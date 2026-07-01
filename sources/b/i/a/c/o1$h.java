package b.i.a.c;

import android.net.Uri;
import androidx.annotation.Nullable;
import b.i.b.b.n$b;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: MediaItem.java */
/* JADX INFO: loaded from: classes3.dex */
public class o1$h {
    public final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f1039b;

    @Nullable
    public final o1$f c;
    public final List<?> d;

    @Nullable
    public final String e;
    public final b.i.b.b.p<o1$k> f;

    @Nullable
    public final Object g;

    /* JADX WARN: Multi-variable type inference failed */
    public o1$h(Uri uri, String str, o1$f o1_f, o1$b o1_b, List list, String str2, b.i.b.b.p pVar, Object obj, o1$a o1_a) {
        this.a = uri;
        this.f1039b = str;
        this.c = o1_f;
        this.d = list;
        this.e = str2;
        this.f = pVar;
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        b.i.a.f.e.o.f.A(4, "initialCapacity");
        Object[] objArrCopyOf = new Object[4];
        int i = 0;
        int i2 = 0;
        while (i < pVar.size()) {
            o1$j o1_j = new o1$j(new o1$k$a((o1$k) pVar.get(i), null), null);
            int i3 = i2 + 1;
            if (objArrCopyOf.length < i3) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, n$b.a(objArrCopyOf.length, i3));
            }
            objArrCopyOf[i2] = o1_j;
            i++;
            i2 = i3;
        }
        b.i.b.b.p.l(objArrCopyOf, i2);
        this.g = obj;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1$h)) {
            return false;
        }
        o1$h o1_h = (o1$h) obj;
        return this.a.equals(o1_h.a) && b.i.a.c.f3.e0.a(this.f1039b, o1_h.f1039b) && b.i.a.c.f3.e0.a(this.c, o1_h.c) && b.i.a.c.f3.e0.a(null, null) && this.d.equals(o1_h.d) && b.i.a.c.f3.e0.a(this.e, o1_h.e) && this.f.equals(o1_h.f) && b.i.a.c.f3.e0.a(this.g, o1_h.g);
    }

    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.f1039b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        o1$f o1_f = this.c;
        int iHashCode3 = (this.d.hashCode() + ((((iHashCode2 + (o1_f == null ? 0 : o1_f.hashCode())) * 31) + 0) * 31)) * 31;
        String str2 = this.e;
        int iHashCode4 = (this.f.hashCode() + ((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
        Object obj = this.g;
        return iHashCode4 + (obj != null ? obj.hashCode() : 0);
    }
}
