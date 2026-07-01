package com.discord.widgets.servers;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsSecurity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsSecurity$Model {
    public static final WidgetServerSettingsSecurity$Model$Companion Companion = new WidgetServerSettingsSecurity$Model$Companion(null);
    private final long guildId;
    private final String guildName;
    private final boolean isMfaEnabled;

    public WidgetServerSettingsSecurity$Model(long j, String str, boolean z2) {
        this.guildId = j;
        this.guildName = str;
        this.isMfaEnabled = z2;
    }

    public static /* synthetic */ WidgetServerSettingsSecurity$Model copy$default(WidgetServerSettingsSecurity$Model widgetServerSettingsSecurity$Model, long j, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetServerSettingsSecurity$Model.guildId;
        }
        if ((i & 2) != 0) {
            str = widgetServerSettingsSecurity$Model.guildName;
        }
        if ((i & 4) != 0) {
            z2 = widgetServerSettingsSecurity$Model.isMfaEnabled;
        }
        return widgetServerSettingsSecurity$Model.copy(j, str, z2);
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
    public final boolean getIsMfaEnabled() {
        return this.isMfaEnabled;
    }

    public final WidgetServerSettingsSecurity$Model copy(long guildId, String guildName, boolean isMfaEnabled) {
        return new WidgetServerSettingsSecurity$Model(guildId, guildName, isMfaEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsSecurity$Model)) {
            return false;
        }
        WidgetServerSettingsSecurity$Model widgetServerSettingsSecurity$Model = (WidgetServerSettingsSecurity$Model) other;
        return this.guildId == widgetServerSettingsSecurity$Model.guildId && m.areEqual(this.guildName, widgetServerSettingsSecurity$Model.guildName) && this.isMfaEnabled == widgetServerSettingsSecurity$Model.isMfaEnabled;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        String str = this.guildName;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.isMfaEnabled;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isMfaEnabled() {
        return this.isMfaEnabled;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", isMfaEnabled=");
        return a.O(sbU, this.isMfaEnabled, ")");
    }
}
