package com.discord.widgets.settings.account.mfa;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaKeyBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEnableMFAKey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAKey extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetEnableMFAKey.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaKeyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetEnableMFAKey.kt */
    public static final class Companion {
        private Companion() {
        }

        private final boolean isPackageInstalled(String packageName, PackageManager packageManager) {
            try {
                packageManager.getPackageInfo(packageName, 0);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetEnableMFAKey() {
        super(C5419R.layout.widget_settings_enable_mfa_key);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableMFAKey$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new C9789xda6f58bd(this), new C0863f0(WidgetEnableMFAKey$viewModel$2.INSTANCE));
    }

    private final void copyCodeToClipboard(Context context) {
        AuthUtils authUtils = AuthUtils.INSTANCE;
        TextView textView = getBinding().f17948b;
        C12238m.checkNotNullExpressionValue(textView, "binding.enableMfaKeyCode");
        String strEncodeTotpSecret = authUtils.encodeTotpSecret(textView.getText().toString());
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText("two fa code", strEncodeTotpSecret);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        C0876m.m169g(context, C5419R.string.copied_text, 0, null, 12);
    }

    private final WidgetSettingsEnableMfaKeyBinding getBinding() {
        return (WidgetSettingsEnableMfaKeyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    private final void showLaunchTexts() {
        final PackageManager packageManager;
        FragmentActivity fragmentActivityM95e = m95e();
        if (fragmentActivityM95e == null || (packageManager = fragmentActivityM95e.getPackageManager()) == null) {
            return;
        }
        Companion companion = INSTANCE;
        if (companion.isPackageInstalled(AuthUtils.AUTHY_PACKAGE, packageManager)) {
            TextView textView = getBinding().f17949c;
            C12238m.checkNotNullExpressionValue(textView, "binding.enableMfaKeyLaunchAuthy");
            textView.setText(C1107b.m213e(this, C5419R.string.launch_app, new Object[]{C1107b.m213e(this, C5419R.string.two_fa_app_name_authy, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null)}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
            TextView textView2 = getBinding().f17949c;
            C12238m.checkNotNullExpressionValue(textView2, "binding.enableMfaKeyLaunchAuthy");
            textView2.setVisibility(0);
            getBinding().f17949c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey.showLaunchTexts.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C12238m.checkNotNullExpressionValue(view, "it");
                    Context context = view.getContext();
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(AuthUtils.AUTHY_PACKAGE);
                    if (launchIntentForPackage != null) {
                        context.startActivity(launchIntentForPackage);
                    }
                }
            });
        }
        if (companion.isPackageInstalled(AuthUtils.GOOGLE_AUTHENTICATOR_PACKAGE, packageManager)) {
            TextView textView3 = getBinding().f17950d;
            C12238m.checkNotNullExpressionValue(textView3, "binding.enableMfaKeyLaunchGoogleAuth");
            textView3.setText(C1107b.m213e(this, C5419R.string.launch_app, new Object[]{C1107b.m213e(this, C5419R.string.two_fa_app_name_google_authenticator, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null)}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
            TextView textView4 = getBinding().f17950d;
            C12238m.checkNotNullExpressionValue(textView4, "binding.enableMfaKeyLaunchGoogleAuth");
            textView4.setVisibility(0);
            getBinding().f17950d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey.showLaunchTexts.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C12238m.checkNotNullExpressionValue(view, "it");
                    Context context = view.getContext();
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(AuthUtils.GOOGLE_AUTHENTICATOR_PACKAGE);
                    if (launchIntentForPackage != null) {
                        context.startActivity(launchIntentForPackage);
                    }
                }
            });
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f17948b;
        C12238m.checkNotNullExpressionValue(textView, "binding.enableMfaKeyCode");
        textView.setText(getViewModel().getTotpSecret());
        getBinding().f17948b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEnableMFAKey widgetEnableMFAKey = WidgetEnableMFAKey.this;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                widgetEnableMFAKey.copyCodeToClipboard(context);
            }
        });
        showLaunchTexts();
    }
}
