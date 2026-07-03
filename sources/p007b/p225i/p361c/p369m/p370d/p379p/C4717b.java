package p007b.p225i.p361c.p369m.p370d.p379p;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.m.d.p.b */
/* JADX INFO: compiled from: ClsFileOutputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4717b extends FileOutputStream {

    /* JADX INFO: renamed from: j */
    public static final FilenameFilter f12686j = new a();

    /* JADX INFO: renamed from: k */
    public final String f12687k;

    /* JADX INFO: renamed from: l */
    public File f12688l;

    /* JADX INFO: renamed from: m */
    public boolean f12689m;

    /* JADX INFO: renamed from: b.i.c.m.d.p.b$a */
    /* JADX INFO: compiled from: ClsFileOutputStream.java */
    public class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public C4717b(File file, String str) throws FileNotFoundException {
        super(new File(file, C1643a.m883w(str, ".cls_temp")));
        this.f12689m = false;
        StringBuilder sb = new StringBuilder();
        sb.append(file);
        String strM822J = C1643a.m822J(sb, File.separator, str);
        this.f12687k = strM822J;
        this.f12688l = new File(C1643a.m883w(strM822J, ".cls_temp"));
    }

    /* JADX INFO: renamed from: a */
    public void m6638a() throws IOException {
        if (this.f12689m) {
            return;
        }
        this.f12689m = true;
        flush();
        super.close();
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f12689m) {
            return;
        }
        this.f12689m = true;
        flush();
        super.close();
        File file = new File(this.f12687k + ".cls");
        if (this.f12688l.renameTo(file)) {
            this.f12688l = null;
            return;
        }
        String str = "";
        if (file.exists()) {
            str = " (target already exists)";
        } else if (!this.f12688l.exists()) {
            str = " (source does not exist)";
        }
        throw new IOException("Could not rename temp file: " + this.f12688l + " -> " + file + str);
    }
}
