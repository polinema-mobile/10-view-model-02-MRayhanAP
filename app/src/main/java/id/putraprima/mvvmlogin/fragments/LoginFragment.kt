package id.putraprima.mvvmlogin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import id.putraprima.mvvmlogin.R
import id.putraprima.mvvmlogin.databinding.FragmentLoginBinding
import id.putraprima.mvvmlogin.model.User
import id.putraprima.mvvmlogin.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var mUser: User
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewmodel = loginViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        loginViewModel.userLiveData.observe(viewLifecycleOwner, { value ->
            mUser = value
        })

        loginViewModel.loggedLiveData.observe(viewLifecycleOwner, { value ->
            if (value) {
                Toast.makeText(context, "Login Berhasil", Toast.LENGTH_SHORT).show()
                val bundle = bundleOf("email" to mUser.email)
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment, bundle)
            }
        })
    }
}