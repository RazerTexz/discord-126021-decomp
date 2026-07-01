package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.e6;
import com.discord.R$id;
import com.discord.views.LoadingButton;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t$b extends d0.z.d.k implements Function1<View, e6> {
    public static final t$b j = new t$b();

    public t$b() {
        super(1, e6.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUrgentMessageDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public e6 invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.view_dialog_confirmation_confirm;
        LoadingButton loadingButton = (LoadingButton) view2.findViewById(R$id.view_dialog_confirmation_confirm);
        if (loadingButton != null) {
            i = R$id.view_dialog_confirmation_header;
            TextView textView = (TextView) view2.findViewById(R$id.view_dialog_confirmation_header);
            if (textView != null) {
                i = R$id.view_dialog_confirmation_text;
                TextView textView2 = (TextView) view2.findViewById(R$id.view_dialog_confirmation_text);
                if (textView2 != null) {
                    return new e6((LinearLayout) view2, loadingButton, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
