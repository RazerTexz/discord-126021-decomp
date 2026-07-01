package b.c.a.y.l;

import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.b0.Logger2;
import b.c.a.w.b.Content2;
import b.c.a.w.b.MergePathsContent;
import b.c.a.y.m.BaseLayer2;
import b.d.b.a.outline;

/* JADX INFO: renamed from: b.c.a.y.l.g, reason: use source file name */
/* JADX INFO: compiled from: MergePaths.java */
/* JADX INFO: loaded from: classes.dex */
public class MergePaths implements ContentModel2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f420b;
    public final boolean c;

    /* JADX INFO: renamed from: b.c.a.y.l.g$a */
    /* JADX INFO: compiled from: MergePaths.java */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS
    }

    public MergePaths(String str, a aVar, boolean z2) {
        this.a = str;
        this.f420b = aVar;
        this.c = z2;
    }

    @Override // b.c.a.y.l.ContentModel2
    @Nullable
    public Content2 a(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2) {
        if (lottieDrawable.w) {
            return new MergePathsContent(this);
        }
        Logger2.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        StringBuilder sbU = outline.U("MergePaths{mode=");
        sbU.append(this.f420b);
        sbU.append('}');
        return sbU.toString();
    }
}
