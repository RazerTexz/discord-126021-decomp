package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetEnableSmsBackupDialogBinding;
import com.discord.restapi.RestAPIParams$ActivateMfaSMS;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableSMSBackupDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEnableSMSBackupDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableSmsBackupDialogBinding;", 0)};
    public static final WidgetEnableSMSBackupDialog$Companion Companion = new WidgetEnableSMSBackupDialog$Companion(null);
    private static final String EXTRA_ENABLE = "extra_enable";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetEnableSMSBackupDialog() {
        super(R$layout.widget_enable_sms_backup_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableSMSBackupDialog$binding$2.INSTANCE, null, 2, null);
        setCancelable(false);
    }

    public static final /* synthetic */ void access$enableSMSBackup(WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog, boolean z2) {
        widgetEnableSMSBackupDialog.enableSMSBackup(z2);
    }

    public static final /* synthetic */ WidgetEnableSmsBackupDialogBinding access$getBinding$p(WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog) {
        return widgetEnableSMSBackupDialog.getBinding();
    }

    private final void enableSMSBackup(boolean enable) {
        TextInputLayout textInputLayout = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout, "binding.enableSmsBackupPasswordWrap");
        RestAPIParams$ActivateMfaSMS restAPIParams$ActivateMfaSMS = new RestAPIParams$ActivateMfaSMS(ViewExtensions.getTextOrEmpty(textInputLayout));
        Observable<Void> observableEnableMfaSMS = enable ? RestAPI.Companion.getApi().enableMfaSMS(restAPIParams$ActivateMfaSMS) : RestAPI.Companion.getApi().disableMfaSMS(restAPIParams$ActivateMfaSMS);
        getBinding().d.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableEnableMfaSMS, false, 1, null), this, null, 2, null), WidgetEnableSMSBackupDialog.class, (Context) null, (Function1) null, new WidgetEnableSMSBackupDialog$enableSMSBackup$1(this), (Function0) null, (Function0) null, new WidgetEnableSMSBackupDialog$enableSMSBackup$2(this), 54, (Object) null);
    }

    private final WidgetEnableSmsBackupDialogBinding getBinding() {
        return (WidgetEnableSmsBackupDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        AppDialog.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        Boolean boolValueOf = arguments != null ? Boolean.valueOf(arguments.getBoolean(EXTRA_ENABLE)) : null;
        if (boolValueOf == null) {
            dismiss();
            return;
        }
        if (boolValueOf.booleanValue()) {
            TextView textView = getBinding().e;
            m.checkNotNullExpressionValue(textView, "binding.enableSmsBackupHeader");
            textView.setText(getString(2131892993));
            TextView textView2 = getBinding().f2381b;
            m.checkNotNullExpressionValue(textView2, "binding.enableSmsBackupBody");
            textView2.setText(getString(2131892988));
            getBinding().d.setText(getString(2131888824));
        } else {
            TextView textView3 = getBinding().e;
            m.checkNotNullExpressionValue(textView3, "binding.enableSmsBackupHeader");
            textView3.setText(getString(2131892998));
            TextView textView4 = getBinding().f2381b;
            m.checkNotNullExpressionValue(textView4, "binding.enableSmsBackupBody");
            textView4.setText(getString(2131892990));
            getBinding().d.setText(getString(2131888462));
        }
        getBinding().c.setOnClickListener(new WidgetEnableSMSBackupDialog$onResume$1(this));
        getBinding().d.setIsLoading(false);
        getBinding().d.setOnClickListener(new WidgetEnableSMSBackupDialog$onResume$2(this, boolValueOf));
    }
}
