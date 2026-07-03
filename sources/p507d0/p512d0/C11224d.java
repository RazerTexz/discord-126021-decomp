package p507d0.p512d0;

import java.util.NoSuchElementException;
import p507d0.p580t.AbstractC12128d0;

/* JADX INFO: renamed from: d0.d0.d */
/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11224d extends AbstractC12128d0 {

    /* JADX INFO: renamed from: j */
    public final long f22286j;

    /* JADX INFO: renamed from: k */
    public boolean f22287k;

    /* JADX INFO: renamed from: l */
    public long f22288l;

    /* JADX INFO: renamed from: m */
    public final long f22289m;

    public C11224d(long j, long j2, long j3) {
        this.f22289m = j3;
        this.f22286j = j2;
        boolean z2 = true;
        if (j3 <= 0 ? j < j2 : j > j2) {
            z2 = false;
        }
        this.f22287k = z2;
        this.f22288l = z2 ? j : j2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f22287k;
    }

    @Override // p507d0.p580t.AbstractC12128d0
    public long nextLong() {
        long j = this.f22288l;
        if (j != this.f22286j) {
            this.f22288l = this.f22289m + j;
        } else {
            if (!this.f22287k) {
                throw new NoSuchElementException();
            }
            this.f22287k = false;
        }
        return j;
    }
}
