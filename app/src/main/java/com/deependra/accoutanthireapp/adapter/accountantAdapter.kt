package com.deependra.accoutanthireapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deependra.accoutanthireapp.R
import com.deependra.accoutanthireapp.api.ServiceBuilder
import com.deependra.accoutanthireapp.entity.Accountant
import de.hdodenhof.circleimageview.CircleImageView

class accountantAdapter(var context: Context, var arrayList: MutableList<Accountant>) :
        RecyclerView.Adapter<accountantAdapter.AccountantHolder>() {


    class AccountantHolder(view : View) :
            RecyclerView.ViewHolder(view){

        val accountantImage: ImageView
        val accountantName: TextView
        val accountantQualification: TextView
        val accountantExperience : TextView
        val accountantNumber : TextView
        val accountantDescription : TextView
        val accountantCharge : TextView

        init {
            accountantImage = view.findViewById(R.id.accountantImage)
            accountantName = view.findViewById(R.id.accountantName)
            accountantQualification = view.findViewById(R.id.accountantQualification)
            accountantExperience = view.findViewById(R.id.accountantExperience)
            accountantNumber = view.findViewById(R.id.accountantNumber)
            accountantDescription = view.findViewById(R.id.accountantDescription)
            accountantCharge = view.findViewById(R.id.accountantCharge)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountantHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_view_layout_accountant,parent,false)
        return AccountantHolder(view)
    }

    override fun onBindViewHolder(holder: AccountantHolder, position: Int) {
        val accountant = arrayList[position]
        holder.accountantName.text = accountant.name
        holder.accountantQualification.text = accountant.qualification
        holder.accountantExperience.text = accountant.experience
        holder.accountantNumber.text = accountant.number
        holder.accountantDescription.text = accountant.description
        holder.accountantCharge.text = accountant.charge

       // val imagePath = ServiceBuilder.loadImagePath() + accountant.accountantImage!!

        Glide.with(context)
                .load(accountant.accountantImage)
                .into(holder.accountantImage)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }



}