package b.a.a.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.u5;
import com.discord.R$id;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c$d$b extends k implements Function1<View, u5> {
    public static final c$d$b j = new c$d$b();

    public c$d$b() {
        super(1, u5.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPremiumUpsellBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public u5 invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.premium_upsell_body;
        TextView textView = (TextView) view2.findViewById(R$id.premium_upsell_body);
        if (textView != null) {
            i = R$id.premium_upsell_header;
            TextView textView2 = (TextView) view2.findViewById(R$id.premium_upsell_header);
            if (textView2 != null) {
                i = R$id.premium_upsell_img;
                ImageView imageView = (ImageView) view2.findViewById(R$id.premium_upsell_img);
                if (imageView != null) {
                    return new u5((LinearLayout) view2, textView, textView2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
