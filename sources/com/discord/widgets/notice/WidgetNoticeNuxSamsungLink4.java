package com.discord.widgets.notice;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$Companion$internalEnqueue$notice$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink4 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public static final WidgetNoticeNuxSamsungLink4 INSTANCE = new WidgetNoticeNuxSamsungLink4();

    public WidgetNoticeNuxSamsungLink4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "it");
        WidgetNoticeNuxSamsungLink widgetNoticeNuxSamsungLink = new WidgetNoticeNuxSamsungLink();
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
        widgetNoticeNuxSamsungLink.show(supportFragmentManager, WidgetNoticeNuxSamsungLink.class.getName());
        AnalyticsTracker.openModal$default("Mobile Samsung Link Upsell", "", null, 4, null);
        return true;
    }
}
