package itcenter.dangara.libaryappdemo.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import itcenter.dangara.libaryappdemo.Adapter.Book
import itcenter.dangara.libaryappdemo.Adapter.BookAdapter
import itcenter.dangara.libaryappdemo.Model.FavoritesViewModel
import itcenter.dangara.libaryappdemo.R

class HikoyaFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    private lateinit var viewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hikoya, container, false)

        recyclerView = view.findViewById(R.id.bookId)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        viewModel = ViewModelProvider(requireActivity()).get(FavoritesViewModel::class.java)

        val books = listOf(
            Book("Birinchi hikoya", R.drawable.book_img),
            Book("Tungi hikoyalar", R.drawable.book_img),
            Book("Qora hikoyalar", R.drawable.book_img),
            Book("Hayotning qisqa hikoyalari", R.drawable.book_img),
            Book("Xayol va hikoyalar", R.drawable.book_img),
            Book("Sehrli hikoyalar", R.drawable.book_img),
            Book("Maktabdagi hikoyalar", R.drawable.book_img),
            Book("Tushdagi hikoyalar", R.drawable.book_img),
            Book("Ko'cha hikoyalari", R.drawable.book_img),
            Book("Qizg'in hikoyalar", R.drawable.book_img),
            Book("Uyg'otuvchi hikoyalar", R.drawable.book_img),
            Book("Sarguzasht hikoyalar", R.drawable.book_img),
            Book("Dostlar hikoyalari", R.drawable.book_img),
            Book("O'zbek hikoyalari", R.drawable.book_img),
            Book("Hikoyalar to'plami", R.drawable.book_img),
            Book("Sevgi hikoyalari", R.drawable.book_img),
            Book("Tuyg'ular hikoyalari", R.drawable.book_img),
            Book("Qiziqarli hikoyalar", R.drawable.book_img),
            Book("Bolalar hikoyalari", R.drawable.book_img),
            Book("Erkak va ayol hikoyalari", R.drawable.book_img),
            Book("Yangi hikoyalar", R.drawable.book_img),
            Book("G'azal hikoyalari", R.drawable.book_img),
            Book("Dramatik hikoyalar", R.drawable.book_img),
            Book("Sarguzasht hikoyalari", R.drawable.book_img),
            Book("Kuchli hikoyalar", R.drawable.book_img),
            Book("Ko'ngil hikoyalari", R.drawable.book_img),
            Book("Tashvishli hikoyalar", R.drawable.book_img),
            Book("Qiziqarli hikoyalar to'plami", R.drawable.book_img),
            Book("Jazbali hikoyalar", R.drawable.book_img),
            Book("Ajoyib hikoyalar", R.drawable.book_img),
            Book("Yangi avlod hikoyalar", R.drawable.book_img),
            Book("Sehrli sarguzashtlar", R.drawable.book_img),
            Book("Moychechak hikoyalari", R.drawable.book_img),
            Book("Yashirin hikoyalar", R.drawable.book_img),
            Book("Tushunarsiz hikoyalar", R.drawable.book_img),
            Book("Hayot hikoyalari", R.drawable.book_img),
            Book("Sirrli hikoyalar", R.drawable.book_img),
            Book("Ko'cha va qo'shni hikoyalar", R.drawable.book_img),
            Book("Do'stlik hikoyalari", R.drawable.book_img),
            Book("Sahro hikoyalari", R.drawable.book_img),
            Book("Qizg'in hikoyalar to'plami", R.drawable.book_img),
            Book("O'ziga xos hikoyalar", R.drawable.book_img)
        )
        

        bookAdapter = BookAdapter(books, viewModel) { book ->
        }
        recyclerView.adapter = bookAdapter

        return view
    }
}