package b.a.p;

import com.discord.player.AppMediaPlayer;
import com.discord.player.AppMediaPlayer$Event$d;
import com.discord.player.AppMediaPlayer$Event$f;
import rx.functions.Action1;

/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a<T> implements Action1<k$a> {
    public final /* synthetic */ AppMediaPlayer j;

    public a(AppMediaPlayer appMediaPlayer) {
        this.j = appMediaPlayer;
    }

    @Override // rx.functions.Action1
    public void call(k$a k_a) {
        this.j.eventSubject.k.onNext(k_a.a ? AppMediaPlayer$Event$f.a : AppMediaPlayer$Event$d.a);
    }
}
