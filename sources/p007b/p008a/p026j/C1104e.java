package p007b.p008a.p026j;

import com.discord.utilities.logging.Logger;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.j.e */
/* JADX INFO: compiled from: FloatingViewManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1104e<T> implements Action1<Throwable> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1100a f1476j;

    public C1104e(C1100a c1100a) {
        this.f1476j = c1100a;
    }

    @Override // p658rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.f1476j.f1456c, "error while subscribing to componentPausedObservable for hiding floating view", th, null, 4, null);
    }
}
