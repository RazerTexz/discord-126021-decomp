package p007b.p109f.p161j.p175j;

import android.graphics.ColorSpace;
import android.media.ExifInterface;
import android.os.Build;
import android.util.Pair;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p115d.p122g.C1701h;
import p007b.p109f.p160i.C1831b;
import p007b.p109f.p160i.C1832c;
import p007b.p109f.p160i.C1833d;
import p007b.p109f.p161j.p169d.C1880a;
import p007b.p109f.p186k.C2038a;
import p007b.p109f.p186k.C2039b;
import p007b.p109f.p186k.C2040c;

/* JADX INFO: renamed from: b.f.j.j.e */
/* JADX INFO: compiled from: EncodedImage.java */
/* JADX INFO: loaded from: classes.dex */
public class C1919e implements Closeable {

    /* JADX INFO: renamed from: j */
    public final CloseableReference<PooledByteBuffer> f3891j;

    /* JADX INFO: renamed from: k */
    public final Supplier<FileInputStream> f3892k;

    /* JADX INFO: renamed from: l */
    public C1832c f3893l;

    /* JADX INFO: renamed from: m */
    public int f3894m;

    /* JADX INFO: renamed from: n */
    public int f3895n;

    /* JADX INFO: renamed from: o */
    public int f3896o;

    /* JADX INFO: renamed from: p */
    public int f3897p;

    /* JADX INFO: renamed from: q */
    public int f3898q;

    /* JADX INFO: renamed from: r */
    public int f3899r;

    /* JADX INFO: renamed from: s */
    public C1880a f3900s;

    /* JADX INFO: renamed from: t */
    public ColorSpace f3901t;

    /* JADX INFO: renamed from: u */
    public boolean f3902u;

    public C1919e(CloseableReference<PooledByteBuffer> closeableReference) {
        this.f3893l = C1832c.f3597a;
        this.f3894m = -1;
        this.f3895n = 0;
        this.f3896o = -1;
        this.f3897p = -1;
        this.f3898q = 1;
        this.f3899r = -1;
        C1460d.m527i(Boolean.valueOf(CloseableReference.m8640y(closeableReference)));
        this.f3891j = closeableReference.clone();
        this.f3892k = null;
    }

    /* JADX INFO: renamed from: a */
    public static C1919e m1336a(C1919e c1919e) {
        C1919e c1919e2 = null;
        if (c1919e != null) {
            Supplier<FileInputStream> supplier = c1919e.f3892k;
            if (supplier != null) {
                c1919e2 = new C1919e(supplier, c1919e.f3899r);
            } else {
                CloseableReference closeableReferenceM8636n = CloseableReference.m8636n(c1919e.f3891j);
                if (closeableReferenceM8636n != null) {
                    try {
                        c1919e2 = new C1919e(closeableReferenceM8636n);
                    } catch (Throwable th) {
                        closeableReferenceM8636n.close();
                        throw th;
                    }
                }
                if (closeableReferenceM8636n != null) {
                    closeableReferenceM8636n.close();
                }
            }
            if (c1919e2 != null) {
                c1919e2.m1339b(c1919e);
            }
        }
        return c1919e2;
    }

    /* JADX INFO: renamed from: s */
    public static boolean m1337s(C1919e c1919e) {
        return c1919e.f3894m >= 0 && c1919e.f3896o >= 0 && c1919e.f3897p >= 0;
    }

    /* JADX INFO: renamed from: u */
    public static boolean m1338u(C1919e c1919e) {
        return c1919e != null && c1919e.m1346t();
    }

    /* JADX INFO: renamed from: b */
    public void m1339b(C1919e c1919e) {
        c1919e.m1347x();
        this.f3893l = c1919e.f3893l;
        c1919e.m1347x();
        this.f3896o = c1919e.f3896o;
        c1919e.m1347x();
        this.f3897p = c1919e.f3897p;
        c1919e.m1347x();
        this.f3894m = c1919e.f3894m;
        c1919e.m1347x();
        this.f3895n = c1919e.f3895n;
        this.f3898q = c1919e.f3898q;
        this.f3899r = c1919e.m1344n();
        this.f3900s = c1919e.f3900s;
        c1919e.m1347x();
        this.f3901t = c1919e.f3901t;
        this.f3902u = c1919e.f3902u;
    }

