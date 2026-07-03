package p007b.p008a.p040p;

import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.p.f */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1181f<T> implements Action1<Throwable> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AppMediaPlayer f1585j;

    public C1181f(AppMediaPlayer appMediaPlayer) {
        this.f1585j = appMediaPlayer;
    }

    @Override // p658rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.f1585j.logger, "error while listening to player states", th, null, 4, null);
    }
}
