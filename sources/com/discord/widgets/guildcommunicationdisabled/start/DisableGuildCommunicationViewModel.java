package com.discord.widgets.guildcommunicationdisabled.start;

import a0.a.a.b;
import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserCommunicationDisabledUpdate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DisableGuildCommunicationViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long guildId;
    private final long userId;

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.DisableGuildCommunicationViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(DisableGuildCommunicationViewModel disableGuildCommunicationViewModel) {
            super(1, disableGuildCommunicationViewModel, DisableGuildCommunicationViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildcommunicationdisabled/start/DisableGuildCommunicationViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((DisableGuildCommunicationViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long userId, long guildId, ObservationDeck observationDeck, StoreUser userStore, StoreGuilds guildsStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{userStore, guildsStore}, false, null, null, new DisableGuildCommunicationViewModel2(userStore, userId, guildsStore, guildId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final User user;

        public StoreState(User user, Guild guild) {
            this.user = user;
            this.guild = guild;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, User user, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                user = storeState.user;
            }
            if ((i & 2) != 0) {
                guild = storeState.guild;
            }
            return storeState.copy(user, guild);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final StoreState copy(User user, Guild guild) {
            return new StoreState(user, guild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.guild, storeState.guild);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            Guild guild = this.guild;
            return iHashCode + (guild != null ? guild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(user=");
            sbU.append(this.user);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final long guildId;
            private final GuildCommunicationDisabledDateUtils2 selectedDurationOption;
            private final User user;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(User user, long j, GuildCommunicationDisabledDateUtils2 guildCommunicationDisabledDateUtils2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildCommunicationDisabledDateUtils2, "selectedDurationOption");
                this.user = user;
                this.guildId = j;
                this.selectedDurationOption = guildCommunicationDisabledDateUtils2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, User user, long j, GuildCommunicationDisabledDateUtils2 guildCommunicationDisabledDateUtils2, int i, Object obj) {
                if ((i & 1) != 0) {
                    user = valid.user;
                }
                if ((i & 2) != 0) {
                    j = valid.guildId;
                }
                if ((i & 4) != 0) {
                    guildCommunicationDisabledDateUtils2 = valid.selectedDurationOption;
                }
                return valid.copy(user, j, guildCommunicationDisabledDateUtils2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final GuildCommunicationDisabledDateUtils2 getSelectedDurationOption() {
                return this.selectedDurationOption;
            }

            public final Valid copy(User user, long guildId, GuildCommunicationDisabledDateUtils2 selectedDurationOption) {
                Intrinsics3.checkNotNullParameter(selectedDurationOption, "selectedDurationOption");
                return new Valid(user, guildId, selectedDurationOption);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.user, valid.user) && this.guildId == valid.guildId && Intrinsics3.areEqual(this.selectedDurationOption, valid.selectedDurationOption);
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final GuildCommunicationDisabledDateUtils2 getSelectedDurationOption() {
                return this.selectedDurationOption;
            }

            public final User getUser() {
                return this.user;
            }

            public int hashCode() {
                User user = this.user;
                int iA = (b.a(this.guildId) + ((user != null ? user.hashCode() : 0) * 31)) * 31;
                GuildCommunicationDisabledDateUtils2 guildCommunicationDisabledDateUtils2 = this.selectedDurationOption;
                return iA + (guildCommunicationDisabledDateUtils2 != null ? guildCommunicationDisabledDateUtils2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(user=");
                sbU.append(this.user);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", selectedDurationOption=");
                sbU.append(this.selectedDurationOption);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.DisableGuildCommunicationViewModel$onDisableCommunicationConfirm$1, reason: invalid class name */
    /* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, TrackNetworkMetadata2> {
        public final /* synthetic */ long $disabledUntilTimestamp;
        public final /* synthetic */ long $durationS;
        public final /* synthetic */ String $reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, String str) {
            super(1);
            this.$durationS = j;
            this.$disabledUntilTimestamp = j2;
            this.$reason = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public final TrackNetworkMetadata2 invoke(Void r7) {
            return new TrackNetworkActionUserCommunicationDisabledUpdate(Long.valueOf(DisableGuildCommunicationViewModel.this.guildId), Long.valueOf(DisableGuildCommunicationViewModel.this.userId), Float.valueOf(this.$durationS), this.$reason, Long.valueOf(this.$disabledUntilTimestamp));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.DisableGuildCommunicationViewModel$onDisableCommunicationConfirm$2, reason: invalid class name */
    /* JADX INFO: compiled from: DisableGuildCommunicationViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Function0 $onFinished;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function0 function0) {
            super(1);
            this.$onFinished = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            this.$onFinished.invoke();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DisableGuildCommunicationViewModel(long j, long j2, ObservationDeck observationDeck, StoreUser storeUser, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i & 4) != 0 ? ObservationDeck4.get() : observationDeck;
        StoreUser users = (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        this(j, j2, observationDeck2, users, guilds, (i & 32) != 0 ? INSTANCE.observeStores(j, j2, observationDeck2, users, guilds) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        GuildCommunicationDisabledDateUtils2 selectedDurationOption;
        ViewState valid;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid2 = (ViewState.Valid) viewState;
        if (storeState.getGuild() == null) {
            valid = ViewState.Invalid.INSTANCE;
        } else {
            User user = storeState.getUser();
            long id2 = storeState.getGuild().getId();
            if (valid2 == null || (selectedDurationOption = valid2.getSelectedDurationOption()) == null) {
                selectedDurationOption = GuildCommunicationDisabledDateUtils2.SECONDS_60;
            }
            valid = new ViewState.Valid(user, id2, selectedDurationOption);
        }
        updateViewState(valid);
    }

    public final void onDisableCommunicationConfirm(WeakReference<Context> context, String reason, Function0<Unit> onFinished) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(onFinished, "onFinished");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            ViewState.Valid valid = (ViewState.Valid) viewState;
            Tuples2<String, Long> futureTimestamp = GuildCommunicationDisabledDateUtils.INSTANCE.getFutureTimestamp(valid.getSelectedDurationOption().getDurationMs());
            String strComponent1 = futureTimestamp.component1();
            long jLongValue = futureTimestamp.component2().longValue();
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(RestCallState5.logNetworkAction(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().disableGuildCommunication(this.guildId, this.userId, new RestAPIParams.DisableGuildCommunication(strComponent1), reason), false, 1, null), new AnonymousClass1(((long) valid.getSelectedDurationOption().getDurationMs()) / 1000, jLongValue, reason)), this, null, 2, null), (Class<?>) DisableGuildCommunicationViewModel.class, (58 & 2) != 0 ? null : context.get(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(onFinished));
        }
    }

    public final void onDurationLengthSelected(GuildCommunicationDisabledDateUtils2 duration) {
        Intrinsics3.checkNotNullParameter(duration, "duration");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            updateViewState(ViewState.Valid.copy$default((ViewState.Valid) viewState, null, 0L, duration, 3, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisableGuildCommunicationViewModel(long j, long j2, ObservationDeck observationDeck, StoreUser storeUser, StoreGuilds storeGuilds, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.userId = j;
        this.guildId = j2;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) DisableGuildCommunicationViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
