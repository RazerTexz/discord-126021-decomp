package b.i.c.m.e;

import b.i.c.m.d.NativeSessionFileProvider;
import java.io.File;

/* JADX INFO: renamed from: b.i.c.m.e.h, reason: use source file name */
/* JADX INFO: compiled from: SessionFilesProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public class SessionFilesProvider implements NativeSessionFileProvider {
    public final SessionFiles a;

    public SessionFilesProvider(SessionFiles sessionFiles) {
        this.a = sessionFiles;
    }

    @Override // b.i.c.m.d.NativeSessionFileProvider
    public File a() {
        return this.a.d;
    }

    @Override // b.i.c.m.d.NativeSessionFileProvider
    public File b() {
        return this.a.f;
    }

    @Override // b.i.c.m.d.NativeSessionFileProvider
    public File c() {
        return this.a.e;
    }

    @Override // b.i.c.m.d.NativeSessionFileProvider
    public File d() {
        return this.a.a;
    }

    @Override // b.i.c.m.d.NativeSessionFileProvider
    public File e() {
        return this.a.c;
    }

    @Override // b.i.c.m.d.NativeSessionFileProvider
    public File f() {
        return this.a.f1756b;
    }
}
