package fr.sophiejacquot.apres

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmDeleteNoteDialogFragment(val noteTitle: String? = "") : DialogFragment() {

    interface ConfirmDeleteNoteDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    var listener: ConfirmDeleteNoteDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?) : Dialog{

        val builder = AlertDialog.Builder(activity)

        builder.setMessage("Etes-vous sûr(e) de  supprimer la note \"$noteTitle\" ?")
            .setPositiveButton("Supprimer",
                    DialogInterface.OnClickListener {dialog: DialogInterface?, id -> listener?.onDialogPositiveClick()})
            .setNegativeButton("Annuler",
                DialogInterface.OnClickListener {dialog: DialogInterface?, id -> listener?.onDialogNegativeClick()})

        return builder.create()
    }
}