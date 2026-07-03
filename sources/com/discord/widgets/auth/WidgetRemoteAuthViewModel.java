package com.discord.widgets.auth;

import androidx.view.ViewModelKt;
import com.discord.models.domain.ModelRemoteAuthHandshake;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p579g0.C12103t;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuthViewModel extends AbstractC0859d0<ViewState> {
    private final RestAPI restAPI;
    private final BehaviorSubject<Boolean> temporaryBehaviorSubject;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$1 */
    /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
    public static final class C72651 extends AbstractC12240o implements Function1<ModelRemoteAuthHandshake, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
        @InterfaceC12188e(m10084c = "com.discord.widgets.auth.WidgetRemoteAuthViewModel$1$1", m10085f = "WidgetRemoteAuthViewModel.kt", m10086l = {54}, m10087m = "invokeSuspend")
        public static final class AnonymousClass1 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ ModelRemoteAuthHandshake $handshakeData;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelRemoteAuthHandshake modelRemoteAuthHandshake, Continuation continuation) {
                super(2, continuation);
                this.$handshakeData = modelRemoteAuthHandshake;
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C12238m.checkNotNullParameter(continuation, "completion");
                return C72651.this.new AnonymousClass1(this.$handshakeData, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    C12113l.throwOnFailure(obj);
                    this.label = 1;
                    if (C3404f.m4234P(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C12113l.throwOnFailure(obj);
                }
                WidgetRemoteAuthViewModel widgetRemoteAuthViewModel = WidgetRemoteAuthViewModel.this;
                String handshakeToken = this.$handshakeData.getHandshakeToken();
                BehaviorSubject behaviorSubject = WidgetRemoteAuthViewModel.this.temporaryBehaviorSubject;
                C12238m.checkNotNullExpressionValue(behaviorSubject, "temporaryBehaviorSubject");
                Object objM11132n0 = behaviorSubject.m11132n0();
                C12238m.checkNotNullExpressionValue(objM11132n0, "temporaryBehaviorSubject.value");
                widgetRemoteAuthViewModel.updateViewState(new ViewState.Loaded(handshakeToken, ((Boolean) objM11132n0).booleanValue(), true));
                return Unit.f27425a;
            }
        }

        public C72651() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelRemoteAuthHandshake modelRemoteAuthHandshake) {
            invoke2(modelRemoteAuthHandshake);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelRemoteAuthHandshake modelRemoteAuthHandshake) {
            C12238m.checkNotNullParameter(modelRemoteAuthHandshake, "handshakeData");
            WidgetRemoteAuthViewModel widgetRemoteAuthViewModel = WidgetRemoteAuthViewModel.this;
            String handshakeToken = modelRemoteAuthHandshake.getHandshakeToken();
            BehaviorSubject behaviorSubject = WidgetRemoteAuthViewModel.this.temporaryBehaviorSubject;
            C12238m.checkNotNullExpressionValue(behaviorSubject, "temporaryBehaviorSubject");
            Object objM11132n0 = behaviorSubject.m11132n0();
            C12238m.checkNotNullExpressionValue(objM11132n0, "temporaryBehaviorSubject.value");
            widgetRemoteAuthViewModel.updateViewState(new ViewState.Loaded(handshakeToken, ((Boolean) objM11132n0).booleanValue(), false));
            C3404f.m4211H0(ViewModelKt.getViewModelScope(WidgetRemoteAuthViewModel.this), null, null, new AnonymousClass1(modelRemoteAuthHandshake, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$2 */
    /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
    public static final class C72662 extends AbstractC12240o implements Function1<Error, Unit> {
        public C72662() {
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
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "it.response");
            if (response.getCode() != 10056) {
                return;
            }
            WidgetRemoteAuthViewModel.this.updateViewState(ViewState.Failed.INSTANCE);
        }
    }

    /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final String handshakeToken;
            private final boolean isTemporary;
            private final boolean loginAllowed;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(String str, boolean z2, boolean z3) {
                super(null);
                C12238m.checkNotNullParameter(str, "handshakeToken");
                this.handshakeToken = str;
                this.isTemporary = z2;
                this.loginAllowed = z3;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, String str, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loaded.handshakeToken;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.isTemporary;
                }
                if ((i & 4) != 0) {
                    z3 = loaded.loginAllowed;
                }
                return loaded.copy(str, z2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getHandshakeToken() {
                return this.handshakeToken;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsTemporary() {
                return this.isTemporary;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getLoginAllowed() {
                return this.loginAllowed;
            }

            public final Loaded copy(String handshakeToken, boolean isTemporary, boolean loginAllowed) {
                C12238m.checkNotNullParameter(handshakeToken, "handshakeToken");
                return new Loaded(handshakeToken, isTemporary, loginAllowed);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.handshakeToken, loaded.handshakeToken) && this.isTemporary == loaded.isTemporary && this.loginAllowed == loaded.loginAllowed;
            }

            public final String getHandshakeToken() {
                return this.handshakeToken;
            }

            public final boolean getLoginAllowed() {
                return this.loginAllowed;
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
                String str = this.handshakeToken;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                boolean z2 = this.isTemporary;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean z3 = this.loginAllowed;
                return i + (z3 ? 1 : z3);
            }

            public final boolean isTemporary() {
                return this.isTemporary;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(handshakeToken=");
                sbM833U.append(this.handshakeToken);
                sbM833U.append(", isTemporary=");
                sbM833U.append(this.isTemporary);
                sbM833U.append(", loginAllowed=");
                return C1643a.m827O(sbM833U, this.loginAllowed, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
        public static final class Succeeded extends ViewState {
            public static final Succeeded INSTANCE = new Succeeded();

            private Succeeded() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$cancelLogin$1 */
    /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
    public static final class C72671 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C72671 INSTANCE = new C72671();

        public C72671() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$remoteLogin$1 */
    /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
    public static final class C72681 extends AbstractC12240o implements Function1<Void, Unit> {
        public C72681() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetRemoteAuthViewModel.this.updateViewState(ViewState.Succeeded.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$remoteLogin$2 */
    /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
    public static final class C72692 extends AbstractC12240o implements Function1<Error, Unit> {
        public C72692() {
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
            WidgetRemoteAuthViewModel.this.updateViewState(ViewState.Failed.INSTANCE);
        }
    }

    public /* synthetic */ WidgetRemoteAuthViewModel(String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public final void cancelLogin() {
        if (getViewState() instanceof ViewState.Loaded) {
            RestAPI restAPI = this.restAPI;
            ViewState viewState = getViewState();
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.auth.WidgetRemoteAuthViewModel.ViewState.Loaded");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(restAPI.postRemoteAuthCancel(new RestAPIParams.RemoteAuthCancel(((ViewState.Loaded) viewState).getHandshakeToken())), false, 1, null), (Class<?>) WidgetRemoteAuthViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C72671.INSTANCE);
        }
    }

    public final void remoteLogin() {
        if (getViewState() instanceof ViewState.Loaded) {
            RestAPI restAPI = this.restAPI;
            ViewState viewState = getViewState();
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.auth.WidgetRemoteAuthViewModel.ViewState.Loaded");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(restAPI.postRemoteAuthFinish(new RestAPIParams.RemoteAuthFinish(false, ((ViewState.Loaded) viewState).getHandshakeToken())), false), this, null, 2, null), (Class<?>) WidgetRemoteAuthViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C72692()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72681());
        }
    }

    public final void toggleTemporary(boolean isTemporary) {
        this.temporaryBehaviorSubject.onNext(Boolean.valueOf(isTemporary));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuthViewModel(String str, RestAPI restAPI) {
        super(ViewState.Loading.INSTANCE);
        C12238m.checkNotNullParameter(str, "fingerprint");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.temporaryBehaviorSubject = BehaviorSubject.m11130l0(Boolean.TRUE);
        if (C12103t.isBlank(str)) {
            updateViewState(ViewState.Failed.INSTANCE);
        } else {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(restAPI.postRemoteAuthInitialize(new RestAPIParams.RemoteAuthInitialize(str)), false), this, null, 2, null), (Class<?>) WidgetRemoteAuthViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C72662()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72651());
        }
    }
}
