package b.c.a.w.b;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import b.c.a.w.c.TransformKeyframeAnimation;
import b.c.a.y.l.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: renamed from: b.c.a.w.b.l, reason: use source file name */
/* JADX INFO: compiled from: MergePathsContent.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public class MergePathsContent implements PathContent, GreedyContent {
    public final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f385b = new Path();
    public final Path c = new Path();
    public final List<PathContent> d = new ArrayList();
    public final MergePaths e;

    public MergePathsContent(MergePaths mergePaths) {
        this.e = mergePaths;
    }

    @TargetApi(19)
    public final void a(Path.Op op) {
        Matrix matrixE;
        Matrix matrixE2;
        this.f385b.reset();
        this.a.reset();
        for (int size = this.d.size() - 1; size >= 1; size--) {
            PathContent pathContent = this.d.get(size);
            if (pathContent instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) pathContent;
                List<PathContent> listE = contentGroup.e();
                for (int size2 = listE.size() - 1; size2 >= 0; size2--) {
                    Path path = listE.get(size2).getPath();
                    TransformKeyframeAnimation transformKeyframeAnimation = contentGroup.k;
                    if (transformKeyframeAnimation != null) {
                        matrixE2 = transformKeyframeAnimation.e();
                    } else {
                        contentGroup.c.reset();
                        matrixE2 = contentGroup.c;
                    }
                    path.transform(matrixE2);
                    this.f385b.addPath(path);
                }
            } else {
                this.f385b.addPath(pathContent.getPath());
            }
        }
        PathContent pathContent2 = this.d.get(0);
        if (pathContent2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) pathContent2;
            List<PathContent> listE2 = contentGroup2.e();
            for (int i = 0; i < listE2.size(); i++) {
                Path path2 = listE2.get(i).getPath();
                TransformKeyframeAnimation transformKeyframeAnimation2 = contentGroup2.k;
                if (transformKeyframeAnimation2 != null) {
                    matrixE = transformKeyframeAnimation2.e();
                } else {
                    contentGroup2.c.reset();
                    matrixE = contentGroup2.c;
                }
                path2.transform(matrixE);
                this.a.addPath(path2);
            }
        } else {
            this.a.set(pathContent2.getPath());
        }
        this.c.op(this.a, this.f385b, op);
    }

    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < this.d.size(); i++) {
            this.d.get(i).b(list, list2);
        }
    }

    @Override // b.c.a.w.b.GreedyContent
    public void e(ListIterator<Content2> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content2 content2Previous = listIterator.previous();
            if (content2Previous instanceof PathContent) {
                this.d.add((PathContent) content2Previous);
                listIterator.remove();
            }
        }
    }

    @Override // b.c.a.w.b.PathContent
    public Path getPath() {
        this.c.reset();
        MergePaths mergePaths = this.e;
        if (mergePaths.c) {
            return this.c;
        }
        int iOrdinal = mergePaths.f420b.ordinal();
        if (iOrdinal == 0) {
            for (int i = 0; i < this.d.size(); i++) {
                this.c.addPath(this.d.get(i).getPath());
            }
        } else if (iOrdinal == 1) {
            a(Path.Op.UNION);
        } else if (iOrdinal == 2) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (iOrdinal == 3) {
            a(Path.Op.INTERSECT);
        } else if (iOrdinal == 4) {
            a(Path.Op.XOR);
        }
        return this.c;
    }
}
