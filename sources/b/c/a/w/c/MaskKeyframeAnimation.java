package b.c.a.w.c;

import android.graphics.Path;
import b.c.a.y.l.Mask;
import b.c.a.y.l.ShapeData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.c.g, reason: use source file name */
/* JADX INFO: compiled from: MaskKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class MaskKeyframeAnimation {
    public final List<BaseKeyframeAnimation<ShapeData, Path>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<BaseKeyframeAnimation<Integer, Integer>> f395b;
    public final List<Mask> c;

    public MaskKeyframeAnimation(List<Mask> list) {
        this.c = list;
        this.a = new ArrayList(list.size());
        this.f395b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.a.add(list.get(i).f419b.a());
            this.f395b.add(list.get(i).c.a());
        }
    }
}
