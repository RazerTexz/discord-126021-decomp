package b.i.a.c;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.c1, reason: use source file name */
/* JADX INFO: compiled from: DeviceInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DeviceInfo2 implements Bundleable {
    public final int j;
    public final int k;
    public final int l;

    public DeviceInfo2(int i, int i2, int i3) {
        this.j = i;
        this.k = i2;
        this.l = i3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo2)) {
            return false;
        }
        DeviceInfo2 deviceInfo2 = (DeviceInfo2) obj;
        return this.j == deviceInfo2.j && this.k == deviceInfo2.k && this.l == deviceInfo2.l;
    }

    public int hashCode() {
        return ((((527 + this.j) * 31) + this.k) * 31) + this.l;
    }
}
