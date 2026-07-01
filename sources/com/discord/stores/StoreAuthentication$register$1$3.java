package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.api.auth.RegisterResponse;
import com.discord.models.authentication.AuthState;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.t.n0;
import rx.functions.Action1;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$register$1$3<T> implements Action1<RegisterResponse> {
    public final /* synthetic */ StoreAuthentication$register$1 this$0;

    public StoreAuthentication$register$1$3(StoreAuthentication$register$1 storeAuthentication$register$1) {
        this.this$0 = storeAuthentication$register$1;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(RegisterResponse registerResponse) {
        call2(registerResponse);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(RegisterResponse registerResponse) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getUserSettingsSystem().setIsSyncThemeEnabled(false);
        this.this$0.this$0.setFingerprint(null, true);
        StoreAuthentication.access$publishAuthState(this.this$0.this$0, new AuthState(registerResponse.getToken(), n0.emptySet()));
        AnalyticsTracker.INSTANCE.appFirstLogin();
        storeStream$Companion.getNotifications().setEnabledInApp(true, false);
        storeStream$Companion.getNux().setFirstOpen(true);
    }
}
