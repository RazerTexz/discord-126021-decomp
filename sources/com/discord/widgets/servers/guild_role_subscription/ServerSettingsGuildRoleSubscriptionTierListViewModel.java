package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import b.a.d.d0;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Failed;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loading;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierListViewModel extends d0<ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState> {
    public static final ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion Companion = new ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion(null);
    private static final int MAX_TIER_ITEMS = 3;
    private final long guildId;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ServerSettingsGuildRoleSubscriptionTierListViewModel(long j, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 2) != 0 ? StoreStream.Companion.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        ObservationDeck observationDeck2 = (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck;
        this(j, guildRoleSubscriptions, observationDeck2, (i & 8) != 0 ? ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion.access$observeStoreState(Companion, j, observationDeck2, guildRoleSubscriptions) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(ServerSettingsGuildRoleSubscriptionTierListViewModel serverSettingsGuildRoleSubscriptionTierListViewModel, ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState serverSettingsGuildRoleSubscriptionTierListViewModel$StoreState) {
        serverSettingsGuildRoleSubscriptionTierListViewModel.handleStoreState(serverSettingsGuildRoleSubscriptionTierListViewModel$StoreState);
    }

    private final void handleStoreState(ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState storeState) {
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = storeState.getGuildRoleSubscriptionGroupState();
        if ((guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loading) || guildRoleSubscriptionGroupState == null) {
            updateViewState(ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loading.INSTANCE);
            return;
        }
        if (!(guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded)) {
            if (guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Failed) {
                updateViewState(ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Failed.INSTANCE);
            }
        } else {
            GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = ((StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded) storeState.getGuildRoleSubscriptionGroupState()).getGuildRoleSubscriptionGroupListing();
            if (guildRoleSubscriptionGroupListing == null) {
                updateViewState(ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Failed.INSTANCE);
            } else {
                updateViewState(new ServerSettingsGuildRoleSubscriptionTierListViewModel$ViewState$Loaded(ServerSettingsGuildRoleSubscriptionTierListItemGeneratorKt.generateServerSettingsGuildRoleSubscriptionTierListItems(guildRoleSubscriptionGroupListing.h(), 3), guildRoleSubscriptionGroupListing.getId()));
            }
        }
    }

    private static final Observable<ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState> observeStoreState(long j, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return ServerSettingsGuildRoleSubscriptionTierListViewModel$Companion.access$observeStoreState(Companion, j, observationDeck, storeGuildRoleSubscriptions);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionTierListViewModel(long j, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, Observable<ServerSettingsGuildRoleSubscriptionTierListViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        storeGuildRoleSubscriptions.fetchGuildRoleSubscriptionGroupsForGuild(j);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ServerSettingsGuildRoleSubscriptionTierListViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ServerSettingsGuildRoleSubscriptionTierListViewModel$1(this), 62, (Object) null);
    }
}
