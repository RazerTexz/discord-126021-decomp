package com.discord.widgets.settings.account;

import android.text.Editable;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountChangePassword$onViewBound$2 extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ WidgetSettingsAccountChangePassword this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountChangePassword$onViewBound$2(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword) {
        super(1);
        this.this$0 = widgetSettingsAccountChangePassword;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        m.checkNotNullParameter(editable, "it");
        TextInputLayout textInputLayout = this.this$0.getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordNewPasswordInput");
        textInputLayout.setError(null);
    }
}
