package com.discord.widgets.settings.account;

import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersViewModel$Companion {
    private WidgetSettingsBlockedUsersViewModel$Companion() {
    }

    public final Observable<WidgetSettingsBlockedUsersViewModel$StoreState> observeStores(StoreUserRelationships storeUserRelationships, StoreUser storeUser) {
        m.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        m.checkNotNullParameter(storeUser, "storeUser");
        Observable observableY = storeUserRelationships.observe().Y(new WidgetSettingsBlockedUsersViewModel$Companion$observeStores$1(storeUser));
        m.checkNotNullExpressionValue(observableY, "storeUserRelationships\n …          }\n            }");
        return observableY;
    }

    public /* synthetic */ WidgetSettingsBlockedUsersViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
