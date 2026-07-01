package b.i.c.u;

import b.d.b.a.outline;
import b.i.c.u.o.PersistedInstallationEntry;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.c.u.i, reason: use source file name */
/* JADX INFO: compiled from: GetAuthTokenListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class GetAuthTokenListener implements StateListener {
    public final Utils6 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<k> f1781b;

    public GetAuthTokenListener(Utils6 utils6, TaskCompletionSource<k> taskCompletionSource) {
        this.a = utils6;
        this.f1781b = taskCompletionSource;
    }

    @Override // b.i.c.u.StateListener
    public boolean a(Exception exc) {
        this.f1781b.a(exc);
        return true;
    }

    @Override // b.i.c.u.StateListener
    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.j() || this.a.d(persistedInstallationEntry)) {
            return false;
        }
        TaskCompletionSource<k> taskCompletionSource = this.f1781b;
        String strA = persistedInstallationEntry.a();
        Objects.requireNonNull(strA, "Null token");
        Long lValueOf = Long.valueOf(persistedInstallationEntry.b());
        Long lValueOf2 = Long.valueOf(persistedInstallationEntry.g());
        String strW = lValueOf == null ? outline.w("", " tokenExpirationTimestamp") : "";
        if (lValueOf2 == null) {
            strW = outline.w(strW, " tokenCreationTimestamp");
        }
        if (!strW.isEmpty()) {
            throw new IllegalStateException(outline.w("Missing required properties:", strW));
        }
        taskCompletionSource.a.s(new a(strA, lValueOf.longValue(), lValueOf2.longValue(), null));
        return true;
    }
}
