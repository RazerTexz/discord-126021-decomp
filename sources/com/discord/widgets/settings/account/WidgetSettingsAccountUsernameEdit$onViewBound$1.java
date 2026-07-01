package com.discord.widgets.settings.account;

import android.text.Editable;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountUsernameEdit$onViewBound$1 extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ WidgetSettingsAccountUsernameEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountUsernameEdit$onViewBound$1(WidgetSettingsAccountUsernameEdit widgetSettingsAccountUsernameEdit) {
        super(1);
        this.this$0 = widgetSettingsAccountUsernameEdit;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        m.checkNotNullParameter(editable, "it");
        TextInputLayout textInputLayout = WidgetSettingsAccountUsernameEdit.access$getBinding$p(this.this$0).f2598b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountDiscriminatorWrap");
        textInputLayout.setError(null);
    }
}
