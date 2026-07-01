package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Failed;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded;
import com.discord.stores.StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loading;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionViewModel extends d0<ServerSettingsGuildRoleSubscriptionViewModel$ViewState> {
    public static final ServerSettingsGuildRoleSubscriptionViewModel$Companion Companion = new ServerSettingsGuildRoleSubscriptionViewModel$Companion(null);
    private String editedGroupCoverImage;
    private String editedGroupDescription;
    private Boolean editedIsFullServerGating;
    private final PublishSubject<ServerSettingsGuildRoleSubscriptionViewModel$Event> eventSubject;
    private Boolean fullServerGatingOverwrite;
    private final long guildId;
    private GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI;
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 4) != 0 ? StoreStream.Companion.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        ObservationDeck observationDeck2 = (i & 16) != 0 ? ObservationDeckProvider.get() : observationDeck;
        this(j, api, guildRoleSubscriptions, guilds, observationDeck2, (i & 32) != 0 ? ServerSettingsGuildRoleSubscriptionViewModel$Companion.access$observeStoreState(Companion, j, observationDeck2, guildRoleSubscriptions, guilds) : observable);
    }

    public static final /* synthetic */ void access$emitEvent(ServerSettingsGuildRoleSubscriptionViewModel serverSettingsGuildRoleSubscriptionViewModel, ServerSettingsGuildRoleSubscriptionViewModel$Event serverSettingsGuildRoleSubscriptionViewModel$Event) {
        serverSettingsGuildRoleSubscriptionViewModel.emitEvent(serverSettingsGuildRoleSubscriptionViewModel$Event);
    }

    public static final /* synthetic */ void access$handleStoreState(ServerSettingsGuildRoleSubscriptionViewModel serverSettingsGuildRoleSubscriptionViewModel, ServerSettingsGuildRoleSubscriptionViewModel$StoreState serverSettingsGuildRoleSubscriptionViewModel$StoreState) {
        serverSettingsGuildRoleSubscriptionViewModel.handleStoreState(serverSettingsGuildRoleSubscriptionViewModel$StoreState);
    }

    public static final /* synthetic */ void access$updateViewState(ServerSettingsGuildRoleSubscriptionViewModel serverSettingsGuildRoleSubscriptionViewModel, ServerSettingsGuildRoleSubscriptionViewModel$ViewState serverSettingsGuildRoleSubscriptionViewModel$ViewState) {
        serverSettingsGuildRoleSubscriptionViewModel.updateViewState(serverSettingsGuildRoleSubscriptionViewModel$ViewState);
    }

    @MainThread
    private final void emitEvent(ServerSettingsGuildRoleSubscriptionViewModel$Event event) {
        this.eventSubject.k.onNext(event);
    }

    private final void handleStoreState(ServerSettingsGuildRoleSubscriptionViewModel$StoreState storeState) {
        StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = storeState.getGuildRoleSubscriptionGroupState();
        if ((guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loading) || guildRoleSubscriptionGroupState == null) {
            updateViewState(ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loading.INSTANCE);
            return;
        }
        if (!(guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded)) {
            if (guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Failed) {
                updateViewState(ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Failed.INSTANCE);
                return;
            }
            return;
        }
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = ((StoreGuildRoleSubscriptions$GuildRoleSubscriptionGroupState$Loaded) storeState.getGuildRoleSubscriptionGroupState()).getGuildRoleSubscriptionGroupListing();
        if (guildRoleSubscriptionGroupListing == null) {
            updateViewState(ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Empty.INSTANCE);
            return;
        }
        ServerSettingsGuildRoleSubscriptionViewModel$ViewState serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState = requireViewState();
        if (!(serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState instanceof ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded)) {
            serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState = null;
        }
        ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded) serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState;
        boolean hasChanges = serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded != null ? serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.getHasChanges() : false;
        if (!hasChanges) {
            this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            emitEvent(new ServerSettingsGuildRoleSubscriptionViewModel$Event$StoreStateUpdate(guildRoleSubscriptionGroupListing, storeState.getFullServerGatingOverwrite()));
        }
        updateViewState(new ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded(hasChanges, serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded != null ? serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.isSubmitting() : false, guildRoleSubscriptionGroupListing.getId()));
    }

    public final Observable<ServerSettingsGuildRoleSubscriptionViewModel$Event> observeEvents() {
        PublishSubject<ServerSettingsGuildRoleSubscriptionViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0034  */
    public final void onGuildRoleSubscriptionGroupUpdated(String description, String coverImage, boolean isFullServerGating) {
        boolean z2;
        boolean z3;
        ServerSettingsGuildRoleSubscriptionViewModel$ViewState serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState = requireViewState();
        if (!(serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState instanceof ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded)) {
            serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState = null;
        }
        ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded) serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState;
        if (serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded != null) {
            GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
            if (!m.areEqual(guildRoleSubscriptionGroupListing != null ? guildRoleSubscriptionGroupListing.getDescription() : null, description)) {
                if (description == null || t.isBlank(description)) {
                    this.editedGroupDescription = null;
                    z2 = false;
                } else {
                    this.editedGroupDescription = description;
                    z2 = true;
                }
            } else {
                this.editedGroupDescription = null;
                z2 = false;
            }
            if (coverImage == null || t.isBlank(coverImage)) {
                this.editedGroupCoverImage = null;
            } else {
                this.editedGroupCoverImage = coverImage;
                z2 = true;
            }
            Boolean boolValueOf = this.fullServerGatingOverwrite;
            if (boolValueOf == null) {
                GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing2 = this.guildRoleSubscriptionGroupListing;
                boolValueOf = guildRoleSubscriptionGroupListing2 != null ? Boolean.valueOf(guildRoleSubscriptionGroupListing2.getFullServerGate()) : null;
            }
            if (!m.areEqual(boolValueOf, Boolean.valueOf(isFullServerGating))) {
                this.editedIsFullServerGating = Boolean.valueOf(isFullServerGating);
                z3 = true;
            } else {
                this.editedIsFullServerGating = null;
                z3 = z2;
            }
            updateViewState(ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.copy$default(serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded, z3, false, 0L, 6, null));
        }
    }

    public final void submitChanges() {
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
        if (guildRoleSubscriptionGroupListing != null) {
            long id2 = guildRoleSubscriptionGroupListing.getId();
            ServerSettingsGuildRoleSubscriptionViewModel$ViewState serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState = requireViewState();
            if (!(serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState instanceof ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded)) {
                serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState = null;
            }
            ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded = (ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded) serverSettingsGuildRoleSubscriptionViewModel$ViewStateRequireViewState;
            if (serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded != null) {
                updateViewState(ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded.copy$default(serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded, false, true, 0L, 5, null));
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.updateGuildRoleSubscriptionGroupListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, id2, this.editedGroupCoverImage, this.editedGroupDescription, this.editedIsFullServerGating), this, null, 2, null), ServerSettingsGuildRoleSubscriptionViewModel.class, (Context) null, (Function1) null, new ServerSettingsGuildRoleSubscriptionViewModel$submitChanges$2(this, serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded), (Function0) null, (Function0) null, new ServerSettingsGuildRoleSubscriptionViewModel$submitChanges$1(this, serverSettingsGuildRoleSubscriptionViewModel$ViewState$Loaded), 54, (Object) null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable<ServerSettingsGuildRoleSubscriptionViewModel$StoreState> observable) {
        super(ServerSettingsGuildRoleSubscriptionViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(restAPI, "restApi");
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
        storeGuildRoleSubscriptions.fetchGuildRoleSubscriptionGroupsForGuild(j);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), ServerSettingsGuildRoleSubscriptionViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ServerSettingsGuildRoleSubscriptionViewModel$1(this), 62, (Object) null);
    }
}
