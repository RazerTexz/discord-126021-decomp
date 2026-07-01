package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetDisableDeleteAccountDialogBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams$DisableAccount;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableDeleteAccountDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetDisableDeleteAccountDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDisableDeleteAccountDialogBinding;", 0)};
    public static final WidgetDisableDeleteAccountDialog$Companion Companion = new WidgetDisableDeleteAccountDialog$Companion(null);
    private static final String EXTRA_MODE = "extra_mode";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetDisableDeleteAccountDialog() {
        super(R$layout.widget_disable_delete_account_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetDisableDeleteAccountDialog$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog, MeUser meUser) {
        widgetDisableDeleteAccountDialog.configureUI(meUser);
    }

    public static final /* synthetic */ WidgetDisableDeleteAccountDialogBinding access$getBinding$p(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog) {
        return widgetDisableDeleteAccountDialog.getBinding();
    }

    public static final /* synthetic */ void access$onDisableClicked(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog, WidgetDisableDeleteAccountDialog$Mode widgetDisableDeleteAccountDialog$Mode) {
        widgetDisableDeleteAccountDialog.onDisableClicked(widgetDisableDeleteAccountDialog$Mode);
    }

    private final void configureUI(MeUser meUser) {
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        textInputLayout.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
    }

    private final WidgetDisableDeleteAccountDialogBinding getBinding() {
        return (WidgetDisableDeleteAccountDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onDisableClicked(WidgetDisableDeleteAccountDialog$Mode mode) {
        String textOrEmpty;
        Observable<Void> observableDisableAccount;
        getBinding().e.setIsLoading(true);
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        if (textInputLayout.getVisibility() == 0) {
            TextInputLayout textInputLayout2 = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeleteCodeWrap");
            textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        } else {
            textOrEmpty = null;
        }
        TextInputLayout textInputLayout3 = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.disableDeletePasswordWrap");
        RestAPIParams$DisableAccount restAPIParams$DisableAccount = new RestAPIParams$DisableAccount(ViewExtensions.getTextOrEmpty(textInputLayout3), textOrEmpty);
        int iOrdinal = mode.ordinal();
        if (iOrdinal == 0) {
            observableDisableAccount = RestAPI.Companion.getApi().disableAccount(restAPIParams$DisableAccount);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            observableDisableAccount = RestAPI.Companion.getApi().deleteAccount(restAPIParams$DisableAccount);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableDisableAccount, false, 1, null), this, null, 2, null), WidgetDisableDeleteAccountDialog.class, (Context) null, (Function1) null, new WidgetDisableDeleteAccountDialog$onDisableClicked$1(this), (Function0) null, (Function0) null, WidgetDisableDeleteAccountDialog$onDisableClicked$2.INSTANCE, 54, (Object) null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.Companion.getUsers(), false, 1, null), this, null, 2, null), WidgetDisableDeleteAccountDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetDisableDeleteAccountDialog$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        WidgetDisableDeleteAccountDialog$Mode widgetDisableDeleteAccountDialog$Mode;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            widgetDisableDeleteAccountDialog$Mode = WidgetDisableDeleteAccountDialog$Mode.values()[arguments.getInt(EXTRA_MODE)];
        } else {
            widgetDisableDeleteAccountDialog$Mode = null;
        }
        if (widgetDisableDeleteAccountDialog$Mode == null) {
            Logger.e$default(AppLog.g, "Disable/Delete Dialog shown with null mode", null, null, 6, null);
            dismiss();
            return;
        }
        getBinding().e.setIsLoading(false);
        TextView textView = getBinding().f;
        m.checkNotNullExpressionValue(textView, "binding.disableDeleteHeader");
        textView.setText(getString(widgetDisableDeleteAccountDialog$Mode.getHeaderStringId()));
        TextView textView2 = getBinding().f2366b;
        m.checkNotNullExpressionValue(textView2, "binding.disableDeleteBody");
        textView2.setText(getString(widgetDisableDeleteAccountDialog$Mode.getBodyStringId()));
        getBinding().e.setText(getString(widgetDisableDeleteAccountDialog$Mode.getConfirmStringId()));
        getBinding().c.setOnClickListener(new WidgetDisableDeleteAccountDialog$onViewBound$1(this));
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetDisableDeleteAccountDialog$onViewBound$2(this));
        TextInputLayout textInputLayout2 = getBinding().g;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeletePasswordWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new WidgetDisableDeleteAccountDialog$onViewBound$3(this));
        getBinding().e.setOnClickListener(new WidgetDisableDeleteAccountDialog$onViewBound$4(this, widgetDisableDeleteAccountDialog$Mode));
    }
}
