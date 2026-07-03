package com.discord.api.role;

import com.discord.nullserializable.NullSerializable;
import java.io.Serializable;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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

    /* JADX INFO: renamed from: b */
    public final boolean m8210b() {
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
        return C12238m.areEqual(this.premiumSubscriber, guildRoleTags.premiumSubscriber) && C12238m.areEqual(this.botId, guildRoleTags.botId) && C12238m.areEqual(this.integrationId, guildRoleTags.integrationId) && C12238m.areEqual(this.skuId, guildRoleTags.skuId) && C12238m.areEqual(this.subscriptionListingId, guildRoleTags.subscriptionListingId) && C12238m.areEqual(this.purchasableOrHasSubscribers, guildRoleTags.purchasableOrHasSubscribers);
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
        StringBuilder sbM833U = C1643a.m833U("GuildRoleTags(premiumSubscriber=");
        sbM833U.append(this.premiumSubscriber);
        sbM833U.append(", botId=");
        sbM833U.append(this.botId);
        sbM833U.append(", integrationId=");
        sbM833U.append(this.integrationId);
        sbM833U.append(", skuId=");
        sbM833U.append(this.skuId);
        sbM833U.append(", subscriptionListingId=");
        sbM833U.append(this.subscriptionListingId);
        sbM833U.append(", purchasableOrHasSubscribers=");
        sbM833U.append(this.purchasableOrHasSubscribers);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
