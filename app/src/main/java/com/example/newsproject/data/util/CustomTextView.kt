package com.example.newsproject.data.util

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.newsproject.R
import java.lang.Exception

/**
 * @author Shashi
 * Date : 18/05/2022
 * Desc : A generic TextView that will be used across the application, all the text views must used in the
 *        application must be YouuTextView
 */

class CustomTextView: AppCompatTextView {
    constructor(context: Context?) : super(context!!) {
        if (isInEditMode) return
        parseAttributes(null)
    }


    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {
        if (isInEditMode) return
        parseAttributes(attrs)
    }

    override fun setTextColor(color: Int) {
        super.setTextColor(color)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context!!, attrs, defStyle
    ) {
        if (isInEditMode) return
        parseAttributes(attrs)
    }

    private fun parseAttributes(attrs: AttributeSet?) {
        val typeface: Int
        try {
            if (attrs == null) { //Not created from xml
                typeface = Custom.Custom_REGULAR
            } else {
                val values = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
                typeface = values.getInt(R.styleable.CustomTextView_typeface, Custom.Custom_REGULAR)
                values.recycle()
            }
            setTypeface(getCustom(typeface))
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    fun setCustomTypeface(typeface: Int) {
        setTypeface(getCustom(typeface))
    }

    private fun getCustom(typeface: Int): Typeface? {
        return getCustom(context, typeface)
    }

    object Custom {

        const val Custom_BLACK = 0
        const val Custom_BLACK_ITALIC = 1
        const val Custom_BOLD = 2
        const val Custom_BOLD_ITALIC = 3
        const val Custom_BOLD_CONDENSED = 4
        const val Custom_ITALIC = 8
        const val Custom_LIGHT = 9
        const val Custom_LIGHT_ITALIC = 10
        const val Custom_MEDIUM = 11
        const val Custom_MEDIUM_ITALIC = 12
        const val Custom_REGULAR = 13
        const val Custom_THIN = 14
        const val Custom_THIN_ITALIC = 15
        var sCustomBlack: Typeface? = null
        var sCustomBlackItalic: Typeface? = null
        var sCustomBold: Typeface? = null
        var sCustomBoldItalic: Typeface? = null
        var sCustomBoldCondensed: Typeface? = null
        var sCustomItalic: Typeface? = null
        var sCustomLight: Typeface? = null
        var sCustomLightItalic: Typeface? = null
        var sCustomMedium: Typeface? = null
        var sCustomMediumItalic: Typeface? = null
        var sCustomRegular: Typeface? = null
        var sCustomThin: Typeface? = null
        var sCustomThinItalic: Typeface? = null
    }

    companion object {
        fun getCustom(context: Context, typeface: Int): Typeface? {
            return when (typeface) {
                Custom.Custom_BLACK -> {
                    if (Custom.sCustomBlack == null) {
                        Custom.sCustomBlack =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-Black.ttf"
                            )
                    }
                    Custom.sCustomBlack
                }
                Custom.Custom_BLACK_ITALIC -> {
                    if (Custom.sCustomBlackItalic == null) {
                        Custom.sCustomBlackItalic =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-BlackItalic.ttf"
                            )
                    }
                    Custom.sCustomBlackItalic
                }
                Custom.Custom_BOLD -> {
                    if (Custom.sCustomBold == null) {
                        Custom.sCustomBold =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-Bold.ttf"
                            )
                    }
                    Custom.sCustomBold
                }
                Custom.Custom_BOLD_CONDENSED -> {
                    if (Custom.sCustomBoldCondensed == null) {
                        Custom.sCustomBoldCondensed =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-ExtraBold.ttf"
                            )
                    }
                    Custom.sCustomBoldCondensed
                }

                Custom.Custom_BOLD_ITALIC -> {
                    if (Custom.sCustomBoldItalic == null) {
                        Custom.sCustomBoldItalic =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-BoldItalic.ttf"
                            )
                    }
                    Custom.sCustomBoldItalic
                }
                Custom.Custom_ITALIC -> {
                    if (Custom.sCustomItalic == null) {
                        Custom.sCustomItalic =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-Italic.ttf"
                            )
                    }
                    Custom.sCustomItalic
                }
                Custom.Custom_LIGHT -> {
                    if (Custom.sCustomLight == null) {
                        Custom.sCustomLight =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-Light.ttf"
                            )
                    }
                    Custom.sCustomLight
                }
                Custom.Custom_LIGHT_ITALIC -> {
                    if (Custom.sCustomLightItalic == null) {
                        Custom.sCustomLightItalic =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-LightItalic.ttf"
                            )
                    }
                    Custom.sCustomLightItalic
                }
                Custom.Custom_MEDIUM -> {
                    if (Custom.sCustomMedium == null) {
                        Custom.sCustomMedium =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-Medium.ttf"
                            )
                    }
                    Custom.sCustomMedium
                }
                Custom.Custom_MEDIUM_ITALIC -> {
                    if (Custom.sCustomMediumItalic == null) {
                        Custom.sCustomMediumItalic =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-MediumItalic.ttf"
                            )
                    }
                    Custom.sCustomMediumItalic
                }
                Custom.Custom_REGULAR -> {
                    if (Custom.sCustomRegular == null) {
                        Custom.sCustomRegular =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-Regular.ttf"
                            )
                    }
                    Custom.sCustomRegular
                }
                Custom.Custom_THIN -> {
                    if (Custom.sCustomThin == null) {
                        Custom.sCustomThin =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-Thin.ttf"
                            )
                    }
                    Custom.sCustomThin
                }
                Custom.Custom_THIN_ITALIC -> {
                    if (Custom.sCustomThinItalic == null) {
                        Custom.sCustomThinItalic =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-ThinItalic.ttf"
                            )
                    }
                    Custom.sCustomThinItalic
                }
                else -> {
                    if (Custom.sCustomRegular == null) {
                        Custom.sCustomRegular =
                            Typeface.createFromAsset(
                                context.assets, "fonts/LibreFranklin-Regular.ttf"
                            )
                    }
                    Custom.sCustomRegular
                }
            }
        }
    }
}