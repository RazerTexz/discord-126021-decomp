package b.c.a.w.b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import b.c.a.b0.Utils;
import b.c.a.w.c.FloatKeyframeAnimation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.b.b, reason: use source file name */
/* JADX INFO: compiled from: CompoundTrimPathContent.java */
/* JADX INFO: loaded from: classes.dex */
public class CompoundTrimPathContent {
    public List<TrimPathContent> a = new ArrayList();

    public void a(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            TrimPathContent trimPathContent = this.a.get(size);
            PathMeasure pathMeasure = Utils.a;
            if (trimPathContent != null && !trimPathContent.a) {
                Utils.a(path, ((FloatKeyframeAnimation) trimPathContent.d).j() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.e).j() / 100.0f, ((FloatKeyframeAnimation) trimPathContent.f).j() / 360.0f);
            }
        }
    }
}
