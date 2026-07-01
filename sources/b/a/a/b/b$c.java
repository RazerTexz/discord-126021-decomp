package b.a.a.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.f1;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UpgradePremiumYearlyDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b$c extends k implements Function1<View, f1> {
    public static final b$c j = new b$c();

    public b$c() {
        super(1, f1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/PremiumUpgradeYearlyDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public f1 invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.premium_upsell_header;
        ImageView imageView = (ImageView) view2.findViewById(R$id.premium_upsell_header);
        if (imageView != null) {
            i = R$id.premium_upsell_yearly_description;
            TextView textView = (TextView) view2.findViewById(R$id.premium_upsell_yearly_description);
            if (textView != null) {
                i = R$id.premium_upsell_yearly_title;
                TextView textView2 = (TextView) view2.findViewById(R$id.premium_upsell_yearly_title);
                if (textView2 != null) {
                    i = R$id.purchase_premium_monthly;
                    TextView textView3 = (TextView) view2.findViewById(R$id.purchase_premium_monthly);
                    if (textView3 != null) {
                        i = R$id.purchase_premium_yearly;
                        MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.purchase_premium_yearly);
                        if (materialButton != null) {
                            return new f1((LinearLayout) view2, imageView, textView, textView2, textView3, materialButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
