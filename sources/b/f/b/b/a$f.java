package b.f.b.b;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.file.FileUtils$ParentDirNotFoundException;
import com.facebook.common.file.FileUtils$RenameException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: DefaultDiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public class a$f implements c$b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public final File f461b;
    public final /* synthetic */ a c;

    public a$f(a aVar, String str, File file) {
        this.c = aVar;
        this.a = str;
        this.f461b = file;
    }

    public boolean a() {
        return !this.f461b.exists() || this.f461b.delete();
    }

    public b.f.a.a b(Object obj) throws IOException {
        Objects.requireNonNull((b.f.d.k.c) this.c.g);
        long jCurrentTimeMillis = System.currentTimeMillis();
        File fileJ = this.c.j(this.a);
        try {
            b.c.a.a0.d.Q1(this.f461b, fileJ);
            if (fileJ.exists()) {
                fileJ.setLastModified(jCurrentTimeMillis);
            }
            return new b.f.a.a(fileJ);
        } catch (FileUtils$RenameException e) {
            Throwable cause = e.getCause();
            if (cause != null && !(cause instanceof FileUtils$ParentDirNotFoundException)) {
                boolean z2 = cause instanceof FileNotFoundException;
            }
            b.f.b.a.a aVar = this.c.f;
            int i = a.f457b;
            Objects.requireNonNull((b.f.b.a.d) aVar);
            throw e;
        }
    }

    public void c(b.f.b.a.g gVar, Object obj) throws IOException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f461b);
            try {
                b.f.d.d.b bVar = new b.f.d.d.b(fileOutputStream);
                b.f.j.c.h hVar = (b.f.j.c.h) gVar;
                InputStream inputStreamE = hVar.a.e();
                Objects.requireNonNull(inputStreamE);
                hVar.f556b.c.a(inputStreamE, bVar);
                bVar.flush();
                long j = bVar.j;
                fileOutputStream.close();
                if (this.f461b.length() != j) {
                    throw new a$e(j, this.f461b.length());
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e) {
            b.f.b.a.a aVar = this.c.f;
            int i = a.f457b;
            Objects.requireNonNull((b.f.b.a.d) aVar);
            throw e;
        }
    }
}
