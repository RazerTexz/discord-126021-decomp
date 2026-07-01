package com.discord.views.calls;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoCallParticipantView$a implements View$OnClickListener {
    public final /* synthetic */ VideoCallParticipantView j;
    public final /* synthetic */ VideoCallParticipantView$ParticipantData$a k;

    public VideoCallParticipantView$a(VideoCallParticipantView videoCallParticipantView, VideoCallParticipantView$ParticipantData$a videoCallParticipantView$ParticipantData$a) {
        this.j = videoCallParticipantView;
        this.k = videoCallParticipantView$ParticipantData$a;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function2<? super VideoCallParticipantView$StreamResolution, ? super VideoCallParticipantView$StreamFps, Unit> function2 = this.j.onStreamQualityIndicatorClicked;
        VideoCallParticipantView$ParticipantData$a videoCallParticipantView$ParticipantData$a = this.k;
        function2.invoke(videoCallParticipantView$ParticipantData$a.f2841b, videoCallParticipantView$ParticipantData$a.c);
    }
}
