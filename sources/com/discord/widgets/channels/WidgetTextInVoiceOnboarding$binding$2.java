package com.discord.widgets.channels;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetTextInVoiceOnboardingBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetTextInVoiceOnboarding$binding$2 extends k implements Function1<View, WidgetTextInVoiceOnboardingBinding> {
    public static final WidgetTextInVoiceOnboarding$binding$2 INSTANCE = new WidgetTextInVoiceOnboarding$binding$2();

    public WidgetTextInVoiceOnboarding$binding$2() {
        super(1, WidgetTextInVoiceOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetTextInVoiceOnboardingBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetTextInVoiceOnboardingBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.text_in_voice_onboarding_close;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.text_in_voice_onboarding_close);
        if (materialButton != null) {
            i = R$id.text_in_voice_onboarding_cta;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.text_in_voice_onboarding_cta);
            if (materialButton2 != null) {
                i = R$id.text_in_voice_onboarding_video;
                VideoView videoView = (VideoView) view.findViewById(R$id.text_in_voice_onboarding_video);
                if (videoView != null) {
                    i = R$id.text_in_voice_onboarding_video_container;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.text_in_voice_onboarding_video_container);
                    if (frameLayout != null) {
                        i = R$id.text_in_voice_onboarding_video_overlay;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.text_in_voice_onboarding_video_overlay);
                        if (simpleDraweeView != null) {
                            i = R$id.text_in_voice_onboarding_video_placeholder;
                            ImageView imageView = (ImageView) view.findViewById(R$id.text_in_voice_onboarding_video_placeholder);
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
