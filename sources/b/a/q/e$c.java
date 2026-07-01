package b.a.q;

import com.discord.rtcconnection.EncodeQuality;

/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$c {
    public final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f259b;
    public final EncodeQuality c;

    public e$c(n nVar, int i, EncodeQuality encodeQuality) {
        d0.z.d.m.checkNotNullParameter(nVar, "budget");
        d0.z.d.m.checkNotNullParameter(encodeQuality, "wantValue");
        this.a = nVar;
        this.f259b = i;
        this.c = encodeQuality;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e$c)) {
            return false;
        }
        e$c e_c = (e$c) obj;
        return d0.z.d.m.areEqual(this.a, e_c.a) && this.f259b == e_c.f259b && d0.z.d.m.areEqual(this.c, e_c.c);
    }

    public int hashCode() {
        n nVar = this.a;
        int iHashCode = (((nVar != null ? nVar.hashCode() : 0) * 31) + this.f259b) * 31;
        EncodeQuality encodeQuality = this.c;
        return iHashCode + (encodeQuality != null ? encodeQuality.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("OrderedLadder(budget=");
        sbU.append(this.a);
        sbU.append(", pixelCount=");
        sbU.append(this.f259b);
        sbU.append(", wantValue=");
        sbU.append(this.c);
        sbU.append(")");
        return sbU.toString();
    }
}
