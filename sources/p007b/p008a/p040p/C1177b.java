package p007b.p008a.p040p;

import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.p.b */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1177b<T> implements Action1<Throwable> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AppMediaPlayer f1580j;

    public C1177b(AppMediaPlayer appMediaPlayer) {
        this.f1580j = appMediaPlayer;
    }

    @Override // p658rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.f1580j.logger, "error while listening to isPlayingChanges", th, null, 4, null);
    }
}
