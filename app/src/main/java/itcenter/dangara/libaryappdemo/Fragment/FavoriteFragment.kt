package itcenter.dangara.libaryappdemo.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import itcenter.dangara.libaryappdemo.Adapter.BookAdapter
import itcenter.dangara.libaryappdemo.R

class FavoriteFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        recyclerView = view.findViewById(R.id.book_list_favorite)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3) // 3 items per row

        bookAdapter = BookAdapter(BadiiyFragment.favoriteBooks) {
            // Handle like click in FavoriteFragment if needed
        }
        recyclerView.adapter = bookAdapter

        return view
    }

    override fun onResume() {
        super.onResume()
        // Refresh adapter when returning to this fragment to reflect new favorite items
        bookAdapter.notifyDataSetChanged()
    }
}