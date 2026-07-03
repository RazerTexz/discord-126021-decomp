package p007b.p485q.p486a.p489j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.yalantis.ucrop.UCropActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p485q.p486a.p487h.InterfaceC5293b;
import p007b.p485q.p486a.p488i.C5297b;
import p007b.p485q.p486a.p490k.C5302b;
import p007b.p485q.p486a.p491l.C5306b;
import p007b.p485q.p486a.p491l.C5307c;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12380x;
import p600f0.p601e0.p605g.C12285e;
import p615g0.C12399p;
import p615g0.C12408y;
import p615g0.InterfaceC12390g;

/* JADX INFO: renamed from: b.q.a.j.b */
/* JADX INFO: compiled from: BitmapLoadTask.java */
/* JADX INFO: loaded from: classes3.dex */
public class AsyncTaskC5300b extends AsyncTask<Void, Void, a> {

    /* JADX INFO: renamed from: a */
    public final Context f14426a;

    /* JADX INFO: renamed from: b */
    public Uri f14427b;

    /* JADX INFO: renamed from: c */
    public Uri f14428c;

    /* JADX INFO: renamed from: d */
    public final int f14429d;

    /* JADX INFO: renamed from: e */
    public final int f14430e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC5293b f14431f;

    public AsyncTaskC5300b(@NonNull Context context, @NonNull Uri uri, @Nullable Uri uri2, int i, int i2, InterfaceC5293b interfaceC5293b) {
        this.f14426a = context;
        this.f14427b = uri;
        this.f14428c = uri2;
        this.f14429d = i;
        this.f14430e = i2;
        this.f14431f = interfaceC5293b;
    }

