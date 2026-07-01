package com.discord.widgets.auth;

import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.utilities.rest.RestAPI;
import d0.g0.y;
import d0.z.d.m;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung$Companion {
    private WidgetOauth2AuthorizeSamsung$Companion() {
    }

    public static final /* synthetic */ String access$createSAStateId(WidgetOauth2AuthorizeSamsung$Companion widgetOauth2AuthorizeSamsung$Companion) {
        return widgetOauth2AuthorizeSamsung$Companion.createSAStateId();
    }

    public static final /* synthetic */ void access$logI(WidgetOauth2AuthorizeSamsung$Companion widgetOauth2AuthorizeSamsung$Companion, String str) {
        widgetOauth2AuthorizeSamsung$Companion.logI(str);
    }

    private final String createSAStateId() {
        StringBuilder sbU = a.U("SA");
        sbU.append(UUID.randomUUID());
        return y.take(sbU.toString(), 115);
    }

    private final void logI(String message) {
        AppLog appLog = AppLog.g;
        appLog.c(message, "Samsung", null, new WidgetOauth2AuthorizeSamsung$Companion$logI$1(appLog));
    }

    private final void logW(String message, Throwable throwable) {
        AppLog appLog = AppLog.g;
        appLog.c(message, "Samsung", throwable, new WidgetOauth2AuthorizeSamsung$Companion$logW$1(appLog));
    }

    public static /* synthetic */ void logW$default(WidgetOauth2AuthorizeSamsung$Companion widgetOauth2AuthorizeSamsung$Companion, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        widgetOauth2AuthorizeSamsung$Companion.logW(str, th);
    }

    public final Observable<Void> getForSamsung(WidgetOauth2Authorize$OAuth2Authorize widgetOauth2Authorize$OAuth2Authorize, String str) {
        m.checkNotNullParameter(widgetOauth2Authorize$OAuth2Authorize, "$this$getForSamsung");
        m.checkNotNullParameter(str, "accountUri");
        return RestAPI.Companion.getApi().getOauth2SamsungAuthorize(String.valueOf(widgetOauth2Authorize$OAuth2Authorize.getClientId()), widgetOauth2Authorize$OAuth2Authorize.getState(), widgetOauth2Authorize$OAuth2Authorize.getResponseType(), str, widgetOauth2Authorize$OAuth2Authorize.getPrompt(), widgetOauth2Authorize$OAuth2Authorize.getScope());
    }

    public /* synthetic */ WidgetOauth2AuthorizeSamsung$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
