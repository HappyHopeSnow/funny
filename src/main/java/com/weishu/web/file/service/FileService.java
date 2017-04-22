package com.weishu.web.file.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/9 下午10:25
 */
public interface FileService {

    /**
     * 上传文件
     * @param file
     * @return
     */
    long upload(MultipartFile file);
}
