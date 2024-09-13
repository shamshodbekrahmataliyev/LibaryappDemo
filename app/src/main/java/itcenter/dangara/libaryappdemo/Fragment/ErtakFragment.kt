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

class ErtakFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    private lateinit var viewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ertak, container, false)

        recyclerView = view.findViewById(R.id.bookId)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        viewModel = ViewModelProvider(requireActivity()).get(FavoritesViewModel::class.java)

        val books = listOf(
            Book("O'zbek xalq ertaklari", R.drawable.book_img),
            Book("Yorug'lik va qorong'ulik", R.drawable.book_img),
            Book("Ajoyib ertaklar", R.drawable.book_img),
            Book("Sehrli o'lkalar", R.drawable.book_img),
            Book("Qizil buta", R.drawable.book_img),
            Book("Bashoratli sehrgar", R.drawable.book_img),
            Book("Qalbning sehrli portali", R.drawable.book_img),
            Book("Jodugar va jodugarchi", R.drawable.book_img),
            Book("Kichik muammolar", R.drawable.book_img),
            Book("Haqiqiy do'stlar", R.drawable.book_img),
            Book("Birinchi qadam", R.drawable.book_img),
            Book("Armanlar o'lkasi", R.drawable.book_img),
            Book("To'rt uslub", R.drawable.book_img),
            Book("Yorqin yulduz", R.drawable.book_img),
            Book("Sehrli sarguzashtlar", R.drawable.book_img),
            Book("Gul va qiz", R.drawable.book_img),
            Book("Olovli qor", R.drawable.book_img),
            Book("Tuzuk xayol", R.drawable.book_img),
            Book("G'azal", R.drawable.book_img),
            Book("Uzumlar va o'rgimchaklar", R.drawable.book_img),
            Book("Qora va oq", R.drawable.book_img),
            Book("Yorug'lik sehrlari", R.drawable.book_img),
            Book("Guldan harf", R.drawable.book_img),
            Book("Sahro gultoj", R.drawable.book_img),
            Book("Toza havo", R.drawable.book_img),
            Book("Oltin bo'ron", R.drawable.book_img),
            Book("Kichik dovdir", R.drawable.book_img),
            Book("Maktabdagi sehr", R.drawable.book_img),
            Book("Ajdaho va olmos", R.drawable.book_img),
            Book("Hayajonli ertaklar", R.drawable.book_img),
            Book("Yashirin sayohatlar", R.drawable.book_img),
            Book("Sevgi o'lkasi", R.drawable.book_img),
            Book("Qizil shahar", R.drawable.book_img),
            Book("Olmosli qalam", R.drawable.book_img),
            Book("O'zbekiston ertaklari", R.drawable.book_img),
            Book("Tuzuk erkin", R.drawable.book_img),
            Book("Sehrli xazon", R.drawable.book_img),
            Book("Qorong'u osmon", R.drawable.book_img),
            Book("G'azal yulduzi", R.drawable.book_img),
            Book("Oltin g'ildirak", R.drawable.book_img),
            Book("Sahro ertaklari", R.drawable.book_img),
            Book("Gulzor", R.drawable.book_img)
        )


        bookAdapter = BookAdapter(books, viewModel) { book ->
            // Handle additional click actions if needed
        }
        recyclerView.adapter = bookAdapter

        return view
    }
}