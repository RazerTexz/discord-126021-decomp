package p007b.p452o.p453a;

import android.os.Handler;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: renamed from: b.o.a.d */
/* JADX INFO: compiled from: CameraUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC5105d implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ byte[] f13699j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ File f13700k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Handler f13701l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ InterfaceC5112k f13702m;

    /* JADX INFO: renamed from: b.o.a.d$a */
    /* JADX INFO: compiled from: CameraUtils.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ File f13703j;

        public a(File file) {
            this.f13703j = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            RunnableC5105d.this.f13702m.mo7165a(this.f13703j);
        }
    }

    public RunnableC5105d(byte[] bArr, File file, Handler handler, InterfaceC5112k interfaceC5112k) {
        this.f13699j = bArr;
        this.f13700k = file;
        this.f13701l = handler;
        this.f13702m = interfaceC5112k;
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] bArr = this.f13699j;
        File file = this.f13700k;
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
                C5106e.f13705a.m7159a(3, "writeToFile:", "could not write file.", e);
                file = null;
            }
        } else {
            file = null;
        }
        this.f13701l.post(new a(file));
    }
}
