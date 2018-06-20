package cn.ph.blog.controller;

import cn.ph.blog.core.ret.RetResponse;
import cn.ph.blog.core.ret.RetResult;
import cn.ph.blog.core.utils.UploadActionUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/uploadFile")
public class UploadFileController {

    @PostMapping("/upload")
    public RetResult<List<String>> upload(HttpServletRequest httpServletRequest) throws Exception {
        List<String> list = UploadActionUtil.uploadFile(httpServletRequest);
        return RetResponse.makeOKRsp(list);
    }
}
