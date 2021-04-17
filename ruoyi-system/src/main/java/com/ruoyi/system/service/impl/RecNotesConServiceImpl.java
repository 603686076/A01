package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RecNotesConMapper;
import com.ruoyi.system.domain.RecNotesCon;
import com.ruoyi.system.service.IRecNotesConService;
import com.ruoyi.common.core.text.Convert;

/**
 * 笔记信息Service业务层处理
 * 
 * @author xu
 * @date 2021-04-02
 */
@Service
public class RecNotesConServiceImpl implements IRecNotesConService 
{
    @Autowired
    private RecNotesConMapper recNotesConMapper;

    /**
     * 查询笔记信息
     * 
     * @param notesId 笔记信息ID
     * @return 笔记信息
     */
    @Override
    public RecNotesCon selectRecNotesConById(Long notesId)
    {
        return recNotesConMapper.selectRecNotesConById(notesId);
    }

    /**
     * 查询笔记信息列表
     * 
     * @param recNotesCon 笔记信息
     * @return 笔记信息
     */
    @Override
    public List<RecNotesCon> selectRecNotesConList(RecNotesCon recNotesCon)
    {
        return recNotesConMapper.selectRecNotesConList(recNotesCon);
    }

    /**
     * 新增笔记信息
     * 
     * @param recNotesCon 笔记信息
     * @return 结果
     */
    @Override
    public int insertRecNotesCon(RecNotesCon recNotesCon)
    {
        recNotesCon.setCreateTime(DateUtils.getNowDate());
        return recNotesConMapper.insertRecNotesCon(recNotesCon);
    }

    /**
     * 修改笔记信息
     * 
     * @param recNotesCon 笔记信息
     * @return 结果
     */
    @Override
    public int updateRecNotesCon(RecNotesCon recNotesCon)
    {
        recNotesCon.setUpdateTime(DateUtils.getNowDate());
        return recNotesConMapper.updateRecNotesCon(recNotesCon);
    }

    /**
     * 删除笔记信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRecNotesConByIds(String ids)
    {
        return recNotesConMapper.deleteRecNotesConByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除笔记信息信息
     * 
     * @param notesId 笔记信息ID
     * @return 结果
     */
    @Override
    public int deleteRecNotesConById(Long notesId)
    {
        return recNotesConMapper.deleteRecNotesConById(notesId);
    }
}
