package com.discord.widgets.settings.account.mfa;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaKeyBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetEnableMFAKey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAKey extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEnableMFAKey.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaKeyBinding;", 0)};
    public static final WidgetEnableMFAKey$Companion Companion = new WidgetEnableMFAKey$Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetEnableMFAKey() {
        super(R$layout.widget_settings_enable_mfa_key);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableMFAKey$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new WidgetEnableMFAKey$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetEnableMFAKey$viewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$copyCodeToClipboard(WidgetEnableMFAKey widgetEnableMFAKey, Context context) {
        widgetEnableMFAKey.copyCodeToClipboard(context);
    }

    private final void copyCodeToClipboard(Context context) {
        AuthUtils authUtils = AuthUtils.INSTANCE;
        TextView textView = getBinding().f2618b;
        m.checkNotNullExpressionValue(textView, "binding.enableMfaKeyCode");
        String strEncodeTotpSecret = authUtils.encodeTotpSecret(textView.getText().toString());
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText("two fa code", strEncodeTotpSecret);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        b.a.d.m.g(context, 2131887925, 0, null, 12);
    }

    private final WidgetSettingsEnableMfaKeyBinding getBinding() {
        return (WidgetSettingsEnableMfaKeyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    private final void showLaunchTexts() {
        PackageManager packageManager;
        FragmentActivity activity = getActivity();
        if (activity == null || (packageManager = activity.getPackageManager()) == null) {
            return;
        }
        WidgetEnableMFAKey$Companion widgetEnableMFAKey$Companion = Companion;
        if (WidgetEnableMFAKey$Companion.access$isPackageInstalled(widgetEnableMFAKey$Companion, AuthUtils.AUTHY_PACKAGE, packageManager)) {
            TextView textView = getBinding().c;
            m.checkNotNullExpressionValue(textView, "binding.enableMfaKeyLaunchAuthy");
            textView.setText(b.k(this, 2131892519, new Object[]{b.k(this, 2131896487, new Object[0], null, 4)}, null, 4));
            TextView textView2 = getBinding().c;
            m.checkNotNullExpressionValue(textView2, "binding.enableMfaKeyLaunchAuthy");
            textView2.setVisibility(0);
            getBinding().c.setOnClickListener(new WidgetEnableMFAKey$showLaunchTexts$1(packageManager));
        }
        if (WidgetEnableMFAKey$Companion.access$isPackageInstalled(widgetEnableMFAKey$Companion, AuthUtils.GOOGLE_AUTHENTICATOR_PACKAGE, packageManager)) {
            TextView textView3 = getBinding().d;
            m.checkNotNullExpressionValue(textView3, "binding.enableMfaKeyLaunchGoogleAuth");
            textView3.setText(b.k(this, 2131892519, new Object[]{b.k(this, 2131896488, new Object[0], null, 4)}, null, 4));
            TextView textView4 = getBinding().d;
            m.checkNotNullExpressionValue(textView4, "binding.enableMfaKeyLaunchGoogleAuth");
            textView4.setVisibility(0);
            getBinding().d.setOnClickListener(new WidgetEnableMFAKey$showLaunchTexts$2(packageManager));
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f2618b;
        m.checkNotNullExpressionValue(textView, "binding.enableMfaKeyCode");
        textView.setText(getViewModel().getTotpSecret());
        getBinding().f2618b.setOnClickListener(new WidgetEnableMFAKey$onViewBound$1(this));
        showLaunchTexts();
    }
}
