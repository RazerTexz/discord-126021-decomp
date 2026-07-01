package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.RestAPI$HarvestState;
import d0.z.d.m;
import j0.k.b;
import j0.p.a;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$3$2<T, R> implements b<MeUser, Observable<? extends RestAPI$HarvestState>> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$3$2 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$3$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends RestAPI$HarvestState> call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends RestAPI$HarvestState> call2(MeUser meUser) {
        RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
        Observable<RestAPI$HarvestState> observableJ = RestAPI.Companion.getApi().getHarvestStatusGuarded().J(a.c());
        m.checkNotNullExpressionValue(observableJ, "RestAPI\n                …bserveOn(Schedulers.io())");
        return RetryWithDelay.restRetry$default(retryWithDelay, observableJ, 0L, null, null, 7, null).q(500L, TimeUnit.MILLISECONDS).M(WidgetSettingsPrivacy$Model$Companion$get$3$2$1.INSTANCE);
    }
}
