package p007b.p225i.p361c.p401u.p403p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p401u.p403p.AbstractC4860f;

/* JADX INFO: renamed from: b.i.c.u.p.b */
/* JADX INFO: compiled from: AutoValue_TokenResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4856b extends AbstractC4860f {

    /* JADX INFO: renamed from: a */
    public final String f12983a;

    /* JADX INFO: renamed from: b */
    public final long f12984b;

    /* JADX INFO: renamed from: c */
    public final AbstractC4860f.b f12985c;

    /* JADX INFO: renamed from: b.i.c.u.p.b$b */
    /* JADX INFO: compiled from: AutoValue_TokenResult.java */
    public static final class b extends AbstractC4860f.a {

        /* JADX INFO: renamed from: a */
        public String f12986a;

        /* JADX INFO: renamed from: b */
        public Long f12987b;

        /* JADX INFO: renamed from: c */
        public AbstractC4860f.b f12988c;

        @Override // p007b.p225i.p361c.p401u.p403p.AbstractC4860f.a
        /* JADX INFO: renamed from: a */
        public AbstractC4860f mo6800a() {
            String str = this.f12987b == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                return new C4856b(this.f12986a, this.f12987b.longValue(), this.f12988c, null);
            }
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", str));
        }

        @Override // p007b.p225i.p361c.p401u.p403p.AbstractC4860f.a
        /* JADX INFO: renamed from: b */
        public AbstractC4860f.a mo6801b(long j) {
            this.f12987b = Long.valueOf(j);
            return this;
        }
    }

    public C4856b(String str, long j, AbstractC4860f.b bVar, a aVar) {
        this.f12983a = str;
        this.f12984b = j;
        this.f12985c = bVar;
    }

    @Override // p007b.p225i.p361c.p401u.p403p.AbstractC4860f
    @Nullable
    /* JADX INFO: renamed from: b */
    public AbstractC4860f.b mo6797b() {
        return this.f12985c;
    }

    @Override // p007b.p225i.p361c.p401u.p403p.AbstractC4860f
    @Nullable
    /* JADX INFO: renamed from: c */
    public String mo6798c() {
        return this.f12983a;
    }

    @Override // p007b.p225i.p361c.p401u.p403p.AbstractC4860f
    @NonNull
    /* JADX INFO: renamed from: d */
    public long mo6799d() {
        return this.f12984b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4860f)) {
            return false;
        }
        AbstractC4860f abstractC4860f = (AbstractC4860f) obj;
        String str = this.f12983a;
        if (str != null ? str.equals(abstractC4860f.mo6798c()) : abstractC4860f.mo6798c() == null) {
            if (this.f12984b == abstractC4860f.mo6799d()) {
                AbstractC4860f.b bVar = this.f12985c;
                if (bVar == null) {
                    if (abstractC4860f.mo6797b() == null) {
                        return true;
                    }
                } else if (bVar.equals(abstractC4860f.mo6797b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f12983a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.f12984b;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        AbstractC4860f.b bVar = this.f12985c;
        return i ^ (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TokenResult{token=");
        sbM833U.append(this.f12983a);
        sbM833U.append(", tokenExpirationTimestamp=");
        sbM833U.append(this.f12984b);
        sbM833U.append(", responseCode=");
        sbM833U.append(this.f12985c);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
