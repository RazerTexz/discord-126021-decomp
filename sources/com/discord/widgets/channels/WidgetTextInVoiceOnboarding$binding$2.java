package com.discord.widgets.channels;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetTextInVoiceOnboardingBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetTextInVoiceOnboarding$binding$2 extends C12236k implements Function1<View, WidgetTextInVoiceOnboardingBinding> {
    public static final WidgetTextInVoiceOnboarding$binding$2 INSTANCE = new WidgetTextInVoiceOnboarding$binding$2();

    public WidgetTextInVoiceOnboarding$binding$2() {
        super(1, WidgetTextInVoiceOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetTextInVoiceOnboardingBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.text_in_voice_onboarding_close;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.text_in_voice_onboarding_close);
        if (materialButton != null) {
            i = C5419R.id.text_in_voice_onboarding_cta;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.text_in_voice_onboarding_cta);
            if (materialButton2 != null) {
                i = C5419R.id.text_in_voice_onboarding_video;
                VideoView videoView = (VideoView) view.findViewById(C5419R.id.text_in_voice_onboarding_video);
                if (videoView != null) {
                    i = C5419R.id.text_in_voice_onboarding_video_container;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.text_in_voice_onboarding_video_container);
                    if (frameLayout != null) {
                        i = C5419R.id.text_in_voice_onboarding_video_overlay;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.text_in_voice_onboarding_video_overlay);
                        if (simpleDraweeView != null) {
                            i = C5419R.id.text_in_voice_onboarding_video_placeholder;
                            ImageView imageView = (ImageView) view.findViewById(C5419R.id.text_in_voice_onboarding_video_placeholder);
                            if (imageView != null) {
                                return new WidgetTextInVoiceOnboardingBinding((ConstraintLayout) view, materialButton, materialButton2, videoView, frameLayout, simpleDraweeView, imageView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
