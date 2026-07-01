package b.q.a.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.q.a.h.BitmapLoadCallback;
import b.q.a.i.ExifInfo;
import b.q.a.k.ImageHeaderParser;
import b.q.a.l.TransformImageView;
import b.q.a.l.TransformImageView2;
import com.adjust.sdk.Constants;
import com.yalantis.ucrop.UCropActivity;
import d0.z.d.Intrinsics3;
import f0.OkHttpClient;
import f0.e0.g.RealCall;
import g0.BufferedSource;
import g0.JvmOkio2;
import g0.Timeout2;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: b.q.a.j.b, reason: use source file name */
/* JADX INFO: compiled from: BitmapLoadTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapLoadTask extends AsyncTask<Void, Void, a> {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Uri f1982b;
    public Uri c;
    public final int d;
    public final int e;
    public final BitmapLoadCallback f;

    public BitmapLoadTask(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        this.a = context;
        this.f1982b = uri;
        this.c = uri2;
        this.d = i;
        this.e = i2;
        this.f = bitmapLoadCallback;
    }

    public final void a(@NonNull Uri uri, @Nullable Uri uri2) throws Throwable {
        InputStream inputStreamOpenInputStream;
        Log.d("BitmapWorkerTask", "copyFile");
        Objects.requireNonNull(uri2, "Output Uri is null - cannot copy image");
        FileOutputStream fileOutputStream = null;
        try {
            inputStreamOpenInputStream = this.a.getContentResolver().openInputStream(uri);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(uri2.getPath()));
                try {
                    if (inputStreamOpenInputStream == null) {
                        throw new NullPointerException("InputStream for given input Uri is null");
                    }
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = inputStreamOpenInputStream.read(bArr);
                        if (i > 0) {
                            fileOutputStream2.write(bArr, 0, i);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    }
                    fileOutputStream2.close();
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                    this.f1982b = this.c;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    this.f1982b = this.c;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenInputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0085 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0080 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void b(@NonNull Uri uri, @Nullable Uri uri2) throws Throwable {
        Response responseExecute;
        JvmOkio2 jvmOkio2;
        ResponseBody responseBody;
        Log.d("BitmapWorkerTask", "downloadFile");
        Objects.requireNonNull(uri2, "Output Uri is null - cannot download image");
        OkHttpClient okHttpClient = new OkHttpClient();
        BufferedSource bufferedSource = null;
        try {
            Request.a aVar = new Request.a();
            aVar.f(uri.toString());
            try {
                responseExecute = ((RealCall) okHttpClient.b(aVar.a())).execute();
                try {
                    BufferedSource bufferedSourceC = responseExecute.body.c();
                    try {
                        OutputStream outputStreamOpenOutputStream = this.a.getContentResolver().openOutputStream(uri2);
                        if (outputStreamOpenOutputStream == null) {
                            throw new NullPointerException("OutputStream for given output Uri is null");
                        }
                        Intrinsics3.checkParameterIsNotNull(outputStreamOpenOutputStream, "$this$sink");
                        jvmOkio2 = new JvmOkio2(outputStreamOpenOutputStream, new Timeout2());
                        try {
                            bufferedSourceC.k0(jvmOkio2);
                            try {
                                bufferedSourceC.close();
                            } catch (IOException unused) {
                            }
                            try {
                                jvmOkio2.close();
                            } catch (IOException unused2) {
                            }
                            ResponseBody responseBody2 = responseExecute.body;
                            if (responseBody2 != null) {
                                try {
                                    responseBody2.close();
                                } catch (IOException unused3) {
                                }
                            }
                            okHttpClient.m.a();
                            this.f1982b = this.c;
                        } catch (Throwable th) {
                            th = th;
                            bufferedSource = bufferedSourceC;
                            if (bufferedSource != null) {
                                try {
                                    bufferedSource.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (jvmOkio2 != null) {
                                try {
                                    jvmOkio2.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (responseExecute != null && (responseBody = responseExecute.body) != null) {
                                try {
                                    responseBody.close();
                                } catch (IOException unused6) {
                                }
                            }
                            okHttpClient.m.a();
                            this.f1982b = this.c;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        jvmOkio2 = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    jvmOkio2 = null;
                }
            } catch (Throwable th4) {
                th = th4;
                responseExecute = null;
                jvmOkio2 = null;
                if (bufferedSource != null) {
                    bufferedSource.close();
                }
                if (jvmOkio2 != null) {
                    jvmOkio2.close();
                }
                if (responseExecute != null) {
                    responseBody.close();
                }
                okHttpClient.m.a();
                this.f1982b = this.c;
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final void c() throws IOException, NullPointerException {
        String scheme = this.f1982b.getScheme();
        Log.d("BitmapWorkerTask", "Uri scheme: " + scheme);
        if ("http".equals(scheme) || Constants.SCHEME.equals(scheme)) {
            try {
                b(this.f1982b, this.c);
                return;
            } catch (IOException | NullPointerException e) {
                Log.e("BitmapWorkerTask", "Downloading failed", e);
                throw e;
            }
        }
        if ("content".equals(scheme)) {
            try {
                a(this.f1982b, this.c);
                return;
            } catch (IOException | NullPointerException e2) {
                Log.e("BitmapWorkerTask", "Copying failed", e2);
                throw e2;
            }
        }
        if ("file".equals(scheme)) {
            return;
        }
        Log.e("BitmapWorkerTask", "Invalid Uri scheme " + scheme);
        throw new IllegalArgumentException(outline.w("Invalid Uri scheme", scheme));
    }

    @Override // android.os.AsyncTask
    @NonNull
    public a doInBackground(Void[] voidArr) {
        int i;
        int iA;
        int i2;
        boolean z2;
        if (this.f1982b == null) {
            return new a(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            c();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int i3 = this.d;
            int i4 = this.e;
            int i5 = options.outHeight;
            int i6 = options.outWidth;
            if (i5 > i4 || i6 > i3) {
                int i7 = 1;
                while (true) {
                    if (i5 / i7 <= i4 && i6 / i7 <= i3) {
                        break;
                    }
                    i7 *= 2;
                }
                i = i7;
            } else {
                i = 1;
            }
            options.inSampleSize = i;
            options.inJustDecodeBounds = false;
            boolean z3 = false;
            Bitmap bitmapDecodeStream = null;
            while (true) {
                int i8 = -1;
                if (z3) {
                    if (bitmapDecodeStream == null) {
                        StringBuilder sbU = outline.U("Bitmap could not be decoded from the Uri: [");
                        sbU.append(this.f1982b);
                        sbU.append("]");
                        return new a(new IllegalArgumentException(sbU.toString()));
                    }
                    Context context = this.a;
                    Uri uri = this.f1982b;
                    try {
                        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                        if (inputStreamOpenInputStream == null) {
                            iA = 0;
                        } else {
                            iA = new ImageHeaderParser(inputStreamOpenInputStream).a();
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException e) {
                        StringBuilder sbU2 = outline.U("getExifOrientation: ");
                        sbU2.append(uri.toString());
                        Log.e("BitmapLoadUtils", sbU2.toString(), e);
                    }
                    switch (iA) {
                        case 3:
                        case 4:
                            i2 = 180;
                            break;
                        case 5:
                        case 6:
                            i2 = 90;
                            break;
                        case 7:
                        case 8:
                            i2 = 270;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    if (iA != 2 && iA != 7 && iA != 4 && iA != 5) {
                        i8 = 1;
                    }
                    ExifInfo exifInfo = new ExifInfo(iA, i2, i8);
                    Matrix matrix = new Matrix();
                    if (i2 != 0) {
                        matrix.preRotate(i2);
                    }
                    if (i8 != 1) {
                        matrix.postScale(i8, 1.0f);
                    }
                    if (matrix.isIdentity()) {
                        return new a(bitmapDecodeStream, exifInfo);
                    }
                    try {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix, true);
                        if (!bitmapDecodeStream.sameAs(bitmapCreateBitmap)) {
                            bitmapDecodeStream = bitmapCreateBitmap;
                        }
                    } catch (OutOfMemoryError e2) {
                        Log.e("BitmapLoadUtils", "transformBitmap: ", e2);
                    }
                    return new a(bitmapDecodeStream, exifInfo);
                }
                try {
                    try {
                        InputStream inputStreamOpenInputStream2 = this.a.getContentResolver().openInputStream(this.f1982b);
                        try {
                            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options);
                            if (options.outWidth == -1 || options.outHeight == -1) {
                                a aVar = new a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.f1982b + "]"));
                                if (inputStreamOpenInputStream2 != null) {
                                    try {
                                        inputStreamOpenInputStream2.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                return aVar;
                            }
                            if (inputStreamOpenInputStream2 != null) {
                                try {
                                    inputStreamOpenInputStream2.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if ((bitmapDecodeStream != null ? bitmapDecodeStream.getByteCount() : 0) > 104857600) {
                                options.inSampleSize *= 2;
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                z3 = true;
                            }
                        } catch (Throwable th) {
                            if (inputStreamOpenInputStream2 != null) {
                                try {
                                    inputStreamOpenInputStream2.close();
                                } catch (IOException unused4) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        Log.e("BitmapWorkerTask", "doInBackground: ImageDecoder.createSource: ", e3);
                        StringBuilder sbU3 = outline.U("Bitmap could not be decoded from the Uri: [");
                        sbU3.append(this.f1982b);
                        sbU3.append("]");
                        return new a(new IllegalArgumentException(sbU3.toString(), e3));
                    }
                } catch (OutOfMemoryError e4) {
                    Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e4);
                    options.inSampleSize *= 2;
                }
            }
        } catch (IOException | NullPointerException e5) {
            return new a(e5);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(@NonNull a aVar) {
        a aVar2 = aVar;
        Exception exc = aVar2.c;
        if (exc != null) {
            TransformImageView transformImageView = (TransformImageView) this.f;
            Objects.requireNonNull(transformImageView);
            Log.e("TransformImageView", "onFailure: setImageUri", exc);
            TransformImageView2.a aVar3 = transformImageView.a.p;
            if (aVar3 != null) {
                UCropActivity.a aVar4 = (UCropActivity.a) aVar3;
                UCropActivity.this.b(exc);
                UCropActivity.this.finish();
                return;
            }
            return;
        }
        BitmapLoadCallback bitmapLoadCallback = this.f;
        Bitmap bitmap = aVar2.a;
        ExifInfo exifInfo = aVar2.f1983b;
        String path = this.f1982b.getPath();
        Uri uri = this.c;
        String path2 = uri == null ? null : uri.getPath();
        TransformImageView2 transformImageView2 = ((TransformImageView) bitmapLoadCallback).a;
        transformImageView2.v = path;
        transformImageView2.w = path2;
        transformImageView2.f1991x = exifInfo;
        transformImageView2.f1990s = true;
        transformImageView2.setImageBitmap(bitmap);
    }

    /* JADX INFO: renamed from: b.q.a.j.b$a */
    /* JADX INFO: compiled from: BitmapLoadTask.java */
    public static class a {
        public Bitmap a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ExifInfo f1983b;
        public Exception c;

        public a(@NonNull Bitmap bitmap, @NonNull ExifInfo exifInfo) {
            this.a = bitmap;
            this.f1983b = exifInfo;
        }

        public a(@NonNull Exception exc) {
            this.c = exc;
        }
    }
}
