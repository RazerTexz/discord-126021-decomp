package b.i.a.b.j;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.Arrays;

/* JADX INFO: compiled from: AutoValue_TransportContext.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends i {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f763b;
    public final b.i.a.b.d c;

    public b(String str, byte[] bArr, b.i.a.b.d dVar, b$a b_a) {
        this.a = str;
        this.f763b = bArr;
        this.c = dVar;
    }

    @Override // b.i.a.b.j.i
    public String b() {
        return this.a;
    }

    @Override // b.i.a.b.j.i
    @Nullable
    public byte[] c() {
        return this.f763b;
    }

    @Override // b.i.a.b.j.i
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public b.i.a.b.d d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.a.equals(iVar.b())) {
            if (Arrays.equals(this.f763b, iVar instanceof b ? ((b) iVar).f763b : iVar.c()) && this.c.equals(iVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f763b)) * 1000003) ^ this.c.hashCode();
    }
}
