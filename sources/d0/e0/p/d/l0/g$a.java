package d0.e0.p.d.l0;

import d0.z.d.m;
import java.lang.reflect.Method;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a {
    public final IntRange a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method[] f3206b;
    public final Method c;

    public g$a(IntRange intRange, Method[] methodArr, Method method) {
        m.checkNotNullParameter(intRange, "argumentRange");
        m.checkNotNullParameter(methodArr, "unbox");
        this.a = intRange;
        this.f3206b = methodArr;
        this.c = method;
    }

    public final IntRange component1() {
        return this.a;
    }

    public final Method[] component2() {
        return this.f3206b;
    }

    public final Method component3() {
        return this.c;
    }
}
