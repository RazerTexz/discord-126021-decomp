package b.f.j.p;

import b.f.j.p.NetworkFetchProducer;
import b.f.j.p.NetworkFetcher2;
import java.util.Objects;
import java.util.concurrent.Future;

/* JADX INFO: renamed from: b.f.j.p.z, reason: use source file name */
/* JADX INFO: compiled from: HttpUrlConnectionNetworkFetcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpUrlConnectionNetworkFetcher3 extends BaseProducerContextCallbacks {
    public final /* synthetic */ Future a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NetworkFetcher2.a f643b;

    public HttpUrlConnectionNetworkFetcher3(HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher, Future future, NetworkFetcher2.a aVar) {
        this.a = future;
        this.f643b = aVar;
    }

    @Override // b.f.j.p.ProducerContextCallbacks
    public void a() {
        if (this.a.cancel(false)) {
            NetworkFetchProducer.a aVar = (NetworkFetchProducer.a) this.f643b;
            NetworkFetchProducer networkFetchProducer = NetworkFetchProducer.this;
            FetchState2 fetchState2 = aVar.a;
            Objects.requireNonNull(networkFetchProducer);
            fetchState2.a().d(fetchState2.f642b, "NetworkFetchProducer", null);
            fetchState2.a.d();
        }
    }
}
