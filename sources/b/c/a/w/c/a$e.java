package b.c.a.w.c;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: compiled from: BaseKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public final class a$e<T> implements a$d<T> {
    public final List<? extends b.c.a.c0.a<T>> a;
    public b.c.a.c0.a<T> c = null;
    public float d = -1.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public b.c.a.c0.a<T> f393b = f(0.0f);

    public a$e(List<? extends b.c.a.c0.a<T>> list) {
        this.a = list;
    }

    @Override // b.c.a.w.c.a$d
    public boolean a(float f) {
        b.c.a.c0.a<T> aVar = this.c;
        b.c.a.c0.a<T> aVar2 = this.f393b;
        if (aVar == aVar2 && this.d == f) {
            return true;
        }
        this.c = aVar2;
        this.d = f;
        return false;
    }

    @Override // b.c.a.w.c.a$d
    @NonNull
    public b.c.a.c0.a<T> b() {
        return this.f393b;
    }

    @Override // b.c.a.w.c.a$d
    public boolean c(float f) {
        if (this.f393b.a(f)) {
            return !this.f393b.d();
        }
        this.f393b = f(f);
        return true;
    }

    @Override // b.c.a.w.c.a$d
    public float d() {
        List<? extends b.c.a.c0.a<T>> list = this.a;
        return list.get(list.size() - 1).b();
    }

    @Override // b.c.a.w.c.a$d
    public float e() {
        return this.a.get(0).c();
    }

    public final b.c.a.c0.a<T> f(float f) {
        List<? extends b.c.a.c0.a<T>> list = this.a;
        b.c.a.c0.a<T> aVar = list.get(list.size() - 1);
        if (f >= aVar.c()) {
            return aVar;
        }
        for (int size = this.a.size() - 2; size >= 1; size--) {
            b.c.a.c0.a<T> aVar2 = this.a.get(size);
            if (this.f393b != aVar2 && aVar2.a(f)) {
                return aVar2;
            }
        }
        return this.a.get(0);
    }

    @Override // b.c.a.w.c.a$d
    public boolean isEmpty() {
        return false;
    }
}
