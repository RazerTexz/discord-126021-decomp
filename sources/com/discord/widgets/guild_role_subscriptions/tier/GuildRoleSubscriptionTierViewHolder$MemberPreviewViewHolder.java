package com.discord.widgets.guild_role_subscriptions.tier;

import android.view.ViewGroup$LayoutParams;
import b.d.b.a.a;
import com.discord.utilities.color.ColorCompat;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionMemberPreview;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierViewHolder$MemberPreviewViewHolder extends GuildRoleSubscriptionTierViewHolder {
    private final GuildRoleSubscriptionMemberPreview memberPreview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionTierViewHolder$MemberPreviewViewHolder(GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview) {
        super(guildRoleSubscriptionMemberPreview, null);
        m.checkNotNullParameter(guildRoleSubscriptionMemberPreview, "memberPreview");
        this.memberPreview = guildRoleSubscriptionMemberPreview;
        guildRoleSubscriptionMemberPreview.setLayoutParams(new ViewGroup$LayoutParams(-1, -2));
        guildRoleSubscriptionMemberPreview.setBackgroundColor(ColorCompat.getThemedColor(guildRoleSubscriptionMemberPreview, 2130968912));
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final GuildRoleSubscriptionMemberPreview getMemberPreview() {
        return this.memberPreview;
    }

    public static /* synthetic */ GuildRoleSubscriptionTierViewHolder$MemberPreviewViewHolder copy$default(GuildRoleSubscriptionTierViewHolder$MemberPreviewViewHolder guildRoleSubscriptionTierViewHolder$MemberPreviewViewHolder, GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRoleSubscriptionMemberPreview = guildRoleSubscriptionTierViewHolder$MemberPreviewViewHolder.memberPreview;
        }
        return guildRoleSubscriptionTierViewHolder$MemberPreviewViewHolder.copy(guildRoleSubscriptionMemberPreview);
    }

    @Override // com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierViewHolder
    public void bind(GuildRoleSubscriptionTierAdapterItem item) {
        m.checkNotNullParameter(item, "item");
        GuildRoleSubscriptionTierAdapterItem$MemberPreview guildRoleSubscriptionTierAdapterItem$MemberPreview = (GuildRoleSubscriptionTierAdapterItem$MemberPreview) item;
        GuildRoleSubscriptionMemberPreview.setMemberDesign$default(this.memberPreview, guildRoleSubscriptionTierAdapterItem$MemberPreview.getMemberColor(), guildRoleSubscriptionTierAdapterItem$MemberPreview.getMemberIcon(), null, 4, null);
    }

    public final GuildRoleSubscriptionTierViewHolder$MemberPreviewViewHolder copy(GuildRoleSubscriptionMemberPreview memberPreview) {
        m.checkNotNullParameter(memberPreview, "memberPreview");
        return new GuildRoleSubscriptionTierViewHolder$MemberPreviewViewHolder(memberPreview);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildRoleSubscriptionTierViewHolder$MemberPreviewViewHolder) && m.areEqual(this.memberPreview, ((GuildRoleSubscriptionTierViewHolder$MemberPreviewViewHolder) other).memberPreview);
        }
        return true;
    }

    public int hashCode() {
        GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview = this.memberPreview;
        if (guildRoleSubscriptionMemberPreview != null) {
            return guildRoleSubscriptionMemberPreview.hashCode();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ViewHolder
    public String toString() {
        StringBuilder sbU = a.U("MemberPreviewViewHolder(memberPreview=");
        sbU.append(this.memberPreview);
        sbU.append(")");
        return sbU.toString();
    }
}
