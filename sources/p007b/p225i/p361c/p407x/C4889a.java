package p007b.p225i.p361c.p407x;

import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.x.a */
/* JADX INFO: compiled from: AutoValue_LibraryVersion.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4889a extends AbstractC4893e {

    /* JADX INFO: renamed from: a */
    public final String f13079a;

    /* JADX INFO: renamed from: b */
    public final String f13080b;

    public C4889a(String str, String str2) {
        Objects.requireNonNull(str, "Null libraryName");
        this.f13079a = str;
        Objects.requireNonNull(str2, "Null version");
        this.f13080b = str2;
    }

    @Override // p007b.p225i.p361c.p407x.AbstractC4893e
    /* JADX INFO: renamed from: a */
    public String mo6843a() {
        return this.f13079a;
    }

    @Override // p007b.p225i.p361c.p407x.AbstractC4893e
    /* JADX INFO: renamed from: b */
    public String mo6844b() {
        return this.f13080b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4893e)) {
            return false;
        }
        AbstractC4893e abstractC4893e = (AbstractC4893e) obj;
        return this.f13079a.equals(abstractC4893e.mo6843a()) && this.f13080b.equals(abstractC4893e.mo6844b());
    }

    public int hashCode() {
        return ((this.f13079a.hashCode() ^ 1000003) * 1000003) ^ this.f13080b.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("LibraryVersion{libraryName=");
        sbM833U.append(this.f13079a);
        sbM833U.append(", version=");
        return C1643a.m822J(sbM833U, this.f13080b, "}");
    }
}
