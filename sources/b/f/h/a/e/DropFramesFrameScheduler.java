package b.f.h.a.e;

import androidx.annotation.VisibleForTesting;
import b.f.h.a.a.AnimationInformation;

/* JADX INFO: renamed from: b.f.h.a.e.a, reason: use source file name */
/* JADX INFO: compiled from: DropFramesFrameScheduler.java */
/* JADX INFO: loaded from: classes.dex */
public class DropFramesFrameScheduler {
    public final AnimationInformation a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f537b = -1;

    public DropFramesFrameScheduler(AnimationInformation animationInformation) {
        this.a = animationInformation;
    }

    @VisibleForTesting
    public int a(long j) {
        int i = 0;
        long jE = 0;
        do {
            jE += (long) this.a.e(i);
            i++;
        } while (j >= jE);
        return i - 1;
    }

    public long b() {
        long j = this.f537b;
        if (j != -1) {
            return j;
        }
        this.f537b = 0L;
        int iA = this.a.a();
        for (int i = 0; i < iA; i++) {
            this.f537b += (long) this.a.e(i);
        }
        return this.f537b;
    }
}
