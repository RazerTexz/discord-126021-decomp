package b.c.a.w.c;

import b.c.a.c0.Keyframe;
import b.c.a.y.DocumentData;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.c.n, reason: use source file name */
/* JADX INFO: compiled from: TextKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    public TextKeyframeAnimation(List<Keyframe<DocumentData>> list) {
        super(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.w.c.BaseKeyframeAnimation
    public Object f(Keyframe keyframe, float f) {
        return (DocumentData) keyframe.f347b;
    }
}
