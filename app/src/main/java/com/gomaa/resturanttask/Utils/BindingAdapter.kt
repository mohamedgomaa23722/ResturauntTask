package com.gomaa.resturanttask.Utils

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gomaa.resturanttask.R
import com.gomaa.resturanttask.Utils.Constants.BASE_IMAGE_URL
import com.gomaa.resturanttask.ui.Adapter.ItemsAdapter

/**
 * This fun used to build up any recycler view with it's adapter with
 * submit different type of data
 */
@BindingAdapter("listData")
fun bindingRecyclerView(recyclerView: RecyclerView, data: List<Any>?) {
    val adapter = recyclerView.adapter as ItemsAdapter<Any>
    adapter.submitList(data)
}

/**
 * This fun to control on the visibility of Loading view depending on
 * the result of the api if it was success, not pass or loading
 */
@BindingAdapter("ProgressStatue")
fun HandleProgresDataStatue(view: View, apiResult: ApiResult<Nothing>) {
    if (apiResult == ApiResult.Success) {
        view.visibility = View.GONE
    } else if (apiResult == ApiResult.Loading) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
        Toast.makeText(
            view.context,
            "error has been happened so check you internet connection",
            Toast.LENGTH_LONG
        ).show()
    }
}

/**
 * This function control on the visibility of the parent view which contains
 * our data if it pass also it depend on api result
 */
@BindingAdapter("viewVisible")
fun HandleViewVisible(view: ConstraintLayout, apiResult: ApiResult<Nothing>) {
    if (apiResult == ApiResult.Success) {
        view.visibility = View.VISIBLE
    }
}

/**
 * This function for loading image via Glide NOTE : we don't use picasso because
 * glide is better than picasso in caching and we find some problem in using
 * picasso lib.
 */
@SuppressLint("CheckResult")
@BindingAdapter("loadImage")
fun LoadImage(image: ImageView, url: String?) {
    if (url != null) {
            Glide.with(image.context).load(BASE_IMAGE_URL + url)
                .placeholder(R.drawable.loading_animation)
                .into(image)
    }

}

/**
 * This function convert the Boolean value to String or to real description
 * so we notify that the backend response set "ISOPEN" as String not boolean
 * so we received it as String.
 */
@BindingAdapter("RestaurantStatue")
fun convertBooleanValueToString(textView: TextView?, isOpen: String?) {
    if (isOpen == "false") {
        textView?.text = textView?.context?.getString(R.string.closed)
    } else {
        textView?.text = textView?.context?.getString(R.string.open)
    }
}



