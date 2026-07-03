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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CodeVerificationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p025i.C1014n4;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthMfa extends AppFragment {
    private static final int BACKUP_CODE_DIGITS = 8;
    private static final String INTENT_TICKET = "INTENT_TICKET";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean ignoreAutopaste;
    private String ticket;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetAuthMfa.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthMfaBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void start(Context context, String ticket) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(ticket, "ticket");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthMfa.INTENT_TICKET, ticket);
            C0870j.m156d(context, WidgetAuthMfa.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$evaluateCode$1 */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final class C71961 extends AbstractC12240o implements Function1<ModelLoginResult, Unit> {
        public static final C71961 INSTANCE = new C71961();

        public C71961() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelLoginResult modelLoginResult) {
            invoke2(modelLoginResult);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelLoginResult modelLoginResult) {
            AnalyticsTracker.INSTANCE.loginAttempt(true);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$onResume$1 */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final class C71981 extends AbstractC12240o implements Function1<Long, Unit> {
        public C71981() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthMfa.this.tryPasteCodeFromClipboard();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final /* synthetic */ class C72002 extends C12236k implements Function1<String, Unit> {
        public C72002(WidgetAuthMfa widgetAuthMfa) {
            super(1, widgetAuthMfa, WidgetAuthMfa.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "p1");
            ((WidgetAuthMfa) this.receiver).evaluateCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$1 */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final class C72041 extends AbstractC12240o implements Function1<String, Unit> {
        public static final C72041 INSTANCE = new C72041();

        public C72041() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$2 */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final /* synthetic */ class C72052 extends C12236k implements Function1<String, Unit> {
        public C72052(WidgetAuthMfa widgetAuthMfa) {
            super(1, widgetAuthMfa, WidgetAuthMfa.class, "evaluateCode", "evaluateCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "p1");
            ((WidgetAuthMfa) this.receiver).evaluateCode(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$tryPasteCodeFromClipboard$3 */
    /* JADX INFO: compiled from: WidgetAuthMfa.kt */
    public static final class C72063 extends AbstractC12240o implements Function1<Long, Unit> {
        public C72063() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetAuthMfa widgetAuthMfa = WidgetAuthMfa.this;
            widgetAuthMfa.evaluateCode(widgetAuthMfa.getBinding().f15693b.getCom.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String());
        }
    }

    public WidgetAuthMfa() {
        super(C5419R.layout.widget_auth_mfa);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthMfa$binding$2.INSTANCE, null, 2, null);
        this.ignoreAutopaste = true;
    }

    private final void evaluateBackupCode(AlertDialog dialog, String code) {
        if (code.length() < 8) {
            C0876m.m171i(this, C5419R.string.two_fa_backup_code_enter_wrong, 0, 4);
        } else {
            dialog.hide();
            evaluateCode(code);
        }
    }

    private final void evaluateCode(String code) {
        if (TextUtils.isEmpty(code)) {
            C0876m.m171i(this, C5419R.string.two_fa_token_required, 0, 4);
            return;
        }
        StoreAuthentication authentication = StoreStream.INSTANCE.getAuthentication();
        String str = this.ticket;
        if (str == null) {
            C12238m.throwUninitializedPropertyAccessException("ticket");
        }
        ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(authentication.authMFA(code, str), this, null, 2, null), getBinding().f15694c, 0L).m11108k(C0879o.f566a.m184g(getContext(), C71961.INSTANCE, new Action1<Error>() { // from class: com.discord.widgets.auth.WidgetAuthMfa.evaluateCode.2
            @Override // p658rx.functions.Action1
            public final void call(Error error) {
                WidgetAuthMfa.this.getBinding().f15693b.m8538b();
                AnalyticsTracker.INSTANCE.loginAttempt(false);
            }
        }));
    }

    private final WidgetAuthMfaBinding getBinding() {
        return (WidgetAuthMfaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @MainThread
    private final void showBackupCodesDialog() {
        View viewInflate = getLayoutInflater().inflate(C5419R.layout.widget_auth_mfa_backup_codes, (ViewGroup) null, false);
        int i = C5419R.id.server_settings_delete_server_header;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.server_settings_delete_server_header);
        if (textView != null) {
            i = C5419R.id.widget_auth_mfa_backup_codes_cancel;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.widget_auth_mfa_backup_codes_cancel);
            if (materialButton != null) {
                i = C5419R.id.widget_auth_mfa_backup_codes_edittext;
                TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(C5419R.id.widget_auth_mfa_backup_codes_edittext);
                if (textInputLayout != null) {
                    i = C5419R.id.widget_auth_mfa_backup_codes_send;
                    MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(C5419R.id.widget_auth_mfa_backup_codes_send);
                    if (materialButton2 != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        final WidgetAuthMfaBackupCodesBinding widgetAuthMfaBackupCodesBinding = new WidgetAuthMfaBackupCodesBinding(linearLayout, textView, materialButton, textInputLayout, materialButton2);
                        C12238m.checkNotNullExpressionValue(widgetAuthMfaBackupCodesBinding, "WidgetAuthMfaBackupCodes…outInflater, null, false)");
                        C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
                        final AlertDialog alertDialogShow = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).show();
                        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthMfa.showBackupCodesDialog.1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                WidgetAuthMfa widgetAuthMfa = WidgetAuthMfa.this;
                                AlertDialog alertDialog = alertDialogShow;
                                C12238m.checkNotNullExpressionValue(alertDialog, "dialog");
                                TextInputLayout textInputLayout2 = widgetAuthMfaBackupCodesBinding.f15690c;
                                C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.widgetAuthMfaBackupCodesEdittext");
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
        View viewInflate = getLayoutInflater().inflate(C5419R.layout.widget_auth_mfa_info, (ViewGroup) null, false);
        int i = C5419R.id.server_settings_delete_server_header;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.server_settings_delete_server_header);
        if (textView != null) {
            i = C5419R.id.widget_auth_mfa_info_okay;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.widget_auth_mfa_info_okay);
            if (materialButton != null) {
                i = C5419R.id.widget_auth_mfa_info_text;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(C5419R.id.widget_auth_mfa_info_text);
                if (linkifiedTextView != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    C12238m.checkNotNullExpressionValue(new C1014n4(linearLayout, textView, materialButton, linkifiedTextView), "WidgetAuthMfaInfoBinding…outInflater, null, false)");
                    C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
                    final AlertDialog alertDialogShow = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).show();
                    C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.widgetAuthMfaInfoText");
                    C1107b.m221m(linkifiedTextView, C5419R.string.two_fa_download_app_body, new Object[]{AuthUtils.URL_AUTHY, AuthUtils.URL_GOOGLE_AUTHENTICATOR}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
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
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            C12238m.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
            if (primaryClip.getItemCount() >= 1) {
                CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(context);
                if (charSequenceCoerceToText.length() == 6 && TextUtils.isDigitsOnly(charSequenceCoerceToText)) {
                    getBinding().f15693b.setOnCodeEntered(C72041.INSTANCE);
                    CodeVerificationView codeVerificationView = getBinding().f15693b;
                    C12238m.checkNotNullExpressionValue(charSequenceCoerceToText, "clipboardText");
                    codeVerificationView.setCode(charSequenceCoerceToText);
                    getBinding().f15693b.setOnCodeEntered(new C72052(this));
                    Observable<Long> observableM11068d0 = Observable.m11068d0(500L, TimeUnit.MILLISECONDS);
                    C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n            .…L, TimeUnit.MILLISECONDS)");
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), (Class<?>) WidgetAuthMfa.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C72063());
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        C12238m.checkNotNullParameter(item, "item");
        if (item.getItemId() != C5419R.id.menu_code_verification_paste) {
            return super.onContextItemSelected(item);
        }
        tryPasteCodeFromClipboard();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        C12238m.checkNotNullParameter(menu, "menu");
        C12238m.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(requireContext()).inflate(C5419R.menu.menu_code_verification, menu);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ignoreAutopaste) {
            this.ignoreAutopaste = false;
            return;
        }
        Observable<Long> observableM11068d0 = Observable.m11068d0(250L, TimeUnit.MILLISECONDS);
        C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n          .ti…L, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), (Class<?>) WidgetAuthMfa.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71981());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        AppActivity appActivity;
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_auth_mfa, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.auth.WidgetAuthMfa.onViewBound.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case C5419R.id.menu_auth_mfa_backup_codes /* 2131364363 */:
                        WidgetAuthMfa.this.showBackupCodesDialog();
                        break;
                    case C5419R.id.menu_auth_mfa_info /* 2131364364 */:
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
            C12238m.throwUninitializedPropertyAccessException("ticket");
        }
        if ((stringExtra.length() == 0) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        getBinding().f15693b.setOnCodeEntered(new C72002(this));
        registerForContextMenu(getBinding().f15693b);
    }
}
