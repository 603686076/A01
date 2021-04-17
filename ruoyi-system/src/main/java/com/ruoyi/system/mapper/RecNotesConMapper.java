package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.RecNotesCon;

/**
 * 笔记信息Mapper接口
 * 
 * @author xu
 * @date 2021-04-02
 */
public interface RecNotesConMapper 
{
    /**
     * 查询笔记信息
     * 
     * @param notesId 笔记信息ID
     * @return 笔记信息
     */
    public RecNotesCon selectRecNotesConById(Long notesId);

    /**
     * 查询笔记信息列表
     * 
     * @param recNotesCon 笔记信息
     * @return 笔记信息集合
     */
    public List<RecNotesCon> selectRecNotesConList(RecNotesCon recNotesCon);

    /**
     * 新增笔记信息
     * 
     * @param recNotesCon 笔记信息
     * @return 结果
     */
    public int insertRecNotesCon(RecNotesCon recNotesCon);

    /**
     * 修改笔记信息
     * 
     * @param recNotesCon 笔记信息
     * @return 结果
     */
    public int updateRecNotesCon(RecNotesCon recNotesCon);

    /**
     * 删除笔记信息
     * 
     * @param notesId 笔记信息ID
     * @return 结果
     */
    public int deleteRecNotesConById(Long notesId);

    /**
     * 批量删除笔记信息
     * 
     * @param notesIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRecNotesConByIds(String[] notesIds);
}
