package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import java.lang.reflect.Field;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s<V> extends f<V> implements KProperty<V> {
    public static final Object n;
    public final c0$b<Field> o;
    public final c0$a<n0> p;
    public final i q;
    public final String r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f3568s;
    public final Object t;

    static {
        new s$b(null);
        n = new Object();
    }

    public s(i iVar, String str, String str2, n0 n0Var, Object obj) {
        this.q = iVar;
        this.r = str;
        this.f3568s = str2;
        this.t = obj;
        c0$b<Field> c0_bLazy = c0.lazy(new s$f(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.o = c0_bLazy;
        c0$a<n0> c0_aLazySoft = c0.lazySoft(n0Var, new s$e(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_aLazySoft, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.p = c0_aLazySoft;
    }

    public final Field c() {
        if (getDescriptor().isDelegated()) {
            return getJavaField();
        }
        return null;
    }

    public boolean equals(Object obj) {
        s<?> sVarAsKPropertyImpl = j0.asKPropertyImpl(obj);
        return sVarAsKPropertyImpl != null && d0.z.d.m.areEqual(getContainer(), sVarAsKPropertyImpl.getContainer()) && d0.z.d.m.areEqual(getName(), sVarAsKPropertyImpl.getName()) && d0.z.d.m.areEqual(this.f3568s, sVarAsKPropertyImpl.f3568s) && d0.z.d.m.areEqual(this.t, sVarAsKPropertyImpl.t);
    }

    public final Object getBoundReceiver() {
        return d0.e0.p.d.l0.h.coerceToExpectedReceiverType(this.t, getDescriptor());
    }

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.l0.d<?> getCaller() {
        return mo112getGetter().getCaller();
    }

    @Override // d0.e0.p.d.f
    public i getContainer() {
        return this.q;
    }

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.l0.d<?> getDefaultCaller() {
        return mo112getGetter().getDefaultCaller();
    }

    @Override // d0.e0.p.d.f
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getDescriptor() {
        return getDescriptor();
    }

    /* JADX INFO: renamed from: getGetter */
    public abstract s$c<V> mo112getGetter();

    public final Field getJavaField() {
        return this.o.invoke();
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        return this.r;
    }

    public final String getSignature() {
        return this.f3568s;
    }

    public int hashCode() {
        return this.f3568s.hashCode() + ((getName().hashCode() + (getContainer().hashCode() * 31)) * 31);
    }

    @Override // d0.e0.p.d.f
    public boolean isBound() {
        return !d0.z.d.m.areEqual(this.t, d0.z.d.d.NO_RECEIVER);
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getDescriptor().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getDescriptor().isLateInit();
    }

    @Override // kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public boolean isSuspend() {
        return false;
    }

    public String toString() {
        return e0.f3197b.renderProperty(getDescriptor());
    }

    @Override // d0.e0.p.d.f
    public n0 getDescriptor() {
        n0 n0VarInvoke = this.p.invoke();
        d0.z.d.m.checkNotNullExpressionValue(n0VarInvoke, "_descriptor()");
        return n0VarInvoke;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(i iVar, String str, String str2, Object obj) {
        this(iVar, str, str2, null, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public s(i iVar, n0 n0Var) {
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        String strAsString = n0Var.getName().asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "descriptor.name.asString()");
        this(iVar, strAsString, f0.f3198b.mapPropertySignature(n0Var).asString(), n0Var, d0.z.d.d.NO_RECEIVER);
    }
}
