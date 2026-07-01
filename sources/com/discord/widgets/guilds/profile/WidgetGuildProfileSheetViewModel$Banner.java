package com.discord.widgets.guilds.profile;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildProfileSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildProfileSheetViewModel$Banner {
    private final long guildId;
    private final String hash;
    private final WidgetGuildProfileSheetViewModel$Banner$Type type;

    public WidgetGuildProfileSheetViewModel$Banner(long j, String str, WidgetGuildProfileSheetViewModel$Banner$Type widgetGuildProfileSheetViewModel$Banner$Type) {
        m.checkNotNullParameter(widgetGuildProfileSheetViewModel$Banner$Type, "type");
        this.guildId = j;
        this.hash = str;
        this.type = widgetGuildProfileSheetViewModel$Banner$Type;
    }

    public static /* synthetic */ WidgetGuildProfileSheetViewModel$Banner copy$default(WidgetGuildProfileSheetViewModel$Banner widgetGuildProfileSheetViewModel$Banner, long j, String str, WidgetGuildProfileSheetViewModel$Banner$Type widgetGuildProfileSheetViewModel$Banner$Type, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetGuildProfileSheetViewModel$Banner.guildId;
        }
        if ((i & 2) != 0) {
            str = widgetGuildProfileSheetViewModel$Banner.hash;
        }
        if ((i & 4) != 0) {
            widgetGuildProfileSheetViewModel$Banner$Type = widgetGuildProfileSheetViewModel$Banner.type;
        }
        return widgetGuildProfileSheetViewModel$Banner.copy(j, str, widgetGuildProfileSheetViewModel$Banner$Type);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final WidgetGuildProfileSheetViewModel$Banner$Type getType() {
        return this.type;
    }

    public final WidgetGuildProfileSheetViewModel$Banner copy(long guildId, String hash, WidgetGuildProfileSheetViewModel$Banner$Type type) {
        m.checkNotNullParameter(type, "type");
        return new WidgetGuildProfileSheetViewModel$Banner(guildId, hash, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildProfileSheetViewModel$Banner)) {
            return false;
        }
        WidgetGuildProfileSheetViewModel$Banner widgetGuildProfileSheetViewModel$Banner = (WidgetGuildProfileSheetViewModel$Banner) other;
        return this.guildId == widgetGuildProfileSheetViewModel$Banner.guildId && m.areEqual(this.hash, widgetGuildProfileSheetViewModel$Banner.hash) && m.areEqual(this.type, widgetGuildProfileSheetViewModel$Banner.type);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getHash() {
        return this.hash;
    }

    public final WidgetGuildProfileSheetViewModel$Banner$Type getType() {
        return this.type;
    }

    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        String str = this.hash;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        WidgetGuildProfileSheetViewModel$Banner$Type widgetGuildProfileSheetViewModel$Banner$Type = this.type;
        return iHashCode + (widgetGuildProfileSheetViewModel$Banner$Type != null ? widgetGuildProfileSheetViewModel$Banner$Type.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Banner(guildId=");
        sbU.append(this.guildId);
        sbU.append(", hash=");
        sbU.append(this.hash);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(")");
        return sbU.toString();
    }
}
