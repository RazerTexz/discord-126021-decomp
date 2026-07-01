package com.discord.stores;

import com.discord.app.AppActivity;
import com.discord.restapi.RestAPIParams$UserSettings;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreUserSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreUserSettings$Companion {
    private StoreUserSettings$Companion() {
    }

    public static final /* synthetic */ void access$updateUserSettings(StoreUserSettings$Companion storeUserSettings$Companion, AppActivity appActivity, RestAPIParams$UserSettings restAPIParams$UserSettings, Integer num) {
        storeUserSettings$Companion.updateUserSettings(appActivity, restAPIParams$UserSettings, num);
    }

    private final void updateUserSettings(AppActivity appActivity, RestAPIParams$UserSettings restAPIParams$UserSettings, Integer num) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateUserSettings(restAPIParams$UserSettings), false, 1, null), appActivity, null, 2, null), StoreUserSettings.class, appActivity, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreUserSettings$Companion$updateUserSettings$1(appActivity, num), 60, (Object) null);
    }

    public static /* synthetic */ void updateUserSettings$default(StoreUserSettings$Companion storeUserSettings$Companion, AppActivity appActivity, RestAPIParams$UserSettings restAPIParams$UserSettings, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        storeUserSettings$Companion.updateUserSettings(appActivity, restAPIParams$UserSettings, num);
    }

    public /* synthetic */ StoreUserSettings$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
