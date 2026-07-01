package b.f.j.s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.ImmutableList;
import b.f.d.e.FLog;
import b.f.i.DefaultImageFormats;
import b.f.i.ImageFormat;
import b.f.j.d.ResizeOptions;
import b.f.j.d.RotationOptions;
import b.f.j.j.EncodedImage2;
import java.io.OutputStream;

/* JADX INFO: renamed from: b.f.j.s.f, reason: use source file name */
/* JADX INFO: compiled from: SimpleImageTranscoder.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleImageTranscoder implements ImageTranscoder {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f645b;

    public SimpleImageTranscoder(boolean z2, int i) {
        this.a = z2;
        this.f645b = i;
    }

    public static Bitmap.CompressFormat e(ImageFormat imageFormat) {
        if (imageFormat == null) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (imageFormat == DefaultImageFormats.a) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (imageFormat == DefaultImageFormats.f540b) {
            return Bitmap.CompressFormat.PNG;
        }
        return DefaultImageFormats.a(imageFormat) ? Bitmap.CompressFormat.WEBP : Bitmap.CompressFormat.JPEG;
    }

    @Override // b.f.j.s.ImageTranscoder
    public String a() {
        return "SimpleImageTranscoder";
    }

    @Override // b.f.j.s.ImageTranscoder
    public boolean b(EncodedImage2 encodedImage2, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.a;
        }
        return this.a && AnimatableValueParser.a0(rotationOptions, resizeOptions, encodedImage2, this.f645b) > 1;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a0  */
    @Override // b.f.j.s.ImageTranscoder
    public ImageTranscodeResult c(EncodedImage2 encodedImage2, OutputStream outputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ImageFormat imageFormat, Integer num) throws Throwable {
        Matrix matrix;
        Bitmap bitmapCreateBitmap;
        Throwable th;
        OutOfMemoryError e;
        Integer num2 = num == null ? 85 : num;
        RotationOptions rotationOptions2 = rotationOptions == null ? RotationOptions.a : rotationOptions;
        int iA0 = !this.a ? 1 : AnimatableValueParser.a0(rotationOptions2, resizeOptions, encodedImage2, this.f645b);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = iA0;
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(encodedImage2.e(), null, options);
            if (bitmapDecodeStream == null) {
                FLog.e("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
                return new ImageTranscodeResult(2);
            }
            ImmutableList<Integer> immutableList = JpegTranscoderUtils.a;
            encodedImage2.x();
            if (immutableList.contains(Integer.valueOf(encodedImage2.n))) {
                int iA = JpegTranscoderUtils.a(rotationOptions2, encodedImage2);
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
                int iB = JpegTranscoderUtils.b(rotationOptions2, encodedImage2);
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
                    FLog.f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                    ImageTranscodeResult imageTranscodeResult = new ImageTranscodeResult(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult;
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
                    ImageTranscodeResult imageTranscodeResult2 = new ImageTranscodeResult(iA0 > 1 ? 0 : 1);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult2;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                    FLog.f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                    ImageTranscodeResult imageTranscodeResult3 = new ImageTranscodeResult(2);
                    bitmapCreateBitmap.recycle();
                    bitmapDecodeStream.recycle();
                    return imageTranscodeResult3;
                }
            } catch (Throwable th3) {
                th = th3;
                bitmapCreateBitmap.recycle();
                bitmapDecodeStream.recycle();
                throw th;
            }
        } catch (OutOfMemoryError e4) {
            FLog.f("SimpleImageTranscoder", "Out-Of-Memory during transcode", e4);
            return new ImageTranscodeResult(2);
        }
    }

    @Override // b.f.j.s.ImageTranscoder
    public boolean d(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.k || imageFormat == DefaultImageFormats.a;
    }
}
