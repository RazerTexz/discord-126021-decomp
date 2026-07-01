package b.a.p;

import android.content.Context;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.DefaultLoadControl;
import b.i.a.c.ExoPlayer2;
import b.i.a.c.SimpleExoPlayer;
import b.i.a.c.e3.DefaultAllocator;
import b.i.a.c.e3.DefaultDataSource;
import b.i.b.a.Supplier2;
import com.discord.app.AppLog;
import com.discord.player.AppMediaPlayer;
import d0.z.d.Intrinsics3;
import j0.p.Schedulers2;
import rx.Scheduler;

/* JADX INFO: renamed from: b.a.p.i, reason: use source file name */
/* JADX INFO: compiled from: AppMediaPlayerFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayerFactory {
    public static final AppMediaPlayer a(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        AppLog appLog = AppLog.g;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(appLog, "logger");
        CacheDataSourceFactory cacheDataSourceFactory = new CacheDataSourceFactory(new DefaultDataSource.a(context), 104857600);
        RxPlayerEventListener rxPlayerEventListener = new RxPlayerEventListener();
        AnimatableValueParser.D(true);
        DefaultLoadControl.j(2500, 0, "bufferForPlaybackMs", "0");
        DefaultLoadControl.j(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        DefaultLoadControl.j(10000, 2500, "minBufferMs", "bufferForPlaybackMs");
        DefaultLoadControl.j(10000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        DefaultLoadControl.j(30000, 10000, "maxBufferMs", "minBufferMs");
        AnimatableValueParser.D(true);
        final DefaultLoadControl defaultLoadControl = new DefaultLoadControl(new DefaultAllocator(true, 65536), 10000, 30000, 2500, 5000, -1, false, 0, false);
        Intrinsics3.checkNotNullExpressionValue(defaultLoadControl, "DefaultLoadControl.Build…     )\n          .build()");
        ExoPlayer2.b bVar = new ExoPlayer2.b(context);
        AnimatableValueParser.D(!bVar.f924s);
        bVar.f = new Supplier2() { // from class: b.i.a.c.d
            @Override // b.i.b.a.Supplier2
            public final Object get() {
                return defaultLoadControl;
            }
        };
        AnimatableValueParser.D(!bVar.f924s);
        bVar.f924s = true;
        SimpleExoPlayer simpleExoPlayer = new SimpleExoPlayer(bVar);
        Intrinsics3.checkNotNullExpressionValue(simpleExoPlayer, "ExoPlayer\n          .Bui…ntrol)\n          .build()");
        simpleExoPlayer.x(rxPlayerEventListener);
        Scheduler schedulerA = Schedulers2.a();
        Intrinsics3.checkNotNullExpressionValue(schedulerA, "Schedulers.computation()");
        return new AppMediaPlayer(simpleExoPlayer, rxPlayerEventListener, cacheDataSourceFactory, schedulerA, appLog);
    }
}
