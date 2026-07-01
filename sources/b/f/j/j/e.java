package b.f.j.j;

import android.graphics.ColorSpace;
import android.media.ExifInterface;
import android.os.Build$VERSION;
import android.util.Pair;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: EncodedImage.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Closeable {
    public final CloseableReference<PooledByteBuffer> j;
    public final Supplier<FileInputStream> k;
    public b.f.i.c l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b.f.j.d.a f590s;
    public ColorSpace t;
    public boolean u;

    public e(CloseableReference<PooledByteBuffer> closeableReference) {
        this.l = b.f.i.c.a;
        this.m = -1;
        this.n = 0;
        this.o = -1;
        this.p = -1;
        this.q = 1;
        this.r = -1;
        b.c.a.a0.d.i(Boolean.valueOf(CloseableReference.y(closeableReference)));
        this.j = closeableReference.b();
        this.k = null;
    }

    public static e a(e eVar) {
        e eVar2 = null;
        if (eVar != null) {
            Supplier<FileInputStream> supplier = eVar.k;
            if (supplier != null) {
                eVar2 = new e(supplier, eVar.r);
            } else {
                CloseableReference closeableReferenceN = CloseableReference.n(eVar.j);
                if (closeableReferenceN != null) {
                    try {
                        eVar2 = new e(closeableReferenceN);
                    } catch (Throwable th) {
                        closeableReferenceN.close();
                        throw th;
                    }
                }
                if (closeableReferenceN != null) {
                    closeableReferenceN.close();
                }
            }
            if (eVar2 != null) {
                eVar2.b(eVar);
            }
        }
        return eVar2;
    }

    public static boolean s(e eVar) {
        return eVar.m >= 0 && eVar.o >= 0 && eVar.p >= 0;
    }

    public static boolean u(e eVar) {
        return eVar != null && eVar.t();
    }

    public void b(e eVar) {
        eVar.x();
        this.l = eVar.l;
        eVar.x();
        this.o = eVar.o;
        eVar.x();
        this.p = eVar.p;
        eVar.x();
        this.m = eVar.m;
        eVar.x();
        this.n = eVar.n;
        this.q = eVar.q;
        this.r = eVar.n();
        this.f590s = eVar.f590s;
        eVar.x();
        this.t = eVar.t;
        this.u = eVar.u;
    }

    public CloseableReference<PooledByteBuffer> c() {
        return CloseableReference.n(this.j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference<PooledByteBuffer> closeableReference = this.j;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public String d(int i) {
        CloseableReference<PooledByteBuffer> closeableReferenceC = c();
        if (closeableReferenceC == null) {
            return "";
        }
        int iMin = Math.min(n(), i);
        byte[] bArr = new byte[iMin];
        try {
            closeableReferenceC.u().i(0, bArr, 0, iMin);
            closeableReferenceC.close();
            StringBuilder sb = new StringBuilder(iMin * 2);
            for (int i2 = 0; i2 < iMin; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } catch (Throwable th) {
            closeableReferenceC.close();
            throw th;
        }
    }

    public InputStream e() {
        Supplier<FileInputStream> supplier = this.k;
        if (supplier != null) {
            return supplier.get();
        }
        CloseableReference closeableReferenceN = CloseableReference.n(this.j);
        if (closeableReferenceN == null) {
            return null;
        }
        try {
            return new b.f.d.g.h((PooledByteBuffer) closeableReferenceN.u());
        } finally {
            closeableReferenceN.close();
        }
    }

    public InputStream f() {
        InputStream inputStreamE = e();
        Objects.requireNonNull(inputStreamE);
        return inputStreamE;
    }

    public int n() {
        CloseableReference<PooledByteBuffer> closeableReference = this.j;
        if (closeableReference == null) {
            return this.r;
        }
        closeableReference.u();
        return this.j.u().size();
    }

    /* JADX WARN: Code duplicated, block: B:116:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:117:0x01ac A[Catch: IOException -> 0x01e5, TryCatch #5 {IOException -> 0x01e5, blocks: (B:63:0x010a, B:64:0x010d, B:68:0x011a, B:84:0x0142, B:86:0x014a, B:110:0x019a, B:114:0x01a0, B:130:0x01d2, B:133:0x01da, B:136:0x01e1, B:117:0x01ac, B:118:0x01b2, B:122:0x01ba, B:125:0x01c3, B:96:0x016a, B:100:0x017a, B:105:0x0188, B:107:0x0190, B:109:0x0194, B:81:0x0135), top: B:169:0x010a }] */
    /* JADX WARN: Code duplicated, block: B:129:0x01d1 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:130:0x01d2 A[Catch: IOException -> 0x01e5, TryCatch #5 {IOException -> 0x01e5, blocks: (B:63:0x010a, B:64:0x010d, B:68:0x011a, B:84:0x0142, B:86:0x014a, B:110:0x019a, B:114:0x01a0, B:130:0x01d2, B:133:0x01da, B:136:0x01e1, B:117:0x01ac, B:118:0x01b2, B:122:0x01ba, B:125:0x01c3, B:96:0x016a, B:100:0x017a, B:105:0x0188, B:107:0x0190, B:109:0x0194, B:81:0x0135), top: B:169:0x010a }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:90:0x015e  */
    public final void q() {
        boolean z2;
        int i;
        boolean z3;
        int iJ1;
        int i2;
        int i3;
        int i4;
        int iJ2;
        int i5;
        int i6;
        int iJ3;
        b.f.i.c cVarB = b.f.i.d.b(e());
        this.l = cVarB;
        int attributeInt = 0;
        InputStream inputStreamE = null;
        pairF0 = null;
        pairF0 = null;
        pairF0 = null;
        pairF0 = null;
        Pair<Integer, Integer> pairF0 = null;
        if (b.f.i.b.a(cVarB) || cVarB == b.f.i.b.j) {
            InputStream inputStreamE2 = e();
            byte[] bArr = new byte[4];
            try {
                try {
                    inputStreamE2.read(bArr);
                    try {
                        if (b.c.a.a0.d.I(bArr, "RIFF")) {
                            b.c.a.a0.d.w0(inputStreamE2);
                            inputStreamE2.read(bArr);
                            if (b.c.a.a0.d.I(bArr, "WEBP")) {
                                inputStreamE2.read(bArr);
                                StringBuilder sb = new StringBuilder();
                                for (int i7 = 0; i7 < 4; i7++) {
                                    sb.append((char) bArr[i7]);
                                }
                                String string = sb.toString();
                                if ("VP8 ".equals(string)) {
                                    pairF0 = b.c.a.a0.d.E0(inputStreamE2);
                                } else if ("VP8L".equals(string)) {
                                    pairF0 = b.c.a.a0.d.F0(inputStreamE2);
                                } else {
                                    if ("VP8X".equals(string)) {
                                        inputStreamE2.skip(8L);
                                        Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(b.c.a.a0.d.D1(inputStreamE2) + 1), Integer.valueOf(b.c.a.a0.d.D1(inputStreamE2) + 1));
                                        try {
                                            inputStreamE2.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        pairF0 = pair;
                                    }
                                    if (pairF0 != null) {
                                        this.o = ((Integer) pairF0.first).intValue();
                                        this.p = ((Integer) pairF0.second).intValue();
                                    }
                                }
                            }
                        }
                        inputStreamE2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    if (inputStreamE2 != null) {
                        try {
                            inputStreamE2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                if (inputStreamE2 != null) {
                }
                if (pairF0 != null) {
                    this.o = ((Integer) pairF0.first).intValue();
                    this.p = ((Integer) pairF0.second).intValue();
                }
            }
            if (pairF0 != null) {
                this.o = ((Integer) pairF0.first).intValue();
                this.p = ((Integer) pairF0.second).intValue();
            }
        } else {
            try {
                inputStreamE = e();
                b.f.k.b bVarA = b.f.k.a.a(inputStreamE);
                this.t = bVarA.f646b;
                Pair<Integer, Integer> pair2 = bVarA.a;
                if (pair2 != null) {
                    this.o = ((Integer) pair2.first).intValue();
                    this.p = ((Integer) pair2.second).intValue();
                }
                try {
                    inputStreamE.close();
                } catch (IOException unused) {
                }
                pairF0 = bVarA.a;
            } catch (Throwable th2) {
                if (inputStreamE != null) {
                    try {
                        inputStreamE.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th2;
            }
        }
        if (cVarB != b.f.i.b.a || this.m != -1) {
            if (cVarB != b.f.i.b.k || this.m != -1) {
                if (this.m == -1) {
                    this.m = 0;
                    return;
                }
                return;
            }
            InputStream inputStreamE3 = e();
            if (Build$VERSION.SDK_INT >= 24) {
                try {
                    attributeInt = new ExifInterface(inputStreamE3).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                } catch (IOException unused3) {
                    int i8 = b.f.d.e.a.a;
                }
            } else {
                int i9 = b.f.d.e.a.a;
            }
            this.n = attributeInt;
            this.m = b.c.a.a0.d.s0(attributeInt);
            return;
        }
        if (pairF0 != null) {
            InputStream inputStreamE4 = e();
            try {
                Objects.requireNonNull(inputStreamE4);
                while (true) {
                    if (b.c.a.a0.d.J1(inputStreamE4, 1, false) == 255) {
                        int iJ4 = 255;
                        while (iJ4 == 255) {
                            iJ4 = b.c.a.a0.d.J1(inputStreamE4, 1, false);
                        }
                        if (iJ4 == 225) {
                            z2 = true;
                            break;
                        } else if (iJ4 != 216 && iJ4 != 1) {
                            if (iJ4 != 217 && iJ4 != 218) {
                                inputStreamE4.skip(b.c.a.a0.d.J1(inputStreamE4, 2, false) - 2);
                            }
                        }
                    }
                    z2 = false;
                    break;
                }
                if (!z2 || (iJ3 = b.c.a.a0.d.J1(inputStreamE4, 2, false) - 2) <= 6) {
                    i = 0;
                } else {
                    int iJ5 = b.c.a.a0.d.J1(inputStreamE4, 4, false);
                    int iJ6 = b.c.a.a0.d.J1(inputStreamE4, 2, false);
                    i = (iJ3 - 4) - 2;
                    if (iJ5 != 1165519206 || iJ6 != 0) {
                        i = 0;
                    }
                }
                if (i != 0) {
                    if (i > 8) {
                        int iJ7 = b.c.a.a0.d.J1(inputStreamE4, 4, false);
                        int i10 = i - 4;
                        if (iJ7 == 1229531648 || iJ7 == 1296891946) {
                            z3 = iJ7 == 1229531648;
                            iJ1 = b.c.a.a0.d.J1(inputStreamE4, 4, z3);
                            i2 = i10 - 4;
                            if (iJ1 < 8 || iJ1 - 8 > i2) {
                                b.f.d.e.a.a(b.f.k.c.class, "Invalid offset");
                                i2 = 0;
                            }
                        } else {
                            b.f.d.e.a.a(b.f.k.c.class, "Invalid TIFF header");
                        }
                        i3 = iJ1 - 8;
                        if (i2 != 0 && i3 <= i2) {
                            inputStreamE4.skip(i3);
                            i4 = i2 - i3;
                            if (i4 < 14) {
                                iJ2 = b.c.a.a0.d.J1(inputStreamE4, 2, z3);
                                i5 = i4 - 2;
                                while (true) {
                                    int i11 = iJ2 - 1;
                                    if (iJ2 <= 0 && i5 >= 12) {
                                        i6 = i5 - 2;
                                        if (b.c.a.a0.d.J1(inputStreamE4, 2, z3) == 274) {
                                            break;
                                        }
                                        inputStreamE4.skip(10L);
                                        i5 = i6 - 10;
                                        iJ2 = i11;
                                    }
                                }
                                if (i6 >= 10 && b.c.a.a0.d.J1(inputStreamE4, 2, z3) == 3 && b.c.a.a0.d.J1(inputStreamE4, 4, z3) == 1) {
                                    attributeInt = b.c.a.a0.d.J1(inputStreamE4, 2, z3);
                                }
                            }
                            i6 = 0;
                            if (i6 >= 10) {
                                attributeInt = b.c.a.a0.d.J1(inputStreamE4, 2, z3);
                            }
                        }
                    }
                    i2 = 0;
                    z3 = false;
                    iJ1 = 0;
                    i3 = iJ1 - 8;
                    if (i2 != 0) {
                        inputStreamE4.skip(i3);
                        i4 = i2 - i3;
                        if (i4 < 14) {
                            iJ2 = b.c.a.a0.d.J1(inputStreamE4, 2, z3);
                            i5 = i4 - 2;
                            while (true) {
                                int i12 = iJ2 - 1;
                                if (iJ2 <= 0) {
                                }
                                inputStreamE4.skip(10L);
                                i5 = i6 - 10;
                                iJ2 = i12;
                            }
                            if (i6 >= 10) {
                                attributeInt = b.c.a.a0.d.J1(inputStreamE4, 2, z3);
                            }
                        }
                        i6 = 0;
                        if (i6 >= 10) {
                            attributeInt = b.c.a.a0.d.J1(inputStreamE4, 2, z3);
                        }
                    }
                }
            } catch (IOException unused4) {
            }
            this.n = attributeInt;
            this.m = b.c.a.a0.d.s0(attributeInt);
        }
    }

    public synchronized boolean t() {
        return CloseableReference.y(this.j) || this.k != null;
    }

    public final void x() {
        if (this.o < 0 || this.p < 0) {
            q();
        }
    }

    public e(Supplier<FileInputStream> supplier, int i) {
        this.l = b.f.i.c.a;
        this.m = -1;
        this.n = 0;
        this.o = -1;
        this.p = -1;
        this.q = 1;
        this.r = -1;
        Objects.requireNonNull(supplier);
        this.j = null;
        this.k = supplier;
        this.r = i;
    }
}
