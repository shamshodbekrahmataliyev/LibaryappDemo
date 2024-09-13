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

class BadiiyFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    private lateinit var viewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_badiiy, container, false)

        recyclerView = view.findViewById(R.id.bookId)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        viewModel = ViewModelProvider(requireActivity()).get(FavoritesViewModel::class.java)

        val books = listOf(
            Book("O'tgan kunlar", R.drawable.book_img),
            Book("Mehrobdan chayon", R.drawable.book_img),
            Book("Yulduzli tunlar", R.drawable.book_img),
            Book("Chol va dengiz", R.drawable.book_img),
            Book("Don Kixot", R.drawable.book_img),
            Book("Boburnoma", R.drawable.book_img),
            Book("Shum bola", R.drawable.book_img),
            Book("Alpomish", R.drawable.book_img),
            Book("Zulmatdagi tong", R.drawable.book_img),
            Book("Sariq devni minib", R.drawable.book_img),
            Book("Urush va tinchlik", R.drawable.book_img),
            Book("Madagaskar", R.drawable.book_img),
            Book("Katta va kichik", R.drawable.book_img),
            Book("Ikki eshik orasi", R.drawable.book_img),
            Book("Zaynab va Omon", R.drawable.book_img),
            Book("Yo'lchi", R.drawable.book_img),
            Book("Muhabbat", R.drawable.book_img),
            Book("Sariq devning o'limi", R.drawable.book_img),
            Book("Qo'rqinchli hikoyalar", R.drawable.book_img),
            Book("Shaytanat", R.drawable.book_img),
            Book("Tafakkur qanotlari", R.drawable.book_img),
            Book("Lolazor", R.drawable.book_img),
            Book("Ko‘hna dunyo", R.drawable.book_img),
            Book("Hamsa", R.drawable.book_img),
            Book("Qiyomat", R.drawable.book_img),
            Book("Oq kema", R.drawable.book_img),
            Book("Erk insoni", R.drawable.book_img),
            Book("Ayblov", R.drawable.book_img),
            Book("Bir savolning hikoyasi", R.drawable.book_img),
            Book("To‘lqinlar", R.drawable.book_img),
            Book("Jinoyat va jazo", R.drawable.book_img),
            Book("Oltin odam", R.drawable.book_img),
            Book("Tungi mehmon", R.drawable.book_img),
            Book("Ikki olam", R.drawable.book_img),
            Book("Olamga sig‘magan odam", R.drawable.book_img),
            Book("O'lim yoqasida", R.drawable.book_img),
            Book("G‘irromlar makoni", R.drawable.book_img),
            Book("Xiyonat", R.drawable.book_img),
            Book("Qo‘rqinchli kecha", R.drawable.book_img)
        )


        bookAdapter = BookAdapter(books, viewModel) { book ->
            // Handle additional click actions if needed
        }
        recyclerView.adapter = bookAdapter

        return view
    }
}