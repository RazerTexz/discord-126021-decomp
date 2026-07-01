package androidx.preference;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class PreferenceGroupAdapter$PreferenceResourceDescriptor {
    public String mClassName;
    public int mLayoutResId;
    public int mWidgetLayoutResId;

    public PreferenceGroupAdapter$PreferenceResourceDescriptor(Preference preference) {
        this.mClassName = preference.getClass().getName();
        this.mLayoutResId = preference.getLayoutResource();
        this.mWidgetLayoutResId = preference.getWidgetLayoutResource();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreferenceGroupAdapter$PreferenceResourceDescriptor)) {
            return false;
        }
        PreferenceGroupAdapter$PreferenceResourceDescriptor preferenceGroupAdapter$PreferenceResourceDescriptor = (PreferenceGroupAdapter$PreferenceResourceDescriptor) obj;
        return this.mLayoutResId == preferenceGroupAdapter$PreferenceResourceDescriptor.mLayoutResId && this.mWidgetLayoutResId == preferenceGroupAdapter$PreferenceResourceDescriptor.mWidgetLayoutResId && TextUtils.equals(this.mClassName, preferenceGroupAdapter$PreferenceResourceDescriptor.mClassName);
    }

    public int hashCode() {
        return this.mClassName.hashCode() + ((((527 + this.mLayoutResId) * 31) + this.mWidgetLayoutResId) * 31);
    }
}
