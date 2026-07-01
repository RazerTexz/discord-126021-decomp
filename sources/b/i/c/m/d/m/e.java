package b.i.c.m.d.m;

import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_FilesPayload_File.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends v$c$a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f1717b;

    public e(String str, byte[] bArr, e$a e_a) {
        this.a = str;
        this.f1717b = bArr;
    }

    @Override // b.i.c.m.d.m.v$c$a
    @NonNull
    public byte[] a() {
        return this.f1717b;
    }

    @Override // b.i.c.m.d.m.v$c$a
    @NonNull
    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v$c$a)) {
            return false;
        }
        v$c$a v_c_a = (v$c$a) obj;
        if (this.a.equals(v_c_a.b())) {
            if (Arrays.equals(this.f1717b, v_c_a instanceof e ? ((e) v_c_a).f1717b : v_c_a.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f1717b);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("File{filename=");
        sbU.append(this.a);
        sbU.append(", contents=");
        sbU.append(Arrays.toString(this.f1717b));
        sbU.append("}");
        return sbU.toString();
    }
}
