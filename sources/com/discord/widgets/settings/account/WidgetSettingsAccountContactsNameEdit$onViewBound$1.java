package com.discord.widgets.settings.account;

import android.widget.TextView;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.w;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountContactsNameEdit$onViewBound$1 extends o implements Function1<TextView, Unit> {
    public final /* synthetic */ WidgetSettingsAccountContactsNameEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountContactsNameEdit$onViewBound$1(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit) {
        super(1);
        this.this$0 = widgetSettingsAccountContactsNameEdit;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
        invoke2(textView);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TextView textView) {
        m.checkNotNullParameter(textView, "it");
        WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit = this.this$0;
        TextInputLayout textInputLayout = WidgetSettingsAccountContactsNameEdit.access$getBinding$p(widgetSettingsAccountContactsNameEdit).f2597b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        Objects.requireNonNull(textOrEmpty, "null cannot be cast to non-null type kotlin.CharSequence");
        WidgetSettingsAccountContactsNameEdit.access$submitName(widgetSettingsAccountContactsNameEdit, w.trim(textOrEmpty).toString());
    }
}
