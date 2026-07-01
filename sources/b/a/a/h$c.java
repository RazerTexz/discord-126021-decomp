package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.a;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAccessibilityDetectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h$c extends d0.z.d.k implements Function1<View, a> {
    public static final h$c j = new h$c();

    public h$c() {
        super(1, a.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/AllowAccessibilityDetectionDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public a invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.accessibility_detection_body_text;
        TextView textView = (TextView) view2.findViewById(R$id.accessibility_detection_body_text);
        if (textView != null) {
            i = R$id.accessibility_detection_disable;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.accessibility_detection_disable);
            if (materialButton != null) {
                i = R$id.accessibility_detection_enable;
                MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R$id.accessibility_detection_enable);
                if (materialButton2 != null) {
                    i = R$id.view_dialog_confirmation_header;
                    TextView textView2 = (TextView) view2.findViewById(R$id.view_dialog_confirmation_header);
                    if (textView2 != null) {
                        return new a((LinearLayout) view2, textView, materialButton, materialButton2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
