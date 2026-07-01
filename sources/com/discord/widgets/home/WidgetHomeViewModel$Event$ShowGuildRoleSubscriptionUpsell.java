package com.discord.widgets.home;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell extends WidgetHomeViewModel$Event {
    private final long guildId;

    public WidgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell(long j) {
        super(null);
        this.guildId = j;
    }

    public static /* synthetic */ WidgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell copy$default(WidgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell widgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell.guildId;
        }
        return widgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell copy(long guildId) {
        return new WidgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell(guildId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell) && this.guildId == ((WidgetHomeViewModel$Event$ShowGuildRoleSubscriptionUpsell) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return b.a(this.guildId);
    }

    public String toString() {
        return a.C(a.U("ShowGuildRoleSubscriptionUpsell(guildId="), this.guildId, ")");
    }
}
