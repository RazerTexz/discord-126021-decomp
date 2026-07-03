package p007b.p008a.p040p;

import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.p.h */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1183h<T> implements Action1<Throwable> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AppMediaPlayer f1587j;

    public C1183h(AppMediaPlayer appMediaPlayer) {
        this.f1587j = appMediaPlayer;
    }

    @Override // p658rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.f1587j.logger, "error while polling progress position", th, null, 4, null);
    }
}
