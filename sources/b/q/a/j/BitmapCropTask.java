package b.q.a.j;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import b.q.a.UCropActivity7;
import b.q.a.h.BitmapCropCallback;
import b.q.a.i.CropParameters;
import b.q.a.i.ImageState;
import b.q.a.k.ImageHeaderParser;
import com.yalantis.ucrop.UCropActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;

/* JADX INFO: renamed from: b.q.a.j.a, reason: use source file name */
/* JADX INFO: compiled from: BitmapCropTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapCropTask extends AsyncTask<Void, Void, Throwable> {
    public final WeakReference<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f1981b;
    public final RectF c;
    public final RectF d;
    public float e;
    public float f;
    public final int g;
    public final int h;
    public final Bitmap.CompressFormat i;
    public final int j;
    public final String k;
    public final String l;
    public final BitmapCropCallback m;
    public int n;
    public int o;
    public int p;
    public int q;

    public BitmapCropTask(@NonNull Context context, @Nullable Bitmap bitmap, @NonNull ImageState imageState, @NonNull CropParameters cropParameters, @Nullable BitmapCropCallback bitmapCropCallback) {
        this.a = new WeakReference<>(context);
        this.f1981b = bitmap;
        this.c = imageState.a;
        this.d = imageState.f1980b;
        this.e = imageState.c;
        this.f = imageState.d;
        this.g = cropParameters.a;
        this.h = cropParameters.f1978b;
        this.i = cropParameters.c;
        this.j = cropParameters.d;
        this.k = cropParameters.e;
        this.l = cropParameters.f;
        this.m = bitmapCropCallback;
    }

    /* JADX WARN: Code duplicated, block: B:122:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x0261 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x0233 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0148  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:73:0x0224 A[Catch: IOException -> 0x0253, TryCatch #3 {IOException -> 0x0253, blocks: (B:70:0x021b, B:73:0x0224, B:75:0x0230, B:76:0x0233, B:77:0x0236), top: B:114:0x021b }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0230 A[Catch: IOException -> 0x0253, TryCatch #3 {IOException -> 0x0253, blocks: (B:70:0x021b, B:73:0x0224, B:75:0x0230, B:76:0x0233, B:77:0x0236), top: B:114:0x021b }] */
    public final boolean a() throws Throwable {
        boolean z2;
        FileChannel fileChannel;
        String[] strArr;
        ExifInterface exifInterface;
        String str;
        String attribute;
        ByteArrayOutputStream byteArrayOutputStream;
        if (this.g > 0 && this.h > 0) {
            float fWidth = this.c.width() / this.e;
            float fHeight = this.c.height() / this.e;
            int i = this.g;
            if (fWidth > i || fHeight > this.h) {
                float fMin = Math.min(i / fWidth, this.h / fHeight);
                Bitmap bitmap = this.f1981b;
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * fMin), Math.round(this.f1981b.getHeight() * fMin), false);
                Bitmap bitmap2 = this.f1981b;
                if (bitmap2 != bitmapCreateScaledBitmap) {
                    bitmap2.recycle();
                }
                this.f1981b = bitmapCreateScaledBitmap;
                this.e /= fMin;
            }
        }
        if (this.f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f, this.f1981b.getWidth() / 2, this.f1981b.getHeight() / 2);
            Bitmap bitmap3 = this.f1981b;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.f1981b.getHeight(), matrix, true);
            Bitmap bitmap4 = this.f1981b;
            if (bitmap4 != bitmapCreateBitmap) {
                bitmap4.recycle();
            }
            this.f1981b = bitmapCreateBitmap;
        }
        this.p = Math.round((this.c.left - this.d.left) / this.e);
        this.q = Math.round((this.c.top - this.d.top) / this.e);
        this.n = Math.round(this.c.width() / this.e);
        int iRound = Math.round(this.c.height() / this.e);
        this.o = iRound;
        int iRound2 = Math.round(Math.max(this.n, iRound) / 1000.0f) + 1;
        if (this.g <= 0 || this.h <= 0) {
            float f = iRound2;
            if (Math.abs(this.c.left - this.d.left) > f || Math.abs(this.c.top - this.d.top) > f || Math.abs(this.c.bottom - this.d.bottom) > f || Math.abs(this.c.right - this.d.right) > f || this.f != 0.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = true;
        }
        Log.i("BitmapCropTask", "Should crop: " + z2);
        FileChannel fileChannel2 = null;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel channel = null;
        if (!z2) {
            String str2 = this.k;
            String str3 = this.l;
            if (!str2.equalsIgnoreCase(str3)) {
                try {
                    FileChannel channel2 = new FileInputStream(new File(str2)).getChannel();
                    try {
                        channel = new FileOutputStream(new File(str3)).getChannel();
                        channel2.transferTo(0L, channel2.size(), channel);
                        channel2.close();
                        channel2.close();
                        if (channel != null) {
                            channel.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileChannel = channel;
                        fileChannel2 = channel2;
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            }
            return false;
        }
        ExifInterface exifInterface2 = new ExifInterface(this.k);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.f1981b, this.p, this.q, this.n, this.o);
        try {
            if (this.a.get() != null) {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(this.l), false);
                    try {
                        ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            bitmapCreateBitmap2.compress(this.i, this.j, byteArrayOutputStream4);
                            fileOutputStream2.write(byteArrayOutputStream4.toByteArray());
                            bitmapCreateBitmap2.recycle();
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused) {
                            }
                            byteArrayOutputStream4.close();
                        } catch (IOException e) {
                            e = e;
                            byteArrayOutputStream2 = byteArrayOutputStream4;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            fileOutputStream = fileOutputStream2;
                            try {
                                Log.e("BitmapCropTask", e.getLocalizedMessage());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (this.i.equals(Bitmap.CompressFormat.JPEG)) {
                                    int i2 = this.n;
                                    int i3 = this.o;
                                    String str4 = this.l;
                                    byte[] bArr = ImageHeaderParser.a;
                                    strArr = new String[]{ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_WHITE_BALANCE};
                                    try {
                                        exifInterface = new ExifInterface(str4);
                                        for (int i4 = 0; i4 < 22; i4++) {
                                            str = strArr[i4];
                                            attribute = exifInterface2.getAttribute(str);
                                            if (!TextUtils.isEmpty(attribute)) {
                                                exifInterface.setAttribute(str, attribute);
                                            }
                                        }
                                        exifInterface.setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i2));
                                        exifInterface.setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i3));
                                        exifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, "0");
                                        exifInterface.saveAttributes();
                                    } catch (IOException e2) {
                                        Log.d("ImageHeaderParser", e2.getMessage());
                                    }
                                }
                                return true;
                            } catch (Throwable th3) {
                                th = th3;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    throw th;
                                }
                                try {
                                    byteArrayOutputStream.close();
                                    throw th;
                                } catch (IOException unused4) {
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            byteArrayOutputStream3 = byteArrayOutputStream4;
                            byteArrayOutputStream = byteArrayOutputStream3;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (byteArrayOutputStream != null) {
                                throw th;
                            }
                            byteArrayOutputStream.close();
                            throw th;
                        }
                    } catch (IOException e3) {
                        e = e3;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (IOException e4) {
                    e = e4;
                    byteArrayOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayOutputStream = null;
                }
            }
        } catch (IOException unused5) {
        }
        if (this.i.equals(Bitmap.CompressFormat.JPEG)) {
            int i5 = this.n;
            int i6 = this.o;
            String str5 = this.l;
            byte[] bArr2 = ImageHeaderParser.a;
            strArr = new String[]{ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_FLASH, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_MAKE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SUBSEC_TIME, ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, ExifInterface.TAG_WHITE_BALANCE};
            exifInterface = new ExifInterface(str5);
            while (i4 < 22) {
                str = strArr[i4];
                attribute = exifInterface2.getAttribute(str);
                if (!TextUtils.isEmpty(attribute)) {
                    exifInterface.setAttribute(str, attribute);
                }
            }
            exifInterface.setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i5));
            exifInterface.setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i6));
            exifInterface.setAttribute(ExifInterface.TAG_ORIENTATION, "0");
            exifInterface.saveAttributes();
        }
        return true;
    }

    @Override // android.os.AsyncTask
    @Nullable
    public Throwable doInBackground(Void[] voidArr) {
        Bitmap bitmap = this.f1981b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            a();
            this.f1981b = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(@Nullable Throwable th) {
        Throwable th2 = th;
        BitmapCropCallback bitmapCropCallback = this.m;
        if (bitmapCropCallback != null) {
            if (th2 != null) {
                UCropActivity7 uCropActivity7 = (UCropActivity7) bitmapCropCallback;
                uCropActivity7.a.b(th2);
                uCropActivity7.a.finish();
                return;
            }
            Uri uriFromFile = Uri.fromFile(new File(this.l));
            BitmapCropCallback bitmapCropCallback2 = this.m;
            int i = this.p;
            int i2 = this.q;
            int i3 = this.n;
            int i4 = this.o;
            UCropActivity7 uCropActivity8 = (UCropActivity7) bitmapCropCallback2;
            UCropActivity uCropActivity = uCropActivity8.a;
            uCropActivity.setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uriFromFile).putExtra("com.yalantis.ucrop.CropAspectRatio", uCropActivity.w.getTargetAspectRatio()).putExtra("com.yalantis.ucrop.ImageWidth", i3).putExtra("com.yalantis.ucrop.ImageHeight", i4).putExtra("com.yalantis.ucrop.OffsetX", i).putExtra("com.yalantis.ucrop.OffsetY", i2));
            uCropActivity8.a.finish();
        }
    }
}
