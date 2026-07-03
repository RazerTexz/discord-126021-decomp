package p007b.p008a.p040p;

import android.content.Context;
import com.discord.app.AppLog;
import com.discord.player.AppMediaPlayer;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2816k2;
import p007b.p225i.p226a.p242c.C3153z0;
import p007b.p225i.p226a.p242c.InterfaceC2677e1;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p257e3.C2715q;
import p007b.p225i.p355b.p356a.InterfaceC4492l;
import p507d0.p592z.p594d.C12238m;
import p637j0.p653p.C12781a;
import p658rx.Scheduler;

/* JADX INFO: renamed from: b.a.p.i */
/* JADX INFO: compiled from: AppMediaPlayerFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1184i {
    /* JADX INFO: renamed from: a */
    public static final AppMediaPlayer m233a(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        AppLog appLog = AppLog.f14950g;
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(appLog, "logger");
        C1185j c1185j = new C1185j(new C2715q.a(context), 104857600);
        C1186k c1186k = new C1186k();
        C1460d.m426D(true);
        C3153z0.m3871j(2500, 0, "bufferForPlaybackMs", "0");
        C3153z0.m3871j(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        C3153z0.m3871j(10000, 2500, "minBufferMs", "bufferForPlaybackMs");
        C3153z0.m3871j(10000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        C3153z0.m3871j(30000, 10000, "maxBufferMs", "minBufferMs");
        C1460d.m426D(true);
        final C3153z0 c3153z0 = new C3153z0(new C2713o(true, 65536), 10000, 30000, 2500, 5000, -1, false, 0, false);
        C12238m.checkNotNullExpressionValue(c3153z0, "DefaultLoadControl.Build…     )\n          .build()");
        InterfaceC2677e1.b bVar = new InterfaceC2677e1.b(context);
        C1460d.m426D(!bVar.f6430s);
        bVar.f6417f = new InterfaceC4492l() { // from class: b.i.a.c.d
            @Override // p007b.p225i.p355b.p356a.InterfaceC4492l
            public final Object get() {
                return c3153z0;
            }
        };
        C1460d.m426D(!bVar.f6430s);
        bVar.f6430s = true;
        C2816k2 c2816k2 = new C2816k2(bVar);
        C12238m.checkNotNullExpressionValue(c2816k2, "ExoPlayer\n          .Bui…ntrol)\n          .build()");
        c2816k2.mo2929x(c1186k);
        Scheduler schedulerM10873a = C12781a.m10873a();
        C12238m.checkNotNullExpressionValue(schedulerM10873a, "Schedulers.computation()");
        return new AppMediaPlayer(c2816k2, c1186k, c1185j, schedulerM10873a, appLog);
    }
}
