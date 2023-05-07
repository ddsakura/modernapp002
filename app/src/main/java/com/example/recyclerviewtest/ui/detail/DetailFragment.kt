package com.example.recyclerviewtest.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewtest.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTitle
        val textDescription: TextView = binding.textDescription
        detailViewModel.gitItem.observe(viewLifecycleOwner) {
            textView.text = it.name
            textDescription.text = it.description
        }

        // if we get param in fragment: https://www.kodeco.com/19327407-using-safe-args-with-the-android-navigation-component#toc-anchor-004
        // val args = DetailFragmentArgs.fromBundle(requireArguments())

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}