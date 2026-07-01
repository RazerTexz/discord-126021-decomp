package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsEnableMfaDownloadBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFADownload$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEnableMFADownload.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFADownload2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsEnableMfaDownloadBinding> {
    public static final WidgetEnableMFADownload2 INSTANCE = new WidgetEnableMFADownload2();

    public WidgetEnableMFADownload2() {
        super(1, WidgetSettingsEnableMfaDownloadBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaDownloadBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsEnableMfaDownloadBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        TextView textView = (TextView) view.findViewById(R.id.mfa_download_body);
        if (textView != null) {
            return new WidgetSettingsEnableMfaDownloadBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.mfa_download_body)));
    }
}
