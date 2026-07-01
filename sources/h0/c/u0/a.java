package h0.c.u0;

import android.media.AudioRecord;
import java.util.concurrent.Callable;
import org.webrtc.audio.WebRtcAudioRecord;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Callable {
    public final /* synthetic */ WebRtcAudioRecord j;
    public final /* synthetic */ AudioRecord k;

    public /* synthetic */ a(WebRtcAudioRecord webRtcAudioRecord, AudioRecord audioRecord) {
        this.j = webRtcAudioRecord;
        this.k = audioRecord;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.j.a(this.k);
        return "Scheduled task is done";
    }
}
