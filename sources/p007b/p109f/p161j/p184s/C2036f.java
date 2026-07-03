package p007b.p109f.p161j.p184s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import java.io.OutputStream;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1682e;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p160i.C1831b;
import p007b.p109f.p160i.C1832c;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p169d.C1885f;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.s.f */
/* JADX INFO: compiled from: SimpleImageTranscoder.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2036f implements InterfaceC2032b {

    /* JADX INFO: renamed from: a */
    public final boolean f4273a;

    /* JADX INFO: renamed from: b */
    public final int f4274b;

    public C2036f(boolean z2, int i) {
        this.f4273a = z2;
        this.f4274b = i;
    }

    /* JADX INFO: renamed from: e */
    public static Bitmap.CompressFormat m1536e(C1832c c1832c) {
        if (c1832c == null) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (c1832c == C1831b.f3585a) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (c1832c == C1831b.f3586b) {
            return Bitmap.CompressFormat.PNG;
        }
        return C1831b.m1172a(c1832c) ? Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.JPEG;
    }

    @Override // p007b.p109f.p161j.p184s.InterfaceC2032b
    /* JADX INFO: renamed from: a */
    public String mo1528a() {
        return "SimpleImageTranscoder";
    }

    @Override // p007b.p109f.p161j.p184s.InterfaceC2032b
    /* JADX INFO: renamed from: b */
    public boolean mo1529b(C1919e c1919e, C1885f c1885f, C1884e c1884e) {
        if (c1885f == null) {
            c1885f = C1885f.f3721a;
        }
        return this.f4273a && C1460d.m496a0(c1885f, c1884e, c1919e, this.f4274b) > 1;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a0  */
    @Override // p007b.p109f.p161j.p184s.InterfaceC2032b
    /* JADX INFO: renamed from: c */
    public C2031a mo1530c(C1919e c1919e, OutputStream outputStream, C1885f c1885f, C1884e c1884e, C1832c c1832c, Integer num) throws Throwable {
        Matrix matrix;
        Bitmap bitmapCreateBitmap;
        Throwable th;
        OutOfMemoryError e;
        Integer num2 = num == null ? 85 : num;
        C1885f c1885f2 = c1885f == null ? C1885f.f3721a : c1885f;
        int iM496a0 = !this.f4273a ? 1 : C1460d.m496a0(c1885f2, c1884e, c1919e, this.f4274b);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = iM496a0;
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(c1919e.m1342e(), null, options);
            if (bitmapDecodeStream == null) {
                C1691a.m977e("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
                return new C2031a(2);
            }
            C1682e<Integer> c1682e = C2034d.f4268a;
            c1919e.m1347x();
            if (c1682e.contains(Integer.valueOf(c1919e.f3895n))) {
                int iM1532a = C2034d.m1532a(c1885f2, c1919e);
                matrix = new Matrix();
                if (iM1532a == 2) {
                    matrix.setScale(-1.0f, 1.0f);
                } else if (iM1532a == 7) {
                    matrix.setRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                } else if (iM1532a == 4) {
                    matrix.setRotate(180.0f);
                    matrix.postScale(-1.0f, 1.0f);
                } else if (iM1532a != 5) {
                    matrix = null;
                } else {
                    matrix.setRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                }
            } else {
                int iM1533b = C2034d.m1533b(c1885f2, c1919e);
                if (iM1533b != 0) {
                    matrix = new Matrix();
                    matrix.setRotate(iM1533b);
                } else {
                    matrix = null;
                }
            }
            Matrix matrix2 = matrix;
            if (matrix2 != null) {
                try {
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix2, false);
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    bitmapCreateBitmap = bitmapDecodeStream;
                    C1691a.m978f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                    C2031a c2031a = new C2031a(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return c2031a;
                } catch (Throwable th2) {
                    th = th2;
                    bitmapCreateBitmap = bitmapDecodeStream;
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    throw th;
                }
            } else {
                bitmapCreateBitmap = bitmapDecodeStream;
            }
            try {
                try {
                    bitmapCreateBitmap.compress(m1536e(null), num2.intValue(), outputStream);
                    C2031a c2031a2 = new C2031a(iM496a0 > 1 ? 0 : 1);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return c2031a2;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    C1691a.m978f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                    C2031a c2031a3 = new C2031a(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return c2031a3;
                }
            } catch (Throwable th3) {
                th = th3;
                bitmapCreateBitmap.recycle();
                bitmapDecodeStream.recycle();
                throw th;
            }
        } catch (OutOfMemoryError e4) {
            C1691a.m978f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e4);
            return new C2031a(2);
        }
    }

    @Override // p007b.p109f.p161j.p184s.InterfaceC2032b
    /* JADX INFO: renamed from: d */
    public boolean mo1531d(C1832c c1832c) {
        return c1832c == C1831b.f3595k || c1832c == C1831b.f3585a;
    }
}
