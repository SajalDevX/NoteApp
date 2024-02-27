//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.noteapp2.note_app.domain.model.Note
//import com.example.noteapp2.note_app.domain.use_case.NoteUseCases
//import com.example.noteapp2.note_app.domain.use_case.SearchNotesUseCase
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.flow.*
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class SearchViewModel @Inject constructor(
//    private val notesUseCase: NoteUseCases,
//    private val searchNotesUseCase: SearchNotesUseCase // Inject SearchNotesUseCase
//) : ViewModel() {
//    private val _searchText = MutableStateFlow("")
//    val searchText = _searchText.asStateFlow()
//
//    private val _notes = MutableStateFlow<List<Note>>(emptyList())
//
//    private val _isSearching = MutableStateFlow(false)
//    val isSearching = _isSearching.asStateFlow()
//
//    init {
//        fetchNotes()
//    }
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    private fun fetchNotes() {
//        viewModelScope.launch {
//            val notesFlow = notesUseCase.getNotesUseCases()
//            val notesList = notesFlow.flatMapLatest { it.asFlow() }.toList()
//            _notes.value = notesList
//        }
//    }
//
//
//    val notes: StateFlow<List<Note>> = searchText
//        .debounce(1000)
//        .onEach { _isSearching.value = true }
//        .flatMapLatest { searchNotesUseCase(it) } // Use searchNotesUseCase for searching
//        .onEach { _isSearching.value = false }
//        .stateIn(
//            viewModelScope,
//            SharingStarted.WhileSubscribed(5000),
//            emptyList()
//        )
//
//    fun takeUserInput(text: String) {
//        _searchText.value = text
//    }
//}
