package b.f.m;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Objects;

/* JADX INFO: compiled from: UnpackingSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class m$a implements Runnable {
    public final /* synthetic */ File j;
    public final /* synthetic */ byte[] k;
    public final /* synthetic */ m$c l;
    public final /* synthetic */ File m;
    public final /* synthetic */ g n;
    public final /* synthetic */ m o;

    public m$a(m mVar, File file, byte[] bArr, m$c m_c, File file2, g gVar) {
        this.o = mVar;
        this.j = file;
        this.k = bArr;
        this.l = m_c;
        this.m = file2;
        this.n = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                Log.v("fb-UnpackingSoSource", "starting syncer worker");
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.j, "rw");
                try {
                    randomAccessFile.write(this.k);
                    randomAccessFile.setLength(randomAccessFile.getFilePointer());
                    randomAccessFile.close();
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File(this.o.a, "dso_manifest"), "rw");
                    try {
                        m$c m_c = this.l;
                        Objects.requireNonNull(m_c);
                        randomAccessFile2.writeByte(1);
                        randomAccessFile2.writeInt(m_c.a.length);
                        int i = 0;
                        while (true) {
                            m$b[] m_bArr = m_c.a;
                            if (i >= m_bArr.length) {
                                randomAccessFile2.close();
                                b.c.a.a0.d.m0(this.o.a);
                                m.l(this.m, (byte) 1);
                                Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.o.a + " (from syncer thread)");
                                this.n.close();
                                return;
                            }
                            randomAccessFile2.writeUTF(m_bArr[i].j);
                            randomAccessFile2.writeUTF(m_c.a[i].k);
                            i++;
                            throw new RuntimeException(e);
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                randomAccessFile2.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (Throwable th7) {
                Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.o.a + " (from syncer thread)");
                this.n.close();
                throw th7;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
