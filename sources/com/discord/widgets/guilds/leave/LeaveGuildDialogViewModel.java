package com.discord.widgets.guilds.leave;

import androidx.annotation.MainThread;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LeaveGuildDialogViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final StoreLurking lurkingStore;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$1 */
    /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
    public static final /* synthetic */ class C87251 extends C12236k implements Function1<StoreState, Unit> {
        public C87251(LeaveGuildDialogViewModel leaveGuildDialogViewModel) {
            super(1, leaveGuildDialogViewModel, LeaveGuildDialogViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guilds/leave/LeaveGuildDialogViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "p1");
            ((LeaveGuildDialogViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, StoreGuilds guildStore, StoreLurking lurkingStore) {
            Observable<StoreState> observableM11076j = Observable.m11076j(guildStore.observeGuild(guildId), lurkingStore.isLurkingObs(guildId), new Func2<Guild, Boolean, StoreState>() { // from class: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$Companion$observeStoreState$1
                @Override // p658rx.functions.Func2
                public final LeaveGuildDialogViewModel.StoreState call(Guild guild, Boolean bool) {
                    if (guild == null) {
                        return LeaveGuildDialogViewModel.StoreState.Invalid.INSTANCE;
                    }
                    C12238m.checkNotNullExpressionValue(bool, "isLurking");
                    return new LeaveGuildDialogViewModel.StoreState.Valid(guild, bool.booleanValue());
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…urking)\n        }\n      }");
            return observableM11076j;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
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

    /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final Guild guild;
            private final boolean isLurking;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, boolean z2) {
                super(null);
                C12238m.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.isLurking = z2;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    z2 = valid.isLurking;
                }
                return valid.copy(guild, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsLurking() {
                return this.isLurking;
            }

            public final Valid copy(Guild guild, boolean isLurking) {
                C12238m.checkNotNullParameter(guild, "guild");
                return new Valid(guild, isLurking);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.guild, valid.guild) && this.isLurking == valid.isLurking;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                boolean z2 = this.isLurking;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public final boolean isLurking() {
                return this.isLurking;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", isLurking=");
                return C1643a.m827O(sbM833U, this.isLurking, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final Guild guild;
            private final boolean isLoading;
            private final boolean isLurking;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Guild guild, boolean z2, boolean z3) {
                super(null);
                C12238m.checkNotNullParameter(guild, "guild");
                this.guild = guild;
                this.isLoading = z2;
                this.isLurking = z3;
            }

            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    z2 = valid.isLoading;
                }
                if ((i & 4) != 0) {
                    z3 = valid.isLurking;
                }
                return valid.copy(guild, z2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsLoading() {
                return this.isLoading;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsLurking() {
                return this.isLurking;
            }

            public final Valid copy(Guild guild, boolean isLoading, boolean isLurking) {
                C12238m.checkNotNullParameter(guild, "guild");
                return new Valid(guild, isLoading, isLurking);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.guild, valid.guild) && this.isLoading == valid.isLoading && this.isLurking == valid.isLurking;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                boolean z2 = this.isLoading;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean z3 = this.isLurking;
                return i + (z3 ? 1 : z3);
            }

            public final boolean isLoading() {
                return this.isLoading;
            }

            public final boolean isLurking() {
                return this.isLurking;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", isLoading=");
                sbM833U.append(this.isLoading);
                sbM833U.append(", isLurking=");
                return C1643a.m827O(sbM833U, this.isLurking, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$1 */
    /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
    public static final class C87261 extends AbstractC12240o implements Function0<Unit> {
        public C87261() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LeaveGuildDialogViewModel.this.onLeaveSucceeded();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$2 */
    /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
    public static final class C87272 extends AbstractC12240o implements Function0<Unit> {
        public C87272() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            LeaveGuildDialogViewModel.this.onLeaveFailed();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$3 */
    /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
    public static final class C87283 extends AbstractC12240o implements Function1<Void, Unit> {
        public C87283() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            LeaveGuildDialogViewModel.this.onLeaveSucceeded();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$leaveGuild$4 */
    /* JADX INFO: compiled from: LeaveGuildDialogViewModel.kt */
    public static final class C87294 extends AbstractC12240o implements Function1<Error, Unit> {
        public C87294() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            LeaveGuildDialogViewModel.this.onLeaveFailed();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LeaveGuildDialogViewModel(long j, RestAPI restAPI, StoreLurking storeLurking, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreLurking lurking = (i & 4) != 0 ? StoreStream.INSTANCE.getLurking() : storeLurking;
        this(j, api, lurking, (i & 8) != 0 ? INSTANCE.observeStoreState(j, StoreStream.INSTANCE.getGuilds(), lurking) : observable);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        boolean zIsLoading = valid != null ? valid.isLoading() : false;
        if (storeState instanceof StoreState.Valid) {
            StoreState.Valid valid2 = (StoreState.Valid) storeState;
            updateViewState(new ViewState.Valid(valid2.getGuild(), zIsLoading, valid2.isLurking()));
        } else if (C12238m.areEqual(storeState, StoreState.Invalid.INSTANCE)) {
            updateViewState(ViewState.Invalid.INSTANCE);
        }
    }

    @MainThread
    private final void onLeaveFailed() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, false, false, 5, null));
        }
    }

    @MainThread
    private final void onLeaveSucceeded() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.f27650k.onNext(Event.Dismiss.INSTANCE);
    }

    @MainThread
    public final void leaveGuild() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        if (valid != null) {
            updateViewState(ViewState.Valid.copy$default(valid, null, true, false, 5, null));
            if (valid.isLurking()) {
                this.lurkingStore.stopLurking(valid.getGuild().getId(), new C87261(), new C87272());
            } else {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.leaveGuild(this.guildId), false, 1, null), this, null, 2, null), (Class<?>) LeaveGuildDialogViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C87294()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87283());
            }
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaveGuildDialogViewModel(long j, RestAPI restAPI, StoreLurking storeLurking, Observable<StoreState> observable) {
        super(null);
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(storeLurking, "lurkingStore");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        this.lurkingStore = storeLurking;
        this.eventSubject = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) LeaveGuildDialogViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C87251(this));
    }
}
