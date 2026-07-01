package b.a.j;

import com.discord.utilities.logging.Logger;
import rx.functions.Action1;

/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e<T> implements Action1<Throwable> {
    public final /* synthetic */ a j;

    public e(a aVar) {
        this.j = aVar;
    }

    @Override // rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.j.c, "error while subscribing to componentPausedObservable for hiding floating view", th, null, 4, null);
    }
}
