package com.discord.widgets.notice;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.notice.WidgetNoticeNuxOverlay$Companion$enqueue$notice$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxOverlay2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public static final WidgetNoticeNuxOverlay2 INSTANCE = new WidgetNoticeNuxOverlay2();

    public WidgetNoticeNuxOverlay2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "it");
        WidgetNoticeNuxOverlay widgetNoticeNuxOverlay = new WidgetNoticeNuxOverlay();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
        widgetNoticeNuxOverlay.show(supportFragmentManager, Reflection2.getOrCreateKotlinClass(WidgetNoticeNuxOverlay.class).toString());
        AnalyticsTracker.openModal$default("Mobile Voice Overlay Upsell", "", null, 4, null);
        return true;
    }
}
