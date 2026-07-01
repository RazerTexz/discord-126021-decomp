package b.f.b.b;

import b.f.a.FileBinaryResource;
import java.io.IOException;
import java.util.Collection;

/* JADX INFO: renamed from: b.f.b.b.c, reason: use source file name */
/* JADX INFO: compiled from: DiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
public interface DiskStorage {

    /* JADX INFO: renamed from: b.f.b.b.c$a */
    /* JADX INFO: compiled from: DiskStorage.java */
    public interface a {
        long a();

        String getId();

        long getSize();
    }

    /* JADX INFO: renamed from: b.f.b.b.c$b */
    /* JADX INFO: compiled from: DiskStorage.java */
    public interface b {
    }

    void a();

    b b(String str, Object obj) throws IOException;

    boolean c(String str, Object obj) throws IOException;

    FileBinaryResource d(String str, Object obj) throws IOException;

    Collection<a> e() throws IOException;

    long f(String str) throws IOException;

    long g(a aVar) throws IOException;

    boolean isExternal();
}
