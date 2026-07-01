package com.discord.widgets.settings.account.mfa;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaDownloadBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetEnableMFADownload.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFADownload extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEnableMFADownload.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaDownloadBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetEnableMFADownload() {
        super(R.layout.widget_settings_enable_mfa_download);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableMFADownload2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsEnableMfaDownloadBinding getBinding() {
        return (WidgetSettingsEnableMfaDownloadBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f2616b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.mfaDownloadBody");
        FormatUtils.m(textView, R.string.two_fa_download_app_body, new Object[]{AuthUtils.URL_AUTHY, AuthUtils.URL_GOOGLE_AUTHENTICATOR}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView2 = getBinding().f2616b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.mfaDownloadBody");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
