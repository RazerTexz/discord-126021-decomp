package androidx.preference;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ListPreference$SimpleSummaryProvider implements Preference$SummaryProvider<ListPreference> {
    private static ListPreference$SimpleSummaryProvider sSimpleSummaryProvider;

    private ListPreference$SimpleSummaryProvider() {
    }

    public static ListPreference$SimpleSummaryProvider getInstance() {
        if (sSimpleSummaryProvider == null) {
            sSimpleSummaryProvider = new ListPreference$SimpleSummaryProvider();
        }
        return sSimpleSummaryProvider;
    }

    @Override // androidx.preference.Preference$SummaryProvider
    public /* bridge */ /* synthetic */ CharSequence provideSummary(Preference preference) {
        return provideSummary((ListPreference) preference);
    }

    public CharSequence provideSummary(ListPreference listPreference) {
        return TextUtils.isEmpty(listPreference.getEntry()) ? listPreference.getContext().getString(R$string.not_set) : listPreference.getEntry();
    }
}
