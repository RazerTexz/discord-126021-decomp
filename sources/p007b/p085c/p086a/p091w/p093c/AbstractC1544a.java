package p007b.p085c.p086a.p091w.p093c;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.C1500c;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p090c0.C1503c;

/* JADX INFO: renamed from: b.c.a.w.c.a */
/* JADX INFO: compiled from: BaseKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1544a<K, A> {

    /* JADX INFO: renamed from: c */
    public final d<K> f2598c;

    /* JADX INFO: renamed from: e */
    @Nullable
    public C1503c<A> f2600e;

    /* JADX INFO: renamed from: a */
    public final List<b> f2596a = new ArrayList(1);

    /* JADX INFO: renamed from: b */
    public boolean f2597b = false;

    /* JADX INFO: renamed from: d */
    public float f2599d = 0.0f;

    /* JADX INFO: renamed from: f */
    @Nullable
    public A f2601f = null;

    /* JADX INFO: renamed from: g */
    public float f2602g = -1.0f;

    /* JADX INFO: renamed from: h */
    public float f2603h = -1.0f;

    /* JADX INFO: renamed from: b.c.a.w.c.a$b */
    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo709a();
    }

    /* JADX INFO: renamed from: b.c.a.w.c.a$c */
    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    public static final class c<T> implements d<T> {
        public c(a aVar) {
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: a */
        public boolean mo732a(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: b */
        public C1501a<T> mo733b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: c */
        public boolean mo734c(float f) {
            return false;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: d */
        public float mo735d() {
            return 1.0f;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: e */
        public float mo736e() {
            return 0.0f;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: renamed from: b.c.a.w.c.a$d */
    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    public interface d<T> {
        /* JADX INFO: renamed from: a */
        boolean mo732a(float f);

        /* JADX INFO: renamed from: b */
        C1501a<T> mo733b();

        /* JADX INFO: renamed from: c */
        boolean mo734c(float f);

        @FloatRange(from = 0.0d, m75to = 1.0d)
        /* JADX INFO: renamed from: d */
        float mo735d();

        @FloatRange(from = 0.0d, m75to = 1.0d)
        /* JADX INFO: renamed from: e */
        float mo736e();

        boolean isEmpty();
    }

    /* JADX INFO: renamed from: b.c.a.w.c.a$e */
    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    public static final class e<T> implements d<T> {

        /* JADX INFO: renamed from: a */
        public final List<? extends C1501a<T>> f2604a;

        /* JADX INFO: renamed from: c */
        public C1501a<T> f2606c = null;

        /* JADX INFO: renamed from: d */
        public float f2607d = -1.0f;

        /* JADX INFO: renamed from: b */
        @NonNull
        public C1501a<T> f2605b = m737f(0.0f);

        public e(List<? extends C1501a<T>> list) {
            this.f2604a = list;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: a */
        public boolean mo732a(float f) {
            C1501a<T> c1501a = this.f2606c;
            C1501a<T> c1501a2 = this.f2605b;
            if (c1501a == c1501a2 && this.f2607d == f) {
                return true;
            }
            this.f2606c = c1501a2;
            this.f2607d = f;
            return false;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        @NonNull
        /* JADX INFO: renamed from: b */
        public C1501a<T> mo733b() {
            return this.f2605b;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: c */
        public boolean mo734c(float f) {
            if (this.f2605b.m664a(f)) {
                return !this.f2605b.m667d();
            }
            this.f2605b = m737f(f);
            return true;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: d */
        public float mo735d() {
            List<? extends C1501a<T>> list = this.f2604a;
            return list.get(list.size() - 1).m665b();
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: e */
        public float mo736e() {
            return this.f2604a.get(0).m666c();
        }

        /* JADX INFO: renamed from: f */
        public final C1501a<T> m737f(float f) {
            List<? extends C1501a<T>> list = this.f2604a;
            C1501a<T> c1501a = list.get(list.size() - 1);
            if (f >= c1501a.m666c()) {
                return c1501a;
            }
            for (int size = this.f2604a.size() - 2; size >= 1; size--) {
                C1501a<T> c1501a2 = this.f2604a.get(size);
                if (this.f2605b != c1501a2 && c1501a2.m664a(f)) {
                    return c1501a2;
                }
            }
            return this.f2604a.get(0);
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: renamed from: b.c.a.w.c.a$f */
    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    public static final class f<T> implements d<T> {

        /* JADX INFO: renamed from: a */
        @NonNull
        public final C1501a<T> f2608a;

        /* JADX INFO: renamed from: b */
        public float f2609b = -1.0f;

        public f(List<? extends C1501a<T>> list) {
            this.f2608a = list.get(0);
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: a */
        public boolean mo732a(float f) {
            if (this.f2609b == f) {
                return true;
            }
            this.f2609b = f;
            return false;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: b */
        public C1501a<T> mo733b() {
            return this.f2608a;
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: c */
        public boolean mo734c(float f) {
            return !this.f2608a.m667d();
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: d */
        public float mo735d() {
            return this.f2608a.m665b();
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        /* JADX INFO: renamed from: e */
        public float mo736e() {
            return this.f2608a.m666c();
        }

        @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.d
        public boolean isEmpty() {
            return false;
        }
    }

    public AbstractC1544a(List<? extends C1501a<K>> list) {
        d<K> fVar;
        if (list.isEmpty()) {
            fVar = new c<>(null);
        } else {
            fVar = list.size() == 1 ? new f<>(list) : new e<>(list);
        }
        this.f2598c = fVar;
    }

    /* JADX INFO: renamed from: a */
    public C1501a<K> m723a() {
        C1501a<K> c1501aMo733b = this.f2598c.mo733b();
        C1500c.m663a("BaseKeyframeAnimation#getCurrentKeyframe");
        return c1501aMo733b;
    }

    @FloatRange(from = 0.0d, m75to = 1.0d)
    /* JADX INFO: renamed from: b */
    public float mo724b() {
        if (this.f2603h == -1.0f) {
            this.f2603h = this.f2598c.mo735d();
        }
        return this.f2603h;
    }

    /* JADX INFO: renamed from: c */
    public float m725c() {
        C1501a<K> c1501aM723a = m723a();
        if (c1501aM723a.m667d()) {
            return 0.0f;
        }
        return c1501aM723a.f2319d.getInterpolation(m726d());
    }

    /* JADX INFO: renamed from: d */
    public float m726d() {
        if (this.f2597b) {
            return 0.0f;
        }
        C1501a<K> c1501aM723a = m723a();
        if (c1501aM723a.m667d()) {
            return 0.0f;
        }
        return (this.f2599d - c1501aM723a.m666c()) / (c1501aM723a.m665b() - c1501aM723a.m666c());
    }

    /* JADX INFO: renamed from: e */
    public A mo727e() {
        float fM725c = m725c();
        if (this.f2600e == null && this.f2598c.mo732a(fM725c)) {
            return this.f2601f;
        }
        A aMo728f = mo728f(m723a(), fM725c);
        this.f2601f = aMo728f;
        return aMo728f;
    }

    /* JADX INFO: renamed from: f */
    public abstract A mo728f(C1501a<K> c1501a, float f2);

    /* JADX INFO: renamed from: g */
    public void mo729g() {
        for (int i = 0; i < this.f2596a.size(); i++) {
            this.f2596a.get(i).mo709a();
        }
    }

    /* JADX INFO: renamed from: h */
    public void mo730h(@FloatRange(from = 0.0d, m75to = 1.0d) float f2) {
        if (this.f2598c.isEmpty()) {
            return;
        }
        if (this.f2602g == -1.0f) {
            this.f2602g = this.f2598c.mo736e();
        }
        float f3 = this.f2602g;
        if (f2 < f3) {
            if (f3 == -1.0f) {
                this.f2602g = this.f2598c.mo736e();
            }
            f2 = this.f2602g;
        } else if (f2 > mo724b()) {
            f2 = mo724b();
        }
        if (f2 == this.f2599d) {
            return;
        }
        this.f2599d = f2;
        if (this.f2598c.mo734c(f2)) {
            mo729g();
        }
    }

    /* JADX INFO: renamed from: i */
    public void m731i(@Nullable C1503c<A> c1503c) {
        C1503c<A> c1503c2 = this.f2600e;
        this.f2600e = null;
    }
}
