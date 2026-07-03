package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p600f0.AbstractC12376t;
import p600f0.C12261a;
import p600f0.C12266c0;
import p600f0.C12379w;
import p600f0.InterfaceC12269e;

/* JADX INFO: renamed from: f0.e0.g.m */
/* JADX INFO: compiled from: RouteSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12293m {

    /* JADX INFO: renamed from: a */
    public List<? extends Proxy> f25514a;

    /* JADX INFO: renamed from: b */
    public int f25515b;

    /* JADX INFO: renamed from: c */
    public List<? extends InetSocketAddress> f25516c;

    /* JADX INFO: renamed from: d */
    public final List<C12266c0> f25517d;

    /* JADX INFO: renamed from: e */
    public final C12261a f25518e;

    /* JADX INFO: renamed from: f */
    public final C12292l f25519f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC12269e f25520g;

    /* JADX INFO: renamed from: h */
    public final AbstractC12376t f25521h;

    /* JADX INFO: renamed from: f0.e0.g.m$a */
    /* JADX INFO: compiled from: RouteSelector.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public int f25522a;

        /* JADX INFO: renamed from: b */
        public final List<C12266c0> f25523b;

        public a(List<C12266c0> list) {
            C12238m.checkParameterIsNotNull(list, "routes");
            this.f25523b = list;
        }

        /* JADX INFO: renamed from: a */
        public final boolean m10211a() {
            return this.f25522a < this.f25523b.size();
        }

        /* JADX INFO: renamed from: b */
        public final C12266c0 m10212b() {
            if (!m10211a()) {
                throw new NoSuchElementException();
            }
            List<C12266c0> list = this.f25523b;
            int i = this.f25522a;
            this.f25522a = i + 1;
            return list.get(i);
        }
    }

    public C12293m(C12261a c12261a, C12292l c12292l, InterfaceC12269e interfaceC12269e, AbstractC12376t abstractC12376t) {
        C12238m.checkParameterIsNotNull(c12261a, "address");
        C12238m.checkParameterIsNotNull(c12292l, "routeDatabase");
        C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(abstractC12376t, "eventListener");
        this.f25518e = c12261a;
        this.f25519f = c12292l;
        this.f25520g = interfaceC12269e;
        this.f25521h = abstractC12376t;
        this.f25514a = C12147n.emptyList();
        this.f25516c = C12147n.emptyList();
        this.f25517d = new ArrayList();
        C12379w c12379w = c12261a.f25353a;
        C12294n c12294n = new C12294n(this, c12261a.f25362j, c12379w);
        Objects.requireNonNull(abstractC12376t);
        C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(c12379w, "url");
        List<? extends Proxy> listInvoke = c12294n.invoke();
        this.f25514a = listInvoke;
        this.f25515b = 0;
        C12238m.checkParameterIsNotNull(interfaceC12269e, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(c12379w, "url");
        C12238m.checkParameterIsNotNull(listInvoke, "proxies");
    }

    /* JADX INFO: renamed from: a */
    public final boolean m10209a() {
        return m10210b() || (this.f25517d.isEmpty() ^ true);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m10210b() {
        return this.f25515b < this.f25514a.size();
    }
}
