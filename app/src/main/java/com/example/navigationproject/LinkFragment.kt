package com.example.navigationproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationproject.ApiInterface
import com.example.navigationproject.R
import com.example.navigationproject.UserAdapter
import com.example.navigationproject.UsersItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LinkFragment : Fragment() {

    lateinit var rvMain: RecyclerView
    lateinit var myAdapter: UserAdapter

    var URL = "https://api.github.com"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_link, container, false)
        val button = view.findViewById<Button>(R.id.backButton)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_linkFragment_to_newsFragment)
        }
        rvMain = view.findViewById(R.id.recycler_view_link)
        rvMain.layoutManager = LinearLayoutManager(activity)
        getAllData()

        return view
    }

    private fun getAllData() {
        var retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var retroData = retrofit.getData()

        retroData.enqueue(object : Callback<List<UsersItem>> {
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                var data = response.body()!!
                myAdapter = UserAdapter(requireContext(), data)
                rvMain.adapter = myAdapter
                Log.d("data", data.toString())
            }

            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
