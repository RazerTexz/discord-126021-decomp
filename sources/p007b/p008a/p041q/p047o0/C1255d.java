package p007b.p008a.p041q.p047o0;

import co.discord.media_engine.Stats;
import co.discord.media_engine.VoiceQuality;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import java.util.Deque;
import java.util.LinkedList;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.q.o0.d */
/* JADX INFO: compiled from: RtcStatsCollector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1255d {

    /* JADX INFO: renamed from: a */
    public final Deque<Stats> f1807a;

    /* JADX INFO: renamed from: b */
    public Subscription f1808b;

    /* JADX INFO: renamed from: c */
    public final long f1809c;

    /* JADX INFO: renamed from: d */
    public final Logger f1810d;

    /* JADX INFO: renamed from: e */
    public final MediaEngineConnection f1811e;

    /* JADX INFO: renamed from: f */
    public final VoiceQuality f1812f;

    /* JADX INFO: renamed from: g */
    public final C1256e f1813g;

    /* JADX INFO: renamed from: h */
    public final KrispOveruseDetector f1814h;

    /* JADX INFO: renamed from: i */
    public final int f1815i;

    public C1255d(long j, Logger logger, MediaEngineConnection mediaEngineConnection, VoiceQuality voiceQuality, C1256e c1256e, KrispOveruseDetector krispOveruseDetector, int i, int i2) {
        i = (i2 & 64) != 0 ? 30 : i;
        C12238m.checkNotNullParameter(logger, "logger");
        C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
        C12238m.checkNotNullParameter(voiceQuality, "voiceQuality");
        C12238m.checkNotNullParameter(c1256e, "videoQuality");
        C12238m.checkNotNullParameter(krispOveruseDetector, "krispOveruseDetector");
        this.f1809c = j;
        this.f1810d = logger;
        this.f1811e = mediaEngineConnection;
        this.f1812f = voiceQuality;
        this.f1813g = c1256e;
        this.f1814h = krispOveruseDetector;
        this.f1815i = i;
        this.f1807a = new LinkedList();
    }

    /* JADX INFO: renamed from: a */
    public final void m351a() {
        Subscription subscription = this.f1808b;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
