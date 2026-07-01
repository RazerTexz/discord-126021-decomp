package b.a.y.o0;

import d0.z.d.m;

/* JADX INFO: compiled from: SpeakersItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d$b extends d {
    public final int l;
    public final String m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$b(int i, String str) {
        super("other-speakers-count", 1, null);
        m.checkNotNullParameter(str, "positionKey");
        this.l = i;
        this.m = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d$b)) {
            return false;
        }
        d$b d_b = (d$b) obj;
        return this.l == d_b.l && m.areEqual(this.m, d_b.m);
    }

    public int hashCode() {
        int i = this.l * 31;
        String str = this.m;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("OtherSpeakersCountItem(otherSpeakersCount=");
        sbU.append(this.l);
        sbU.append(", positionKey=");
        return b.d.b.a.a.J(sbU, this.m, ")");
    }
}
