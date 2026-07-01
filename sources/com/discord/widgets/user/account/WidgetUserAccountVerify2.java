package com.discord.widgets.user.account;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetUserAccountVerifyBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.account.WidgetUserAccountVerify$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserAccountVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserAccountVerify2 extends FunctionReferenceImpl implements Function1<View, WidgetUserAccountVerifyBinding> {
    public static final WidgetUserAccountVerify2 INSTANCE = new WidgetUserAccountVerify2();

    public WidgetUserAccountVerify2() {
        super(1, WidgetUserAccountVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserAccountVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserAccountVerifyBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.verify_account_by_email;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.verify_account_by_email);
        if (relativeLayout != null) {
            i = R.id.verify_account_by_phone;
            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.verify_account_by_phone);
            if (relativeLayout2 != null) {
                i = R.id.verify_account_support;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.verify_account_support);
                if (linkifiedTextView != null) {
                    i = R.id.verify_account_text_body;
                    TextView textView = (TextView) view.findViewById(R.id.verify_account_text_body);
                    if (textView != null) {
                        return new WidgetUserAccountVerifyBinding((RelativeLayout) view, relativeLayout, relativeLayout2, linkifiedTextView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
