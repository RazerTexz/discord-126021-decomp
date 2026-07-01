package b.i.c.w;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.esotericsoftware.kryo.io.Util;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayDeque;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n implements Callable {
    public final o j;

    public n(o oVar) {
        this.j = oVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws IOException {
        byte[] bArrA;
        o oVar = this.j;
        String strValueOf = String.valueOf(oVar.j);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
        sb.append("Starting download of: ");
        sb.append(strValueOf);
        Log.i("FirebaseMessaging", sb.toString());
        URLConnection uRLConnectionOpenConnection = oVar.j.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            oVar.l = inputStream;
            int i = b.i.a.f.h.i.b.a;
            b.i.a.f.h.i.d dVar = new b.i.a.f.h.i.d(inputStream);
            ArrayDeque arrayDeque = new ArrayDeque(20);
            int i2 = 8192;
            int i3 = 0;
            loop0: while (true) {
                if (i3 >= 2147483639) {
                    if (dVar.read() != -1) {
                        throw new OutOfMemoryError("input is too large to fit in a byte array");
                    }
                    bArrA = b.i.a.f.h.i.b.a(arrayDeque, Util.MAX_SAFE_ARRAY_SIZE);
                    break;
                }
                int iMin = Math.min(i2, Util.MAX_SAFE_ARRAY_SIZE - i3);
                byte[] bArr = new byte[iMin];
                arrayDeque.add(bArr);
                int i4 = 0;
                while (i4 < iMin) {
                    int i5 = dVar.read(bArr, i4, iMin - i4);
                    if (i5 == -1) {
                        bArrA = b.i.a.f.h.i.b.a(arrayDeque, i3);
                        break loop0;
                    }
                    i4 += i5;
                    i3 += i5;
                }
                long j = ((long) i2) << 1;
                if (j > 2147483647L) {
                    i2 = Integer.MAX_VALUE;
                } else {
                    i2 = j < -2147483648L ? Integer.MIN_VALUE : (int) j;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                int length = bArrA.length;
                String strValueOf2 = String.valueOf(oVar.j);
                StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 34);
                sb2.append("Downloaded ");
                sb2.append(length);
                sb2.append(" bytes from ");
                sb2.append(strValueOf2);
                Log.v("FirebaseMessaging", sb2.toString());
            }
            if (bArrA.length > 1048576) {
                throw new IOException("Image exceeds max size of 1048576");
            }
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length);
            if (bitmapDecodeByteArray == null) {
                String strValueOf3 = String.valueOf(oVar.j);
                throw new IOException(b.d.b.a.a.j(strValueOf3.length() + 24, "Failed to decode image: ", strValueOf3));
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String strValueOf4 = String.valueOf(oVar.j);
                StringBuilder sb3 = new StringBuilder(strValueOf4.length() + 31);
                sb3.append("Successfully downloaded image: ");
                sb3.append(strValueOf4);
                Log.d("FirebaseMessaging", sb3.toString());
            }
            return bitmapDecodeByteArray;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    b.i.a.f.h.i.e.a.a(th, th2);
                }
            }
            throw th;
        }
    }
}
