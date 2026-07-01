package b.a.a.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.p1;
import com.discord.R$id;
import com.discord.views.premium.ShinyButton;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SingleValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d$c extends k implements Function1<View, p1> {
    public static final d$c j = new d$c();

    public d$c() {
        super(1, p1.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/SingleValuePropPremiumUpsellDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public p1 invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.button_container;
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R$id.button_container);
        if (linearLayout != null) {
            i = R$id.close_button;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.close_button);
            if (materialButton != null) {
                i = R$id.content_background;
                View viewFindViewById = view2.findViewById(R$id.content_background);
                if (viewFindViewById != null) {
                    i = R$id.get_premium_button;
                    ShinyButton shinyButton = (ShinyButton) view2.findViewById(R$id.get_premium_button);
                    if (shinyButton != null) {
                        i = R$id.transparent_space;
                        View viewFindViewById2 = view2.findViewById(R$id.transparent_space);
                        if (viewFindViewById2 != null) {
                            i = R$id.upsell_body_text;
                            TextView textView = (TextView) view2.findViewById(R$id.upsell_body_text);
                            if (textView != null) {
                                i = R$id.upsell_header_text;
                                TextView textView2 = (TextView) view2.findViewById(R$id.upsell_header_text);
                                if (textView2 != null) {
                                    i = R$id.value_prop_image;
                                    ImageView imageView = (ImageView) view2.findViewById(R$id.value_prop_image);
                                    if (imageView != null) {
                                        return new p1((LinearLayout) view2, linearLayout, materialButton, viewFindViewById, shinyButton, viewFindViewById2, textView, textView2, imageView);
                                    }
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
