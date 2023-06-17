package com.lagou.edu.boss.controller;

import com.lagou.edu.ad.client.dto.PromotionAdDTO;
import com.lagou.edu.ad.client.dto.PromotionSpaceDTO;
import com.lagou.edu.ad.client.remote.AdRemoteService;
import com.lagou.edu.common.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AdController
 *
 * @author xianhongle
 * @data 2022/1/9 7:40 下午
 **/
@RestController
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private AdRemoteService adRemoteService;

    @GetMapping("/space/getAllSpaces")
    public ResponseDTO<List<PromotionSpaceDTO>> getAllSpaces() {
        return ResponseDTO.success(adRemoteService.getAllSpaces());
    }

    @GetMapping("/getAdBySpaceKey")
    public ResponseDTO<List<PromotionSpaceDTO>> getAdBySpaceKey(@RequestParam("spaceKey") String[] spaceKey) {
        return ResponseDTO.success(adRemoteService.getAdBySpaceKey(spaceKey));
    }

    @PostMapping("/space/saveOrUpdateSpace")
    public ResponseDTO saveOrUpdateSpace(@RequestBody PromotionSpaceDTO spaceDTO){
        return adRemoteService.saveOrUpdateSpace(spaceDTO);
    }

    @GetMapping("/space/getSpaceById")
    public ResponseDTO<PromotionSpaceDTO> getSpaceById(@RequestParam("id") Integer id){
        PromotionSpaceDTO rs = adRemoteService.getSpaceById(id);
        return ResponseDTO.success(rs);
    }

    @GetMapping("/getAllAds")
    public ResponseDTO<List<PromotionAdDTO>> getAllAds(){
        List<PromotionAdDTO> rs = adRemoteService.getAllAds();
        return ResponseDTO.success(rs);
    }

    @PostMapping("/saveOrUpdateAd")
    public ResponseDTO saveOrUpdateAd(@RequestBody PromotionAdDTO promotionAdDTO){
        ResponseDTO rs = adRemoteService.saveOrUpdateAd(promotionAdDTO);
        return rs;
    }

    @GetMapping("/getAdById")
    public ResponseDTO<PromotionAdDTO> getAdById(@RequestParam("id") Integer id){
        ResponseDTO<PromotionAdDTO> rs = adRemoteService.getAdById(id);
        return rs;
    }

    @RequestMapping("/updateStatus")
    ResponseDTO updateStatus(@RequestParam("id") Integer id,
                             @RequestParam("status") Integer status){
        return adRemoteService.updateStatus(id,status);
    }

}
