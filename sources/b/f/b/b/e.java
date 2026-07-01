package b.f.b.b;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.file.FileUtils$CreateDirectoryException;
import com.facebook.common.internal.Supplier;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: compiled from: DynamicDefaultDiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements c {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Supplier<File> f466b;
    public final String c;
    public final b.f.b.a.a d;

    @VisibleForTesting
    public volatile e$a e = new e$a(null, null);

    public e(int i, Supplier<File> supplier, String str, b.f.b.a.a aVar) {
        this.a = i;
        this.d = aVar;
        this.f466b = supplier;
        this.c = str;
    }

    @Override // b.f.b.b.c
    public void a() {
        try {
            i().a();
        } catch (IOException e) {
            b.f.d.e.a.b(e.class, "purgeUnexpectedResources", e);
        }
    }

    @Override // b.f.b.b.c
    public c$b b(String str, Object obj) throws IOException {
        return i().b(str, obj);
    }

    @Override // b.f.b.b.c
    public boolean c(String str, Object obj) throws IOException {
        return i().c(str, obj);
    }

    @Override // b.f.b.b.c
    public b.f.a.a d(String str, Object obj) throws IOException {
        return i().d(str, obj);
    }

    @Override // b.f.b.b.c
    public Collection<c$a> e() throws IOException {
        return i().e();
    }

    @Override // b.f.b.b.c
    public long f(String str) throws IOException {
        return i().f(str);
    }

    @Override // b.f.b.b.c
    public long g(c$a c_a) throws IOException {
        return i().g(c_a);
    }

    public final void h() throws IOException {
        File file = new File(this.f466b.get(), this.c);
        try {
            b.c.a.a0.d.l1(file);
            file.getAbsolutePath();
            int i = b.f.d.e.a.a;
            this.e = new e$a(file, new a(file, this.a, this.d));
        } catch (FileUtils$CreateDirectoryException e) {
            Objects.requireNonNull((b.f.b.a.d) this.d);
            throw e;
        }
    }

    @VisibleForTesting
    public synchronized c i() throws IOException {
        c cVar;
        File file;
        e$a e_a = this.e;
        if (e_a.a == null || (file = e_a.f467b) == null || !file.exists()) {
            if (this.e.a != null && this.e.f467b != null) {
                b.c.a.a0.d.Z(this.e.f467b);
            }
            h();
        }
        cVar = this.e.a;
        Objects.requireNonNull(cVar);
        return cVar;
    }

    @Override // b.f.b.b.c
    public boolean isExternal() {
        try {
            return i().isExternal();
        } catch (IOException unused) {
            return false;
        }
    }
}
