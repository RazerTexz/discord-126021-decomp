package b.a.p;

import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import rx.functions.Action1;

/* JADX INFO: renamed from: b.a.p.h, reason: use source file name */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayer9<T> implements Action1<Throwable> {
    public final /* synthetic */ AppMediaPlayer j;

    public AppMediaPlayer9(AppMediaPlayer appMediaPlayer) {
        this.j = appMediaPlayer;
    }

    @Override // rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.j.logger, "error while polling progress position", th, null, 4, null);
    }
}
