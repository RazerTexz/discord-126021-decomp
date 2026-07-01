package b.c.a.y.l;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MergePaths.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g$a f420b;
    public final boolean c;

    public g(String str, g$a g_a, boolean z2) {
        this.a = str;
        this.f420b = g_a;
        this.c = z2;
    }

    @Override // b.c.a.y.l.b
    @Nullable
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        if (jVar.w) {
            return new b.c.a.w.b.l(this);
        }
        b.c.a.b0.c.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("MergePaths{mode=");
        sbU.append(this.f420b);
        sbU.append('}');
        return sbU.toString();
    }
}
