package com.discord.widgets.settings.connections;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelConnectionState;
import com.discord.restapi.RestAPIParams$ConnectionState;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAddXbox$submitPinCode$1<T, R> implements b<ModelConnectionState, Observable<? extends Void>> {
    public final /* synthetic */ Platform $platform;

    public WidgetSettingsUserConnectionsAddXbox$submitPinCode$1(Platform platform) {
        this.$platform = platform;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Void> call(ModelConnectionState modelConnectionState) {
        return call2(modelConnectionState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Void> call2(ModelConnectionState modelConnectionState) {
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        m.checkNotNullExpressionValue(modelConnectionState, "state");
        analyticsTracker.accountLinkStep("PIN code entry", "PIN success", modelConnectionState.getState(), this.$platform.getPlatformId());
        RestAPI api = RestAPI.Companion.getApi();
        String platformId = this.$platform.getPlatformId();
        String code = modelConnectionState.getCode();
        String state = modelConnectionState.getState();
        Boolean bool = Boolean.TRUE;
        return api.submitConnectionState(platformId, new RestAPIParams$ConnectionState(code, state, bool, bool));
    }
}
