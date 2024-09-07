package itcenter.dangara.libaryappdemo.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import itcenter.dangara.libaryappdemo.Fragment.BadiiyFragment
import itcenter.dangara.libaryappdemo.R

data class Book(val title: String, val imageResId: Int)

class BookAdapter(
    private val books: List<Book>,
    private val onLikeClicked: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.titleTextView.text = book.title
        holder.bookImageView.setImageResource(book.imageResId)

        // Set the saveLike icon based on whether the book is in favorites
        holder.saveLikeImageView.setImageResource(
            if (BadiiyFragment.favoriteBooks.contains(book)) R.drawable.favorite_fill else R.drawable.favorite
        )

        holder.saveLikeImageView.setOnClickListener {
            if (BadiiyFragment.favoriteBooks.contains(book)) {
                BadiiyFragment.favoriteBooks.remove(book)
                holder.saveLikeImageView.setImageResource(R.drawable.favorite)
            } else {
                BadiiyFragment.favoriteBooks.add(book)
                holder.saveLikeImageView.setImageResource(R.drawable.favorite_fill)
                onLikeClicked(book)  // Handle the click to add to favorites
            }
        }
    }

    override fun getItemCount(): Int {
        return books.size
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.title)
        val bookImageView: ImageView = itemView.findViewById(R.id.bookImage)
        val saveLikeImageView: ImageView = itemView.findViewById(R.id.saveLike)
    }
}