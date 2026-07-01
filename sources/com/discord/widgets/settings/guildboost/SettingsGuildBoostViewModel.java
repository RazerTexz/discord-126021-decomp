package com.discord.widgets.settings.guildboost;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.premium.PremiumTier;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildBoost;
import com.discord.stores.StoreGuildBoost$State;
import com.discord.stores.StoreGuildBoost$State$Failure;
import com.discord.stores.StoreGuildBoost$State$Loaded;
import com.discord.stores.StoreGuildBoost$State$Loading;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreSubscriptions$SubscriptionsState;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Failure;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loaded;
import com.discord.stores.StoreSubscriptions$SubscriptionsState$Loading;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: SettingsGuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGuildBoostViewModel extends d0<SettingsGuildBoostViewModel$ViewState> {
    public static final SettingsGuildBoostViewModel$Companion Companion = new SettingsGuildBoostViewModel$Companion(null);
    private static final int NUM_SAMPLE_GUILDS = 4;
    private static final Long UNUSED_GUILD_BOOST_GUILD_ID = null;
    private final StoreGuildBoost storeGuildBoost;
    private final StoreSubscriptions storeSubscriptions;

    public SettingsGuildBoostViewModel() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ SettingsGuildBoostViewModel(StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getGuildBoosts() : storeGuildBoost, (i & 2) != 0 ? StoreStream.Companion.getSubscriptions() : storeSubscriptions, (i & 4) != 0 ? SettingsGuildBoostViewModel$Companion.access$observeStores(Companion) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(SettingsGuildBoostViewModel settingsGuildBoostViewModel, SettingsGuildBoostViewModel$StoreState settingsGuildBoostViewModel$StoreState) {
        settingsGuildBoostViewModel.handleStoreState(settingsGuildBoostViewModel$StoreState);
    }

    private final List<WidgetSettingsGuildBoostSubscriptionAdapter$Item> createGuildBoostItems(StoreGuildBoost$State$Loaded guildSubState, Map<Long, Guild> guilds, ModelSubscription subscription) {
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
                arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem((ModelGuildBoostSlot) it2.next(), subscription != null ? subscription.getCurrentPeriodEnd() : null));
            }
        }
        if (!map.isEmpty()) {
            arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter$Item$HeaderItem(2131894082));
        }
        for (Map$Entry map$Entry : map.entrySet()) {
            Long l = (Long) map$Entry.getKey();
            ArrayList arrayList4 = (ArrayList) map$Entry.getValue();
            Guild guild = guilds.get(l);
            if (l != null && guild != null) {
                arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildItem(guild, arrayList4.size()));
                Iterator it3 = arrayList4.iterator();
                while (it3.hasNext()) {
                    arrayList.add(new WidgetSettingsGuildBoostSubscriptionAdapter$Item$GuildBoostItem((ModelGuildBoostSlot) it3.next(), subscription != null ? subscription.getCurrentPeriodEnd() : null));
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
    private final void handleStoreState(SettingsGuildBoostViewModel$StoreState storeState) {
        Object settingsGuildBoostViewModel$ViewState$Loaded;
        boolean z2;
        SubscriptionPlanType planType;
        PremiumTier premiumTier;
        SubscriptionPlanType planType2;
        StoreGuildBoost$State guildBoostState = storeState.getGuildBoostState();
        StoreSubscriptions$SubscriptionsState subscriptionState = storeState.getSubscriptionState();
        if ((guildBoostState instanceof StoreGuildBoost$State$Loading) || (subscriptionState instanceof StoreSubscriptions$SubscriptionsState$Loading)) {
            settingsGuildBoostViewModel$ViewState$Loaded = SettingsGuildBoostViewModel$ViewState$Loading.INSTANCE;
        } else if ((guildBoostState instanceof StoreGuildBoost$State$Failure) || (subscriptionState instanceof StoreSubscriptions$SubscriptionsState$Failure) || !(guildBoostState instanceof StoreGuildBoost$State$Loaded) || !(subscriptionState instanceof StoreSubscriptions$SubscriptionsState$Loaded)) {
            settingsGuildBoostViewModel$ViewState$Loaded = SettingsGuildBoostViewModel$ViewState$Failure.INSTANCE;
        } else {
            ModelSubscription premiumSubscription = ((StoreSubscriptions$SubscriptionsState$Loaded) subscriptionState).getPremiumSubscription();
            boolean z3 = premiumSubscription != null && premiumSubscription.isGoogleSubscription();
            if (z3) {
                z2 = false;
            } else {
                if (((premiumSubscription == null || (planType = premiumSubscription.getPlanType()) == null) ? null : planType.getPremiumTier()) == PremiumTier.TIER_2) {
                    Map<Long, ModelGuildBoostSlot> boostSlotMap = ((StoreGuildBoost$State$Loaded) guildBoostState).getBoostSlotMap();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map$Entry<Long, ModelGuildBoostSlot> map$Entry : boostSlotMap.entrySet()) {
                        if (!map$Entry.getValue().getCanceled()) {
                            linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
                        }
                    }
                    if (linkedHashMap.size() <= 2) {
                        z2 = false;
                    }
                }
                z2 = true;
            }
            boolean z4 = !z3;
            List<WidgetSettingsGuildBoostSubscriptionAdapter$Item> listCreateGuildBoostItems = createGuildBoostItems((StoreGuildBoost$State$Loaded) guildBoostState, storeState.getGuilds(), premiumSubscription);
            List listTake = u.take(storeState.getGuilds().values(), 4);
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(listTake, 10));
            Iterator it = listTake.iterator();
            while (it.hasNext()) {
                arrayList.add(new SettingsGuildBoostSampleGuildAdapter$Item((Guild) it.next()));
            }
            if (premiumSubscription == null || (planType2 = premiumSubscription.getPlanType()) == null || (premiumTier = planType2.getPremiumTier()) == null) {
                premiumTier = PremiumTier.PREMIUM_GUILD_SUBSCRIPTION_ONLY;
            }
            settingsGuildBoostViewModel$ViewState$Loaded = new SettingsGuildBoostViewModel$ViewState$Loaded(z2, z4, listCreateGuildBoostItems, arrayList, null, premiumTier);
        }
        updateViewState(settingsGuildBoostViewModel$ViewState$Loaded);
    }

    @MainThread
    public final void cancelClicked(long slotId, boolean cancel) {
        SettingsGuildBoostViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsGuildBoostViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsGuildBoostViewModel$ViewState$Loaded settingsGuildBoostViewModel$ViewState$Loaded = (SettingsGuildBoostViewModel$ViewState$Loaded) viewState;
        if (settingsGuildBoostViewModel$ViewState$Loaded != null) {
            updateViewState(SettingsGuildBoostViewModel$ViewState$Loaded.copy$default(settingsGuildBoostViewModel$ViewState$Loaded, false, false, null, null, cancel ? new SettingsGuildBoostViewModel$PendingAction$Cancel(slotId) : new SettingsGuildBoostViewModel$PendingAction$Uncancel(slotId), null, 47, null));
        }
    }

    @MainThread
    public final void consumePendingAction() {
        SettingsGuildBoostViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsGuildBoostViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsGuildBoostViewModel$ViewState$Loaded settingsGuildBoostViewModel$ViewState$Loaded = (SettingsGuildBoostViewModel$ViewState$Loaded) viewState;
        if (settingsGuildBoostViewModel$ViewState$Loaded != null) {
            updateViewState(SettingsGuildBoostViewModel$ViewState$Loaded.copy$default(settingsGuildBoostViewModel$ViewState$Loaded, false, false, null, null, null, null, 47, null));
        }
    }

    @MainThread
    public final void handleGuildSearchCallback(long guildId) {
        SettingsGuildBoostViewModel$PendingAction settingsGuildBoostViewModel$PendingActionCopy$default;
        SettingsGuildBoostViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsGuildBoostViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsGuildBoostViewModel$ViewState$Loaded settingsGuildBoostViewModel$ViewState$Loaded = (SettingsGuildBoostViewModel$ViewState$Loaded) viewState;
        if (settingsGuildBoostViewModel$ViewState$Loaded != null) {
            SettingsGuildBoostViewModel$PendingAction pendingAction = settingsGuildBoostViewModel$ViewState$Loaded.getPendingAction();
            if (pendingAction instanceof SettingsGuildBoostViewModel$PendingAction$Transfer) {
                settingsGuildBoostViewModel$PendingActionCopy$default = SettingsGuildBoostViewModel$PendingAction$Transfer.copy$default((SettingsGuildBoostViewModel$PendingAction$Transfer) settingsGuildBoostViewModel$ViewState$Loaded.getPendingAction(), null, 0L, Long.valueOf(guildId), 3, null);
            } else {
                settingsGuildBoostViewModel$PendingActionCopy$default = pendingAction instanceof SettingsGuildBoostViewModel$PendingAction$Subscribe ? SettingsGuildBoostViewModel$PendingAction$Subscribe.copy$default((SettingsGuildBoostViewModel$PendingAction$Subscribe) settingsGuildBoostViewModel$ViewState$Loaded.getPendingAction(), 0L, Long.valueOf(guildId), 1, null) : settingsGuildBoostViewModel$ViewState$Loaded.getPendingAction();
            }
            updateViewState(SettingsGuildBoostViewModel$ViewState$Loaded.copy$default(settingsGuildBoostViewModel$ViewState$Loaded, false, false, null, null, settingsGuildBoostViewModel$PendingActionCopy$default, null, 47, null));
        }
    }

    @MainThread
    public final void retryClicked() {
        fetchData();
    }

    @MainThread
    public final void subscribeClicked(long slotId) {
        SettingsGuildBoostViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsGuildBoostViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsGuildBoostViewModel$ViewState$Loaded settingsGuildBoostViewModel$ViewState$Loaded = (SettingsGuildBoostViewModel$ViewState$Loaded) viewState;
        if (settingsGuildBoostViewModel$ViewState$Loaded != null) {
            updateViewState(SettingsGuildBoostViewModel$ViewState$Loaded.copy$default(settingsGuildBoostViewModel$ViewState$Loaded, false, false, null, null, new SettingsGuildBoostViewModel$PendingAction$Subscribe(slotId, null, 2, null), null, 47, null));
        }
    }

    @MainThread
    public final void transferClicked(ModelGuildBoostSlot slot, long previousGuildId) {
        m.checkNotNullParameter(slot, "slot");
        SettingsGuildBoostViewModel$ViewState viewState = getViewState();
        if (!(viewState instanceof SettingsGuildBoostViewModel$ViewState$Loaded)) {
            viewState = null;
        }
        SettingsGuildBoostViewModel$ViewState$Loaded settingsGuildBoostViewModel$ViewState$Loaded = (SettingsGuildBoostViewModel$ViewState$Loaded) viewState;
        if (settingsGuildBoostViewModel$ViewState$Loaded != null) {
            updateViewState(SettingsGuildBoostViewModel$ViewState$Loaded.copy$default(settingsGuildBoostViewModel$ViewState$Loaded, false, false, null, null, new SettingsGuildBoostViewModel$PendingAction$Transfer(slot, previousGuildId, null, 4, null), null, 47, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGuildBoostViewModel(StoreGuildBoost storeGuildBoost, StoreSubscriptions storeSubscriptions, Observable<SettingsGuildBoostViewModel$StoreState> observable) {
        super(SettingsGuildBoostViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(storeGuildBoost, "storeGuildBoost");
        m.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        m.checkNotNullParameter(observable, "storeObservable");
        this.storeGuildBoost = storeGuildBoost;
        this.storeSubscriptions = storeSubscriptions;
        fetchData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), SettingsGuildBoostViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new SettingsGuildBoostViewModel$1(this), 62, (Object) null);
    }
}
