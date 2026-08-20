package com.discord.widgets.servers.member_verification;

import androidx.annotation.MainThread;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$1 */
    /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
    public static final class C95541 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C95541() {
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
            MemberVerificationSuccessViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableM11076j = Observable.m11076j(companion.getGuildJoinRequests().observeGuildJoinRequest(guildId), companion.getGuilds().observeGuild(guildId), new Func2<GuildJoinRequest, Guild, StoreState>() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$Companion$observeStores$1
                @Override // p658rx.functions.Func2
                public final MemberVerificationSuccessViewModel.StoreState call(GuildJoinRequest guildJoinRequest, Guild guild) {
                    return new MemberVerificationSuccessViewModel.StoreState(guildJoinRequest != null ? guildJoinRequest.getLastSeen() : null, guild != null ? guild.getName() : null);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…?.name,\n        )\n      }");
            return observableM11076j;
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
            return C12238m.areEqual(this.lastSeen, storeState.lastSeen) && C12238m.areEqual(this.guildName, storeState.guildName);
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
            StringBuilder sbM833U = C1643a.m833U("StoreState(lastSeen=");
            sbM833U.append(this.lastSeen);
            sbM833U.append(", guildName=");
            return C1643a.m822J(sbM833U, this.guildName, ")");
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
                    return (other instanceof Loaded) && C12238m.areEqual(this.guildName, ((Loaded) other).guildName);
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
                return C1643a.m822J(C1643a.m833U("Loaded(guildName="), this.guildName, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$ackGuildJoinRequest$1 */
    /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
    public static final class C95551 extends AbstractC12240o implements Function1<Error, Unit> {
        public C95551() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            MemberVerificationSuccessViewModel.this.eventSubject.f27650k.onNext((T) Event.Error.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$ackGuildJoinRequest$2 */
    /* JADX INFO: compiled from: MemberVerificationSuccessViewModel.kt */
    public static final class C95562 extends AbstractC12240o implements Function1<Void, Unit> {
        public C95562() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            MemberVerificationSuccessViewModel.this.eventSubject.f27650k.onNext((T) Event.Success.INSTANCE);
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.ackGuildJoinRequest(this.guildId), false, 1, null), this, null, 2, null), (Class<?>) MemberVerificationSuccessViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C95551()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95562());
    }

    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationSuccessViewModel(long j, RestAPI restAPI, Observable<StoreState> observable) {
        super(null);
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.restAPI = restAPI;
        PublishSubject<Event> publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.eventSubject = publishSubjectM11133k0;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) MemberVerificationSuccessViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95541());
    }
}
