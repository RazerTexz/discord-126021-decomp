package b.o.a;

import android.os.Handler;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: renamed from: b.o.a.d, reason: use source file name */
/* JADX INFO: compiled from: CameraUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraUtils implements Runnable {
    public final /* synthetic */ byte[] j;
    public final /* synthetic */ File k;
    public final /* synthetic */ Handler l;
    public final /* synthetic */ FileCallback m;

    /* JADX INFO: renamed from: b.o.a.d$a */
    /* JADX INFO: compiled from: CameraUtils.java */
    public class a implements Runnable {
        public final /* synthetic */ File j;

        public a(File file) {
            this.j = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraUtils.this.m.a(this.j);
        }
    }

    public CameraUtils(byte[] bArr, File file, Handler handler, FileCallback fileCallback) {
        this.j = bArr;
        this.k = file;
        this.l = handler;
        this.m = fileCallback;
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
                CameraUtils2.a.a(3, "writeToFile:", "could not write file.", e);
                file = null;
            }
        } else {
            file = null;
        }
        this.l.post(new a(file));
    }
}
