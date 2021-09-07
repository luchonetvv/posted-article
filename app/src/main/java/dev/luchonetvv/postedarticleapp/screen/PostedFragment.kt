package dev.luchonetvv.postedarticleapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.ItemTouchHelper
import dev.luchonetvv.postedarticleapp.PostedArticleApp
import dev.luchonetvv.postedarticleapp.R
import dev.luchonetvv.postedarticleapp.config.SwipeToDeleteCallback
import dev.luchonetvv.postedarticleapp.databinding.FragmentPostedListBinding
import dev.luchonetvv.postedarticleapp.domain.entity.ArticleEntity
import dev.luchonetvv.postedarticleapp.screen.adapters.PostedRecyclerViewAdapter

typealias Callback = (articleEntity: ArticleEntity) -> Unit
typealias SwipeCallback = () -> Unit

/**
 * A fragment representing a list of Items.
 */
class PostedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_posted_list, container, false)
        val navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        val postedArticleContainer = (requireActivity().application as PostedArticleApp).postArticleContainer
        val articleViewModel = postedArticleContainer.articleViewModelFactory.create()
        val callback: Callback = {
            articleViewModel.deleteItem(it)
        }
        val adapter = PostedRecyclerViewAdapter(callback)

        FragmentPostedListBinding.bind(view).apply {
            toolbarPostArticle.setupWithNavController(navController, appBarConfiguration)

            listPostArticle.adapter = adapter

            ItemTouchHelper(
                SwipeToDeleteCallback(requireContext(), adapter)
            ).attachToRecyclerView(listPostArticle)

            val swipeCallback: SwipeCallback = {
                if (swipeContainerPostArticle.isRefreshing) swipeContainerPostArticle.isRefreshing = false
            }

            swipeContainerPostArticle.setOnRefreshListener {
                articleViewModel.requestArticleAndPersistIt(swipeCallback)
            }

            articleViewModel.allArticles.observe(viewLifecycleOwner, {
                it.let {
                    if (it.isEmpty()) {
                        swipeContainerPostArticle.post { swipeContainerPostArticle.isRefreshing = true }
                        articleViewModel.requestArticleAndPersistIt(swipeCallback)
                    }

                    adapter.values = it.toMutableList().apply { sortByDescending { article -> article.createdAtI } }
                    adapter.notifyItemRangeChanged(0, it.size)
                    if (swipeContainerPostArticle.isRefreshing) swipeContainerPostArticle.isRefreshing = false
                }
            })
        }

        return view
    }
}
