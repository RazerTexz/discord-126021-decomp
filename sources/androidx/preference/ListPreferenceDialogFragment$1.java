package androidx.preference;

import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

/* JADX INFO: loaded from: classes.dex */
public class ListPreferenceDialogFragment$1 implements DialogInterface$OnClickListener {
    public final /* synthetic */ ListPreferenceDialogFragment this$0;

    public ListPreferenceDialogFragment$1(ListPreferenceDialogFragment listPreferenceDialogFragment) {
        this.this$0 = listPreferenceDialogFragment;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ListPreferenceDialogFragment listPreferenceDialogFragment = this.this$0;
        listPreferenceDialogFragment.mClickedDialogEntryIndex = i;
        listPreferenceDialogFragment.onClick(dialogInterface, -1);
        dialogInterface.dismiss();
    }
}
