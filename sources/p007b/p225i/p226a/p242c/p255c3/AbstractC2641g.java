package p007b.p225i.p226a.p242c.p255c3;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p243a3.C2556n0;

/* JADX INFO: renamed from: b.i.a.c.c3.g */
/* JADX INFO: compiled from: BaseTrackSelection.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2641g implements InterfaceC2644j {

    /* JADX INFO: renamed from: a */
    public final C2556n0 f6187a;

    /* JADX INFO: renamed from: b */
    public final int f6188b;

    /* JADX INFO: renamed from: c */
    public final int[] f6189c;

    /* JADX INFO: renamed from: d */
    public final C2811j1[] f6190d;

    /* JADX INFO: renamed from: e */
    public int f6191e;

    public AbstractC2641g(C2556n0 c2556n0, int[] iArr, int i) {
        C1460d.m426D(iArr.length > 0);
        Objects.requireNonNull(c2556n0);
        this.f6187a = c2556n0;
        int length = iArr.length;
        this.f6188b = length;
        this.f6190d = new C2811j1[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.f6190d[i2] = c2556n0.f5662l[iArr[i2]];
        }
        Arrays.sort(this.f6190d, new Comparator() { // from class: b.i.a.c.c3.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((C2811j1) obj2).f7151s - ((C2811j1) obj).f7151s;
            }
        });
        this.f6189c = new int[this.f6188b];
        int i3 = 0;
        while (true) {
            int i4 = this.f6188b;
            if (i3 >= i4) {
                long[] jArr = new long[i4];
                return;
            }
            int[] iArr2 = this.f6189c;
            C2811j1 c2811j1 = this.f6190d[i3];
            int i5 = 0;
            while (true) {
                C2811j1[] c2811j1Arr = c2556n0.f5662l;
                if (i5 >= c2811j1Arr.length) {
                    i5 = -1;
                    break;
                } else if (c2811j1 == c2811j1Arr[i5]) {
                    break;
                } else {
                    i5++;
                }
            }
            iArr2[i3] = i5;
            i3++;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2647m
    /* JADX INFO: renamed from: a */
    public final C2556n0 mo2727a() {
        return this.f6187a;
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j
    /* JADX INFO: renamed from: c */
    public /* synthetic */ void mo2728c(boolean z2) {
        C2643i.m2750b(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2647m
    /* JADX INFO: renamed from: d */
    public final C2811j1 mo2729d(int i) {
        return this.f6190d[i];
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j
    /* JADX INFO: renamed from: e */
    public void mo2724e() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AbstractC2641g abstractC2641g = (AbstractC2641g) obj;
        return this.f6187a == abstractC2641g.f6187a && Arrays.equals(this.f6189c, abstractC2641g.f6189c);
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2647m
    /* JADX INFO: renamed from: f */
    public final int mo2730f(int i) {
        return this.f6189c[i];
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j
    /* JADX INFO: renamed from: g */
    public void mo2725g() {
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j
    /* JADX INFO: renamed from: h */
    public final C2811j1 mo2731h() {
        return this.f6190d[mo2723b()];
    }

    public int hashCode() {
        if (this.f6191e == 0) {
            this.f6191e = Arrays.hashCode(this.f6189c) + (System.identityHashCode(this.f6187a) * 31);
        }
        return this.f6191e;
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j
    /* JADX INFO: renamed from: i */
    public void mo2726i(float f) {
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j
    /* JADX INFO: renamed from: j */
    public /* synthetic */ void mo2732j() {
        C2643i.m2749a(this);
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j
    /* JADX INFO: renamed from: k */
    public /* synthetic */ void mo2733k() {
        C2643i.m2751c(this);
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2647m
    /* JADX INFO: renamed from: l */
    public final int mo2734l(int i) {
        for (int i2 = 0; i2 < this.f6188b; i2++) {
            if (this.f6189c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2647m
    public final int length() {
        return this.f6189c.length;
    }
}
