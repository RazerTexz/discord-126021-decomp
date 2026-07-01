package com.discord.widgets.notice;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.discord.databinding.WidgetNoticeDialogBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetNoticeDialog$binding$2 extends k implements Function1<View, WidgetNoticeDialogBinding> {
    public static final WidgetNoticeDialog$binding$2 INSTANCE = new WidgetNoticeDialog$binding$2();

    public WidgetNoticeDialog$binding$2() {
        super(1, WidgetNoticeDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNoticeDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetNoticeDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetNoticeDialogBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.notice_body_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.notice_body_container);
        if (linearLayout != null) {
            i = R$id.notice_body_text;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.notice_body_text);
            if (linkifiedTextView != null) {
                i = 2131364550;
                MaterialButton materialButton = (MaterialButton) view.findViewById(2131364550);
                if (materialButton != null) {
                    i = R$id.notice_header;
                    TextView textView = (TextView) view.findViewById(R$id.notice_header);
                    if (textView != null) {
                        i = R$id.notice_header_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.notice_header_container);
                        if (linearLayout2 != null) {
                            i = 2131364555;
                            MaterialButton materialButton2 = (MaterialButton) view.findViewById(2131364555);
                            if (materialButton2 != null) {
                                return new WidgetNoticeDialogBinding((LinearLayout) view, linearLayout, linkifiedTextView, materialButton, textView, linearLayout2, materialButton2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
