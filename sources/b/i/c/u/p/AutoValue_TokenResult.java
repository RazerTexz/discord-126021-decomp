package b.i.c.u.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.u.p.TokenResult;

/* JADX INFO: renamed from: b.i.c.u.p.b, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_TokenResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_TokenResult extends TokenResult {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1789b;
    public final TokenResult.b c;

    /* JADX INFO: renamed from: b.i.c.u.p.b$b */
    /* JADX INFO: compiled from: AutoValue_TokenResult.java */
    public static final class b extends TokenResult.a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f1790b;
        public TokenResult.b c;

        @Override // b.i.c.u.p.TokenResult.a
        public TokenResult a() {
            String str = this.f1790b == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                return new AutoValue_TokenResult(this.a, this.f1790b.longValue(), this.c, null);
            }
            throw new IllegalStateException(outline.w("Missing required properties:", str));
        }

        @Override // b.i.c.u.p.TokenResult.a
        public TokenResult.a b(long j) {
            this.f1790b = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_TokenResult(String str, long j, TokenResult.b bVar, a aVar) {
        this.a = str;
        this.f1789b = j;
        this.c = bVar;
    }

    @Override // b.i.c.u.p.TokenResult
    @Nullable
    public TokenResult.b b() {
        return this.c;
    }

    @Override // b.i.c.u.p.TokenResult
    @Nullable
    public String c() {
        return this.a;
    }

    @Override // b.i.c.u.p.TokenResult
    @NonNull
    public long d() {
        return this.f1789b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.a;
        if (str != null ? str.equals(tokenResult.c()) : tokenResult.c() == null) {
            if (this.f1789b == tokenResult.d()) {
                TokenResult.b bVar = this.c;
                if (bVar == null) {
                    if (tokenResult.b() == null) {
                        return true;
                    }
                } else if (bVar.equals(tokenResult.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.f1789b;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        TokenResult.b bVar = this.c;
        return i ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TokenResult{token=");
        sbU.append(this.a);
        sbU.append(", tokenExpirationTimestamp=");
        sbU.append(this.f1789b);
        sbU.append(", responseCode=");
        sbU.append(this.c);
        sbU.append("}");
        return sbU.toString();
    }
}
