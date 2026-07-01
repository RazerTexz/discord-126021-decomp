package com.discord.widgets.notice;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxOverlay$Companion$enqueue$notice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public static final WidgetNoticeNuxOverlay$Companion$enqueue$notice$1 INSTANCE = new WidgetNoticeNuxOverlay$Companion$enqueue$notice$1();

    public WidgetNoticeNuxOverlay$Companion$enqueue$notice$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "it");
        WidgetNoticeNuxOverlay widgetNoticeNuxOverlay = new WidgetNoticeNuxOverlay();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
        widgetNoticeNuxOverlay.show(supportFragmentManager, a0.getOrCreateKotlinClass(WidgetNoticeNuxOverlay.class).toString());
        AnalyticsTracker.openModal$default("Mobile Voice Overlay Upsell", "", null, 4, null);
        return true;
    }
}
