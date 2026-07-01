package b.i.c.u;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: compiled from: GetAuthTokenListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class i implements m {
    public final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<k> f1781b;

    public i(n nVar, TaskCompletionSource<k> taskCompletionSource) {
        this.a = nVar;
        this.f1781b = taskCompletionSource;
    }

    @Override // b.i.c.u.m
    public boolean a(Exception exc) {
        this.f1781b.a(exc);
        return true;
    }

    @Override // b.i.c.u.m
    public boolean b(b.i.c.u.o.d dVar) {
        if (!dVar.j() || this.a.d(dVar)) {
            return false;
        }
        TaskCompletionSource<k> taskCompletionSource = this.f1781b;
        String strA = dVar.a();
        Objects.requireNonNull(strA, "Null token");
        Long lValueOf = Long.valueOf(dVar.b());
        Long lValueOf2 = Long.valueOf(dVar.g());
        String strW = lValueOf == null ? b.d.b.a.a.w("", " tokenExpirationTimestamp") : "";
        if (lValueOf2 == null) {
            strW = b.d.b.a.a.w(strW, " tokenCreationTimestamp");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
        }
        taskCompletionSource.a.s(new a(strA, lValueOf.longValue(), lValueOf2.longValue(), null));
        return true;
    }
}
