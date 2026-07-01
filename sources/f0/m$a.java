package f0;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: ConnectionSpec.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m$a {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String[] f3675b;
    public String[] c;
    public boolean d;

    public m$a(boolean z2) {
        this.a = z2;
    }

    public final m a() {
        return new m(this.a, this.d, this.f3675b, this.c);
    }

    public final m$a b(String... strArr) throws CloneNotSupportedException {
        d0.z.d.m.checkParameterIsNotNull(strArr, "cipherSuites");
        if (!this.a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }
        if (!(!(strArr.length == 0))) {
            throw new IllegalArgumentException("At least one cipher suite is required".toString());
        }
        Object objClone = strArr.clone();
        if (objClone == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        }
        this.f3675b = (String[]) objClone;
        return this;
    }

    public final m$a c(j... jVarArr) throws CloneNotSupportedException {
        d0.z.d.m.checkParameterIsNotNull(jVarArr, "cipherSuites");
        if (!this.a) {
            throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
        }
        ArrayList arrayList = new ArrayList(jVarArr.length);
        for (j jVar : jVarArr) {
            arrayList.add(jVar.t);
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        b((String[]) Arrays.copyOf(strArr, strArr.length));
        return this;
    }

    public final m$a d(boolean z2) {
        if (!this.a) {
            throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
        }
        this.d = z2;
        return this;
    }

    public final m$a e(String... strArr) throws CloneNotSupportedException {
        d0.z.d.m.checkParameterIsNotNull(strArr, "tlsVersions");
        if (!this.a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }
        if (!(!(strArr.length == 0))) {
            throw new IllegalArgumentException("At least one TLS version is required".toString());
        }
        Object objClone = strArr.clone();
        if (objClone == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        }
        this.c = (String[]) objClone;
        return this;
    }

    public final m$a f(d0... d0VarArr) throws CloneNotSupportedException {
        d0.z.d.m.checkParameterIsNotNull(d0VarArr, "tlsVersions");
        if (!this.a) {
            throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
        }
        ArrayList arrayList = new ArrayList(d0VarArr.length);
        for (d0 d0Var : d0VarArr) {
            arrayList.add(d0Var.f());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        e((String[]) Arrays.copyOf(strArr, strArr.length));
        return this;
    }

    public m$a(m mVar) {
        d0.z.d.m.checkParameterIsNotNull(mVar, "connectionSpec");
        this.a = mVar.e;
        this.f3675b = mVar.g;
        this.c = mVar.h;
        this.d = mVar.f;
    }
}
