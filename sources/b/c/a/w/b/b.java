package b.c.a.w.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: CompoundTrimPathContent.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public List<s> a = new ArrayList();

    public void a(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            s sVar = this.a.get(size);
            PathMeasure pathMeasure = b.c.a.b0.g.a;
            if (sVar != null && !sVar.a) {
                b.c.a.b0.g.a(path, ((b.c.a.w.c.c) sVar.d).j() / 100.0f, ((b.c.a.w.c.c) sVar.e).j() / 100.0f, ((b.c.a.w.c.c) sVar.f).j() / 360.0f);
            }
        }
    }
}
