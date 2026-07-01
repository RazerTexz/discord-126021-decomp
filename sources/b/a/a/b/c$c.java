package b.a.a.b;

import androidx.annotation.DrawableRes;
import d0.z.d.m;

/* JADX INFO: compiled from: MultiValuePropPremiumUpsellDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f45b;
    public CharSequence c;

    public c$c(@DrawableRes int i, CharSequence charSequence, CharSequence charSequence2) {
        m.checkNotNullParameter(charSequence, "headerText");
        m.checkNotNullParameter(charSequence2, "bodyText");
        this.a = i;
        this.f45b = charSequence;
        this.c = charSequence2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c$c)) {
            return false;
        }
        c$c c_c = (c$c) obj;
        return this.a == c_c.a && m.areEqual(this.f45b, c_c.f45b) && m.areEqual(this.c, c_c.c);
    }

    public int hashCode() {
        int i = this.a * 31;
        CharSequence charSequence = this.f45b;
        int iHashCode = (i + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.c;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("UpsellData(imageResId=");
        sbU.append(this.a);
        sbU.append(", headerText=");
        sbU.append(this.f45b);
        sbU.append(", bodyText=");
        return b.d.b.a.a.E(sbU, this.c, ")");
    }
}
