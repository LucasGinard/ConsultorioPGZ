package com.pgz.consultoriopgz.modules.client.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.data.entitys.ClientEntity
import com.pgz.consultoriopgz.modules.client.model.ClientListContract
import com.pgz.consultoriopgz.utils.SessionCache

class ClientListAdapter(private val clientList: ArrayList<ClientEntity>,var view:ClientListContract.View) :
    RecyclerView.Adapter<ClientListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_client, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val scheduleAppointment = clientList[position]
        holder.bind(scheduleAppointment)
    }

    override fun getItemCount(): Int {
        return clientList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvLastName: TextView = itemView.findViewById(R.id.tvLastName)
        private val tvCI: TextView = itemView.findViewById(R.id.tvCI)
        private val tvCellphone: TextView = itemView.findViewById(R.id.tvCellphone)
        private val checkClient: CheckBox = itemView.findViewById(R.id.cbDelete)

        fun bind(client: ClientEntity) {
            tvName.text = client.firstName
            tvLastName.text = client.lastName
            tvCI.text = client.idClient.toString()
            tvCellphone.text = client.numberContact

            checkClient.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked){
                    SessionCache.listCheckToDeleteClient.add(client)
                    view.showDeleteButton()
                }else{
                    SessionCache.listCheckToDeleteClient.remove(client)
                    view.hideDeleteButton()
                }
            }
        }

    }
}