package b.a.z.a.a;

import j0.l.a.n$b;
import j0.l.a.o2;
import j0.l.e.m$a;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements j0.k.b {
    public final /* synthetic */ List j;
    public final /* synthetic */ Map k;
    public final /* synthetic */ String l;

    public /* synthetic */ h(List list, Map map, String str) {
        this.j = list;
        this.k = map;
        this.l = str;
    }

    @Override // j0.k.b
    public final Object call(Object obj) {
        List list = this.j;
        Map map = this.k;
        Observable observableH0 = Observable.h0(new j0.l.a.r(Observable.B(((Map) obj).values()).y(new l(list)).y(new m(map)).y(new k(this.l)).j, new o2(new f(map), 10)));
        m$a m_a = m$a.INSTANCE;
        return (observableH0 instanceof j0.l.e.k ? Observable.h0(new n$b(((j0.l.e.k) observableH0).l, m_a)) : Observable.h0(new j0.l.a.n(observableH0, m_a, j0.l.e.i.j))).G(new d(map)).f0();
    }
}
