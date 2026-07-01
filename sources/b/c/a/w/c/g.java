package b.c.a.w.c;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MaskKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public final List<a<b.c.a.y.l.k, Path>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a<Integer, Integer>> f395b;
    public final List<b.c.a.y.l.f> c;

    public g(List<b.c.a.y.l.f> list) {
        this.c = list;
        this.a = new ArrayList(list.size());
        this.f395b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.a.add(list.get(i).f419b.a());
            this.f395b.add(list.get(i).c.a());
        }
    }
}
