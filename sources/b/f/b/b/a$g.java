package b.f.b.b;

import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: DefaultDiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
public class a$g implements b.f.d.c.a {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f462b;

    public a$g(a aVar, a$a a_a) {
        this.f462b = aVar;
    }

    @Override // b.f.d.c.a
    public void a(File file) {
        if (this.a) {
            a$d a_dH = a.h(this.f462b, file);
            boolean z2 = false;
            if (a_dH != null) {
                String str = a_dH.a;
                if (str == ".tmp") {
                    long jLastModified = file.lastModified();
                    Objects.requireNonNull((b.f.d.k.c) this.f462b.g);
                    if (jLastModified > System.currentTimeMillis() - a.a) {
                    }
                } else {
                    b.c.a.a0.d.B(str == ".cnt");
                }
                z2 = true;
            }
            if (z2) {
                return;
            }
        }
        file.delete();
    }

    @Override // b.f.d.c.a
    public void b(File file) {
        if (this.a || !file.equals(this.f462b.e)) {
            return;
        }
        this.a = true;
    }

    @Override // b.f.d.c.a
    public void c(File file) {
        if (!this.f462b.c.equals(file) && !this.a) {
            file.delete();
        }
        if (this.a && file.equals(this.f462b.e)) {
            this.a = false;
        }
    }
}
