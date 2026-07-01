package b.c.a.w.c;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.L;
import b.c.a.c0.Keyframe;
import b.c.a.c0.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.c.a, reason: use source file name */
/* JADX INFO: compiled from: BaseKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseKeyframeAnimation<K, A> {
    public final d<K> c;

    @Nullable
    public LottieValueCallback<A> e;
    public final List<b> a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f392b = false;
    public float d = 0.0f;

    @Nullable
    public A f = null;
    public float g = -1.0f;
    public float h = -1.0f;

    /* JADX INFO: renamed from: b.c.a.w.c.a$b */
    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    public interface b {
        void a();
    }

    /* JADX INFO: renamed from: b.c.a.w.c.a$c */
    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    public static final class c<T> implements d<T> {
        public c(a aVar) {
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public boolean a(float f) {
            throw new IllegalStateException("not implemented");
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public Keyframe<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public boolean c(float f) {
            return false;
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public float d() {
            return 1.0f;
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public float e() {
            return 0.0f;
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: renamed from: b.c.a.w.c.a$d */
    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    public interface d<T> {
        boolean a(float f);

        Keyframe<T> b();

        boolean c(float f);

        @FloatRange(from = 0.0d, to = 1.0d)
        float d();

        @FloatRange(from = 0.0d, to = 1.0d)
        float e();

        boolean isEmpty();
    }

    /* JADX INFO: renamed from: b.c.a.w.c.a$e */
    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    public static final class e<T> implements d<T> {
        public final List<? extends Keyframe<T>> a;
        public Keyframe<T> c = null;
        public float d = -1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public Keyframe<T> f393b = f(0.0f);

        public e(List<? extends Keyframe<T>> list) {
            this.a = list;
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public boolean a(float f) {
            Keyframe<T> keyframe = this.c;
            Keyframe<T> keyframe2 = this.f393b;
            if (keyframe == keyframe2 && this.d == f) {
                return true;
            }
            this.c = keyframe2;
            this.d = f;
            return false;
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        @NonNull
        public Keyframe<T> b() {
            return this.f393b;
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public boolean c(float f) {
            if (this.f393b.a(f)) {
                return !this.f393b.d();
            }
            this.f393b = f(f);
            return true;
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public float d() {
            List<? extends Keyframe<T>> list = this.a;
            return list.get(list.size() - 1).b();
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public float e() {
            return this.a.get(0).c();
        }

        public final Keyframe<T> f(float f) {
            List<? extends Keyframe<T>> list = this.a;
            Keyframe<T> keyframe = list.get(list.size() - 1);
            if (f >= keyframe.c()) {
                return keyframe;
            }
            for (int size = this.a.size() - 2; size >= 1; size--) {
                Keyframe<T> keyframe2 = this.a.get(size);
                if (this.f393b != keyframe2 && keyframe2.a(f)) {
                    return keyframe2;
                }
            }
            return this.a.get(0);
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: renamed from: b.c.a.w.c.a$f */
    /* JADX INFO: compiled from: BaseKeyframeAnimation.java */
    public static final class f<T> implements d<T> {

        @NonNull
        public final Keyframe<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f394b = -1.0f;

        public f(List<? extends Keyframe<T>> list) {
            this.a = list.get(0);
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public boolean a(float f) {
            if (this.f394b == f) {
                return true;
            }
            this.f394b = f;
            return false;
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public Keyframe<T> b() {
            return this.a;
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public boolean c(float f) {
            return !this.a.d();
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public float d() {
            return this.a.b();
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public float e() {
            return this.a.c();
        }

        @Override // b.c.a.w.c.BaseKeyframeAnimation.d
        public boolean isEmpty() {
            return false;
        }
    }

    public BaseKeyframeAnimation(List<? extends Keyframe<K>> list) {
        d<K> fVar;
        if (list.isEmpty()) {
            fVar = new c<>(null);
        } else {
            fVar = list.size() == 1 ? new f<>(list) : new e<>(list);
        }
        this.c = fVar;
    }

    public Keyframe<K> a() {
        Keyframe<K> keyframeB = this.c.b();
        L.a("BaseKeyframeAnimation#getCurrentKeyframe");
        return keyframeB;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float b() {
        if (this.h == -1.0f) {
            this.h = this.c.d();
        }
        return this.h;
    }

    public float c() {
        Keyframe<K> keyframeA = a();
        if (keyframeA.d()) {
            return 0.0f;
        }
        return keyframeA.d.getInterpolation(d());
    }

    public float d() {
        if (this.f392b) {
            return 0.0f;
        }
        Keyframe<K> keyframeA = a();
        if (keyframeA.d()) {
            return 0.0f;
        }
        return (this.d - keyframeA.c()) / (keyframeA.b() - keyframeA.c());
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

    public abstract A f(Keyframe<K> keyframe, float f2);

    public void g() {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).a();
        }
    }

    public void h(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.c.isEmpty()) {
            return;
        }
        if (this.g == -1.0f) {
            this.g = this.c.e();
        }
        float f3 = this.g;
        if (f2 < f3) {
            if (f3 == -1.0f) {
                this.g = this.c.e();
            }
            f2 = this.g;
        } else if (f2 > b()) {
            f2 = b();
        }
        if (f2 == this.d) {
            return;
        }
        this.d = f2;
        if (this.c.c(f2)) {
            g();
        }
    }

    public void i(@Nullable LottieValueCallback<A> lottieValueCallback) {
        LottieValueCallback<A> lottieValueCallback2 = this.e;
        this.e = null;
    }
}
