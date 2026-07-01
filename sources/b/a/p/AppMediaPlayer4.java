package b.a.p;

import b.a.p.RxPlayerEventListener;
import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import d0.z.d.Intrinsics3;
import rx.functions.Action1;

/* JADX INFO: renamed from: b.a.p.c, reason: use source file name */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayer4<T> implements Action1<RxPlayerEventListener.b> {
    public final /* synthetic */ AppMediaPlayer j;
    public final /* synthetic */ String k;

    public AppMediaPlayer4(AppMediaPlayer appMediaPlayer, String str) {
        this.j = appMediaPlayer;
        this.k = str;
    }

    @Override // rx.functions.Action1
    public void call(RxPlayerEventListener.b bVar) {
        Logger logger = this.j.logger;
        String simpleName = AppMediaPlayer.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        Logger.e$default(logger, simpleName, "playback error for feature: " + this.k, bVar.a, null, 8, null);
    }
}
