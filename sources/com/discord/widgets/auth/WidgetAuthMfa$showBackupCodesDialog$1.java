package com.discord.widgets.auth;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.appcompat.app.AlertDialog;
import com.discord.databinding.WidgetAuthMfaBackupCodesBinding;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthMfa$showBackupCodesDialog$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetAuthMfaBackupCodesBinding $binding;
    public final /* synthetic */ AlertDialog $dialog;
    public final /* synthetic */ WidgetAuthMfa this$0;

    public WidgetAuthMfa$showBackupCodesDialog$1(WidgetAuthMfa widgetAuthMfa, AlertDialog alertDialog, WidgetAuthMfaBackupCodesBinding widgetAuthMfaBackupCodesBinding) {
        this.this$0 = widgetAuthMfa;
        this.$dialog = alertDialog;
        this.$binding = widgetAuthMfaBackupCodesBinding;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetAuthMfa widgetAuthMfa = this.this$0;
        AlertDialog alertDialog = this.$dialog;
        m.checkNotNullExpressionValue(alertDialog, "dialog");
        TextInputLayout textInputLayout = this.$binding.c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.widgetAuthMfaBackupCodesEdittext");
        WidgetAuthMfa.access$evaluateBackupCode(widgetAuthMfa, alertDialog, ViewExtensions.getTextOrEmpty(textInputLayout));
    }
}
