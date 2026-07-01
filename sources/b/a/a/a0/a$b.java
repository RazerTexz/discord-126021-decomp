package b.a.a.a0;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.i.r;
import com.discord.R$id;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GiftPurchasedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a$b extends k implements Function1<View, r> {
    public static final a$b j = new a$b();

    public a$b() {
        super(1, r.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GiftPurchasedDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public r invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.gift_entitlement_code;
        TextView textView = (TextView) view2.findViewById(R$id.gift_entitlement_code);
        if (textView != null) {
            i = R$id.gift_entitlement_code_container;
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R$id.gift_entitlement_code_container);
            if (relativeLayout != null) {
                i = R$id.gift_entitlement_copy;
                MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.gift_entitlement_copy);
                if (materialButton != null) {
                    i = R$id.gift_link_subtext;
                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(R$id.gift_link_subtext);
                    if (linkifiedTextView != null) {
                        i = R$id.gift_purchased_dialog_confirm;
                        MaterialButton materialButton2 = (MaterialButton) view2.findViewById(R$id.gift_purchased_dialog_confirm);
                        if (materialButton2 != null) {
                            i = R$id.gift_purchased_dialog_subtext;
                            TextView textView2 = (TextView) view2.findViewById(R$id.gift_purchased_dialog_subtext);
                            if (textView2 != null) {
                                i = R$id.gift_purchased_icon;
                                ImageView imageView = (ImageView) view2.findViewById(R$id.gift_purchased_icon);
                                if (imageView != null) {
                                    return new r((LinearLayout) view2, textView, relativeLayout, materialButton, linkifiedTextView, materialButton2, textView2, imageView);
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
