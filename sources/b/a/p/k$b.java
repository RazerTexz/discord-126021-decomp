package b.a.p;

import com.google.android.exoplayer2.PlaybackException;
import d0.z.d.m;

/* JADX INFO: compiled from: RxPlayerEventListener.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$b {
    public final PlaybackException a;

    public k$b(PlaybackException playbackException) {
        m.checkNotNullParameter(playbackException, "exoPlaybackException");
        this.a = playbackException;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof k$b) && m.areEqual(this.a, ((k$b) obj).a);
        }
        return true;
    }

    public int hashCode() {
        PlaybackException playbackException = this.a;
        if (playbackException != null) {
            return playbackException.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("PlayerError(exoPlaybackException=");
        sbU.append(this.a);
        sbU.append(")");
        return sbU.toString();
    }
}
