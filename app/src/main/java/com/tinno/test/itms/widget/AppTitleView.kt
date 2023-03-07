package com.tinno.test.itms.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.tinno.test.itms.R

class AppTitleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {


    private var mTitleView: AppCompatTextView
    private var mIconView: AppCompatImageView

    init {
        View.inflate(context, R.layout.widget_app_title_layout, this)
        mTitleView = findViewById(R.id.title)
        mIconView = findViewById(R.id.icon)
    }


    var title: String = ""
        set(value) {
            field = value
            mTitleView.text = value
        }
        get() = mTitleView.text.toString()

    var iconVisible: Boolean = true
        set(value) {
            field = value
            mIconView.visibility = if (value) View.VISIBLE else View.GONE
        }
}