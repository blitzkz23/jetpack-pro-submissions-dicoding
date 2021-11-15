package com.app.mynoteappsroomdb.ui.insert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.app.mynoteappsroomdb.R
import com.app.mynoteappsroomdb.database.Note
import com.app.mynoteappsroomdb.databinding.ActivityNoteAddUpdateBinding
import com.app.mynoteappsroomdb.helper.DateHelper
import com.app.mynoteappsroomdb.ui.ViewModelFactory

class NoteAddUpdateActivity : AppCompatActivity() {

	private var isEdit = false
	private var note: Note? = null

	private lateinit var noteAddUpdateViewModel: NoteAddUpdateViewModel

	private var _activityNoteAddUpdateBinding: ActivityNoteAddUpdateBinding? = null
	private val binding get() = _activityNoteAddUpdateBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		_activityNoteAddUpdateBinding = ActivityNoteAddUpdateBinding.inflate(layoutInflater)
		setContentView(binding?.root)

		noteAddUpdateViewModel = obtainViewModel(this@NoteAddUpdateActivity)

		note = intent.getParcelableExtra(EXTRA_NOTE)
		if (note != null) {
			isEdit = true
		} else {
			note = Note()
		}
		val actionBarTitle: String
		val btnTitle: String

		if (isEdit) {
			actionBarTitle = getString(R.string.change)
			btnTitle = getString(R.string.update)
			if (note != null) {
				note?.let { note ->
					binding?.edtTitle?.setText(note.title)
					binding?.edtDescription?.setText(note.description)
				}
			}
		} else {
			actionBarTitle = getString(R.string.add)
			btnTitle = getString(R.string.save)
		}
		supportActionBar?.title = actionBarTitle

		supportActionBar?.setDisplayHomeAsUpEnabled(true)
		binding?.btnSubmit?.text = btnTitle
		binding?.btnSubmit?.setOnClickListener {
			val title = binding?.edtTitle?.text.toString().trim()
			val description = binding?.edtDescription?.text.toString().trim()
			when {
				title.isEmpty() -> {
					binding?.edtTitle?.error = getString(R.string.empty)
				}
				description.isEmpty() -> {
					binding?.edtDescription?.error = getString(R.string.empty)
				}
				else -> {
					note.let { note ->
						note?.title = title
						note?.description = description
					}
					if (isEdit) {
						noteAddUpdateViewModel.update(note as Note)
						showToast(getString(R.string.changed))
					} else {
						note.let { note ->
							note?.date = DateHelper.getCurrentDate()
						}
						noteAddUpdateViewModel.insert(note as Note)
						showToast(getString(R.string.added))
					}
					finish()
				}
			}
		}
	}

	private fun showToast(message: String) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
	}

	private fun obtainViewModel(activity: AppCompatActivity): NoteAddUpdateViewModel {
		val factory = ViewModelFactory.getInstance(activity.application)
		return ViewModelProvider(activity, factory).get(NoteAddUpdateViewModel::class.java)
	}

	override fun onCreateOptionsMenu(menu: Menu?): Boolean {
		if (isEdit) {
			menuInflater.inflate(R.menu.menu_form, menu)
		}
		return super.onCreateOptionsMenu(menu)
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		when (item.itemId) {
			R.id.action_delete -> showAlertDialog(ALERT_DIALOG_DELETE)
			android.R.id.home -> showAlertDialog(ALERT_DIALOG_CLOSE)
		}
		return super.onOptionsItemSelected(item)
	}

	override fun onBackPressed() {
		showAlertDialog(ALERT_DIALOG_CLOSE)
	}

	private fun showAlertDialog(type: Int) {
		val isDialogClose = type == ALERT_DIALOG_CLOSE
		val dialogTitle: String
		val dialogMessage: String
		if (isDialogClose) {
			dialogTitle = getString(R.string.cancel)
			dialogMessage = getString(R.string.delete)
		} else {
			dialogMessage = getString(R.string.message_delete)
			dialogTitle = getString(R.string.delete)
		}
		val alertDialogBuilder = AlertDialog.Builder(this)
		with(alertDialogBuilder) {
			setTitle(dialogTitle)
			setMessage(dialogMessage)
			setCancelable(false)
			setPositiveButton(getString(R.string.yes)) { _, _ ->
				if (!isDialogClose) {
					noteAddUpdateViewModel.delete(note as Note)
					showToast(getString(R.string.deleted))
				}
				finish()
			}
			setNegativeButton(getString(R.string.no)) { dialog, _ -> dialog.cancel() }
		}
		val alertDialog = alertDialogBuilder.create()
		alertDialog.show()
	}

	override fun onDestroy() {
		super.onDestroy()
		_activityNoteAddUpdateBinding = null
	}

	companion object {
		const val EXTRA_NOTE = "extra_note"
		const val ALERT_DIALOG_CLOSE = 10
		const val ALERT_DIALOG_DELETE = 20
	}
}