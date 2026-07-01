package com.discord.widgets.guild_role_subscriptions.tier;

import androidx.annotation.ColorInt;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierAdapterItem$MemberPreview extends GuildRoleSubscriptionTierAdapterItem {
    private final String key;
    private final Integer memberColor;
    private final String memberIcon;

    public /* synthetic */ GuildRoleSubscriptionTierAdapterItem$MemberPreview(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i & 2) != 0 ? null : str);
    }

    public static /* synthetic */ GuildRoleSubscriptionTierAdapterItem$MemberPreview copy$default(GuildRoleSubscriptionTierAdapterItem$MemberPreview guildRoleSubscriptionTierAdapterItem$MemberPreview, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = guildRoleSubscriptionTierAdapterItem$MemberPreview.memberColor;
        }
        if ((i & 2) != 0) {
            str = guildRoleSubscriptionTierAdapterItem$MemberPreview.memberIcon;
        }
        return guildRoleSubscriptionTierAdapterItem$MemberPreview.copy(num, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getMemberColor() {
        return this.memberColor;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMemberIcon() {
        return this.memberIcon;
    }

    public final GuildRoleSubscriptionTierAdapterItem$MemberPreview copy(@ColorInt Integer memberColor, String memberIcon) {
        return new GuildRoleSubscriptionTierAdapterItem$MemberPreview(memberColor, memberIcon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierAdapterItem$MemberPreview)) {
            return false;
        }
        GuildRoleSubscriptionTierAdapterItem$MemberPreview guildRoleSubscriptionTierAdapterItem$MemberPreview = (GuildRoleSubscriptionTierAdapterItem$MemberPreview) other;
        return m.areEqual(this.memberColor, guildRoleSubscriptionTierAdapterItem$MemberPreview.memberColor) && m.areEqual(this.memberIcon, guildRoleSubscriptionTierAdapterItem$MemberPreview.memberIcon);
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final Integer getMemberColor() {
        return this.memberColor;
    }

    public final String getMemberIcon() {
        return this.memberIcon;
    }

    public int hashCode() {
        Integer num = this.memberColor;
        int iHashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.memberIcon;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("MemberPreview(memberColor=");
        sbU.append(this.memberColor);
        sbU.append(", memberIcon=");
        return a.J(sbU, this.memberIcon, ")");
    }

    public GuildRoleSubscriptionTierAdapterItem$MemberPreview(@ColorInt Integer num, String str) {
        super(null);
        this.memberColor = num;
        this.memberIcon = str;
        this.key = "member:" + num;
    }
}
