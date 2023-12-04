package com.example.navigationproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewsFragment : Fragment() {
    private lateinit var newRecycleview: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    private lateinit var constraintLayout: ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        val button = view.findViewById<Button>(R.id.btnNext)
        button.setOnClickListener {
            findNavController().navigate(R.id.action_newsFragment_to_linkFragment)
        }
        imageId = arrayOf(
            R.drawable.g,
            R.drawable.f,
            R.drawable.c,
            R.drawable.a,
            R.drawable.e,
            R.drawable.b,
            R.drawable.x,
            R.drawable.z,
            R.drawable.usyk,
            R.drawable.d,
            R.drawable.d
        )

        heading = arrayOf(
            "Стрельбу открыли на праздновании Хэллоуина в США (видео)",
            "Окжетпес вылетает: итоги последнего тура чемпионата Казахстана по футболу ",
            "Взрыв был такой силы, что летали вагонетки: очевидцы о трагедии на шахте им. Костенко ",
            "Токаев обсудил с Эрдоганом по телефону инцидент на шахте в Караганде ",
            "Должны понести серьезное наказание: экс-премьер Серик Ахметов высказался о трагедии на шахте",
            "Матч Барыса в КХЛ начался с минуты молчания в память о погибших шахтерах ",
            "Часть Астаны осталась без электричества и воды (фото, видео)",
            "Определился первый финалист The International 2023",
            "Фьюри провел дуэль взглядов с Усиком после победы над Нганну (видео)",
            "Должны понести серьезное наказание: экс-премьер Серик Ахметов высказался о трагедии на шахте",
            "Должны понести серьезное наказание: экс-премьер Серик Ахметов высказался о трагедии на шахте"
        )

        newRecycleview = view.findViewById(R.id.recycleview)
        newRecycleview.layoutManager = LinearLayoutManager(requireContext())
        newRecycleview.setHasFixedSize(true)

        newArrayList = arrayListOf<News>()
        getUserdata()

        return view
    }

    private fun getUserdata() {
        for (i in imageId.indices) {
            val news = News(imageId[i], heading[i])
            newArrayList.add(news)
        }

        newRecycleview.adapter = MyAdapter(newArrayList)
    }
}