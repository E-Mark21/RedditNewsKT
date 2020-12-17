package com.myprog.redditnewskt.newslistscreen.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myprog.redditnewskt.R
import com.myprog.redditnewskt.newslistscreen.contract.MainContract
import com.myprog.redditnewskt.newslistscreen.presenter.NewsListScreenPresenter

class NewsListScreenView : Fragment(), MainContract.View {

    init {
        val mPresenter = NewsListScreenPresenter(this)
    }

    private lateinit var recyclerView: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_list_screen, container, false)
        recyclerView = view.findViewById(R.id.news_recycler) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        return view
    }



    companion object {
        fun newInstance(): NewsListScreenView {
            return NewsListScreenView()
        }
    }

    private inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        val author: TextView = itemView.findViewById(R.id.author)
        val posted_by: TextView = itemView.findViewById(R.id.posted_by)
        val num_comments: TextView = itemView.findViewById(R.id.num_comments)
        val tile: TextView = itemView.findViewById(R.id.title)
        val thumbnail: ImageView = itemView.findViewById(R.id.thumbnail)

        init {
            itemView.setOnClickListener (this)
        }

        fun bind() {

        }

        override fun onClick(v: View) {

        }
    }

    private inner class NewsAdapter() : RecyclerView.Adapter<ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = layoutInflater.inflate(R.layout.news_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind()
        }

        override fun getItemCount(): Int {
            return 100
        }
    }

    override fun updateAdapter(
        author: ArrayList<String>,
        timePublic: ArrayList<Int>,
        num_comments: ArrayList<Int>,
        thumbnail: ArrayList<String>,
        url: ArrayList<String>,
        title: ArrayList<String>
    ) {

    }
}