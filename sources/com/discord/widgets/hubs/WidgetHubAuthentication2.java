package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetHubAuthenticationBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CodeVerificationView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubAuthentication2 extends FunctionReferenceImpl implements Function1<View, WidgetHubAuthenticationBinding> {
    public static final WidgetHubAuthentication2 INSTANCE = new WidgetHubAuthentication2();

    public WidgetHubAuthentication2() {
        super(1, WidgetHubAuthenticationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubAuthenticationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetHubAuthenticationBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.contact_sync_permissions_subtitle;
        TextView textView = (TextView) view.findViewById(R.id.contact_sync_permissions_subtitle);
        if (textView != null) {
            i = R.id.description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.description);
            if (linkifiedTextView != null) {
                i = R.id.title;
                TextView textView2 = (TextView) view.findViewById(R.id.title);
                if (textView2 != null) {
                    i = R.id.verification;
                    CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(R.id.verification);
                    if (codeVerificationView != null) {
                        return new WidgetHubAuthenticationBinding((LinearLayout) view, textView, linkifiedTextView, textView2, codeVerificationView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
