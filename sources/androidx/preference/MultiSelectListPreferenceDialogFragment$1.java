package androidx.preference;

import android.content.DialogInterface;
import android.content.DialogInterface$OnMultiChoiceClickListener;

/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreferenceDialogFragment$1 implements DialogInterface$OnMultiChoiceClickListener {
    public final /* synthetic */ MultiSelectListPreferenceDialogFragment this$0;

    public MultiSelectListPreferenceDialogFragment$1(MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment) {
        this.this$0 = multiSelectListPreferenceDialogFragment;
    }

    @Override // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(DialogInterface dialogInterface, int i, boolean z2) {
        if (z2) {
            MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment = this.this$0;
            multiSelectListPreferenceDialogFragment.mPreferenceChanged = multiSelectListPreferenceDialogFragment.mNewValues.add(multiSelectListPreferenceDialogFragment.mEntryValues[i].toString()) | multiSelectListPreferenceDialogFragment.mPreferenceChanged;
        } else {
            MultiSelectListPreferenceDialogFragment multiSelectListPreferenceDialogFragment2 = this.this$0;
            multiSelectListPreferenceDialogFragment2.mPreferenceChanged = multiSelectListPreferenceDialogFragment2.mNewValues.remove(multiSelectListPreferenceDialogFragment2.mEntryValues[i].toString()) | multiSelectListPreferenceDialogFragment2.mPreferenceChanged;
        }
    }
}
