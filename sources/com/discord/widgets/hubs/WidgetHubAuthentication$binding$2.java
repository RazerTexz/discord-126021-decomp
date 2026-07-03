package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetHubAuthenticationBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CodeVerificationView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubAuthentication$binding$2 extends C12236k implements Function1<View, WidgetHubAuthenticationBinding> {
    public static final WidgetHubAuthentication$binding$2 INSTANCE = new WidgetHubAuthentication$binding$2();

    public WidgetHubAuthentication$binding$2() {
        super(1, WidgetHubAuthenticationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubAuthenticationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetHubAuthenticationBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.contact_sync_permissions_subtitle;
        TextView textView = (TextView) view.findViewById(C5419R.id.contact_sync_permissions_subtitle);
        if (textView != null) {
            i = C5419R.id.description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.description);
            if (linkifiedTextView != null) {
                i = C5419R.id.title;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.title);
                if (textView2 != null) {
                    i = C5419R.id.verification;
                    CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(C5419R.id.verification);
                    if (codeVerificationView != null) {
                        return new WidgetHubAuthenticationBinding((LinearLayout) view, textView, linkifiedTextView, textView2, codeVerificationView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
