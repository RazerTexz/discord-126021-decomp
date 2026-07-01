package b.c.a.w.c;

import androidx.annotation.Nullable;
import java.util.Collections;

/* JADX INFO: compiled from: ValueCallbackKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class p<K, A> extends a<K, A> {
    public final A i;

    public p(b.c.a.c0.c<A> cVar, @Nullable A a) {
        super(Collections.emptyList());
        this.e = cVar;
        this.i = a;
    }

    @Override // b.c.a.w.c.a
    public float b() {
        return 1.0f;
    }

    @Override // b.c.a.w.c.a
    public A e() {
        b.c.a.c0.c<A> cVar = this.e;
        A a = this.i;
        float f = this.d;
        return cVar.a(0.0f, 0.0f, a, a, f, f, f);
    }

    @Override // b.c.a.w.c.a
    public A f(b.c.a.c0.a<K> aVar, float f) {
        return e();
    }

    @Override // b.c.a.w.c.a
    public void g() {
        if (this.e != null) {
            super.g();
        }
    }

    @Override // b.c.a.w.c.a
    public void h(float f) {
        this.d = f;
    }
}
