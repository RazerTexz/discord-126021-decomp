package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ShapePath$a extends ShapePath$d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f3058b;
    public final /* synthetic */ Matrix c;

    public ShapePath$a(ShapePath shapePath, List list, Matrix matrix) {
        this.f3058b = list;
        this.c = matrix;
    }

    @Override // com.google.android.material.shape.ShapePath$d
    public void a(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
        Iterator it = this.f3058b.iterator();
        while (it.hasNext()) {
            ((ShapePath$d) it.next()).a(this.c, shadowRenderer, i, canvas);
        }
    }
}
