package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsEnableMfaDownloadBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEnableMFADownload.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFADownload$binding$2 extends C12236k implements Function1<View, WidgetSettingsEnableMfaDownloadBinding> {
    public static final WidgetEnableMFADownload$binding$2 INSTANCE = new WidgetEnableMFADownload$binding$2();

    public WidgetEnableMFADownload$binding$2() {
        super(1, WidgetSettingsEnableMfaDownloadBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaDownloadBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetSettingsEnableMfaDownloadBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        TextView textView = (TextView) view.findViewById(C5419R.id.mfa_download_body);
        if (textView != null) {
            return new WidgetSettingsEnableMfaDownloadBinding((LinearLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.mfa_download_body)));
    }
}
