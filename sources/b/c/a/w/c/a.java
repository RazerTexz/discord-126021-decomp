package b.c.a.w.c;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: BaseKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<K, A> {
    public final a$d<K> c;

    @Nullable
    public b.c.a.c0.c<A> e;
    public final List<a$b> a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f392b = false;
    public float d = 0.0f;

    @Nullable
    public A f = null;
    public float g = -1.0f;
    public float h = -1.0f;

    public a(List<? extends b.c.a.c0.a<K>> list) {
        a$d<K> a_f;
        if (list.isEmpty()) {
            a_f = new a$c<>(null);
        } else {
            a_f = list.size() == 1 ? new a$f<>(list) : new a$e<>(list);
        }
        this.c = a_f;
    }

    public b.c.a.c0.a<K> a() {
        b.c.a.c0.a<K> aVarB = this.c.b();
        b.c.a.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        return aVarB;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float b() {
        if (this.h == -1.0f) {
            this.h = this.c.d();
        }
        return this.h;
    }

    public float c() {
        b.c.a.c0.a<K> aVarA = a();
        if (aVarA.d()) {
            return 0.0f;
        }
        return aVarA.d.getInterpolation(d());
    }

    public float d() {
        if (this.f392b) {
            return 0.0f;
        }
        b.c.a.c0.a<K> aVarA = a();
        if (aVarA.d()) {
            return 0.0f;
        }
        return (this.d - aVarA.c()) / (aVarA.b() - aVarA.c());
    }

    public A e() {
        float fC = c();
        if (this.e == null && this.c.a(fC)) {
            return this.f;
        }
        A aF = f(a(), fC);
        this.f = aF;
        return aF;
    }

    public abstract A f(b.c.a.c0.a<K> aVar, float f);

    public void g() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).a();
        }
    }

    public void h(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.c.isEmpty()) {
            return;
        }
        if (this.g == -1.0f) {
            this.g = this.c.e();
        }
        float f2 = this.g;
        if (f < f2) {
            if (f2 == -1.0f) {
                this.g = this.c.e();
            }
            f = this.g;
        } else if (f > b()) {
            f = b();
        }
        if (f == this.d) {
            return;
        }
        this.d = f;
        if (this.c.c(f)) {
            g();
        }
    }

    public void i(@Nullable b.c.a.c0.c<A> cVar) {
        b.c.a.c0.c<A> cVar2 = this.e;
        this.e = null;
    }
}
