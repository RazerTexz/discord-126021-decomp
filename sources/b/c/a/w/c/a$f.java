package b.c.a.w.c;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: compiled from: BaseKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public final class a$f<T> implements a$d<T> {

    @NonNull
    public final b.c.a.c0.a<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f394b = -1.0f;

    public a$f(List<? extends b.c.a.c0.a<T>> list) {
        this.a = list.get(0);
    }

    @Override // b.c.a.w.c.a$d
    public boolean a(float f) {
        if (this.f394b == f) {
            return true;
        }
        this.f394b = f;
        return false;
    }

    @Override // b.c.a.w.c.a$d
    public b.c.a.c0.a<T> b() {
        return this.a;
    }

    @Override // b.c.a.w.c.a$d
    public boolean c(float f) {
        return !this.a.d();
    }

    @Override // b.c.a.w.c.a$d
    public float d() {
        return this.a.b();
    }

    @Override // b.c.a.w.c.a$d
    public float e() {
        return this.a.c();
    }

    @Override // b.c.a.w.c.a$d
    public boolean isEmpty() {
        return false;
    }
}
