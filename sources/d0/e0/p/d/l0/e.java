package d0.e0.p.d.l0;

import d0.t.k;
import d0.t.n;
import d0.z.d.c0;
import d0.z.d.m;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e<M extends Member> implements d<M> {
    public static final e$d a = new e$d(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Type> f3204b;
    public final M c;
    public final Type d;
    public final Class<?> e;

    /* JADX WARN: Code duplicated, block: B:7:0x002a  */
    /* JADX WARN: Multi-variable type inference failed */
    public e(Member member, Type type, Class cls, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
        List<Type> list;
        this.c = member;
        this.d = type;
        this.e = cls;
        if (cls != null) {
            c0 c0Var = new c0(2);
            c0Var.add(cls);
            c0Var.addSpread(typeArr);
            list = n.listOf(c0Var.toArray(new Type[c0Var.size()]));
            list = list == null ? k.toList(typeArr) : list;
        }
        this.f3204b = list;
    }

    public final void a(Object obj) {
        if (obj == null || !this.c.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    public void checkArguments(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        d$a.checkArguments(this, objArr);
    }

    public final Class<?> getInstanceClass() {
        return this.e;
    }

    @Override // d0.e0.p.d.l0.d
    /* JADX INFO: renamed from: getMember */
    public final M mo80getMember() {
        return this.c;
    }

    @Override // d0.e0.p.d.l0.d
    public List<Type> getParameterTypes() {
        return this.f3204b;
    }

    @Override // d0.e0.p.d.l0.d
    public final Type getReturnType() {
        return this.d;
    }
}
