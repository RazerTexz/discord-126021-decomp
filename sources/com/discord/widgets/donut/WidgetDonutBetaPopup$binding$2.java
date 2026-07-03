package com.discord.widgets.donut;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetDonutBetaPopupBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDonutBetaPopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDonutBetaPopup$binding$2 extends C12236k implements Function1<View, WidgetDonutBetaPopupBinding> {
    public static final WidgetDonutBetaPopup$binding$2 INSTANCE = new WidgetDonutBetaPopup$binding$2();

    public WidgetDonutBetaPopup$binding$2() {
        super(1, WidgetDonutBetaPopupBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDonutBetaPopupBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetDonutBetaPopupBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.donut_beta_actions;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.donut_beta_actions);
        if (linearLayout != null) {
            i = C5419R.id.donut_beta_body;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.donut_beta_body);
            if (linkifiedTextView != null) {
                i = C5419R.id.donut_beta_close;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.donut_beta_close);
                if (imageView != null) {
                    i = C5419R.id.donut_beta_close_button;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.donut_beta_close_button);
                    if (materialButton != null) {
                        i = C5419R.id.donut_beta_open_button;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.donut_beta_open_button);
                        if (materialButton2 != null) {
                            i = C5419R.id.donut_beta_title;
                            TextView textView = (TextView) view.findViewById(C5419R.id.donut_beta_title);
                            if (textView != null) {
                                return new WidgetDonutBetaPopupBinding((ConstraintLayout) view, linearLayout, linkifiedTextView, imageView, materialButton, materialButton2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
