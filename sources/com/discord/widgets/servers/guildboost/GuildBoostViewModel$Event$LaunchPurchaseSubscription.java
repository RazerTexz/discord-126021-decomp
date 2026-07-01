package com.discord.widgets.servers.guildboost;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostViewModel$Event$LaunchPurchaseSubscription extends GuildBoostViewModel$Event {
    private final long guildId;
    private final String oldSkuName;
    private final String section;

    public /* synthetic */ GuildBoostViewModel$Event$LaunchPurchaseSubscription(String str, long j, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, (i & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ GuildBoostViewModel$Event$LaunchPurchaseSubscription copy$default(GuildBoostViewModel$Event$LaunchPurchaseSubscription guildBoostViewModel$Event$LaunchPurchaseSubscription, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guildBoostViewModel$Event$LaunchPurchaseSubscription.section;
        }
        if ((i & 2) != 0) {
            j = guildBoostViewModel$Event$LaunchPurchaseSubscription.guildId;
        }
        if ((i & 4) != 0) {
            str2 = guildBoostViewModel$Event$LaunchPurchaseSubscription.oldSkuName;
        }
        return guildBoostViewModel$Event$LaunchPurchaseSubscription.copy(str, j, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSection() {
        return this.section;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getOldSkuName() {
        return this.oldSkuName;
    }

    public final GuildBoostViewModel$Event$LaunchPurchaseSubscription copy(String section, long guildId, String oldSkuName) {
        m.checkNotNullParameter(section, "section");
        return new GuildBoostViewModel$Event$LaunchPurchaseSubscription(section, guildId, oldSkuName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostViewModel$Event$LaunchPurchaseSubscription)) {
            return false;
        }
        GuildBoostViewModel$Event$LaunchPurchaseSubscription guildBoostViewModel$Event$LaunchPurchaseSubscription = (GuildBoostViewModel$Event$LaunchPurchaseSubscription) other;
        return m.areEqual(this.section, guildBoostViewModel$Event$LaunchPurchaseSubscription.section) && this.guildId == guildBoostViewModel$Event$LaunchPurchaseSubscription.guildId && m.areEqual(this.oldSkuName, guildBoostViewModel$Event$LaunchPurchaseSubscription.oldSkuName);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getOldSkuName() {
        return this.oldSkuName;
    }

    public final String getSection() {
        return this.section;
    }

    public int hashCode() {
        String str = this.section;
        int iA = (b.a(this.guildId) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        String str2 = this.oldSkuName;
        return iA + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("LaunchPurchaseSubscription(section=");
        sbU.append(this.section);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", oldSkuName=");
        return a.J(sbU, this.oldSkuName, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostViewModel$Event$LaunchPurchaseSubscription(String str, long j, String str2) {
        super(null);
        m.checkNotNullParameter(str, "section");
        this.section = str;
        this.guildId = j;
        this.oldSkuName = str2;
    }
}
