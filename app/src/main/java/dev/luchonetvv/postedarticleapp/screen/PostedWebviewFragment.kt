package dev.luchonetvv.postedarticleapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import dev.luchonetvv.postedarticleapp.R
import dev.luchonetvv.postedarticleapp.databinding.FragmentPostedWebviewBinding

/**
 * A simple [Fragment] subclass.
 * Use the [PostedWebviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostedWebviewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posted_webview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: PostedWebviewFragmentArgs by navArgs()
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        FragmentPostedWebviewBinding.bind(view).apply {
            toolbarPostWebsite.setupWithNavController(navController, appBarConfiguration)

            webviewPostWebsite.apply {
                loadUrl(args.url!!)
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment.
         *
         * @return A new instance of fragment PostWebviewFragment.
         */
        @JvmStatic
        fun newInstance() = PostedWebviewFragment()
    }
}
