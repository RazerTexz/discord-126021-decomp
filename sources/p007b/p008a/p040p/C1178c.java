package p007b.p008a.p040p;

import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.p.c */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1178c<T> implements Action1<C1186k.b> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AppMediaPlayer f1581j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ String f1582k;

    public C1178c(AppMediaPlayer appMediaPlayer, String str) {
        this.f1581j = appMediaPlayer;
        this.f1582k = str;
    }

    @Override // p658rx.functions.Action1
    public void call(C1186k.b bVar) {
        Logger logger = this.f1581j.logger;
        String simpleName = AppMediaPlayer.class.getSimpleName();
        C12238m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        Logger.e$default(logger, simpleName, "playback error for feature: " + this.f1582k, bVar.f1594a, null, 8, null);
    }
}
