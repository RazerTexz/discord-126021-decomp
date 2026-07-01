package b.c.a.y.k;

import android.graphics.Path;
import b.c.a.c0.Keyframe;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.ShapeKeyframeAnimation;
import b.c.a.y.l.ShapeData;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.k.h, reason: use source file name */
/* JADX INFO: compiled from: AnimatableShapeValue.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatableShapeValue extends BaseAnimatableValue<ShapeData, Path> {
    public AnimatableShapeValue(List<Keyframe<ShapeData>> list) {
        super((List) list);
    }

    @Override // b.c.a.y.k.AnimatableValue
    public BaseKeyframeAnimation<ShapeData, Path> a() {
        return new ShapeKeyframeAnimation(this.a);
    }
}
