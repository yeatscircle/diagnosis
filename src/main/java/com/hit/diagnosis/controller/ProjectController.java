package com.hit.diagnosis.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hit.diagnosis.common.Result;
import com.hit.diagnosis.domain.TDiagnosisProject;
import com.hit.diagnosis.service.TDiagnosisProjectService;
import com.pig4cloud.plugin.excel.annotation.RequestExcel;
import com.pig4cloud.plugin.excel.annotation.ResponseExcel;
import com.pig4cloud.plugin.excel.annotation.Sheet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
@Slf4j
public class ProjectController {
    final private TDiagnosisProjectService service;

    // 条件查询
    @GetMapping("/all")
    public Result selectAll(String DiaId, String DiaName, Short DiaExpType,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                            @RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer pageSize) throws Exception{
        log.info("DiaId={},DiaName={},DiaExpType={},page={},pageSize={},begin={},end={}", DiaId, DiaName, DiaExpType, page, pageSize, begin, end);
        // 分页构造器
        Page<TDiagnosisProject> pageInfo = new Page<>(page, pageSize);

        //条件构造器
        LambdaQueryWrapper<TDiagnosisProject> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加条件
        lambdaQueryWrapper.like(!StrUtil.isBlank(DiaName), TDiagnosisProject::getDiaName, DiaName);
        lambdaQueryWrapper.eq(!StrUtil.isBlank(DiaId), TDiagnosisProject::getDiaId, DiaId);
        lambdaQueryWrapper.eq(!Objects.isNull(DiaExpType), TDiagnosisProject::getDiaExpType, DiaExpType);
        lambdaQueryWrapper.between(!Objects.isNull(begin) && !Objects.isNull(end), TDiagnosisProject::getCreatetime, begin, end);

        try {
            //执行操作
            service.page(pageInfo, lambdaQueryWrapper);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return Result.success(pageInfo);
    }

    // 根据id回显
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Long id) throws Exception{
        try {
            return Result.success(service.getById(id));
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    // 批量删除
    @DeleteMapping("/{ids}")
    public Result deletePro(@PathVariable List<Long> ids) throws Exception{
        try {
            service.removeByIds(ids);
            return Result.success();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    // 新增项目
    @PostMapping
    public Result addPro(@RequestBody TDiagnosisProject project) throws Exception{
        try {
            service.save(project);
        } catch (Exception e){
            log.error("Error saving project: {}", project, e);
            throw new Exception(e.getMessage());
        }
        return Result.success();
    }

    // 修改项目
    @PutMapping
    public Result updatePro(@RequestBody TDiagnosisProject project) throws Exception{
        TDiagnosisProject before = service.getById(project.getId());
        if (before.equals(project))
            return Result.error("未做修改");
        else {
            try {
                service.updateById(project);
            } catch (Exception e){
                log.error("Error saving project: {}", project, e);
                throw new Exception(e.getMessage());
            }
            return Result.success();
        }

    }

    @DeleteMapping("/single/{id}")
    public Result deleteById(@PathVariable Long id) throws Exception{
        try {
            service.removeById(id);
            return Result.success();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @ResponseExcel(name = "Excel", sheets = @Sheet(sheetName = "Excel"))
    @GetMapping("/downloadExcel")
    public List<TDiagnosisProject> downloadExcel() {
        return service.list();
    }
}
