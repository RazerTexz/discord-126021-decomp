package b.a.a.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.i.v;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UpgradeGuildBoostDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a$c extends k implements Function1<View, v> {
    public static final a$c j = new a$c();

    public a$c() {
        super(1, v.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostUpgradeDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public v invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.continue_button;
        TextView textView = (TextView) view2.findViewById(R$id.continue_button);
        if (textView != null) {
            i = R$id.premium_upsell_close;
            ImageView imageView = (ImageView) view2.findViewById(R$id.premium_upsell_close);
            if (imageView != null) {
                i = R$id.premium_upsell_description;
                TextView textView2 = (TextView) view2.findViewById(R$id.premium_upsell_description);
                if (textView2 != null) {
                    i = R$id.premium_upsell_server_perk;
                    TextView textView3 = (TextView) view2.findViewById(R$id.premium_upsell_server_perk);
                    if (textView3 != null) {
                        i = R$id.upgrade_button;
                        MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.upgrade_button);
                        if (materialButton != null) {
                            return new v((RelativeLayout) view2, textView, imageView, textView2, textView3, materialButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
