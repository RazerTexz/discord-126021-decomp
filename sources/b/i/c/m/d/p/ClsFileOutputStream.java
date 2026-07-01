package b.i.c.m.d.p;

import b.d.b.a.outline;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.c.m.d.p.b, reason: use source file name */
/* JADX INFO: compiled from: ClsFileOutputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClsFileOutputStream extends FileOutputStream {
    public static final FilenameFilter j = new a();
    public final String k;
    public File l;
    public boolean m;

    /* JADX INFO: renamed from: b.i.c.m.d.p.b$a */
    /* JADX INFO: compiled from: ClsFileOutputStream.java */
    public class a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public ClsFileOutputStream(File file, String str) throws FileNotFoundException {
        super(new File(file, outline.w(str, ".cls_temp")));
        this.m = false;
        StringBuilder sb = new StringBuilder();
        sb.append(file);
        String strJ = outline.J(sb, File.separator, str);
        this.k = strJ;
        this.l = new File(outline.w(strJ, ".cls_temp"));
    }

    public void a() throws IOException {
        if (this.m) {
            return;
        }
        this.m = true;
        flush();
        super.close();
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.m) {
            return;
        }
        this.m = true;
        flush();
        super.close();
        File file = new File(this.k + ".cls");
        if (this.l.renameTo(file)) {
            this.l = null;
            return;
        }
        String str = "";
        if (file.exists()) {
            str = " (target already exists)";
        } else if (!this.l.exists()) {
            str = " (source does not exist)";
        }
        throw new IOException("Could not rename temp file: " + this.l + " -> " + file + str);
    }
}
