package b0.a.a.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import b0.a.a.d;
import d0.g0.w;
import d0.o;
import d0.y.h;
import d0.z.d.m;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Pair;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: DefaultConstraint.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1992b;
    public final int c;
    public final Bitmap$CompressFormat d;
    public final int e;

    public c(int i, int i2, Bitmap$CompressFormat bitmap$CompressFormat, int i3) {
        m.checkParameterIsNotNull(bitmap$CompressFormat, "format");
        this.f1992b = i;
        this.c = i2;
        this.d = bitmap$CompressFormat;
        this.e = i3;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x010c  */
    @Override // b0.a.a.e.b
    public File a(File file) throws Throwable {
        int i;
        Bitmap$CompressFormat bitmap$CompressFormat;
        File file2;
        m.checkParameterIsNotNull(file, "imageFile");
        int i2 = this.f1992b;
        int i3 = this.c;
        String str = d.a;
        m.checkParameterIsNotNull(file, "imageFile");
        BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        bitmapFactory$Options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), bitmapFactory$Options);
        m.checkParameterIsNotNull(bitmapFactory$Options, "options");
        Pair pair = o.to(Integer.valueOf(bitmapFactory$Options.outHeight), Integer.valueOf(bitmapFactory$Options.outWidth));
        int iIntValue = ((Number) pair.component1()).intValue();
        int iIntValue2 = ((Number) pair.component2()).intValue();
        if (iIntValue > i3 || iIntValue2 > i2) {
            int i4 = iIntValue / 2;
            int i5 = iIntValue2 / 2;
            i = 1;
            while (i4 / i >= i3 && i5 / i >= i2) {
                i *= 2;
            }
        } else {
            i = 1;
        }
        bitmapFactory$Options.inSampleSize = i;
        bitmapFactory$Options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), bitmapFactory$Options);
        m.checkExpressionValueIsNotNull(bitmapDecodeFile, "BitmapFactory.decodeFile…eFile.absolutePath, this)");
        m.checkExpressionValueIsNotNull(bitmapDecodeFile, "BitmapFactory.Options().…absolutePath, this)\n    }");
        m.checkParameterIsNotNull(file, "imageFile");
        m.checkParameterIsNotNull(bitmapDecodeFile, "bitmap");
        int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
        Matrix matrix = new Matrix();
        if (attributeInt == 3) {
            matrix.postRotate(180.0f);
        } else if (attributeInt == 6) {
            matrix.postRotate(90.0f);
        } else if (attributeInt == 8) {
            matrix.postRotate(270.0f);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
        m.checkExpressionValueIsNotNull(bitmapCreateBitmap, "Bitmap.createBitmap(bitm…map.height, matrix, true)");
        Bitmap$CompressFormat bitmap$CompressFormat2 = this.d;
        int i6 = this.e;
        m.checkParameterIsNotNull(file, "imageFile");
        m.checkParameterIsNotNull(bitmapCreateBitmap, "bitmap");
        m.checkParameterIsNotNull(bitmap$CompressFormat2, "format");
        m.checkParameterIsNotNull(file, "$this$compressFormat");
        String extension = h.getExtension(file);
        if (extension == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = extension.toLowerCase();
        m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
        int iHashCode = lowerCase.hashCode();
        String str2 = "webp";
        if (iHashCode != 111145) {
            if (iHashCode == 3645340 && lowerCase.equals("webp")) {
                bitmap$CompressFormat = Bitmap$CompressFormat.WEBP;
            } else {
                bitmap$CompressFormat = Bitmap$CompressFormat.JPEG;
            }
        } else if (lowerCase.equals("png")) {
            bitmap$CompressFormat = Bitmap$CompressFormat.PNG;
        } else {
            bitmap$CompressFormat = Bitmap$CompressFormat.JPEG;
        }
        FileOutputStream fileOutputStream = null;
        if (bitmap$CompressFormat2 == bitmap$CompressFormat) {
            file2 = file;
        } else {
            StringBuilder sb = new StringBuilder();
            String absolutePath = file.getAbsolutePath();
            m.checkExpressionValueIsNotNull(absolutePath, "imageFile.absolutePath");
            sb.append(w.substringBeforeLast$default(absolutePath, ".", (String) null, 2, (Object) null));
            sb.append('.');
            m.checkParameterIsNotNull(bitmap$CompressFormat2, "$this$extension");
            int i7 = b0.a.a.c.a[bitmap$CompressFormat2.ordinal()];
            if (i7 == 1) {
                str2 = "png";
            } else if (i7 != 2) {
                str2 = "jpg";
            }
            sb.append(str2);
            file2 = new File(sb.toString());
        }
        file.delete();
        m.checkParameterIsNotNull(bitmapCreateBitmap, "bitmap");
        m.checkParameterIsNotNull(file2, "destination");
        m.checkParameterIsNotNull(bitmap$CompressFormat2, "format");
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2.getAbsolutePath());
            try {
                bitmapCreateBitmap.compress(bitmap$CompressFormat2, i6, fileOutputStream2);
                fileOutputStream2.flush();
                fileOutputStream2.close();
                this.a = true;
                return file2;
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // b0.a.a.e.b
    public boolean b(File file) {
        m.checkParameterIsNotNull(file, "imageFile");
        return this.a;
    }
}
