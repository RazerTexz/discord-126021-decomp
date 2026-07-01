package b.a.y.j0;

import android.view.View;
import com.discord.views.calls.VideoCallParticipantView;

/* JADX INFO: renamed from: b.a.y.j0.n, reason: use source file name */
/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoCallParticipantView6 implements View.OnClickListener {
    public final /* synthetic */ VideoCallParticipantView j;
    public final /* synthetic */ VideoCallParticipantView.ParticipantData k;

    public VideoCallParticipantView6(VideoCallParticipantView videoCallParticipantView, VideoCallParticipantView.ParticipantData participantData) {
        this.j = videoCallParticipantView;
        this.k = participantData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.k.voiceParticipant.getApplicationStream() != null) {
            this.j.onWatchStreamClicked.invoke(this.k.voiceParticipant.getApplicationStream().getEncodedStreamKey());
        }
    }
}
