package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.o4;
import com.discord.R$id;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetBlockRussianPurchasesDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r$b extends d0.z.d.k implements Function1<View, o4> {
    public static final r$b j = new r$b();

    public r$b() {
        super(1, o4.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetBlockRussianPurchasesDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public o4 invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.notice_body_container;
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R$id.notice_body_container);
        if (linearLayout != null) {
            i = R$id.notice_body_text;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(R$id.notice_body_text);
            if (linkifiedTextView != null) {
                i = R$id.notice_header;
                TextView textView = (TextView) view2.findViewById(R$id.notice_header);
                if (textView != null) {
                    i = R$id.notice_header_container;
                    LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R$id.notice_header_container);
                    if (linearLayout2 != null) {
                        i = 2131364555;
                        MaterialButton materialButton = (MaterialButton) view2.findViewById(2131364555);
                        if (materialButton != null) {
                            return new o4((LinearLayout) view2, linearLayout, linkifiedTextView, textView, linearLayout2, materialButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
