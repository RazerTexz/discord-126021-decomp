package b.i.a.c.f3;

import android.util.Log;
import b.d.b.a.outline;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: renamed from: b.i.a.c.f3.e, reason: use source file name */
/* JADX INFO: compiled from: AtomicFile.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AtomicFile3 {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f967b;

    /* JADX INFO: renamed from: b.i.a.c.f3.e$a */
    /* JADX INFO: compiled from: AtomicFile.java */
    public static final class a extends OutputStream {
        public final FileOutputStream j;
        public boolean k = false;

        public a(File file) throws FileNotFoundException {
            this.j = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.k) {
                return;
            }
            this.k = true;
            this.j.flush();
            try {
                this.j.getFD().sync();
            } catch (IOException e) {
                Log2.c("AtomicFile", "Failed to sync file descriptor:", e);
            }
            this.j.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.j.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.j.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.j.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.j.write(bArr, i, i2);
        }
    }

    public AtomicFile3(File file) {
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
                Log.w("AtomicFile", outline.l(strValueOf2.length() + strValueOf.length() + 37, "Couldn't rename file ", strValueOf, " to backup file ", strValueOf2));
            }
        }
        try {
            return new a(this.a);
        } catch (FileNotFoundException e) {
            File parentFile = this.a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                String strValueOf3 = String.valueOf(this.a);
                throw new IOException(outline.j(strValueOf3.length() + 16, "Couldn't create ", strValueOf3), e);
            }
            try {
                return new a(this.a);
            } catch (FileNotFoundException e2) {
                String strValueOf4 = String.valueOf(this.a);
                throw new IOException(outline.j(strValueOf4.length() + 16, "Couldn't create ", strValueOf4), e2);
            }
        }
    }
}
