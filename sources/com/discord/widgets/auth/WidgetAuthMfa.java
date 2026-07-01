package com.discord.widgets.auth;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.i.WidgetAuthMfaInfoBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthMfaBackupCodesBinding;
import com.discord.databinding.WidgetAuthMfaBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CodeVerificationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthMfa extends AppFragment {
    private static final int BACKUP_CODE_DIGITS = 8;
    private static final String INTENT_TICKET = "INTENT_TICKET";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean ignoreAutopaste;
    private String ticket;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetAuthMfa.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthMfaBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void start(Context context, String ticket) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(ticket, "ticket");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthMfa.INTENT_TICKET, ticket);
            AppScreen2.d(context, WidgetAuthMfa.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$evaluateCode$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelLoginResult, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLoginResult modelLoginResult) {
            invoke2(modelLoginResult);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLoginResult modelLoginResult) {
            AnalyticsTracker.INSTANCE.loginAttempt(true);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthMfa.this.tryPasteCodeFromClipboard();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(WidgetAuthMfa widgetAuthMfa) {
            super(1, widgetAuthMfa, WidgetAuthMfa.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            ((WidgetAuthMfa) this.receiver).evaluateCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<String, Unit> {
        public AnonymousClass2(WidgetAuthMfa widgetAuthMfa) {
            super(1, widgetAuthMfa, WidgetAuthMfa.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            ((WidgetAuthMfa) this.receiver).evaluateCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthMfa widgetAuthMfa = WidgetAuthMfa.this;
            widgetAuthMfa.evaluateCode(widgetAuthMfa.getBinding().f2234b.getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String());
        }
    }

    public WidgetAuthMfa() {
        super(R.layout.widget_auth_mfa);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAuthMfa2.INSTANCE, null, 2, null);
        this.ignoreAutopaste = true;
    }

    private final void evaluateBackupCode(AlertDialog dialog, String code) {
        if (code.length() < 8) {
            AppToast.i(this, R.string.two_fa_backup_code_enter_wrong, 0, 4);
        } else {
            dialog.hide();
            evaluateCode(code);
        }
    }

    private final void evaluateCode(String code) {
        if (TextUtils.isEmpty(code)) {
            AppToast.i(this, R.string.two_fa_token_required, 0, 4);
            return;
        }
        StoreAuthentication authentication = StoreStream.INSTANCE.getAuthentication();
        String str = this.ticket;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("ticket");
        }
        ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(authentication.authMFA(code, str), this, null, 2, null), getBinding().c, 0L).k(o.a.g(getContext(), AnonymousClass1.INSTANCE, new Action1<Error>() { // from class: com.discord.widgets.auth.WidgetAuthMfa.evaluateCode.2
            @Override // rx.functions.Action1
            public final void call(Error error) {
                WidgetAuthMfa.this.getBinding().f2234b.b();
                AnalyticsTracker.INSTANCE.loginAttempt(false);
            }
        }));
    }

    private final WidgetAuthMfaBinding getBinding() {
        return (WidgetAuthMfaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @MainThread
    private final void showBackupCodesDialog() {
        View viewInflate = getLayoutInflater().inflate(R.layout.widget_auth_mfa_backup_codes, (ViewGroup) null, false);
        int i = R.id.server_settings_delete_server_header;
        TextView textView = (TextView) viewInflate.findViewById(R.id.server_settings_delete_server_header);
        if (textView != null) {
            i = R.id.widget_auth_mfa_backup_codes_cancel;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.widget_auth_mfa_backup_codes_cancel);
            if (materialButton != null) {
                i = R.id.widget_auth_mfa_backup_codes_edittext;
                TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R.id.widget_auth_mfa_backup_codes_edittext);
                if (textInputLayout != null) {
                    i = R.id.widget_auth_mfa_backup_codes_send;
                    MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.widget_auth_mfa_backup_codes_send);
                    if (materialButton2 != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        final WidgetAuthMfaBackupCodesBinding widgetAuthMfaBackupCodesBinding = new WidgetAuthMfaBackupCodesBinding(linearLayout, textView, materialButton, textInputLayout, materialButton2);
                        Intrinsics3.checkNotNullExpressionValue(widgetAuthMfaBackupCodesBinding, "WidgetAuthMfaBackupCodes…outInflater, null, false)");
                        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                        final AlertDialog alertDialogShow = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).show();
                        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthMfa.showBackupCodesDialog.1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                WidgetAuthMfa widgetAuthMfa = WidgetAuthMfa.this;
                                AlertDialog alertDialog = alertDialogShow;
                                Intrinsics3.checkNotNullExpressionValue(alertDialog, "dialog");
                                TextInputLayout textInputLayout2 = widgetAuthMfaBackupCodesBinding.c;
                                Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.widgetAuthMfaBackupCodesEdittext");
                                widgetAuthMfa.evaluateBackupCode(alertDialog, ViewExtensions.getTextOrEmpty(textInputLayout2));
                            }
                        });
                        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthMfa.showBackupCodesDialog.2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                alertDialogShow.hide();
                            }
                        });
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @MainThread
    private final void showInfoDialog() {
        View viewInflate = getLayoutInflater().inflate(R.layout.widget_auth_mfa_info, (ViewGroup) null, false);
        int i = R.id.server_settings_delete_server_header;
        TextView textView = (TextView) viewInflate.findViewById(R.id.server_settings_delete_server_header);
        if (textView != null) {
            i = R.id.widget_auth_mfa_info_okay;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.widget_auth_mfa_info_okay);
            if (materialButton != null) {
                i = R.id.widget_auth_mfa_info_text;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R.id.widget_auth_mfa_info_text);
                if (linkifiedTextView != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    Intrinsics3.checkNotNullExpressionValue(new WidgetAuthMfaInfoBinding(linearLayout, textView, materialButton, linkifiedTextView), "WidgetAuthMfaInfoBinding…outInflater, null, false)");
                    Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                    final AlertDialog alertDialogShow = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).show();
                    Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.widgetAuthMfaInfoText");
                    FormatUtils.m(linkifiedTextView, R.string.two_fa_download_app_body, new Object[]{AuthUtils.URL_AUTHY, AuthUtils.URL_GOOGLE_AUTHENTICATOR}, (4 & 4) != 0 ? FormatUtils.g.j : null);
                    materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthMfa.showInfoDialog.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            alertDialogShow.dismiss();
                        }
                    });
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void tryPasteCodeFromClipboard() {
        ClipData primaryClip;
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            Intrinsics3.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
            if (primaryClip.getItemCount() >= 1) {
                CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(context);
                if (charSequenceCoerceToText.length() == 6 && TextUtils.isDigitsOnly(charSequenceCoerceToText)) {
                    getBinding().f2234b.setOnCodeEntered(AnonymousClass1.INSTANCE);
                    CodeVerificationView codeVerificationView = getBinding().f2234b;
                    Intrinsics3.checkNotNullExpressionValue(charSequenceCoerceToText, "clipboardText");
                    codeVerificationView.setCode(charSequenceCoerceToText);
                    getBinding().f2234b.setOnCodeEntered(new AnonymousClass2(this));
                    Observable<Long> observableD0 = Observable.d0(500L, TimeUnit.MILLISECONDS);
                    Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n            .…L, TimeUnit.MILLISECONDS)");
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), (Class<?>) WidgetAuthMfa.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        if (item.getItemId() != R.id.menu_code_verification_paste) {
            return super.onContextItemSelected(item);
        }
        tryPasteCodeFromClipboard();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        Intrinsics3.checkNotNullParameter(menu, "menu");
        Intrinsics3.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(requireContext()).inflate(R.menu.menu_code_verification, menu);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ignoreAutopaste) {
            this.ignoreAutopaste = false;
            return;
        }
        Observable<Long> observableD0 = Observable.d0(250L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…L, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), (Class<?>) WidgetAuthMfa.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        AppActivity appActivity;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_auth_mfa, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.auth.WidgetAuthMfa.onViewBound.1
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case R.id.menu_auth_mfa_backup_codes /* 2131364363 */:
                        WidgetAuthMfa.this.showBackupCodesDialog();
                        break;
                    case R.id.menu_auth_mfa_info /* 2131364364 */:
                        WidgetAuthMfa.this.showInfoDialog();
                        break;
                }
            }
        }, null, 4, null);
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_TICKET);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.ticket = stringExtra;
        if (stringExtra == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("ticket");
        }
        if ((stringExtra.length() == 0) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        getBinding().f2234b.setOnCodeEntered(new AnonymousClass2(this));
        registerForContextMenu(getBinding().f2234b);
    }
}
