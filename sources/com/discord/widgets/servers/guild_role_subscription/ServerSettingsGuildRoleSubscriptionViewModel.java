package com.discord.widgets.servers.guild_role_subscription;

import a0.a.a.b;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String editedGroupCoverImage;
    private String editedGroupDescription;
    private Boolean editedIsFullServerGating;
    private final PublishSubject<Event> eventSubject;
    private Boolean fullServerGatingOverwrite;
    private final long guildId;
    private GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
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
            ServerSettingsGuildRoleSubscriptionViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new ServerSettingsGuildRoleSubscriptionViewModel2(storeGuildRoleSubscriptions, guildId, storeGuilds), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        public static final /* data */ class StoreStateUpdate extends Event {
            private final Boolean fullServerGatingOverwrite;
            private final GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;

            public /* synthetic */ StoreStateUpdate(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(guildRoleSubscriptionGroupListing, (i & 2) != 0 ? null : bool);
            }

            public static /* synthetic */ StoreStateUpdate copy$default(StoreStateUpdate storeStateUpdate, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildRoleSubscriptionGroupListing = storeStateUpdate.guildRoleSubscriptionGroupListing;
                }
                if ((i & 2) != 0) {
                    bool = storeStateUpdate.fullServerGatingOverwrite;
                }
                return storeStateUpdate.copy(guildRoleSubscriptionGroupListing, bool);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
                return this.guildRoleSubscriptionGroupListing;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Boolean getFullServerGatingOverwrite() {
                return this.fullServerGatingOverwrite;
            }

            public final StoreStateUpdate copy(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean fullServerGatingOverwrite) {
                Intrinsics3.checkNotNullParameter(guildRoleSubscriptionGroupListing, "guildRoleSubscriptionGroupListing");
                return new StoreStateUpdate(guildRoleSubscriptionGroupListing, fullServerGatingOverwrite);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof StoreStateUpdate)) {
                    return false;
                }
                StoreStateUpdate storeStateUpdate = (StoreStateUpdate) other;
                return Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListing, storeStateUpdate.guildRoleSubscriptionGroupListing) && Intrinsics3.areEqual(this.fullServerGatingOverwrite, storeStateUpdate.fullServerGatingOverwrite);
            }

            public final Boolean getFullServerGatingOverwrite() {
                return this.fullServerGatingOverwrite;
            }

            public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
                return this.guildRoleSubscriptionGroupListing;
            }

            public int hashCode() {
                GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
                int iHashCode = (guildRoleSubscriptionGroupListing != null ? guildRoleSubscriptionGroupListing.hashCode() : 0) * 31;
                Boolean bool = this.fullServerGatingOverwrite;
                return iHashCode + (bool != null ? bool.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("StoreStateUpdate(guildRoleSubscriptionGroupListing=");
                sbU.append(this.guildRoleSubscriptionGroupListing);
                sbU.append(", fullServerGatingOverwrite=");
                return outline.D(sbU, this.fullServerGatingOverwrite, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StoreStateUpdate(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildRoleSubscriptionGroupListing, "guildRoleSubscriptionGroupListing");
                this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
                this.fullServerGatingOverwrite = bool;
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        public static final /* data */ class SubmitFailure extends Event {
            private final Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubmitFailure(Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ SubmitFailure copy$default(SubmitFailure submitFailure, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    error = submitFailure.error;
                }
                return submitFailure.copy(error);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final SubmitFailure copy(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new SubmitFailure(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SubmitFailure) && Intrinsics3.areEqual(this.error, ((SubmitFailure) other).error);
                }
                return true;
            }

            public final Error getError() {
                return this.error;
            }

            public int hashCode() {
                Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SubmitFailure(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        public static final class SubmitSuccess extends Event {
            public static final SubmitSuccess INSTANCE = new SubmitSuccess();

            private SubmitSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    public static final /* data */ class StoreState {
        private final Boolean fullServerGatingOverwrite;
        private final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState;

        public StoreState(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, Boolean bool) {
            this.guildRoleSubscriptionGroupState = guildRoleSubscriptionGroupState;
            this.fullServerGatingOverwrite = bool;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionGroupState = storeState.guildRoleSubscriptionGroupState;
            }
            if ((i & 2) != 0) {
                bool = storeState.fullServerGatingOverwrite;
            }
            return storeState.copy(guildRoleSubscriptionGroupState, bool);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
            return this.guildRoleSubscriptionGroupState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getFullServerGatingOverwrite() {
            return this.fullServerGatingOverwrite;
        }

        public final StoreState copy(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, Boolean fullServerGatingOverwrite) {
            return new StoreState(guildRoleSubscriptionGroupState, fullServerGatingOverwrite);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildRoleSubscriptionGroupState, storeState.guildRoleSubscriptionGroupState) && Intrinsics3.areEqual(this.fullServerGatingOverwrite, storeState.fullServerGatingOverwrite);
        }

        public final Boolean getFullServerGatingOverwrite() {
            return this.fullServerGatingOverwrite;
        }

        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
            return this.guildRoleSubscriptionGroupState;
        }

        public int hashCode() {
            StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupState;
            int iHashCode = (guildRoleSubscriptionGroupState != null ? guildRoleSubscriptionGroupState.hashCode() : 0) * 31;
            Boolean bool = this.fullServerGatingOverwrite;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildRoleSubscriptionGroupState=");
            sbU.append(this.guildRoleSubscriptionGroupState);
            sbU.append(", fullServerGatingOverwrite=");
            return outline.D(sbU, this.fullServerGatingOverwrite, ")");
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        public static final class Empty extends ViewState {
            public static final Empty INSTANCE = new Empty();

            private Empty() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final long groupListingId;
            private final boolean hasChanges;
            private final boolean isSubmitting;

            public /* synthetic */ Loaded(boolean z2, boolean z3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, j);
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, boolean z3, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = loaded.hasChanges;
                }
                if ((i & 2) != 0) {
                    z3 = loaded.isSubmitting;
                }
                if ((i & 4) != 0) {
                    j = loaded.groupListingId;
                }
                return loaded.copy(z2, z3, j);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getHasChanges() {
                return this.hasChanges;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsSubmitting() {
                return this.isSubmitting;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getGroupListingId() {
                return this.groupListingId;
            }

            public final Loaded copy(boolean hasChanges, boolean isSubmitting, long groupListingId) {
                return new Loaded(hasChanges, isSubmitting, groupListingId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.hasChanges == loaded.hasChanges && this.isSubmitting == loaded.isSubmitting && this.groupListingId == loaded.groupListingId;
            }

            public final long getGroupListingId() {
                return this.groupListingId;
            }

            public final boolean getHasChanges() {
                return this.hasChanges;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r0v6 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            public int hashCode() {
                boolean z2 = this.hasChanges;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.isSubmitting;
                return b.a(this.groupListingId) + ((i + (z3 ? 1 : z3)) * 31);
            }

            public final boolean isSubmitting() {
                return this.isSubmitting;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(hasChanges=");
                sbU.append(this.hasChanges);
                sbU.append(", isSubmitting=");
                sbU.append(this.isSubmitting);
                sbU.append(", groupListingId=");
                return outline.C(sbU, this.groupListingId, ")");
            }

            public Loaded(boolean z2, boolean z3, long j) {
                super(null);
                this.hasChanges = z2;
                this.isSubmitting = z3;
                this.groupListingId = j;
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
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

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel$submitChanges$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionGroupListing, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            invoke2(guildRoleSubscriptionGroupListing);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionGroupListing, "it");
            ServerSettingsGuildRoleSubscriptionViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, false, false, 0L, 4, null));
            ServerSettingsGuildRoleSubscriptionViewModel.this.emitEvent(Event.SubmitSuccess.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionViewModel$submitChanges$2, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            ServerSettingsGuildRoleSubscriptionViewModel.this.updateViewState(ViewState.Loaded.copy$default(this.$viewState, false, false, 0L, 5, null));
            ServerSettingsGuildRoleSubscriptionViewModel.this.emitEvent(new Event.SubmitFailure(error));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ServerSettingsGuildRoleSubscriptionViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 4) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        ObservationDeck observationDeck2 = (i & 16) != 0 ? ObservationDeck4.get() : observationDeck;
        this(j, api, guildRoleSubscriptions, guilds, observationDeck2, (i & 32) != 0 ? INSTANCE.observeStoreState(j, observationDeck2, guildRoleSubscriptions, guilds) : observable);
    }

    @MainThread
    private final void emitEvent(Event event) {
        this.eventSubject.k.onNext(event);
    }

    private final void handleStoreState(StoreState storeState) {
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = storeState.getGuildRoleSubscriptionGroupState();
        if ((guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loading) || guildRoleSubscriptionGroupState == null) {
            updateViewState(ViewState.Loading.INSTANCE);
            return;
        }
        if (!(guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded)) {
            if (guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Failed) {
                updateViewState(ViewState.Failed.INSTANCE);
                return;
            }
            return;
        }
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = ((StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) storeState.getGuildRoleSubscriptionGroupState()).getGuildRoleSubscriptionGroupListing();
        if (guildRoleSubscriptionGroupListing == null) {
            updateViewState(ViewState.Empty.INSTANCE);
            return;
        }
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        boolean hasChanges = loaded != null ? loaded.getHasChanges() : false;
        if (!hasChanges) {
            this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            emitEvent(new Event.StoreStateUpdate(guildRoleSubscriptionGroupListing, storeState.getFullServerGatingOverwrite()));
        }
        updateViewState(new ViewState.Loaded(hasChanges, loaded != null ? loaded.isSubmitting() : false, guildRoleSubscriptionGroupListing.getId()));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0034  */
    public final void onGuildRoleSubscriptionGroupUpdated(String description, String coverImage, boolean isFullServerGating) {
        boolean z2;
        boolean z3;
        ViewState viewStateRequireViewState = requireViewState();
        if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
            viewStateRequireViewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
        if (loaded != null) {
            GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
            if (!Intrinsics3.areEqual(guildRoleSubscriptionGroupListing != null ? guildRoleSubscriptionGroupListing.getDescription() : null, description)) {
                if (description == null || StringsJVM.isBlank(description)) {
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
            if (coverImage == null || StringsJVM.isBlank(coverImage)) {
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
            if (!Intrinsics3.areEqual(boolValueOf, Boolean.valueOf(isFullServerGating))) {
                this.editedIsFullServerGating = Boolean.valueOf(isFullServerGating);
                z3 = true;
            } else {
                this.editedIsFullServerGating = null;
                z3 = z2;
            }
            updateViewState(ViewState.Loaded.copy$default(loaded, z3, false, 0L, 6, null));
        }
    }

    public final void submitChanges() {
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
        if (guildRoleSubscriptionGroupListing != null) {
            long id2 = guildRoleSubscriptionGroupListing.getId();
            ViewState viewStateRequireViewState = requireViewState();
            if (!(viewStateRequireViewState instanceof ViewState.Loaded)) {
                viewStateRequireViewState = null;
            }
            ViewState.Loaded loaded = (ViewState.Loaded) viewStateRequireViewState;
            if (loaded != null) {
                updateViewState(ViewState.Loaded.copy$default(loaded, false, true, 0L, 5, null));
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.updateGuildRoleSubscriptionGroupListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, id2, this.editedGroupCoverImage, this.editedGroupDescription, this.editedIsFullServerGating), this, null, 2, null), (Class<?>) ServerSettingsGuildRoleSubscriptionViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2(loaded)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(loaded));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionViewModel(long j, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
        storeGuildRoleSubscriptions.fetchGuildRoleSubscriptionGroupsForGuild(j);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) ServerSettingsGuildRoleSubscriptionViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
