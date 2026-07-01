package b.a.y.j0;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.views.calls.VideoCallParticipantView$ParticipantData;

/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements View$OnClickListener {
    public final /* synthetic */ VideoCallParticipantView j;
    public final /* synthetic */ VideoCallParticipantView$ParticipantData k;

    public n(VideoCallParticipantView videoCallParticipantView, VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData) {
        this.j = videoCallParticipantView;
        this.k = videoCallParticipantView$ParticipantData;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.k.voiceParticipant.getApplicationStream() != null) {
            this.j.onWatchStreamClicked.invoke(this.k.voiceParticipant.getApplicationStream().getEncodedStreamKey());
        }
    }
}
