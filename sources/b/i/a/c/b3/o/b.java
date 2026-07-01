package b.i.a.c.b3.o;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint$Style;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffXfermode;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.w;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: DvbParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final byte[] a = {0, 7, 8, 15};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f862b = {0, 119, -120, -1};
    public static final byte[] c = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    public final Paint d;
    public final Paint e;
    public final Canvas f;
    public final b$b g;
    public final b$a h;
    public final b$h i;
    public Bitmap j;

    public b(int i, int i2) {
        Paint paint = new Paint();
        this.d = paint;
        paint.setStyle(Paint$Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff$Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setStyle(Paint$Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff$Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f = new Canvas();
        this.g = new b$b(719, 575, 0, 719, 0, 575);
        this.h = new b$a(0, new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505}, b(), c());
        this.i = new b$h(i, i2);
    }

    public static byte[] a(int i, int i2, w wVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) wVar.g(i2);
        }
        return bArr;
    }

    public static int[] b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = d(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i2 = i & 1;
                int i3 = Opcodes.LAND;
                int i4 = i2 != 0 ? Opcodes.LAND : 0;
                int i5 = (i & 2) != 0 ? Opcodes.LAND : 0;
                if ((i & 4) == 0) {
                    i3 = 0;
                }
                iArr[i] = d(255, i4, i5, i3);
            }
        }
        return iArr;
    }

    public static int[] c() {
        int i;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = d(63, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
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
                    iArr[i2] = d(255, i5, i6, i + i4);
                } else if (i3 == 8) {
                    int i7 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? Opcodes.TABLESWITCH : 0);
                    int i8 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? Opcodes.TABLESWITCH : 0);
                    i = (i2 & 4) == 0 ? 0 : 85;
                    if ((i2 & 64) == 0) {
                        i4 = 0;
                    }
                    iArr[i2] = d(Opcodes.LAND, i7, i8, i + i4);
                } else if (i3 == 128) {
                    iArr[i2] = d(255, ((i2 & 1) != 0 ? 43 : 0) + Opcodes.LAND + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + Opcodes.LAND + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + Opcodes.LAND + ((i2 & 64) == 0 ? 0 : 85));
                } else if (i3 == 136) {
                    iArr[i2] = d(255, ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int d(int i, int i2, int i3, int i4) {
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
    public static void e(byte[] bArr, int[] iArr, int i, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        int i4;
        boolean z2;
        int iG;
        boolean z3;
        int i5;
        int iG2;
        int iG3;
        int iG4;
        boolean z4;
        int iG5;
        int i6;
        int iG6;
        boolean z5;
        int iG7;
        w wVar = new w(bArr);
        int i7 = i2;
        int i8 = i3;
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        byte[] bArrA3 = null;
        while (wVar.b() != 0) {
            int i9 = 8;
            int iG8 = wVar.g(8);
            if (iG8 != 240) {
                int i10 = 4;
                int i11 = 2;
                switch (iG8) {
                    case 16:
                        if (i == 3) {
                            bArr3 = bArrA == null ? f862b : bArrA;
                        } else {
                            if (i == 2) {
                                bArr3 = bArrA3 == null ? a : bArrA3;
                            } else {
                                bArr2 = null;
                            }
                            i4 = i7;
                            z2 = false;
                            while (true) {
                                iG = wVar.g(2);
                                if (iG == 0) {
                                    if (wVar.f()) {
                                        iG3 = wVar.g(3) + 3;
                                        iG4 = wVar.g(2);
                                    } else if (wVar.f()) {
                                        iG = 0;
                                        z3 = z2;
                                        i5 = 1;
                                    } else {
                                        iG2 = wVar.g(2);
                                        if (iG2 != 0) {
                                            z2 = true;
                                        } else if (iG2 != 1) {
                                            z3 = z2;
                                            iG = 0;
                                            i5 = 2;
                                        } else if (iG2 != 2) {
                                            iG3 = wVar.g(4) + 12;
                                            iG4 = wVar.g(2);
                                        } else if (iG2 != 3) {
                                            iG3 = wVar.g(8) + 29;
                                            iG4 = wVar.g(2);
                                        }
                                        z3 = z2;
                                        iG = 0;
                                        i5 = 0;
                                    }
                                    i5 = iG3;
                                    iG = iG4;
                                    z3 = z2;
                                } else {
                                    z3 = z2;
                                    i5 = 1;
                                }
                                if (i5 == 0 && paint != null) {
                                    if (bArr2 != 0) {
                                        iG = bArr2[iG];
                                    }
                                    paint.setColor(iArr[iG]);
                                    canvas.drawRect(i4, i8, i4 + i5, i8 + 1, paint);
                                }
                                i4 += i5;
                                if (z3) {
                                    wVar.c();
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
                            iG = wVar.g(2);
                            if (iG == 0) {
                                if (wVar.f()) {
                                    iG3 = wVar.g(3) + 3;
                                    iG4 = wVar.g(2);
                                } else if (wVar.f()) {
                                    iG = 0;
                                    z3 = z2;
                                    i5 = 1;
                                } else {
                                    iG2 = wVar.g(2);
                                    if (iG2 != 0) {
                                        z2 = true;
                                    } else if (iG2 != 1) {
                                        z3 = z2;
                                        iG = 0;
                                        i5 = 2;
                                    } else if (iG2 != 2) {
                                        iG3 = wVar.g(4) + 12;
                                        iG4 = wVar.g(2);
                                    } else if (iG2 != 3) {
                                        iG3 = wVar.g(8) + 29;
                                        iG4 = wVar.g(2);
                                    }
                                    z3 = z2;
                                    iG = 0;
                                    i5 = 0;
                                }
                                i5 = iG3;
                                iG = iG4;
                                z3 = z2;
                            } else {
                                z3 = z2;
                                i5 = 1;
                            }
                            if (i5 == 0) {
                            }
                            i4 += i5;
                            if (z3) {
                                wVar.c();
                                i7 = i4;
                            } else {
                                z2 = z3;
                            }
                            break;
                        }
                        break;
                    case 17:
                        byte[] bArr4 = i == 3 ? bArrA2 == null ? c : bArrA2 : null;
                        int i12 = i7;
                        boolean z6 = false;
                        while (true) {
                            int iG9 = wVar.g(i10);
                            if (iG9 != 0) {
                                z4 = z6;
                                iG5 = iG9;
                                i6 = 1;
                            } else if (wVar.f()) {
                                if (wVar.f()) {
                                    int iG10 = wVar.g(i11);
                                    if (iG10 == 0) {
                                        iG9 = 0;
                                        z4 = z6;
                                        iG5 = iG9;
                                        i6 = 1;
                                    } else if (iG10 == 1) {
                                        z4 = z6;
                                        iG5 = 0;
                                        i6 = 2;
                                    } else if (iG10 == i11) {
                                        iG6 = wVar.g(i10) + 9;
                                        iG5 = wVar.g(i10);
                                    } else if (iG10 != 3) {
                                        z4 = z6;
                                        iG5 = 0;
                                        i6 = 0;
                                    } else {
                                        iG6 = wVar.g(i9) + 25;
                                        iG5 = wVar.g(i10);
                                    }
                                } else {
                                    iG6 = wVar.g(i11) + i10;
                                    iG5 = wVar.g(i10);
                                }
                                z4 = z6;
                                i6 = iG6;
                            } else {
                                int iG11 = wVar.g(3);
                                if (iG11 != 0) {
                                    z4 = z6;
                                    i6 = iG11 + 2;
                                    iG5 = 0;
                                } else {
                                    z6 = true;
                                    z4 = z6;
                                    iG5 = 0;
                                    i6 = 0;
                                }
                            }
                            if (i6 != 0 && paint != null) {
                                if (bArr4 != 0) {
                                    iG5 = bArr4[iG5];
                                }
                                paint.setColor(iArr[iG5]);
                                canvas.drawRect(i12, i8, i12 + i6, i8 + 1, paint);
                            }
                            i12 += i6;
                            if (z4) {
                                wVar.c();
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
                            int iG12 = wVar.g(8);
                            if (iG12 != 0) {
                                z5 = z7;
                                iG7 = 1;
                            } else if (wVar.f()) {
                                z5 = z7;
                                iG7 = wVar.g(7);
                                iG12 = wVar.g(8);
                            } else {
                                int iG13 = wVar.g(7);
                                if (iG13 != 0) {
                                    z5 = z7;
                                    iG7 = iG13;
                                    iG12 = 0;
                                } else {
                                    iG12 = 0;
                                    z5 = true;
                                    iG7 = 0;
                                }
                            }
                            if (iG7 != 0 && paint != null) {
                                paint.setColor(iArr[iG12]);
                                canvas.drawRect(i13, i8, i13 + iG7, i8 + 1, paint);
                            }
                            i13 += iG7;
                            if (z5) {
                                i7 = i13;
                            } else {
                                z7 = z5;
                            }
                            break;
                        }
                        break;
                    default:
                        switch (iG8) {
                            case 32:
                                bArrA3 = a(4, 4, wVar);
                                break;
                            case 33:
                                bArrA = a(4, 8, wVar);
                                break;
                            case 34:
                                bArrA2 = a(16, 8, wVar);
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

    public static b$a f(w wVar, int i) {
        int[] iArr;
        int iG;
        int iG2;
        int iG3;
        int iG4;
        int i2 = 8;
        int iG5 = wVar.g(8);
        wVar.m(8);
        int i3 = i - 2;
        int i4 = 4;
        int[] iArr2 = {0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
        int[] iArrB = b();
        int[] iArrC = c();
        while (i3 > 0) {
            int iG6 = wVar.g(i2);
            int iG7 = wVar.g(i2);
            int i5 = i3 - 2;
            if ((iG7 & 128) != 0) {
                iArr = iArr2;
            } else {
                iArr = (iG7 & 64) != 0 ? iArrB : iArrC;
            }
            if ((iG7 & 1) != 0) {
                iG3 = wVar.g(i2);
                iG = wVar.g(i2);
                iG4 = wVar.g(i2);
                iG2 = wVar.g(i2);
                i3 = i5 - 4;
            } else {
                int iG8 = wVar.g(6) << 2;
                int iG9 = wVar.g(i4) << i4;
                int iG10 = wVar.g(i4) << i4;
                i3 = i5 - 2;
                iG = iG9;
                iG2 = wVar.g(2) << 6;
                iG3 = iG8;
                iG4 = iG10;
            }
            if (iG3 == 0) {
                iG = 0;
                iG4 = 0;
                iG2 = 255;
            }
            double d = iG3;
            double d2 = iG - 128;
            double d3 = iG4 - 128;
            iArr[iG6] = d((byte) (255 - (iG2 & 255)), e0.h((int) ((1.402d * d2) + d), 0, 255), e0.h((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255), e0.h((int) ((d3 * 1.772d) + d), 0, 255));
            iArr2 = iArr2;
            iG5 = iG5;
            i2 = 8;
            i4 = 4;
        }
        return new b$a(iG5, iArr2, iArrB, iArrC);
    }

    public static b$c g(w wVar) {
        byte[] bArr;
        int iG = wVar.g(16);
        wVar.m(4);
        int iG2 = wVar.g(2);
        boolean zF = wVar.f();
        wVar.m(1);
        byte[] bArr2 = e0.f;
        if (iG2 != 1) {
            if (iG2 == 0) {
                int iG3 = wVar.g(16);
                int iG4 = wVar.g(16);
                if (iG3 > 0) {
                    bArr2 = new byte[iG3];
                    wVar.i(bArr2, 0, iG3);
                }
                if (iG4 > 0) {
                    bArr = new byte[iG4];
                    wVar.i(bArr, 0, iG4);
                }
            }
            return new b$c(iG, zF, bArr2, bArr);
        }
        wVar.m(wVar.g(8) * 16);
        bArr = bArr2;
        return new b$c(iG, zF, bArr2, bArr);
    }
}
