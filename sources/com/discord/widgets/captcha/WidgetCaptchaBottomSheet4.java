package com.discord.widgets.captcha;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetCaptchaBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCaptchaBottomSheet4 extends FunctionReferenceImpl implements Function1<View, WidgetCaptchaBottomSheetBinding> {
    public static final WidgetCaptchaBottomSheet4 INSTANCE = new WidgetCaptchaBottomSheet4();

    public WidgetCaptchaBottomSheet4() {
        super(1, WidgetCaptchaBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCaptchaBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetCaptchaBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.captcha_body;
        TextView textView = (TextView) view.findViewById(R.id.captcha_body);
        if (textView != null) {
            i = R.id.captcha_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.captcha_button);
            if (materialButton != null) {
                i = R.id.captcha_title;
                TextView textView2 = (TextView) view.findViewById(R.id.captcha_title);
                if (textView2 != null) {
                    i = R.id.guild_join_captcha_image;
                    ImageView imageView = (ImageView) view.findViewById(R.id.guild_join_captcha_image);
                    if (imageView != null) {
                        return new WidgetCaptchaBottomSheetBinding((NestedScrollView) view, textView, materialButton, textView2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
