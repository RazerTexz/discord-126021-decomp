package okhttp3.internal.publicsuffix;

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
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p578f0.C12078q;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p609k.C12333h;
import p615g0.C12395l;
import p615g0.C12397n;
import p615g0.C12401r;
import p615g0.C12408y;

/* JADX INFO: compiled from: PublicSuffixDatabase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: e */
    public final AtomicBoolean f27588e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f */
    public final CountDownLatch f27589f = new CountDownLatch(1);

    /* JADX INFO: renamed from: g */
    public byte[] f27590g;

    /* JADX INFO: renamed from: h */
    public byte[] f27591h;

    /* JADX INFO: renamed from: d */
    public static final C12940a f27587d = new C12940a(null);

    /* JADX INFO: renamed from: a */
    public static final byte[] f27584a = {(byte) 42};

    /* JADX INFO: renamed from: b */
    public static final List<String> f27585b = C12145m.listOf("*");

    /* JADX INFO: renamed from: c */
    public static final PublicSuffixDatabase f27586c = new PublicSuffixDatabase();

    /* JADX INFO: renamed from: okhttp3.internal.publicsuffix.PublicSuffixDatabase$a */
    /* JADX INFO: compiled from: PublicSuffixDatabase.kt */
    public static final class C12940a {
        public C12940a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public static final String m11005a(C12940a c12940a, byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            boolean z2;
            int i3;
            int i4;
            int length = bArr.length;
            int i5 = 0;
            while (i5 < length) {
                int i6 = (i5 + length) / 2;
                while (i6 > -1 && bArr[i6] != ((byte) 10)) {
                    i6--;
                }
                int i7 = i6 + 1;
                int i8 = 1;
                while (true) {
                    i2 = i7 + i8;
                    if (bArr[i2] == ((byte) 10)) {
                        break;
                    }
                    i8++;
                }
                int i9 = i2 - i7;
                int i10 = i;
                boolean z3 = false;
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (z3) {
                        i3 = 46;
                        z2 = false;
                    } else {
                        byte b2 = bArr2[i10][i11];
                        byte[] bArr3 = C12272c.f25397a;
                        int i13 = b2 & 255;
                        z2 = z3;
                        i3 = i13;
                    }
                    byte b3 = bArr[i7 + i12];
                    byte[] bArr4 = C12272c.f25397a;
                    i4 = i3 - (b3 & 255);
                    if (i4 != 0) {
                        break;
                    }
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length != i11) {
                        z3 = z2;
                    } else {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z3 = true;
                        i11 = -1;
                    }
                }
                if (i4 >= 0) {
                    if (i4 <= 0) {
                        int i14 = i9 - i12;
                        int length2 = bArr2[i10].length - i11;
                        int length3 = bArr2.length;
                        for (int i15 = i10 + 1; i15 < length3; i15++) {
                            length2 += bArr2[i15].length;
                        }
                        if (length2 >= i14) {
                            if (length2 <= i14) {
                                Charset charset = StandardCharsets.UTF_8;
                                C12238m.checkExpressionValueIsNotNull(charset, "UTF_8");
                                return new String(bArr, i7, i9, charset);
                            }
                        }
                    }
                    i5 = i2 + 1;
                }
                length = i7 - 1;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m11002a(String str) {
        String strM11005a;
        String str2;
        String strM11005a2;
        List<String> listEmptyList;
        List<String> listEmptyList2;
        int size;
        int size2;
        C12238m.checkParameterIsNotNull(str, "domain");
        String unicode = IDN.toUnicode(str);
        C12238m.checkExpressionValueIsNotNull(unicode, "unicodeDomain");
        List<String> listM11004c = m11004c(unicode);
        if (this.f27588e.get() || !this.f27588e.compareAndSet(false, true)) {
            try {
                this.f27589f.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z2 = false;
            while (true) {
                try {
                    try {
                        m11003b();
                        if (!z2) {
                            break;
                        }
                        Thread.currentThread().interrupt();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z2 = true;
                    } catch (IOException e) {
                        C12333h.a aVar = C12333h.f25785c;
                        C12333h.f25783a.m10330i("Failed to read public suffix list", 5, e);
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
        if (!(this.f27590g != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size3 = listM11004c.size();
        byte[][] bArr = new byte[size3][];
        for (int i = 0; i < size3; i++) {
            String str3 = listM11004c.get(i);
            Charset charset = StandardCharsets.UTF_8;
            C12238m.checkExpressionValueIsNotNull(charset, "UTF_8");
            if (str3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str3.getBytes(charset);
            C12238m.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            bArr[i] = bytes;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= size3) {
                strM11005a = null;
                break;
            }
            C12940a c12940a = f27587d;
            byte[] bArr2 = this.f27590g;
            if (bArr2 == null) {
                C12238m.throwUninitializedPropertyAccessException("publicSuffixListBytes");
            }
            strM11005a = C12940a.m11005a(c12940a, bArr2, bArr, i2);
            if (strM11005a != null) {
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
            bArr3[i3] = f27584a;
            C12940a c12940a2 = f27587d;
            byte[] bArr4 = this.f27590g;
            if (bArr4 == null) {
                C12238m.throwUninitializedPropertyAccessException("publicSuffixListBytes");
            }
            String strM11005a3 = C12940a.m11005a(c12940a2, bArr4, bArr3, i3);
            if (strM11005a3 != null) {
                str2 = strM11005a3;
                break;
            }
            i3++;
        }
        if (str2 == null) {
            strM11005a2 = null;
            break;
        }
        int i4 = size3 - 1;
        int i5 = 0;
        while (true) {
            if (i5 >= i4) {
                strM11005a2 = null;
                break;
            }
            C12940a c12940a3 = f27587d;
            byte[] bArr5 = this.f27591h;
            if (bArr5 == null) {
                C12238m.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
            }
            strM11005a2 = C12940a.m11005a(c12940a3, bArr5, bArr, i5);
            if (strM11005a2 != null) {
                break;
            }
            i5++;
        }
        if (strM11005a2 != null) {
            listEmptyList2 = C12106w.split$default((CharSequence) ('!' + strM11005a2), new char[]{'.'}, false, 0, 6, (Object) null);
        } else if (strM11005a == null && str2 == null) {
            listEmptyList2 = f27585b;
        } else {
            if (strM11005a == null || (listEmptyList = C12106w.split$default((CharSequence) strM11005a, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                listEmptyList = C12147n.emptyList();
            }
            if (str2 == null || (listEmptyList2 = C12106w.split$default((CharSequence) str2, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                listEmptyList2 = C12147n.emptyList();
            }
            if (listEmptyList.size() > listEmptyList2.size()) {
                listEmptyList2 = listEmptyList;
            }
        }
        if (listM11004c.size() == listEmptyList2.size() && listEmptyList2.get(0).charAt(0) != '!') {
            return null;
        }
        if (listEmptyList2.get(0).charAt(0) == '!') {
            size = listM11004c.size();
            size2 = listEmptyList2.size();
        } else {
            size = listM11004c.size();
            size2 = listEmptyList2.size() + 1;
        }
        return C12078q.joinToString$default(C12078q.drop(C12163u.asSequence(m11004c(str)), size - size2), ".", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0048 A[Catch: all -> 0x0054, TryCatch #0 {, blocks: (B:9:0x0041, B:10:0x0044, B:12:0x0048, B:13:0x004b), top: B:26:0x0041 }] */
    /* JADX INFO: renamed from: b */
    public final void m11003b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            C12238m.checkParameterIsNotNull(resourceAsStream, "$this$source");
            C12395l c12395l = new C12395l(new C12397n(resourceAsStream, new C12408y()));
            C12238m.checkParameterIsNotNull(c12395l, "$this$buffer");
            C12401r c12401r = new C12401r(c12395l);
            try {
                byte[] bArrMo10450Z = c12401r.mo10450Z(c12401r.readInt());
                byte[] bArrMo10450Z2 = c12401r.mo10450Z(c12401r.readInt());
                C12201b.closeFinally(c12401r, null);
                synchronized (this) {
                    if (bArrMo10450Z == null) {
                        C12238m.throwNpe();
                        this.f27590g = bArrMo10450Z;
                        if (bArrMo10450Z2 == null) {
                            C12238m.throwNpe();
                        }
                        this.f27591h = bArrMo10450Z2;
                    } else {
                        this.f27590g = bArrMo10450Z;
                        if (bArrMo10450Z2 == null) {
                            C12238m.throwNpe();
                        }
                        this.f27591h = bArrMo10450Z2;
                    }
                    throw th;
                }
                this.f27589f.countDown();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    C12201b.closeFinally(c12401r, th);
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final List<String> m11004c(String str) {
        List<String> listSplit$default = C12106w.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        return C12238m.areEqual((String) C12163u.last((List) listSplit$default), "") ? C12163u.dropLast(listSplit$default, 1) : listSplit$default;
    }
}
