package com.discord.widgets.user;

import a0.a.a.b;
import b.d.b.a.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserMentions$Model$MessageLoader$Filters {
    private final boolean allGuilds;
    private final long guildId;
    private final boolean includeEveryone;
    private final boolean includeRoles;

    public WidgetUserMentions$Model$MessageLoader$Filters() {
        this(0L, false, false, false, 15, null);
    }

    public WidgetUserMentions$Model$MessageLoader$Filters(long j, boolean z2, boolean z3, boolean z4) {
        this.guildId = j;
        this.allGuilds = z2;
        this.includeEveryone = z3;
        this.includeRoles = z4;
    }

    public static /* synthetic */ WidgetUserMentions$Model$MessageLoader$Filters copy$default(WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$Filters, long j, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetUserMentions$Model$MessageLoader$Filters.guildId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            z2 = widgetUserMentions$Model$MessageLoader$Filters.allGuilds;
        }
        boolean z5 = z2;
        if ((i & 4) != 0) {
            z3 = widgetUserMentions$Model$MessageLoader$Filters.includeEveryone;
        }
        boolean z6 = z3;
        if ((i & 8) != 0) {
            z4 = widgetUserMentions$Model$MessageLoader$Filters.includeRoles;
        }
        return widgetUserMentions$Model$MessageLoader$Filters.copy(j2, z5, z6, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAllGuilds() {
        return this.allGuilds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIncludeEveryone() {
        return this.includeEveryone;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIncludeRoles() {
        return this.includeRoles;
    }

    public final WidgetUserMentions$Model$MessageLoader$Filters copy(long guildId, boolean allGuilds, boolean includeEveryone, boolean includeRoles) {
        return new WidgetUserMentions$Model$MessageLoader$Filters(guildId, allGuilds, includeEveryone, includeRoles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserMentions$Model$MessageLoader$Filters)) {
            return false;
        }
        WidgetUserMentions$Model$MessageLoader$Filters widgetUserMentions$Model$MessageLoader$Filters = (WidgetUserMentions$Model$MessageLoader$Filters) other;
        return this.guildId == widgetUserMentions$Model$MessageLoader$Filters.guildId && this.allGuilds == widgetUserMentions$Model$MessageLoader$Filters.allGuilds && this.includeEveryone == widgetUserMentions$Model$MessageLoader$Filters.includeEveryone && this.includeRoles == widgetUserMentions$Model$MessageLoader$Filters.includeRoles;
    }

    public final boolean getAllGuilds() {
        return this.allGuilds;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final boolean getIncludeEveryone() {
        return this.includeEveryone;
    }

    public final boolean getIncludeRoles() {
        return this.includeRoles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iA = b.a(this.guildId) * 31;
        boolean z2 = this.allGuilds;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iA + r1) * 31;
        boolean z3 = this.includeEveryone;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.includeRoles;
        return i2 + (z4 ? 1 : z4);
    }

    public String toString() {
        StringBuilder sbU = a.U("Filters(guildId=");
        sbU.append(this.guildId);
        sbU.append(", allGuilds=");
        sbU.append(this.allGuilds);
        sbU.append(", includeEveryone=");
        sbU.append(this.includeEveryone);
        sbU.append(", includeRoles=");
        return a.O(sbU, this.includeRoles, ")");
    }

    public /* synthetic */ WidgetUserMentions$Model$MessageLoader$Filters(long j, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4);
    }
}
