package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsVanityUrl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsVanityUrl$Model {
    public static final WidgetServerSettingsVanityUrl$Model$Companion Companion = new WidgetServerSettingsVanityUrl$Model$Companion(null);
    private final long guildId;
    private final String guildName;
    private final String vanityUrl;
    private final int vanityUrlUses;

    public WidgetServerSettingsVanityUrl$Model(long j, String str, String str2, int i) {
        this.guildId = j;
        this.guildName = str;
        this.vanityUrl = str2;
        this.vanityUrlUses = i;
    }

    public static /* synthetic */ WidgetServerSettingsVanityUrl$Model copy$default(WidgetServerSettingsVanityUrl$Model widgetServerSettingsVanityUrl$Model, long j, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = widgetServerSettingsVanityUrl$Model.guildId;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            str = widgetServerSettingsVanityUrl$Model.guildName;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = widgetServerSettingsVanityUrl$Model.vanityUrl;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            i = widgetServerSettingsVanityUrl$Model.vanityUrlUses;
        }
        return widgetServerSettingsVanityUrl$Model.copy(j2, str3, str4, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVanityUrl() {
        return this.vanityUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getVanityUrlUses() {
        return this.vanityUrlUses;
    }

    public final WidgetServerSettingsVanityUrl$Model copy(long guildId, String guildName, String vanityUrl, int vanityUrlUses) {
        return new WidgetServerSettingsVanityUrl$Model(guildId, guildName, vanityUrl, vanityUrlUses);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsVanityUrl$Model)) {
            return false;
        }
        WidgetServerSettingsVanityUrl$Model widgetServerSettingsVanityUrl$Model = (WidgetServerSettingsVanityUrl$Model) other;
        return this.guildId == widgetServerSettingsVanityUrl$Model.guildId && m.areEqual(this.guildName, widgetServerSettingsVanityUrl$Model.guildName) && m.areEqual(this.vanityUrl, widgetServerSettingsVanityUrl$Model.vanityUrl) && this.vanityUrlUses == widgetServerSettingsVanityUrl$Model.vanityUrlUses;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    public final String getVanityUrl() {
        return this.vanityUrl;
    }

    public final int getVanityUrlUses() {
        return this.vanityUrlUses;
    }

    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        String str = this.guildName;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.vanityUrl;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.vanityUrlUses;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", vanityUrl=");
        sbU.append(this.vanityUrl);
        sbU.append(", vanityUrlUses=");
        return a.B(sbU, this.vanityUrlUses, ")");
    }
}
