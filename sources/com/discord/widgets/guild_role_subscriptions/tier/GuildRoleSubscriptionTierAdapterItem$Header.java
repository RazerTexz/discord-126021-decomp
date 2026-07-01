package com.discord.widgets.guild_role_subscriptions.tier;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierAdapterItem$Header extends GuildRoleSubscriptionTierAdapterItem {
    private final String description;
    private final String image;
    private final String key;
    private final String name;
    private final Integer price;
    private final Long skuId;

    public /* synthetic */ GuildRoleSubscriptionTierAdapterItem$Header(String str, Integer num, Long l, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, num, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
    }

    public static /* synthetic */ GuildRoleSubscriptionTierAdapterItem$Header copy$default(GuildRoleSubscriptionTierAdapterItem$Header guildRoleSubscriptionTierAdapterItem$Header, String str, Integer num, Long l, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guildRoleSubscriptionTierAdapterItem$Header.name;
        }
        if ((i & 2) != 0) {
            num = guildRoleSubscriptionTierAdapterItem$Header.price;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            l = guildRoleSubscriptionTierAdapterItem$Header.skuId;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            str2 = guildRoleSubscriptionTierAdapterItem$Header.image;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = guildRoleSubscriptionTierAdapterItem$Header.description;
        }
        return guildRoleSubscriptionTierAdapterItem$Header.copy(str, num2, l2, str4, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getSkuId() {
        return this.skuId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final GuildRoleSubscriptionTierAdapterItem$Header copy(String name, Integer price, Long skuId, String image, String description) {
        return new GuildRoleSubscriptionTierAdapterItem$Header(name, price, skuId, image, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierAdapterItem$Header)) {
            return false;
        }
        GuildRoleSubscriptionTierAdapterItem$Header guildRoleSubscriptionTierAdapterItem$Header = (GuildRoleSubscriptionTierAdapterItem$Header) other;
        return m.areEqual(this.name, guildRoleSubscriptionTierAdapterItem$Header.name) && m.areEqual(this.price, guildRoleSubscriptionTierAdapterItem$Header.price) && m.areEqual(this.skuId, guildRoleSubscriptionTierAdapterItem$Header.skuId) && m.areEqual(this.image, guildRoleSubscriptionTierAdapterItem$Header.image) && m.areEqual(this.description, guildRoleSubscriptionTierAdapterItem$Header.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getImage() {
        return this.image;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getPrice() {
        return this.price;
    }

    public final Long getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.price;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 31;
        Long l = this.skuId;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        String str2 = this.image;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Header(name=");
        sbU.append(this.name);
        sbU.append(", price=");
        sbU.append(this.price);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", image=");
        sbU.append(this.image);
        sbU.append(", description=");
        return a.J(sbU, this.description, ")");
    }

    public GuildRoleSubscriptionTierAdapterItem$Header(String str, Integer num, Long l, String str2, String str3) {
        super(null);
        this.name = str;
        this.price = num;
        this.skuId = l;
        this.image = str2;
        this.description = str3;
        this.key = a.w("header:", str);
    }
}
