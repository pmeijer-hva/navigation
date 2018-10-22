package org.me.navigation.ask

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.request_fragment.*
import org.me.navigation.*


class RequestFragment : Fragment() {

    private lateinit var viewModel: RequestViewModel
    private lateinit var sharedViewModel: SharedViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        sharedViewModel = ViewModelProviders.of(activity!!).get(SharedViewModel::class.java)
        //read value passed down via safeArgs & create own view model
        val safeArgValue = RequestViewModelFactory(RequestFragmentArgs.fromBundle(arguments).responseValue)
        viewModel = ViewModelProviders.of(this, safeArgValue).get(RequestViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.request_fragment, container, false)

    //After the view was created, set click listeners & update text views as required
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        request_button.setOnClickListener(::handleRequestValue)
        if (viewModel.requestValue == 0) {
            show_response.visibility = View.GONE
        } else {
            show_response.text = "Response value: " + viewModel.requestValue
        }
    }

    private fun handleRequestValue(button: View) {
        //In order to perform the navigation set an event into the shared view model tied to the activity's lifetime.
        sharedViewModel.navigate.value = Event(Navigation.Request)
    }

}
