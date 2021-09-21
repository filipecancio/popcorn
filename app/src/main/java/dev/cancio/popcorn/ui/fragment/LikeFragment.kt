package dev.cancio.popcorn.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.cancio.popcorn.base.BaseFragment
import dev.cancio.popcorn.databinding.FragmentLikeBinding
import dev.cancio.popcorn.presenter.LikePresenter

class LikeFragment : BaseFragment(), LikePresenter.View {

    override val binding: FragmentLikeBinding by lazy {
        FragmentLikeBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindViews()
        return binding.root
    }

    override fun bindViews() {

    }
}