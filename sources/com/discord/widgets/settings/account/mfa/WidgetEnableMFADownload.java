package com.discord.widgets.settings.account.mfa;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaDownloadBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetEnableMFADownload.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFADownload extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEnableMFADownload.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaDownloadBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetEnableMFADownload() {
        super(R$layout.widget_settings_enable_mfa_download);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableMFADownload$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsEnableMfaDownloadBinding getBinding() {
        return (WidgetSettingsEnableMfaDownloadBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f2616b;
        m.checkNotNullExpressionValue(textView, "binding.mfaDownloadBody");
        b.n(textView, 2131896511, new Object[]{AuthUtils.URL_AUTHY, AuthUtils.URL_GOOGLE_AUTHENTICATOR}, null, 4);
        TextView textView2 = getBinding().f2616b;
        m.checkNotNullExpressionValue(textView2, "binding.mfaDownloadBody");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
