package b.c.a.y.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import b.c.a.LottieDrawable;
import b.c.a.w.b.ContentGroup;
import b.c.a.y.KeyPath;
import b.c.a.y.l.ShapeGroup;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.m.g, reason: use source file name */
/* JADX INFO: compiled from: ShapeLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class ShapeLayer extends BaseLayer2 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ContentGroup f440x;

    public ShapeLayer(LottieDrawable lottieDrawable, Layer2 layer2) {
        super(lottieDrawable, layer2);
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer2.a, false));
        this.f440x = contentGroup;
        contentGroup.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // b.c.a.y.m.BaseLayer2, b.c.a.w.b.DrawingContent
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        this.f440x.d(rectF, this.m, z2);
    }

    @Override // b.c.a.y.m.BaseLayer2
    public void j(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.f440x.f(canvas, matrix, i);
    }

    @Override // b.c.a.y.m.BaseLayer2
    public void n(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        this.f440x.c(keyPath, i, list, keyPath2);
    }
}
