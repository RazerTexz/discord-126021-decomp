package f0.e0.g;

import d0.z.d.o;
import f0.w;
import java.net.Proxy;
import java.net.URI;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: RouteSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends o implements Function0<List<? extends Proxy>> {
    public final /* synthetic */ Proxy $proxy;
    public final /* synthetic */ w $url;
    public final /* synthetic */ m this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, Proxy proxy, w wVar) {
        super(0);
        this.this$0 = mVar;
        this.$proxy = proxy;
        this.$url = wVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends Proxy> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends Proxy> invoke2() {
        Proxy proxy = this.$proxy;
        if (proxy != null) {
            return d0.t.m.listOf(proxy);
        }
        URI uriI = this.$url.i();
        if (uriI.getHost() == null) {
            return f0.e0.c.m(Proxy.NO_PROXY);
        }
        List<Proxy> listSelect = this.this$0.e.k.select(uriI);
        return listSelect == null || listSelect.isEmpty() ? f0.e0.c.m(Proxy.NO_PROXY) : f0.e0.c.z(listSelect);
    }
}
