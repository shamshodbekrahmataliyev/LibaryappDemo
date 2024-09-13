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

class JahonFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    private lateinit var viewModel: FavoritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_jahon, container, false)

        recyclerView = view.findViewById(R.id.bookId)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)

        viewModel = ViewModelProvider(requireActivity()).get(FavoritesViewModel::class.java)

        val books = listOf(
            Book("Don Kixot", R.drawable.book_img),
            Book("Urush va tinchlik", R.drawable.book_img),
            Book("Anna Karenina", R.drawable.book_img),
            Book("Gurur va oldinma", R.drawable.book_img),
            Book("Hozirgi zamon", R.drawable.book_img),
            Book("Siddhartha", R.drawable.book_img),
            Book("1984", R.drawable.book_img),
            Book("Brave New World", R.drawable.book_img),
            Book("G'azal", R.drawable.book_img),
            Book("Moby-Dick", R.drawable.book_img),
            Book("Yuz yil yolg'izlik", R.drawable.book_img),
            Book("Kichik Prens", R.drawable.book_img),
            Book("Bachkanak", R.drawable.book_img),
            Book("Bo'ron", R.drawable.book_img),
            Book("Jinoyat va jazo", R.drawable.book_img),
            Book("Kechikib ketgan hayot", R.drawable.book_img),
            Book("G'arbiy Frontda Yangi Narsalar", R.drawable.book_img),
            Book("Kichik Muammolar", R.drawable.book_img),
            Book("Sahro", R.drawable.book_img),
            Book("Sevgi hikoyalari", R.drawable.book_img),
            Book("O'zini ozod qilish", R.drawable.book_img),
            Book("Yulduzlar", R.drawable.book_img),
            Book("Parvoz", R.drawable.book_img),
            Book("Metamorfoz", R.drawable.book_img),
            Book("Pushti olov", R.drawable.book_img),
            Book("Ulug'bekning yulduzi", R.drawable.book_img),
            Book("O'zgarmas kishi", R.drawable.book_img),
            Book("Yetti muammo", R.drawable.book_img),
            Book("Osmon yulduzi", R.drawable.book_img),
            Book("Yevropa muhiti", R.drawable.book_img),
            Book("Sahrodagi mo''jiza", R.drawable.book_img),
            Book("Sog'inch", R.drawable.book_img),
            Book("Ajdaho", R.drawable.book_img),
            Book("Gullardan xayol", R.drawable.book_img),
            Book("Erkinlik va inson", R.drawable.book_img),
            Book("O'limga qaramay", R.drawable.book_img),
            Book("Olmosli yulduzlar", R.drawable.book_img),
            Book("Sayyoralar", R.drawable.book_img),
            Book("Olamni o'zgartirish", R.drawable.book_img),
            Book("Sehrli sayohat", R.drawable.book_img),
            Book("Hikmat", R.drawable.book_img),
            Book("Yashirin sarguzasht", R.drawable.book_img)
        )



        bookAdapter = BookAdapter(books, viewModel) { book ->
            // Handle additional click actions if needed
        }
        recyclerView.adapter = bookAdapter

        return view
    }
}