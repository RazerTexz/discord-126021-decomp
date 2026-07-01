package com.discord.api.role;

import b.d.b.a.a;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.m;
import java.io.Serializable;

/* JADX INFO: compiled from: GuildRoleTags.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildRoleTags implements Serializable {
    private final String botId;
    private final String integrationId;
    private final NullSerializable<Object> premiumSubscriber;
    private final NullSerializable<Object> purchasableOrHasSubscribers;
    private final String skuId;
    private final String subscriptionListingId;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getSubscriptionListingId() {
        return this.subscriptionListingId;
    }

    public final boolean b() {
        return this.purchasableOrHasSubscribers != null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleTags)) {
            return false;
        }
        GuildRoleTags guildRoleTags = (GuildRoleTags) other;
        return m.areEqual(this.premiumSubscriber, guildRoleTags.premiumSubscriber) && m.areEqual(this.botId, guildRoleTags.botId) && m.areEqual(this.integrationId, guildRoleTags.integrationId) && m.areEqual(this.skuId, guildRoleTags.skuId) && m.areEqual(this.subscriptionListingId, guildRoleTags.subscriptionListingId) && m.areEqual(this.purchasableOrHasSubscribers, guildRoleTags.purchasableOrHasSubscribers);
    }

    public int hashCode() {
        NullSerializable<Object> nullSerializable = this.premiumSubscriber;
        int iHashCode = (nullSerializable != null ? nullSerializable.hashCode() : 0) * 31;
        String str = this.botId;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.integrationId;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.skuId;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.subscriptionListingId;
        int iHashCode5 = (iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        NullSerializable<Object> nullSerializable2 = this.purchasableOrHasSubscribers;
        return iHashCode5 + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildRoleTags(premiumSubscriber=");
        sbU.append(this.premiumSubscriber);
        sbU.append(", botId=");
        sbU.append(this.botId);
        sbU.append(", integrationId=");
        sbU.append(this.integrationId);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", subscriptionListingId=");
        sbU.append(this.subscriptionListingId);
        sbU.append(", purchasableOrHasSubscribers=");
        sbU.append(this.purchasableOrHasSubscribers);
        sbU.append(")");
        return sbU.toString();
    }
}
