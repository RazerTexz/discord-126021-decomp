package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildRoleSubscriptionBenefitListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionBenefitListItemGeneratorKt {
    public static final List<GuildRoleSubscriptionBenefitAdapterItem> generateGuildRoleSubscriptionBenefitListItems(List<Benefit.ChannelBenefit> list, List<Benefit.IntangibleBenefit> list2, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, long j, String str, Boolean bool, boolean z2, SubscriptionTrialInterval subscriptionTrialInterval, Integer num) {
        C12238m.checkNotNullParameter(list, "channelBenefits");
        C12238m.checkNotNullParameter(list2, "intangibleBenefits");
        C12238m.checkNotNullParameter(guildRoleSubscriptionTierBenefitListType, "benefitListType");
        ArrayList arrayList = new ArrayList();
        if ((!C12238m.areEqual(bool, Boolean.TRUE)) && (guildRoleSubscriptionTierBenefitListType == GuildRoleSubscriptionTierBenefitListType.ALL || guildRoleSubscriptionTierBenefitListType == GuildRoleSubscriptionTierBenefitListType.CHANNEL)) {
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
