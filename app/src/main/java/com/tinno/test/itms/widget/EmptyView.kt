package com.tinno.test.itms.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.tinno.test.itms.R

class EmptyView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private var mEmptyIconView: AppCompatImageView
    private var mEmptyTipView: AppCompatTextView

    init {
        View.inflate(context, R.layout.widget_empty_view, this)
        mEmptyIconView = findViewById(R.id.emptyIcon)
        mEmptyTipView = findViewById(R.id.emptyTip)
    }

    /**
     * 错误提示
     */
    var mEmptyTip: String = ""
        set(value) {
            field = value
            mEmptyTipView.text = value
        }
        get() = mEmptyTipView.text.toString()
}