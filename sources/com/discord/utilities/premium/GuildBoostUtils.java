package com.discord.utilities.premium;

import com.discord.api.guild.GuildFeature;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.ModelSubscription$SubscriptionAdditionalPlan;
import com.discord.models.domain.ModelSubscription$SubscriptionRenewalMutations;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.guilds.GuildConstantsKt;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import d0.t.u;
import d0.z.d.m;
import j0.p.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: GuildBoostUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostUtils {
    public static final int DEFAULT_GUILD_BOOST_GUILD_COUNT = 1;
    public static final int DEFAULT_GUILD_BOOST_SLOT_COUNT = 1;
    public static final int GUILD_BOOST_COOLDOWN_DAYS = 7;
    public static final GuildBoostUtils INSTANCE = new GuildBoostUtils();

    private GuildBoostUtils() {
    }

    public static /* synthetic */ int calculatePercentToNextTier$default(GuildBoostUtils guildBoostUtils, long j, int i, int i2, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            storeExperiments = StoreStream.Companion.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i3 & 16) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        return guildBoostUtils.calculatePercentToNextTier(j, i, i2, storeExperiments2, storeGuilds);
    }

    public static /* synthetic */ int calculateTotalProgress$default(GuildBoostUtils guildBoostUtils, long j, int i, int i2, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            storeExperiments = StoreStream.Companion.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i3 & 16) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        return guildBoostUtils.calculateTotalProgress(j, i, i2, storeExperiments2, storeGuilds);
    }

    public static /* synthetic */ int getBoostTier$default(GuildBoostUtils guildBoostUtils, long j, int i, StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            storeExperiments = StoreStream.Companion.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i2 & 8) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
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
            storeExperiments = StoreStream.Companion.getExperiments();
        }
        StoreExperiments storeExperiments2 = storeExperiments;
        if ((i2 & 8) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
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

    private final Observable<GuildBoostUtils$ModifyGuildBoostSlotResult> modifyGuildBoostSlot(RestAPI api, long slotId, ModelSubscription subscription, boolean cancel, StoreGuildBoost storeGuildBoost) {
        Observable<GuildBoostUtils$ModifyGuildBoostSlotResult> observableA = (cancel ? api.cancelSubscriptionSlot(slotId) : api.uncancelSubscriptionSlot(slotId)).X(a.c()).u(new GuildBoostUtils$modifyGuildBoostSlot$1(storeGuildBoost)).G(GuildBoostUtils$modifyGuildBoostSlot$2.INSTANCE).M(GuildBoostUtils$modifyGuildBoostSlot$3.INSTANCE).A(new GuildBoostUtils$modifyGuildBoostSlot$4(api, subscription, cancel));
        m.checkNotNullExpressionValue(observableA, "apiObs\n        .subscrib…N }\n          }\n        }");
        return observableA;
    }

    public final List<ModelSubscription$SubscriptionAdditionalPlan> calculateAdditionalPlansWithGuildBoostAdjustment(ModelSubscription subscription, int guildBoostAdjustment) {
        Object next;
        ModelSubscription$SubscriptionAdditionalPlan modelSubscription$SubscriptionAdditionalPlan;
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        ModelSubscription$SubscriptionRenewalMutations renewalMutations = subscription.getRenewalMutations();
        List<ModelSubscription$SubscriptionAdditionalPlan> premiumAdditionalPlans = renewalMutations == null ? subscription.getPremiumAdditionalPlans() : renewalMutations.getPremiumAdditionalPlans();
        Iterator<T> it = premiumAdditionalPlans.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            modelSubscription$SubscriptionAdditionalPlan = (ModelSubscription$SubscriptionAdditionalPlan) next;
        } while (!(modelSubscription$SubscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPlanId() || modelSubscription$SubscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_3_MONTH.getPlanId() || modelSubscription$SubscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_6_MONTH.getPlanId() || modelSubscription$SubscriptionAdditionalPlan.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_YEAR.getPlanId()));
        ModelSubscription$SubscriptionAdditionalPlan modelSubscription$SubscriptionAdditionalPlan2 = (ModelSubscription$SubscriptionAdditionalPlan) next;
        int quantity = (modelSubscription$SubscriptionAdditionalPlan2 != null ? modelSubscription$SubscriptionAdditionalPlan2.getQuantity() : 0) + guildBoostAdjustment;
        if (quantity < 0 || modelSubscription$SubscriptionAdditionalPlan2 == null) {
            Logger.e$default(AppLog.g, "Error calculating additional_plans adjustment, new sub count:" + quantity, null, null, 6, null);
            return subscription.getPremiumAdditionalPlans();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : premiumAdditionalPlans) {
            ModelSubscription$SubscriptionAdditionalPlan modelSubscription$SubscriptionAdditionalPlan3 = (ModelSubscription$SubscriptionAdditionalPlan) obj;
            if ((modelSubscription$SubscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_MONTH.getPlanId() || modelSubscription$SubscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_3_MONTH.getPlanId() || modelSubscription$SubscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_6_MONTH.getPlanId() || modelSubscription$SubscriptionAdditionalPlan3.getPlanId() == SubscriptionPlanType.PREMIUM_GUILD_YEAR.getPlanId()) ? false : true) {
                arrayList.add(obj);
            }
        }
        return quantity == 0 ? arrayList : u.plus((Collection) arrayList, (Iterable) d0.t.m.listOf(new ModelSubscription$SubscriptionAdditionalPlan(modelSubscription$SubscriptionAdditionalPlan2.getPlanId(), quantity)));
    }

    public final int calculatePercentToNextTier(long guildId, int premiumTier, int subscriptionCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        if (premiumTier >= 3) {
            return 100;
        }
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        return d0.a0.a.roundToInt(((subscriptionCount - getCurrentTierSubs(boostTierAmounts, premiumTier)) / getNextTierSubs(boostTierAmounts, premiumTier)) * 100);
    }

    public final int calculateTotalProgress(long guildId, int premiumTier, int subscriptionCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        if (premiumTier >= 3) {
            return 100;
        }
        GuildBoostTierAmounts boostTierAmounts = getBoostTierAmounts(guildId, storeExperiments, storeGuilds);
        int nextTierSubs = getNextTierSubs(boostTierAmounts, premiumTier);
        int currentTierSubs = getCurrentTierSubs(boostTierAmounts, premiumTier);
        return d0.a0.a.roundToInt((((subscriptionCount - currentTierSubs) / (nextTierSubs - currentTierSubs)) * 33.3f) + (premiumTier * 33.3f));
    }

    public final Observable<GuildBoostUtils$ModifyGuildBoostSlotResult> cancelGuildBoostSlot(RestAPI api, long slotId, ModelSubscription subscription, StoreGuildBoost storeGuildBoost) {
        m.checkNotNullParameter(api, "api");
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        return modifyGuildBoostSlot(api, slotId, subscription, true, storeGuildBoost);
    }

    public final int getBoostTier(long guildId, int guildBoostCount, StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
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
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
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

    public final Observable<GuildBoostUtils$ModifyGuildBoostSlotResult> uncancelGuildBoostSlot(RestAPI api, long slotId, ModelSubscription subscription, StoreGuildBoost storeGuildBoost) {
        m.checkNotNullParameter(api, "api");
        m.checkNotNullParameter(subscription, Traits$Payment$Type.SUBSCRIPTION);
        m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        return modifyGuildBoostSlot(api, slotId, subscription, false, storeGuildBoost);
    }
}
