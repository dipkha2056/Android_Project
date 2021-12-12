package com.deependra.accoutanthireapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deependra.accoutanthireapp.adapter.accountantAdapter
import com.deependra.accoutanthireapp.db.AccountantDB
import com.deependra.accoutanthireapp.entity.Accountant
import com.deependra.accoutanthireapp.repository.AccountantRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserDashboard_Activity : AppCompatActivity() {

    //private var lstAccontant = ArrayList<Accountant>()
    private lateinit var recycler_view_accountant: RecyclerView
    private var gridLayoutManager: GridLayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard_)

        recycler_view_accountant = findViewById(R.id.recycler_view_accountant)


        CoroutineScope(Dispatchers.IO).launch {

            val accountantRepository = AccountantRepository()
            val response = accountantRepository.getAllAccountant(this@UserDashboard_Activity)

            withContext(Main) {

                gridLayoutManager =
                        GridLayoutManager(applicationContext, 2, LinearLayoutManager.VERTICAL, false)
                recycler_view_accountant.layoutManager = gridLayoutManager
                recycler_view_accountant.setHasFixedSize(true)

//                        lstAccountant = ArrayList()
                val adapter = accountantAdapter(this@UserDashboard_Activity, response)
                recycler_view_accountant.adapter = adapter
            }
        }


    }
}




//
//        var accountant: ArrayList<Accountant> = ArrayList()
//
//        accountant.add(Accountant("1","Deependra Khatiwada","MBA","5 years","9861047344",
//        "one of the best Accountant","1000/hr",
//                "https://rukminim1.flixcart.com/image/352/352/k1fbmvk0/mug/8/s/v/i-love-you-deependra-name-ceramic-white-coffee-mug-330-ml-1-original-imafkzyytffmfk7j.jpeg?q=70"))
//
//
//
//        accountant.add(Accountant("1","Deependra Khatiwada","MBA","5 years","9861047344",
//                "one of the best Accountant","1000/hr",
//                "https://rukminim1.flixcart.com/image/352/352/k1fbmvk0/mug/8/s/v/i-love-you-deependra-name-ceramic-white-coffee-mug-330-ml-1-original-imafkzyytffmfk7j.jpeg?q=70"))
//
//
//        accountant.add(Accountant("1","Deependra Khatiwada","MBA","5 years","9861047344",
//                "one of the best Accountant","1000/hr",
//                "https://rukminim1.flixcart.com/image/352/352/k1fbmvk0/mug/8/s/v/i-love-you-deependra-name-ceramic-white-coffee-mug-330-ml-1-original-imafkzyytffmfk7j.jpeg?q=70"))
//
//
//        accountant.add(Accountant("1","Deependra Khatiwada","MBA","5 years","9861047344",
//                "one of the best Accountant","1000/hr",
//                "https://rukminim1.flixcart.com/image/352/352/k1fbmvk0/mug/8/s/v/i-love-you-deependra-name-ceramic-white-coffee-mug-330-ml-1-original-imafkzyytffmfk7j.jpeg?q=70"))
//
//
//        return accountant

