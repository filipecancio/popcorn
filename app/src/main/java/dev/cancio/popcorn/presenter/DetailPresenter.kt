package dev.cancio.popcorn.presenter

import dev.cancio.popcorn.base.BasePresenter
import dev.cancio.popcorn.base.BaseView
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val view: View
) : BasePresenter<DetailPresenter.View>(view) {


    interface View : BaseView {

    }
}