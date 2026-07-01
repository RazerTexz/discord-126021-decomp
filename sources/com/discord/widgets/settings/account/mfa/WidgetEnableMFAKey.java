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
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaKeyBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetEnableMFAKey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFAKey extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEnableMFAKey.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaKeyBinding;", 0)};

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
        super(R.layout.widget_settings_enable_mfa_key);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableMFAKey2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetEnableMFAViewModel.class), new WidgetEnableMFAKey$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetEnableMFAKey3.INSTANCE));
    }

    private final void copyCodeToClipboard(Context context) {
        AuthUtils authUtils = AuthUtils.INSTANCE;
        TextView textView = getBinding().f2618b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableMfaKeyCode");
        String strEncodeTotpSecret = authUtils.encodeTotpSecret(textView.getText().toString());
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText("two fa code", strEncodeTotpSecret);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        AppToast.g(context, R.string.copied_text, 0, null, 12);
    }

    private final WidgetSettingsEnableMfaKeyBinding getBinding() {
        return (WidgetSettingsEnableMfaKeyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetEnableMFAViewModel getViewModel() {
        return (WidgetEnableMFAViewModel) this.viewModel.getValue();
    }

    private final void showLaunchTexts() {
        final PackageManager packageManager;
        FragmentActivity fragmentActivityE = e();
        if (fragmentActivityE == null || (packageManager = fragmentActivityE.getPackageManager()) == null) {
            return;
        }
        Companion companion = INSTANCE;
        if (companion.isPackageInstalled(AuthUtils.AUTHY_PACKAGE, packageManager)) {
            TextView textView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableMfaKeyLaunchAuthy");
            textView.setText(FormatUtils.e(this, R.string.launch_app, new Object[]{FormatUtils.e(this, R.string.two_fa_app_name_authy, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null)}, (4 & 4) != 0 ? FormatUtils.a.j : null));
            TextView textView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.enableMfaKeyLaunchAuthy");
            textView2.setVisibility(0);
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey.showLaunchTexts.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Intrinsics3.checkNotNullExpressionValue(view, "it");
                    Context context = view.getContext();
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(AuthUtils.AUTHY_PACKAGE);
                    if (launchIntentForPackage != null) {
                        context.startActivity(launchIntentForPackage);
                    }
                }
            });
        }
        if (companion.isPackageInstalled(AuthUtils.GOOGLE_AUTHENTICATOR_PACKAGE, packageManager)) {
            TextView textView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.enableMfaKeyLaunchGoogleAuth");
            textView3.setText(FormatUtils.e(this, R.string.launch_app, new Object[]{FormatUtils.e(this, R.string.two_fa_app_name_google_authenticator, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null)}, (4 & 4) != 0 ? FormatUtils.a.j : null));
            TextView textView4 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.enableMfaKeyLaunchGoogleAuth");
            textView4.setVisibility(0);
            getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey.showLaunchTexts.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Intrinsics3.checkNotNullExpressionValue(view, "it");
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f2618b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableMfaKeyCode");
        textView.setText(getViewModel().getTotpSecret());
        getBinding().f2618b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEnableMFAKey widgetEnableMFAKey = WidgetEnableMFAKey.this;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                widgetEnableMFAKey.copyCodeToClipboard(context);
            }
        });
        showLaunchTexts();
    }
}
