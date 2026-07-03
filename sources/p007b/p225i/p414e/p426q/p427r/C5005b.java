package p007b.p225i.p414e.p426q.p427r;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.e.q.r.b */
/* JADX INFO: compiled from: DataCharacter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5005b {

    /* JADX INFO: renamed from: a */
    public final int f13405a;

    /* JADX INFO: renamed from: b */
    public final int f13406b;

    public C5005b(int i, int i2) {
        this.f13405a = i;
        this.f13406b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C5005b)) {
            return false;
        }
        C5005b c5005b = (C5005b) obj;
        return this.f13405a == c5005b.f13405a && this.f13406b == c5005b.f13406b;
    }

    public final int hashCode() {
        return this.f13405a ^ this.f13406b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13405a);
        sb.append("(");
        return C1643a.m813A(sb, this.f13406b, ')');
    }
}
