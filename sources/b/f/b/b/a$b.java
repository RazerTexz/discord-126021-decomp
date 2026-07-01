package b.f.b.b;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DefaultDiskStorage.java */
/* JADX INFO: loaded from: classes.dex */
public class a$b implements b.f.d.c.a {
    public final List<c$a> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f458b;

    public a$b(a aVar, a$a a_a) {
        this.f458b = aVar;
    }

    @Override // b.f.d.c.a
    public void a(File file) {
        a$d a_dH = a.h(this.f458b, file);
        if (a_dH == null || a_dH.a != ".cnt") {
            return;
        }
        this.a.add(new a$c(a_dH.f460b, file, null));
    }

    @Override // b.f.d.c.a
    public void b(File file) {
    }

    @Override // b.f.d.c.a
    public void c(File file) {
    }
}
