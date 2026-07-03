package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p091w.p093c.C1546c;

/* JADX INFO: renamed from: b.c.a.w.b.b */
/* JADX INFO: compiled from: CompoundTrimPathContent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1526b {

    /* JADX INFO: renamed from: a */
    public List<C1543s> f2481a = new ArrayList();

    /* JADX INFO: renamed from: a */
    public void m715a(Path path) {
        for (int size = this.f2481a.size() - 1; size >= 0; size--) {
            C1543s c1543s = this.f2481a.get(size);
            PathMeasure pathMeasure = C1499g.f2309a;
            if (c1543s != null && !c1543s.f2590a) {
                C1499g.m657a(path, ((C1546c) c1543s.f2593d).m739j() / 100.0f, ((C1546c) c1543s.f2594e).m739j() / 100.0f, ((C1546c) c1543s.f2595f).m739j() / 360.0f);
            }
        }
    }
}
