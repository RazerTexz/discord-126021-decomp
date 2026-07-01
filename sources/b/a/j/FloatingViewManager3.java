package b.a.j;

import com.discord.utilities.logging.Logger;
import rx.functions.Action1;

/* JADX INFO: renamed from: b.a.j.e, reason: use source file name */
/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FloatingViewManager3<T> implements Action1<Throwable> {
    public final /* synthetic */ FloatingViewManager j;

    public FloatingViewManager3(FloatingViewManager floatingViewManager) {
        this.j = floatingViewManager;
    }

    @Override // rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.j.c, "error while subscribing to componentPausedObservable for hiding floating view", th, null, 4, null);
    }
}
