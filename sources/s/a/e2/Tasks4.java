package s.a.e2;

/* JADX INFO: renamed from: s.a.e2.h, reason: use source file name */
/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Tasks4 implements Runnable {
    public long j;
    public Tasks5 k;

    public Tasks4(long j, Tasks5 tasks5) {
        this.j = j;
        this.k = tasks5;
    }

    public Tasks4() {
        Tasks3 tasks3 = Tasks3.j;
        this.j = 0L;
        this.k = tasks3;
    }
}
