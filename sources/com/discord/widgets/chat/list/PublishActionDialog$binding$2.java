package com.discord.widgets.chat.list;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.PublishMessageDialogBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PublishActionDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class PublishActionDialog$binding$2 extends C12236k implements Function1<View, PublishMessageDialogBinding> {
    public static final PublishActionDialog$binding$2 INSTANCE = new PublishActionDialog$binding$2();

    public PublishActionDialog$binding$2() {
        super(1, PublishMessageDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PublishMessageDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final PublishMessageDialogBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.notice_body_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.notice_body_container);
        if (linearLayout != null) {
            i = C5419R.id.notice_body_text;
            TextView textView = (TextView) view.findViewById(C5419R.id.notice_body_text);
            if (textView != null) {
                i = C5419R.id.notice_cancel;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.notice_cancel);
                if (materialButton != null) {
                    i = C5419R.id.notice_header;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.notice_header);
                    if (textView2 != null) {
                        i = C5419R.id.notice_header_container;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.notice_header_container);
                        if (linearLayout2 != null) {
                            i = C5419R.id.notice_ok;
                            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.notice_ok);
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
