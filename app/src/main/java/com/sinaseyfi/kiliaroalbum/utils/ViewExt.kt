@file:Suppress("ControlFlowWithEmptyBody")

package com.sinaseyfi.kiliaroalbum.utils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.setVisibility(visible: Boolean) {
    if (visible) show() else hide()
}

val View.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(this.context)

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
): Target<*>? {
    this?.let { iv ->
        if(url != null) {
            try {
                val glideUrl =
                    if(width == 0 || height == 0 || !thumbnail) GlideUrl("$url")
                    else GlideUrl("$url?w=${width}&h=${height}&m=${resizeMode.id}")
                return Glide.with(iv.context).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).load(glideUrl).into(
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
                // This is for when we want to do something with error placeholder
                return null
            }
        } else {
            // If the url is null, do something else.
            return null
        }
    } ?: return null
}