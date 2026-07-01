package b.i.c.u;

import b.i.c.u.o.PersistedInstallation;
import b.i.c.u.o.PersistedInstallationEntry;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: renamed from: b.i.c.u.j, reason: use source file name */
/* JADX INFO: compiled from: GetIdListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class GetIdListener implements StateListener {
    public final TaskCompletionSource<String> a;

    public GetIdListener(TaskCompletionSource<String> taskCompletionSource) {
        this.a = taskCompletionSource;
    }

    @Override // b.i.c.u.StateListener
    public boolean a(Exception exc) {
        return false;
    }

    @Override // b.i.c.u.StateListener
    public boolean b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!(persistedInstallationEntry.f() == PersistedInstallation.a.UNREGISTERED) && !persistedInstallationEntry.j() && !persistedInstallationEntry.h()) {
            return false;
        }
        this.a.b(persistedInstallationEntry.c());
        return true;
    }
}
