package com.discord.widgets.settings.billing;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$initPaymentSourceInfo$5 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetPaymentSourceEditDialog$StateEntry[] $states;
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPaymentSourceEditDialog$initPaymentSourceInfo$5(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, WidgetPaymentSourceEditDialog$StateEntry[] widgetPaymentSourceEditDialog$StateEntryArr) {
        super(1);
        this.this$0 = widgetPaymentSourceEditDialog;
        this.$states = widgetPaymentSourceEditDialog$StateEntryArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog = this.this$0;
        WidgetPaymentSourceEditDialog$StateEntry[] widgetPaymentSourceEditDialog$StateEntryArr = this.$states;
        m.checkNotNullExpressionValue(widgetPaymentSourceEditDialog$StateEntryArr, "states");
        WidgetPaymentSourceEditDialog.access$selectState(widgetPaymentSourceEditDialog, widgetPaymentSourceEditDialog$StateEntryArr);
    }
}
