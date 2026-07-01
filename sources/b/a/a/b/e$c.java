package b.a.a.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.i.w;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e$c extends k implements Function1<View, w> {
    public static final e$c j = new e$c();

    public e$c() {
        super(1, w.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostUpsellDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public w invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.guild_boost_upsell_close;
        ImageView imageView = (ImageView) view2.findViewById(R$id.guild_boost_upsell_close);
        if (imageView != null) {
            i = R$id.guild_boost_upsell_close_button;
            TextView textView = (TextView) view2.findViewById(R$id.guild_boost_upsell_close_button);
            if (textView != null) {
                i = R$id.guild_boost_upsell_subscribe_button;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.guild_boost_upsell_subscribe_button);
                if (materialButton != null) {
                    return new w((RelativeLayout) view2, imageView, textView, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
