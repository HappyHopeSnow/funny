package com.weishu.main.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.constant.ApplicationConstants;
import com.weishu.main.model.DownloadModel;
import com.weishu.main.service.DownloadService;
import com.weishu.web.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;


@Controller
@RequestMapping("/")
public class MainController {

	@Resource(name = "masterDataSource")
	private DruidDataSource masterDataSource;

	@Resource(name="slaveDataSource")
	private DruidDataSource slaveDataSource;

	@Resource
	private DownloadService downloadService;

	@Autowired
	private FileService fileService;


	@RequestMapping(value="")
	public String index(
			@RequestParam(required=false, value="v", defaultValue="") String version,
			@RequestParam(required=false, value="c", defaultValue="") String channelName,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) {

//		UserAgent userAgent = new UserAgent(request);

		DownloadModel downloadModel = downloadService.getDownloadModel(ApplicationConstants.WEI_SHU_FUNNY, version, channelName);

		model.addAttribute("downloadModel", downloadModel);
		model.addAttribute("url", "http://static.starft.cn/mt156");
		return "web/index";

	}

	@ResponseBody
	@RequestMapping(value="/hello")
	public Object hello(
			@RequestParam(required=false, value="s", defaultValue="tomcat") String serverName,
			HttpServletRequest request,
			HttpServletResponse response,
			Model model) {

		String result = "";
		result += getDataSourceString(masterDataSource, "master", true, serverName) + "\n";
		result += getDataSourceString(slaveDataSource, "slave", false, serverName) + "\n";
		return result;
	}

	private String getDataSourceString(DruidDataSource dataSource) {
		Map<String, Object> map = getDataSource(dataSource);
		StringBuilder builder = new StringBuilder();
		for(String key : map.keySet()) {
			builder.append(key).append("(").append(map.get(key)).append(")").append(" ");
		}
		return builder.toString();
	}

	private String getDataSourceString(DruidDataSource dataSource, String name, boolean head, String serverName) {
		Map<String, Object> map = getDataSource(dataSource);
		StringBuilder builder = new StringBuilder();
		if(head) {
			builder.append(String.format("%-20s", "=== [ "+serverName+" ] ==="));
			for(String key : map.keySet()) {
				builder.append(String.format("%15s", ""+key+""));
			}
			builder.append("\n");
		}
		builder.append(String.format("%-20s", name));
		for(String key : map.keySet()) {
			builder.append(String.format("%15s", map.get(key)));
		}
		return builder.toString();
	}

	private Map<String, Object> getDataSource(DruidDataSource dataSource) {
		Map<String, Object> mapModel = new LinkedHashMap<String, Object>();
		try {
			mapModel.put("init/Min/Max", dataSource.getInitialSize() + "/" + dataSource.getMinIdle() + "/" + dataSource.getMaxActive());
			mapModel.put("connectCount", dataSource.getConnectCount());
			mapModel.put("activeCount", dataSource.getActiveCount());
			mapModel.put("createCount", dataSource.getCreateCount());
			mapModel.put("errorCount", dataSource.getConnectErrorCount());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapModel;
	}


	/**
	 * 文件上传
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "admin/imgUpload", method = RequestMethod.POST)
	@ResponseBody
	public UnifiedResponse imgUpload(MultipartFile file) {

		long pid = fileService.upload(file);
		UnifiedResponse unifiedResponse = new UnifiedResponse();
		unifiedResponse.setData(pid);
		unifiedResponse.setMessage("保存成功");
		unifiedResponse.setStatus(ResultCodeEnum.SUCCESS.getCode());
		return unifiedResponse;

	}

}
