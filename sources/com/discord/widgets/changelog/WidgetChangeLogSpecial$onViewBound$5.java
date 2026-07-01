package com.discord.widgets.changelog;

import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView$OnScrollChangeListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.d0.f;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChangeLogSpecial.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeLogSpecial$onViewBound$5 implements NestedScrollView$OnScrollChangeListener {
    public final /* synthetic */ WidgetChangeLogSpecial this$0;

    public WidgetChangeLogSpecial$onViewBound$5(WidgetChangeLogSpecial widgetChangeLogSpecial) {
        this.this$0 = widgetChangeLogSpecial;
    }

    @Override // androidx.core.widget.NestedScrollView$OnScrollChangeListener
    public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        WidgetChangeLogSpecial widgetChangeLogSpecial = this.this$0;
        int iAccess$getMaxScrolledPercent$p = WidgetChangeLogSpecial.access$getMaxScrolledPercent$p(widgetChangeLogSpecial);
        NestedScrollView nestedScrollView2 = WidgetChangeLogSpecial.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(nestedScrollView2, "binding.changeLogSpecialScrollview");
        int height = ViewExtensions.getContentView(nestedScrollView2).getHeight();
        NestedScrollView nestedScrollView3 = WidgetChangeLogSpecial.access$getBinding$p(this.this$0).g;
        m.checkNotNullExpressionValue(nestedScrollView3, "binding.changeLogSpecialScrollview");
        WidgetChangeLogSpecial.access$setMaxScrolledPercent$p(widgetChangeLogSpecial, f.coerceAtLeast(iAccess$getMaxScrolledPercent$p, (i2 * 100) / f.coerceAtLeast(height - nestedScrollView3.getHeight(), 1)));
    }
}
