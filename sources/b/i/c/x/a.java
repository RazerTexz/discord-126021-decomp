package b.i.c.x;

import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_LibraryVersion.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends e {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1802b;

    public a(String str, String str2) {
        Objects.requireNonNull(str, "Null libraryName");
        this.a = str;
        Objects.requireNonNull(str2, "Null version");
        this.f1802b = str2;
    }

    @Override // b.i.c.x.e
    public String a() {
        return this.a;
    }

    @Override // b.i.c.x.e
    public String b() {
        return this.f1802b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a.equals(eVar.a()) && this.f1802b.equals(eVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1802b.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("LibraryVersion{libraryName=");
        sbU.append(this.a);
        sbU.append(", version=");
        return b.d.b.a.a.J(sbU, this.f1802b, "}");
    }
}
