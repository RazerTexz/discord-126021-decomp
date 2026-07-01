package com.discord.widgets.tos;

import android.view.View$OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: WidgetTosReportViolationReasonView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolationReasonView$setOnClickListener$2 implements CompoundButton$OnCheckedChangeListener {
    public final /* synthetic */ Ref$BooleanRef $onClickInvoked;
    public final /* synthetic */ View$OnClickListener $onClickListener;
    public final /* synthetic */ WidgetTosReportViolationReasonView this$0;

    public WidgetTosReportViolationReasonView$setOnClickListener$2(WidgetTosReportViolationReasonView widgetTosReportViolationReasonView, Ref$BooleanRef ref$BooleanRef, View$OnClickListener view$OnClickListener) {
        this.this$0 = widgetTosReportViolationReasonView;
        this.$onClickInvoked = ref$BooleanRef;
        this.$onClickListener = view$OnClickListener;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        View$OnClickListener view$OnClickListener;
        if (this.$onClickInvoked.element || !z2 || (view$OnClickListener = this.$onClickListener) == null) {
            return;
        }
        view$OnClickListener.onClick(this.this$0);
    }
}
