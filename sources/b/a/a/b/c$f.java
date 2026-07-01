package b.a.a.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager2.widget.ViewPager2;
import b.a.i.w0;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c$f extends k implements Function1<View, w0> {
    public static final c$f j = new c$f();

    public c$f() {
        super(1, w0.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/MultiValuePropPremiumUpsellDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public w0 invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.premium_upsell_button_container;
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R$id.premium_upsell_button_container);
        if (linearLayout != null) {
            i = R$id.premium_upsell_close;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.premium_upsell_close);
            if (materialButton != null) {
                i = R$id.premium_upsell_divider;
                View viewFindViewById = view2.findViewById(R$id.premium_upsell_divider);
                if (viewFindViewById != null) {
                    i = R$id.premium_upsell_dots;
                    TabLayout tabLayout = (TabLayout) view2.findViewById(R$id.premium_upsell_dots);
                    if (tabLayout != null) {
                        i = R$id.premium_upsell_get_premium;
                        MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R$id.premium_upsell_get_premium);
                        if (materialButton2 != null) {
                            i = R$id.premium_upsell_learn_more;
                            MaterialButton materialButton3 = (MaterialButton) view2.findViewById(R$id.premium_upsell_learn_more);
                            if (materialButton3 != null) {
                                i = R$id.premium_upsell_viewpager;
                                ViewPager2 viewPager2 = (ViewPager2) view2.findViewById(R$id.premium_upsell_viewpager);
                                if (viewPager2 != null) {
                                    return new w0((RelativeLayout) view2, linearLayout, materialButton, viewFindViewById, tabLayout, materialButton2, materialButton3, viewPager2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
