package b.i.a.b.j;

import androidx.annotation.NonNull;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: EncodedPayload.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public final b.i.a.b.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f766b;

    public e(@NonNull b.i.a.b.b bVar, @NonNull byte[] bArr) {
        Objects.requireNonNull(bVar, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.a = bVar;
        this.f766b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.a.equals(eVar.a)) {
            return Arrays.equals(this.f766b, eVar.f766b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f766b);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("EncodedPayload{encoding=");
        sbU.append(this.a);
        sbU.append(", bytes=[...]}");
        return sbU.toString();
    }
}
