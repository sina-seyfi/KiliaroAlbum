package com.sinaseyfi.presentation.ui.utils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewPropertyAnimator
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.transition.Transition

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.setVisibility(visible: Boolean) {
    if (visible) show() else hide()
}

fun View.setInvisibility(invisible: Boolean) {
    if(invisible) invisible() else show()
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}

fun View.isVisible() = visibility == View.VISIBLE

fun View.isInvisible() = visibility == View.INVISIBLE

fun View.isGone() = visibility == View.GONE

val View.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this.context)

fun List<View>.setOnClickListener(action: (View) -> Unit) {
    this.forEach { view -> view.setOnClickListener { action(it) } }
}

fun List<View>.setOnClickListener(listener: View.OnClickListener?) {
    this.forEach { view ->
        view.setOnClickListener(listener)
    }
}

fun List<View?>.setVisibility(visible: Boolean) {
    forEach { view -> view?.setVisibility(visible) }
}

fun List<View?>.setEnabled(enabled: Boolean) {
    forEach { view -> view?.isEnabled = enabled }
}

fun View.getNavigationBarHeight(): Int {
    val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    return if (resourceId > 0) {
        resources.getDimensionPixelSize(resourceId)
    } else 0
}

fun List<View?>.animate(chain: ViewPropertyAnimator.() -> Unit) {
    this.forEach { view -> view?.animate()?.chain() }
}

enum class ResizeMode(val id: String) {
    BOUNDING_BOX("bb"),
    CROP("crop"),
    MINIMUM_DIMENSION("md")
}

fun ImageView?.loadFromUrl(
    url: String?,
    thumbnail: Boolean = true,
    width: Int = this?.measuredWidth ?: 0,
    height: Int = this?.measuredHeight ?: 0,
    resizeMode: ResizeMode = ResizeMode.CROP,
    success: () -> Unit = {},
    error: () -> Unit = {}
) {
    this?.let { iv ->
        if(url != null) {
            try {
                val glideUrl =
                    if(width == 0 || height == 0 || !thumbnail) GlideUrl("$url")
                    else GlideUrl("$url?w=${width}&h=${height}&m=${resizeMode.id}")
                Glide.with(iv.context).asBitmap().load(glideUrl).into(
                    object: BitmapImageViewTarget(iv) {
                        override fun onLoadFailed(errorDrawable: Drawable?) {
                            error.invoke()
                            super.onLoadFailed(errorDrawable)
                        }
                        override fun onResourceReady(
                            resource: Bitmap,
                            transition: Transition<in Bitmap>?
                        ) {
                            success.invoke()
                            super.onResourceReady(resource, transition)
                        }
                    }
                )
            } catch (e: Exception) {

            }
        } else {

        }
    }
}