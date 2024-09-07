package itcenter.dangara.libaryappdemo.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import itcenter.dangara.libaryappdemo.Adapter.Book

class FavoritesViewModel : ViewModel() {

    private val _favoriteBooks = MutableLiveData<MutableList<Book>>(mutableListOf())
    val favoriteBooks: LiveData<MutableList<Book>> = _favoriteBooks

    fun addFavorite(book: Book) {
        _favoriteBooks.value?.let {
            if (!it.contains(book)) {
                it.add(book)
                _favoriteBooks.value = it
            }
        }
    }

    fun removeFavorite(book: Book) {
        _favoriteBooks.value?.let {
            it.remove(book)
            _favoriteBooks.value = it
        }
    }
}