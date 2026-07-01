package com.discord.widgets.chat.list;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.PublishMessageDialogBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.PublishActionDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class PublishActionDialog2 extends FunctionReferenceImpl implements Function1<View, PublishMessageDialogBinding> {
    public static final PublishActionDialog2 INSTANCE = new PublishActionDialog2();

    public PublishActionDialog2() {
        super(1, PublishMessageDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PublishMessageDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PublishMessageDialogBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.notice_body_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.notice_body_container);
        if (linearLayout != null) {
            i = R.id.notice_body_text;
            TextView textView = (TextView) view.findViewById(R.id.notice_body_text);
            if (textView != null) {
                i = R.id.notice_cancel;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.notice_cancel);
                if (materialButton != null) {
                    i = R.id.notice_header;
                    TextView textView2 = (TextView) view.findViewById(R.id.notice_header);
                    if (textView2 != null) {
                        i = R.id.notice_header_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.notice_header_container);
                        if (linearLayout2 != null) {
                            i = R.id.notice_ok;
                            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.notice_ok);
                            if (materialButton2 != null) {
                                return new PublishMessageDialogBinding((LinearLayout) view, linearLayout, textView, materialButton, textView2, linearLayout2, materialButton2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
