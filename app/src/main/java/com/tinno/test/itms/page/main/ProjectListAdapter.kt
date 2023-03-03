package com.tinno.test.itms.page.main

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.tinno.test.itms.R
import com.tinno.test.itms.model.ProjectModel

class ProjectListAdapter :
    BaseQuickAdapter<ProjectModel, BaseViewHolder>(R.layout.item_project_home_list_layout) {
    override fun convert(holder: BaseViewHolder, item: ProjectModel) {
        holder.setText(R.id.createName, item.createmanName)
        holder.setText(R.id.projectName, item.project)
        holder.setText(R.id.startTime, "开始时间${item.startTime}")
        holder.setText(R.id.endTime, "结束时间${item.endTime}")
        holder.setText(R.id.taskName, item.name)
        holder.setText(R.id.taskPlan, item.taskType)
        holder.setText(R.id.taskDesc, item.taskPreparation)

    }
}