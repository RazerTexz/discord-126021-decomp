package com.discord.widgets.captcha;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetCaptchaBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCaptchaBottomSheet$binding$2 extends k implements Function1<View, WidgetCaptchaBottomSheetBinding> {
    public static final WidgetCaptchaBottomSheet$binding$2 INSTANCE = new WidgetCaptchaBottomSheet$binding$2();

    public WidgetCaptchaBottomSheet$binding$2() {
        super(1, WidgetCaptchaBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCaptchaBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCaptchaBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCaptchaBottomSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.captcha_body;
        TextView textView = (TextView) view.findViewById(R$id.captcha_body);
        if (textView != null) {
            i = R$id.captcha_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.captcha_button);
            if (materialButton != null) {
                i = R$id.captcha_title;
                TextView textView2 = (TextView) view.findViewById(R$id.captcha_title);
                if (textView2 != null) {
                    i = R$id.guild_join_captcha_image;
                    ImageView imageView = (ImageView) view.findViewById(R$id.guild_join_captcha_image);
                    if (imageView != null) {
                        return new WidgetCaptchaBottomSheetBinding((NestedScrollView) view, textView, materialButton, textView2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
