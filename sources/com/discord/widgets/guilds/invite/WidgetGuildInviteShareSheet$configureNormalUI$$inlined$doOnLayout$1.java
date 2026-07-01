package com.discord.widgets.guilds.invite;

import android.content.res.Resources;
import android.view.View;
import android.view.View$OnLayoutChangeListener;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareSheet$configureNormalUI$$inlined$doOnLayout$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ WidgetGuildInviteShareSheet this$0;

    public WidgetGuildInviteShareSheet$configureNormalUI$$inlined$doOnLayout$1(WidgetGuildInviteShareSheet widgetGuildInviteShareSheet) {
        this.this$0 = widgetGuildInviteShareSheet;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams) layoutParams;
        Resources resources = this.this$0.getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        frameLayout$LayoutParams.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
        view.setLayoutParams(frameLayout$LayoutParams);
        WidgetGuildInviteShareSheet.access$getBinding$p(this.this$0).m.requestLayout();
    }
}