    /* JADX INFO: renamed from: a */
    public final void m7472a(@NonNull Uri uri, @Nullable Uri uri2) throws Throwable {
        InputStream inputStreamOpenInputStream;
        Log.d("BitmapWorkerTask", "copyFile");
        Objects.requireNonNull(uri2, "Output Uri is null - cannot copy image");
        FileOutputStream fileOutputStream = null;
        try {
            inputStreamOpenInputStream = this.f14426a.getContentResolver().openInputStream(uri);
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
                    this.f14427b = this.f14428c;
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
                    this.f14427b = this.f14428c;
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
    /* JADX INFO: renamed from: b */
    public final void m7473b(@NonNull Uri uri, @Nullable Uri uri2) throws Throwable {
        Response responseExecute;
        C12399p c12399p;
        ResponseBody responseBody;
        Log.d("BitmapWorkerTask", "downloadFile");
        Objects.requireNonNull(uri2, "Output Uri is null - cannot download image");
        C12380x c12380x = new C12380x();
        InterfaceC12390g interfaceC12390g = null;
        try {
            Request.C12935a c12935a = new Request.C12935a();
            c12935a.m10983f(uri.toString());
            try {
                responseExecute = ((C12285e) c12380x.mo10114b(c12935a.m10978a())).execute();
                try {
                    InterfaceC12390g interfaceC12390gMo10105c = responseExecute.body.mo10105c();
                    try {
                        OutputStream outputStreamOpenOutputStream = this.f14426a.getContentResolver().openOutputStream(uri2);
                        if (outputStreamOpenOutputStream == null) {
                            throw new NullPointerException("OutputStream for given output Uri is null");
                        }
                        C12238m.checkParameterIsNotNull(outputStreamOpenOutputStream, "$this$sink");
                        c12399p = new C12399p(outputStreamOpenOutputStream, new C12408y());
                        try {
                            interfaceC12390gMo10105c.mo10459k0(c12399p);
                            try {
                                interfaceC12390gMo10105c.close();
                            } catch (IOException unused) {
                            }
                            try {
                                c12399p.close();
                            } catch (IOException unused2) {
                            }
                            ResponseBody responseBody2 = responseExecute.body;
                            if (responseBody2 != null) {
                                try {
                                    responseBody2.close();
                                } catch (IOException unused3) {
                                }
                            }
                            c12380x.f26012m.m10388a();
                            this.f14427b = this.f14428c;
                        } catch (Throwable th) {
                            th = th;
                            interfaceC12390g = interfaceC12390gMo10105c;
                            if (interfaceC12390g != null) {
                                try {
                                    interfaceC12390g.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (c12399p != null) {
                                try {
                                    c12399p.close();
                                } catch (IOException unused5) {
                                }
                            }
                            if (responseExecute != null && (responseBody = responseExecute.body) != null) {
                                try {
                                    responseBody.close();
                                } catch (IOException unused6) {
                                }
                            }
                            c12380x.f26012m.m10388a();
                            this.f14427b = this.f14428c;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c12399p = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    c12399p = null;
                }
            } catch (Throwable th4) {
                th = th4;
                responseExecute = null;
                c12399p = null;
                if (interfaceC12390g != null) {
                    interfaceC12390g.close();
                }
                if (c12399p != null) {
                    c12399p.close();
                }
                if (responseExecute != null) {
                    responseBody.close();
                }
                c12380x.f26012m.m10388a();
                this.f14427b = this.f14428c;
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m7474c() throws IOException, NullPointerException {
        String scheme = this.f14427b.getScheme();
        Log.d("BitmapWorkerTask", "Uri scheme: " + scheme);
        if ("http".equals(scheme) || Constants.SCHEME.equals(scheme)) {
            try {
                m7473b(this.f14427b, this.f14428c);
                return;
            } catch (IOException | NullPointerException e) {
                Log.e("BitmapWorkerTask", "Downloading failed", e);
                throw e;
            }
        }
        if ("content".equals(scheme)) {
            try {
                m7472a(this.f14427b, this.f14428c);
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
        throw new IllegalArgumentException(C1643a.m883w("Invalid Uri scheme", scheme));
    }

    @Override // android.os.AsyncTask
    @NonNull
    public a doInBackground(Void[] voidArr) {
        int i;
        int iM7475a;
        int i2;
        boolean z2;
        if (this.f14427b == null) {
            return new a(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            m7474c();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            int i3 = this.f14429d;
            int i4 = this.f14430e;
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
                        StringBuilder sbM833U = C1643a.m833U("Bitmap could not be decoded from the Uri: [");
                        sbM833U.append(this.f14427b);
                        sbM833U.append("]");
                        return new a(new IllegalArgumentException(sbM833U.toString()));
                    }
                    Context context = this.f14426a;
                    Uri uri = this.f14427b;
                    try {
                        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                        if (inputStreamOpenInputStream == null) {
                            iM7475a = 0;
                        } else {
                            iM7475a = new C5302b(inputStreamOpenInputStream).m7475a();
                            try {
                                inputStreamOpenInputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException e) {
                        StringBuilder sbM833U2 = C1643a.m833U("getExifOrientation: ");
                        sbM833U2.append(uri.toString());
                        Log.e("BitmapLoadUtils", sbM833U2.toString(), e);
                    }
                    switch (iM7475a) {
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
                    if (iM7475a != 2 && iM7475a != 7 && iM7475a != 4 && iM7475a != 5) {
                        i8 = 1;
                    }
                    C5297b c5297b = new C5297b(iM7475a, i2, i8);
                    Matrix matrix = new Matrix();
                    if (i2 != 0) {
                        matrix.preRotate(i2);
                    }
                    if (i8 != 1) {
                        matrix.postScale(i8, 1.0f);
                    }
                    if (matrix.isIdentity()) {
                        return new a(bitmapDecodeStream, c5297b);
                    }
                    try {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix, true);
                        if (!bitmapDecodeStream.sameAs(bitmapCreateBitmap)) {
                            bitmapDecodeStream = bitmapCreateBitmap;
                        }
                    } catch (OutOfMemoryError e2) {
                        Log.e("BitmapLoadUtils", "transformBitmap: ", e2);
                    }
                    return new a(bitmapDecodeStream, c5297b);
                }
                try {
                    try {
                        InputStream inputStreamOpenInputStream2 = this.f14426a.getContentResolver().openInputStream(this.f14427b);
                        try {
                            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, null, options);
                            if (options.outWidth == -1 || options.outHeight == -1) {
                                a aVar = new a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.f14427b + "]"));
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
                        StringBuilder sbM833U3 = C1643a.m833U("Bitmap could not be decoded from the Uri: [");
                        sbM833U3.append(this.f14427b);
                        sbM833U3.append("]");
                        return new a(new IllegalArgumentException(sbM833U3.toString(), e3));
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
        Exception exc = aVar2.f14434c;
        if (exc != null) {
            C5306b c5306b = (C5306b) this.f14431f;
            Objects.requireNonNull(c5306b);
            Log.e("TransformImageView", "onFailure: setImageUri", exc);
            C5307c.a aVar3 = c5306b.f14483a.f14490p;
            if (aVar3 != null) {
                UCropActivity.C11200a c11200a = (UCropActivity.C11200a) aVar3;
                UCropActivity.this.m9320b(exc);
                UCropActivity.this.finish();
                return;
            }
            return;
        }
        InterfaceC5293b interfaceC5293b = this.f14431f;
        Bitmap bitmap = aVar2.f14432a;
        C5297b c5297b = aVar2.f14433b;
        String path = this.f14427b.getPath();
        Uri uri = this.f14428c;
        String path2 = uri == null ? null : uri.getPath();
        C5307c c5307c = ((C5306b) interfaceC5293b).f14483a;
        c5307c.f14496v = path;
        c5307c.f14497w = path2;
        c5307c.f14498x = c5297b;
        c5307c.f14493s = true;
        c5307c.setImageBitmap(bitmap);
    }

    /* JADX INFO: renamed from: b.q.a.j.b$a */
    /* JADX INFO: compiled from: BitmapLoadTask.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public Bitmap f14432a;

        /* JADX INFO: renamed from: b */
        public C5297b f14433b;

        /* JADX INFO: renamed from: c */
        public Exception f14434c;

        public a(@NonNull Bitmap bitmap, @NonNull C5297b c5297b) {
            this.f14432a = bitmap;
            this.f14433b = c5297b;
        }

        public a(@NonNull Exception exc) {
            this.f14434c = exc;
        }
    }
}
