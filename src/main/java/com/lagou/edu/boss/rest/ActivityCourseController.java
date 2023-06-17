package com.lagou.edu.boss.rest;

import com.alibaba.fastjson.JSON;
import com.lagou.edu.boss.entity.form.ActivityCourseForm;
import com.lagou.edu.common.entity.vo.Result;
import com.lagou.edu.common.response.ResponseDTO;
import com.lagou.edu.common.utils.CoverUtil;
import com.lagou.edu.common.utils.ValidateUtils;
import com.lagou.edu.course.client.dto.ActivityCourseDTO;
import com.lagou.edu.course.client.remote.ActivityCourseRemoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ma wei long
 * @date:   2020年7月6日 下午9:40:04
*/
@Api(tags = "活动课程", produces = "application/json")
@Slf4j
@RestController
@RequestMapping("/activityCourse")
public class ActivityCourseController {

    @Autowired
    private ActivityCourseRemoteService activityCourseRemoteService;
    
    /**
     * @author: ma wei long
     * @date:   2020年7月7日 下午7:42:14   
    */
    @ApiOperation("保存活动商品")
    @PostMapping("/save")
    public Result<?> save(@RequestBody ActivityCourseForm reqVo) {
    	log.info("save - reqVo:{}",JSON.toJSONString(reqVo));
    	ResponseDTO<?> resp = activityCourseRemoteService.saveActivityCourse(CoverUtil.cover(reqVo, ActivityCourseDTO.class));
        log.info("save - activityCourseRemoteService.saveActivityCourse - resp：{}",JSON.toJSONString(resp));
        ValidateUtils.isTrue(resp.isSuccess(), resp.getMessage());
    	return Result.success();
    }
    
    /**
     * @author: ma wei long
     * @date:   2020年7月7日 下午8:59:06   
    */
    @ApiOperation("更新活动商品状态")
    @PostMapping("/updateStatus")
    public Result<?> updateStatus(@RequestBody ActivityCourseForm reqVo) {
    	log.info("updateStatus - reqVo:{}",JSON.toJSONString(reqVo));
    	ResponseDTO<?> resp = activityCourseRemoteService.updateActivityCourseStatus(CoverUtil.cover(reqVo, ActivityCourseDTO.class));
    	log.info("updateStatus - activityCourseRemoteService.updateActivityCourseStatus - resp：{}",JSON.toJSONString(resp));
        ValidateUtils.isTrue(resp.isSuccess(), resp.getMessage());
    	return Result.success();
    }
}
