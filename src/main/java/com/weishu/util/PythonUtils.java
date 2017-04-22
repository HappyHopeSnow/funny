package com.weishu.util;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/19 上午7:41
 */
public class PythonUtils {

    /**
     * 执行python脚本
     * @param pythonPath
     * @param params
     * @return
     */
    public List<String> pythonShell(String pythonPath, String[] params) {
        File file = new File(pythonPath);
        if (!file.exists()){
            System.out.println("python脚本不存在!");
            return new ArrayList<>();
        }

        String[] command = Arrays.copyOf(new String[]{"python", pythonPath}, params.length + 2);
        System.arraycopy(params, 0, command, 2, params.length);

        List<String> res = new ArrayList<>();
        try {
            Process process = Runtime.getRuntime().exec(command, null, null);

            ClearThread ct = new ClearThread(process);
            ct.start();

            process.waitFor();
            Thread.sleep(1000);

            ct.setEnd(true);
            res = ct.getRes();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return res;
    }

    class ClearThread extends Thread {
        Process process;
        boolean end;
        List<String> res;

        public ClearThread(Process process) {
            this.process = process;
            end = false;
            res = new ArrayList<>();
        }

        @Override
        public void run() {
            if (process == null) {
                return;
            }

            Scanner scanner = new Scanner(process.getInputStream());
            while (process != null && !end) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    res.add(line);
                }
            }
        }

        public void setEnd(boolean end) {
            this.end = end;
        }

        public List<String> getRes() {
            return res;
        }
    }

    public static void main(String[] args) {
        //python classify_image.py --image_file /Users/lianle/Downloads/cat.jpg
        String pythonPath = "/Users/lianle/PycharmProjects/models/tutorials/image/imagenet/classify_image.py";

//        String photoPath = "/Users/lianle/Downloads/apples.jpeg";
        String photoPath = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1492853305&di=30640847a9b59405d413d962ce53b203&src=http://pic118.nipic.com/file/20161224/17961491_145458373000_2.jpg";
        if (photoPath.startsWith("http://") || photoPath.startsWith("https://")) {
            System.out.println("from internet photo,start download image...");
            photoPath = downloadNetImg(photoPath);
            System.out.println("after down load image, photo path = " + photoPath);
        }

        String pam = "--image_file";
        String[] param = {pam, photoPath};

        PythonUtils pythonUtils = new PythonUtils();
        List<String> stringList = pythonUtils.pythonShell(pythonPath, param);

        List<String> afterTransData = new ArrayList<>(stringList.size());

        for (String s : stringList) {
            afterTransData.add(splitEnglish(s));
        }

        for (String afterTransDatum : afterTransData) {
            System.out.println(afterTransDatum);
        }
    }

    /**
     * 执行python代码，从网络下载图片
     * @param url 网络图片地址
     * @return
     */
    private static String downloadNetImg(String url) {
        String pythonShellPath = "/Users/lianle/PycharmProjects/models/tutorials/image/imagenet/downloadImg.py";
        String[] param = {url};

        PythonUtils pythonUtils = new PythonUtils();
        List<String> stringList = pythonUtils.pythonShell(pythonShellPath, param);
        if (stringList != null && stringList.size() > 0) {
            return stringList.get(1);
        }
        return "";
    }

    /**
     * 将结果集切割
     * @param data
     * @return
     */
    private static String splitEnglish(String data) {

        String[] splitData = data.split("\\(");
        String chinese = TransUtils.en2zh(splitData[0]);
        return chinese + "(" + splitData[1];
    }

}
