package com.discord.widgets.auth;

import android.content.Context;
import b.a.d.d0;
import com.discord.restapi.RestAPIParams$RemoteAuthCancel;
import com.discord.restapi.RestAPIParams$RemoteAuthFinish;
import com.discord.restapi.RestAPIParams$RemoteAuthInitialize;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.t;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuthViewModel extends d0<WidgetRemoteAuthViewModel$ViewState> {
    private final RestAPI restAPI;
    private final BehaviorSubject<Boolean> temporaryBehaviorSubject;

    public /* synthetic */ WidgetRemoteAuthViewModel(String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI);
    }

    public static final /* synthetic */ BehaviorSubject access$getTemporaryBehaviorSubject$p(WidgetRemoteAuthViewModel widgetRemoteAuthViewModel) {
        return widgetRemoteAuthViewModel.temporaryBehaviorSubject;
    }

    public static final /* synthetic */ void access$updateViewState(WidgetRemoteAuthViewModel widgetRemoteAuthViewModel, WidgetRemoteAuthViewModel$ViewState widgetRemoteAuthViewModel$ViewState) {
        widgetRemoteAuthViewModel.updateViewState(widgetRemoteAuthViewModel$ViewState);
    }

    public final void cancelLogin() {
        if (getViewState() instanceof WidgetRemoteAuthViewModel$ViewState$Loaded) {
            RestAPI restAPI = this.restAPI;
            WidgetRemoteAuthViewModel$ViewState viewState = getViewState();
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.auth.WidgetRemoteAuthViewModel.ViewState.Loaded");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.postRemoteAuthCancel(new RestAPIParams$RemoteAuthCancel(((WidgetRemoteAuthViewModel$ViewState$Loaded) viewState).getHandshakeToken())), false, 1, null), WidgetRemoteAuthViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetRemoteAuthViewModel$cancelLogin$1.INSTANCE, 62, (Object) null);
        }
    }

    public final void remoteLogin() {
        if (getViewState() instanceof WidgetRemoteAuthViewModel$ViewState$Loaded) {
            RestAPI restAPI = this.restAPI;
            WidgetRemoteAuthViewModel$ViewState viewState = getViewState();
            Objects.requireNonNull(viewState, "null cannot be cast to non-null type com.discord.widgets.auth.WidgetRemoteAuthViewModel.ViewState.Loaded");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(restAPI.postRemoteAuthFinish(new RestAPIParams$RemoteAuthFinish(false, ((WidgetRemoteAuthViewModel$ViewState$Loaded) viewState).getHandshakeToken())), false), this, null, 2, null), WidgetRemoteAuthViewModel.class, (Context) null, (Function1) null, new WidgetRemoteAuthViewModel$remoteLogin$2(this), (Function0) null, (Function0) null, new WidgetRemoteAuthViewModel$remoteLogin$1(this), 54, (Object) null);
        }
    }

    public final void toggleTemporary(boolean isTemporary) {
        this.temporaryBehaviorSubject.onNext(Boolean.valueOf(isTemporary));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuthViewModel(String str, RestAPI restAPI) {
        super(WidgetRemoteAuthViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(str, "fingerprint");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.temporaryBehaviorSubject = BehaviorSubject.l0(Boolean.TRUE);
        if (t.isBlank(str)) {
            updateViewState(WidgetRemoteAuthViewModel$ViewState$Failed.INSTANCE);
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn(restAPI.postRemoteAuthInitialize(new RestAPIParams$RemoteAuthInitialize(str)), false), this, null, 2, null), WidgetRemoteAuthViewModel.class, (Context) null, (Function1) null, new WidgetRemoteAuthViewModel$2(this), (Function0) null, (Function0) null, new WidgetRemoteAuthViewModel$1(this), 54, (Object) null);
    }
}
