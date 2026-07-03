package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p369m.p370d.p375m.AbstractC4695v;

/* JADX INFO: renamed from: b.i.c.m.d.k.c */
/* JADX INFO: compiled from: AutoValue_CrashlyticsReportWithSessionId.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4613c extends AbstractC4646o0 {

    /* JADX INFO: renamed from: a */
    public final AbstractC4695v f12268a;

    /* JADX INFO: renamed from: b */
    public final String f12269b;

    public C4613c(AbstractC4695v abstractC4695v, String str) {
        Objects.requireNonNull(abstractC4695v, "Null report");
        this.f12268a = abstractC4695v;
        Objects.requireNonNull(str, "Null sessionId");
        this.f12269b = str;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.AbstractC4646o0
    /* JADX INFO: renamed from: a */
    public AbstractC4695v mo6396a() {
        return this.f12268a;
    }

    @Override // p007b.p225i.p361c.p369m.p370d.p373k.AbstractC4646o0
    /* JADX INFO: renamed from: b */
    public String mo6397b() {
        return this.f12269b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4646o0)) {
            return false;
        }
        AbstractC4646o0 abstractC4646o0 = (AbstractC4646o0) obj;
        return this.f12268a.equals(abstractC4646o0.mo6396a()) && this.f12269b.equals(abstractC4646o0.mo6397b());
    }

    public int hashCode() {
        return ((this.f12268a.hashCode() ^ 1000003) * 1000003) ^ this.f12269b.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("CrashlyticsReportWithSessionId{report=");
        sbM833U.append(this.f12268a);
        sbM833U.append(", sessionId=");
        return C1643a.m822J(sbM833U, this.f12269b, "}");
    }
}
