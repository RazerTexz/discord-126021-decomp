package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetDisableDeleteAccountDialogBinding;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableDeleteAccountDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetDisableDeleteAccountDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDisableDeleteAccountDialogBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(mode, "mode");
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
        DISABLE(R.string.disable_account, R.string.disable_account_body, R.string.disable),
        DELETE(R.string.delete_account, R.string.delete_account_body, R.string.delete);

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

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onDisableClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetDisableDeleteAccountDialog.this.getBinding().e.setIsLoading(false);
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "it.response");
            int code = response.getCode();
            if (code == 50018) {
                TextInputLayout textInputLayout = WidgetDisableDeleteAccountDialog.this.getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeletePasswordWrap");
                Error.Response response2 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response2, "it.response");
                textInputLayout.setError(response2.getMessage());
                return;
            }
            if (code != 60008) {
                Context context = WidgetDisableDeleteAccountDialog.this.getContext();
                Error.Response response3 = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response3, "it.response");
                AppToast.h(context, response3.getMessage(), 0, null, 12);
                return;
            }
            TextInputLayout textInputLayout2 = WidgetDisableDeleteAccountDialog.this.getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeleteCodeWrap");
            Error.Response response4 = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response4, "it.response");
            textInputLayout2.setError(response4.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onDisableClicked$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            StoreStream.INSTANCE.getAuthentication().logout();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<MeUser, Unit> {
        public AnonymousClass1(WidgetDisableDeleteAccountDialog widgetDisableDeleteAccountDialog) {
            super(1, widgetDisableDeleteAccountDialog, WidgetDisableDeleteAccountDialog.class, "configureUI", "configureUI(Lcom/discord/models/user/MeUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "p1");
            ((WidgetDisableDeleteAccountDialog) this.receiver).configureUI(meUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetDisableDeleteAccountDialog.this.getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
            textInputLayout.setError(null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDisableDeleteAccountDialog.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            TextInputLayout textInputLayout = WidgetDisableDeleteAccountDialog.this.getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeletePasswordWrap");
            textInputLayout.setError(null);
        }
    }

    public WidgetDisableDeleteAccountDialog() {
        super(R.layout.widget_disable_delete_account_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetDisableDeleteAccountDialog2.INSTANCE, null, 2, null);
    }

    private final void configureUI(MeUser meUser) {
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        textInputLayout.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
    }

    private final WidgetDisableDeleteAccountDialogBinding getBinding() {
        return (WidgetDisableDeleteAccountDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onDisableClicked(Mode mode) {
        String textOrEmpty;
        Observable<Void> observableDisableAccount;
        getBinding().e.setIsLoading(true);
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        if (textInputLayout.getVisibility() == 0) {
            TextInputLayout textInputLayout2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeleteCodeWrap");
            textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        } else {
            textOrEmpty = null;
        }
        TextInputLayout textInputLayout3 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.disableDeletePasswordWrap");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableDisableAccount, false, 1, null), this, null, 2, null), (Class<?>) WidgetDisableDeleteAccountDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass2.INSTANCE);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null), this, null, 2, null), (Class<?>) WidgetDisableDeleteAccountDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        final Mode mode;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setCancelable(false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            mode = Mode.values()[arguments.getInt(EXTRA_MODE)];
        } else {
            mode = null;
        }
        if (mode == null) {
            Logger.e$default(AppLog.g, "Disable/Delete Dialog shown with null mode", null, null, 6, null);
            dismiss();
            return;
        }
        getBinding().e.setIsLoading(false);
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.disableDeleteHeader");
        textView.setText(getString(mode.getHeaderStringId()));
        TextView textView2 = getBinding().f2366b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.disableDeleteBody");
        textView2.setText(getString(mode.getBodyStringId()));
        getBinding().e.setText(getString(mode.getConfirmStringId()));
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetDisableDeleteAccountDialog.this.dismiss();
            }
        });
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableDeleteCodeWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
        TextInputLayout textInputLayout2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.disableDeletePasswordWrap");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new AnonymousClass3());
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetDisableDeleteAccountDialog.this.onDisableClicked(mode);
            }
        });
    }
}
