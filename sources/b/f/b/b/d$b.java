package b.f.b.b;

import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: DiskStorageCache.java */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public class d$b {
    public boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f464b = -1;
    public long c = -1;

    public synchronized long a() {
        return this.f464b;
    }

    public synchronized void b(long j, long j2) {
        if (this.a) {
            this.f464b += j;
            this.c += j2;
        }
    }
}
