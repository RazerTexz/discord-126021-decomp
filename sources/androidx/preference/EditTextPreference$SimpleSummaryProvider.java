package androidx.preference;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class EditTextPreference$SimpleSummaryProvider implements Preference$SummaryProvider<EditTextPreference> {
    private static EditTextPreference$SimpleSummaryProvider sSimpleSummaryProvider;

    private EditTextPreference$SimpleSummaryProvider() {
    }

    public static EditTextPreference$SimpleSummaryProvider getInstance() {
        if (sSimpleSummaryProvider == null) {
            sSimpleSummaryProvider = new EditTextPreference$SimpleSummaryProvider();
        }
        return sSimpleSummaryProvider;
    }

    @Override // androidx.preference.Preference$SummaryProvider
    public /* bridge */ /* synthetic */ CharSequence provideSummary(Preference preference) {
        return provideSummary((EditTextPreference) preference);
    }

    public CharSequence provideSummary(EditTextPreference editTextPreference) {
        return TextUtils.isEmpty(editTextPreference.getText()) ? editTextPreference.getContext().getString(R$string.not_set) : editTextPreference.getText();
    }
}
