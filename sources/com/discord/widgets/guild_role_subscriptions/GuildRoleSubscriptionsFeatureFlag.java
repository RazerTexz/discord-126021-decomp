package com.discord.widgets.guild_role_subscriptions;

import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.creator_monetization_eligibility.CreatorMonetizationCountryAllowlist;
import d0.g;
import d0.z.d.m;
import j0.l.e.k;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionsFeatureFlag {
    public static final GuildRoleSubscriptionsFeatureFlag$Companion Companion = new GuildRoleSubscriptionsFeatureFlag$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(GuildRoleSubscriptionsFeatureFlag$Companion$INSTANCE$2.INSTANCE);
    private final ObservationDeck observationDeck;
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUser storeUser;

    public GuildRoleSubscriptionsFeatureFlag() {
        this(null, null, null, null, null, 31, null);
    }

    public GuildRoleSubscriptionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
        this.storeUser = storeUser;
        this.storePermissions = storePermissions;
        this.observationDeck = observationDeck;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static /* synthetic */ boolean canGuildSeeGuildRoleSubscriptionSettings$default(GuildRoleSubscriptionsFeatureFlag guildRoleSubscriptionsFeatureFlag, long j, CreatorMonetizationCountryAllowlist creatorMonetizationCountryAllowlist, int i, Object obj) {
        if ((i & 2) != 0) {
            creatorMonetizationCountryAllowlist = CreatorMonetizationCountryAllowlist.Companion.getINSTANCE();
        }
        return guildRoleSubscriptionsFeatureFlag.canGuildSeeGuildRoleSubscriptionSettings(j, creatorMonetizationCountryAllowlist);
    }

    public static /* synthetic */ boolean canUserAccessRoleSubscriptionManagement$default(GuildRoleSubscriptionsFeatureFlag guildRoleSubscriptionsFeatureFlag, StoreExperiments storeExperiments, int i, Object obj) {
        if ((i & 1) != 0) {
            storeExperiments = guildRoleSubscriptionsFeatureFlag.storeExperiments;
        }
        return guildRoleSubscriptionsFeatureFlag.canUserAccessRoleSubscriptionManagement(storeExperiments);
    }

    private final boolean canUserCreateRoleSubscriptions() {
        Experiment userExperiment = this.storeExperiments.getUserExperiment("2021-08_guild_role_subscription_users", false);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public final boolean canGuildAccessMobileWebPurchases(long guildId) {
        Experiment guildExperiment = this.storeExperiments.getGuildExperiment("2022-05_mobile_web_role_subscription_purchase_page", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1;
    }

    public final boolean canGuildCreateRoleSubscriptions(long guildId) {
        Experiment guildExperiment = this.storeExperiments.getGuildExperiment("2021-06_guild_role_subscriptions", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1;
    }

    public final boolean canGuildSeeGuildRoleSubscriptionSettings(long guildId, CreatorMonetizationCountryAllowlist countryAllowlist) {
        Guild guild;
        m.checkNotNullParameter(countryAllowlist, "countryAllowlist");
        if (!isGuildEligibleForRoleSubscriptions(guildId) || (guild = this.storeGuilds.getGuild(guildId)) == null) {
            return false;
        }
        if (GuildRoleSubscriptionsFeatureFlag$Companion.access$isCreatorMonetizable$p(Companion, guild)) {
            return PermissionUtils.can(32L, this.storePermissions.getGuildPermissions().get(Long.valueOf(guildId)));
        }
        return guild.isOwner(this.storeUser.getMeSnapshot().getId()) && countryAllowlist.isUserInEligibleCountry();
    }

    public final boolean canGuildSeePremiumMemberships(long guildId) {
        Guild guild = this.storeGuilds.getGuild(guildId);
        if (guild != null) {
            return guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE) && GuildRoleSubscriptionsFeatureFlag$Companion.access$isCreatorMonetizable$p(Companion, guild);
        }
        return false;
    }

    public final boolean canGuildSeePurchaseFeedbackLoopMessages(long guildId) {
        Experiment guildExperiment = this.storeExperiments.getGuildExperiment("2022-04_guild_role_subscription_purchase_feedback_loop", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1 && isGuildEligibleForRoleSubscriptions(guildId);
    }

    public final boolean canUserAccessRoleSubscriptionManagement(StoreExperiments experiments) {
        m.checkNotNullParameter(experiments, "experiments");
        Experiment userExperiment = experiments.getUserExperiment("2022-06_native_mobile_role_subscription_management", false);
        return userExperiment != null && userExperiment.getBucket() == 1;
    }

    public final boolean isGuildEligibleForGuildRoleSubscriptionTrials(long guildId) {
        Experiment guildExperiment = this.storeExperiments.getGuildExperiment("2022-01_guild_role_subscription_trials", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1 && isGuildEligibleForRoleSubscriptions(guildId);
    }

    public final boolean isGuildEligibleForRoleSubscriptions(long guildId) {
        return canGuildCreateRoleSubscriptions(guildId) && canUserCreateRoleSubscriptions();
    }

    public final Observable<Boolean> observeCanGuildSeeGuildRoleSubscriptions(long guildId) {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.storeGuilds}, false, null, null, new GuildRoleSubscriptionsFeatureFlag$observeCanGuildSeeGuildRoleSubscriptions$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeCanGuildSeeGuildRoleSubscriptionsSettings(long guildId) {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.storeExperiments, this.storeGuilds, this.storeUser, this.storePermissions}, false, null, null, new GuildRoleSubscriptionsFeatureFlag$observeCanGuildSeeGuildRoleSubscriptionsSettings$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long guildId) {
        if (guildId == null) {
            k kVar = new k(Boolean.FALSE);
            m.checkNotNullExpressionValue(kVar, "Observable.just(false)");
            return kVar;
        }
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.storeExperiments, this.storeGuilds}, false, null, null, new GuildRoleSubscriptionsFeatureFlag$observeCanGuildSeePurchaseFeedbackLoopSystemMessages$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Boolean> observeIsGuildEligibleForGuildRoleSubscriptionFreeTrials(long guildId) {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.storeExperiments}, false, null, null, new GuildRoleSubscriptionsFeatureFlag$observeIsGuildEligibleForGuildRoleSubscriptionFreeTrials$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ GuildRoleSubscriptionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 8) != 0 ? StoreStream.Companion.getPermissions() : storePermissions, (i & 16) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }
}
