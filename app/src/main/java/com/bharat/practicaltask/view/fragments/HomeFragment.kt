package com.bharat.practicaltask.view.fragments

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bharat.practicaltask.MyApp
import com.bharat.practicaltask.databinding.FragmentHomeBinding
import com.bharat.practicaltask.view.adapters.CoinAdapter
import com.bharat.practicaltask.viewModel.AppViewModelFactory
import com.bharat.practicaltask.viewModel.MainViewModel
import javax.inject.Inject


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MainViewModel

    internal var viewModelFactory: AppViewModelFactory? = null
        @Inject set
    //private lateinit var viewModelFactory: AppViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApp.getComponent().inject(this)

        //viewModelFactory = AppViewModelFactory(requireActivity().application)
        if(viewModelFactory != null) {
            viewModel = ViewModelProvider(this, viewModelFactory!!).get(MainViewModel::class.java)
                .apply {
                    getCoinList()
                }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.allLabel.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        val adapter = CoinAdapter()
        val layoutManager = GridLayoutManager(activity, 3)

        binding.gridview.layoutManager = layoutManager
        binding.gridview.adapter = adapter

        viewModel.coinResponse.observe(viewLifecycleOwner) {
            it?.let { coinResponseData ->
                binding.progressLoader.visibility = View.GONE
                if(coinResponseData.isSuccessful) {
//                    Log.i("TAG", "onCreateView: ${coinResponseData.body()?.data?.list}")
                    adapter.data = coinResponseData.body()?.data?.list ?: listOf()
                }
            }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}