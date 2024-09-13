package itcenter.dangara.libaryappdemo.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import itcenter.dangara.libaryappdemo.Adapter.Book
import itcenter.dangara.libaryappdemo.Adapter.BookAdapter
import itcenter.dangara.libaryappdemo.Model.FavoritesViewModel
import itcenter.dangara.libaryappdemo.R

class FavoriteFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    private lateinit var stop: LinearLayout
    private lateinit var viewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        recyclerView = view.findViewById(R.id.book_list_favorite)
        stop = view.findViewById(R.id.stop)  // Initialize stop here
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        viewModel = ViewModelProvider(requireActivity()).get(FavoritesViewModel::class.java)

        bookAdapter = BookAdapter(viewModel.favoriteBooks.value ?: emptyList(), viewModel) { book ->
            // Handle additional click actions if needed
        }
        recyclerView.adapter = bookAdapter

        // Observe the favoriteBooks LiveData
        viewModel.favoriteBooks.observe(viewLifecycleOwner) { books ->
            bookAdapter.notifyDataSetChanged()
            checkIfEmpty(books)
        }

        return view
    }

    // Function to check if the list is empty and toggle visibility
    private fun checkIfEmpty(books: List<Book>) {
        if (books.isEmpty()) {
            recyclerView.visibility = View.GONE // If empty, RecyclerView will be hidden
            stop.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE // If not empty, RecyclerView will be shown
            stop.visibility = View.GONE
        }
    }
}