package b.a.q.o0;

import co.discord.media_engine.Stats;
import co.discord.media_engine.VoiceQuality;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import java.util.Deque;
import java.util.LinkedList;
import rx.Subscription;

/* JADX INFO: renamed from: b.a.q.o0.d, reason: use source file name */
/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcStatsCollector4 {
    public final Deque<Stats> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Subscription f279b;
    public final long c;
    public final Logger d;
    public final MediaEngineConnection e;
    public final VoiceQuality f;
    public final VideoQuality g;
    public final KrispOveruseDetector h;
    public final int i;

    public RtcStatsCollector4(long j, Logger logger, MediaEngineConnection mediaEngineConnection, VoiceQuality voiceQuality, VideoQuality videoQuality, KrispOveruseDetector krispOveruseDetector, int i, int i2) {
        i = (i2 & 64) != 0 ? 30 : i;
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
        Intrinsics3.checkNotNullParameter(voiceQuality, "voiceQuality");
        Intrinsics3.checkNotNullParameter(videoQuality, "videoQuality");
        Intrinsics3.checkNotNullParameter(krispOveruseDetector, "krispOveruseDetector");
        this.c = j;
        this.d = logger;
        this.e = mediaEngineConnection;
        this.f = voiceQuality;
        this.g = videoQuality;
        this.h = krispOveruseDetector;
        this.i = i;
        this.a = new LinkedList();
    }

    public final void a() {
        Subscription subscription = this.f279b;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
