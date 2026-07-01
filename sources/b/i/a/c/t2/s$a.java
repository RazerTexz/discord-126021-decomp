package b.i.a.c.t2;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: AudioTimestampPoller.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(19)
public final class s$a {
    public final AudioTrack a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioTimestamp f1128b = new AudioTimestamp();
    public long c;
    public long d;
    public long e;

    public s$a(AudioTrack audioTrack) {
        this.a = audioTrack;
    }
}
