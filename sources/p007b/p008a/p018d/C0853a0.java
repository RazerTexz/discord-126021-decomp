package p007b.p008a.p018d;

import kotlin.jvm.functions.Function1;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.d.a0 */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0853a0<T, R> implements Observable.InterfaceC13007c<T, R> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Function1 f499j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Function1 f500k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Function1 f501l;

    public C0853a0(Function1 function1, Function1 function2, Function1 function3) {
        this.f499j = function1;
        this.f500k = function2;
        this.f501l = function3;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        return ((Observable) obj).m11099Y(new C0890z(this));
    }
}
