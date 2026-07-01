package com.discord.widgets.settings;

import b.d.b.a.a;
import com.discord.models.user.MeUser;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsAppearance$Model {
    public static final WidgetSettingsAppearance$Model$Companion Companion = new WidgetSettingsAppearance$Model$Companion(null);
    private final boolean canSeePureEvil;
    private final String currentTheme;
    private final int fontScale;
    private final MeUser meUser;

    public WidgetSettingsAppearance$Model(String str, boolean z2, int i, MeUser meUser) {
        m.checkNotNullParameter(str, "currentTheme");
        m.checkNotNullParameter(meUser, "meUser");
        this.currentTheme = str;
        this.canSeePureEvil = z2;
        this.fontScale = i;
        this.meUser = meUser;
    }

    public static /* synthetic */ WidgetSettingsAppearance$Model copy$default(WidgetSettingsAppearance$Model widgetSettingsAppearance$Model, String str, boolean z2, int i, MeUser meUser, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = widgetSettingsAppearance$Model.currentTheme;
        }
        if ((i2 & 2) != 0) {
            z2 = widgetSettingsAppearance$Model.canSeePureEvil;
        }
        if ((i2 & 4) != 0) {
            i = widgetSettingsAppearance$Model.fontScale;
        }
        if ((i2 & 8) != 0) {
            meUser = widgetSettingsAppearance$Model.meUser;
        }
        return widgetSettingsAppearance$Model.copy(str, z2, i, meUser);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCurrentTheme() {
        return this.currentTheme;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getCanSeePureEvil() {
        return this.canSeePureEvil;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getFontScale() {
        return this.fontScale;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final WidgetSettingsAppearance$Model copy(String currentTheme, boolean canSeePureEvil, int fontScale, MeUser meUser) {
        m.checkNotNullParameter(currentTheme, "currentTheme");
        m.checkNotNullParameter(meUser, "meUser");
        return new WidgetSettingsAppearance$Model(currentTheme, canSeePureEvil, fontScale, meUser);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSettingsAppearance$Model)) {
            return false;
        }
        WidgetSettingsAppearance$Model widgetSettingsAppearance$Model = (WidgetSettingsAppearance$Model) other;
        return m.areEqual(this.currentTheme, widgetSettingsAppearance$Model.currentTheme) && this.canSeePureEvil == widgetSettingsAppearance$Model.canSeePureEvil && this.fontScale == widgetSettingsAppearance$Model.fontScale && m.areEqual(this.meUser, widgetSettingsAppearance$Model.meUser);
    }

    public final boolean getCanSeePureEvil() {
        return this.canSeePureEvil;
    }

    public final String getCurrentTheme() {
        return this.currentTheme;
    }

    public final int getFontScale() {
        return this.fontScale;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public int hashCode() {
        String str = this.currentTheme;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.canSeePureEvil;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (((iHashCode + r2) * 31) + this.fontScale) * 31;
        MeUser meUser = this.meUser;
        return i + (meUser != null ? meUser.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(currentTheme=");
        sbU.append(this.currentTheme);
        sbU.append(", canSeePureEvil=");
        sbU.append(this.canSeePureEvil);
        sbU.append(", fontScale=");
        sbU.append(this.fontScale);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(")");
        return sbU.toString();
    }
}
