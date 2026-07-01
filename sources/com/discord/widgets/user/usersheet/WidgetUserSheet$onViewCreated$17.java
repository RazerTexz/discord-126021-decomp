package com.discord.widgets.user.usersheet;

import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$onViewCreated$17 extends AccessibilityDelegateCompat {
    public final /* synthetic */ WidgetUserSheet this$0;

    public WidgetUserSheet$onViewCreated$17(WidgetUserSheet widgetUserSheet) {
        this.this$0 = widgetUserSheet;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
        m.checkNotNullParameter(host, "host");
        m.checkNotNullParameter(info, "info");
        super.onInitializeAccessibilityNodeInfo(host, info);
        info.setTraversalAfter(WidgetUserSheet.access$getBinding$p(this.this$0).o);
    }
}
