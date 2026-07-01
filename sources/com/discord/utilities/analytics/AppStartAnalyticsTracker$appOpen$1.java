package com.discord.utilities.analytics;

import android.net.Uri;
import com.adjust.sdk.Constants;
import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AppStartAnalyticsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppStartAnalyticsTracker$appOpen$1 extends o implements Function0<Map<String, ? extends Object>> {
    public final /* synthetic */ boolean $isNotificationRoute;
    public final /* synthetic */ Uri $uri;
    public final /* synthetic */ boolean $uriCanBeRouted;
    public final /* synthetic */ AppStartAnalyticsTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppStartAnalyticsTracker$appOpen$1(AppStartAnalyticsTracker appStartAnalyticsTracker, boolean z2, boolean z3, Uri uri) {
        super(0);
        this.this$0 = appStartAnalyticsTracker;
        this.$isNotificationRoute = z2;
        this.$uriCanBeRouted = z3;
        this.$uri = uri;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, ? extends Object> invoke2() {
        String str;
        Pair[] pairArr = new Pair[2];
        if (this.$isNotificationRoute) {
            str = "notification";
        } else {
            str = this.$uriCanBeRouted ? Constants.DEEPLINK : "launcher";
        }
        pairArr[0] = d0.o.to("opened_from", str);
        pairArr[1] = d0.o.to("theme", AppStartAnalyticsTracker.access$getStoreUserSettingsSystem$p(this.this$0).getTheme());
        Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(pairArr);
        AppStartAnalyticsTracker$Companion.access$insertUriProperties(AppStartAnalyticsTracker.Companion, mapMutableMapOf, this.$uri);
        if (AppStartAnalyticsTracker.access$getAppOpenTimestamp$p(this.this$0) == null) {
            mapMutableMapOf.put("load_id", AppStartAnalyticsTracker.access$getOpenAppLoadId$p(this.this$0));
            AppStartAnalyticsTracker appStartAnalyticsTracker = this.this$0;
            AppStartAnalyticsTracker.access$setAppOpenTimestamp$p(appStartAnalyticsTracker, Long.valueOf(AppStartAnalyticsTracker.access$getClock$p(appStartAnalyticsTracker).currentTimeMillis()));
        }
        return mapMutableMapOf;
    }
}
