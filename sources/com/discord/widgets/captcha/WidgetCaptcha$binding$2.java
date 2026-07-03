package com.discord.widgets.captcha;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetCaptchaBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCaptcha$binding$2 extends C12236k implements Function1<View, WidgetCaptchaBinding> {
    public static final WidgetCaptcha$binding$2 INSTANCE = new WidgetCaptcha$binding$2();

    public WidgetCaptcha$binding$2() {
        super(1, WidgetCaptchaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCaptchaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetCaptchaBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.captcha_help;
        TextView textView = (TextView) view.findViewById(C5419R.id.captcha_help);
        if (textView != null) {
            i = C5419R.id.captcha_verify;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.captcha_verify);
            if (materialButton != null) {
                i = C5419R.id.screen_title;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.screen_title);
                if (screenTitleView != null) {
                    return new WidgetCaptchaBinding((CoordinatorLayout) view, textView, materialButton, screenTitleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
