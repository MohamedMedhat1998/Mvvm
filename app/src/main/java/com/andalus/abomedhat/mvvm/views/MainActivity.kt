package com.andalus.abomedhat.mvvm.views

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.andalus.abomedhat.mvvm.R
import com.andalus.abomedhat.mvvm.adapters.UsersAdapter
import com.andalus.abomedhat.mvvm.data.AppDatabase
import com.andalus.abomedhat.mvvm.models.User
import com.andalus.abomedhat.mvvm.repositories.UsersRepository
import com.andalus.abomedhat.mvvm.viewmodels.MainActivityViewModel
import com.andalus.abomedhat.mvvm.viewmodels.MainActivityViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    lateinit var adapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dao = AppDatabase.getInstance(this).getUsersDaoDao()
        viewModel = ViewModelProviders.of(this, MainActivityViewModelFactory(UsersRepository(dao)))
            .get(MainActivityViewModel::class.java)
        initializeViews()

        viewModel.getUsersList().observe(this, androidx.lifecycle.Observer {
            if (it != null) {
                adapter.data = it as MutableList<User>
                adapter.notifyDataSetChanged()
            }
        })

        viewModel.getIsEmpty().observe(this, androidx.lifecycle.Observer {
            if (it)
                tvIsEmpty.visibility = View.VISIBLE
            else
                tvIsEmpty.visibility = View.INVISIBLE

        })
    }

    private fun initializeViews() {
        adapter = UsersAdapter()
        rvUsers.adapter = adapter
        rvUsers.layoutManager = LinearLayoutManager(this)
        rvUsers.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        fab.setOnClickListener {
            viewModel.onFabClicked()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.option_clear -> viewModel.onClearOptionSelected()
        }
        return super.onOptionsItemSelected(item)
    }

}
