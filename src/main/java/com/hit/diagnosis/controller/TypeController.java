package com.hit.diagnosis.controller;


import com.hit.diagnosis.common.Result;
import com.hit.diagnosis.service.ExpTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exp/type")
@RequiredArgsConstructor
public class TypeController {
    final private ExpTypeService service;

    @GetMapping
    public Result selectAll(){
        return Result.success(service.list());
    }

}
