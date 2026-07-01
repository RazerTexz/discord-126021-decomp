package b.i.a.b.j;

import java.util.Objects;

/* JADX INFO: compiled from: AutoValue_TransportContext.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b extends i$a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f764b;
    public b.i.a.b.d c;

    @Override // b.i.a.b.j.i$a
    public i a() {
        String strW = this.a == null ? " backendName" : "";
        if (this.c == null) {
            strW = b.d.b.a.a.w(strW, " priority");
        }
        if (strW.isEmpty()) {
            return new b(this.a, this.f764b, this.c, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", strW));
    }

    @Override // b.i.a.b.j.i$a
    public i$a b(String str) {
        Objects.requireNonNull(str, "Null backendName");
        this.a = str;
        return this;
    }

    @Override // b.i.a.b.j.i$a
    public i$a c(b.i.a.b.d dVar) {
        Objects.requireNonNull(dVar, "Null priority");
        this.c = dVar;
        return this;
    }
}
