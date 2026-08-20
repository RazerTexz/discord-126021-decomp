package p007b.p225i.p361c.p401u.p403p;

import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.u.p.a */
/* JADX INFO: compiled from: AutoValue_InstallationResponse.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4855a extends AbstractC4858d {

    /* JADX INFO: renamed from: a */
    public final String f12978a;

    /* JADX INFO: renamed from: b */
    public final String f12979b;

    /* JADX INFO: renamed from: c */
    public final String f12980c;

    /* JADX INFO: renamed from: d */
    public final AbstractC4860f f12981d;

    /* JADX INFO: renamed from: e */
    public final AbstractC4858d.a f12982e;

    public C4855a(String str, String str2, String str3, AbstractC4860f abstractC4860f, AbstractC4858d.a aVar, a aVar2) {
        this.f12978a = str;
        this.f12979b = str2;
        this.f12980c = str3;
        this.f12981d = abstractC4860f;
        this.f12982e = aVar;
    }

    @Override // p007b.p225i.p361c.p401u.p403p.AbstractC4858d
    @Nullable
    /* JADX INFO: renamed from: a */
    public AbstractC4860f mo6792a() {
        return this.f12981d;
    }

    @Override // p007b.p225i.p361c.p401u.p403p.AbstractC4858d
    @Nullable
    /* JADX INFO: renamed from: b */
    public String mo6793b() {
        return this.f12979b;
    }

    @Override // p007b.p225i.p361c.p401u.p403p.AbstractC4858d
    @Nullable
    /* JADX INFO: renamed from: c */
    public String mo6794c() {
        return this.f12980c;
    }

    @Override // p007b.p225i.p361c.p401u.p403p.AbstractC4858d
    @Nullable
    /* JADX INFO: renamed from: d */
    public AbstractC4858d.a mo6795d() {
        return this.f12982e;
    }

    @Override // p007b.p225i.p361c.p401u.p403p.AbstractC4858d
    @Nullable
    /* JADX INFO: renamed from: e */
    public String mo6796e() {
        return this.f12978a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4858d)) {
            return false;
        }
        AbstractC4858d abstractC4858d = (AbstractC4858d) obj;
        String str = this.f12978a;
        if (str != null ? str.equals(abstractC4858d.mo6796e()) : abstractC4858d.mo6796e() == null) {
            String str2 = this.f12979b;
            if (str2 != null ? str2.equals(abstractC4858d.mo6793b()) : abstractC4858d.mo6793b() == null) {
                String str3 = this.f12980c;
                if (str3 != null ? str3.equals(abstractC4858d.mo6794c()) : abstractC4858d.mo6794c() == null) {
                    AbstractC4860f abstractC4860f = this.f12981d;
                    if (abstractC4860f != null ? abstractC4860f.equals(abstractC4858d.mo6792a()) : abstractC4858d.mo6792a() == null) {
                        AbstractC4858d.a aVar = this.f12982e;
                        if (aVar == null) {
                            if (abstractC4858d.mo6795d() == null) {
                                return true;
                            }
                        } else if (aVar.equals(abstractC4858d.mo6795d())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f12978a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f12979b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f12980c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        AbstractC4860f abstractC4860f = this.f12981d;
        int iHashCode4 = (iHashCode3 ^ (abstractC4860f == null ? 0 : abstractC4860f.hashCode())) * 1000003;
        AbstractC4858d.a aVar = this.f12982e;
        return iHashCode4 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("InstallationResponse{uri=");
        sbM833U.append(this.f12978a);
        sbM833U.append(", fid=");
        sbM833U.append(this.f12979b);
        sbM833U.append(", refreshToken=");
        sbM833U.append(this.f12980c);
        sbM833U.append(", authToken=");
        sbM833U.append(this.f12981d);
        sbM833U.append(", responseCode=");
        sbM833U.append(this.f12982e);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
