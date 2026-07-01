package com.discord.widgets.guilds.join;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetGuildJoinCaptchaBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildJoinCaptchaBottomSheet$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildJoinCaptchaBottomSheetBinding> {
    public static final WidgetGuildJoinCaptchaBottomSheet$binding$2 INSTANCE = new WidgetGuildJoinCaptchaBottomSheet$binding$2();

    public WidgetGuildJoinCaptchaBottomSheet$binding$2() {
        super(1, WidgetGuildJoinCaptchaBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildJoinCaptchaBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildJoinCaptchaBottomSheetBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_join_captcha_body;
        TextView textView = (TextView) view.findViewById(R.id.guild_join_captcha_body);
        if (textView != null) {
            i = R.id.guild_join_captcha_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_join_captcha_button);
            if (materialButton != null) {
                i = R.id.guild_join_captcha_image;
                ImageView imageView = (ImageView) view.findViewById(R.id.guild_join_captcha_image);
                if (imageView != null) {
                    i = R.id.guild_join_captcha_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.guild_join_captcha_title);
                    if (textView2 != null) {
                        return new WidgetGuildJoinCaptchaBottomSheetBinding((NestedScrollView) view, textView, materialButton, imageView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
