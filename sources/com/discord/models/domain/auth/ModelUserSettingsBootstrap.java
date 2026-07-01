package com.discord.models.domain.auth;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelLoginResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelUserSettingsBootstrap {
    private final String locale;
    private final String theme;

    public ModelUserSettingsBootstrap(String str, String str2) {
        this.theme = str;
        this.locale = str2;
    }

    public static /* synthetic */ ModelUserSettingsBootstrap copy$default(ModelUserSettingsBootstrap modelUserSettingsBootstrap, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelUserSettingsBootstrap.theme;
        }
        if ((i & 2) != 0) {
            str2 = modelUserSettingsBootstrap.locale;
        }
        return modelUserSettingsBootstrap.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTheme() {
        return this.theme;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    public final ModelUserSettingsBootstrap copy(String theme, String locale) {
        return new ModelUserSettingsBootstrap(theme, locale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelUserSettingsBootstrap)) {
            return false;
        }
        ModelUserSettingsBootstrap modelUserSettingsBootstrap = (ModelUserSettingsBootstrap) other;
        return m.areEqual(this.theme, modelUserSettingsBootstrap.theme) && m.areEqual(this.locale, modelUserSettingsBootstrap.locale);
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getTheme() {
        return this.theme;
    }

    public int hashCode() {
        String str = this.theme;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.locale;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelUserSettingsBootstrap(theme=");
        sbU.append(this.theme);
        sbU.append(", locale=");
        return a.J(sbU, this.locale, ")");
    }
}
