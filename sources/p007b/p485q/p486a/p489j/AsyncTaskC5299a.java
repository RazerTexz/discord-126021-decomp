package p007b.p485q.p486a.p489j;

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
import com.yalantis.ucrop.UCropActivity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import p007b.p485q.p486a.C5291g;
import p007b.p485q.p486a.p487h.InterfaceC5292a;
import p007b.p485q.p486a.p488i.C5296a;
import p007b.p485q.p486a.p488i.C5298c;
import p007b.p485q.p486a.p490k.C5302b;

/* JADX INFO: renamed from: b.q.a.j.a */
/* JADX INFO: compiled from: BitmapCropTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class AsyncTaskC5299a extends AsyncTask<Void, Void, Throwable> {

    /* JADX INFO: renamed from: a */
    public final WeakReference<Context> f14409a;

    /* JADX INFO: renamed from: b */
    public Bitmap f14410b;

    /* JADX INFO: renamed from: c */
    public final RectF f14411c;

    /* JADX INFO: renamed from: d */
    public final RectF f14412d;

    /* JADX INFO: renamed from: e */
    public float f14413e;

    /* JADX INFO: renamed from: f */
    public float f14414f;

    /* JADX INFO: renamed from: g */
    public final int f14415g;

    /* JADX INFO: renamed from: h */
    public final int f14416h;

    /* JADX INFO: renamed from: i */
    public final Bitmap.CompressFormat f14417i;

    /* JADX INFO: renamed from: j */
    public final int f14418j;

    /* JADX INFO: renamed from: k */
    public final String f14419k;

    /* JADX INFO: renamed from: l */
    public final String f14420l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC5292a f14421m;

    /* JADX INFO: renamed from: n */
    public int f14422n;

    /* JADX INFO: renamed from: o */
    public int f14423o;

    /* JADX INFO: renamed from: p */
    public int f14424p;

    /* JADX INFO: renamed from: q */
    public int f14425q;

    public AsyncTaskC5299a(@NonNull Context context, @Nullable Bitmap bitmap, @NonNull C5298c c5298c, @NonNull C5296a c5296a, @Nullable InterfaceC5292a interfaceC5292a) {
        this.f14409a = new WeakReference<>(context);
        this.f14410b = bitmap;
        this.f14411c = c5298c.f14405a;
        this.f14412d = c5298c.f14406b;
        this.f14413e = c5298c.f14407c;
        this.f14414f = c5298c.f14408d;
        this.f14415g = c5296a.f14395a;
        this.f14416h = c5296a.f14396b;
        this.f14417i = c5296a.f14397c;
        this.f14418j = c5296a.f14398d;
        this.f14419k = c5296a.f14399e;
        this.f14420l = c5296a.f14400f;
        this.f14421m = interfaceC5292a;
    }

    /* JADX WARN: Code duplicated, block: B:122:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:0x0261 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x0233 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0148  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:73:0x0224 A[Catch: IOException -> 0x0253, TryCatch #3 {IOException -> 0x0253, blocks: (B:70:0x021b, B:73:0x0224, B:75:0x0230, B:76:0x0233, B:77:0x0236), top: B:114:0x021b }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0230 A[Catch: IOException -> 0x0253, TryCatch #3 {IOException -> 0x0253, blocks: (B:70:0x021b, B:73:0x0224, B:75:0x0230, B:76:0x0233, B:77:0x0236), top: B:114:0x021b }] */
    /* JADX INFO: renamed from: a */
    public final boolean m7471a() throws Throwable {
        boolean z2;
        FileChannel fileChannel;
        String[] strArr;
        ExifInterface exifInterface;
        String str;
        String attribute;
        ByteArrayOutputStream byteArrayOutputStream;
        if (this.f14415g > 0 && this.f14416h > 0) {
            float fWidth = this.f14411c.width() / this.f14413e;
            float fHeight = this.f14411c.height() / this.f14413e;
            int i = this.f14415g;
            if (fWidth > i || fHeight > this.f14416h) {
                float fMin = Math.min(i / fWidth, this.f14416h / fHeight);
                Bitmap bitmap = this.f14410b;
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * fMin), Math.round(this.f14410b.getHeight() * fMin), false);
                Bitmap bitmap2 = this.f14410b;
                if (bitmap2 != bitmapCreateScaledBitmap) {
                    bitmap2.recycle();
                }
                this.f14410b = bitmapCreateScaledBitmap;
                this.f14413e /= fMin;
            }
        }
        if (this.f14414f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f14414f, this.f14410b.getWidth() / 2, this.f14410b.getHeight() / 2);
            Bitmap bitmap3 = this.f14410b;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap3, 0, 0, bitmap3.getWidth(), this.f14410b.getHeight(), matrix, true);
            Bitmap bitmap4 = this.f14410b;
            if (bitmap4 != bitmapCreateBitmap) {
                bitmap4.recycle();
            }
            this.f14410b = bitmapCreateBitmap;
        }
        this.f14424p = Math.round((this.f14411c.left - this.f14412d.left) / this.f14413e);
        this.f14425q = Math.round((this.f14411c.top - this.f14412d.top) / this.f14413e);
        this.f14422n = Math.round(this.f14411c.width() / this.f14413e);
        int iRound = Math.round(this.f14411c.height() / this.f14413e);
        this.f14423o = iRound;
        int iRound2 = Math.round(Math.max(this.f14422n, iRound) / 1000.0f) + 1;
        if (this.f14415g <= 0 || this.f14416h <= 0) {
            float f = iRound2;
            if (Math.abs(this.f14411c.left - this.f14412d.left) > f || Math.abs(this.f14411c.top - this.f14412d.top) > f || Math.abs(this.f14411c.bottom - this.f14412d.bottom) > f || Math.abs(this.f14411c.right - this.f14412d.right) > f || this.f14414f != 0.0f) {
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
            String str2 = this.f14419k;
            String str3 = this.f14420l;
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
        ExifInterface exifInterface2 = new ExifInterface(this.f14419k);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.f14410b, this.f14424p, this.f14425q, this.f14422n, this.f14423o);
        try {
            if (this.f14409a.get() != null) {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(this.f14420l), false);
                    try {
                        ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            bitmapCreateBitmap2.compress(this.f14417i, this.f14418j, byteArrayOutputStream4);
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
                                if (this.f14417i.equals(Bitmap.CompressFormat.JPEG)) {
                                    int i2 = this.f14422n;
                                    int i3 = this.f14423o;
                                    String str4 = this.f14420l;
                                    byte[] bArr = C5302b.f14440a;
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
        if (this.f14417i.equals(Bitmap.CompressFormat.JPEG)) {
            int i5 = this.f14422n;
            int i6 = this.f14423o;
            String str5 = this.f14420l;
            byte[] bArr2 = C5302b.f14440a;
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
        Bitmap bitmap = this.f14410b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.f14412d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        try {
            m7471a();
            this.f14410b = null;
            return null;
        } catch (Throwable th) {
            return th;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(@Nullable Throwable th) {
        Throwable th2 = th;
        InterfaceC5292a interfaceC5292a = this.f14421m;
        if (interfaceC5292a != null) {
            if (th2 != null) {
                C5291g c5291g = (C5291g) interfaceC5292a;
                c5291g.f14394a.m9320b(th2);
                c5291g.f14394a.finish();
                return;
            }
            Uri uriFromFile = Uri.fromFile(new File(this.f14420l));
            InterfaceC5292a interfaceC5292a2 = this.f14421m;
            int i = this.f14424p;
            int i2 = this.f14425q;
            int i3 = this.f14422n;
            int i4 = this.f14423o;
            C5291g c5291g2 = (C5291g) interfaceC5292a2;
            UCropActivity uCropActivity = c5291g2.f14394a;
            uCropActivity.setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uriFromFile).putExtra("com.yalantis.ucrop.CropAspectRatio", uCropActivity.f22194w.getTargetAspectRatio()).putExtra("com.yalantis.ucrop.ImageWidth", i3).putExtra("com.yalantis.ucrop.ImageHeight", i4).putExtra("com.yalantis.ucrop.OffsetX", i).putExtra("com.yalantis.ucrop.OffsetY", i2));
            c5291g2.f14394a.finish();
        }
    }
}
