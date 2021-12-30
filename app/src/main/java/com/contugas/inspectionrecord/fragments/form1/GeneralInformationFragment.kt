package com.contugas.inspectionrecord.fragments.form1

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.contugas.inspectionrecord.R
import com.contugas.inspectionrecord.databinding.FragmentGeneralInformationBinding

class GeneralInformationFragment : Fragment() {

  private var _binding: FragmentGeneralInformationBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentGeneralInformationBinding.inflate(inflater, container, false)

    val sedeAC = binding.acSede
    ArrayAdapter.createFromResource(
      requireContext(),
      R.array.sedesList,
      android.R.layout.simple_spinner_item
    ).also { adapter ->
      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
      //sedeSpinner.adapter = adapter
      sedeAC.setAdapter(adapter)
    }


    return binding.root

  }
}