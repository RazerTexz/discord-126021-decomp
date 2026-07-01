package com.discord.widgets.auth;

import androidx.view.ViewModel3;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelRemoteAuthHandshake;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Result3;
import d0.g0.StringsJVM;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuthViewModel extends AppViewModel<ViewState> {
    private final RestAPI restAPI;
    private final BehaviorSubject<Boolean> temporaryBehaviorSubject;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelRemoteAuthHandshake, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
        @DebugMetadata(c = "com.discord.widgets.auth.WidgetRemoteAuthViewModel$1$1", f = "WidgetRemoteAuthViewModel.kt", l = {54}, m = "invokeSuspend")
        public static final class C02371 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ ModelRemoteAuthHandshake $handshakeData;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02371(ModelRemoteAuthHandshake modelRemoteAuthHandshake, Continuation continuation) {
                super(2, continuation);
                this.$handshakeData = modelRemoteAuthHandshake;
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                return AnonymousClass1.this.new C02371(this.$handshakeData, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02371) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    this.label = 1;
                    if (f.P(1000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                WidgetRemoteAuthViewModel widgetRemoteAuthViewModel = WidgetRemoteAuthViewModel.this;
                String handshakeToken = this.$handshakeData.getHandshakeToken();
                BehaviorSubject behaviorSubject = WidgetRemoteAuthViewModel.this.temporaryBehaviorSubject;
                Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "temporaryBehaviorSubject");
                Object objN0 = behaviorSubject.n0();
                Intrinsics3.checkNotNullExpressionValue(objN0, "temporaryBehaviorSubject.value");
                widgetRemoteAuthViewModel.updateViewState(new ViewState.Loaded(handshakeToken, ((Boolean) objN0).booleanValue(), true));
                return Unit.a;
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelRemoteAuthHandshake modelRemoteAuthHandshake) {
            invoke2(modelRemoteAuthHandshake);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelRemoteAuthHandshake modelRemoteAuthHandshake) {
            Intrinsics3.checkNotNullParameter(modelRemoteAuthHandshake, "handshakeData");
            WidgetRemoteAuthViewModel widgetRemoteAuthViewModel = WidgetRemoteAuthViewModel.this;
            String handshakeToken = modelRemoteAuthHandshake.getHandshakeToken();
            BehaviorSubject behaviorSubject = WidgetRemoteAuthViewModel.this.temporaryBehaviorSubject;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "temporaryBehaviorSubject");
            Object objN0 = behaviorSubject.n0();
            Intrinsics3.checkNotNullExpressionValue(objN0, "temporaryBehaviorSubject.value");
            widgetRemoteAuthViewModel.updateViewState(new ViewState.Loaded(handshakeToken, ((Boolean) objN0).booleanValue(), false));
            f.H0(ViewModel3.getViewModelScope(WidgetRemoteAuthViewModel.this), null, null, new C02371(modelRemoteAuthHandshake, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "it.response");
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
                Intrinsics3.checkNotNullParameter(str, "handshakeToken");
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
                Intrinsics3.checkNotNullParameter(handshakeToken, "handshakeToken");
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
                return Intrinsics3.areEqual(this.handshakeToken, loaded.handshakeToken) && this.isTemporary == loaded.isTemporary && this.loginAllowed == loaded.loginAllowed;
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
                StringBuilder sbU = outline.U("Loaded(handshakeToken=");
                sbU.append(this.handshakeToken);
                sbU.append(", isTemporary=");
                sbU.append(this.isTemporary);
                sbU.append(", loginAllowed=");
                return outline.O(sbU, this.loginAllowed, ")");
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

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$cancelLogin$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$remoteLogin$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            WidgetRemoteAuthViewModel.this.updateViewState(ViewState.Succeeded.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetRemoteAuthViewModel$remoteLogin$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
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
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(restAPI.postRemoteAuthCancel(new RestAPIParams.RemoteAuthCancel(((ViewState.Loaded) viewState).getHandshakeToken())), false, 1, null), (Class<?>) WidgetRemoteAuthViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
        }
    }

    public final void remoteLogin() {
        if (getViewState() instanceof ViewState.Loaded) {
            RestAPI restAPI = this.restAPI;
            ViewState viewState = getViewState();
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.auth.WidgetRemoteAuthViewModel.ViewState.Loaded");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(restAPI.postRemoteAuthFinish(new RestAPIParams.RemoteAuthFinish(false, ((ViewState.Loaded) viewState).getHandshakeToken())), false), this, null, 2, null), (Class<?>) WidgetRemoteAuthViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        }
    }

    public final void toggleTemporary(boolean isTemporary) {
        this.temporaryBehaviorSubject.onNext(Boolean.valueOf(isTemporary));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuthViewModel(String str, RestAPI restAPI) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(str, "fingerprint");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.temporaryBehaviorSubject = BehaviorSubject.l0(Boolean.TRUE);
        if (StringsJVM.isBlank(str)) {
            updateViewState(ViewState.Failed.INSTANCE);
        } else {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(restAPI.postRemoteAuthInitialize(new RestAPIParams.RemoteAuthInitialize(str)), false), this, null, 2, null), (Class<?>) WidgetRemoteAuthViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        }
    }
}
