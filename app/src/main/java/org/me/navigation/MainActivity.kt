package org.me.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import org.me.navigation.say.ResponseFragmentDirections

class MainActivity : AppCompatActivity() {
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedViewModel = ViewModelProviders.of(this).get(SharedViewModel::class.java)
        handleNavigationEvents()
    }

    private fun handleNavigationEvents() {
        sharedViewModel.navigate.observe(this, Observer { event ->
            event?.getContentIfNotHandled()?.let { action ->
                when (action) {
                    is Navigation.Request -> openRequestFragment()
                    is Navigation.Response -> handleResponse(action.response)
                }
            }
        })
    }

    private fun openRequestFragment() {
        findNavController(R.id.nav_graph_container).navigate(R.id.action_goFrom_requestFragment_to_responseFragment)
    }

    private fun handleResponse(response: Int) {
        findNavController(R.id.nav_graph_container).navigate(ResponseFragmentDirections.actionResultFromResponseFragmentToRequestFragment().setResponseValue(response))
    }

}
