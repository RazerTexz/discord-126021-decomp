package p007b.p225i.p226a.p242c.p245b3.p247o;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2756w;

/* JADX INFO: renamed from: b.i.a.c.b3.o.b */
/* JADX INFO: compiled from: DvbParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2597b {

    /* JADX INFO: renamed from: a */
    public static final byte[] f5916a = {0, 7, 8, 15};

    /* JADX INFO: renamed from: b */
    public static final byte[] f5917b = {0, 119, -120, -1};

    /* JADX INFO: renamed from: c */
    public static final byte[] f5918c = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* JADX INFO: renamed from: d */
    public final Paint f5919d;

    /* JADX INFO: renamed from: e */
    public final Paint f5920e;

    /* JADX INFO: renamed from: f */
    public final Canvas f5921f;

    /* JADX INFO: renamed from: g */
    public final b f5922g;

    /* JADX INFO: renamed from: h */
    public final a f5923h;

    /* JADX INFO: renamed from: i */
    public final h f5924i;

    /* JADX INFO: renamed from: j */
    public Bitmap f5925j;

    /* JADX INFO: renamed from: b.i.a.c.b3.o.b$a */
    /* JADX INFO: compiled from: DvbParser.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f5926a;

        /* JADX INFO: renamed from: b */
        public final int[] f5927b;

        /* JADX INFO: renamed from: c */
        public final int[] f5928c;

        /* JADX INFO: renamed from: d */
        public final int[] f5929d;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f5926a = i;
            this.f5927b = iArr;
            this.f5928c = iArr2;
            this.f5929d = iArr3;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.o.b$b */
    /* JADX INFO: compiled from: DvbParser.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f5930a;

        /* JADX INFO: renamed from: b */
        public final int f5931b;

        /* JADX INFO: renamed from: c */
        public final int f5932c;

        /* JADX INFO: renamed from: d */
        public final int f5933d;

        /* JADX INFO: renamed from: e */
        public final int f5934e;

        /* JADX INFO: renamed from: f */
        public final int f5935f;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f5930a = i;
            this.f5931b = i2;
            this.f5932c = i3;
            this.f5933d = i4;
            this.f5934e = i5;
            this.f5935f = i6;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.o.b$c */
    /* JADX INFO: compiled from: DvbParser.java */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final int f5936a;

        /* JADX INFO: renamed from: b */
        public final boolean f5937b;

        /* JADX INFO: renamed from: c */
        public final byte[] f5938c;

        /* JADX INFO: renamed from: d */
        public final byte[] f5939d;

        public c(int i, boolean z2, byte[] bArr, byte[] bArr2) {
            this.f5936a = i;
            this.f5937b = z2;
            this.f5938c = bArr;
            this.f5939d = bArr2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.o.b$d */
    /* JADX INFO: compiled from: DvbParser.java */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public final int f5940a;

        /* JADX INFO: renamed from: b */
        public final int f5941b;

        /* JADX INFO: renamed from: c */
        public final SparseArray<e> f5942c;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.f5940a = i2;
            this.f5941b = i3;
            this.f5942c = sparseArray;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.o.b$e */
    /* JADX INFO: compiled from: DvbParser.java */
    public static final class e {

        /* JADX INFO: renamed from: a */
        public final int f5943a;

        /* JADX INFO: renamed from: b */
        public final int f5944b;

        public e(int i, int i2) {
            this.f5943a = i;
            this.f5944b = i2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.o.b$f */
    /* JADX INFO: compiled from: DvbParser.java */
    public static final class f {

        /* JADX INFO: renamed from: a */
        public final int f5945a;

        /* JADX INFO: renamed from: b */
        public final boolean f5946b;

        /* JADX INFO: renamed from: c */
        public final int f5947c;

        /* JADX INFO: renamed from: d */
        public final int f5948d;

        /* JADX INFO: renamed from: e */
        public final int f5949e;

        /* JADX INFO: renamed from: f */
        public final int f5950f;

        /* JADX INFO: renamed from: g */
        public final int f5951g;

        /* JADX INFO: renamed from: h */
        public final int f5952h;

        /* JADX INFO: renamed from: i */
        public final int f5953i;

        /* JADX INFO: renamed from: j */
        public final SparseArray<g> f5954j;

        public f(int i, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.f5945a = i;
            this.f5946b = z2;
            this.f5947c = i2;
            this.f5948d = i3;
            this.f5949e = i5;
            this.f5950f = i6;
            this.f5951g = i7;
            this.f5952h = i8;
            this.f5953i = i9;
            this.f5954j = sparseArray;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.o.b$g */
    /* JADX INFO: compiled from: DvbParser.java */
    public static final class g {

        /* JADX INFO: renamed from: a */
        public final int f5955a;

        /* JADX INFO: renamed from: b */
        public final int f5956b;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f5955a = i3;
            this.f5956b = i4;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.o.b$h */
    /* JADX INFO: compiled from: DvbParser.java */
    public static final class h {

        /* JADX INFO: renamed from: a */
        public final int f5957a;

        /* JADX INFO: renamed from: b */
        public final int f5958b;

        /* JADX INFO: renamed from: c */
        public final SparseArray<f> f5959c = new SparseArray<>();

        /* JADX INFO: renamed from: d */
        public final SparseArray<a> f5960d = new SparseArray<>();

        /* JADX INFO: renamed from: e */
        public final SparseArray<c> f5961e = new SparseArray<>();

        /* JADX INFO: renamed from: f */
        public final SparseArray<a> f5962f = new SparseArray<>();

        /* JADX INFO: renamed from: g */
        public final SparseArray<c> f5963g = new SparseArray<>();

        /* JADX INFO: renamed from: h */
        @Nullable
        public b f5964h;

        /* JADX INFO: renamed from: i */
        @Nullable
        public d f5965i;

        public h(int i, int i2) {
            this.f5957a = i;
            this.f5958b = i2;
        }
    }

    public C2597b(int i, int i2) {
        Paint paint = new Paint();
        this.f5919d = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f5920e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f5921f = new Canvas();
        this.f5922g = new b(719, 575, 0, 719, 0, 575);
        this.f5923h = new a(0, new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505}, m2661b(), m2662c());
        this.f5924i = new h(i, i2);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m2660a(int i, int i2, C2756w c2756w) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) c2756w.m3067g(i2);
        }
        return bArr;
    }

    /* JADX INFO: renamed from: b */
    public static int[] m2661b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = m2663d(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i2 = i & 1;
                int i3 = Opcodes.LAND;
                int i4 = i2 != 0 ? Opcodes.LAND : 0;
                int i5 = (i & 2) != 0 ? Opcodes.LAND : 0;
                if ((i & 4) == 0) {
                    i3 = 0;
                }
                iArr[i] = m2663d(255, i4, i5, i3);
            }
        }
        return iArr;
    }

    /* JADX INFO: renamed from: c */
    public static int[] m2662c() {
        int i;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = m2663d(63, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
            } else {
                int i3 = i2 & Opcodes.L2I;
                int i4 = Opcodes.TABLESWITCH;
                if (i3 == 0) {
                    int i5 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? Opcodes.TABLESWITCH : 0);
                    int i6 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? Opcodes.TABLESWITCH : 0);
                    i = (i2 & 4) == 0 ? 0 : 85;
                    if ((i2 & 64) == 0) {
                        i4 = 0;
                    }
                    iArr[i2] = m2663d(255, i5, i6, i + i4);
                } else if (i3 == 8) {
                    int i7 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? Opcodes.TABLESWITCH : 0);
                    int i8 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? Opcodes.TABLESWITCH : 0);
                    i = (i2 & 4) == 0 ? 0 : 85;
                    if ((i2 & 64) == 0) {
                        i4 = 0;
                    }
                    iArr[i2] = m2663d(Opcodes.LAND, i7, i8, i + i4);
                } else if (i3 == 128) {
                    iArr[i2] = m2663d(255, ((i2 & 1) != 0 ? 43 : 0) + Opcodes.LAND + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + Opcodes.LAND + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + Opcodes.LAND + ((i2 & 64) == 0 ? 0 : 85));
                } else if (i3 == 136) {
                    iArr[i2] = m2663d(255, ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    /* JADX INFO: renamed from: d */
    public static int m2663d(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0194 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x0196 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0198  */
    /* JADX WARN: Code duplicated, block: B:103:0x019c  */
    /* JADX WARN: Code duplicated, block: B:104:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:106:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:107:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:114:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:118:0x020b A[LOOP:3: B:87:0x0163->B:118:0x020b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:142:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x016a  */
    /* JADX WARN: Code duplicated, block: B:92:0x0170  */
    /* JADX WARN: Code duplicated, block: B:93:0x017d  */
    /* JADX WARN: Code duplicated, block: B:95:0x0183  */
    /* JADX WARN: Code duplicated, block: B:96:0x0184 A[PHI: r1
      0x0184: PHI (r1v4 int) = (r1v3 int), (r1v22 int) binds: [B:88:0x0167, B:95:0x0183] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:97:0x018c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0192 A[DONT_INVERT] */
    /* JADX INFO: renamed from: e */
    public static void m2664e(byte[] bArr, int[] iArr, int i, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int i4;
        boolean z2;
        int iM3067g;
        boolean z3;
        int i5;
        int iM3067g2;
        int iM3067g3;
        int iM3067g4;
        boolean z4;
        int iM3067g5;
        int i6;
        int iM3067g6;
        boolean z5;
        int iM3067g7;
        C2756w c2756w = new C2756w(bArr);
        int i7 = i2;
        int i8 = i3;
        byte[] bArrM2660a = null;
        byte[] bArrM2660a2 = null;
        byte[] bArrM2660a3 = null;
        while (c2756w.m3062b() != 0) {
            int i9 = 8;
            int iM3067g8 = c2756w.m3067g(8);
            if (iM3067g8 != 240) {
                int i10 = 4;
                int i11 = 2;
                switch (iM3067g8) {
                    case 16:
                        if (i == 3) {
                            bArr3 = bArrM2660a == null ? f5917b : bArrM2660a;
                        } else {
                            if (i == 2) {
                                bArr3 = bArrM2660a3 == null ? f5916a : bArrM2660a3;
                            } else {
                                bArr2 = null;
                            }
                            i4 = i7;
                            z2 = false;
                            while (true) {
                                iM3067g = c2756w.m3067g(2);
                                if (iM3067g == 0) {
                                    if (c2756w.m3066f()) {
                                        iM3067g3 = c2756w.m3067g(3) + 3;
                                        iM3067g4 = c2756w.m3067g(2);
                                    } else if (c2756w.m3066f()) {
                                        iM3067g = 0;
                                        z3 = z2;
                                        i5 = 1;
                                    } else {
                                        iM3067g2 = c2756w.m3067g(2);
                                        if (iM3067g2 != 0) {
                                            z2 = true;
                                        } else if (iM3067g2 != 1) {
                                            z3 = z2;
                                            iM3067g = 0;
                                            i5 = 2;
                                        } else if (iM3067g2 != 2) {
                                            iM3067g3 = c2756w.m3067g(4) + 12;
                                            iM3067g4 = c2756w.m3067g(2);
                                        } else if (iM3067g2 != 3) {
                                            iM3067g3 = c2756w.m3067g(8) + 29;
                                            iM3067g4 = c2756w.m3067g(2);
                                        }
                                        z3 = z2;
                                        iM3067g = 0;
                                        i5 = 0;
                                    }
                                    i5 = iM3067g3;
                                    iM3067g = iM3067g4;
                                    z3 = z2;
                                } else {
                                    z3 = z2;
                                    i5 = 1;
                                }
                                if (i5 == 0 && paint != null) {
                                    if (bArr2 != 0) {
                                        iM3067g = bArr2[iM3067g];
                                    }
                                    paint.setColor(iArr[iM3067g]);
                                    canvas.drawRect(i4, i8, i4 + i5, i8 + 1, paint);
                                }
                                i4 += i5;
                                if (z3) {
                                    c2756w.m3063c();
                                    i7 = i4;
                                } else {
                                    z2 = z3;
                                }
                            }
                        }
                        bArr2 = bArr3;
                        i4 = i7;
                        z2 = false;
                        while (true) {
                            iM3067g = c2756w.m3067g(2);
                            if (iM3067g == 0) {
                                if (c2756w.m3066f()) {
                                    iM3067g3 = c2756w.m3067g(3) + 3;
                                    iM3067g4 = c2756w.m3067g(2);
                                } else if (c2756w.m3066f()) {
                                    iM3067g = 0;
                                    z3 = z2;
                                    i5 = 1;
                                } else {
                                    iM3067g2 = c2756w.m3067g(2);
                                    if (iM3067g2 != 0) {
                                        z2 = true;
                                    } else if (iM3067g2 != 1) {
                                        z3 = z2;
                                        iM3067g = 0;
                                        i5 = 2;
                                    } else if (iM3067g2 != 2) {
                                        iM3067g3 = c2756w.m3067g(4) + 12;
                                        iM3067g4 = c2756w.m3067g(2);
                                    } else if (iM3067g2 != 3) {
                                        iM3067g3 = c2756w.m3067g(8) + 29;
                                        iM3067g4 = c2756w.m3067g(2);
                                    }
                                    z3 = z2;
                                    iM3067g = 0;
                                    i5 = 0;
                                }
                                i5 = iM3067g3;
                                iM3067g = iM3067g4;
                                z3 = z2;
                            } else {
                                z3 = z2;
                                i5 = 1;
                            }
                            if (i5 == 0) {
                            }
                            i4 += i5;
                            if (z3) {
                                c2756w.m3063c();
                                i7 = i4;
                            } else {
                                z2 = z3;
                            }
                            break;
                        }
                        break;
                    case 17:
                        byte[] bArr4 = i == 3 ? bArrM2660a2 == null ? f5918c : bArrM2660a2 : null;
                        int i12 = i7;
                        boolean z6 = false;
                        while (true) {
                            int iM3067g9 = c2756w.m3067g(i10);
                            if (iM3067g9 != 0) {
                                z4 = z6;
                                iM3067g5 = iM3067g9;
                                i6 = 1;
                            } else if (c2756w.m3066f()) {
                                if (c2756w.m3066f()) {
                                    int iM3067g10 = c2756w.m3067g(i11);
                                    if (iM3067g10 == 0) {
                                        iM3067g9 = 0;
                                        z4 = z6;
                                        iM3067g5 = iM3067g9;
                                        i6 = 1;
                                    } else if (iM3067g10 == 1) {
                                        z4 = z6;
                                        iM3067g5 = 0;
                                        i6 = 2;
                                    } else if (iM3067g10 == i11) {
                                        iM3067g6 = c2756w.m3067g(i10) + 9;
                                        iM3067g5 = c2756w.m3067g(i10);
                                    } else if (iM3067g10 != 3) {
                                        z4 = z6;
                                        iM3067g5 = 0;
                                        i6 = 0;
                                    } else {
                                        iM3067g6 = c2756w.m3067g(i9) + 25;
                                        iM3067g5 = c2756w.m3067g(i10);
                                    }
                                } else {
                                    iM3067g6 = c2756w.m3067g(i11) + i10;
                                    iM3067g5 = c2756w.m3067g(i10);
                                }
                                z4 = z6;
                                i6 = iM3067g6;
                            } else {
                                int iM3067g11 = c2756w.m3067g(3);
                                if (iM3067g11 != 0) {
                                    z4 = z6;
                                    i6 = iM3067g11 + 2;
                                    iM3067g5 = 0;
                                } else {
                                    z6 = true;
                                    z4 = z6;
                                    iM3067g5 = 0;
                                    i6 = 0;
                                }
                            }
                            if (i6 != 0 && paint != null) {
                                if (bArr4 != 0) {
                                    iM3067g5 = bArr4[iM3067g5];
                                }
                                paint.setColor(iArr[iM3067g5]);
                                canvas.drawRect(i12, i8, i12 + i6, i8 + 1, paint);
                            }
                            i12 += i6;
                            if (z4) {
                                c2756w.m3063c();
                                i7 = i12;
                            } else {
                                z6 = z4;
                                i11 = 2;
                                i10 = 4;
                                i9 = 8;
                            }
                            break;
                        }
                        break;
                    case 18:
                        int i13 = i7;
                        boolean z7 = false;
                        while (true) {
                            int iM3067g12 = c2756w.m3067g(8);
                            if (iM3067g12 != 0) {
                                z5 = z7;
                                iM3067g7 = 1;
                            } else if (c2756w.m3066f()) {
                                z5 = z7;
                                iM3067g7 = c2756w.m3067g(7);
                                iM3067g12 = c2756w.m3067g(8);
                            } else {
                                int iM3067g13 = c2756w.m3067g(7);
                                if (iM3067g13 != 0) {
                                    z5 = z7;
                                    iM3067g7 = iM3067g13;
                                    iM3067g12 = 0;
                                } else {
                                    iM3067g12 = 0;
                                    z5 = true;
                                    iM3067g7 = 0;
                                }
                            }
                            if (iM3067g7 != 0 && paint != null) {
                                paint.setColor(iArr[iM3067g12]);
                                canvas.drawRect(i13, i8, i13 + iM3067g7, i8 + 1, paint);
                            }
                            i13 += iM3067g7;
                            if (z5) {
                                i7 = i13;
                            } else {
                                z7 = z5;
                            }
                            break;
                        }
                        break;
                    default:
                        switch (iM3067g8) {
                            case 32:
                                bArrM2660a3 = m2660a(4, 4, c2756w);
                                break;
                            case 33:
                                bArrM2660a = m2660a(4, 8, c2756w);
                                break;
                            case 34:
                                bArrM2660a2 = m2660a(16, 8, c2756w);
                                break;
                        }
                        break;
                }
            } else {
                i8 += 2;
                i7 = i2;
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public static a m2665f(C2756w c2756w, int i) {
        int[] iArr;
        int iM3067g;
        int iM3067g2;
        int iM3067g3;
        int iM3067g4;
        int i2 = 8;
        int iM3067g5 = c2756w.m3067g(8);
        c2756w.m3073m(8);
        int i3 = i - 2;
        int i4 = 4;
        int[] iArr2 = {0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
        int[] iArrM2661b = m2661b();
        int[] iArrM2662c = m2662c();
        while (i3 > 0) {
            int iM3067g6 = c2756w.m3067g(i2);
            int iM3067g7 = c2756w.m3067g(i2);
            int i5 = i3 - 2;
            if ((iM3067g7 & 128) != 0) {
                iArr = iArr2;
            } else {
                iArr = (iM3067g7 & 64) != 0 ? iArrM2661b : iArrM2662c;
            }
            if ((iM3067g7 & 1) != 0) {
                iM3067g3 = c2756w.m3067g(i2);
                iM3067g = c2756w.m3067g(i2);
                iM3067g4 = c2756w.m3067g(i2);
                iM3067g2 = c2756w.m3067g(i2);
                i3 = i5 - 4;
            } else {
                int iM3067g8 = c2756w.m3067g(6) << 2;
                int iM3067g9 = c2756w.m3067g(i4) << i4;
                int iM3067g10 = c2756w.m3067g(i4) << i4;
                i3 = i5 - 2;
                iM3067g = iM3067g9;
                iM3067g2 = c2756w.m3067g(2) << 6;
                iM3067g3 = iM3067g8;
                iM3067g4 = iM3067g10;
            }
            if (iM3067g3 == 0) {
                iM3067g = 0;
                iM3067g4 = 0;
                iM3067g2 = 255;
            }
            double d2 = iM3067g3;
            double d3 = iM3067g - 128;
            double d4 = iM3067g4 - 128;
            iArr[iM3067g6] = m2663d((byte) (255 - (iM3067g2 & 255)), C2738e0.m3000h((int) ((1.402d * d3) + d2), 0, 255), C2738e0.m3000h((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), C2738e0.m3000h((int) ((d4 * 1.772d) + d2), 0, 255));
            iArr2 = iArr2;
            iM3067g5 = iM3067g5;
            i2 = 8;
            i4 = 4;
        }
        return new a(iM3067g5, iArr2, iArrM2661b, iArrM2662c);
    }

    /* JADX INFO: renamed from: g */
    public static c m2666g(C2756w c2756w) {
        byte[] bArr;
        int iM3067g = c2756w.m3067g(16);
        c2756w.m3073m(4);
        int iM3067g2 = c2756w.m3067g(2);
        boolean zM3066f = c2756w.m3066f();
        c2756w.m3073m(1);
        byte[] bArr2 = C2738e0.f6713f;
        if (iM3067g2 != 1) {
            if (iM3067g2 == 0) {
                int iM3067g3 = c2756w.m3067g(16);
                int iM3067g4 = c2756w.m3067g(16);
                if (iM3067g3 > 0) {
                    bArr2 = new byte[iM3067g3];
                    c2756w.m3069i(bArr2, 0, iM3067g3);
                }
                if (iM3067g4 > 0) {
                    bArr = new byte[iM3067g4];
                    c2756w.m3069i(bArr, 0, iM3067g4);
                }
            }
            return new c(iM3067g, zM3066f, bArr2, bArr);
        }
        c2756w.m3073m(c2756w.m3067g(8) * 16);
        bArr = bArr2;
        return new c(iM3067g, zM3066f, bArr2, bArr);
    }
}
