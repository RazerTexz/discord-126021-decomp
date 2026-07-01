package androidx.preference;

import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

/* JADX INFO: loaded from: classes.dex */
public class ListPreferenceDialogFragmentCompat$1 implements DialogInterface$OnClickListener {
    public final /* synthetic */ ListPreferenceDialogFragmentCompat this$0;

    public ListPreferenceDialogFragmentCompat$1(ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat) {
        this.this$0 = listPreferenceDialogFragmentCompat;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ListPreferenceDialogFragmentCompat listPreferenceDialogFragmentCompat = this.this$0;
        listPreferenceDialogFragmentCompat.mClickedDialogEntryIndex = i;
        listPreferenceDialogFragmentCompat.onClick(dialogInterface, -1);
        dialogInterface.dismiss();
    }
}
