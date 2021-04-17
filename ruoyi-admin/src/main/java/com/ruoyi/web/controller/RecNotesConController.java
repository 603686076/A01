package com.ruoyi.web.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.RecNotesCon;
import com.ruoyi.system.service.IRecNotesConService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 笔记信息Controller
 * 
 * @author xu
 * @date 2021-04-02
 */
@Controller
@RequestMapping("/system/crnotes")
public class RecNotesConController extends BaseController
{
    private String prefix = "system/crnotes";

    @Autowired
    private IRecNotesConService recNotesConService;

    @RequiresPermissions("system:crnotes:view")
    @GetMapping()
    public String crnotes()
    {
        return prefix + "/crnotes";
    }

    /**
     * 查询笔记信息列表
     */
    @RequiresPermissions("system:crnotes:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RecNotesCon recNotesCon)
    {
        startPage();
        SysUser user = ShiroUtils.getSysUser();
        List<RecNotesCon> list = recNotesConService.selectRecNotesConList(recNotesCon);//从数据库获得数据
        //如果是管理员， 进入
        if (user.getUserId() == 1) {

        }

        //如果是HR， 进入
        if (user.getUserId() == 103 || user.getUserId() == 104 || user.getUserId() == 105) {

        }

        //员工
        if (user.getUserId() == 106 || user.getUserId() == 107 ||user.getUserId() == 108 || user.getUserId() == 109 || user.getUserId() == 110) {
            recNotesCon.setUserId((long)user.getUserId());//通过ID获取笔记
            //实现了当四个监管者都同意员工页面才显示的功能
            List<RecNotesCon> list1 = new ArrayList<>();
            for (RecNotesCon r : list) {
                if (r.getR1_flag() == 1 && r.getR2_flag() == 1 && r.getR3_flag() == 1 && r.getR4_flag() == 1) {
                    list1.add(r);
                }
            }
            return getDataTable(list1);
        }

        //监管者
        if (user.getUserId() == 101 || user.getUserId() == 102 || user.getUserId() == 113 || user.getUserId() == 114) {
            List<RecNotesCon> list2 = new ArrayList<>();
            if (user.getUserId() == 101) {
                for (RecNotesCon r : list) {
                    if (r.getR1_flag() == 1) {

                    }else {
                        list2.add(r);
                    }
                }
            }
            if (user.getUserId() == 102) {
                for (RecNotesCon r : list) {
                    if (r.getR2_flag() == 1) {

                    }else {
                        list2.add(r);
                    }
                }
            }
            if (user.getUserId() == 113) {
                for (RecNotesCon r : list) {
                    if (r.getR3_flag() == 1) {

                    }else {
                        list2.add(r);
                    }
                }
            }
            if (user.getUserId() == 114) {
                for (RecNotesCon r : list) {
                    if (r.getR4_flag() == 1) {

                    }else {
                        list2.add(r);
                    }
                }
            }
            return getDataTable(list2);
        }

//        //这里应该获取用户角色，如果是员工则执行，
//        if(user.getUserId()!=1||user.getUserId()!=2||user.getUserId()!=101||user.getUserId()!=102){
//
//            recNotesCon.setUserId((long)user.getUserId());//通过ID获取笔记
//            recNotesCon.setR1_flag(1);
//            recNotesCon.setR2_flag(1);
//            recNotesCon.setR3_flag(1);
//            recNotesCon.setR4_flag(1);
//        }
        return getDataTable(list);
    }

    /**
     * 导出笔记信息列表
     */
    @RequiresPermissions("system:crnotes:export")
    @Log(title = "笔记信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RecNotesCon recNotesCon)
    {
        List<RecNotesCon> list = recNotesConService.selectRecNotesConList(recNotesCon);
        ExcelUtil<RecNotesCon> util = new ExcelUtil<RecNotesCon>(RecNotesCon.class);
        return util.exportExcel(list, "crnotes");
    }

    /**
     * 新增笔记信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存笔记信息
     */
    @RequiresPermissions("system:crnotes:add")
    @Log(title = "笔记信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RecNotesCon recNotesCon)
    {
        return toAjax(recNotesConService.insertRecNotesCon(recNotesCon));
    }

    /**
     * 修改笔记信息
     */
    @GetMapping("/edit/{notesId}")
    public String edit(@PathVariable("notesId") Long notesId, ModelMap mmap)
    {
        RecNotesCon recNotesCon = recNotesConService.selectRecNotesConById(notesId);
        mmap.put("recNotesCon", recNotesCon);
        return prefix + "/edit";
    }

    /**
     * 修改保存笔记信息
     */
    @RequiresPermissions("system:crnotes:edit")
    @Log(title = "笔记信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RecNotesCon recNotesCon)
    {
        return toAjax(recNotesConService.updateRecNotesCon(recNotesCon));
    }

    /**
     * 删除笔记信息
     */
    @RequiresPermissions("system:crnotes:remove")
    @Log(title = "笔记信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(recNotesConService.deleteRecNotesConByIds(ids));
    }

    /**
     * 查看笔记信息
     */
    @GetMapping("/detail/{notesId}")
    public String detail(@PathVariable("notesId") Long notesId, ModelMap mmap)
    {
        RecNotesCon recNotesCon = recNotesConService.selectRecNotesConById(notesId);
        mmap.put("recNotesCon", recNotesCon);
        return prefix + "/detail";
    }



    /**
     * 授权笔记信息
     */
    @GetMapping("/authorize/{notesId}")
    public String authorize(@PathVariable("notesId") Long notesId, ModelMap mmap)
    {
        RecNotesCon recNotesCon = recNotesConService.selectRecNotesConById(notesId);
        mmap.put("recNotesCon", recNotesCon);
        return prefix + "/authorize";
    }

    /**
     * 确认授权笔记信息
     */
    @PostMapping("/confirm")
    @ResponseBody
    public AjaxResult authorizeConfirm(RecNotesCon recNotesCon)
    {
        SysUser user = ShiroUtils.getSysUser();
        if (user.getUserId() == 101) {
             recNotesCon.setR1_flag(1);
        }
        if (user.getUserId() == 102) {
            recNotesCon.setR2_flag(1);
        }
        if (user.getUserId() == 113) {
            recNotesCon.setR3_flag(1);
        }
        if (user.getUserId() == 114) {
            recNotesCon.setR4_flag(1);
        }
        return toAjax(recNotesConService.updateRecNotesCon(recNotesCon));
    }
}
