package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.o1;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SimpleConfirmationDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e$d extends d0.z.d.k implements Function1<View, o1> {
    public static final e$d j = new e$d();

    public e$d() {
        super(1, o1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/SimpleConfirmationDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public o1 invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.notice_header_container;
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R$id.notice_header_container);
        if (linearLayout != null) {
            i = R$id.simple_confirmation_dialog_description;
            TextView textView = (TextView) view2.findViewById(R$id.simple_confirmation_dialog_description);
            if (textView != null) {
                i = R$id.simple_confirmation_dialog_negative;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.simple_confirmation_dialog_negative);
                if (materialButton != null) {
                    i = R$id.simple_confirmation_dialog_positive;
                    MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R$id.simple_confirmation_dialog_positive);
                    if (materialButton2 != null) {
                        i = R$id.simple_confirmation_dialog_title;
                        TextView textView2 = (TextView) view2.findViewById(R$id.simple_confirmation_dialog_title);
                        if (textView2 != null) {
                            return new o1((LinearLayout) view2, linearLayout, textView, materialButton, materialButton2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
