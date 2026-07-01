package okhttp3.internal.publicsuffix;

import d0.f0.q;
import d0.g0.w;
import d0.t.m;
import d0.t.n;
import d0.t.u;
import d0.y.b;
import f0.e0.k.h;
import f0.e0.k.h$a;
import g0.l;
import g0.r;
import g0.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: PublicSuffixDatabase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PublicSuffixDatabase {
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final CountDownLatch f = new CountDownLatch(1);
    public byte[] g;
    public byte[] h;
    public static final PublicSuffixDatabase$a d = new PublicSuffixDatabase$a(null);
    public static final byte[] a = {(byte) 42};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f3817b = m.listOf("*");
    public static final PublicSuffixDatabase c = new PublicSuffixDatabase();

    public final String a(String str) {
        String strA;
        String str2;
        String strA2;
        List<String> listEmptyList;
        List<String> listEmptyList2;
        int size;
        int size2;
        d0.z.d.m.checkParameterIsNotNull(str, "domain");
        String unicode = IDN.toUnicode(str);
        d0.z.d.m.checkExpressionValueIsNotNull(unicode, "unicodeDomain");
        List<String> listC = c(unicode);
        if (this.e.get() || !this.e.compareAndSet(false, true)) {
            try {
                this.f.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z2 = false;
            while (true) {
                try {
                    try {
                        b();
                        if (!z2) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z2 = true;
                    } catch (IOException e) {
                        h$a h_a = h.c;
                        h.a.i("Failed to read public suffix list", 5, e);
                        if (z2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (Throwable th) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
        }
        if (!(this.g != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size3 = listC.size();
        byte[][] bArr = new byte[size3][];
        for (int i = 0; i < size3; i++) {
            String str3 = listC.get(i);
            Charset charset = StandardCharsets.UTF_8;
            d0.z.d.m.checkExpressionValueIsNotNull(charset, "UTF_8");
            if (str3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str3.getBytes(charset);
            d0.z.d.m.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            bArr[i] = bytes;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= size3) {
                strA = null;
                break;
            }
            PublicSuffixDatabase$a publicSuffixDatabase$a = d;
            byte[] bArr2 = this.g;
            if (bArr2 == null) {
                d0.z.d.m.throwUninitializedPropertyAccessException("publicSuffixListBytes");
            }
            strA = PublicSuffixDatabase$a.a(publicSuffixDatabase$a, bArr2, bArr, i2);
            if (strA != null) {
                break;
            }
            i2++;
        }
        if (size3 <= 1) {
            str2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                str2 = null;
                break;
            }
            bArr3[i3] = a;
            PublicSuffixDatabase$a publicSuffixDatabase$a2 = d;
            byte[] bArr4 = this.g;
            if (bArr4 == null) {
                d0.z.d.m.throwUninitializedPropertyAccessException("publicSuffixListBytes");
            }
            String strA3 = PublicSuffixDatabase$a.a(publicSuffixDatabase$a2, bArr4, bArr3, i3);
            if (strA3 != null) {
                str2 = strA3;
                break;
            }
            i3++;
        }
        if (str2 == null) {
            strA2 = null;
            break;
        }
        int i4 = size3 - 1;
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                strA2 = null;
                break;
            }
            PublicSuffixDatabase$a publicSuffixDatabase$a3 = d;
            byte[] bArr5 = this.h;
            if (bArr5 == null) {
                d0.z.d.m.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
            }
            strA2 = PublicSuffixDatabase$a.a(publicSuffixDatabase$a3, bArr5, bArr, i5);
            if (strA2 != null) {
                break;
            }
            i5++;
        }
        if (strA2 != null) {
            listEmptyList2 = w.split$default((CharSequence) ('!' + strA2), new char[]{'.'}, false, 0, 6, (Object) null);
        } else if (strA == null && str2 == null) {
            listEmptyList2 = f3817b;
        } else {
            if (strA == null || (listEmptyList = w.split$default((CharSequence) strA, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                listEmptyList = n.emptyList();
            }
            if (str2 == null || (listEmptyList2 = w.split$default((CharSequence) str2, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                listEmptyList2 = n.emptyList();
            }
            if (listEmptyList.size() > listEmptyList2.size()) {
                listEmptyList2 = listEmptyList;
            }
        }
        if (listC.size() == listEmptyList2.size() && listEmptyList2.get(0).charAt(0) != '!') {
            return null;
        }
        if (listEmptyList2.get(0).charAt(0) == '!') {
            size = listC.size();
            size2 = listEmptyList2.size();
        } else {
            size = listC.size();
            size2 = listEmptyList2.size() + 1;
        }
        return q.joinToString$default(q.drop(u.asSequence(c(str)), size - size2), ".", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0048 A[Catch: all -> 0x0054, TryCatch #0 {, blocks: (B:9:0x0041, B:10:0x0044, B:12:0x0048, B:13:0x004b), top: B:26:0x0041 }] */
    public final void b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            d0.z.d.m.checkParameterIsNotNull(resourceAsStream, "$this$source");
            l lVar = new l(new g0.n(resourceAsStream, new y()));
            d0.z.d.m.checkParameterIsNotNull(lVar, "$this$buffer");
            r rVar = new r(lVar);
            try {
                byte[] bArrZ = rVar.Z(rVar.readInt());
                byte[] bArrZ2 = rVar.Z(rVar.readInt());
                b.closeFinally(rVar, null);
                synchronized (this) {
                    if (bArrZ == null) {
                        d0.z.d.m.throwNpe();
                        this.g = bArrZ;
                        if (bArrZ2 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        this.h = bArrZ2;
                    } else {
                        this.g = bArrZ;
                        if (bArrZ2 == null) {
                            d0.z.d.m.throwNpe();
                        }
                        this.h = bArrZ2;
                    }
                    throw th;
                }
                this.f.countDown();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    b.closeFinally(rVar, th);
                    throw th2;
                }
            }
        }
    }

    public final List<String> c(String str) {
        List<String> listSplit$default = w.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        return d0.z.d.m.areEqual((String) u.last((List) listSplit$default), "") ? u.dropLast(listSplit$default, 1) : listSplit$default;
    }
}
