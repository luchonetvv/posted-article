package dev.luchonetvv.postedarticleapp.screen.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController

import dev.luchonetvv.postedarticleapp.databinding.FragmentPostedBinding
import dev.luchonetvv.postedarticleapp.domain.entity.ArticleEntity
import dev.luchonetvv.postedarticleapp.screen.Callback
import dev.luchonetvv.postedarticleapp.screen.PostedFragmentDirections
import java.time.Instant
import java.time.temporal.ChronoUnit

/**
 * [RecyclerView.Adapter] that can display a [ArticleEntity].
 */
class PostedRecyclerViewAdapter(val callback: Callback) : RecyclerView.Adapter<PostedRecyclerViewAdapter.ViewHolder>() {
    var values = mutableListOf<ArticleEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentPostedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val actionToWebsite = PostedFragmentDirections.actionPostFragmentToPostWebviewFragment(item.storyUrl)

        holder.titleView.text = item.storyTitle
        holder.authorDateView.apply {
            "${item.author} - ${getElapsedTime(item.createdAt)}".also { text = it }
        }
        holder.cardArticle.setOnClickListener { it.findNavController().navigate(actionToWebsite) }
    }

    override fun getItemCount(): Int = values.size

    fun removeItem(position: Int) {
        val deleteItem = values[position]
        values.removeAt(position)
        notifyItemRemoved(position)
        callback(deleteItem)
    }

    inner class ViewHolder(binding: FragmentPostedBinding) : RecyclerView.ViewHolder(binding.root) {
        val titleView: TextView = binding.txtViewTitle
        val authorDateView: TextView = binding.txtViewAuthorDate
        val cardArticle: CardView = binding.cardArticle

        override fun toString(): String {
            return super.toString() + " '" + authorDateView.text + "'"
        }
    }

    private fun getElapsedTime(date: String): String {
        val dateLongMinutes = ChronoUnit.MINUTES.between(Instant.parse(date), Instant.now())

        return when {
            dateLongMinutes <= 59 -> {
                "${dateLongMinutes}minutes"
            }
            dateLongMinutes in 60..1439 -> {
                "${ChronoUnit.HOURS.between(Instant.parse(date), Instant.now())}hours"
            }
            dateLongMinutes in 1440..10079 -> {
                "${ChronoUnit.DAYS.between(Instant.parse(date), Instant.now())}days"
            }
            dateLongMinutes in 10080..40319 -> {
                "${ChronoUnit.WEEKS.between(Instant.parse(date), Instant.now())}weeks"
            }
            else -> {
                "${ChronoUnit.MONTHS.between(Instant.parse(date), Instant.now())}months"
            }
        }
    }

}
