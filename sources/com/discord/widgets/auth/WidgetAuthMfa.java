package com.discord.widgets.auth;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.fragment.app.Fragment;
import b.a.d.m;
import b.a.d.o;
import b.a.i.n4;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuthMfaBackupCodesBinding;
import com.discord.databinding.WidgetAuthMfaBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CodeVerificationView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthMfa extends AppFragment {
    private static final int BACKUP_CODE_DIGITS = 8;
    private static final String INTENT_TICKET = "INTENT_TICKET";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean ignoreAutopaste;
    private String ticket;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthMfa.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthMfaBinding;", 0)};
    public static final WidgetAuthMfa$Companion Companion = new WidgetAuthMfa$Companion(null);

    public WidgetAuthMfa() {
        super(R$layout.widget_auth_mfa);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthMfa$binding$2.INSTANCE, null, 2, null);
        this.ignoreAutopaste = true;
    }

    public static final /* synthetic */ void access$evaluateBackupCode(WidgetAuthMfa widgetAuthMfa, AlertDialog alertDialog, String str) {
        widgetAuthMfa.evaluateBackupCode(alertDialog, str);
    }

    public static final /* synthetic */ void access$evaluateCode(WidgetAuthMfa widgetAuthMfa, String str) {
        widgetAuthMfa.evaluateCode(str);
    }

    public static final /* synthetic */ WidgetAuthMfaBinding access$getBinding$p(WidgetAuthMfa widgetAuthMfa) {
        return widgetAuthMfa.getBinding();
    }

    public static final /* synthetic */ void access$showBackupCodesDialog(WidgetAuthMfa widgetAuthMfa) {
        widgetAuthMfa.showBackupCodesDialog();
    }

    public static final /* synthetic */ void access$showInfoDialog(WidgetAuthMfa widgetAuthMfa) {
        widgetAuthMfa.showInfoDialog();
    }

    public static final /* synthetic */ void access$tryPasteCodeFromClipboard(WidgetAuthMfa widgetAuthMfa) {
        widgetAuthMfa.tryPasteCodeFromClipboard();
    }

    private final void evaluateBackupCode(AlertDialog dialog, String code) {
        if (code.length() < 8) {
            m.i(this, 2131896492, 0, 4);
        } else {
            dialog.hide();
            evaluateCode(code);
        }
    }

    private final void evaluateCode(String code) {
        if (TextUtils.isEmpty(code)) {
            m.i(this, 2131896542, 0, 4);
            return;
        }
        StoreAuthentication authentication = StoreStream.Companion.getAuthentication();
        String str = this.ticket;
        if (str == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("ticket");
        }
        ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(authentication.authMFA(code, str), this, null, 2, null), getBinding().c, 0L).k(o.a.g(getContext(), WidgetAuthMfa$evaluateCode$1.INSTANCE, new WidgetAuthMfa$evaluateCode$2(this)));
    }

    private final WidgetAuthMfaBinding getBinding() {
        return (WidgetAuthMfaBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @MainThread
    private final void showBackupCodesDialog() {
        View viewInflate = getLayoutInflater().inflate(R$layout.widget_auth_mfa_backup_codes, (ViewGroup) null, false);
        int i = R$id.server_settings_delete_server_header;
        TextView textView = (TextView) viewInflate.findViewById(R$id.server_settings_delete_server_header);
        if (textView != null) {
            i = R$id.widget_auth_mfa_backup_codes_cancel;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R$id.widget_auth_mfa_backup_codes_cancel);
            if (materialButton != null) {
                i = R$id.widget_auth_mfa_backup_codes_edittext;
                TextInputLayout textInputLayout = (TextInputLayout) viewInflate.findViewById(R$id.widget_auth_mfa_backup_codes_edittext);
                if (textInputLayout != null) {
                    i = R$id.widget_auth_mfa_backup_codes_send;
                    MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R$id.widget_auth_mfa_backup_codes_send);
                    if (materialButton2 != null) {
                        LinearLayout linearLayout = (LinearLayout) viewInflate;
                        WidgetAuthMfaBackupCodesBinding widgetAuthMfaBackupCodesBinding = new WidgetAuthMfaBackupCodesBinding(linearLayout, textView, materialButton, textInputLayout, materialButton2);
                        d0.z.d.m.checkNotNullExpressionValue(widgetAuthMfaBackupCodesBinding, "WidgetAuthMfaBackupCodes…outInflater, null, false)");
                        d0.z.d.m.checkNotNullExpressionValue(linearLayout, "binding.root");
                        AlertDialog alertDialogShow = new AlertDialog$Builder(linearLayout.getContext()).setView(linearLayout).show();
                        materialButton2.setOnClickListener(new WidgetAuthMfa$showBackupCodesDialog$1(this, alertDialogShow, widgetAuthMfaBackupCodesBinding));
                        materialButton.setOnClickListener(new WidgetAuthMfa$showBackupCodesDialog$2(alertDialogShow));
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @MainThread
    private final void showInfoDialog() {
        View viewInflate = getLayoutInflater().inflate(R$layout.widget_auth_mfa_info, (ViewGroup) null, false);
        int i = R$id.server_settings_delete_server_header;
        TextView textView = (TextView) viewInflate.findViewById(R$id.server_settings_delete_server_header);
        if (textView != null) {
            i = R$id.widget_auth_mfa_info_okay;
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R$id.widget_auth_mfa_info_okay);
            if (materialButton != null) {
                i = R$id.widget_auth_mfa_info_text;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R$id.widget_auth_mfa_info_text);
                if (linkifiedTextView != null) {
                    LinearLayout linearLayout = (LinearLayout) viewInflate;
                    d0.z.d.m.checkNotNullExpressionValue(new n4(linearLayout, textView, materialButton, linkifiedTextView), "WidgetAuthMfaInfoBinding…outInflater, null, false)");
                    d0.z.d.m.checkNotNullExpressionValue(linearLayout, "binding.root");
                    AlertDialog alertDialogShow = new AlertDialog$Builder(linearLayout.getContext()).setView(linearLayout).show();
                    d0.z.d.m.checkNotNullExpressionValue(linkifiedTextView, "binding.widgetAuthMfaInfoText");
                    b.n(linkifiedTextView, 2131896511, new Object[]{AuthUtils.URL_AUTHY, AuthUtils.URL_GOOGLE_AUTHENTICATOR}, null, 4);
                    materialButton.setOnClickListener(new WidgetAuthMfa$showInfoDialog$1(alertDialogShow));
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
            d0.z.d.m.checkNotNullExpressionValue(context, "context ?: return");
            Object systemService = context.getSystemService("clipboard");
            if (!(systemService instanceof ClipboardManager)) {
                systemService = null;
            }
            ClipboardManager clipboardManager = (ClipboardManager) systemService;
            if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                return;
            }
            d0.z.d.m.checkNotNullExpressionValue(primaryClip, "clipboard.primaryClip ?: return");
            if (primaryClip.getItemCount() >= 1) {
                CharSequence charSequenceCoerceToText = primaryClip.getItemAt(0).coerceToText(context);
                if (charSequenceCoerceToText.length() == 6 && TextUtils.isDigitsOnly(charSequenceCoerceToText)) {
                    getBinding().f2234b.setOnCodeEntered(WidgetAuthMfa$tryPasteCodeFromClipboard$1.INSTANCE);
                    CodeVerificationView codeVerificationView = getBinding().f2234b;
                    d0.z.d.m.checkNotNullExpressionValue(charSequenceCoerceToText, "clipboardText");
                    codeVerificationView.setCode(charSequenceCoerceToText);
                    getBinding().f2234b.setOnCodeEntered(new WidgetAuthMfa$tryPasteCodeFromClipboard$2(this));
                    Observable<Long> observableD0 = Observable.d0(500L, TimeUnit.MILLISECONDS);
                    d0.z.d.m.checkNotNullExpressionValue(observableD0, "Observable\n            .…L, TimeUnit.MILLISECONDS)");
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetAuthMfa.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAuthMfa$tryPasteCodeFromClipboard$3(this), 62, (Object) null);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem item) {
        d0.z.d.m.checkNotNullParameter(item, "item");
        if (item.getItemId() != 2131364379) {
            return super.onContextItemSelected(item);
        }
        tryPasteCodeFromClipboard();
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View$OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu$ContextMenuInfo menuInfo) {
        d0.z.d.m.checkNotNullParameter(menu, "menu");
        d0.z.d.m.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        new MenuInflater(requireContext()).inflate(R$menu.menu_code_verification, menu);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ignoreAutopaste) {
            this.ignoreAutopaste = false;
            return;
        }
        Observable<Long> observableD0 = Observable.d0(250L, TimeUnit.MILLISECONDS);
        d0.z.d.m.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…L, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetAuthMfa.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAuthMfa$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        AppActivity appActivity;
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_auth_mfa, new WidgetAuthMfa$onViewBound$1(this), null, 4, null);
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_TICKET);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.ticket = stringExtra;
        if (stringExtra == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("ticket");
        }
        if ((stringExtra.length() == 0) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        getBinding().f2234b.setOnCodeEntered(new WidgetAuthMfa$onViewBound$2(this));
        registerForContextMenu(getBinding().f2234b);
    }
}
