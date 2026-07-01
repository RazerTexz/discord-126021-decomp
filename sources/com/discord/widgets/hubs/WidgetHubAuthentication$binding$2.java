package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetHubAuthenticationBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CodeVerificationView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubAuthentication$binding$2 extends k implements Function1<View, WidgetHubAuthenticationBinding> {
    public static final WidgetHubAuthentication$binding$2 INSTANCE = new WidgetHubAuthentication$binding$2();

    public WidgetHubAuthentication$binding$2() {
        super(1, WidgetHubAuthenticationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubAuthenticationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubAuthenticationBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubAuthenticationBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.contact_sync_permissions_subtitle;
        TextView textView = (TextView) view.findViewById(R$id.contact_sync_permissions_subtitle);
        if (textView != null) {
            i = R$id.description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.description);
            if (linkifiedTextView != null) {
                i = 2131365869;
                TextView textView2 = (TextView) view.findViewById(2131365869);
                if (textView2 != null) {
                    i = R$id.verification;
                    CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R$id.verification);
                    if (codeVerificationView != null) {
                        return new WidgetHubAuthenticationBinding((LinearLayout) view, textView, linkifiedTextView, textView2, codeVerificationView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
