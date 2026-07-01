package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.a.i.ViewStageChannelSpeakerBinding;
import com.discord.R;
import com.discord.utilities.analytics.Traits;
import com.discord.views.VoiceUserView;
import d0.z.d.Intrinsics3;
import rx.Subscription;

/* JADX INFO: compiled from: StageCallSpeakerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCallSpeakerView extends CardView {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewStageChannelSpeakerBinding binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Subscription subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallSpeakerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_stage_channel_speaker, this);
        int i = R.id.stage_channel_speaker;
        VoiceUserView voiceUserView = (VoiceUserView) findViewById(R.id.stage_channel_speaker);
        if (voiceUserView != null) {
            i = R.id.stage_channel_speaker_blocked;
            ImageView imageView = (ImageView) findViewById(R.id.stage_channel_speaker_blocked);
            if (imageView != null) {
                i = R.id.stage_channel_speaker_deafen_indicator;
                ImageView imageView2 = (ImageView) findViewById(R.id.stage_channel_speaker_deafen_indicator);
                if (imageView2 != null) {
                    i = R.id.stage_channel_speaker_mod_indicator;
                    ImageView imageView3 = (ImageView) findViewById(R.id.stage_channel_speaker_mod_indicator);
                    if (imageView3 != null) {
                        i = R.id.stage_channel_speaker_mute_indicator;
                        ImageView imageView4 = (ImageView) findViewById(R.id.stage_channel_speaker_mute_indicator);
                        if (imageView4 != null) {
                            i = R.id.stage_channel_speaker_name;
                            TextView textView = (TextView) findViewById(R.id.stage_channel_speaker_name);
                            if (textView != null) {
                                i = R.id.stage_channel_speaker_pulse;
                                SpeakerPulseView speakerPulseView = (SpeakerPulseView) findViewById(R.id.stage_channel_speaker_pulse);
                                if (speakerPulseView != null) {
                                    ViewStageChannelSpeakerBinding viewStageChannelSpeakerBinding = new ViewStageChannelSpeakerBinding(this, voiceUserView, imageView, imageView2, imageView3, imageView4, textView, speakerPulseView);
                                    Intrinsics3.checkNotNullExpressionValue(viewStageChannelSpeakerBinding, "ViewStageChannelSpeakerB…ater.from(context), this)");
                                    this.binding = viewStageChannelSpeakerBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
