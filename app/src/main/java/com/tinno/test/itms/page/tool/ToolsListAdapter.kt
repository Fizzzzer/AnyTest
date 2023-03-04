package com.tinno.test.itms.page.tool

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.tinno.test.itms.R
import com.tinno.test.itms.model.ToolsModel

class ToolsListAdapter: BaseQuickAdapter<ToolsModel, BaseViewHolder>(R.layout.item_tools_layout) {
    override fun convert(holder: BaseViewHolder, item: ToolsModel) {
        holder.setText(R.id.appName,item.appName)
    }
}