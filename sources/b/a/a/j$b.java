package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CameraCapacityDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j$b extends d0.z.d.k implements Function1<View, b.a.i.e> {
    public static final j$b j = new j$b();

    public j$b() {
        super(1, b.a.i.e.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/CameraCapacityDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public b.a.i.e invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.camera_capacity_body;
        TextView textView = (TextView) view2.findViewById(R$id.camera_capacity_body);
        if (textView != null) {
            i = R$id.camera_capacity_confirm;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.camera_capacity_confirm);
            if (materialButton != null) {
                i = R$id.notice_header_container;
                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R$id.notice_header_container);
                if (linearLayout != null) {
                    return new b.a.i.e((LinearLayout) view2, textView, materialButton, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
