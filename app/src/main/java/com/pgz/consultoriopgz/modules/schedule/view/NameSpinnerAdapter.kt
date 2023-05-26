package com.pgz.consultoriopgz.modules.schedule.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.modules.client.model.ClientModel


class NameSpinnerAdapter(context: Context, listaNombres: List<ClientModel>) :
    ArrayAdapter<ClientModel>(context, R.layout.item_spinner_client, listaNombres) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_spinner_client, parent, false)

        val client = getItem(position)

        val tvName = view.findViewById<TextView>(R.id.tvName)
        tvName.text = client?.firstName

        val tvLastName = view.findViewById<TextView>(R.id.tvLastName)
        tvLastName.text = client?.lastName

        val tvId= view.findViewById<TextView>(R.id.tvId)
        tvId.text = client?.idClient.toString()

        val tvCellphone= view.findViewById<TextView>(R.id.tvCellphone)
        tvCellphone.text = client?.numberContact

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_spinner_client, parent, false)

        val client = getItem(position)

        val tvName = view.findViewById<TextView>(R.id.tvName)
        tvName.text = client?.firstName

        val tvLastName = view.findViewById<TextView>(R.id.tvLastName)
        tvLastName.text = client?.lastName

        val tvId= view.findViewById<TextView>(R.id.tvId)
        tvId.text = client?.idClient.toString()

        val tvCellphone= view.findViewById<TextView>(R.id.tvCellphone)
        tvCellphone.text = client?.numberContact

        return view
    }
}