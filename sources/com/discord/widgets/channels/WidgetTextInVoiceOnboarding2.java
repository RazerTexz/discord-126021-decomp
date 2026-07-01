package com.discord.widgets.channels;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.WidgetTextInVoiceOnboardingBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetTextInVoiceOnboarding2 extends FunctionReferenceImpl implements Function1<View, WidgetTextInVoiceOnboardingBinding> {
    public static final WidgetTextInVoiceOnboarding2 INSTANCE = new WidgetTextInVoiceOnboarding2();

    public WidgetTextInVoiceOnboarding2() {
        super(1, WidgetTextInVoiceOnboardingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetTextInVoiceOnboardingBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.text_in_voice_onboarding_close;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.text_in_voice_onboarding_close);
        if (materialButton != null) {
            i = R.id.text_in_voice_onboarding_cta;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.text_in_voice_onboarding_cta);
            if (materialButton2 != null) {
                i = R.id.text_in_voice_onboarding_video;
                VideoView videoView = (VideoView) view.findViewById(R.id.text_in_voice_onboarding_video);
                if (videoView != null) {
                    i = R.id.text_in_voice_onboarding_video_container;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.text_in_voice_onboarding_video_container);
                    if (frameLayout != null) {
                        i = R.id.text_in_voice_onboarding_video_overlay;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.text_in_voice_onboarding_video_overlay);
                        if (simpleDraweeView != null) {
                            i = R.id.text_in_voice_onboarding_video_placeholder;
                            ImageView imageView = (ImageView) view.findViewById(R.id.text_in_voice_onboarding_video_placeholder);
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
