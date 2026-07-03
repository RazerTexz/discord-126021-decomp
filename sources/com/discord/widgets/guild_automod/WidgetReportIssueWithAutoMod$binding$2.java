package com.discord.widgets.guild_automod;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetReportIssueWithAutomodBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetReportIssueWithAutoMod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetReportIssueWithAutoMod$binding$2 extends C12236k implements Function1<View, WidgetReportIssueWithAutomodBinding> {
    public static final WidgetReportIssueWithAutoMod$binding$2 INSTANCE = new WidgetReportIssueWithAutoMod$binding$2();

    public WidgetReportIssueWithAutoMod$binding$2() {
        super(1, WidgetReportIssueWithAutomodBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetReportIssueWithAutomodBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetReportIssueWithAutomodBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.back_button;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.back_button);
        if (imageView != null) {
            i = C5419R.id.header;
            TextView textView = (TextView) view.findViewById(C5419R.id.header);
            if (textView != null) {
                i = C5419R.id.option1;
                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.option1);
                if (checkedSetting != null) {
                    i = C5419R.id.option2;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.option2);
                    if (checkedSetting2 != null) {
                        i = C5419R.id.options_container;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.options_container);
                        if (linearLayout != null) {
                            i = C5419R.id.submit_button;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.submit_button);
                            if (materialButton != null) {
                                i = C5419R.id.subtitle;
                                TextView textView2 = (TextView) view.findViewById(C5419R.id.subtitle);
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
