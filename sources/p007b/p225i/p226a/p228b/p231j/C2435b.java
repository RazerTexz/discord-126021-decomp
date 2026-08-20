package p007b.p225i.p226a.p228b.p231j;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.EnumC2409d;

/* JADX INFO: renamed from: b.i.a.b.j.b */
/* JADX INFO: compiled from: AutoValue_TransportContext.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2435b extends AbstractC2442i {

    /* JADX INFO: renamed from: a */
    public final String f5258a;

    /* JADX INFO: renamed from: b */
    public final byte[] f5259b;

    /* JADX INFO: renamed from: c */
    public final EnumC2409d f5260c;

    /* JADX INFO: renamed from: b.i.a.b.j.b$b */
    /* JADX INFO: compiled from: AutoValue_TransportContext.java */
    public static final class b extends AbstractC2442i.a {

        /* JADX INFO: renamed from: a */
        public String f5261a;

        /* JADX INFO: renamed from: b */
        public byte[] f5262b;

        /* JADX INFO: renamed from: c */
        public EnumC2409d f5263c;

        @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2442i.a
        /* JADX INFO: renamed from: a */
        public AbstractC2442i mo2351a() {
            String strM883w = this.f5261a == null ? " backendName" : "";
            if (this.f5263c == null) {
                strM883w = C1643a.m883w(strM883w, " priority");
            }
            if (strM883w.isEmpty()) {
                return new C2435b(this.f5261a, this.f5262b, this.f5263c, null);
            }
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }

        @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2442i.a
        /* JADX INFO: renamed from: b */
        public AbstractC2442i.a mo2352b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.f5261a = str;
            return this;
        }

        @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2442i.a
        /* JADX INFO: renamed from: c */
        public AbstractC2442i.a mo2353c(EnumC2409d enumC2409d) {
            Objects.requireNonNull(enumC2409d, "Null priority");
            this.f5263c = enumC2409d;
            return this;
        }
    }

    public C2435b(String str, byte[] bArr, EnumC2409d enumC2409d, a aVar) {
        this.f5258a = str;
        this.f5259b = bArr;
        this.f5260c = enumC2409d;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2442i
    /* JADX INFO: renamed from: b */
    public String mo2348b() {
        return this.f5258a;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2442i
    @Nullable
    /* JADX INFO: renamed from: c */
    public byte[] mo2349c() {
        return this.f5259b;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.AbstractC2442i
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* JADX INFO: renamed from: d */
    public EnumC2409d mo2350d() {
        return this.f5260c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2442i)) {
            return false;
        }
        AbstractC2442i abstractC2442i = (AbstractC2442i) obj;
        if (this.f5258a.equals(abstractC2442i.mo2348b())) {
            if (Arrays.equals(this.f5259b, abstractC2442i instanceof C2435b ? ((C2435b) abstractC2442i).f5259b : abstractC2442i.mo2349c()) && this.f5260c.equals(abstractC2442i.mo2350d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f5258a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f5259b)) * 1000003) ^ this.f5260c.hashCode();
    }
}
