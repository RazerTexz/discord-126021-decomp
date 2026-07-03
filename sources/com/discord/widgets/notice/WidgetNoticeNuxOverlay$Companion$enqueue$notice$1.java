package com.discord.widgets.notice;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxOverlay$Companion$enqueue$notice$1 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
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
        C12238m.checkNotNullParameter(fragmentActivity, "it");
        WidgetNoticeNuxOverlay widgetNoticeNuxOverlay = new WidgetNoticeNuxOverlay();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        C12238m.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
        widgetNoticeNuxOverlay.show(supportFragmentManager, C12216a0.getOrCreateKotlinClass(WidgetNoticeNuxOverlay.class).toString());
        AnalyticsTracker.openModal$default("Mobile Voice Overlay Upsell", "", null, 4, null);
        return true;
    }
}
