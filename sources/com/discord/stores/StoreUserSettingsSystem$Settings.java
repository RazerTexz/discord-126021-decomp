package com.discord.stores;

import b.d.b.a.a;
import com.discord.models.domain.ModelUserSettings;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreUserSettingsSystem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreUserSettingsSystem$Settings {
    private final String _locale;
    private final int fontScale;
    private final String theme;

    public StoreUserSettingsSystem$Settings(String str, String str2, int i) {
        m.checkNotNullParameter(str, "theme");
        this.theme = str;
        this._locale = str2;
        this.fontScale = i;
    }

    public static /* synthetic */ StoreUserSettingsSystem$Settings copy$default(StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = storeUserSettingsSystem$Settings.theme;
        }
        if ((i2 & 2) != 0) {
            str2 = storeUserSettingsSystem$Settings._locale;
        }
        if ((i2 & 4) != 0) {
            i = storeUserSettingsSystem$Settings.fontScale;
        }
        return storeUserSettingsSystem$Settings.copy(str, str2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTheme() {
        return this.theme;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String get_locale() {
        return this._locale;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFontScale() {
        return this.fontScale;
    }

    public final StoreUserSettingsSystem$Settings copy(String theme, String _locale, int fontScale) {
        m.checkNotNullParameter(theme, "theme");
        return new StoreUserSettingsSystem$Settings(theme, _locale, fontScale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreUserSettingsSystem$Settings)) {
            return false;
        }
        StoreUserSettingsSystem$Settings storeUserSettingsSystem$Settings = (StoreUserSettingsSystem$Settings) other;
        return m.areEqual(this.theme, storeUserSettingsSystem$Settings.theme) && m.areEqual(this._locale, storeUserSettingsSystem$Settings._locale) && this.fontScale == storeUserSettingsSystem$Settings.fontScale;
    }

    public final int getFontScale() {
        return this.fontScale;
    }

    public final String getLocale() {
        String str = this._locale;
        if (str != null) {
            return str;
        }
        String defaultLocale = ModelUserSettings.getDefaultLocale();
        m.checkNotNullExpressionValue(defaultLocale, "ModelUserSettings.getDefaultLocale()");
        return defaultLocale;
    }

    public final String getTheme() {
        return this.theme;
    }

    public final String get_locale() {
        return this._locale;
    }

    public int hashCode() {
        String str = this.theme;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this._locale;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.fontScale;
    }

    public String toString() {
        StringBuilder sbU = a.U("Settings(theme=");
        sbU.append(this.theme);
        sbU.append(", _locale=");
        sbU.append(this._locale);
        sbU.append(", fontScale=");
        return a.B(sbU, this.fontScale, ")");
    }
}
