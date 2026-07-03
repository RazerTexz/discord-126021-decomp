package com.discord.utilities.premium;

import com.discord.api.guild.GuildFeature;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.guilds.GuildConstantsKt;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p507d0.p508a0.C11210a;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: GuildBoostUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostUtils {
    public static final int DEFAULT_GUILD_BOOST_GUILD_COUNT = 1;
    public static final int DEFAULT_GUILD_BOOST_SLOT_COUNT = 1;
    public static final int GUILD_BOOST_COOLDOWN_DAYS = 7;
    public static final GuildBoostUtils INSTANCE = new GuildBoostUtils();

    /* JADX INFO: compiled from: GuildBoostUtils.kt */
    public enum ModifyGuildBoostSlotResult {
        SUCCESS,
        FAILURE_MODIFYING_SLOT,
        FAILURE_UPDATING_SUBSCRIPTION
    }

    private GuildBoostUtils() {
    }

    public static /* synthetic */ int calculatePercentToNextTier$default(GuildBoostUtils guildBoostUtils, long j, int i, int i2, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i3 & 16) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.calculatePercentToNextTier(j, i, i2, storeExperiments2, storeGuilds);
    }

    public static /* synthetic */ int calculateTotalProgress$default(GuildBoostUtils guildBoostUtils, long j, int i, int i2, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i3 & 16) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.calculateTotalProgress(j, i, i2, storeExperiments2, storeGuilds);
    }

    public static /* synthetic */ int getBoostTier$default(GuildBoostUtils guildBoostUtils, long j, int i, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i2 & 8) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.getBoostTier(j, i, storeExperiments2, storeGuilds);
    }

    private final GuildBoostTierAmounts getBoostTierAmounts(long guildId, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Guild guild = storeGuilds.getGuild(guildId);
        boolean z2 = false;
        boolean z3 = guild != null && guild.hasFeature(GuildFeature.BOOSTING_TIERS_EXPERIMENT_SMALL_GUILD);
        Guild guild2 = storeGuilds.getGuild(guildId);
        if (guild2 != null && guild2.hasFeature(GuildFeature.BOOSTING_TIERS_EXPERIMENT_MEDIUM_GUILD)) {
            z2 = true;
        }
        Experiment guildExperiment = storeExperiments.getGuildExperiment("2022-03_boosting_tiers_small_guilds", guildId, z3);
        Experiment guildExperiment2 = storeExperiments.getGuildExperiment("2022-03_boosting_tiers_medium_guilds", guildId, z2);
        if (!z3 || ((guildExperiment == null || guildExperiment.getBucket() != 1) && (guildExperiment == null || guildExperiment.getBucket() != 2))) {
            return (!z2 || ((guildExperiment2 == null || guildExperiment2.getBucket() != 1) && (guildExperiment2 == null || guildExperiment2.getBucket() != 2))) ? GuildConstantsKt.getGUILD_BOOST_TIER_AMOUNTS() : GuildConstantsKt.getGUILD_BOOST_TIER_AMOUNTS_EXP_MEDIUM_GUILDS();
        }
        return GuildConstantsKt.getGUILD_BOOST_TIER_AMOUNTS_EXP_SMALL_GUILDS();
    }

    public static /* synthetic */ int getBoostsRequiredForTier$default(GuildBoostUtils guildBoostUtils, long j, int i, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            storeExperiments = StoreStream.INSTANCE.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i2 & 8) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        return guildBoostUtils.getBoostsRequiredForTier(j, i, storeExperiments2, storeGuilds);
    }

    private final int getCurrentTierSubs(GuildBoostTierAmounts boostTierAmounts, int premiumTier) {
        if (premiumTier == 1) {
            return boostTierAmounts.getTier1Boosts();
        }
        if (premiumTier == 2) {
            return boostTierAmounts.getTier2Boosts();
        }
        if (premiumTier != 3) {
            return 0;
        }
        return boostTierAmounts.getTier3Boosts();
    }

    private final int getNextTierSubs(GuildBoostTierAmounts boostTierAmounts, int premiumTier) {
        if (premiumTier == 1) {
            return boostTierAmounts.getTier2Boosts();
        }
        if (premiumTier == 2) {
            return boostTierAmounts.getTier3Boosts();
        }
        if (premiumTier != 3) {
            return boostTierAmounts.getTier1Boosts();
        }
        return 0;
    }

    private final Observable<ModifyGuildBoostSlotResult> modifyGuildBoostSlot(final RestAPI api, long slotId, final ModelSubscription subscription, final boolean cancel, final StoreGuildBoost storeGuildBoost) {
        Observable<ModifyGuildBoostSlotResult> observableM11082A = (cancel ? api.cancelSubscriptionSlot(slotId) : api.uncancelSubscriptionSlot(slotId)).m11098X(C12781a.m10875c()).m11115u(new Action1<ModelGuildBoostSlot>() { // from class: com.discord.utilities.premium.GuildBoostUtils.modifyGuildBoostSlot.1
            @Override // p658rx.functions.Action1
            public final void call(ModelGuildBoostSlot modelGuildBoostSlot) {
                StoreGuildBoost storeGuildBoost2 = storeGuildBoost;
                C12238m.checkNotNullExpressionValue(modelGuildBoostSlot, "it");
                storeGuildBoost2.updateGuildBoostSlot(modelGuildBoostSlot);
            }
        }).m11083G(new InterfaceC12589b<ModelGuildBoostSlot, Boolean>() { // from class: com.discord.utilities.premium.GuildBoostUtils.modifyGuildBoostSlot.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(ModelGuildBoostSlot modelGuildBoostSlot) {
                return Boolean.TRUE;
            }
        }).m11087M(new InterfaceC12589b<Throwable, Boolean>() { // from class: com.discord.utilities.premium.GuildBoostUtils.modifyGuildBoostSlot.3
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Throwable th) {
                return Boolean.FALSE;
            }
        }).m11082A(new InterfaceC12589b<Boolean, Observable<? extends ModifyGuildBoostSlotResult>>() { // from class: com.discord.utilities.premium.GuildBoostUtils.modifyGuildBoostSlot.4
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends ModifyGuildBoostSlotResult> call(Boolean bool) {
                if (bool.booleanValue()) {
                    return api.updateSubscription(subscription.getId(), new RestAPIParams.UpdateSubscription(null, null, null, GuildBoostUtils.INSTANCE.calculateAdditionalPlansWithGuildBoostAdjustment(subscription, cancel ? -1 : 1), 7, null)).m11083G(new InterfaceC12589b<Void, ModifyGuildBoostSlotResult>() { // from class: com.discord.utilities.premium.GuildBoostUtils.modifyGuildBoostSlot.4.1
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final ModifyGuildBoostSlotResult call(Void r1) {
                            return ModifyGuildBoostSlotResult.SUCCESS;
                        }
                    }).m11087M(new InterfaceC12589b<Throwable, ModifyGuildBoostSlotResult>() { // from class: com.discord.utilities.premium.GuildBoostUtils.modifyGuildBoostSlot.4.2
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final ModifyGuildBoostSlotResult call(Throwable th) {
                            return ModifyGuildBoostSlotResult.FAILURE_UPDATING_SUBSCRIPTION;
                        }
                    });
                }
                return new C12721k(ModifyGuildBoostSlotResult.FAILURE_MODIFYING_SLOT);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11082A, "apiObs\n        .subscrib…N }\n          }\n        }");
        return observableM11082A;
    }

    public final List<ModelSubscription.SubscriptionAdditionalPlan> calculateAdditionalPlansWithGuildBoostAdjustment(ModelSubscription subscription, int guildBoostAdjustment) {
        Object next;
        ModelSubscription.SubscriptionAdditionalPlan subscriptionAdditionalPlan;
        C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
        ModelSubscription.SubscriptionRenewalMutations renewalMutations = subscription.getRenewalMutations();
        List<ModelSubscription.SubscriptionAdditionalPlan> premiumAdditionalPlans = renewalMutations == null ? subscription.getPremiumAdditionalPlans() : renewalMutations.getPremiumAdditionalPlans();
        Iterator<T> it = premiumAdditionalPlans.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            subscriptionAdditionalPlan = (ModelSubscription.SubscriptionAdditionalPlan) next;
        } while (!(subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPlanId() || subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_3_MONTH.getPlanId() || subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_6_MONTH.getPlanId() || subscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_YEAR.getPlanId()));
        ModelSubscription.SubscriptionAdditionalPlan subscriptionAdditionalPlan2 = (ModelSubscription.SubscriptionAdditionalPlan) next;
        int quantity = (subscriptionAdditionalPlan2 != null ? subscriptionAdditionalPlan2.getQuantity() : 0) + guildBoostAdjustment;
        if (quantity < 0 || subscriptionAdditionalPlan2 == null) {
            Logger.e$default(AppLog.f14950g, "Error calculating additional_plans adjustment, new sub count:" + quantity, null, null, 6, null);
            return subscription.getPremiumAdditionalPlans();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : premiumAdditionalPlans) {
            ModelSubscription.SubscriptionAdditionalPlan subscriptionAdditionalPlan3 = (ModelSubscription.SubscriptionAdditionalPlan) obj;
            if ((subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPlanId() || subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_3_MONTH.getPlanId() || subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_6_MONTH.getPlanId() || subscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_YEAR.getPlanId()) ? false : true) {
                arrayList.add(obj);
            }
        }
        return quantity == 0 ? arrayList : C12163u.plus((Collection) arrayList, (Iterable) C12145m.listOf(new ModelSubscription.SubscriptionAdditionalPlan(subscriptionAdditionalPlan2.getPlanId(), quantity)));
    }

    public final int calculatePercentToNextTier(long guildId, int premiumTier, int subscriptionCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        if (premiumTier >= 3) {
            return 100;
        }
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        return C11210a.roundToInt(((subscriptionCount - getCurrentTierSubs(boostTierAmounts, premiumTier)) / getNextTierSubs(boostTierAmounts, premiumTier)) * 100);
    }

    public final int calculateTotalProgress(long guildId, int premiumTier, int subscriptionCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        if (premiumTier >= 3) {
            return 100;
        }
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        int nextTierSubs = getNextTierSubs(boostTierAmounts, premiumTier);
        int currentTierSubs = getCurrentTierSubs(boostTierAmounts, premiumTier);
        return C11210a.roundToInt((((subscriptionCount - currentTierSubs) / (nextTierSubs - currentTierSubs)) * 33.3f) + (premiumTier * 33.3f));
    }

    public final Observable<ModifyGuildBoostSlotResult> cancelGuildBoostSlot(RestAPI api, long slotId, ModelSubscription subscription, StoreGuildBoost storeGuildBoost) {
        C12238m.checkNotNullParameter(api, "api");
        C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
        C12238m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        return modifyGuildBoostSlot(api, slotId, subscription, true, storeGuildBoost);
    }

    public final int getBoostTier(long guildId, int guildBoostCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        if (guildBoostCount >= boostTierAmounts.getTier3Boosts()) {
            return 3;
        }
        if (guildBoostCount >= boostTierAmounts.getTier2Boosts()) {
            return 2;
        }
        return guildBoostCount >= boostTierAmounts.getTier1Boosts() ? 1 : 0;
    }

    public final int getBoostsRequiredForTier(long guildId, int tier, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        if (tier == 1) {
            return boostTierAmounts.getTier1Boosts();
        }
        if (tier == 2) {
            return boostTierAmounts.getTier2Boosts();
        }
        if (tier != 3) {
            return 0;
        }
        return boostTierAmounts.getTier3Boosts();
    }

    public final Observable<ModifyGuildBoostSlotResult> uncancelGuildBoostSlot(RestAPI api, long slotId, ModelSubscription subscription, StoreGuildBoost storeGuildBoost) {
        C12238m.checkNotNullParameter(api, "api");
        C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
        C12238m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        return modifyGuildBoostSlot(api, slotId, subscription, false, storeGuildBoost);
    }
}
