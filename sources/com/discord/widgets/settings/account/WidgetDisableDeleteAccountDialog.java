package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetDisableDeleteAccountDialogBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableDeleteAccountDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetDisableDeleteAccountDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDisableDeleteAccountDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_MODE = "extra_mode";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Mode mode) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(mode, "mode");
            WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog = new WidgetDisableDeleteAccountDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(WidgetDisableDeleteAccountDialog.EXTRA_MODE, mode.ordinal());
            widgetDisableDeleteAccountDialog.setArguments(bundle);
            String tag = widgetDisableDeleteAccountDialog.getTag();
            if (tag == null) {
                tag = "";
            }
            widgetDisableDeleteAccountDialog.show(fragmentManager, tag);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public enum Mode {
        DISABLE(C5419R.string.disable_account, C5419R.string.disable_account_body, C5419R.string.disable),
        DELETE(C5419R.string.delete_account, C5419R.string.delete_account_body, C5419R.string.delete);

        private final int bodyStringId;
        private final int confirmStringId;
        private final int headerStringId;

        Mode(@StringRes int i, int i2, int i3) {
            this.headerStringId = i;
            this.bodyStringId = i2;
            this.confirmStringId = i3;
        }

        public final int getBodyStringId() {
            return this.bodyStringId;
        }

        public final int getConfirmStringId() {
            return this.confirmStringId;
        }

        public final int getHeaderStringId() {
            return this.headerStringId;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Mode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[Mode.DISABLE.ordinal()] = 1;
            iArr[Mode.DELETE.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onDisableClicked$1 */
    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public static final class C97061 extends AbstractC12240o implements Function1<Error, Unit> {
        public C97061() {
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
            WidgetDisableDeleteAccountDialog.this.getBinding().f16471e.setIsLoading(false);
            Error.Response response = error.getResponse();
            C12238m.checkNotNullExpressionValue(response, "it.response");
            int code = response.getCode();
            if (code == 50018) {
                TextInputLayout textInputLayout = WidgetDisableDeleteAccountDialog.this.getBinding().f16473g;
                C12238m.checkNotNullExpressionValue(textInputLayout, "binding.disableDeletePasswordWrap");
                Error.Response response2 = error.getResponse();
                C12238m.checkNotNullExpressionValue(response2, "it.response");
                textInputLayout.setError(response2.getMessage());
                return;
            }
            if (code != 60008) {
                Context context = WidgetDisableDeleteAccountDialog.this.getContext();
                Error.Response response3 = error.getResponse();
                C12238m.checkNotNullExpressionValue(response3, "it.response");
                C0876m.m170h(context, response3.getMessage(), 0, null, 12);
                return;
            }
            TextInputLayout textInputLayout2 = WidgetDisableDeleteAccountDialog.this.getBinding().f16470d;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeleteCodeWrap");
            Error.Response response4 = error.getResponse();
            C12238m.checkNotNullExpressionValue(response4, "it.response");
            textInputLayout2.setError(response4.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onDisableClicked$2 */
    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public static final class C97072 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C97072 INSTANCE = new C97072();

        public C97072() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            StoreStream.INSTANCE.getAuthentication().logout();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onResume$1 */
    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public static final /* synthetic */ class C97081 extends C12236k implements Function1<MeUser, Unit> {
        public C97081(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog) {
            super(1, widgetDisableDeleteAccountDialog, WidgetDisableDeleteAccountDialog.class, "configureUI", "configureUI(Lcom/discord/models/user/MeUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            C12238m.checkNotNullParameter(meUser, "p1");
            ((WidgetDisableDeleteAccountDialog) this.receiver).configureUI(meUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public static final class C97102 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C97102() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetDisableDeleteAccountDialog.this.getBinding().f16470d;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
            textInputLayout.setError(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public static final class C97113 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C97113() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetDisableDeleteAccountDialog.this.getBinding().f16473g;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.disableDeletePasswordWrap");
            textInputLayout.setError(null);
        }
    }

    public WidgetDisableDeleteAccountDialog() {
        super(C5419R.layout.widget_disable_delete_account_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetDisableDeleteAccountDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI(MeUser meUser) {
        TextInputLayout textInputLayout = getBinding().f16470d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        textInputLayout.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
    }

    private final WidgetDisableDeleteAccountDialogBinding getBinding() {
        return (WidgetDisableDeleteAccountDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onDisableClicked(Mode mode) {
        String textOrEmpty;
        Observable<Void> observableDisableAccount;
        getBinding().f16471e.setIsLoading(true);
        TextInputLayout textInputLayout = getBinding().f16470d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        if (textInputLayout.getVisibility() == 0) {
            TextInputLayout textInputLayout2 = getBinding().f16470d;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeleteCodeWrap");
            textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        } else {
            textOrEmpty = null;
        }
        TextInputLayout textInputLayout3 = getBinding().f16473g;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.disableDeletePasswordWrap");
        RestAPIParams.DisableAccount disableAccount = new RestAPIParams.DisableAccount(ViewExtensions.getTextOrEmpty(textInputLayout3), textOrEmpty);
        int iOrdinal = mode.ordinal();
        if (iOrdinal == 0) {
            observableDisableAccount = RestAPI.INSTANCE.getApi().disableAccount(disableAccount);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            observableDisableAccount = RestAPI.INSTANCE.getApi().deleteAccount(disableAccount);
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableDisableAccount, false, 1, null), this, null, 2, null), (Class<?>) WidgetDisableDeleteAccountDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C97061()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C97072.INSTANCE);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), (Class<?>) WidgetDisableDeleteAccountDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97081(this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        final Mode mode;
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mode = Mode.values()[arguments.getInt(EXTRA_MODE)];
        } else {
            mode = null;
        }
        if (mode == null) {
            Logger.e$default(AppLog.f14950g, "Disable/Delete Dialog shown with null mode", null, null, 6, null);
            dismiss();
            return;
        }
        getBinding().f16471e.setIsLoading(false);
        TextView textView = getBinding().f16472f;
        C12238m.checkNotNullExpressionValue(textView, "binding.disableDeleteHeader");
        textView.setText(getString(mode.getHeaderStringId()));
        TextView textView2 = getBinding().f16468b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.disableDeleteBody");
        textView2.setText(getString(mode.getBodyStringId()));
        getBinding().f16471e.setText(getString(mode.getConfirmStringId()));
        getBinding().f16469c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetDisableDeleteAccountDialog.this.dismiss();
            }
        });
        TextInputLayout textInputLayout = getBinding().f16470d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C97102());
        TextInputLayout textInputLayout2 = getBinding().f16473g;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeletePasswordWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new C97113());
        getBinding().f16471e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetDisableDeleteAccountDialog.this.onDisableClicked(mode);
            }
        });
    }
}
