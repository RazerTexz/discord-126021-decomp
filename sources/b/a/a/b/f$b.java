package b.a.a.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.d1;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PremiumActivatedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f$b extends k implements Function1<View, d1> {
    public static final f$b j = new f$b();

    public f$b() {
        super(1, d1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumActivatedDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public d1 invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.premium_activated_confirm;
        MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.premium_activated_confirm);
        if (materialButton != null) {
            i = R$id.premium_activated_description;
            TextView textView = (TextView) view2.findViewById(R$id.premium_activated_description);
            if (textView != null) {
                i = R$id.premium_activated_header_background;
                ImageView imageView = (ImageView) view2.findViewById(R$id.premium_activated_header_background);
                if (imageView != null) {
                    i = R$id.premium_activated_logo;
                    ImageView imageView2 = (ImageView) view2.findViewById(R$id.premium_activated_logo);
                    if (imageView2 != null) {
                        i = R$id.premium_activated_title;
                        ImageView imageView3 = (ImageView) view2.findViewById(R$id.premium_activated_title);
                        if (imageView3 != null) {
                            i = R$id.premium_activated_wumpus;
                            ImageView imageView4 = (ImageView) view2.findViewById(R$id.premium_activated_wumpus);
                            if (imageView4 != null) {
                                return new d1((LinearLayout) view2, materialButton, textView, imageView, imageView2, imageView3, imageView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
