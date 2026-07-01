package b.i.a.b.j.q;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: AutoValue_BackendRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends f {
    public final Iterable<b.i.a.b.j.f> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f771b;

    public a(Iterable iterable, byte[] bArr, a$a a_a) {
        this.a = iterable;
        this.f771b = bArr;
    }

    @Override // b.i.a.b.j.q.f
    public Iterable<b.i.a.b.j.f> a() {
        return this.a;
    }

    @Override // b.i.a.b.j.q.f
    @Nullable
    public byte[] b() {
        return this.f771b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.a.equals(fVar.a())) {
            if (Arrays.equals(this.f771b, fVar instanceof a ? ((a) fVar).f771b : fVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f771b);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("BackendRequest{events=");
        sbU.append(this.a);
        sbU.append(", extras=");
        sbU.append(Arrays.toString(this.f771b));
        sbU.append("}");
        return sbU.toString();
    }
}
