package com.discord.widgets.user.profile;

import android.content.Context;
import com.discord.app.AppComponent;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$Companion {
    private UserProfileHeaderView$Companion() {
    }

    public final void bind(UserProfileHeaderView userProfileHeaderView, AppComponent appComponent, Observable<UserProfileHeaderViewModel$ViewState> observable) {
        m.checkNotNullParameter(userProfileHeaderView, "$this$bind");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(observable, "observable");
        Observable<R> observableG = observable.y(UserProfileHeaderView$Companion$bind$$inlined$filterIs$1.INSTANCE).G(UserProfileHeaderView$Companion$bind$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, appComponent, null, 2, null), appComponent.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new UserProfileHeaderView$Companion$bind$1(userProfileHeaderView), 62, (Object) null);
    }

    public /* synthetic */ UserProfileHeaderView$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
