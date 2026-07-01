package d0.e0.p.d.l0;

import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.l0.j, reason: use source file name */
/* JADX INFO: compiled from: ThrowingCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ThrowingCaller implements Caller2 {
    public static final ThrowingCaller a = new ThrowingCaller();

    @Override // d0.e0.p.d.l0.Caller2
    public Object call(Object[] objArr) {
        Intrinsics3.checkNotNullParameter(objArr, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    public Void getMember() {
        return null;
    }

    @Override // d0.e0.p.d.l0.Caller2
    /* JADX INFO: renamed from: getMember */
    public /* bridge */ /* synthetic */ Member mo80getMember() {
        return (Member) getMember();
    }

    @Override // d0.e0.p.d.l0.Caller2
    public List<Type> getParameterTypes() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.l0.Caller2
    public Type getReturnType() {
        Class cls = Void.TYPE;
        Intrinsics3.checkNotNullExpressionValue(cls, "Void.TYPE");
        return cls;
    }
}
