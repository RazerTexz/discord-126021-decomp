package com.discord.widgets.settings.billing;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetPaymentSourceEditDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$Companion {
    private WidgetPaymentSourceEditDialog$Companion() {
    }

    public static final /* synthetic */ String access$getTextOrEmpty(WidgetPaymentSourceEditDialog$Companion widgetPaymentSourceEditDialog$Companion, TextInputLayout textInputLayout) {
        return widgetPaymentSourceEditDialog$Companion.getTextOrEmpty(textInputLayout);
    }

    private final String getTextOrEmpty(TextInputLayout textInputLayout) {
        Editable text;
        EditText editText = textInputLayout.getEditText();
        String string = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        return string != null ? string : "";
    }

    public final void launch(FragmentManager fragmentManager, String paymentSourceId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(paymentSourceId, "paymentSourceId");
        WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog = new WidgetPaymentSourceEditDialog();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_PAYMENT_SOURCE_ID", paymentSourceId);
        widgetPaymentSourceEditDialog.setArguments(bundle);
        widgetPaymentSourceEditDialog.show(fragmentManager, "javaClass");
    }

    public /* synthetic */ WidgetPaymentSourceEditDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
