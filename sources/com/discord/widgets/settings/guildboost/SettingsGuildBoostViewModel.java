package com.discord.widgets.settings.guildboost;

import a0.a.a.b;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.guildboost.SettingsGuildBoostSampleGuildAdapter;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoostSubscriptionAdapter;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func4;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGuildBoostViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int NUM_SAMPLE_GUILDS = 4;
    private static final Long UNUSED_GUILD_BOOST_GUILD_ID = null;
    private final StoreGuildBoost storeGuildBoost;
    private final StoreSubscriptions storeSubscriptions;

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            SettingsGuildBoostViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableObserveGuildBoostState$default = StoreGuildBoost.observeGuildBoostState$default(companion.getGuildBoosts(), null, 1, null);
            Observable<StoreSubscriptions.SubscriptionsState> observableObserveSubscriptions = companion.getSubscriptions().observeSubscriptions();
            Observable<LinkedHashMap<Long, Guild>> observableObserveOrderedGuilds = companion.getGuildsSorted().observeOrderedGuilds();
            Observable observableR = StoreUser.observeMe$default(companion.getUsers(), false, 1, null).G(new Func1<MeUser, PremiumTier>() { // from class: com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel$Companion$observeStores$1
                @Override // j0.k.Func1
                public final PremiumTier call(MeUser meUser) {
                    return meUser.getPremiumTier();
                }
            }).r();
            final SettingsGuildBoostViewModel3 settingsGuildBoostViewModel3 = SettingsGuildBoostViewModel3.INSTANCE;
            Object obj = settingsGuildBoostViewModel3;
            if (settingsGuildBoostViewModel3 != null) {
                obj = new Func4() { // from class: com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel$sam$rx_functions_Func4$0
                    @Override // rx.functions.Func4
                    public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4, Object obj5) {
                        return settingsGuildBoostViewModel3.invoke(obj2, obj3, obj4, obj5);
                    }
                };
            }
            Observable<StoreState> observableH = Observable.h(observableObserveGuildBoostState$default, observableObserveSubscriptions, observableObserveOrderedGuilds, observableR, (Func4) obj);
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…     ::StoreState\n      )");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
    public static abstract class PendingAction {

        /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
        public static final /* data */ class Cancel extends PendingAction {
            private final long slotId;

            public Cancel(long j) {
                super(null);
                this.slotId = j;
            }

            public static /* synthetic */ Cancel copy$default(Cancel cancel, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = cancel.slotId;
                }
                return cancel.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getSlotId() {
                return this.slotId;
            }

            public final Cancel copy(long slotId) {
                return new Cancel(slotId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Cancel) && this.slotId == ((Cancel) other).slotId;
                }
                return true;
            }

            public final long getSlotId() {
                return this.slotId;
            }

            public int hashCode() {
                return b.a(this.slotId);
            }

            public String toString() {
                return outline.C(outline.U("Cancel(slotId="), this.slotId, ")");
            }
        }

        /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
        public static final /* data */ class Subscribe extends PendingAction {
            private final long slotId;
            private final Long targetGuildId;

            public /* synthetic */ Subscribe(long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(j, (i & 2) != 0 ? null : l);
            }

            public static /* synthetic */ Subscribe copy$default(Subscribe subscribe, long j, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = subscribe.slotId;
                }
                if ((i & 2) != 0) {
                    l = subscribe.targetGuildId;
                }
                return subscribe.copy(j, l);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getSlotId() {
                return this.slotId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Long getTargetGuildId() {
                return this.targetGuildId;
            }

            public final Subscribe copy(long slotId, Long targetGuildId) {
                return new Subscribe(slotId, targetGuildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Subscribe)) {
                    return false;
                }
                Subscribe subscribe = (Subscribe) other;
                return this.slotId == subscribe.slotId && Intrinsics3.areEqual(this.targetGuildId, subscribe.targetGuildId);
            }

            public final long getSlotId() {
                return this.slotId;
            }

            public final Long getTargetGuildId() {
                return this.targetGuildId;
            }

            public int hashCode() {
                int iA = b.a(this.slotId) * 31;
                Long l = this.targetGuildId;
                return iA + (l != null ? l.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Subscribe(slotId=");
                sbU.append(this.slotId);
                sbU.append(", targetGuildId=");
                return outline.G(sbU, this.targetGuildId, ")");
            }

            public Subscribe(long j, Long l) {
                super(null);
                this.slotId = j;
                this.targetGuildId = l;
            }
        }

        /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
        public static final /* data */ class Transfer extends PendingAction {
            private final long previousGuildId;
            private final ModelGuildBoostSlot slot;
            private final Long targetGuildId;

            public /* synthetic */ Transfer(ModelGuildBoostSlot modelGuildBoostSlot, long j, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(modelGuildBoostSlot, j, (i & 4) != 0 ? null : l);
            }

            public static /* synthetic */ Transfer copy$default(Transfer transfer, ModelGuildBoostSlot modelGuildBoostSlot, long j, Long l, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildBoostSlot = transfer.slot;
                }
                if ((i & 2) != 0) {
                    j = transfer.previousGuildId;
                }
                if ((i & 4) != 0) {
                    l = transfer.targetGuildId;
                }
                return transfer.copy(modelGuildBoostSlot, j, l);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelGuildBoostSlot getSlot() {
                return this.slot;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getPreviousGuildId() {
                return this.previousGuildId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Long getTargetGuildId() {
                return this.targetGuildId;
            }

            public final Transfer copy(ModelGuildBoostSlot slot, long previousGuildId, Long targetGuildId) {
                Intrinsics3.checkNotNullParameter(slot, "slot");
                return new Transfer(slot, previousGuildId, targetGuildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Transfer)) {
                    return false;
                }
                Transfer transfer = (Transfer) other;
                return Intrinsics3.areEqual(this.slot, transfer.slot) && this.previousGuildId == transfer.previousGuildId && Intrinsics3.areEqual(this.targetGuildId, transfer.targetGuildId);
            }

            public final long getPreviousGuildId() {
                return this.previousGuildId;
            }

            public final ModelGuildBoostSlot getSlot() {
                return this.slot;
            }

            public final Long getTargetGuildId() {
                return this.targetGuildId;
            }

            public int hashCode() {
                ModelGuildBoostSlot modelGuildBoostSlot = this.slot;
                int iA = (b.a(this.previousGuildId) + ((modelGuildBoostSlot != null ? modelGuildBoostSlot.hashCode() : 0) * 31)) * 31;
                Long l = this.targetGuildId;
                return iA + (l != null ? l.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Transfer(slot=");
                sbU.append(this.slot);
                sbU.append(", previousGuildId=");
                sbU.append(this.previousGuildId);
                sbU.append(", targetGuildId=");
                return outline.G(sbU, this.targetGuildId, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Transfer(ModelGuildBoostSlot modelGuildBoostSlot, long j, Long l) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelGuildBoostSlot, "slot");
                this.slot = modelGuildBoostSlot;
                this.previousGuildId = j;
                this.targetGuildId = l;
            }
        }

        /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
        public static final /* data */ class Uncancel extends PendingAction {
            private final long slotId;

            public Uncancel(long j) {
                super(null);
                this.slotId = j;
            }

            public static /* synthetic */ Uncancel copy$default(Uncancel uncancel, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = uncancel.slotId;
                }
                return uncancel.copy(j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getSlotId() {
                return this.slotId;
            }

            public final Uncancel copy(long slotId) {
                return new Uncancel(slotId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Uncancel) && this.slotId == ((Uncancel) other).slotId;
                }
                return true;
            }

            public final long getSlotId() {
                return this.slotId;
            }

            public int hashCode() {
                return b.a(this.slotId);
            }

            public String toString() {
                return outline.C(outline.U("Uncancel(slotId="), this.slotId, ")");
            }
        }

        private PendingAction() {
        }

        public /* synthetic */ PendingAction(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
    public static final /* data */ class StoreState {
        private final StoreGuildBoost.State guildBoostState;
        private final Map<Long, Guild> guilds;
        private final StoreSubscriptions.SubscriptionsState subscriptionState;
        private final PremiumTier userPremiumTier;

        public StoreState(StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map<Long, Guild> map, PremiumTier premiumTier) {
            Intrinsics3.checkNotNullParameter(state, "guildBoostState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionState");
            Intrinsics3.checkNotNullParameter(map, "guilds");
            Intrinsics3.checkNotNullParameter(premiumTier, "userPremiumTier");
            this.guildBoostState = state;
            this.subscriptionState = subscriptionsState;
            this.guilds = map;
            this.userPremiumTier = premiumTier;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGuildBoost.State state, StoreSubscriptions.SubscriptionsState subscriptionsState, Map map, PremiumTier premiumTier, int i, Object obj) {
            if ((i & 1) != 0) {
                state = storeState.guildBoostState;
            }
            if ((i & 2) != 0) {
                subscriptionsState = storeState.subscriptionState;
            }
            if ((i & 4) != 0) {
                map = storeState.guilds;
            }
            if ((i & 8) != 0) {
                premiumTier = storeState.userPremiumTier;
            }
            return storeState.copy(state, subscriptionsState, map, premiumTier);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionState() {
            return this.subscriptionState;
        }

        public final Map<Long, Guild> component3() {
            return this.guilds;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final PremiumTier getUserPremiumTier() {
            return this.userPremiumTier;
        }

        public final StoreState copy(StoreGuildBoost.State guildBoostState, StoreSubscriptions.SubscriptionsState subscriptionState, Map<Long, Guild> guilds, PremiumTier userPremiumTier) {
            Intrinsics3.checkNotNullParameter(guildBoostState, "guildBoostState");
            Intrinsics3.checkNotNullParameter(subscriptionState, "subscriptionState");
            Intrinsics3.checkNotNullParameter(guilds, "guilds");
            Intrinsics3.checkNotNullParameter(userPremiumTier, "userPremiumTier");
            return new StoreState(guildBoostState, subscriptionState, guilds, userPremiumTier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildBoostState, storeState.guildBoostState) && Intrinsics3.areEqual(this.subscriptionState, storeState.subscriptionState) && Intrinsics3.areEqual(this.guilds, storeState.guilds) && Intrinsics3.areEqual(this.userPremiumTier, storeState.userPremiumTier);
        }

        public final StoreGuildBoost.State getGuildBoostState() {
            return this.guildBoostState;
        }

        public final Map<Long, Guild> getGuilds() {
            return this.guilds;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionState() {
            return this.subscriptionState;
        }

        public final PremiumTier getUserPremiumTier() {
            return this.userPremiumTier;
        }

        public int hashCode() {
            StoreGuildBoost.State state = this.guildBoostState;
            int iHashCode = (state != null ? state.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionState;
            int iHashCode2 = (iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0)) * 31;
            Map<Long, Guild> map = this.guilds;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            PremiumTier premiumTier = this.userPremiumTier;
            return iHashCode3 + (premiumTier != null ? premiumTier.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildBoostState=");
            sbU.append(this.guildBoostState);
            sbU.append(", subscriptionState=");
            sbU.append(this.subscriptionState);
            sbU.append(", guilds=");
            sbU.append(this.guilds);
            sbU.append(", userPremiumTier=");
            sbU.append(this.userPremiumTier);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean canCancelBoosts;
            private final boolean canUncancelBoosts;
            private final List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> guildBoostItems;
            private final PendingAction pendingAction;
            private final List<SettingsGuildBoostSampleGuildAdapter.Item> sampleGuildItems;
            private final PremiumTier userPremiumTier;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(boolean z2, boolean z3, List<? extends WidgetSettingsGuildBoostSubscriptionAdapter.Item> list, List<SettingsGuildBoostSampleGuildAdapter.Item> list2, PendingAction pendingAction, PremiumTier premiumTier) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "guildBoostItems");
                Intrinsics3.checkNotNullParameter(list2, "sampleGuildItems");
                Intrinsics3.checkNotNullParameter(premiumTier, "userPremiumTier");
                this.canCancelBoosts = z2;
                this.canUncancelBoosts = z3;
                this.guildBoostItems = list;
                this.sampleGuildItems = list2;
                this.pendingAction = pendingAction;
                this.userPremiumTier = premiumTier;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, boolean z3, List list, List list2, PendingAction pendingAction, PremiumTier premiumTier, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loaded.canCancelBoosts;
                }
                if ((i & 2) != 0) {
                    z3 = loaded.canUncancelBoosts;
                }
                boolean z4 = z3;
                if ((i & 4) != 0) {
                    list = loaded.guildBoostItems;
                }
                List list3 = list;
                if ((i & 8) != 0) {
                    list2 = loaded.sampleGuildItems;
                }
                List list4 = list2;
                if ((i & 16) != 0) {
                    pendingAction = loaded.pendingAction;
                }
                PendingAction pendingAction2 = pendingAction;
                if ((i & 32) != 0) {
                    premiumTier = loaded.userPremiumTier;
                }
                return loaded.copy(z2, z4, list3, list4, pendingAction2, premiumTier);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getCanCancelBoosts() {
                return this.canCancelBoosts;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getCanUncancelBoosts() {
                return this.canUncancelBoosts;
            }

            public final List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> component3() {
                return this.guildBoostItems;
            }

            public final List<SettingsGuildBoostSampleGuildAdapter.Item> component4() {
                return this.sampleGuildItems;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final PendingAction getPendingAction() {
                return this.pendingAction;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final PremiumTier getUserPremiumTier() {
                return this.userPremiumTier;
            }

            public final Loaded copy(boolean canCancelBoosts, boolean canUncancelBoosts, List<? extends WidgetSettingsGuildBoostSubscriptionAdapter.Item> guildBoostItems, List<SettingsGuildBoostSampleGuildAdapter.Item> sampleGuildItems, PendingAction pendingAction, PremiumTier userPremiumTier) {
                Intrinsics3.checkNotNullParameter(guildBoostItems, "guildBoostItems");
                Intrinsics3.checkNotNullParameter(sampleGuildItems, "sampleGuildItems");
                Intrinsics3.checkNotNullParameter(userPremiumTier, "userPremiumTier");
                return new Loaded(canCancelBoosts, canUncancelBoosts, guildBoostItems, sampleGuildItems, pendingAction, userPremiumTier);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.canCancelBoosts == loaded.canCancelBoosts && this.canUncancelBoosts == loaded.canUncancelBoosts && Intrinsics3.areEqual(this.guildBoostItems, loaded.guildBoostItems) && Intrinsics3.areEqual(this.sampleGuildItems, loaded.sampleGuildItems) && Intrinsics3.areEqual(this.pendingAction, loaded.pendingAction) && Intrinsics3.areEqual(this.userPremiumTier, loaded.userPremiumTier);
            }

            public final boolean getCanCancelBoosts() {
                return this.canCancelBoosts;
            }

            public final boolean getCanUncancelBoosts() {
                return this.canUncancelBoosts;
            }

            public final List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> getGuildBoostItems() {
                return this.guildBoostItems;
            }

            public final PendingAction getPendingAction() {
                return this.pendingAction;
            }

            public final List<SettingsGuildBoostSampleGuildAdapter.Item> getSampleGuildItems() {
                return this.sampleGuildItems;
            }

            public final PremiumTier getUserPremiumTier() {
                return this.userPremiumTier;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v12 */
            /* JADX WARN: Type inference failed for: r0v13 */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v15 */
            public int hashCode() {
                boolean z2 = this.canCancelBoosts;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.canUncancelBoosts;
                int i2 = (i + (z3 ? 1 : z3)) * 31;
                List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> list = this.guildBoostItems;
                int iHashCode = (i2 + (list != null ? list.hashCode() : 0)) * 31;
                List<SettingsGuildBoostSampleGuildAdapter.Item> list2 = this.sampleGuildItems;
                int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
                PendingAction pendingAction = this.pendingAction;
                int iHashCode3 = (iHashCode2 + (pendingAction != null ? pendingAction.hashCode() : 0)) * 31;
                PremiumTier premiumTier = this.userPremiumTier;
                return iHashCode3 + (premiumTier != null ? premiumTier.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(canCancelBoosts=");
                sbU.append(this.canCancelBoosts);
                sbU.append(", canUncancelBoosts=");
                sbU.append(this.canUncancelBoosts);
                sbU.append(", guildBoostItems=");
                sbU.append(this.guildBoostItems);
                sbU.append(", sampleGuildItems=");
                sbU.append(this.sampleGuildItems);
                sbU.append(", pendingAction=");
                sbU.append(this.pendingAction);
                sbU.append(", userPremiumTier=");
                sbU.append(this.userPremiumTier);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
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

    public SettingsGuildBoostViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ SettingsGuildBoostViewModel(StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getGuildBoosts() : storeGuildBoost, (i & 2) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions, (i & 4) != 0 ? INSTANCE.observeStores() : observable);
    }

    private final List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> createGuildBoostItems(StoreGuildBoost.State.Loaded guildSubState, Map<Long, Guild> guilds, ModelSubscription subscription) {
        Collection<ModelGuildBoostSlot> collectionValues = guildSubState.getBoostSlotMap().values();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ModelGuildBoostSlot modelGuildBoostSlot = (ModelGuildBoostSlot) it.next();
            ModelAppliedGuildBoost premiumGuildSubscription = modelGuildBoostSlot.getPremiumGuildSubscription();
            Long lValueOf = premiumGuildSubscription != null ? Long.valueOf(premiumGuildSubscription.getGuildId()) : null;
            Object arrayList2 = map.get(lValueOf);
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
            }
            ((ArrayList) arrayList2).add(modelGuildBoostSlot);
            map.put(lValueOf, arrayList2);
        }
        ArrayList arrayList3 = (ArrayList) map.remove(UNUSED_GUILD_BOOST_GUILD_ID);
        if (arrayList3 != null) {
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem((ModelGuildBoostSlot) it2.next(), subscription != null ? subscription.getCurrentPeriodEnd() : null));
            }
        }
        if (!map.isEmpty()) {
            arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter.Item.HeaderItem(R.string.premium_guild_subscription_active_title));
        }
        for (Map.Entry entry : map.entrySet()) {
            Long l = (Long) entry.getKey();
            ArrayList arrayList4 = (ArrayList) entry.getValue();
            Guild guild = guilds.get(l);
            if (l != null && guild != null) {
                arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildItem(guild, arrayList4.size()));
                Iterator it3 = arrayList4.iterator();
                while (it3.hasNext()) {
                    arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter.Item.GuildBoostItem((ModelGuildBoostSlot) it3.next(), subscription != null ? subscription.getCurrentPeriodEnd() : null));
                }
            }
        }
        return arrayList;
    }

    private final void fetchData() {
        this.storeGuildBoost.fetchUserGuildBoostState();
        this.storeSubscriptions.fetchSubscriptions();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0039  */
    @MainThread
    private final void handleStoreState(StoreState storeState) {
        Object loaded;
        boolean z2;
        SubscriptionPlanType planType;
        PremiumTier premiumTier;
        SubscriptionPlanType planType2;
        StoreGuildBoost.State guildBoostState = storeState.getGuildBoostState();
        StoreSubscriptions.SubscriptionsState subscriptionState = storeState.getSubscriptionState();
        if ((guildBoostState instanceof StoreGuildBoost.State.Loading) || (subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Loading)) {
            loaded = ViewState.Loading.INSTANCE;
        } else if ((guildBoostState instanceof StoreGuildBoost.State.Failure) || (subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Failure) || !(guildBoostState instanceof StoreGuildBoost.State.Loaded) || !(subscriptionState instanceof StoreSubscriptions.SubscriptionsState.Loaded)) {
            loaded = ViewState.Failure.INSTANCE;
        } else {
            ModelSubscription premiumSubscription = ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionState).getPremiumSubscription();
            boolean z3 = premiumSubscription != null && premiumSubscription.isGoogleSubscription();
            if (z3) {
                z2 = false;
            } else {
                if (((premiumSubscription == null || (planType = premiumSubscription.getPlanType()) == null) ? null : planType.getPremiumTier()) == PremiumTier.TIER_2) {
                    Map<Long, ModelGuildBoostSlot> boostSlotMap = ((StoreGuildBoost.State.Loaded) guildBoostState).getBoostSlotMap();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry<Long, ModelGuildBoostSlot> entry : boostSlotMap.entrySet()) {
                        if (!entry.getValue().getCanceled()) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    if (linkedHashMap.size() <= 2) {
                        z2 = false;
                    }
                }
                z2 = true;
            }
            boolean z4 = !z3;
            List<WidgetSettingsGuildBoostSubscriptionAdapter.Item> listCreateGuildBoostItems = createGuildBoostItems((StoreGuildBoost.State.Loaded) guildBoostState, storeState.getGuilds(), premiumSubscription);
            List listTake = _Collections.take(storeState.getGuilds().values(), 4);
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listTake, 10));
            Iterator it = listTake.iterator();
            while (it.hasNext()) {
                arrayList.add(new SettingsGuildBoostSampleGuildAdapter.Item((Guild) it.next()));
            }
            if (premiumSubscription == null || (planType2 = premiumSubscription.getPlanType()) == null || (premiumTier = planType2.getPremiumTier()) == null) {
                premiumTier = PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY;
            }
            loaded = new ViewState.Loaded(z2, z4, listCreateGuildBoostItems, arrayList, null, premiumTier);
        }
        updateViewState(loaded);
    }

    @MainThread
    public final void cancelClicked(long slotId, boolean cancel) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, null, cancel ? new PendingAction.Cancel(slotId) : new PendingAction.Uncancel(slotId), null, 47, null));
        }
    }

    @MainThread
    public final void consumePendingAction() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, null, null, null, 47, null));
        }
    }

    @MainThread
    public final void handleGuildSearchCallback(long guildId) {
        PendingAction pendingActionCopy$default;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            PendingAction pendingAction = loaded.getPendingAction();
            if (pendingAction instanceof PendingAction.Transfer) {
                pendingActionCopy$default = PendingAction.Transfer.copy$default((PendingAction.Transfer) loaded.getPendingAction(), null, 0L, Long.valueOf(guildId), 3, null);
            } else {
                pendingActionCopy$default = pendingAction instanceof PendingAction.Subscribe ? PendingAction.Subscribe.copy$default((PendingAction.Subscribe) loaded.getPendingAction(), 0L, Long.valueOf(guildId), 1, null) : loaded.getPendingAction();
            }
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, null, pendingActionCopy$default, null, 47, null));
        }
    }

    @MainThread
    public final void retryClicked() {
        fetchData();
    }

    @MainThread
    public final void subscribeClicked(long slotId) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, null, new PendingAction.Subscribe(slotId, null, 2, null), null, 47, null));
        }
    }

    @MainThread
    public final void transferClicked(ModelGuildBoostSlot slot, long previousGuildId) {
        Intrinsics3.checkNotNullParameter(slot, "slot");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, null, null, new PendingAction.Transfer(slot, previousGuildId, null, 4, null), null, 47, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGuildBoostViewModel(StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        Intrinsics3.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storeGuildBoost = storeGuildBoost;
        this.storeSubscriptions = storeSubscriptions;
        fetchData();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) SettingsGuildBoostViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
