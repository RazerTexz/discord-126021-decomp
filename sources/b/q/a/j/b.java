package b.q.a.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.q.a.l.c;
import b.q.a.l.c$a;
import com.adjust.sdk.Constants;
import com.yalantis.ucrop.UCropActivity$a;
import d0.z.d.m;
import f0.e0.g.e;
import f0.x;
import g0.g;
import g0.p;
import g0.y;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import okhttp3.Request$a;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: BitmapLoadTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends AsyncTask<Void, Void, b$a> {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Uri f1982b;
    public Uri c;
    public final int d;
    public final int e;
    public final b.q.a.h.b f;

    public b(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i, int i2, b.q.a.h.b bVar) {
        this.a = context;
        this.f1982b = uri;
        this.c = uri2;
        this.d = i;
        this.e = i2;
        this.f = bVar;
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
        p pVar;
        ResponseBody responseBody;
        Log.d("BitmapWorkerTask", "downloadFile");
        Objects.requireNonNull(uri2, "Output Uri is null - cannot download image");
        x xVar = new x();
        g gVar = null;
        try {
            Request$a request$a = new Request$a();
            request$a.f(uri.toString());
            try {
                responseExecute = ((e) xVar.b(request$a.a())).execute();
                try {
                    g gVarC = responseExecute.body.c();
                    try {
                        OutputStream outputStreamOpenOutputStream = this.a.getContentResolver().openOutputStream(uri2);
                        if (outputStreamOpenOutputStream == null) {
                            throw new NullPointerException("OutputStream for given output Uri is null");
                        }
                        m.checkParameterIsNotNull(outputStreamOpenOutputStream, "$this$sink");
                        pVar = new p(outputStreamOpenOutputStream, new y());
                        try {
                            gVarC.k0(pVar);
                            try {
                                gVarC.close();
                            } catch (IOException unused) {
                            }
                            try {
                                pVar.close();
                            } catch (IOException unused2) {
                            }
                            ResponseBody responseBody2 = responseExecute.body;
                            if (responseBody2 != null) {
                                try {
                                    responseBody2.close();
                                } catch (IOException unused3) {
                                }
                            }
                            xVar.m.a();
                            this.f1982b = this.c;
                        } catch (Throwable th) {
                            th = th;
                            gVar = gVarC;
                            if (gVar != null) {
                                try {
                                    gVar.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (pVar != null) {
                                try {
                                    pVar.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (responseExecute != null && (responseBody = responseExecute.body) != null) {
                                try {
                                    responseBody.close();
                                } catch (IOException unused6) {
                                }
                            }
                            xVar.m.a();
                            this.f1982b = this.c;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        pVar = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    pVar = null;
                }
            } catch (Throwable th4) {
                th = th4;
                responseExecute = null;
                pVar = null;
                if (gVar != null) {
                    gVar.close();
                }
                if (pVar != null) {
                    pVar.close();
                }
                if (responseExecute != null) {
                    responseBody.close();
                }
                xVar.m.a();
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
        throw new IllegalArgumentException(b.d.b.a.a.w("Invalid Uri scheme", scheme));
    }

    @Override // android.os.AsyncTask
    @NonNull
    public b$a doInBackground(Void[] voidArr) {
        int i;
        int iA;
        int i2;
        boolean z2;
        if (this.f1982b == null) {
            return new b$a(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            c();
            BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
            bitmapFactory$Options.inJustDecodeBounds = true;
            int i3 = this.d;
            int i4 = this.e;
            int i5 = bitmapFactory$Options.outHeight;
            int i6 = bitmapFactory$Options.outWidth;
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
            bitmapFactory$Options.inSampleSize = i;
            bitmapFactory$Options.inJustDecodeBounds = false;
            boolean z3 = false;
            Bitmap bitmapDecodeStream = null;
            while (true) {
                int i8 = -1;
                if (z3) {
                    if (bitmapDecodeStream == null) {
                        StringBuilder sbU = b.d.b.a.a.U("Bitmap could not be decoded from the Uri: [");
                        sbU.append(this.f1982b);
                        sbU.append("]");
                        return new b$a(new IllegalArgumentException(sbU.toString()));
                    }
                    Context context = this.a;
                    Uri uri = this.f1982b;
                    try {
                        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                        if (inputStreamOpenInputStream == null) {
                            iA = 0;
                        } else {
                            iA = new b.q.a.k.b(inputStreamOpenInputStream).a();
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException e) {
                        StringBuilder sbU2 = b.d.b.a.a.U("getExifOrientation: ");
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
                    b.q.a.i.b bVar = new b.q.a.i.b(iA, i2, i8);
                    Matrix matrix = new Matrix();
                    if (i2 != 0) {
                        matrix.preRotate(i2);
                    }
                    if (i8 != 1) {
                        matrix.postScale(i8, 1.0f);
                    }
                    if (matrix.isIdentity()) {
                        return new b$a(bitmapDecodeStream, bVar);
                    }
                    try {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix, true);
                        if (!bitmapDecodeStream.sameAs(bitmapCreateBitmap)) {
                            bitmapDecodeStream = bitmapCreateBitmap;
                        }
                    } catch (OutOfMemoryError e2) {
                        Log.e("BitmapLoadUtils", "transformBitmap: ", e2);
                    }
                    return new b$a(bitmapDecodeStream, bVar);
                }
                try {
                    try {
                        InputStream inputStreamOpenInputStream2 = this.a.getContentResolver().openInputStream(this.f1982b);
                        try {
                            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, bitmapFactory$Options);
                            if (bitmapFactory$Options.outWidth == -1 || bitmapFactory$Options.outHeight == -1) {
                                b$a b_a = new b$a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.f1982b + "]"));
                                if (inputStreamOpenInputStream2 != null) {
                                    try {
                                        inputStreamOpenInputStream2.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                return b_a;
                            }
                            if (inputStreamOpenInputStream2 != null) {
                                try {
                                    inputStreamOpenInputStream2.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if ((bitmapDecodeStream != null ? bitmapDecodeStream.getByteCount() : 0) > 104857600) {
                                bitmapFactory$Options.inSampleSize *= 2;
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
                        StringBuilder sbU3 = b.d.b.a.a.U("Bitmap could not be decoded from the Uri: [");
                        sbU3.append(this.f1982b);
                        sbU3.append("]");
                        return new b$a(new IllegalArgumentException(sbU3.toString(), e3));
                    }
                } catch (OutOfMemoryError e4) {
                    Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e4);
                    bitmapFactory$Options.inSampleSize *= 2;
                }
            }
        } catch (IOException | NullPointerException e5) {
            return new b$a(e5);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(@NonNull b$a b_a) {
        b$a b_a2 = b_a;
        Exception exc = b_a2.c;
        if (exc != null) {
            b.q.a.l.b bVar = (b.q.a.l.b) this.f;
            Objects.requireNonNull(bVar);
            Log.e("TransformImageView", "onFailure: setImageUri", exc);
            c$a c_a = bVar.a.p;
            if (c_a != null) {
                UCropActivity$a uCropActivity$a = (UCropActivity$a) c_a;
                uCropActivity$a.a.b(exc);
                uCropActivity$a.a.finish();
                return;
            }
            return;
        }
        b.q.a.h.b bVar2 = this.f;
        Bitmap bitmap = b_a2.a;
        b.q.a.i.b bVar3 = b_a2.f1983b;
        String path = this.f1982b.getPath();
        Uri uri = this.c;
        String path2 = uri == null ? null : uri.getPath();
        c cVar = ((b.q.a.l.b) bVar2).a;
        cVar.v = path;
        cVar.w = path2;
        cVar.f1991x = bVar3;
        cVar.f1990s = true;
        cVar.setImageBitmap(bitmap);
    }
}
