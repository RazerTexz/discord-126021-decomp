package com.discord.widgets.guild_role_subscriptions.tier;

import com.discord.R;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierListItemGeneratorKt, reason: use source file name */
/* JADX INFO: compiled from: GuildRoleSubscriptionTierListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionTierListItemGenerator {
    public static final List<GuildRoleSubscriptionTierAdapterItem> generateGuildRoleSubscriptionReviewListItems(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean bool, Integer num, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (!(str == null || StringsJVM.isBlank(str))) {
            if (!(str2 == null || StringsJVM.isBlank(str2))) {
                arrayList.add(new GuildRoleSubscriptionTierAdapterItem.PlanDetails(str, str2));
            }
        }
        if (guildRoleSubscriptionTier != null) {
            arrayList.add(new GuildRoleSubscriptionTierAdapterItem.Header(guildRoleSubscriptionTier.getName(), guildRoleSubscriptionTier.getPriceTier(), null, guildRoleSubscriptionTier.getImage(), guildRoleSubscriptionTier.getDescription(), 4, null));
            arrayList.add(new GuildRoleSubscriptionTierAdapterItem.MemberPreview(guildRoleSubscriptionTier.getMemberColor(), guildRoleSubscriptionTier.getMemberIcon()));
            if (guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(bool)) {
                if (num == null) {
                    arrayList.add(new GuildRoleSubscriptionTierAdapterItem.SectionHeader(Integer.valueOf(R.string.guild_role_subscription_setup_channel_benefits_channels_title), null, null));
                } else {
                    arrayList.add(new GuildRoleSubscriptionTierAdapterItem.SectionHeader(null, Integer.valueOf(R.plurals.guild_role_subscription_tier_review_exclusive_channel_header_count), num));
                }
                arrayList.add(GuildRoleSubscriptionTierAdapterItem.AllChannelsAccessBenefitItem.INSTANCE);
            } else if (!guildRoleSubscriptionTier.getChannelBenefits().isEmpty()) {
                arrayList.add(new GuildRoleSubscriptionTierAdapterItem.SectionHeader(null, Integer.valueOf(R.plurals.guild_role_subscription_tier_review_exclusive_channel_header_count), Integer.valueOf(guildRoleSubscriptionTier.getChannelBenefits().size())));
                int i2 = 0;
                for (Object obj : guildRoleSubscriptionTier.getChannelBenefits()) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        Collections2.throwIndexOverflow();
                    }
                    arrayList.add(new GuildRoleSubscriptionTierAdapterItem.BenefitItem(i2, (Benefit.ChannelBenefit) obj));
                    i2 = i3;
                }
            }
            if (!guildRoleSubscriptionTier.getIntangibleBenefits().isEmpty()) {
                arrayList.add(new GuildRoleSubscriptionTierAdapterItem.SectionHeader(null, Integer.valueOf(R.plurals.guild_role_subscription_tier_review_intangible_benefits_header_count), Integer.valueOf(guildRoleSubscriptionTier.getIntangibleBenefits().size())));
                for (Object obj2 : guildRoleSubscriptionTier.getIntangibleBenefits()) {
                    int i4 = i + 1;
                    if (i < 0) {
                        Collections2.throwIndexOverflow();
                    }
                    arrayList.add(new GuildRoleSubscriptionTierAdapterItem.BenefitItem(guildRoleSubscriptionTier.getChannelBenefits().size() + i, (Benefit.IntangibleBenefit) obj2));
                    i = i4;
                }
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List generateGuildRoleSubscriptionReviewListItems$default(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean bool, Integer num, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        if ((i & 16) != 0) {
            str2 = null;
        }
        return generateGuildRoleSubscriptionReviewListItems(guildRoleSubscriptionTier, bool, num, str, str2);
    }
}
