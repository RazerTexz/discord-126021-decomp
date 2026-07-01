package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionBenefitListItemGeneratorKt, reason: use source file name */
/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitListItemGenerator {
    public static final List<GuildRoleSubscriptionBenefitAdapterItem> generateGuildRoleSubscriptionBenefitListItems(List<Benefit.ChannelBenefit> list, List<Benefit.IntangibleBenefit> list2, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, long j, String str, Boolean bool, boolean z2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num) {
        Intrinsics3.checkNotNullParameter(list, "channelBenefits");
        Intrinsics3.checkNotNullParameter(list2, "intangibleBenefits");
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierBenefitListType, "benefitListType");
        ArrayList arrayList = new ArrayList();
        if ((!Intrinsics3.areEqual(bool, Boolean.TRUE)) && (guildRoleSubscriptionTierBenefitListType == GuildRoleSubscriptionTierBenefitListType.ALL || guildRoleSubscriptionTierBenefitListType == GuildRoleSubscriptionTierBenefitListType.CHANNEL)) {
            arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.Header(GuildRoleSubscriptionBenefitType.CHANNEL));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.BenefitItem(GuildRoleSubscriptionBenefitType.CHANNEL, (Benefit.ChannelBenefit) it.next(), j, str));
            }
            arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem(GuildRoleSubscriptionBenefitType.CHANNEL, j, str));
        }
        if (guildRoleSubscriptionTierBenefitListType == GuildRoleSubscriptionTierBenefitListType.ALL || guildRoleSubscriptionTierBenefitListType == GuildRoleSubscriptionTierBenefitListType.INTANGIBLE) {
            arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.Header(GuildRoleSubscriptionBenefitType.INTANGIBLE));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.BenefitItem(GuildRoleSubscriptionBenefitType.INTANGIBLE, (Benefit.IntangibleBenefit) it2.next(), j, str));
            }
            arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.AddBenefitItem(GuildRoleSubscriptionBenefitType.INTANGIBLE, j, str));
        }
        if (z2) {
            arrayList.add(new GuildRoleSubscriptionBenefitAdapterItem.FreeTrialItem(subscriptionTrialInterval != null, subscriptionTrialInterval, num));
        }
        return arrayList;
    }
}
