package com.discord.widgets.user.email;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserEmailVerify$Model$Companion {
    private WidgetUserEmailVerify$Model$Companion() {
    }

    public final Observable<WidgetUserEmailVerify$Model> get() {
        Observable<WidgetUserEmailVerify$Model> observableR = StoreUser.observeMe$default(StoreStream.Companion.getUsers(), false, 1, null).G(WidgetUserEmailVerify$Model$Companion$get$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "getUsers()\n            .…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetUserEmailVerify$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
