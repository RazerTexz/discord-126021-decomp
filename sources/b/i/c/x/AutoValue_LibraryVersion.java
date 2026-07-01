package b.i.c.x;

import b.d.b.a.outline;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.c.x.a, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_LibraryVersion.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_LibraryVersion extends LibraryVersion {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1802b;

    public AutoValue_LibraryVersion(String str, String str2) {
        Objects.requireNonNull(str, "Null libraryName");
        this.a = str;
        Objects.requireNonNull(str2, "Null version");
        this.f1802b = str2;
    }

    @Override // b.i.c.x.LibraryVersion
    public String a() {
        return this.a;
    }

    @Override // b.i.c.x.LibraryVersion
    public String b() {
        return this.f1802b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryVersion)) {
            return false;
        }
        LibraryVersion libraryVersion = (LibraryVersion) obj;
        return this.a.equals(libraryVersion.a()) && this.f1802b.equals(libraryVersion.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1802b.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("LibraryVersion{libraryName=");
        sbU.append(this.a);
        sbU.append(", version=");
        return outline.J(sbU, this.f1802b, "}");
    }
}