    /* JADX INFO: renamed from: c */
    public CloseableReference<PooledByteBuffer> m1340c() {
        return CloseableReference.m8636n(this.f3891j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference<PooledByteBuffer> closeableReference = this.f3891j;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    /* JADX INFO: renamed from: d */
    public String m1341d(int i) {
        CloseableReference<PooledByteBuffer> closeableReferenceM1340c = m1340c();
        if (closeableReferenceM1340c == null) {
            return "";
        }
        int iMin = Math.min(m1344n(), i);
        byte[] bArr = new byte[iMin];
        try {
            closeableReferenceM1340c.m8642u().mo1396i(0, bArr, 0, iMin);
            closeableReferenceM1340c.close();
            StringBuilder sb = new StringBuilder(iMin * 2);
            for (int i2 = 0; i2 < iMin; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } catch (Throwable th) {
            closeableReferenceM1340c.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: e */
    public InputStream m1342e() {
        Supplier<FileInputStream> supplier = this.f3892k;
        if (supplier != null) {
            return supplier.get();
        }
        CloseableReference closeableReferenceM8636n = CloseableReference.m8636n(this.f3891j);
        if (closeableReferenceM8636n == null) {
            return null;
        }
        try {
            return new C1701h((PooledByteBuffer) closeableReferenceM8636n.m8642u());
        } finally {
            closeableReferenceM8636n.close();
        }
    }

    /* JADX INFO: renamed from: f */
    public InputStream m1343f() {
        InputStream inputStreamM1342e = m1342e();
        Objects.requireNonNull(inputStreamM1342e);
        return inputStreamM1342e;
    }

    /* JADX INFO: renamed from: n */
    public int m1344n() {
        CloseableReference<PooledByteBuffer> closeableReference = this.f3891j;
        if (closeableReference == null) {
            return this.f3899r;
        }
        closeableReference.m8642u();
        return this.f3891j.m8642u().size();
    }

    /* JADX WARN: Code duplicated, block: B:116:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:117:0x01ac A[Catch: IOException -> 0x01e5, TryCatch #5 {IOException -> 0x01e5, blocks: (B:63:0x010a, B:64:0x010d, B:68:0x011a, B:84:0x0142, B:86:0x014a, B:110:0x019a, B:114:0x01a0, B:130:0x01d2, B:133:0x01da, B:136:0x01e1, B:117:0x01ac, B:118:0x01b2, B:122:0x01ba, B:125:0x01c3, B:96:0x016a, B:100:0x017a, B:105:0x0188, B:107:0x0190, B:109:0x0194, B:81:0x0135), top: B:169:0x010a }] */
    /* JADX WARN: Code duplicated, block: B:129:0x01d1 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:130:0x01d2 A[Catch: IOException -> 0x01e5, TryCatch #5 {IOException -> 0x01e5, blocks: (B:63:0x010a, B:64:0x010d, B:68:0x011a, B:84:0x0142, B:86:0x014a, B:110:0x019a, B:114:0x01a0, B:130:0x01d2, B:133:0x01da, B:136:0x01e1, B:117:0x01ac, B:118:0x01b2, B:122:0x01ba, B:125:0x01c3, B:96:0x016a, B:100:0x017a, B:105:0x0188, B:107:0x0190, B:109:0x0194, B:81:0x0135), top: B:169:0x010a }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:90:0x015e  */
    /* JADX INFO: renamed from: q */
    public final void m1345q() {
        boolean z2;
        int i;
        boolean z3;
        int iM446J1;
        int i2;
        int i3;
        int i4;
        int iM446J2;
        int i5;
        int i6;
        int iM446J3;
        C1832c c1832cM1174b = C1833d.m1174b(m1342e());
        this.f3893l = c1832cM1174b;
        int attributeInt = 0;
        InputStream inputStreamM1342e = null;
        pairM433F0 = null;
        pairM433F0 = null;
        pairM433F0 = null;
        pairM433F0 = null;
        Pair<Integer, Integer> pairM433F0 = null;
        if (C1831b.m1172a(c1832cM1174b) || c1832cM1174b == C1831b.f3594j) {
            InputStream inputStreamM1342e2 = m1342e();
            byte[] bArr = new byte[4];
            try {
                try {
                    inputStreamM1342e2.read(bArr);
                    try {
                        if (C1460d.m441I(bArr, "RIFF")) {
                            C1460d.m584w0(inputStreamM1342e2);
                            inputStreamM1342e2.read(bArr);
                            if (C1460d.m441I(bArr, "WEBP")) {
                                inputStreamM1342e2.read(bArr);
                                StringBuilder sb = new StringBuilder();
                                for (int i7 = 0; i7 < 4; i7++) {
                                    sb.append((char) bArr[i7]);
                                }
                                String string = sb.toString();
                                if ("VP8 ".equals(string)) {
                                    pairM433F0 = C1460d.m430E0(inputStreamM1342e2);
                                } else if ("VP8L".equals(string)) {
                                    pairM433F0 = C1460d.m433F0(inputStreamM1342e2);
                                } else {
                                    if ("VP8X".equals(string)) {
                                        inputStreamM1342e2.skip(8L);
                                        Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(C1460d.m428D1(inputStreamM1342e2) + 1), Integer.valueOf(C1460d.m428D1(inputStreamM1342e2) + 1));
                                        try {
                                            inputStreamM1342e2.close();
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        pairM433F0 = pair;
                                    }
                                    if (pairM433F0 != null) {
                                        this.f3896o = ((Integer) pairM433F0.first).intValue();
                                        this.f3897p = ((Integer) pairM433F0.second).intValue();
                                    }
                                }
                            }
                        }
                        inputStreamM1342e2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    if (inputStreamM1342e2 != null) {
                        try {
                            inputStreamM1342e2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                if (inputStreamM1342e2 != null) {
                }
                if (pairM433F0 != null) {
                    this.f3896o = ((Integer) pairM433F0.first).intValue();
                    this.f3897p = ((Integer) pairM433F0.second).intValue();
                }
            }
            if (pairM433F0 != null) {
                this.f3896o = ((Integer) pairM433F0.first).intValue();
                this.f3897p = ((Integer) pairM433F0.second).intValue();
            }
        } else {
            try {
                inputStreamM1342e = m1342e();
                C2039b c2039bM1538a = C2038a.m1538a(inputStreamM1342e);
                this.f3901t = c2039bM1538a.f4278b;
                Pair<Integer, Integer> pair2 = c2039bM1538a.f4277a;
                if (pair2 != null) {
                    this.f3896o = ((Integer) pair2.first).intValue();
                    this.f3897p = ((Integer) pair2.second).intValue();
                }
                try {
                    inputStreamM1342e.close();
                } catch (IOException unused) {
                }
                pairM433F0 = c2039bM1538a.f4277a;
            } catch (Throwable th2) {
                if (inputStreamM1342e != null) {
                    try {
                        inputStreamM1342e.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th2;
            }
        }
        if (c1832cM1174b != C1831b.f3585a || this.f3894m != -1) {
            if (c1832cM1174b != C1831b.f3595k || this.f3894m != -1) {
                if (this.f3894m == -1) {
                    this.f3894m = 0;
                    return;
                }
                return;
            }
            InputStream inputStreamM1342e3 = m1342e();
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    attributeInt = new ExifInterface(inputStreamM1342e3).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                } catch (IOException unused3) {
                    int i8 = C1691a.f3102a;
                }
            } else {
                int i9 = C1691a.f3102a;
            }
            this.f3895n = attributeInt;
            this.f3894m = C1460d.m568s0(attributeInt);
            return;
        }
        if (pairM433F0 != null) {
            InputStream inputStreamM1342e4 = m1342e();
            try {
                Objects.requireNonNull(inputStreamM1342e4);
                while (true) {
                    if (C1460d.m446J1(inputStreamM1342e4, 1, false) == 255) {
                        int iM446J4 = 255;
                        while (iM446J4 == 255) {
                            iM446J4 = C1460d.m446J1(inputStreamM1342e4, 1, false);
                        }
                        if (iM446J4 == 225) {
                            z2 = true;
                            break;
                        } else if (iM446J4 != 216 && iM446J4 != 1) {
                            if (iM446J4 != 217 && iM446J4 != 218) {
                                inputStreamM1342e4.skip(C1460d.m446J1(inputStreamM1342e4, 2, false) - 2);
                            }
                        }
                    }
                    z2 = false;
                    break;
                }
                if (!z2 || (iM446J3 = C1460d.m446J1(inputStreamM1342e4, 2, false) - 2) <= 6) {
                    i = 0;
                } else {
                    int iM446J5 = C1460d.m446J1(inputStreamM1342e4, 4, false);
                    int iM446J6 = C1460d.m446J1(inputStreamM1342e4, 2, false);
                    i = (iM446J3 - 4) - 2;
                    if (iM446J5 != 1165519206 || iM446J6 != 0) {
                        i = 0;
                    }
                }
                if (i != 0) {
                    if (i > 8) {
                        int iM446J7 = C1460d.m446J1(inputStreamM1342e4, 4, false);
                        int i10 = i - 4;
                        if (iM446J7 == 1229531648 || iM446J7 == 1296891946) {
                            z3 = iM446J7 == 1229531648;
                            iM446J1 = C1460d.m446J1(inputStreamM1342e4, 4, z3);
                            i2 = i10 - 4;
                            if (iM446J1 < 8 || iM446J1 - 8 > i2) {
                                C1691a.m973a(C2040c.class, "Invalid offset");
                                i2 = 0;
                            }
                        } else {
                            C1691a.m973a(C2040c.class, "Invalid TIFF header");
                        }
                        i3 = iM446J1 - 8;
                        if (i2 != 0 && i3 <= i2) {
                            inputStreamM1342e4.skip(i3);
                            i4 = i2 - i3;
                            if (i4 < 14) {
                                iM446J2 = C1460d.m446J1(inputStreamM1342e4, 2, z3);
                                i5 = i4 - 2;
                                while (true) {
                                    int i11 = iM446J2 - 1;
                                    if (iM446J2 <= 0 && i5 >= 12) {
                                        i6 = i5 - 2;
                                        if (C1460d.m446J1(inputStreamM1342e4, 2, z3) == 274) {
                                            break;
                                        }
                                        inputStreamM1342e4.skip(10L);
                                        i5 = i6 - 10;
                                        iM446J2 = i11;
                                    }
                                }
                                if (i6 >= 10 && C1460d.m446J1(inputStreamM1342e4, 2, z3) == 3 && C1460d.m446J1(inputStreamM1342e4, 4, z3) == 1) {
                                    attributeInt = C1460d.m446J1(inputStreamM1342e4, 2, z3);
                                }
                            }
                            i6 = 0;
                            if (i6 >= 10) {
                                attributeInt = C1460d.m446J1(inputStreamM1342e4, 2, z3);
                            }
                        }
                    }
                    i2 = 0;
                    z3 = false;
                    iM446J1 = 0;
                    i3 = iM446J1 - 8;
                    if (i2 != 0) {
                        inputStreamM1342e4.skip(i3);
                        i4 = i2 - i3;
                        if (i4 < 14) {
                            iM446J2 = C1460d.m446J1(inputStreamM1342e4, 2, z3);
                            i5 = i4 - 2;
                            while (true) {
                                int i12 = iM446J2 - 1;
                                if (iM446J2 <= 0) {
                                }
                                inputStreamM1342e4.skip(10L);
                                i5 = i6 - 10;
                                iM446J2 = i12;
                            }
                            if (i6 >= 10) {
                                attributeInt = C1460d.m446J1(inputStreamM1342e4, 2, z3);
                            }
                        }
                        i6 = 0;
                        if (i6 >= 10) {
                            attributeInt = C1460d.m446J1(inputStreamM1342e4, 2, z3);
                        }
                    }
                }
            } catch (IOException unused4) {
            }
            this.f3895n = attributeInt;
            this.f3894m = C1460d.m568s0(attributeInt);
        }
    }

    /* JADX INFO: renamed from: t */
    public synchronized boolean m1346t() {
        return CloseableReference.m8640y(this.f3891j) || this.f3892k != null;
    }

    /* JADX INFO: renamed from: x */
    public final void m1347x() {
        if (this.f3896o < 0 || this.f3897p < 0) {
            m1345q();
        }
    }

    public C1919e(Supplier<FileInputStream> supplier, int i) {
        this.f3893l = C1832c.f3597a;
        this.f3894m = -1;
        this.f3895n = 0;
        this.f3896o = -1;
        this.f3897p = -1;
        this.f3898q = 1;
        this.f3899r = -1;
        Objects.requireNonNull(supplier);
        this.f3891j = null;
        this.f3892k = supplier;
        this.f3899r = i;
    }
}
