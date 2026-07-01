package com.discord.stores;

import com.discord.app.AppComponent;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AppStartAnalyticsTracker;
import com.discord.widgets.auth.WidgetAuthLanding;
import com.discord.widgets.guilds.invite.WidgetGuildInvite;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.share.WidgetIncomingShare;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAnalytics.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAnalytics$onScreenViewed$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreAnalytics$ScreenViewed $screenViewed;
    public final /* synthetic */ StoreAnalytics this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAnalytics$onScreenViewed$1(StoreAnalytics storeAnalytics, StoreAnalytics$ScreenViewed storeAnalytics$ScreenViewed) {
        super(0);
        this.this$0 = storeAnalytics;
        this.$screenViewed = storeAnalytics$ScreenViewed;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String simpleName;
        Class<? extends AppComponent> screen = this.$screenViewed.getScreen();
        if (m.areEqual(screen, WidgetHome.class)) {
            simpleName = StoreAnalytics.access$getStores$p(this.this$0).getGuildSelected().getSelectedGuildId() == 0 ? "private_channel" : "guild";
        } else if (m.areEqual(screen, WidgetGuildInvite.class)) {
            simpleName = "invite";
        } else if (m.areEqual(screen, WidgetIncomingShare.class)) {
            simpleName = AnalyticsTracker.ATTACHMENT_SOURCE_SHARE;
        } else {
            simpleName = m.areEqual(screen, WidgetAuthLanding.class) ? "app_landing" : this.$screenViewed.getScreen().getSimpleName();
        }
        AppStartAnalyticsTracker appStartAnalyticsTracker$Companion = AppStartAnalyticsTracker.Companion.getInstance();
        m.checkNotNullExpressionValue(simpleName, "screenName");
        appStartAnalyticsTracker$Companion.appUiViewed(simpleName, this.$screenViewed.getTimestamp());
    }
}
