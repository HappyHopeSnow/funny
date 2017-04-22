package com.weishu.web.file.service.impl;

import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.exception.ImgException;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.constant.DeleteEnum;
import com.weishu.util.OSSClientUtil;
import com.weishu.web.file.dao.FileMapper;
import com.weishu.web.file.entity.File;
import com.weishu.web.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/9 下午10:25
 */
@Service
public class FileServiceImpl implements FileService {

    @Resource
    private OSSClientUtil ossClientUtil;

    @Autowired
    private FileMapper fileMapper;

    @Override
    @Transactional
    public long upload(MultipartFile file) {

        if (file == null || file.getSize() <= 0) {
            throw new ImgException("头像不能为空");
        }

        File dbFile = new File();
        Date now = new Date();
        String originName = file.getOriginalFilename();
        String suffix = originName.substring(originName.lastIndexOf(".")+1);
        dbFile.setFileName(originName);
        dbFile.setSize((int) file.getSize());
        dbFile.setSuffix(suffix);
        dbFile.setCreateTime(now);
        dbFile.setUpdateTime(now);
        dbFile.setIsDelete(DeleteEnum.NOT_DELETE.getCode());
        fileMapper.insert(dbFile);
        ossClientUtil.uploadImg2Oss(file, String.valueOf(dbFile.getId()), suffix);

        return dbFile.getId();
    }

}
