package com.discord.widgets.user;

import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends$Model$Companion {
    private WidgetUserMutualFriends$Model$Companion() {
    }

    public final Observable<WidgetUserMutualFriends$Model> get(long userId) {
        Observable observableY = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getRelationships(userId), false, 1, null).Y(new WidgetUserMutualFriends$Model$Companion$get$1(userId));
        m.checkNotNullExpressionValue(observableY, "RestAPI\n            .api…          )\n            }");
        Observable<WidgetUserMutualFriends$Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "RestAPI\n            .api…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetUserMutualFriends$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
