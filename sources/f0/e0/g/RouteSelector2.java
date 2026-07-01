package f0.e0.g;

import d0.t.CollectionsJVM;
import d0.z.d.Lambda;
import f0.HttpUrl;
import f0.e0.Util7;
import java.net.Proxy;
import java.net.URI;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: f0.e0.g.n, reason: use source file name */
/* JADX INFO: compiled from: RouteSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RouteSelector2 extends Lambda implements Function0<List<? extends Proxy>> {
    public final /* synthetic */ Proxy $proxy;
    public final /* synthetic */ HttpUrl $url;
    public final /* synthetic */ RouteSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteSelector2(RouteSelector routeSelector, Proxy proxy, HttpUrl httpUrl) {
        super(0);
        this.this$0 = routeSelector;
        this.$proxy = proxy;
        this.$url = httpUrl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends Proxy> invoke() {
        Proxy proxy = this.$proxy;
        if (proxy != null) {
            return CollectionsJVM.listOf(proxy);
        }
        URI uriI = this.$url.i();
        if (uriI.getHost() == null) {
            return Util7.m(Proxy.NO_PROXY);
        }
        List<Proxy> listSelect = this.this$0.e.k.select(uriI);
        return listSelect == null || listSelect.isEmpty() ? Util7.m(Proxy.NO_PROXY) : Util7.z(listSelect);
    }
}
