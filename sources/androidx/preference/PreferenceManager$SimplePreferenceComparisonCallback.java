package androidx.preference;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceManager$SimplePreferenceComparisonCallback extends PreferenceManager$PreferenceComparisonCallback {
    @Override // androidx.preference.PreferenceManager$PreferenceComparisonCallback
    public boolean arePreferenceContentsTheSame(Preference preference, Preference preference2) {
        if (preference.getClass() != preference2.getClass()) {
            return false;
        }
        if ((preference == preference2 && preference.wasDetached()) || !TextUtils.equals(preference.getTitle(), preference2.getTitle()) || !TextUtils.equals(preference.getSummary(), preference2.getSummary())) {
            return false;
        }
        Drawable icon = preference.getIcon();
        Drawable icon2 = preference2.getIcon();
        if ((icon != icon2 && (icon == null || !icon.equals(icon2))) || preference.isEnabled() != preference2.isEnabled() || preference.isSelectable() != preference2.isSelectable()) {
            return false;
        }
        if (!(preference instanceof TwoStatePreference) || ((TwoStatePreference) preference).isChecked() == ((TwoStatePreference) preference2).isChecked()) {
            return !(preference instanceof DropDownPreference) || preference == preference2;
        }
        return false;
    }

    @Override // androidx.preference.PreferenceManager$PreferenceComparisonCallback
    public boolean arePreferenceItemsTheSame(Preference preference, Preference preference2) {
        return preference.getId() == preference2.getId();
    }
}
