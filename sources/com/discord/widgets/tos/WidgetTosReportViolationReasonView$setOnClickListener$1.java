package com.discord.widgets.tos;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: WidgetTosReportViolationReasonView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolationReasonView$setOnClickListener$1 implements View$OnClickListener {
    public final /* synthetic */ Ref$BooleanRef $onClickInvoked;
    public final /* synthetic */ View$OnClickListener $onClickListener;
    public final /* synthetic */ WidgetTosReportViolationReasonView this$0;

    public WidgetTosReportViolationReasonView$setOnClickListener$1(WidgetTosReportViolationReasonView widgetTosReportViolationReasonView, Ref$BooleanRef ref$BooleanRef, View$OnClickListener view$OnClickListener) {
        this.this$0 = widgetTosReportViolationReasonView;
        this.$onClickInvoked = ref$BooleanRef;
        this.$onClickListener = view$OnClickListener;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onClickInvoked.element = true;
        View$OnClickListener view$OnClickListener = this.$onClickListener;
        if (view$OnClickListener != null) {
            view$OnClickListener.onClick(this.this$0);
        }
        this.$onClickInvoked.element = false;
    }
}
