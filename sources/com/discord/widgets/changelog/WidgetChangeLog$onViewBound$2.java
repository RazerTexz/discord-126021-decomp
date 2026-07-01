package com.discord.widgets.changelog;

import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView$OnScrollChangeListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.d0.f;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChangeLog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLog$onViewBound$2 implements NestedScrollView$OnScrollChangeListener {
    public final /* synthetic */ WidgetChangeLog this$0;

    public WidgetChangeLog$onViewBound$2(WidgetChangeLog widgetChangeLog) {
        this.this$0 = widgetChangeLog;
    }

    @Override // androidx.core.widget.NestedScrollView$OnScrollChangeListener
    public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        WidgetChangeLog widgetChangeLog = this.this$0;
        int iAccess$getMaxScrolledPercent$p = WidgetChangeLog.access$getMaxScrolledPercent$p(widgetChangeLog);
        NestedScrollView nestedScrollView2 = WidgetChangeLog.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(nestedScrollView2, "binding.changeLogScrollview");
        int height = ViewExtensions.getContentView(nestedScrollView2).getHeight();
        NestedScrollView nestedScrollView3 = WidgetChangeLog.access$getBinding$p(this.this$0).e;
        m.checkNotNullExpressionValue(nestedScrollView3, "binding.changeLogScrollview");
        WidgetChangeLog.access$setMaxScrolledPercent$p(widgetChangeLog, f.coerceAtLeast(iAccess$getMaxScrolledPercent$p, (i2 * 100) / f.coerceAtLeast(height - nestedScrollView3.getHeight(), 1)));
    }
}
