package okhttp3.internal.publicsuffix;

import d0.f0._Sequences2;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import f0.e0.k.Platform2;
import g0.GzipSource;
import g0.JvmOkio;
import g0.RealBufferedSource;
import g0.Timeout2;
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

/* JADX INFO: compiled from: PublicSuffixDatabase.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PublicSuffixDatabase {
    public final AtomicBoolean e = new AtomicBoolean(false);
    public final CountDownLatch f = new CountDownLatch(1);
    public byte[] g;
    public byte[] h;
    public static final a d = new a(null);
    public static final byte[] a = {(byte) 42};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f3817b = CollectionsJVM.listOf("*");
    public static final PublicSuffixDatabase c = new PublicSuffixDatabase();

    /* JADX INFO: compiled from: PublicSuffixDatabase.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final String a(a aVar, byte[] bArr, byte[][] bArr2, int i) {
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
                        byte[] bArr3 = Util7.a;
                        int i13 = b2 & 255;
                        z2 = z3;
                        i3 = i13;
                    }
                    byte b3 = bArr[i7 + i12];
                    byte[] bArr4 = Util7.a;
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
                                Intrinsics3.checkExpressionValueIsNotNull(charset, "UTF_8");
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

    public final String a(String str) {
        String strA;
        String str2;
        String strA2;
        List<String> listEmptyList;
        List<String> listEmptyList2;
        int size;
        int size2;
        Intrinsics3.checkParameterIsNotNull(str, "domain");
        String unicode = IDN.toUnicode(str);
        Intrinsics3.checkExpressionValueIsNotNull(unicode, "unicodeDomain");
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
                        Platform2.a aVar = Platform2.c;
                        Platform2.a.i("Failed to read public suffix list", 5, e);
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
            Intrinsics3.checkExpressionValueIsNotNull(charset, "UTF_8");
            if (str3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str3.getBytes(charset);
            Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            bArr[i] = bytes;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= size3) {
                strA = null;
                break;
            }
            a aVar2 = d;
            byte[] bArr2 = this.g;
            if (bArr2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("publicSuffixListBytes");
            }
            strA = a.a(aVar2, bArr2, bArr, i2);
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
            a aVar3 = d;
            byte[] bArr4 = this.g;
            if (bArr4 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("publicSuffixListBytes");
            }
            String strA3 = a.a(aVar3, bArr4, bArr3, i3);
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
            a aVar4 = d;
            byte[] bArr5 = this.h;
            if (bArr5 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
            }
            strA2 = a.a(aVar4, bArr5, bArr, i5);
            if (strA2 != null) {
                break;
            }
            i5++;
        }
        if (strA2 != null) {
            listEmptyList2 = Strings4.split$default((CharSequence) ('!' + strA2), new char[]{'.'}, false, 0, 6, (Object) null);
        } else if (strA == null && str2 == null) {
            listEmptyList2 = f3817b;
        } else {
            if (strA == null || (listEmptyList = Strings4.split$default((CharSequence) strA, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                listEmptyList = Collections2.emptyList();
            }
            if (str2 == null || (listEmptyList2 = Strings4.split$default((CharSequence) str2, new char[]{'.'}, false, 0, 6, (Object) null)) == null) {
                listEmptyList2 = Collections2.emptyList();
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
        return _Sequences2.joinToString$default(_Sequences2.drop(_Collections.asSequence(c(str)), size - size2), ".", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0048 A[Catch: all -> 0x0054, TryCatch #0 {, blocks: (B:9:0x0041, B:10:0x0044, B:12:0x0048, B:13:0x004b), top: B:26:0x0041 }] */
    public final void b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            Intrinsics3.checkParameterIsNotNull(resourceAsStream, "$this$source");
            GzipSource gzipSource = new GzipSource(new JvmOkio(resourceAsStream, new Timeout2()));
            Intrinsics3.checkParameterIsNotNull(gzipSource, "$this$buffer");
            RealBufferedSource realBufferedSource = new RealBufferedSource(gzipSource);
            try {
                byte[] bArrZ = realBufferedSource.Z(realBufferedSource.readInt());
                byte[] bArrZ2 = realBufferedSource.Z(realBufferedSource.readInt());
                Closeable.closeFinally(realBufferedSource, null);
                synchronized (this) {
                    if (bArrZ == null) {
                        Intrinsics3.throwNpe();
                        this.g = bArrZ;
                        if (bArrZ2 == null) {
                            Intrinsics3.throwNpe();
                        }
                        this.h = bArrZ2;
                    } else {
                        this.g = bArrZ;
                        if (bArrZ2 == null) {
                            Intrinsics3.throwNpe();
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
                    Closeable.closeFinally(realBufferedSource, th);
                    throw th2;
                }
            }
        }
    }

    public final List<String> c(String str) {
        List<String> listSplit$default = Strings4.split$default((CharSequence) str, new char[]{'.'}, false, 0, 6, (Object) null);
        return Intrinsics3.areEqual((String) _Collections.last((List) listSplit$default), "") ? _Collections.dropLast(listSplit$default, 1) : listSplit$default;
    }
}
