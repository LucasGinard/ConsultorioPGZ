package com.pgz.consultoriopgz.modules.client.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.pgz.consultoriopgz.R
import com.pgz.consultoriopgz.data.entitys.ClientEntity
import com.pgz.consultoriopgz.databinding.FragmentListClientsBinding
import com.pgz.consultoriopgz.modules.client.model.ClientListContract
import com.pgz.consultoriopgz.modules.client.presenter.ClientListPresenter
import com.pgz.consultoriopgz.utils.SessionCache

class ClientListFragment:Fragment(), ClientListContract.View {

    private lateinit var _binding:FragmentListClientsBinding
    private lateinit var presenter:ClientListPresenter
    private lateinit var adapter: ClientListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListClientsBinding.inflate(inflater, container, false)
        presenter = ClientListPresenter(this)
        configureUI()
        configureOnClickListener()
        return _binding.root
    }

    private fun configureUI() {
        _binding.header.tvTitleHeader.text = getText(R.string.title_client)
        _binding.header.icLogo.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_client))

        _binding.rvListClients.layoutManager = LinearLayoutManager(requireContext())
        adapter = ClientListAdapter(SessionCache.listClients,this)
        _binding.rvListClients.adapter = adapter
        validateShowList(SessionCache.listClients.isEmpty())
    }

    private fun configureOnClickListener() {
        _binding.btnAddClient.setOnClickListener {
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(this.id, ClientRegisterFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        _binding.btnDelete.setOnClickListener {
            presenter.deleteClient(SessionCache.listCheckToDeleteClient)
        }

        _binding.header.btnArrowBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun validateShowList(hideList: Boolean) {
        if (hideList){
            _binding.rvListClients.visibility = View.GONE
            _binding.showIsEmptySection.visibility = View.VISIBLE
        }else{
            _binding.rvListClients.visibility = View.VISIBLE
            _binding.showIsEmptySection.visibility = View.GONE
        }
    }

    override fun deleteClientsSelect(listDelete:ArrayList<ClientEntity>) {
        listDelete.forEach { clientEntity ->
            SessionCache.listClients.remove(clientEntity)
        }
    }

    override fun updateListClient() {
        adapter.notifyDataSetChanged()
    }

    override fun showError() {
        Toast.makeText(requireContext(),"No se a eliminado vuelva a intentarlo", Toast.LENGTH_LONG).show()
    }

    override fun showDeleteButton() {
        _binding.btnDelete.visibility = View.VISIBLE
    }

    override fun hideDeleteButton() {
        _binding.btnDelete.visibility = View.GONE
    }
}