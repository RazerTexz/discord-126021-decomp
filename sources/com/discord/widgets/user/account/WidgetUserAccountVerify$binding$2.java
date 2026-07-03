package com.discord.widgets.user.account;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserAccountVerifyBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserAccountVerify$binding$2 extends C12236k implements Function1<View, WidgetUserAccountVerifyBinding> {
    public static final WidgetUserAccountVerify$binding$2 INSTANCE = new WidgetUserAccountVerify$binding$2();

    public WidgetUserAccountVerify$binding$2() {
        super(1, WidgetUserAccountVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserAccountVerifyBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.verify_account_by_email;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.verify_account_by_email);
        if (relativeLayout != null) {
            i = C5419R.id.verify_account_by_phone;
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(C5419R.id.verify_account_by_phone);
            if (relativeLayout2 != null) {
                i = C5419R.id.verify_account_support;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.verify_account_support);
                if (linkifiedTextView != null) {
                    i = C5419R.id.verify_account_text_body;
                    TextView textView = (TextView) view.findViewById(C5419R.id.verify_account_text_body);
                    if (textView != null) {
                        return new WidgetUserAccountVerifyBinding((RelativeLayout) view, relativeLayout, relativeLayout2, linkifiedTextView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
