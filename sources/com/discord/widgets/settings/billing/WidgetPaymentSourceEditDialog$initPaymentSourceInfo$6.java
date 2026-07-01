package com.discord.widgets.settings.billing;

import android.view.KeyEvent;
import android.widget.TextView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$initPaymentSourceInfo$6 extends o implements Function3<TextView, Integer, KeyEvent, Boolean> {
    public final /* synthetic */ WidgetPaymentSourceEditDialog$StateEntry[] $states;
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPaymentSourceEditDialog$initPaymentSourceInfo$6(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, WidgetPaymentSourceEditDialog$StateEntry[] widgetPaymentSourceEditDialog$StateEntryArr) {
        super(3);
        this.this$0 = widgetPaymentSourceEditDialog;
        this.$states = widgetPaymentSourceEditDialog$StateEntryArr;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
        return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
    }

    public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
        m.checkNotNullParameter(textView, "<anonymous parameter 0>");
        if (i != 2 && i != 6) {
            return false;
        }
        WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog = this.this$0;
        WidgetPaymentSourceEditDialog$StateEntry[] widgetPaymentSourceEditDialog$StateEntryArr = this.$states;
        m.checkNotNullExpressionValue(widgetPaymentSourceEditDialog$StateEntryArr, "states");
        WidgetPaymentSourceEditDialog.access$selectState(widgetPaymentSourceEditDialog, widgetPaymentSourceEditDialog$StateEntryArr);
        return true;
    }
}
