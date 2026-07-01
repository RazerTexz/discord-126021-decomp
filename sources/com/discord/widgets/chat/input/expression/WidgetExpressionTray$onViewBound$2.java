package com.discord.widgets.chat.input.expression;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionTray$onViewBound$2 implements AppBarLayout$OnOffsetChangedListener {
    public final /* synthetic */ WidgetExpressionTray this$0;

    public WidgetExpressionTray$onViewBound$2(WidgetExpressionTray widgetExpressionTray) {
        this.this$0 = widgetExpressionTray;
    }

    @Override // com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout$BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        WidgetExpressionTray.access$isAtInitialScrollPositionSubject$p(this.this$0).onNext(Boolean.valueOf(i == 0));
    }
}
