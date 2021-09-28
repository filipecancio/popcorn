package dev.cancio.popcorn.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.cancio.popcorn.databinding.FragmentNoneBinding

class NoneFragment : Fragment() {

    private val binding: FragmentNoneBinding by lazy {
        FragmentNoneBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}