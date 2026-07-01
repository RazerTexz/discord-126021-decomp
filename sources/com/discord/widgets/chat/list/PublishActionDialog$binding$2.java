package com.discord.widgets.chat.list;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.PublishMessageDialogBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class PublishActionDialog$binding$2 extends k implements Function1<View, PublishMessageDialogBinding> {
    public static final PublishActionDialog$binding$2 INSTANCE = new PublishActionDialog$binding$2();

    public PublishActionDialog$binding$2() {
        super(1, PublishMessageDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PublishMessageDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ PublishMessageDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final PublishMessageDialogBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.notice_body_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.notice_body_container);
        if (linearLayout != null) {
            i = R$id.notice_body_text;
            TextView textView = (TextView) view.findViewById(R$id.notice_body_text);
            if (textView != null) {
                i = 2131364550;
                MaterialButton materialButton = (MaterialButton) view.findViewById(2131364550);
                if (materialButton != null) {
                    i = R$id.notice_header;
                    TextView textView2 = (TextView) view.findViewById(R$id.notice_header);
                    if (textView2 != null) {
                        i = R$id.notice_header_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.notice_header_container);
                        if (linearLayout2 != null) {
                            i = 2131364555;
                            MaterialButton materialButton2 = (MaterialButton) view.findViewById(2131364555);
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
