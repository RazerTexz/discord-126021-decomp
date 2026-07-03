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
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.creator_monetization_eligibility.CreatorMonetizationCountryAllowlist;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;

/* JADX INFO: compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionsFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = C12083g.lazy(GuildRoleSubscriptionsFeatureFlag$Companion$INSTANCE$2.INSTANCE);
    private final ObservationDeck observationDeck;
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUser storeUser;

    /* JADX INFO: compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        private final boolean isCreatorMonetizable(Guild guild) {
            return guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE) && !guild.hasFeature(GuildFeature.CREATOR_MONETIZABLE_DISABLED);
        }

        public final GuildRoleSubscriptionsFeatureFlag getINSTANCE() {
            Lazy lazy = GuildRoleSubscriptionsFeatureFlag.INSTANCE$delegate;
            Companion companion = GuildRoleSubscriptionsFeatureFlag.INSTANCE;
            return (GuildRoleSubscriptionsFeatureFlag) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag$observeCanGuildSeeGuildRoleSubscriptions$1 */
    /* JADX INFO: compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
    public static final class C84311 extends AbstractC12240o implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C84311(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return GuildRoleSubscriptionsFeatureFlag.this.canGuildSeePremiumMemberships(this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag$observeCanGuildSeeGuildRoleSubscriptionsSettings$1 */
    /* JADX INFO: compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
    public static final class C84321 extends AbstractC12240o implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C84321(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return GuildRoleSubscriptionsFeatureFlag.canGuildSeeGuildRoleSubscriptionSettings$default(GuildRoleSubscriptionsFeatureFlag.this, this.$guildId, null, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag$observeCanGuildSeePurchaseFeedbackLoopSystemMessages$1 */
    /* JADX INFO: compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
    public static final class C84331 extends AbstractC12240o implements Function0<Boolean> {
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C84331(Long l) {
            super(0);
            this.$guildId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return GuildRoleSubscriptionsFeatureFlag.this.canGuildSeePurchaseFeedbackLoopMessages(this.$guildId.longValue());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag$observeIsGuildEligibleForGuildRoleSubscriptionFreeTrials$1 */
    /* JADX INFO: compiled from: GuildRoleSubscriptionsFeatureFlag.kt */
    public static final class C84341 extends AbstractC12240o implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C84341(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return GuildRoleSubscriptionsFeatureFlag.this.isGuildEligibleForGuildRoleSubscriptionTrials(this.$guildId);
        }
    }

    public GuildRoleSubscriptionsFeatureFlag() {
        this(null, null, null, null, null, 31, null);
    }

    public GuildRoleSubscriptionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
        this.storeUser = storeUser;
        this.storePermissions = storePermissions;
        this.observationDeck = observationDeck;
    }

    public static /* synthetic */ boolean canGuildSeeGuildRoleSubscriptionSettings$default(GuildRoleSubscriptionsFeatureFlag guildRoleSubscriptionsFeatureFlag, long j, CreatorMonetizationCountryAllowlist creatorMonetizationCountryAllowlist, int i, Object obj) {
        if ((i & 2) != 0) {
            creatorMonetizationCountryAllowlist = CreatorMonetizationCountryAllowlist.INSTANCE.getINSTANCE();
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
        C12238m.checkNotNullParameter(countryAllowlist, "countryAllowlist");
        if (!isGuildEligibleForRoleSubscriptions(guildId) || (guild = this.storeGuilds.getGuild(guildId)) == null) {
            return false;
        }
        if (INSTANCE.isCreatorMonetizable(guild)) {
            return PermissionUtils.can(32L, this.storePermissions.getGuildPermissions().get(Long.valueOf(guildId)));
        }
        return guild.isOwner(this.storeUser.getMeSnapshot().getId()) && countryAllowlist.isUserInEligibleCountry();
    }

    public final boolean canGuildSeePremiumMemberships(long guildId) {
        Guild guild = this.storeGuilds.getGuild(guildId);
        if (guild != null) {
            return guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE) && INSTANCE.isCreatorMonetizable(guild);
        }
        return false;
    }

    public final boolean canGuildSeePurchaseFeedbackLoopMessages(long guildId) {
        Experiment guildExperiment = this.storeExperiments.getGuildExperiment("2022-04_guild_role_subscription_purchase_feedback_loop", guildId, false);
        return guildExperiment != null && guildExperiment.getBucket() == 1 && isGuildEligibleForRoleSubscriptions(guildId);
    }

    public final boolean canUserAccessRoleSubscriptionManagement(StoreExperiments experiments) {
        C12238m.checkNotNullParameter(experiments, "experiments");
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
        Observable<Boolean> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeGuilds}, false, null, null, new C84311(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Boolean> observeCanGuildSeeGuildRoleSubscriptionsSettings(long guildId) {
        Observable<Boolean> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeExperiments, this.storeGuilds, this.storeUser, this.storePermissions}, false, null, null, new C84321(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Boolean> observeCanGuildSeePurchaseFeedbackLoopSystemMessages(Long guildId) {
        if (guildId == null) {
            C12721k c12721k = new C12721k(Boolean.FALSE);
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(false)");
            return c12721k;
        }
        Observable<Boolean> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeExperiments, this.storeGuilds}, false, null, null, new C84331(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Boolean> observeIsGuildEligibleForGuildRoleSubscriptionFreeTrials(long guildId) {
        Observable<Boolean> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeExperiments}, false, null, null, new C84341(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public /* synthetic */ GuildRoleSubscriptionsFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreUser storeUser, StorePermissions storePermissions, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 8) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 16) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }
}
