package p007b.p109f.p148h.p149a.p157e;

import androidx.annotation.VisibleForTesting;
import p007b.p109f.p148h.p149a.p150a.InterfaceC1804d;

/* JADX INFO: renamed from: b.f.h.a.e.a */
/* JADX INFO: compiled from: DropFramesFrameScheduler.java */
/* JADX INFO: loaded from: classes.dex */
public class C1825a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1804d f3561a;

    /* JADX INFO: renamed from: b */
    public long f3562b = -1;

    public C1825a(InterfaceC1804d interfaceC1804d) {
        this.f3561a = interfaceC1804d;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: a */
    public int m1166a(long j) {
        int i = 0;
        long jMo1144e = 0;
        do {
            jMo1144e += (long) this.f3561a.mo1144e(i);
            i++;
        } while (j >= jMo1144e);
        return i - 1;
    }

    /* JADX INFO: renamed from: b */
    public long m1167b() {
        long j = this.f3562b;
        if (j != -1) {
            return j;
        }
        this.f3562b = 0L;
        int iMo1142a = this.f3561a.mo1142a();
        for (int i = 0; i < iMo1142a; i++) {
            this.f3562b += (long) this.f3561a.mo1144e(i);
        }
        return this.f3562b;
    }
}
