package com.discord.widgets.settings.billing;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$selectState$2 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetPaymentSourceEditDialog$StateEntry[] $states;
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPaymentSourceEditDialog$selectState$2(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog, WidgetPaymentSourceEditDialog$StateEntry[] widgetPaymentSourceEditDialog$StateEntryArr) {
        super(1);
        this.this$0 = widgetPaymentSourceEditDialog;
        this.$states = widgetPaymentSourceEditDialog$StateEntryArr;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        TextInputLayout textInputLayout = WidgetPaymentSourceEditDialog.access$getBinding$p(this.this$0).n;
        m.checkNotNullExpressionValue(textInputLayout, "binding.paymentSourceEditState");
        ViewExtensions.setText(textInputLayout, this.$states[i].getLabel());
    }
}
