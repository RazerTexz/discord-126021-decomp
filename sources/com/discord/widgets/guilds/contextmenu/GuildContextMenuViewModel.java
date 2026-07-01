package com.discord.widgets.guilds.contextmenu;

import a0.a.a.b;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreReadStates;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func4;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildContextMenuViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;
    private final Observable<StoreState> storeStateObservable;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(GuildContextMenuViewModel guildContextMenuViewModel) {
            super(1, guildContextMenuViewModel, GuildContextMenuViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/contextmenu/GuildContextMenuViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((GuildContextMenuViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreGuilds guildStore, StoreUser userStore, StoreReadStates readStateStore, StoreGuildSelected selectedGuildStore) {
            Observable<StoreState> observableH = Observable.h(guildStore.observeGuild(guildId), StoreUser.observeMe$default(userStore, false, 1, null), readStateStore.getIsUnread(guildId), selectedGuildStore.observeSelectedGuildId(), new Func4<Guild, MeUser, Boolean, Long, StoreState>() { // from class: com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func4
                public final GuildContextMenuViewModel.StoreState call(Guild guild, MeUser meUser, Boolean bool, Long l) {
                    if (guild == null) {
                        return GuildContextMenuViewModel.StoreState.Invalid.INSTANCE;
                    }
                    long id2 = meUser.getId();
                    Intrinsics3.checkNotNullExpressionValue(bool, "isUnread");
                    boolean zBooleanValue = bool.booleanValue();
                    Intrinsics3.checkNotNullExpressionValue(l, "selectedGuildId");
                    return new GuildContextMenuViewModel.StoreState.Valid(guild, id2, zBooleanValue, l.longValue());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…      )\n        }\n      }");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
        public static final class Dismiss extends Event {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final Guild guild;
            private final boolean isGuildUnread;
            private final long myUserId;
            private final long selectedGuildId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, long j, boolean z2, long j2) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.myUserId = j;
                this.isGuildUnread = z2;
                this.selectedGuildId = j2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, long j, boolean z2, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    j = valid.myUserId;
                }
                long j3 = j;
                if ((i & 4) != 0) {
                    z2 = valid.isGuildUnread;
                }
                boolean z3 = z2;
                if ((i & 8) != 0) {
                    j2 = valid.selectedGuildId;
                }
                return valid.copy(guild, j3, z3, j2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsGuildUnread() {
                return this.isGuildUnread;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final long getSelectedGuildId() {
                return this.selectedGuildId;
            }

            public final Valid copy(Guild guild, long myUserId, boolean isGuildUnread, long selectedGuildId) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Valid(guild, myUserId, isGuildUnread, selectedGuildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && this.myUserId == valid.myUserId && this.isGuildUnread == valid.isGuildUnread && this.selectedGuildId == valid.selectedGuildId;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            public final long getSelectedGuildId() {
                return this.selectedGuildId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10 */
            /* JADX WARN: Type inference failed for: r0v5, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8 */
            /* JADX WARN: Type inference failed for: r1v4, types: [int] */
            public int hashCode() {
                Guild guild = this.guild;
                int iA = (b.a(this.myUserId) + ((guild != null ? guild.hashCode() : 0) * 31)) * 31;
                boolean z2 = this.isGuildUnread;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                return b.a(this.selectedGuildId) + ((iA + r0) * 31);
            }

            public final boolean isGuildUnread() {
                return this.isGuildUnread;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", myUserId=");
                sbU.append(this.myUserId);
                sbU.append(", isGuildUnread=");
                sbU.append(this.isGuildUnread);
                sbU.append(", selectedGuildId=");
                return outline.C(sbU, this.selectedGuildId, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final Guild guild;
            private final boolean isGuildSelected;
            private final boolean showLeaveGuild;
            private final boolean showMarkAsRead;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, boolean z2, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.showMarkAsRead = z2;
                this.showLeaveGuild = z3;
                this.isGuildSelected = z4;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    z2 = valid.showMarkAsRead;
                }
                if ((i & 4) != 0) {
                    z3 = valid.showLeaveGuild;
                }
                if ((i & 8) != 0) {
                    z4 = valid.isGuildSelected;
                }
                return valid.copy(guild, z2, z3, z4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getShowMarkAsRead() {
                return this.showMarkAsRead;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getShowLeaveGuild() {
                return this.showLeaveGuild;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsGuildSelected() {
                return this.isGuildSelected;
            }

            public final Valid copy(Guild guild, boolean showMarkAsRead, boolean showLeaveGuild, boolean isGuildSelected) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return new Valid(guild, showMarkAsRead, showLeaveGuild, isGuildSelected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return Intrinsics3.areEqual(this.guild, valid.guild) && this.showMarkAsRead == valid.showMarkAsRead && this.showLeaveGuild == valid.showLeaveGuild && this.isGuildSelected == valid.isGuildSelected;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getShowLeaveGuild() {
                return this.showLeaveGuild;
            }

            public final boolean getShowMarkAsRead() {
                return this.showMarkAsRead;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v6 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                boolean z2 = this.showMarkAsRead;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean z3 = this.showLeaveGuild;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean z4 = this.isGuildSelected;
                return i2 + (z4 ? 1 : z4);
            }

            public final boolean isGuildSelected() {
                return this.isGuildSelected;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", showMarkAsRead=");
                sbU.append(this.showMarkAsRead);
                sbU.append(", showLeaveGuild=");
                sbU.append(this.showLeaveGuild);
                sbU.append(", isGuildSelected=");
                return outline.O(sbU, this.isGuildSelected, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel$onMarkAsReadClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            GuildContextMenuViewModel.this.eventSubject.k.onNext((T) Event.Dismiss.INSTANCE);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildContextMenuViewModel(long j, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        restAPI = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 4) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = companion.observeStoreState(j, companion2.getGuilds(), companion2.getUsers(), companion2.getReadStates(), companion2.getGuildSelected());
        }
        this(j, restAPI, observable);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid = (StoreState.Valid) storeState;
            updateViewState(new ViewState.Valid(valid.getGuild(), valid.isGuildUnread(), valid.getGuild().getOwnerId() != valid.getMyUserId(), valid.getSelectedGuildId() == valid.getGuild().getId()));
        } else if (Intrinsics3.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            updateViewState(ViewState.Invalid.INSTANCE);
        }
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onMarkAsReadClicked() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuild(this.guildId), false, 1, null), this, null, 2, null), (Class<?>) GuildContextMenuViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildContextMenuViewModel(long j, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) GuildContextMenuViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
