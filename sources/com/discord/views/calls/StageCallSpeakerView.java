package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.discord.C5419R;
import com.discord.utilities.analytics.Traits;
import com.discord.views.VoiceUserView;
import p007b.p008a.p025i.C1076w3;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: StageCallSpeakerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCallSpeakerView extends CardView {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C1076w3 binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Subscription subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallSpeakerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.view_stage_channel_speaker, this);
        int i = C5419R.id.stage_channel_speaker;
        VoiceUserView voiceUserView = (VoiceUserView) findViewById(C5419R.id.stage_channel_speaker);
        if (voiceUserView != null) {
            i = C5419R.id.stage_channel_speaker_blocked;
            ImageView imageView = (ImageView) findViewById(C5419R.id.stage_channel_speaker_blocked);
            if (imageView != null) {
                i = C5419R.id.stage_channel_speaker_deafen_indicator;
                ImageView imageView2 = (ImageView) findViewById(C5419R.id.stage_channel_speaker_deafen_indicator);
                if (imageView2 != null) {
                    i = C5419R.id.stage_channel_speaker_mod_indicator;
                    ImageView imageView3 = (ImageView) findViewById(C5419R.id.stage_channel_speaker_mod_indicator);
                    if (imageView3 != null) {
                        i = C5419R.id.stage_channel_speaker_mute_indicator;
                        ImageView imageView4 = (ImageView) findViewById(C5419R.id.stage_channel_speaker_mute_indicator);
                        if (imageView4 != null) {
                            i = C5419R.id.stage_channel_speaker_name;
                            TextView textView = (TextView) findViewById(C5419R.id.stage_channel_speaker_name);
                            if (textView != null) {
                                i = C5419R.id.stage_channel_speaker_pulse;
                                SpeakerPulseView speakerPulseView = (SpeakerPulseView) findViewById(C5419R.id.stage_channel_speaker_pulse);
                                if (speakerPulseView != null) {
                                    C1076w3 c1076w3 = new C1076w3(this, voiceUserView, imageView, imageView2, imageView3, imageView4, textView, speakerPulseView);
                                    C12238m.checkNotNullExpressionValue(c1076w3, "ViewStageChannelSpeakerB…ater.from(context), this)");
                                    this.binding = c1076w3;
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
