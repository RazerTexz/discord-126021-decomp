package b.i.a.b.j;

import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.a.b.Encoding2;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.j.e, reason: use source file name */
/* JADX INFO: compiled from: EncodedPayload.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EncodedPayload {
    public final Encoding2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f766b;

    public EncodedPayload(@NonNull Encoding2 encoding2, @NonNull byte[] bArr) {
        Objects.requireNonNull(encoding2, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.a = encoding2;
        this.f766b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (this.a.equals(encodedPayload.a)) {
            return Arrays.equals(this.f766b, encodedPayload.f766b);
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f766b);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EncodedPayload{encoding=");
        sbU.append(this.a);
        sbU.append(", bytes=[...]}");
        return sbU.toString();
    }
}
