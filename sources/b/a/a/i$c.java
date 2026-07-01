package b.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ConnectedAccountActionsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i$c extends d0.z.d.k implements Function1<View, b.a.i.h> {
    public static final i$c j = new i$c();

    public i$c() {
        super(1, b.a.i.h.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ConnectedAccountActionsDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public b.a.i.h invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.connected_account_actions_dialog_copy_username;
        TextView textView = (TextView) view2.findViewById(R$id.connected_account_actions_dialog_copy_username);
        if (textView != null) {
            i = R$id.connected_account_actions_dialog_header;
            TextView textView2 = (TextView) view2.findViewById(R$id.connected_account_actions_dialog_header);
            if (textView2 != null) {
                i = R$id.connected_account_actions_dialog_open_in_browser;
                TextView textView3 = (TextView) view2.findViewById(R$id.connected_account_actions_dialog_open_in_browser);
                if (textView3 != null) {
                    return new b.a.i.h((LinearLayout) view2, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
