import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studymate.R
import com.example.studymate.Todolist
import com.example.studymate.TodolistDatabaseHelper
import com.example.studymate.databinding.InboxBinding
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import java.util.Locale

class InboxActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdapter<Todolist>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = InboxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val popupWindow = PopupWindow(
            LayoutInflater.from(this).inflate(R.layout.popup_layout, null),
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        popupWindow.isOutsideTouchable = true
        popupWindow.isFocusable = true
        popupWindow.setBackgroundDrawable(ColorDrawable(Color.WHITE))

        val imageView = findViewById<ImageView>(R.id.imageView9)
        imageView.setOnClickListener {
            popupWindow.showAtLocation(it, Gravity.CENTER, 0, 0)
        }

        val saveButton = popupWindow.contentView.findViewById<Button>(R.id.save_todo)
        saveButton.setOnClickListener {
            val todoTitle = popupWindow.contentView.findViewById<EditText>(R.id.todo_title).text.toString()
            val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
            val todoList = Todolist(0, todoTitle, currentDate, "incomplete")
            val databaseHelper = TodolistDatabaseHelper(this)
            databaseHelper.insertToDo(todoList)
            popupWindow.dismiss()
        }

        val todoAdapter = TodoAdapter<Todolist>(mutableListOf())

        binding.todoRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@InboxActivity)
            adapter = todoAdapter
        }

        val databaseHelper = TodolistDatabaseHelper(this)
        val todoList = databaseHelper.getAllTodos() as ArrayList<Todolist>
        todoAdapter.updateData(todoList)
    }
}