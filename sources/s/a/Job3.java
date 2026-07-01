package s.a;

/* JADX INFO: renamed from: s.a.o1, reason: use source file name */
/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Job3 implements Job2, Job4 {
    public static final Job3 j = new Job3();

    @Override // s.a.Job2
    public void dispose() {
    }

    @Override // s.a.Job4
    public boolean h(Throwable th) {
        return false;
    }

    public String toString() {
        return "NonDisposableHandle";
    }
}
