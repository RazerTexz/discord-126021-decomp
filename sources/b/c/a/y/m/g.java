package b.c.a.y.m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import b.c.a.j;
import b.c.a.y.l.m;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ShapeLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends b {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b.c.a.w.b.d f440x;

    public g(j jVar, e eVar) {
        super(jVar, eVar);
        b.c.a.w.b.d dVar = new b.c.a.w.b.d(jVar, this, new m("__container", eVar.a, false));
        this.f440x = dVar;
        dVar.b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // b.c.a.y.m.b, b.c.a.w.b.e
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        super.d(rectF, matrix, z2);
        this.f440x.d(rectF, this.m, z2);
    }

    @Override // b.c.a.y.m.b
    public void j(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.f440x.f(canvas, matrix, i);
    }

    @Override // b.c.a.y.m.b
    public void n(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2) {
        this.f440x.c(fVar, i, list, fVar2);
    }
}
