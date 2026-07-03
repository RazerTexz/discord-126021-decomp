package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.i.c.m.d.k.k */
/* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4637k<T> implements InterfaceC4353a<Void, T> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Callable f12328a;

    public C4637k(C4631i c4631i, Callable callable) {
        this.f12328a = callable;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* JADX INFO: renamed from: a */
    public T mo4012a(@NonNull Task<Void> task) throws Exception {
        return (T) this.f12328a.call();
    }
}
