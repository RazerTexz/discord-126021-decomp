package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetMemberVerificationPendingDialogBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class MemberVerificationPendingDialog$binding$2 extends C12236k implements Function1<View, WidgetMemberVerificationPendingDialogBinding> {
    public static final MemberVerificationPendingDialog$binding$2 INSTANCE = new MemberVerificationPendingDialog$binding$2();

    public MemberVerificationPendingDialog$binding$2() {
        super(1, WidgetMemberVerificationPendingDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMemberVerificationPendingDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetMemberVerificationPendingDialogBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.member_verification_pending_img;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.member_verification_pending_img);
        if (imageView != null) {
            i = C5419R.id.member_verification_primary_btn;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.member_verification_primary_btn);
            if (materialButton != null) {
                i = C5419R.id.member_verification_secondary_btn;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.member_verification_secondary_btn);
                if (materialButton2 != null) {
                    i = C5419R.id.member_verification_tertiary_btn;
                    TextView textView = (TextView) view.findViewById(C5419R.id.member_verification_tertiary_btn);
                    if (textView != null) {
                        i = C5419R.id.pending_dialog_desc;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.pending_dialog_desc);
                        if (textView2 != null) {
                            i = C5419R.id.pending_dialog_title;
                            TextView textView3 = (TextView) view.findViewById(C5419R.id.pending_dialog_title);
                            if (textView3 != null) {
                                return new WidgetMemberVerificationPendingDialogBinding((RelativeLayout) view, imageView, materialButton, materialButton2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
