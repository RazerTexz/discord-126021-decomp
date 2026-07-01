package androidx.preference;

import android.content.DialogInterface;
import android.content.DialogInterface$OnMultiChoiceClickListener;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreferenceDialogFragmentCompat$1 implements DialogInterface$OnMultiChoiceClickListener {
    public final /* synthetic */ MultiSelectListPreferenceDialogFragmentCompat this$0;

    public MultiSelectListPreferenceDialogFragmentCompat$1(MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat) {
        this.this$0 = multiSelectListPreferenceDialogFragmentCompat;
    }

    @Override // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(DialogInterface dialogInterface, int i, boolean z2) {
        if (z2) {
            MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat = this.this$0;
            multiSelectListPreferenceDialogFragmentCompat.mPreferenceChanged = multiSelectListPreferenceDialogFragmentCompat.mNewValues.add(multiSelectListPreferenceDialogFragmentCompat.mEntryValues[i].toString()) | multiSelectListPreferenceDialogFragmentCompat.mPreferenceChanged;
        } else {
            MultiSelectListPreferenceDialogFragmentCompat multiSelectListPreferenceDialogFragmentCompat2 = this.this$0;
            multiSelectListPreferenceDialogFragmentCompat2.mPreferenceChanged = multiSelectListPreferenceDialogFragmentCompat2.mNewValues.remove(multiSelectListPreferenceDialogFragmentCompat2.mEntryValues[i].toString()) | multiSelectListPreferenceDialogFragmentCompat2.mPreferenceChanged;
        }
    }
}
