package b.a.a.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.e1;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PremiumAndGuildBoostActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g$b extends k implements Function1<View, e1> {
    public static final g$b j = new g$b();

    public g$b() {
        super(1, e1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumAndGuildBoostActivatedDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public e1 invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.premium_activated_confirm;
        MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.premium_activated_confirm);
        if (materialButton != null) {
            i = R$id.premium_and_guild_boost_activated_text;
            TextView textView = (TextView) view2.findViewById(R$id.premium_and_guild_boost_activated_text);
            if (textView != null) {
                return new e1((LinearLayout) view2, materialButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
