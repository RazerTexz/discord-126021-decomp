package b.f.h.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import b.f.h.a.a.a;

/* JADX INFO: compiled from: AnimationBackendDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class b<T extends a> implements a {
    public T a;

    public b(T t) {
        this.a = t;
    }

    @Override // b.f.h.a.a.d
    public int a() {
        T t = this.a;
        if (t == null) {
            return 0;
        }
        return t.a();
    }

    @Override // b.f.h.a.a.d
    public int b() {
        T t = this.a;
        if (t == null) {
            return 0;
        }
        return t.b();
    }

    @Override // b.f.h.a.a.a
    public void clear() {
        T t = this.a;
        if (t != null) {
            t.clear();
        }
    }

    @Override // b.f.h.a.a.a
    public void d(ColorFilter colorFilter) {
        T t = this.a;
        if (t != null) {
            t.d(colorFilter);
        }
    }

    @Override // b.f.h.a.a.d
    public int e(int i) {
        T t = this.a;
        if (t == null) {
            return 0;
        }
        return t.e(i);
    }

    @Override // b.f.h.a.a.a
    public void f(@IntRange(from = 0, to = 255) int i) {
        T t = this.a;
        if (t != null) {
            t.f(i);
        }
    }

    @Override // b.f.h.a.a.a
    public int g() {
        T t = this.a;
        if (t == null) {
            return -1;
        }
        return t.g();
    }

    @Override // b.f.h.a.a.a
    public void h(Rect rect) {
        T t = this.a;
        if (t != null) {
            t.h(rect);
        }
    }

    @Override // b.f.h.a.a.a
    public int i() {
        T t = this.a;
        if (t == null) {
            return -1;
        }
        return t.i();
    }

    @Override // b.f.h.a.a.a
    public boolean j(Drawable drawable, Canvas canvas, int i) {
        T t = this.a;
        return t != null && t.j(drawable, canvas, i);
    }
}
