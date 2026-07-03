package p007b.p085c.p086a.p091w.p093c;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.p095y.p097l.C1591f;
import p007b.p085c.p086a.p095y.p097l.C1596k;

/* JADX INFO: renamed from: b.c.a.w.c.g */
/* JADX INFO: compiled from: MaskKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1550g {

    /* JADX INFO: renamed from: a */
    public final List<AbstractC1544a<C1596k, Path>> f2611a;

    /* JADX INFO: renamed from: b */
    public final List<AbstractC1544a<Integer, Integer>> f2612b;

    /* JADX INFO: renamed from: c */
    public final List<C1591f> f2613c;

    public C1550g(List<C1591f> list) {
        this.f2613c = list;
        this.f2611a = new ArrayList(list.size());
        this.f2612b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f2611a.add(list.get(i).f2768b.mo773a());
            this.f2612b.add(list.get(i).f2769c.mo773a());
        }
    }
}
