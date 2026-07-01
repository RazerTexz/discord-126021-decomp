package b.i.a.c.c3;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.a3.TrackGroup;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.c3.g, reason: use source file name */
/* JADX INFO: compiled from: BaseTrackSelection.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseTrackSelection implements ExoTrackSelection2 {
    public final TrackGroup a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f897b;
    public final int[] c;
    public final Format2[] d;
    public int e;

    public BaseTrackSelection(TrackGroup trackGroup, int[] iArr, int i) {
        AnimatableValueParser.D(iArr.length > 0);
        Objects.requireNonNull(trackGroup);
        this.a = trackGroup;
        int length = iArr.length;
        this.f897b = length;
        this.d = new Format2[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.d[i2] = trackGroup.l[iArr[i2]];
        }
        Arrays.sort(this.d, new Comparator() { // from class: b.i.a.c.c3.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Format2) obj2).f1017s - ((Format2) obj).f1017s;
            }
        });
        this.c = new int[this.f897b];
        int i3 = 0;
        while (true) {
            int i4 = this.f897b;
            if (i3 >= i4) {
                long[] jArr = new long[i4];
                return;
            }
            int[] iArr2 = this.c;
            Format2 format2 = this.d[i3];
            int i5 = 0;
            while (true) {
                Format2[] format2Arr = trackGroup.l;
                if (i5 >= format2Arr.length) {
                    i5 = -1;
                    break;
                } else if (format2 == format2Arr[i5]) {
                    break;
                } else {
                    i5++;
                }
            }
            iArr2[i3] = i5;
            i3++;
        }
    }

    @Override // b.i.a.c.c3.TrackSelection
    public final TrackGroup a() {
        return this.a;
    }

    @Override // b.i.a.c.c3.ExoTrackSelection2
    public /* synthetic */ void c(boolean z2) {
        ExoTrackSelection.b(this, z2);
    }

    @Override // b.i.a.c.c3.TrackSelection
    public final Format2 d(int i) {
        return this.d[i];
    }

    @Override // b.i.a.c.c3.ExoTrackSelection2
    public void e() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseTrackSelection baseTrackSelection = (BaseTrackSelection) obj;
        return this.a == baseTrackSelection.a && Arrays.equals(this.c, baseTrackSelection.c);
    }

    @Override // b.i.a.c.c3.TrackSelection
    public final int f(int i) {
        return this.c[i];
    }

    @Override // b.i.a.c.c3.ExoTrackSelection2
    public void g() {
    }

    @Override // b.i.a.c.c3.ExoTrackSelection2
    public final Format2 h() {
        return this.d[b()];
    }

    public int hashCode() {
        if (this.e == 0) {
            this.e = Arrays.hashCode(this.c) + (System.identityHashCode(this.a) * 31);
        }
        return this.e;
    }

    @Override // b.i.a.c.c3.ExoTrackSelection2
    public void i(float f) {
    }

    @Override // b.i.a.c.c3.ExoTrackSelection2
    public /* synthetic */ void j() {
        ExoTrackSelection.a(this);
    }

    @Override // b.i.a.c.c3.ExoTrackSelection2
    public /* synthetic */ void k() {
        ExoTrackSelection.c(this);
    }

    @Override // b.i.a.c.c3.TrackSelection
    public final int l(int i) {
        for (int i2 = 0; i2 < this.f897b; i2++) {
            if (this.c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // b.i.a.c.c3.TrackSelection
    public final int length() {
        return this.c.length;
    }
}
