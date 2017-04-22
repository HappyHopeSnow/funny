package com.weishu.main.service.impl;

import com.weishu.main.entity.Application;
import com.weishu.main.entity.Devpackage;
import com.weishu.main.model.DownloadModel;
import com.weishu.main.service.DownloadService;
import com.weishu.util.DownloadURLUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by lianle on 15-5-20.
 */
@Service
public class DownloadServiceImpl implements DownloadService {

    @Override
    public DownloadModel getDownloadModel(Application application, String version, String channelName) {
        if(null == application) {
            return null;
        }

        DownloadModel downloadModel = new DownloadModel(application);
        String iphoneName = "";
        String androidName = "";
        Devpackage iphoneDevPackage = null;
        Devpackage androidDevPackage = null;

        if(iphoneDevPackage!=null) iphoneName = iphoneDevPackage.getName();
        if(androidDevPackage!=null) androidName = androidDevPackage.getName();

        if(!StringUtils.isEmpty(iphoneName)) {
            downloadModel.setIphoneUrl(DownloadURLUtil.getEscapeURL(iphoneName));
            downloadModel.setIphoneTdc(DownloadURLUtil.getEscapeImgURL(iphoneName, 125, "jpg"));
            downloadModel.setIphoneIpaUrl(DownloadURLUtil.getURL(iphoneName, "ipa"));
            downloadModel.setIphoneVersion(iphoneName);

        }

        if(!StringUtils.isEmpty(androidName)) {
            downloadModel.setAndroidUrl(DownloadURLUtil.getURL(androidName, "apk"));
            downloadModel.setAndroidTdc(DownloadURLUtil.getImgURL(androidName, 125, "jpg"));
            downloadModel.setAndroidVersion(androidName);
        }

        return downloadModel;
    }

    @Override
    public DownloadModel getDownloadModel(Long appId, String version, String channelName) {
//        Application application = applicationService.get(appId);
        Application application = new Application();
        application.setId(1l);
        return getDownloadModel(application, version, channelName);
    }

}
