package com.myprog.redditnewskt.newslistscreen.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myprog.redditnewskt.R
import com.myprog.redditnewskt.newslistscreen.contract.MainContract
import com.myprog.redditnewskt.newslistscreen.presenter.NewsListScreenPresenter

class NewsListScreenView : Fragment(), MainContract.View {


    private lateinit var recyclerView: RecyclerView
    private lateinit var mPresenter: NewsListScreenPresenter
    private var adapter: NewsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_list_screen, container, false)
        recyclerView = view.findViewById(R.id.news_recycler) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        mPresenter = NewsListScreenPresenter(this)
        return view
    }
    override fun updateAdapter(
        author: ArrayList<String>,
        timePublic: ArrayList<Int>,
        num_comments: ArrayList<Int>,
        thumbnail: ArrayList<String>,
        url: ArrayList<String>,
        title: ArrayList<String>
    ) {
        adapter = NewsAdapter(author, timePublic, num_comments, thumbnail, url, title)
        recyclerView.adapter= adapter

    }

    companion object {
        fun newInstance(): NewsListScreenView {
            return NewsListScreenView()
        }
    }

    private inner class NewsAdapter(var author: ArrayList<String>,
                                    var timePublic: ArrayList<Int>,
                                    var num_comments: ArrayList<Int>,
                                    var thumbnail: ArrayList<String>,
                                    var url: ArrayList<String>,
                                    var title: ArrayList<String>) :
        RecyclerView.Adapter<ViewHolder>(), View.OnClickListener {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = layoutInflater.inflate(R.layout.news_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind()
        }

        override fun getItemCount(): Int {
            return author.size
        }

        override fun onClick(p0: View?) {
            Toast.makeText(context, "Pressed!", Toast.LENGTH_SHORT).show()
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




}