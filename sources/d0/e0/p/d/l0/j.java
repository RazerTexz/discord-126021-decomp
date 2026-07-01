package d0.e0.p.d.l0;

import d0.t.n;
import d0.z.d.m;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: ThrowingCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements d {
    public static final j a = new j();

    @Override // d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    public Void getMember() {
        return null;
    }

    @Override // d0.e0.p.d.l0.d
    /* JADX INFO: renamed from: getMember */
    public /* bridge */ /* synthetic */ Member mo80getMember() {
        return (Member) getMember();
    }

    @Override // d0.e0.p.d.l0.d
    public List<Type> getParameterTypes() {
        return n.emptyList();
    }

    @Override // d0.e0.p.d.l0.d
    public Type getReturnType() {
        Class cls = Void.TYPE;
        m.checkNotNullExpressionValue(cls, "Void.TYPE");
        return cls;
    }
}
