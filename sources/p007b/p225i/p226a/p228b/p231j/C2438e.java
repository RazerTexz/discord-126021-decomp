package p007b.p225i.p226a.p228b.p231j;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.C2407b;

/* JADX INFO: renamed from: b.i.a.b.j.e */
/* JADX INFO: compiled from: EncodedPayload.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2438e {

    /* JADX INFO: renamed from: a */
    public final C2407b f5276a;

    /* JADX INFO: renamed from: b */
    public final byte[] f5277b;

    public C2438e(@NonNull C2407b c2407b, @NonNull byte[] bArr) {
        Objects.requireNonNull(c2407b, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.f5276a = c2407b;
        this.f5277b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2438e)) {
            return false;
        }
        C2438e c2438e = (C2438e) obj;
        if (this.f5276a.equals(c2438e.f5276a)) {
            return Arrays.equals(this.f5277b, c2438e.f5277b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.f5276a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5277b);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EncodedPayload{encoding=");
        sbM833U.append(this.f5276a);
        sbM833U.append(", bytes=[...]}");
        return sbM833U.toString();
    }
}
