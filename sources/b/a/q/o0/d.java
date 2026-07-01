package b.a.q.o0;

import co.discord.media_engine.Stats;
import co.discord.media_engine.VoiceQuality;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import java.util.Deque;
import java.util.LinkedList;
import rx.Subscription;

/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final Deque<Stats> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Subscription f279b;
    public final long c;
    public final Logger d;
    public final MediaEngineConnection e;
    public final VoiceQuality f;
    public final e g;
    public final KrispOveruseDetector h;
    public final int i;

    public d(long j, Logger logger, MediaEngineConnection mediaEngineConnection, VoiceQuality voiceQuality, e eVar, KrispOveruseDetector krispOveruseDetector, int i, int i2) {
        i = (i2 & 64) != 0 ? 30 : i;
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(mediaEngineConnection, "connection");
        m.checkNotNullParameter(voiceQuality, "voiceQuality");
        m.checkNotNullParameter(eVar, "videoQuality");
        m.checkNotNullParameter(krispOveruseDetector, "krispOveruseDetector");
        this.c = j;
        this.d = logger;
        this.e = mediaEngineConnection;
        this.f = voiceQuality;
        this.g = eVar;
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
