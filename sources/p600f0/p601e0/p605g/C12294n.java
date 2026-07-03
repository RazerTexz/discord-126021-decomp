package p600f0.p601e0.p605g;

import java.net.Proxy;
import java.net.URI;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p600f0.C12379w;
import p600f0.p601e0.C12272c;

/* JADX INFO: renamed from: f0.e0.g.n */
/* JADX INFO: compiled from: RouteSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12294n extends AbstractC12240o implements Function0<List<? extends Proxy>> {
    public final /* synthetic */ Proxy $proxy;
    public final /* synthetic */ C12379w $url;
    public final /* synthetic */ C12293m this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12294n(C12293m c12293m, Proxy proxy, C12379w c12379w) {
        super(0);
        this.this$0 = c12293m;
        this.$proxy = proxy;
        this.$url = c12379w;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends Proxy> invoke() {
        Proxy proxy = this.$proxy;
        if (proxy != null) {
            return C12145m.listOf(proxy);
        }
        URI uriM10407i = this.$url.m10407i();
        if (uriM10407i.getHost() == null) {
            return C12272c.m10132m(Proxy.NO_PROXY);
        }
        List<Proxy> listSelect = this.this$0.f25518e.f25363k.select(uriM10407i);
        return listSelect == null || listSelect.isEmpty() ? C12272c.m10132m(Proxy.NO_PROXY) : C12272c.m10145z(listSelect);
    }
}
