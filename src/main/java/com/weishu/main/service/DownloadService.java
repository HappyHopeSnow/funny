package com.weishu.main.service;


import com.weishu.main.entity.Application;
import com.weishu.main.model.DownloadModel;

/**
 * Created by lianle on 15-5-20.
 */
public interface DownloadService {

    DownloadModel getDownloadModel(Long appId, String version, String channelName);

    DownloadModel getDownloadModel(Application application, String version, String channelName);

}
