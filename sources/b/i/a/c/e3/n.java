package b.i.a.c.e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import b.i.a.c.i1;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: DataSpec.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public final Uri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f942b;
    public final int c;

    @Nullable
    public final byte[] d;
    public final Map<String, String> e;
    public final long f;
    public final long g;

    @Nullable
    public final String h;
    public final int i;

    @Nullable
    public final Object j;

    static {
        i1.a("goog.exo.datasource");
    }

    public n(Uri uri, long j, int i, @Nullable byte[] bArr, Map<String, String> map, long j2, long j3, @Nullable String str, int i2, @Nullable Object obj) {
        byte[] bArr2 = bArr;
        boolean z2 = true;
        b.c.a.a0.d.j(j + j2 >= 0);
        b.c.a.a0.d.j(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z2 = false;
        }
        b.c.a.a0.d.j(z2);
        this.a = uri;
        this.f942b = j;
        this.c = i;
        this.d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.e = Collections.unmodifiableMap(new HashMap(map));
        this.f = j2;
        this.g = j3;
        this.h = str;
        this.i = i2;
        this.j = obj;
    }

    public static String b(int i) {
        if (i == 1) {
            return ShareTarget.METHOD_GET;
        }
        if (i == 2) {
            return ShareTarget.METHOD_POST;
        }
        if (i == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public n$b a() {
        return new n$b(this, null);
    }

    public boolean c(int i) {
        return (this.i & i) == i;
    }

    public String toString() {
        String strB = b(this.c);
        String strValueOf = String.valueOf(this.a);
        long j = this.f;
        long j2 = this.g;
        String str = this.h;
        int i = this.i;
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str, strValueOf.length() + strB.length() + 70), "DataSpec[", strB, " ", strValueOf);
        sbS.append(", ");
        sbS.append(j);
        sbS.append(", ");
        sbS.append(j2);
        sbS.append(", ");
        sbS.append(str);
        sbS.append(", ");
        sbS.append(i);
        sbS.append("]");
        return sbS.toString();
    }
}
