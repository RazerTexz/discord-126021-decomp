package b.a.a.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.s;
import com.airbnb.lottie.LottieAnimationView;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c$b extends d0.z.d.k implements Function1<View, s> {
    public static final c$b j = new c$b();

    public c$b() {
        super(1, s.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostActivatedDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public s invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.guild_boost_activated_body_1;
        TextView textView = (TextView) view2.findViewById(R$id.guild_boost_activated_body_1);
        if (textView != null) {
            i = R$id.guild_boost_activated_body_2;
            TextView textView2 = (TextView) view2.findViewById(R$id.guild_boost_activated_body_2);
            if (textView2 != null) {
                i = R$id.guild_boost_activated_lottie;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) view2.findViewById(R$id.guild_boost_activated_lottie);
                if (lottieAnimationView != null) {
                    i = R$id.guild_boost_activated_ok;
                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.guild_boost_activated_ok);
                    if (materialButton != null) {
                        return new s((LinearLayout) view2, textView, textView2, lottieAnimationView, materialButton);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
