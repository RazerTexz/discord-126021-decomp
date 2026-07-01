package com.discord.models.domain.auth;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.models.domain.auth.ModelUserSettingsBootstrap, reason: use source file name */
/* JADX INFO: compiled from: ModelLoginResult.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelLoginResult2 {
    private final String locale;
    private final String theme;

    public ModelLoginResult2(String str, String str2) {
        this.theme = str;
        this.locale = str2;
    }

    public static /* synthetic */ ModelLoginResult2 copy$default(ModelLoginResult2 modelLoginResult2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelLoginResult2.theme;
        }
        if ((i & 2) != 0) {
            str2 = modelLoginResult2.locale;
        }
        return modelLoginResult2.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTheme() {
        return this.theme;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLocale() {
        return this.locale;
    }

    public final ModelLoginResult2 copy(String theme, String locale) {
        return new ModelLoginResult2(theme, locale);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelLoginResult2)) {
            return false;
        }
        ModelLoginResult2 modelLoginResult2 = (ModelLoginResult2) other;
        return Intrinsics3.areEqual(this.theme, modelLoginResult2.theme) && Intrinsics3.areEqual(this.locale, modelLoginResult2.locale);
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
        StringBuilder sbU = outline.U("ModelUserSettingsBootstrap(theme=");
        sbU.append(this.theme);
        sbU.append(", locale=");
        return outline.J(sbU, this.locale, ")");
    }
}
