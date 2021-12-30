package com.contugas.inspectionrecord

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.contugas.inspectionrecord.fragments.form1.GeneralInformationFragment
import com.contugas.inspectionrecord.fragments.form1.InspectionResultsFragment
import com.contugas.inspectionrecord.fragments.form1.ObservationFragment

class ViewPagerAdapter(fragment: FragmentManager, lifecycle: Lifecycle) :
  FragmentStateAdapter(fragment, lifecycle) {
  override fun getItemCount(): Int {
    return 3
  }

  override fun createFragment(position: Int): Fragment {
    when (position) {
      0 -> return GeneralInformationFragment()
      1 -> return InspectionResultsFragment()
      2 -> return ObservationFragment()
      else -> return GeneralInformationFragment()
    }
  }

}