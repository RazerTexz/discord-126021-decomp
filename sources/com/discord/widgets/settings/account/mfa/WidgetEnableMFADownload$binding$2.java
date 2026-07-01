package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetSettingsEnableMfaDownloadBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEnableMFADownload.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFADownload$binding$2 extends k implements Function1<View, WidgetSettingsEnableMfaDownloadBinding> {
    public static final WidgetEnableMFADownload$binding$2 INSTANCE = new WidgetEnableMFADownload$binding$2();

    public WidgetEnableMFADownload$binding$2() {
        super(1, WidgetSettingsEnableMfaDownloadBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaDownloadBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsEnableMfaDownloadBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsEnableMfaDownloadBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        TextView textView = (TextView) view.findViewById(R$id.mfa_download_body);
        if (textView != null) {
            return new WidgetSettingsEnableMfaDownloadBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.mfa_download_body)));
    }
}
