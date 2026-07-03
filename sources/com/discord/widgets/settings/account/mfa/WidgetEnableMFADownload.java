package com.discord.widgets.settings.account.mfa;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsEnableMfaDownloadBinding;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEnableMFADownload.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableMFADownload extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetEnableMFADownload.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsEnableMfaDownloadBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetEnableMFADownload() {
        super(C5419R.layout.widget_settings_enable_mfa_download);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableMFADownload$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetSettingsEnableMfaDownloadBinding getBinding() {
        return (WidgetSettingsEnableMfaDownloadBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f17944b;
        C12238m.checkNotNullExpressionValue(textView, "binding.mfaDownloadBody");
        C1107b.m221m(textView, C5419R.string.two_fa_download_app_body, new Object[]{AuthUtils.URL_AUTHY, AuthUtils.URL_GOOGLE_AUTHENTICATOR}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = getBinding().f17944b;
        C12238m.checkNotNullExpressionValue(textView2, "binding.mfaDownloadBody");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
