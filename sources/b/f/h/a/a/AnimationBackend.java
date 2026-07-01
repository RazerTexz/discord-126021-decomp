package b.f.h.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;

/* JADX INFO: renamed from: b.f.h.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: AnimationBackend.java */
/* JADX INFO: loaded from: classes.dex */
public interface AnimationBackend extends AnimationInformation {
    void clear();

    void d(ColorFilter colorFilter);

    void f(@IntRange(from = 0, to = 255) int i);

    int g();

    void h(Rect rect);

    int i();

    boolean j(Drawable drawable, Canvas canvas, int i);
}
