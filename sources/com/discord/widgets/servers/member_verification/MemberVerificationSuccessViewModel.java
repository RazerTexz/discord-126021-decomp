package com.discord.widgets.servers.member_verification;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
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
            MemberVerificationSuccessViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableJ = Observable.j(companion.getGuildJoinRequests().observeGuildJoinRequest(guildId), companion.getGuilds().observeGuild(guildId), new Func2<GuildJoinRequest, Guild, StoreState>() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$Companion$observeStores$1
                @Override // rx.functions.Func2
                public final MemberVerificationSuccessViewModel.StoreState call(GuildJoinRequest guildJoinRequest, Guild guild) {
                    return new MemberVerificationSuccessViewModel.StoreState(guildJoinRequest != null ? guildJoinRequest.getLastSeen() : null, guild != null ? guild.getName() : null);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…?.name,\n        )\n      }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
        public static final class Error extends Event {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
        public static final class Success extends Event {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
    public static final /* data */ class StoreState {
        private final String guildName;
        private final String lastSeen;

        public StoreState(String str, String str2) {
            this.lastSeen = str;
            this.guildName = str2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = storeState.lastSeen;
            }
            if ((i & 2) != 0) {
                str2 = storeState.guildName;
            }
            return storeState.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLastSeen() {
            return this.lastSeen;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        public final StoreState copy(String lastSeen, String guildName) {
            return new StoreState(lastSeen, guildName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.lastSeen, storeState.lastSeen) && Intrinsics3.areEqual(this.guildName, storeState.guildName);
        }

        public final String getGuildName() {
            return this.guildName;
        }

        public final String getLastSeen() {
            return this.lastSeen;
        }

        public int hashCode() {
            String str = this.lastSeen;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.guildName;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(lastSeen=");
            sbU.append(this.lastSeen);
            sbU.append(", guildName=");
            return outline.J(sbU, this.guildName, ")");
        }
    }

    /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
        public static final class Acked extends ViewState {
            public static final Acked INSTANCE = new Acked();

            private Acked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final String guildName;

            public Loaded(String str) {
                super(null);
                this.guildName = str;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loaded.guildName;
                }
                return loaded.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            public final Loaded copy(String guildName) {
                return new Loaded(guildName);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.guildName, ((Loaded) other).guildName);
                }
                return true;
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public int hashCode() {
                String str = this.guildName;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("Loaded(guildName="), this.guildName, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$ackGuildJoinRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            MemberVerificationSuccessViewModel.this.eventSubject.k.onNext((T) Event.Error.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$ackGuildJoinRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass2() {
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
            MemberVerificationSuccessViewModel.this.eventSubject.k.onNext((T) Event.Success.INSTANCE);
        }
    }

    public /* synthetic */ MemberVerificationSuccessViewModel(long j, RestAPI restAPI, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? INSTANCE.observeStores(j) : observable);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState.getLastSeen() != null) {
            updateViewState(ViewState.Acked.INSTANCE);
        } else {
            updateViewState(new ViewState.Loaded(storeState.getGuildName()));
        }
    }

    public final void ackGuildJoinRequest() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), (Class<?>) MemberVerificationSuccessViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationSuccessViewModel(long j, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) MemberVerificationSuccessViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
