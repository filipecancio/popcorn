package dev.cancio.filmin.presenter

import dev.cancio.filmin.base.BasePresenter
import dev.cancio.filmin.base.BaseView
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val view: View
) : BasePresenter<DetailPresenter.View>(view) {


    interface View : BaseView {

    }
}