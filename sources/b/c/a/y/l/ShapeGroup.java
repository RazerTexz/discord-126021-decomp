package b.c.a.y.l;

import b.c.a.LottieDrawable;
import b.c.a.w.b.Content2;
import b.c.a.w.b.ContentGroup;
import b.c.a.y.m.BaseLayer2;
import b.d.b.a.outline;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.l.m, reason: use source file name */
/* JADX INFO: compiled from: ShapeGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeGroup implements ContentModel2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ContentModel2> f426b;
    public final boolean c;

    public ShapeGroup(String str, List<ContentModel2> list, boolean z2) {
        this.a = str;
        this.f426b = list;
        this.c = z2;
    }

    @Override // b.c.a.y.l.ContentModel2
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        return new ContentGroup(lottieDrawable, baseLayer2, this);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ShapeGroup{name='");
        sbU.append(this.a);
        sbU.append("' Shapes: ");
        sbU.append(Arrays.toString(this.f426b.toArray()));
        sbU.append('}');
        return sbU.toString();
    }
}
