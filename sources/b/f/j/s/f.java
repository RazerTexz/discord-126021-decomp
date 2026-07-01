package b.f.j.s;

import android.graphics.Bitmap;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import android.graphics.Matrix;
import java.io.OutputStream;

/* JADX INFO: compiled from: SimpleImageTranscoder.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements b {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f645b;

    public f(boolean z2, int i) {
        this.a = z2;
        this.f645b = i;
    }

    public static Bitmap$CompressFormat e(b.f.i.c cVar) {
        if (cVar == null) {
            return Bitmap$CompressFormat.JPEG;
        }
        if (cVar == b.f.i.b.a) {
            return Bitmap$CompressFormat.JPEG;
        }
        if (cVar == b.f.i.b.f540b) {
            return Bitmap$CompressFormat.PNG;
        }
        return b.f.i.b.a(cVar) ? Bitmap$CompressFormat.WEBP : Bitmap$CompressFormat.JPEG;
    }

    @Override // b.f.j.s.b
    public String a() {
        return "SimpleImageTranscoder";
    }

    @Override // b.f.j.s.b
    public boolean b(b.f.j.j.e eVar, b.f.j.d.f fVar, b.f.j.d.e eVar2) {
        if (fVar == null) {
            fVar = b.f.j.d.f.a;
        }
        return this.a && b.c.a.a0.d.a0(fVar, eVar2, eVar, this.f645b) > 1;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a0  */
    @Override // b.f.j.s.b
    public a c(b.f.j.j.e eVar, OutputStream outputStream, b.f.j.d.f fVar, b.f.j.d.e eVar2, b.f.i.c cVar, Integer num) throws Throwable {
        Matrix matrix;
        Bitmap bitmapCreateBitmap;
        Throwable th;
        OutOfMemoryError e;
        Integer num2 = num == null ? 85 : num;
        b.f.j.d.f fVar2 = fVar == null ? b.f.j.d.f.a : fVar;
        int iA0 = !this.a ? 1 : b.c.a.a0.d.a0(fVar2, eVar2, eVar, this.f645b);
        BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inSampleSize = iA0;
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(eVar.e(), null, bitmapFactory$Options);
            if (bitmapDecodeStream == null) {
                b.f.d.e.a.e("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
                return new a(2);
            }
            b.f.d.d.e<Integer> eVar3 = d.a;
            eVar.x();
            if (eVar3.contains(Integer.valueOf(eVar.n))) {
                int iA = d.a(fVar2, eVar);
                matrix = new Matrix();
                if (iA == 2) {
                    matrix.setScale(-1.0f, 1.0f);
                } else if (iA == 7) {
                    matrix.setRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                } else if (iA == 4) {
                    matrix.setRotate(180.0f);
                    matrix.postScale(-1.0f, 1.0f);
                } else if (iA != 5) {
                    matrix = null;
                } else {
                    matrix.setRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                }
            } else {
                int iB = d.b(fVar2, eVar);
                if (iB != 0) {
                    matrix = new Matrix();
                    matrix.setRotate(iB);
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
                    b.f.d.e.a.f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                    a aVar = new a(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return aVar;
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
                    bitmapCreateBitmap.compress(e(null), num2.intValue(), outputStream);
                    a aVar2 = new a(iA0 > 1 ? 0 : 1);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return aVar2;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    b.f.d.e.a.f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                    a aVar3 = new a(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return aVar3;
                }
            } catch (Throwable th3) {
                th = th3;
                bitmapCreateBitmap.recycle();
                bitmapDecodeStream.recycle();
                throw th;
            }
        } catch (OutOfMemoryError e4) {
            b.f.d.e.a.f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e4);
            return new a(2);
        }
    }

    @Override // b.f.j.s.b
    public boolean d(b.f.i.c cVar) {
        return cVar == b.f.i.b.k || cVar == b.f.i.b.a;
    }
}
