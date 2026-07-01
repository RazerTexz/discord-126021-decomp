package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import androidx.annotation.DrawableRes;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: GuildRoleSubscriptionTierBenefitViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildRoleSubscriptionTierBenefitViewModel$ViewState {
    private final boolean canSubmitResult;
    private final Long channelId;
    private final String description;
    private final Emoji emoji;
    private final Integer leadingNameIconResId;
    private final String name;
    private final String tierName;

    public GuildRoleSubscriptionTierBenefitViewModel$ViewState() {
        this(false, null, null, null, null, null, null, Opcodes.LAND, null);
    }

    public GuildRoleSubscriptionTierBenefitViewModel$ViewState(boolean z2, String str, String str2, @DrawableRes Integer num, Emoji emoji, String str3, Long l) {
        this.canSubmitResult = z2;
        this.name = str;
        this.tierName = str2;
        this.leadingNameIconResId = num;
        this.emoji = emoji;
        this.description = str3;
        this.channelId = l;
    }

    public static /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel$ViewState copy$default(GuildRoleSubscriptionTierBenefitViewModel$ViewState guildRoleSubscriptionTierBenefitViewModel$ViewState, boolean z2, String str, String str2, Integer num, Emoji emoji, String str3, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = guildRoleSubscriptionTierBenefitViewModel$ViewState.canSubmitResult;
        }
        if ((i & 2) != 0) {
            str = guildRoleSubscriptionTierBenefitViewModel$ViewState.name;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = guildRoleSubscriptionTierBenefitViewModel$ViewState.tierName;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            num = guildRoleSubscriptionTierBenefitViewModel$ViewState.leadingNameIconResId;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            emoji = guildRoleSubscriptionTierBenefitViewModel$ViewState.emoji;
        }
        Emoji emoji2 = emoji;
        if ((i & 32) != 0) {
            str3 = guildRoleSubscriptionTierBenefitViewModel$ViewState.description;
        }
        String str6 = str3;
        if ((i & 64) != 0) {
            l = guildRoleSubscriptionTierBenefitViewModel$ViewState.channelId;
        }
        return guildRoleSubscriptionTierBenefitViewModel$ViewState.copy(z2, str4, str5, num2, emoji2, str6, l);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getCanSubmitResult() {
        return this.canSubmitResult;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTierName() {
        return this.tierName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getLeadingNameIconResId() {
        return this.leadingNameIconResId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Emoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getChannelId() {
        return this.channelId;
    }

    public final GuildRoleSubscriptionTierBenefitViewModel$ViewState copy(boolean canSubmitResult, String name, String tierName, @DrawableRes Integer leadingNameIconResId, Emoji emoji, String description, Long channelId) {
        return new GuildRoleSubscriptionTierBenefitViewModel$ViewState(canSubmitResult, name, tierName, leadingNameIconResId, emoji, description, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleSubscriptionTierBenefitViewModel$ViewState)) {
            return false;
        }
        GuildRoleSubscriptionTierBenefitViewModel$ViewState guildRoleSubscriptionTierBenefitViewModel$ViewState = (GuildRoleSubscriptionTierBenefitViewModel$ViewState) other;
        return this.canSubmitResult == guildRoleSubscriptionTierBenefitViewModel$ViewState.canSubmitResult && m.areEqual(this.name, guildRoleSubscriptionTierBenefitViewModel$ViewState.name) && m.areEqual(this.tierName, guildRoleSubscriptionTierBenefitViewModel$ViewState.tierName) && m.areEqual(this.leadingNameIconResId, guildRoleSubscriptionTierBenefitViewModel$ViewState.leadingNameIconResId) && m.areEqual(this.emoji, guildRoleSubscriptionTierBenefitViewModel$ViewState.emoji) && m.areEqual(this.description, guildRoleSubscriptionTierBenefitViewModel$ViewState.description) && m.areEqual(this.channelId, guildRoleSubscriptionTierBenefitViewModel$ViewState.channelId);
    }

    public final boolean getCanSubmitResult() {
        return this.canSubmitResult;
    }

    public final Long getChannelId() {
        return this.channelId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Emoji getEmoji() {
        return this.emoji;
    }

    public final Integer getLeadingNameIconResId() {
        return this.leadingNameIconResId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTierName() {
        return this.tierName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean z2 = this.canSubmitResult;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.tierName;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.leadingNameIconResId;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Emoji emoji = this.emoji;
        int iHashCode4 = (iHashCode3 + (emoji != null ? emoji.hashCode() : 0)) * 31;
        String str3 = this.description;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l = this.channelId;
        return iHashCode5 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(canSubmitResult=");
        sbU.append(this.canSubmitResult);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", tierName=");
        sbU.append(this.tierName);
        sbU.append(", leadingNameIconResId=");
        sbU.append(this.leadingNameIconResId);
        sbU.append(", emoji=");
        sbU.append(this.emoji);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", channelId=");
        return a.G(sbU, this.channelId, ")");
    }

    public /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel$ViewState(boolean z2, String str, String str2, Integer num, Emoji emoji, String str3, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : emoji, (i & 32) != 0 ? null : str3, (i & 64) == 0 ? l : null);
    }
}
