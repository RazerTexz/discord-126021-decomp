package b0.a.a.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import b0.a.a.Util3;
import d0.Tuples;
import d0.g0.Strings4;
import d0.y.Utils7;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Tuples2;
import kotlin.TypeCastException;

/* JADX INFO: renamed from: b0.a.a.e.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultConstraint.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultConstraint implements Constraint2 {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1992b;
    public final int c;
    public final Bitmap.CompressFormat d;
    public final int e;

    public DefaultConstraint(int i, int i2, Bitmap.CompressFormat compressFormat, int i3) {
        Intrinsics3.checkParameterIsNotNull(compressFormat, "format");
        this.f1992b = i;
        this.c = i2;
        this.d = compressFormat;
        this.e = i3;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x010c  */
    @Override // b0.a.a.e.Constraint2
    public File a(File file) throws Throwable {
        int i;
        Bitmap.CompressFormat compressFormat;
        File file2;
        Intrinsics3.checkParameterIsNotNull(file, "imageFile");
        int i2 = this.f1992b;
        int i3 = this.c;
        String str = Util3.a;
        Intrinsics3.checkParameterIsNotNull(file, "imageFile");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        Intrinsics3.checkParameterIsNotNull(options, "options");
        Tuples2 tuples2 = Tuples.to(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int iIntValue = ((Number) tuples2.component1()).intValue();
        int iIntValue2 = ((Number) tuples2.component2()).intValue();
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
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        Intrinsics3.checkExpressionValueIsNotNull(bitmapDecodeFile, "BitmapFactory.decodeFile…eFile.absolutePath, this)");
        Intrinsics3.checkExpressionValueIsNotNull(bitmapDecodeFile, "BitmapFactory.Options().…absolutePath, this)\n    }");
        Intrinsics3.checkParameterIsNotNull(file, "imageFile");
        Intrinsics3.checkParameterIsNotNull(bitmapDecodeFile, "bitmap");
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
        Intrinsics3.checkExpressionValueIsNotNull(bitmapCreateBitmap, "Bitmap.createBitmap(bitm…map.height, matrix, true)");
        Bitmap.CompressFormat compressFormat2 = this.d;
        int i6 = this.e;
        Intrinsics3.checkParameterIsNotNull(file, "imageFile");
        Intrinsics3.checkParameterIsNotNull(bitmapCreateBitmap, "bitmap");
        Intrinsics3.checkParameterIsNotNull(compressFormat2, "format");
        Intrinsics3.checkParameterIsNotNull(file, "$this$compressFormat");
        String extension = Utils7.getExtension(file);
        if (extension == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = extension.toLowerCase();
        Intrinsics3.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
        int iHashCode = lowerCase.hashCode();
        String str2 = "webp";
        if (iHashCode != 111145) {
            if (iHashCode == 3645340 && lowerCase.equals("webp")) {
                compressFormat = Bitmap.CompressFormat.WEBP;
            } else {
                compressFormat = Bitmap.CompressFormat.JPEG;
            }
        } else if (lowerCase.equals("png")) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        FileOutputStream fileOutputStream = null;
        if (compressFormat2 == compressFormat) {
            file2 = file;
        } else {
            StringBuilder sb = new StringBuilder();
            String absolutePath = file.getAbsolutePath();
            Intrinsics3.checkExpressionValueIsNotNull(absolutePath, "imageFile.absolutePath");
            sb.append(Strings4.substringBeforeLast$default(absolutePath, ".", (String) null, 2, (Object) null));
            sb.append('.');
            Intrinsics3.checkParameterIsNotNull(compressFormat2, "$this$extension");
            int i7 = b0.a.a.c.a[compressFormat2.ordinal()];
            if (i7 == 1) {
                str2 = "png";
            } else if (i7 != 2) {
                str2 = "jpg";
            }
            sb.append(str2);
            file2 = new File(sb.toString());
        }
        file.delete();
        Intrinsics3.checkParameterIsNotNull(bitmapCreateBitmap, "bitmap");
        Intrinsics3.checkParameterIsNotNull(file2, "destination");
        Intrinsics3.checkParameterIsNotNull(compressFormat2, "format");
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2.getAbsolutePath());
            try {
                bitmapCreateBitmap.compress(compressFormat2, i6, fileOutputStream2);
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

    @Override // b0.a.a.e.Constraint2
    public boolean b(File file) {
        Intrinsics3.checkParameterIsNotNull(file, "imageFile");
        return this.a;
    }
}
