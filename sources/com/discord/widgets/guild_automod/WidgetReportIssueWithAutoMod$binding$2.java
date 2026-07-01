package com.discord.widgets.guild_automod;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetReportIssueWithAutomodBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetReportIssueWithAutoMod$binding$2 extends k implements Function1<View, WidgetReportIssueWithAutomodBinding> {
    public static final WidgetReportIssueWithAutoMod$binding$2 INSTANCE = new WidgetReportIssueWithAutoMod$binding$2();

    public WidgetReportIssueWithAutoMod$binding$2() {
        super(1, WidgetReportIssueWithAutomodBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetReportIssueWithAutomodBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetReportIssueWithAutomodBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetReportIssueWithAutomodBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.back_button;
        ImageView imageView = (ImageView) view.findViewById(R$id.back_button);
        if (imageView != null) {
            i = R$id.header;
            TextView textView = (TextView) view.findViewById(R$id.header);
            if (textView != null) {
                i = R$id.option1;
                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.option1);
                if (checkedSetting != null) {
                    i = R$id.option2;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.option2);
                    if (checkedSetting2 != null) {
                        i = R$id.options_container;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.options_container);
                        if (linearLayout != null) {
                            i = R$id.submit_button;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.submit_button);
                            if (materialButton != null) {
                                i = R$id.subtitle;
                                TextView textView2 = (TextView) view.findViewById(R$id.subtitle);
                                if (textView2 != null) {
                                    return new WidgetReportIssueWithAutomodBinding((ConstraintLayout) view, imageView, textView, checkedSetting, checkedSetting2, linearLayout, materialButton, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
