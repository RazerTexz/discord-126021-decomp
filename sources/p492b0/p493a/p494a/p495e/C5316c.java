package p492b0.p493a.p494a.p495e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Pair;
import kotlin.TypeCastException;
import p492b0.p493a.p494a.C5312c;
import p492b0.p493a.p494a.C5313d;
import p507d0.C12116o;
import p507d0.p579g0.C12106w;
import p507d0.p591y.C12207h;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b0.a.a.e.c */
/* JADX INFO: compiled from: DefaultConstraint.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5316c implements InterfaceC5315b {

    /* JADX INFO: renamed from: a */
    public boolean f14506a;

    /* JADX INFO: renamed from: b */
    public final int f14507b;

    /* JADX INFO: renamed from: c */
    public final int f14508c;

    /* JADX INFO: renamed from: d */
    public final Bitmap.CompressFormat f14509d;

    /* JADX INFO: renamed from: e */
    public final int f14510e;

    public C5316c(int i, int i2, Bitmap.CompressFormat compressFormat, int i3) {
        C12238m.checkParameterIsNotNull(compressFormat, "format");
        this.f14507b = i;
        this.f14508c = i2;
        this.f14509d = compressFormat;
        this.f14510e = i3;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x010c  */
    @Override // p492b0.p493a.p494a.p495e.InterfaceC5315b
    /* JADX INFO: renamed from: a */
    public File mo7489a(File file) throws Throwable {
        int i;
        Bitmap.CompressFormat compressFormat;
        File file2;
        C12238m.checkParameterIsNotNull(file, "imageFile");
        int i2 = this.f14507b;
        int i3 = this.f14508c;
        String str = C5313d.f14504a;
        C12238m.checkParameterIsNotNull(file, "imageFile");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        C12238m.checkParameterIsNotNull(options, "options");
        Pair pairM10073to = C12116o.m10073to(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int iIntValue = ((Number) pairM10073to.component1()).intValue();
        int iIntValue2 = ((Number) pairM10073to.component2()).intValue();
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
        C12238m.checkExpressionValueIsNotNull(bitmapDecodeFile, "BitmapFactory.decodeFile…eFile.absolutePath, this)");
        C12238m.checkExpressionValueIsNotNull(bitmapDecodeFile, "BitmapFactory.Options().…absolutePath, this)\n    }");
        C12238m.checkParameterIsNotNull(file, "imageFile");
        C12238m.checkParameterIsNotNull(bitmapDecodeFile, "bitmap");
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
        C12238m.checkExpressionValueIsNotNull(bitmapCreateBitmap, "Bitmap.createBitmap(bitm…map.height, matrix, true)");
        Bitmap.CompressFormat compressFormat2 = this.f14509d;
        int i6 = this.f14510e;
        C12238m.checkParameterIsNotNull(file, "imageFile");
        C12238m.checkParameterIsNotNull(bitmapCreateBitmap, "bitmap");
        C12238m.checkParameterIsNotNull(compressFormat2, "format");
        C12238m.checkParameterIsNotNull(file, "$this$compressFormat");
        String extension = C12207h.getExtension(file);
        if (extension == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = extension.toLowerCase();
        C12238m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
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
            C12238m.checkExpressionValueIsNotNull(absolutePath, "imageFile.absolutePath");
            sb.append(C12106w.substringBeforeLast$default(absolutePath, ".", (String) null, 2, (Object) null));
            sb.append('.');
            C12238m.checkParameterIsNotNull(compressFormat2, "$this$extension");
            int i7 = C5312c.f14503a[compressFormat2.ordinal()];
            if (i7 == 1) {
                str2 = "png";
            } else if (i7 != 2) {
                str2 = "jpg";
            }
            sb.append(str2);
            file2 = new File(sb.toString());
        }
        file.delete();
        C12238m.checkParameterIsNotNull(bitmapCreateBitmap, "bitmap");
        C12238m.checkParameterIsNotNull(file2, "destination");
        C12238m.checkParameterIsNotNull(compressFormat2, "format");
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
                this.f14506a = true;
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

    @Override // p492b0.p493a.p494a.p495e.InterfaceC5315b
    /* JADX INFO: renamed from: b */
    public boolean mo7490b(File file) {
        C12238m.checkParameterIsNotNull(file, "imageFile");
        return this.f14506a;
    }
}
