package p007b.p225i.p361c.p369m.p370d.p375m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.m.b */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReport.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4675b extends AbstractC4695v {

    /* JADX INFO: renamed from: b */
    public final String f12518b;

    /* JADX INFO: renamed from: c */
    public final String f12519c;

    /* JADX INFO: renamed from: d */
    public final int f12520d;

    /* JADX INFO: renamed from: e */
    public final String f12521e;

    /* JADX INFO: renamed from: f */
    public final String f12522f;

    /* JADX INFO: renamed from: g */
    public final String f12523g;

    /* JADX INFO: renamed from: h */
    public final AbstractC4695v.d f12524h;

    /* JADX INFO: renamed from: i */
    public final AbstractC4695v.c f12525i;

    /* JADX INFO: renamed from: b.i.c.m.d.m.b$b */
    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport.java */
    public static final class b extends AbstractC4695v.a {

        /* JADX INFO: renamed from: a */
        public String f12526a;

        /* JADX INFO: renamed from: b */
        public String f12527b;

        /* JADX INFO: renamed from: c */
        public Integer f12528c;

        /* JADX INFO: renamed from: d */
        public String f12529d;

        /* JADX INFO: renamed from: e */
        public String f12530e;

        /* JADX INFO: renamed from: f */
        public String f12531f;

        /* JADX INFO: renamed from: g */
        public AbstractC4695v.d f12532g;

        /* JADX INFO: renamed from: h */
        public AbstractC4695v.c f12533h;

        public b() {
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v.a
        /* JADX INFO: renamed from: a */
        public AbstractC4695v mo6524a() {
            String strM883w = this.f12526a == null ? " sdkVersion" : "";
            if (this.f12527b == null) {
                strM883w = C1643a.m883w(strM883w, " gmpAppId");
            }
            if (this.f12528c == null) {
                strM883w = C1643a.m883w(strM883w, " platform");
            }
            if (this.f12529d == null) {
                strM883w = C1643a.m883w(strM883w, " installationUuid");
            }
            if (this.f12530e == null) {
                strM883w = C1643a.m883w(strM883w, " buildVersion");
            }
            if (this.f12531f == null) {
                strM883w = C1643a.m883w(strM883w, " displayVersion");
            }
            if (strM883w.isEmpty()) {
                return new C4675b(this.f12526a, this.f12527b, this.f12528c.intValue(), this.f12529d, this.f12530e, this.f12531f, this.f12532g, this.f12533h, null);
            }
            throw new IllegalStateException(C1643a.m883w("Missing required properties:", strM883w));
        }

        public b(AbstractC4695v abstractC4695v, a aVar) {
            C4675b c4675b = (C4675b) abstractC4695v;
            this.f12526a = c4675b.f12518b;
            this.f12527b = c4675b.f12519c;
            this.f12528c = Integer.valueOf(c4675b.f12520d);
            this.f12529d = c4675b.f12521e;
            this.f12530e = c4675b.f12522f;
            this.f12531f = c4675b.f12523g;
            this.f12532g = c4675b.f12524h;
            this.f12533h = c4675b.f12525i;
        }
    }

    public C4675b(String str, String str2, int i, String str3, String str4, String str5, AbstractC4695v.d dVar, AbstractC4695v.c cVar, a aVar) {
        this.f12518b = str;
        this.f12519c = str2;
        this.f12520d = i;
        this.f12521e = str3;
        this.f12522f = str4;
        this.f12523g = str5;
        this.f12524h = dVar;
        this.f12525i = cVar;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v
    @NonNull
    /* JADX INFO: renamed from: a */
    public String mo6515a() {
        return this.f12522f;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v
    @NonNull
    /* JADX INFO: renamed from: b */
    public String mo6516b() {
        return this.f12523g;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v
    @NonNull
    /* JADX INFO: renamed from: c */
    public String mo6517c() {
        return this.f12519c;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v
    @NonNull
    /* JADX INFO: renamed from: d */
    public String mo6518d() {
        return this.f12521e;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v
    @Nullable
    /* JADX INFO: renamed from: e */
    public AbstractC4695v.c mo6519e() {
        return this.f12525i;
    }

    public boolean equals(Object obj) {
        AbstractC4695v.d dVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4695v)) {
            return false;
        }
        AbstractC4695v abstractC4695v = (AbstractC4695v) obj;
        if (this.f12518b.equals(abstractC4695v.mo6521g()) && this.f12519c.equals(abstractC4695v.mo6517c()) && this.f12520d == abstractC4695v.mo6520f() && this.f12521e.equals(abstractC4695v.mo6518d()) && this.f12522f.equals(abstractC4695v.mo6515a()) && this.f12523g.equals(abstractC4695v.mo6516b()) && ((dVar = this.f12524h) != null ? dVar.equals(abstractC4695v.mo6522h()) : abstractC4695v.mo6522h() == null)) {
            AbstractC4695v.c cVar = this.f12525i;
            if (cVar == null) {
                if (abstractC4695v.mo6519e() == null) {
                    return true;
                }
            } else if (cVar.equals(abstractC4695v.mo6519e())) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v
    /* JADX INFO: renamed from: f */
    public int mo6520f() {
        return this.f12520d;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v
    @NonNull
    /* JADX INFO: renamed from: g */
    public String mo6521g() {
        return this.f12518b;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v
    @Nullable
    /* JADX INFO: renamed from: h */
    public AbstractC4695v.d mo6522h() {
        return this.f12524h;
    }

    public int hashCode() {
        int iHashCode = (((((((((((this.f12518b.hashCode() ^ 1000003) * 1000003) ^ this.f12519c.hashCode()) * 1000003) ^ this.f12520d) * 1000003) ^ this.f12521e.hashCode()) * 1000003) ^ this.f12522f.hashCode()) * 1000003) ^ this.f12523g.hashCode()) * 1000003;
        AbstractC4695v.d dVar = this.f12524h;
        int iHashCode2 = (iHashCode ^ (dVar == null ? 0 : dVar.hashCode())) * 1000003;
        AbstractC4695v.c cVar = this.f12525i;
        return iHashCode2 ^ (cVar != null ? cVar.hashCode() : 0);
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v
    /* JADX INFO: renamed from: i */
    public AbstractC4695v.a mo6523i() {
        return new b(this, null);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CrashlyticsReport{sdkVersion=");
        sbM833U.append(this.f12518b);
        sbM833U.append(", gmpAppId=");
        sbM833U.append(this.f12519c);
        sbM833U.append(", platform=");
        sbM833U.append(this.f12520d);
        sbM833U.append(", installationUuid=");
        sbM833U.append(this.f12521e);
        sbM833U.append(", buildVersion=");
        sbM833U.append(this.f12522f);
        sbM833U.append(", displayVersion=");
        sbM833U.append(this.f12523g);
        sbM833U.append(", session=");
        sbM833U.append(this.f12524h);
        sbM833U.append(", ndkPayload=");
        sbM833U.append(this.f12525i);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
