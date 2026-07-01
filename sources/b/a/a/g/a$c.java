package b.a.a.g;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.q5;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMaskedLinksDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a$c extends k implements Function1<View, q5> {
    public static final a$c j = new a$c();

    public a$c() {
        super(1, q5.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMaskedLinksDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public q5 invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.masked_links_body_text;
        TextView textView = (TextView) view2.findViewById(R$id.masked_links_body_text);
        if (textView != null) {
            i = R$id.masked_links_cancel;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.masked_links_cancel);
            if (materialButton != null) {
                i = R$id.masked_links_confirm;
                MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R$id.masked_links_confirm);
                if (materialButton2 != null) {
                    i = R$id.masked_links_trust_domain;
                    TextView textView2 = (TextView) view2.findViewById(R$id.masked_links_trust_domain);
                    if (textView2 != null) {
                        i = R$id.view_dialog_confirmation_header;
                        TextView textView3 = (TextView) view2.findViewById(R$id.view_dialog_confirmation_header);
                        if (textView3 != null) {
                            return new q5((LinearLayout) view2, textView, materialButton, materialButton2, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
