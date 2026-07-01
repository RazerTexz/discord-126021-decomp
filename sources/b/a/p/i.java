package b.a.p;

import android.content.Context;
import b.i.a.c.e1$b;
import b.i.a.c.e3.o;
import b.i.a.c.e3.q$a;
import b.i.a.c.k2;
import b.i.a.c.z0;
import com.discord.app.AppLog;
import com.discord.player.AppMediaPlayer;
import d0.z.d.m;
import rx.Scheduler;

/* JADX INFO: compiled from: AppMediaPlayerFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static final AppMediaPlayer a(Context context) {
        m.checkNotNullParameter(context, "context");
        AppLog appLog = AppLog.g;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(appLog, "logger");
        j jVar = new j(new q$a(context), 104857600);
        k kVar = new k();
        b.c.a.a0.d.D(true);
        z0.j(2500, 0, "bufferForPlaybackMs", "0");
        z0.j(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        z0.j(10000, 2500, "minBufferMs", "bufferForPlaybackMs");
        z0.j(10000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        z0.j(30000, 10000, "maxBufferMs", "minBufferMs");
        b.c.a.a0.d.D(true);
        z0 z0Var = new z0(new o(true, 65536), 10000, 30000, 2500, 5000, -1, false, 0, false);
        m.checkNotNullExpressionValue(z0Var, "DefaultLoadControl.Build…     )\n          .build()");
        e1$b e1_b = new e1$b(context);
        b.c.a.a0.d.D(!e1_b.f924s);
        e1_b.f = new b.i.a.c.d(z0Var);
        b.c.a.a0.d.D(!e1_b.f924s);
        e1_b.f924s = true;
        k2 k2Var = new k2(e1_b);
        m.checkNotNullExpressionValue(k2Var, "ExoPlayer\n          .Bui…ntrol)\n          .build()");
        k2Var.x(kVar);
        Scheduler schedulerA = j0.p.a.a();
        m.checkNotNullExpressionValue(schedulerA, "Schedulers.computation()");
        return new AppMediaPlayer(k2Var, kVar, jVar, schedulerA, appLog);
    }
}
