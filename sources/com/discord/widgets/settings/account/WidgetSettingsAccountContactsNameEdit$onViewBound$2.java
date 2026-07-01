package com.discord.widgets.settings.account;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.w;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetSettingsAccountContactsNameEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountContactsNameEdit$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsAccountContactsNameEdit this$0;

    public WidgetSettingsAccountContactsNameEdit$onViewBound$2(WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit) {
        this.this$0 = widgetSettingsAccountContactsNameEdit;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsAccountContactsNameEdit widgetSettingsAccountContactsNameEdit = this.this$0;
        TextInputLayout textInputLayout = WidgetSettingsAccountContactsNameEdit.access$getBinding$p(widgetSettingsAccountContactsNameEdit).f2597b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editAccountNameWrap");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        Objects.requireNonNull(textOrEmpty, "null cannot be cast to non-null type kotlin.CharSequence");
        WidgetSettingsAccountContactsNameEdit.access$submitName(widgetSettingsAccountContactsNameEdit, w.trim(textOrEmpty).toString());
    }
}
