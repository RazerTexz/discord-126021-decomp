package p007b.p085c.p086a.p091w.p093c;

import androidx.annotation.Nullable;
import java.util.Collections;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p090c0.C1503c;

/* JADX INFO: renamed from: b.c.a.w.c.p */
/* JADX INFO: compiled from: ValueCallbackKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1559p<K, A> extends AbstractC1544a<K, A> {

    /* JADX INFO: renamed from: i */
    public final A f2641i;

    public C1559p(C1503c<A> c1503c, @Nullable A a) {
        super(Collections.emptyList());
        this.f2600e = c1503c;
        this.f2641i = a;
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: b */
    public float mo724b() {
        return 1.0f;
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: e */
    public A mo727e() {
        C1503c<A> c1503c = this.f2600e;
        A a = this.f2641i;
        float f = this.f2599d;
        return c1503c.m668a(0.0f, 0.0f, a, a, f, f, f);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: f */
    public A mo728f(C1501a<K> c1501a, float f) {
        return mo727e();
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: g */
    public void mo729g() {
        if (this.f2600e != null) {
            super.mo729g();
        }
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: h */
    public void mo730h(float f) {
        this.f2599d = f;
    }
}
