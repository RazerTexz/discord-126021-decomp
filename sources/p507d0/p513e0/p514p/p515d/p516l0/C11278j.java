package p507d0.p513e0.p514p.p515d.p516l0;

import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.List;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.l0.j */
/* JADX INFO: compiled from: ThrowingCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11278j implements InterfaceC11272d {

    /* JADX INFO: renamed from: a */
    public static final C11278j f22446a = new C11278j();

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public Object call(Object[] objArr) {
        C12238m.checkNotNullParameter(objArr, "args");
        throw new UnsupportedOperationException("call/callBy are not supported for this declaration.");
    }

    public Void getMember() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    /* JADX INFO: renamed from: getMember */
    public /* bridge */ /* synthetic */ Member mo11457getMember() {
        return (Member) getMember();
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public List<Type> getParameterTypes() {
        return C12147n.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p516l0.InterfaceC11272d
    public Type getReturnType() {
        Class cls = Void.TYPE;
        C12238m.checkNotNullExpressionValue(cls, "Void.TYPE");
        return cls;
    }
}
