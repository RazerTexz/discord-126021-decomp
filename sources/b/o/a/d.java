package b.o.a;

import android.os.Handler;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: CameraUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements Runnable {
    public final /* synthetic */ byte[] j;
    public final /* synthetic */ File k;
    public final /* synthetic */ Handler l;
    public final /* synthetic */ k m;

    public d(byte[] bArr, File file, Handler handler, k kVar) {
        this.j = bArr;
        this.k = file;
        this.l = handler;
        this.m = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] bArr = this.j;
        File file = this.k;
        if (!file.exists() || file.delete()) {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                e.a.a(3, "writeToFile:", "could not write file.", e);
                file = null;
            }
        } else {
            file = null;
        }
        this.l.post(new d$a(this, file));
    }
}
