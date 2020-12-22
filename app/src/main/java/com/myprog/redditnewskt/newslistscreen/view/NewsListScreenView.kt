package com.myprog.redditnewskt.newslistscreen.view

import android.content.Intent
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
import com.myprog.redditnewskt.imageviewerscreen.EXTRA_URL
import com.myprog.redditnewskt.imageviewerscreen.ImageViewerScreen
import com.myprog.redditnewskt.newslistscreen.contract.MainContract
import com.myprog.redditnewskt.newslistscreen.presenter.NewsListScreenPresenter
import com.squareup.picasso.Picasso
import kotlin.math.atan

class NewsListScreenView : Fragment(), MainContract.View {


    private lateinit var recyclerView: RecyclerView
    private lateinit var mPresenter: MainContract.Presenter
    private var adapter: NewsAdapter? = null

    //Test
    var author: ArrayList<String> = arrayListOf("Автор", "Автор")
    var timePublic: ArrayList<Int> = arrayListOf(2, 1)
    var num_comments: ArrayList<Int> = arrayListOf(543, 631)
    var thumbnail: ArrayList<String> = arrayListOf("https://lh3.googleusercontent.com/proxy/LDuFuVyPRPzM0YzB7LIpva1-47GsSvgEKGYRRi9UsoyIhUVmys5St9pnAvBzTwDaf7D-quZ4PXlJ3EhtcqhbUVjW4Ohr47lZbUn3QbJ405M873uYz4vJWy4sk_nOG52PWSEYTFhTYbmQf1YwZEI65wo", "https://i.pinimg.com/originals/ab/b6/a8/abb6a800ab2193fcedd9bda566b7402c.jpg")
    var url: ArrayList<String> = arrayListOf("", "")
    var title: ArrayList<String> = arrayListOf("Заголовок", "Заоловок")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = NewsListScreenPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.news_list_screen, container, false)
        recyclerView = view.findViewById(R.id.news_recycler) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = NewsAdapter(author, timePublic, num_comments, thumbnail, url, title)          //Test
        recyclerView.adapter = adapter                                                          //Test
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
        if (adapter == null) {
            adapter = NewsAdapter(author, timePublic, num_comments, thumbnail, url, title)
            recyclerView.adapter = adapter
        } else {
            adapter!!.updateItem(author, timePublic, num_comments, thumbnail, url, title)
            adapter!!.notifyDataSetChanged()
        }
    }

    companion object {
        fun newInstance(): NewsListScreenView {
            return NewsListScreenView()
        }
    }

    private inner class NewsAdapter(
        var author: ArrayList<String>,
        var timePublic: ArrayList<Int>,
        var num_comments: ArrayList<Int>,
        var thumbnail: ArrayList<String>,
        var url: ArrayList<String>,
        var title: ArrayList<String>
    ) :
        RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = layoutInflater.inflate(R.layout.news_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(author, timePublic, num_comments, url, title)

            Picasso.with(holder.itemView.context).load(thumbnail[position])
                .placeholder(R.drawable.placeholder).into(holder.thumbnailView)
        }

        override fun getItemCount(): Int {
            return author.size
        }

        fun updateItem(
            author: ArrayList<String>,
            timePublic: ArrayList<Int>,
            num_comments: ArrayList<Int>,
            thumbnail: ArrayList<String>,
            url: ArrayList<String>,
            title: ArrayList<String>
        ) {
           this.author = author
           this.timePublic = timePublic
           this.num_comments = num_comments
           this.thumbnail = thumbnail
           this.url = url
           this.title = title
           notifyDataSetChanged()
        }
    }

    private inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {

        var textAuthorView: TextView = itemView.findViewById(R.id.author)
        var textPosted_byView: TextView = itemView.findViewById(R.id.posted_by)
        var textNum_commentsView: TextView = itemView.findViewById(R.id.num_comments)
        var textTitleView: TextView = itemView.findViewById(R.id.title)
        var thumbnailView: ImageView = itemView.findViewById(R.id.thumbnail)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(
            author: ArrayList<String>,
            timePublic: ArrayList<Int>,
            num_comments: ArrayList<Int>,
            url: ArrayList<String>,
            title: ArrayList<String>
        ) {
            textAuthorView.setText(author[position])
            textPosted_byView.setText(timePublic[position].toString())
            textNum_commentsView.setText(num_comments[position].toString())
            textTitleView.setText(title[position])
        }

        override fun onClick(v: View) {
            Intent(context, ImageViewerScreen::class.java).apply {
                putExtra(EXTRA_URL, url[position])
            }
        }
    }
}