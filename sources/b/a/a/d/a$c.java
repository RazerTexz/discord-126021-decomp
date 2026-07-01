package b.a.a.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.u1;
import com.discord.R$id;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserActionsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a$c extends k implements Function1<View, u1> {
    public static final a$c j = new a$c();

    public a$c() {
        super(1, u1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/UserActionsDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public u1 invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.user_actions_dialog_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R$id.user_actions_dialog_avatar);
        if (simpleDraweeView != null) {
            i = R$id.user_actions_dialog_block_item;
            TextView textView = (TextView) view2.findViewById(R$id.user_actions_dialog_block_item);
            if (textView != null) {
                i = R$id.user_actions_dialog_remove_friend_item;
                TextView textView2 = (TextView) view2.findViewById(R$id.user_actions_dialog_remove_friend_item);
                if (textView2 != null) {
                    i = R$id.user_actions_dialog_unblock_item;
                    TextView textView3 = (TextView) view2.findViewById(R$id.user_actions_dialog_unblock_item);
                    if (textView3 != null) {
                        i = R$id.user_actions_dialog_user_name;
                        TextView textView4 = (TextView) view2.findViewById(R$id.user_actions_dialog_user_name);
                        if (textView4 != null) {
                            return new u1((LinearLayout) view2, simpleDraweeView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
