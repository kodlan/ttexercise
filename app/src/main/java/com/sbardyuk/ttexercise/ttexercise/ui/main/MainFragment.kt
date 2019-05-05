package com.sbardyuk.ttexercise.ttexercise.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sbardyuk.ttexercise.ttexercise.R
import com.sbardyuk.ttexercise.ttexercise.data.User
import com.sbardyuk.ttexercise.ttexercise.databinding.MainFragmentBinding

class MainFragment : Fragment(), UserRecyclerAdapter.OnItemClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val userRecyclerAdapter = UserRecyclerAdapter(arrayListOf(), this)
    private lateinit var viewModel: MainViewModel
    lateinit var binding: MainFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.listItems.layoutManager = LinearLayoutManager(context)
        binding.listItems.adapter = userRecyclerAdapter
        viewModel.listLiveData.observe(this, Observer<ArrayList<User>> { itt -> itt?.let{ userRecyclerAdapter.replaceData(it)} })

        return binding.root
    }

    override fun onItemClick(position: Int) {
        TODO("not implemented")
    }
}
