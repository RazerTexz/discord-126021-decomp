package b.i.c.u.p;

/* JADX INFO: compiled from: AutoValue_TokenResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b extends f$a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f1790b;
    public f$b c;

    @Override // b.i.c.u.p.f$a
    public f a() {
        String str = this.f1790b == null ? " tokenExpirationTimestamp" : "";
        if (str.isEmpty()) {
            return new b(this.a, this.f1790b.longValue(), this.c, null);
        }
        throw new IllegalStateException(b.d.b.a.a.w("Missing required properties:", str));
    }

    @Override // b.i.c.u.p.f$a
    public f$a b(long j) {
        this.f1790b = Long.valueOf(j);
        return this;
    }
}
