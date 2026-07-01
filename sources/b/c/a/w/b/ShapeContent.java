package b.c.a.w.b;

import android.graphics.Path;
import b.c.a.LottieDrawable;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.y.l.ShapeData;
import b.c.a.y.l.ShapePath2;
import b.c.a.y.m.BaseLayer2;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.b.q, reason: use source file name */
/* JADX INFO: compiled from: ShapeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeContent implements PathContent, BaseKeyframeAnimation.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f389b;
    public final LottieDrawable c;
    public final BaseKeyframeAnimation<?, Path> d;
    public boolean e;
    public final Path a = new Path();
    public CompoundTrimPathContent f = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, ShapePath2 shapePath2) {
        this.f389b = shapePath2.d;
        this.c = lottieDrawable;
        BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimationA = shapePath2.c.a();
        this.d = baseKeyframeAnimationA;
        baseLayer2.e(baseKeyframeAnimationA);
        baseKeyframeAnimationA.a.add(this);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        this.e = false;
        this.c.invalidateSelf();
    }

    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content2 content2 = list.get(i);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content2;
                if (trimPathContent.c == 1) {
                    this.f.a.add(trimPathContent);
                    trimPathContent.f391b.add(this);
                }
            }
        }
    }

    @Override // b.c.a.w.b.PathContent
    public Path getPath() {
        if (this.e) {
            return this.a;
        }
        this.a.reset();
        if (this.f389b) {
            this.e = true;
            return this.a;
        }
        this.a.set(this.d.e());
        this.a.setFillType(Path.FillType.EVEN_ODD);
        this.f.a(this.a);
        this.e = true;
        return this.a;
    }
}
