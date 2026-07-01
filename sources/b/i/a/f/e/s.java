package b.i.a.f.e;

import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s implements Callable {
    public final boolean j;
    public final String k;
    public final x l;

    public s(boolean z2, String str, x xVar) {
        this.j = z2;
        this.k = str;
        this.l = xVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        boolean z2 = this.j;
        String str = this.k;
        x xVar = this.l;
        Object[] objArr = new Object[5];
        objArr[0] = true != (!z2 && b0.b(str, xVar, true, false).f1349b) ? "not allowed" : "debug cert rejected";
        objArr[1] = str;
        MessageDigest messageDigestA = b.i.a.f.e.o.a.a(Constants.SHA1);
        Objects.requireNonNull(messageDigestA, "null reference");
        byte[] bArrDigest = messageDigestA.digest(xVar.g());
        int length = bArrDigest.length;
        char[] cArr = new char[length + length];
        int i = 0;
        for (byte b2 : bArrDigest) {
            int i2 = b2 & 255;
            int i3 = i + 1;
            char[] cArr2 = b.i.a.f.e.o.d.f1396b;
            cArr[i] = cArr2[i2 >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[i2 & 15];
        }
        objArr[2] = new String(cArr);
        objArr[3] = Boolean.valueOf(z2);
        objArr[4] = "12451000.false";
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", objArr);
    }
}
