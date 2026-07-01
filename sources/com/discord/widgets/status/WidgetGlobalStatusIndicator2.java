package com.discord.widgets.status;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetGlobalStatusIndicatorBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGlobalStatusIndicator2 extends FunctionReferenceImpl implements Function1<View, WidgetGlobalStatusIndicatorBinding> {
    public static final WidgetGlobalStatusIndicator2 INSTANCE = new WidgetGlobalStatusIndicator2();

    public WidgetGlobalStatusIndicator2() {
        super(1, WidgetGlobalStatusIndicatorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGlobalStatusIndicatorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGlobalStatusIndicatorBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.alert_text;
        TextView textView = (TextView) view.findViewById(R.id.alert_text);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.indicator_accept;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.indicator_accept);
            if (materialButton != null) {
                i = R.id.indicator_actions;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.indicator_actions);
                if (linearLayout2 != null) {
                    i = R.id.indicator_content;
                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.indicator_content);
                    if (linearLayout3 != null) {
                        i = R.id.indicator_decline;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.indicator_decline);
                        if (materialButton2 != null) {
                            i = R.id.indicator_icon;
                            ImageView imageView = (ImageView) view.findViewById(R.id.indicator_icon);
                            if (imageView != null) {
                                i = R.id.indicator_text;
                                TextView textView2 = (TextView) view.findViewById(R.id.indicator_text);
                                if (textView2 != null) {
                                    return new WidgetGlobalStatusIndicatorBinding(linearLayout, textView, linearLayout, materialButton, linearLayout2, linearLayout3, materialButton2, imageView, textView2);
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
