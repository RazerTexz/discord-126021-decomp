package b.i.c.m.d.l;

import android.util.Log;
import b.d.b.a.outline;
import b.i.c.m.d.Logger3;
import b.i.c.m.d.k.CommonUtils;
import com.adjust.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: renamed from: b.i.c.m.d.l.e, reason: use source file name */
/* JADX INFO: compiled from: QueueFileLogStore.java */
/* JADX INFO: loaded from: classes3.dex */
public class QueueFileLogStore2 implements FileLogStore {
    public static final Charset a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f1711b;
    public final int c;
    public QueueFile d;

    /* JADX INFO: renamed from: b.i.c.m.d.l.e$a */
    /* JADX INFO: compiled from: QueueFileLogStore.java */
    public class a {
        public final byte[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1712b;

        public a(QueueFileLogStore2 queueFileLogStore2, byte[] bArr, int i) {
            this.a = bArr;
            this.f1712b = i;
        }
    }

    public QueueFileLogStore2(File file, int i) {
        this.f1711b = file;
        this.c = i;
    }

    @Override // b.i.c.m.d.l.FileLogStore
    public void a() {
        CommonUtils.c(this.d, "There was a problem closing the Crashlytics log file.");
        this.d = null;
    }

    @Override // b.i.c.m.d.l.FileLogStore
    public String b() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return new String(bArrC, a);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x000a  */
    @Override // b.i.c.m.d.l.FileLogStore
    public byte[] c() {
        a aVar;
        if (this.f1711b.exists()) {
            f();
            QueueFile queueFile = this.d;
            if (queueFile == null) {
                aVar = null;
            } else {
                int[] iArr = {0};
                byte[] bArr = new byte[queueFile.x()];
                try {
                    this.d.e(new QueueFileLogStore(this, bArr, iArr));
                } catch (IOException e) {
                    if (Logger3.a.a(6)) {
                        Log.e("FirebaseCrashlytics", "A problem occurred while reading the Crashlytics log file.", e);
                    }
                }
                aVar = new a(this, bArr, iArr[0]);
            }
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        int i = aVar.f1712b;
        byte[] bArr2 = new byte[i];
        System.arraycopy(aVar.a, 0, bArr2, 0, i);
        return bArr2;
    }

    @Override // b.i.c.m.d.l.FileLogStore
    public void d() {
        CommonUtils.c(this.d, "There was a problem closing the Crashlytics log file.");
        this.d = null;
        this.f1711b.delete();
    }

    @Override // b.i.c.m.d.l.FileLogStore
    public void e(long j, String str) {
        f();
        if (this.d == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i = this.c / 4;
            if (str.length() > i) {
                str = "..." + str.substring(str.length() - i);
            }
            this.d.b(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(a));
            while (!this.d.f() && this.d.x() > this.c) {
                this.d.s();
            }
        } catch (IOException e) {
            if (Logger3.a.a(6)) {
                Log.e("FirebaseCrashlytics", "There was a problem writing to the Crashlytics log.", e);
            }
        }
    }

    public final void f() {
        if (this.d == null) {
            try {
                this.d = new QueueFile(this.f1711b);
            } catch (IOException e) {
                Logger3 logger3 = Logger3.a;
                StringBuilder sbU = outline.U("Could not open log file: ");
                sbU.append(this.f1711b);
                logger3.e(sbU.toString(), e);
            }
        }
    }
}
