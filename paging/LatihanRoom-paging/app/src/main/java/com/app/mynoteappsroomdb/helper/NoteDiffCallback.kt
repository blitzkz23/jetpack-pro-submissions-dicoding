package com.app.mynoteappsroomdb.helper

import androidx.recyclerview.widget.DiffUtil
import com.app.mynoteappsroomdb.database.Note

class NoteDiffCallback(private val mOldNoteList: List<Note>, private val mNewNoteList: List<Note>): DiffUtil.Callback() {
	override fun getOldListSize(): Int {
		return mOldNoteList.size
	}

	override fun getNewListSize(): Int {
		return mNewNoteList.size
	}

	override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		return mOldNoteList[oldItemPosition].id == mNewNoteList[newItemPosition].id
	}

	override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
		val oldNoteList = mOldNoteList[oldItemPosition]
		val newNoteList = mNewNoteList[newItemPosition]
		return oldNoteList.title == newNoteList.title && oldNoteList.description == newNoteList.description
	}
}