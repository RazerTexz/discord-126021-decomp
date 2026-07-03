package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetEnableSmsBackupDialogBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableSMSBackupDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetEnableSMSBackupDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableSmsBackupDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_ENABLE = "extra_enable";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, boolean enable) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog = new WidgetEnableSMSBackupDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(WidgetEnableSMSBackupDialog.EXTRA_ENABLE, enable);
            widgetEnableSMSBackupDialog.setArguments(bundle);
            String tag = widgetEnableSMSBackupDialog.getTag();
            if (tag == null) {
                tag = "";
            }
            widgetEnableSMSBackupDialog.show(fragmentManager, tag);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$enableSMSBackup$1 */
    /* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
    public static final class C97131 extends AbstractC12240o implements Function1<Error, Unit> {
        public C97131() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            WidgetEnableSMSBackupDialog.this.getBinding().f16595d.setIsLoading(false);
            View view = WidgetEnableSMSBackupDialog.this.getView();
            Context context = view != null ? view.getContext() : null;
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "it.response");
            C0876m.m170h(context, response.getMessage(), 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$enableSMSBackup$2 */
    /* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
    public static final class C97142 extends AbstractC12240o implements Function1<Void, Unit> {
        public C97142() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreStream.INSTANCE.getMFA().togglingSMSBackup();
            WidgetEnableSMSBackupDialog.this.getBinding().f16595d.setIsLoading(false);
            WidgetEnableSMSBackupDialog.this.dismiss();
        }
    }

    public WidgetEnableSMSBackupDialog() {
        super(C5419R.layout.widget_enable_sms_backup_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableSMSBackupDialog$binding$2.INSTANCE, null, 2, null);
        setCancelable(false);
    }

    private final void enableSMSBackup(boolean enable) {
        TextInputLayout textInputLayout = getBinding().f16597f;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.enableSmsBackupPasswordWrap");
        RestAPIParams.ActivateMfaSMS activateMfaSMS = new RestAPIParams.ActivateMfaSMS(ViewExtensions.getTextOrEmpty(textInputLayout));
        Observable<Void> observableEnableMfaSMS = enable ? RestAPI.INSTANCE.getApi().enableMfaSMS(activateMfaSMS) : RestAPI.INSTANCE.getApi().disableMfaSMS(activateMfaSMS);
        getBinding().f16595d.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableEnableMfaSMS, false, 1, null), this, null, 2, null), (Class<?>) WidgetEnableSMSBackupDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C97131()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97142());
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
        final Boolean boolValueOf = arguments != null ? Boolean.valueOf(arguments.getBoolean(EXTRA_ENABLE)) : null;
        if (boolValueOf == null) {
            dismiss();
            return;
        }
        if (boolValueOf.booleanValue()) {
            TextView textView = getBinding().f16596e;
            C12238m.checkNotNullExpressionValue(textView, "binding.enableSmsBackupHeader");
            textView.setText(getString(C5419R.string.mfa_sms_enable));
            TextView textView2 = getBinding().f16593b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.enableSmsBackupBody");
            textView2.setText(getString(C5419R.string.mfa_sms_auth_sales_pitch));
            getBinding().f16595d.setText(getString(C5419R.string.enable));
        } else {
            TextView textView3 = getBinding().f16596e;
            C12238m.checkNotNullExpressionValue(textView3, "binding.enableSmsBackupHeader");
            textView3.setText(getString(C5419R.string.mfa_sms_remove));
            TextView textView4 = getBinding().f16593b;
            C12238m.checkNotNullExpressionValue(textView4, "binding.enableSmsBackupBody");
            textView4.setText(getString(C5419R.string.mfa_sms_confirm_remove_body));
            getBinding().f16595d.setText(getString(C5419R.string.disable));
        }
        getBinding().f16594c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog.onResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetEnableSMSBackupDialog.this.dismiss();
            }
        });
        getBinding().f16595d.setIsLoading(false);
        getBinding().f16595d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog.onResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetEnableSMSBackupDialog.this.enableSMSBackup(boolValueOf.booleanValue());
            }
        });
    }
}
