package b.i.a.c.e3;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Util2;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.e3.o, reason: use source file name */
/* JADX INFO: compiled from: DefaultAllocator.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultAllocator {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f944b;
    public final Allocation[] c;
    public int d;
    public int e;
    public int f;
    public Allocation[] g;

    public DefaultAllocator(boolean z2, int i) {
        AnimatableValueParser.j(i > 0);
        AnimatableValueParser.j(true);
        this.a = z2;
        this.f944b = i;
        this.f = 0;
        this.g = new Allocation[100];
        this.c = new Allocation[1];
    }

    public synchronized void a(Allocation[] allocationArr) {
        int i = this.f;
        int length = allocationArr.length + i;
        Allocation[] allocationArr2 = this.g;
        if (length >= allocationArr2.length) {
            this.g = (Allocation[]) Arrays.copyOf(allocationArr2, Math.max(allocationArr2.length * 2, i + allocationArr.length));
        }
        for (Allocation allocation : allocationArr) {
            Allocation[] allocationArr3 = this.g;
            int i2 = this.f;
            this.f = i2 + 1;
            allocationArr3[i2] = allocation;
        }
        this.e -= allocationArr.length;
        notifyAll();
    }

    public synchronized void b(int i) {
        boolean z2 = i < this.d;
        this.d = i;
        if (z2) {
            c();
        }
    }

    public synchronized void c() {
        int iMax = Math.max(0, Util2.f(this.d, this.f944b) - this.e);
        int i = this.f;
        if (iMax >= i) {
            return;
        }
        Arrays.fill(this.g, iMax, i, (Object) null);
        this.f = iMax;
    }
}
