package com.discord.widgets.servers.guildboost;

import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import com.android.billingclient.api.Purchase;
import com.discord.C5419R;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreUser;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func5;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Clock clock;
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final StoreGuildBoost storeGuildBoost;
    private final StoreSubscriptions storeSubscriptions;

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.GuildBoostViewModel$1 */
    /* JADX INFO: compiled from: GuildBoostViewModel.kt */
    public static final class C95051 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C95051() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            GuildBoostViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildBoostViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableObserveGuildBoostState$default = StoreGuildBoost.observeGuildBoostState$default(companion.getGuildBoosts(), null, 1, null);
            Observable<StoreSubscriptions.SubscriptionsState> observableObserveSubscriptions = companion.getSubscriptions().observeSubscriptions();
            Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
            Observable<Guild> observableObserveGuild = companion.getGuilds().observeGuild(guildId);
            Observable<StoreGooglePlayPurchases.State> observableObserveState = companion.getGooglePlayPurchases().observeState();
            final GuildBoostViewModel$Companion$observeStores$1 guildBoostViewModel$Companion$observeStores$1 = GuildBoostViewModel$Companion$observeStores$1.INSTANCE;
            Object obj = guildBoostViewModel$Companion$observeStores$1;
            if (guildBoostViewModel$Companion$observeStores$1 != null) {
                obj = new Func5() { // from class: com.discord.widgets.servers.guildboost.GuildBoostViewModel$sam$rx_functions_Func5$0
                    @Override // p658rx.functions.Func5
                    public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                        return guildBoostViewModel$Companion$observeStores$1.invoke(obj2, obj3, obj4, obj5, obj6);
                    }
                };
            }
            Observable<StoreState> observableM11072g = Observable.m11072g(observableObserveGuildBoostState$default, observableObserveSubscriptions, observableObserveMe$default, observableObserveGuild, observableObserveState, (Func5) obj);
            C12238m.checkNotNullExpressionValue(observableM11072g, "Observable.combineLatest…     ::StoreState\n      )");
            return observableM11072g;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildBoostViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: GuildBoostViewModel.kt */
        public static final /* data */ class LaunchPurchaseSubscription extends Event {
            private final long guildId;
            private final String oldSkuName;
            private final String section;

            public /* synthetic */ LaunchPurchaseSubscription(String str, long j, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, j, (i & 4) != 0 ? null : str2);
            }

            public static /* synthetic */ LaunchPurchaseSubscription copy$default(LaunchPurchaseSubscription launchPurchaseSubscription, String str, long j, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = launchPurchaseSubscription.section;
                }
                if ((i & 2) != 0) {
                    j = launchPurchaseSubscription.guildId;
                }
                if ((i & 4) != 0) {
                    str2 = launchPurchaseSubscription.oldSkuName;
                }
                return launchPurchaseSubscription.copy(str, j, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSection() {
                return this.section;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getOldSkuName() {
                return this.oldSkuName;
            }

            public final LaunchPurchaseSubscription copy(String section, long guildId, String oldSkuName) {
                C12238m.checkNotNullParameter(section, "section");
                return new LaunchPurchaseSubscription(section, guildId, oldSkuName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchPurchaseSubscription)) {
                    return false;
                }
                LaunchPurchaseSubscription launchPurchaseSubscription = (LaunchPurchaseSubscription) other;
                return C12238m.areEqual(this.section, launchPurchaseSubscription.section) && this.guildId == launchPurchaseSubscription.guildId && C12238m.areEqual(this.oldSkuName, launchPurchaseSubscription.oldSkuName);
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final String getOldSkuName() {
                return this.oldSkuName;
            }

            public final String getSection() {
                return this.section;
            }

            public int hashCode() {
                String str = this.section;
                int iM3a = (C0002b.m3a(this.guildId) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
                String str2 = this.oldSkuName;
                return iM3a + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("LaunchPurchaseSubscription(section=");
                sbM833U.append(this.section);
                sbM833U.append(", guildId=");
                sbM833U.append(this.guildId);
                sbM833U.append(", oldSkuName=");
                return C1643a.m822J(sbM833U, this.oldSkuName, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LaunchPurchaseSubscription(String str, long j, String str2) {
                super(null);
                C12238m.checkNotNullParameter(str, "section");
                this.section = str;
                this.guildId = j;
                this.oldSkuName = str2;
            }
        }

        /* JADX INFO: compiled from: GuildBoostViewModel.kt */
        public static final /* data */ class LaunchSubscriptionConfirmation extends Event {
            private final long guildId;
            private final long slotId;

            public LaunchSubscriptionConfirmation(long j, long j2) {
                super(null);
                this.guildId = j;
                this.slotId = j2;
            }

            public static /* synthetic */ LaunchSubscriptionConfirmation copy$default(LaunchSubscriptionConfirmation launchSubscriptionConfirmation, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = launchSubscriptionConfirmation.guildId;
                }
                if ((i & 2) != 0) {
                    j2 = launchSubscriptionConfirmation.slotId;
                }
                return launchSubscriptionConfirmation.copy(j, j2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getSlotId() {
                return this.slotId;
            }

            public final LaunchSubscriptionConfirmation copy(long guildId, long slotId) {
                return new LaunchSubscriptionConfirmation(guildId, slotId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchSubscriptionConfirmation)) {
                    return false;
                }
                LaunchSubscriptionConfirmation launchSubscriptionConfirmation = (LaunchSubscriptionConfirmation) other;
                return this.guildId == launchSubscriptionConfirmation.guildId && this.slotId == launchSubscriptionConfirmation.slotId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final long getSlotId() {
                return this.slotId;
            }

            public int hashCode() {
                return C0002b.m3a(this.slotId) + (C0002b.m3a(this.guildId) * 31);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("LaunchSubscriptionConfirmation(guildId=");
                sbM833U.append(this.guildId);
                sbM833U.append(", slotId=");
                return C1643a.m815C(sbM833U, this.slotId, ")");
            }
        }

        /* JADX INFO: compiled from: GuildBoostViewModel.kt */
        public static final /* data */ class ShowBlockedPlanSwitchAlertDialog extends Event {
            private final int bodyStringRes;
            private final int headerStringRes;

            public ShowBlockedPlanSwitchAlertDialog(@StringRes int i, @StringRes int i2) {
                super(null);
                this.headerStringRes = i;
                this.bodyStringRes = i2;
            }

            public static /* synthetic */ ShowBlockedPlanSwitchAlertDialog copy$default(ShowBlockedPlanSwitchAlertDialog showBlockedPlanSwitchAlertDialog, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = showBlockedPlanSwitchAlertDialog.headerStringRes;
                }
                if ((i3 & 2) != 0) {
                    i2 = showBlockedPlanSwitchAlertDialog.bodyStringRes;
                }
                return showBlockedPlanSwitchAlertDialog.copy(i, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getHeaderStringRes() {
                return this.headerStringRes;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getBodyStringRes() {
                return this.bodyStringRes;
            }

            public final ShowBlockedPlanSwitchAlertDialog copy(@StringRes int headerStringRes, @StringRes int bodyStringRes) {
                return new ShowBlockedPlanSwitchAlertDialog(headerStringRes, bodyStringRes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowBlockedPlanSwitchAlertDialog)) {
                    return false;
                }
                ShowBlockedPlanSwitchAlertDialog showBlockedPlanSwitchAlertDialog = (ShowBlockedPlanSwitchAlertDialog) other;
                return this.headerStringRes == showBlockedPlanSwitchAlertDialog.headerStringRes && this.bodyStringRes == showBlockedPlanSwitchAlertDialog.bodyStringRes;
            }

            public final int getBodyStringRes() {
                return this.bodyStringRes;
            }

            public final int getHeaderStringRes() {
                return this.headerStringRes;
            }

            public int hashCode() {
                return (this.headerStringRes * 31) + this.bodyStringRes;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("ShowBlockedPlanSwitchAlertDialog(headerStringRes=");
                sbM833U.append(this.headerStringRes);
                sbM833U.append(", bodyStringRes=");
                return C1643a.m814B(sbM833U, this.bodyStringRes, ")");
            }
        }

        /* JADX INFO: compiled from: GuildBoostViewModel.kt */
        public static final class ShowDesktopAlertDialog extends Event {
            public static final ShowDesktopAlertDialog INSTANCE = new ShowDesktopAlertDialog();

            private ShowDesktopAlertDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildBoostViewModel.kt */
        public static final class UnacknowledgedPurchase extends Event {
            public static final UnacknowledgedPurchase INSTANCE = new UnacknowledgedPurchase();

            private UnacknowledgedPurchase() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildBoostViewModel.kt */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final StoreGuildBoost.State guildBoostState;
        private final MeUser meUser;
        private final StoreGooglePlayPurchases.State purchasesState;
        private final StoreSubscriptions.SubscriptionsState subscriptionState;

        public StoreState(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases.State state2) {
            C12238m.checkNotNullParameter(state, "guildBoostState");
            C12238m.checkNotNullParameter(subscriptionsState, "subscriptionState");
            C12238m.checkNotNullParameter(meUser, "meUser");
            C12238m.checkNotNullParameter(state2, "purchasesState");
            this.guildBoostState = state;
            this.subscriptionState = subscriptionsState;
            this.meUser = meUser;
            this.guild = guild;
            this.purchasesState = state2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, MeUser meUser, Guild guild, StoreGooglePlayPurchases.State state2, int i, Object obj) {
            if ((i & 1) != 0) {
                state = storeState.guildBoostState;
            }
            if ((i & 2) != 0) {
                subscriptionsState = storeState.subscriptionState;
            }
            StoreSubscriptions.SubscriptionsState subscriptionsState2 = subscriptionsState;
            if ((i & 4) != 0) {
                meUser = storeState.meUser;
            }
            MeUser meUser2 = meUser;
            if ((i & 8) != 0) {
                guild = storeState.guild;
            }
            Guild guild2 = guild;
            if ((i & 16) != 0) {
                state2 = storeState.purchasesState;
            }
            return storeState.copy(state, subscriptionsState2, meUser2, guild2, state2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionState() {
            return this.subscriptionState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final StoreGooglePlayPurchases.State getPurchasesState() {
            return this.purchasesState;
        }

        public final StoreState copy(StoreGuildBoost.State guildBoostState, StoreSubscriptions.SubscriptionsState subscriptionState, MeUser meUser, Guild guild, StoreGooglePlayPurchases.State purchasesState) {
            C12238m.checkNotNullParameter(guildBoostState, "guildBoostState");
            C12238m.checkNotNullParameter(subscriptionState, "subscriptionState");
            C12238m.checkNotNullParameter(meUser, "meUser");
            C12238m.checkNotNullParameter(purchasesState, "purchasesState");
            return new StoreState(guildBoostState, subscriptionState, meUser, guild, purchasesState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.guildBoostState, storeState.guildBoostState) && C12238m.areEqual(this.subscriptionState, storeState.subscriptionState) && C12238m.areEqual(this.meUser, storeState.meUser) && C12238m.areEqual(this.guild, storeState.guild) && C12238m.areEqual(this.purchasesState, storeState.purchasesState);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final StoreGooglePlayPurchases.State getPurchasesState() {
            return this.purchasesState;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionState() {
            return this.subscriptionState;
        }

        public int hashCode() {
            StoreGuildBoost.State state = this.guildBoostState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionState;
            int iHashCode2 = (iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0)) * 31;
            MeUser meUser = this.meUser;
            int iHashCode3 = (iHashCode2 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode4 = (iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31;
            StoreGooglePlayPurchases.State state2 = this.purchasesState;
            return iHashCode4 + (state2 != null ? state2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(guildBoostState=");
            sbM833U.append(this.guildBoostState);
            sbM833U.append(", subscriptionState=");
            sbM833U.append(this.subscriptionState);
            sbM833U.append(", meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", purchasesState=");
            sbM833U.append(this.purchasesState);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildBoostViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GuildBoostViewModel.kt */
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildBoostViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Map<Long, ModelGuildBoostSlot> boostSlotMap;
            private final Guild guild;
            private final MeUser meUser;
            private final ModelSubscription premiumSubscription;
            private final List<Purchase> purchases;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Map<Long, ModelGuildBoostSlot> map, ModelSubscription modelSubscription, List<? extends Purchase> list, MeUser meUser, Guild guild) {
                super(null);
                C12238m.checkNotNullParameter(map, "boostSlotMap");
                C12238m.checkNotNullParameter(list, "purchases");
                C12238m.checkNotNullParameter(meUser, "meUser");
                C12238m.checkNotNullParameter(guild, "guild");
                this.boostSlotMap = map;
                this.premiumSubscription = modelSubscription;
                this.purchases = list;
                this.meUser = meUser;
                this.guild = guild;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, ModelSubscription modelSubscription, List list, MeUser meUser, Guild guild, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.boostSlotMap;
                }
                if ((i & 2) != 0) {
                    modelSubscription = loaded.premiumSubscription;
                }
                ModelSubscription modelSubscription2 = modelSubscription;
                if ((i & 4) != 0) {
                    list = loaded.purchases;
                }
                List list2 = list;
                if ((i & 8) != 0) {
                    meUser = loaded.meUser;
                }
                MeUser meUser2 = meUser;
                if ((i & 16) != 0) {
                    guild = loaded.guild;
                }
                return loaded.copy(map, modelSubscription2, list2, meUser2, guild);
            }

            public final Map<Long, ModelGuildBoostSlot> component1() {
                return this.boostSlotMap;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ModelSubscription getPremiumSubscription() {
                return this.premiumSubscription;
            }

            public final List<Purchase> component3() {
                return this.purchases;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final Loaded copy(Map<Long, ModelGuildBoostSlot> boostSlotMap, ModelSubscription premiumSubscription, List<? extends Purchase> purchases, MeUser meUser, Guild guild) {
                C12238m.checkNotNullParameter(boostSlotMap, "boostSlotMap");
                C12238m.checkNotNullParameter(purchases, "purchases");
                C12238m.checkNotNullParameter(meUser, "meUser");
                C12238m.checkNotNullParameter(guild, "guild");
                return new Loaded(boostSlotMap, premiumSubscription, purchases, meUser, guild);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.boostSlotMap, loaded.boostSlotMap) && C12238m.areEqual(this.premiumSubscription, loaded.premiumSubscription) && C12238m.areEqual(this.purchases, loaded.purchases) && C12238m.areEqual(this.meUser, loaded.meUser) && C12238m.areEqual(this.guild, loaded.guild);
            }

            public final Map<Long, ModelGuildBoostSlot> getBoostSlotMap() {
                return this.boostSlotMap;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final ModelSubscription getPremiumSubscription() {
                return this.premiumSubscription;
            }

            public final List<Purchase> getPurchases() {
                return this.purchases;
            }

            public int hashCode() {
                Map<Long, ModelGuildBoostSlot> map = this.boostSlotMap;
                int iHashCode = (map != null ? map.hashCode() : 0) * 31;
                ModelSubscription modelSubscription = this.premiumSubscription;
                int iHashCode2 = (iHashCode + (modelSubscription != null ? modelSubscription.hashCode() : 0)) * 31;
                List<Purchase> list = this.purchases;
                int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
                MeUser meUser = this.meUser;
                int iHashCode4 = (iHashCode3 + (meUser != null ? meUser.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                return iHashCode4 + (guild != null ? guild.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(boostSlotMap=");
                sbM833U.append(this.boostSlotMap);
                sbM833U.append(", premiumSubscription=");
                sbM833U.append(this.premiumSubscription);
                sbM833U.append(", purchases=");
                sbM833U.append(this.purchases);
                sbM833U.append(", meUser=");
                sbM833U.append(this.meUser);
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: GuildBoostViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ GuildBoostViewModel(long j, StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Clock clock, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : storeGuildBoost, (i & 4) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions, (i & 8) != 0 ? ClockFactory.get() : clock, (i & 16) != 0 ? INSTANCE.observeStores(j) : observable);
    }

    private final void fetchData() {
        this.storeGuildBoost.fetchUserGuildBoostState();
        this.storeSubscriptions.fetchSubscriptions();
        GooglePlayBillingManager.INSTANCE.queryPurchases();
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ViewState loaded;
        StoreGuildBoost.State guildBoostState = storeState.getGuildBoostState();
        StoreSubscriptions.SubscriptionsState subscriptionState = storeState.getSubscriptionState();
        StoreGooglePlayPurchases.State purchasesState = storeState.getPurchasesState();
        if ((guildBoostState instanceof StoreGuildBoost.State.Loading) || (subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Loading) || (purchasesState instanceof StoreGooglePlayPurchases.State.Uninitialized)) {
            loaded = ViewState.Loading.INSTANCE;
        } else if ((guildBoostState instanceof StoreGuildBoost.State.Failure) || (subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Failure) || !(guildBoostState instanceof StoreGuildBoost.State.Loaded) || !(subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Loaded) || !(purchasesState instanceof StoreGooglePlayPurchases.State.Loaded)) {
            loaded = ViewState.Failure.INSTANCE;
        } else {
            if (storeState.getGuild() == null) {
                ViewState.Failure failure = ViewState.Failure.INSTANCE;
                return;
            }
            loaded = new ViewState.Loaded(((StoreGuildBoost.State.Loaded) guildBoostState).getBoostSlotMap(), ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionState).getPremiumSubscription(), ((StoreGooglePlayPurchases.State.Loaded) purchasesState).getPurchases(), storeState.getMeUser(), storeState.getGuild());
        }
        updateViewState(loaded);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void retryClicked() {
        fetchData();
    }

    @MainThread
    public final void subscribeClicked(String section) {
        boolean z2;
        C12238m.checkNotNullParameter(section, "section");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            Map<Long, ModelGuildBoostSlot> boostSlotMap = loaded.getBoostSlotMap();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<Map.Entry<Long, ModelGuildBoostSlot>> it = boostSlotMap.entrySet().iterator();
            while (true) {
                z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Long, ModelGuildBoostSlot> next = it.next();
                ModelGuildBoostSlot value = next.getValue();
                if (value.getCooldownExpiresAtTimestamp() < this.clock.currentTimeMillis()) {
                    ModelAppliedGuildBoost premiumGuildSubscription = value.getPremiumGuildSubscription();
                    if ((premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null) == null) {
                        z2 = true;
                    }
                }
                if (z2) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            if (!linkedHashMap.isEmpty()) {
                this.eventSubject.f27650k.onNext(new Event.LaunchSubscriptionConfirmation(loaded.getGuild().getId(), ((ModelGuildBoostSlot) C12163u.first(linkedHashMap.values())).getId()));
                return;
            }
            ModelSubscription premiumSubscription = loaded.getPremiumSubscription();
            if (premiumSubscription != null && !premiumSubscription.isGoogleSubscription()) {
                this.eventSubject.f27650k.onNext(Event.ShowDesktopAlertDialog.INSTANCE);
                return;
            }
            if ((premiumSubscription != null ? premiumSubscription.getRenewalMutations() : null) != null) {
                this.eventSubject.f27650k.onNext(new Event.ShowBlockedPlanSwitchAlertDialog(C5419R.string.premium_guild_subscription_out_of_slots_title, C5419R.string.premium_guild_subscription_out_of_slots_pending_plan_change));
                return;
            }
            if ((premiumSubscription != null ? premiumSubscription.getStatus() : null) == ModelSubscription.Status.CANCELED) {
                this.eventSubject.f27650k.onNext(new Event.ShowBlockedPlanSwitchAlertDialog(C5419R.string.premium_guild_subscription_out_of_slots_title, C5419R.string.premium_guild_subscription_out_of_slots_canceled_subscription));
                return;
            }
            if ((premiumSubscription != null ? premiumSubscription.getStatus() : null) == ModelSubscription.Status.ACCOUNT_HOLD) {
                this.eventSubject.f27650k.onNext(new Event.ShowBlockedPlanSwitchAlertDialog(C5419R.string.premium_guild_subscription_out_of_slots_account_hold_title, C5419R.string.premium_guild_subscription_out_of_slots_account_hold));
                return;
            }
            List<Purchase> purchases = loaded.getPurchases();
            if (!(purchases instanceof Collection) || !purchases.isEmpty()) {
                Iterator<T> it2 = purchases.iterator();
                while (it2.hasNext()) {
                    if (!((Purchase) it2.next()).m7499c()) {
                        z2 = true;
                        break;
                    }
                }
            }
            if (z2) {
                this.eventSubject.f27650k.onNext(Event.UnacknowledgedPurchase.INSTANCE);
            } else {
                PublishSubject<Event> publishSubject = this.eventSubject;
                long id2 = loaded.getGuild().getId();
                ModelSubscription premiumSubscription2 = loaded.getPremiumSubscription();
                publishSubject.f27650k.onNext(new Event.LaunchPurchaseSubscription(section, id2, premiumSubscription2 != null ? premiumSubscription2.getPaymentGatewayPlanId() : null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostViewModel(long j, StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Clock clock, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        C12238m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        C12238m.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.storeGuildBoost = storeGuildBoost;
        this.storeSubscriptions = storeSubscriptions;
        this.clock = clock;
        this.eventSubject = PublishSubject.m11133k0();
        fetchData();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildBoostViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95051());
    }
}
