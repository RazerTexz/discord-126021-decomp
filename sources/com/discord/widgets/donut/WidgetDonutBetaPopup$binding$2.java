package com.discord.widgets.donut;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetDonutBetaPopupBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDonutBetaPopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDonutBetaPopup$binding$2 extends k implements Function1<View, WidgetDonutBetaPopupBinding> {
    public static final WidgetDonutBetaPopup$binding$2 INSTANCE = new WidgetDonutBetaPopup$binding$2();

    public WidgetDonutBetaPopup$binding$2() {
        super(1, WidgetDonutBetaPopupBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDonutBetaPopupBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetDonutBetaPopupBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetDonutBetaPopupBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.donut_beta_actions;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.donut_beta_actions);
        if (linearLayout != null) {
            i = R$id.donut_beta_body;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.donut_beta_body);
            if (linkifiedTextView != null) {
                i = R$id.donut_beta_close;
                ImageView imageView = (ImageView) view.findViewById(R$id.donut_beta_close);
                if (imageView != null) {
                    i = R$id.donut_beta_close_button;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.donut_beta_close_button);
                    if (materialButton != null) {
                        i = R$id.donut_beta_open_button;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.donut_beta_open_button);
                        if (materialButton2 != null) {
                            i = R$id.donut_beta_title;
                            TextView textView = (TextView) view.findViewById(R$id.donut_beta_title);
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
