package org.me.navigation.say

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.response_fragment.*
import org.me.navigation.Event
import org.me.navigation.Navigation
import org.me.navigation.R
import org.me.navigation.SharedViewModel


class ResponseFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        sharedViewModel = ViewModelProviders.of(activity!!).get(SharedViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.response_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =
            send_response.setOnClickListener(::handleSendResponse)


    private fun handleSendResponse(button: View) {
        val response = Integer.parseInt(value.text.toString())
        sharedViewModel.navigate.value = Event(Navigation.Response(response))
    }
}
