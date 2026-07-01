package b.i.a.c.f3;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: AtomicFile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f967b;

    public e(File file) {
        this.a = file;
        this.f967b = new File(String.valueOf(file.getPath()).concat(".bak"));
    }

    public boolean a() {
        return this.a.exists() || this.f967b.exists();
    }

    public InputStream b() throws FileNotFoundException {
        if (this.f967b.exists()) {
            this.a.delete();
            this.f967b.renameTo(this.a);
        }
        return new FileInputStream(this.a);
    }

    public OutputStream c() throws IOException {
        if (this.a.exists()) {
            if (this.f967b.exists()) {
                this.a.delete();
            } else if (!this.a.renameTo(this.f967b)) {
                String strValueOf = String.valueOf(this.a);
                String strValueOf2 = String.valueOf(this.f967b);
                Log.w("AtomicFile", b.d.b.a.a.l(strValueOf2.length() + strValueOf.length() + 37, "Couldn't rename file ", strValueOf, " to backup file ", strValueOf2));
            }
        }
        try {
            return new e$a(this.a);
        } catch (FileNotFoundException e) {
            File parentFile = this.a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                String strValueOf3 = String.valueOf(this.a);
                throw new IOException(b.d.b.a.a.j(strValueOf3.length() + 16, "Couldn't create ", strValueOf3), e);
            }
            try {
                return new e$a(this.a);
            } catch (FileNotFoundException e2) {
                String strValueOf4 = String.valueOf(this.a);
                throw new IOException(b.d.b.a.a.j(strValueOf4.length() + 16, "Couldn't create ", strValueOf4), e2);
            }
        }
    }
}
