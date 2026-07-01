package b.f.j.p;

import b.f.j.k.RequestListener;
import b.f.j.k.RequestListener2;
import java.util.Map;

/* JADX INFO: renamed from: b.f.j.p.b0, reason: use source file name */
/* JADX INFO: compiled from: InternalRequestListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class InternalRequestListener implements RequestListener2, ProducerListener2 {
    public final ProducerListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProducerListener2 f605b;
    public final RequestListener c;
    public final RequestListener2 d;

    public InternalRequestListener(RequestListener requestListener, RequestListener2 requestListener2) {
        this.a = requestListener;
        this.f605b = requestListener2;
        this.c = requestListener;
        this.d = requestListener2;
    }

    @Override // b.f.j.p.ProducerListener2
    public void a(ProducerContext producerContext, String str, String str2) {
        ProducerListener producerListener = this.a;
        if (producerListener != null) {
            producerListener.h(producerContext.getId(), str, str2);
        }
        ProducerListener2 producerListener2 = this.f605b;
        if (producerListener2 != null) {
            producerListener2.a(producerContext, str, str2);
        }
    }

    @Override // b.f.j.k.RequestListener2
    public void b(ProducerContext producerContext) {
        RequestListener requestListener = this.c;
        if (requestListener != null) {
            requestListener.a(producerContext.e(), producerContext.b(), producerContext.getId(), producerContext.k());
        }
        RequestListener2 requestListener2 = this.d;
        if (requestListener2 != null) {
            requestListener2.b(producerContext);
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public void c(ProducerContext producerContext, String str, boolean z2) {
        ProducerListener producerListener = this.a;
        if (producerListener != null) {
            producerListener.e(producerContext.getId(), str, z2);
        }
        ProducerListener2 producerListener2 = this.f605b;
        if (producerListener2 != null) {
            producerListener2.c(producerContext, str, z2);
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public void d(ProducerContext producerContext, String str, Map map) {
        ProducerListener producerListener = this.a;
        if (producerListener != null) {
            producerListener.d(producerContext.getId(), str, map);
        }
        ProducerListener2 producerListener2 = this.f605b;
        if (producerListener2 != null) {
            producerListener2.d(producerContext, str, map);
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public void e(ProducerContext producerContext, String str) {
        ProducerListener producerListener = this.a;
        if (producerListener != null) {
            producerListener.b(producerContext.getId(), str);
        }
        ProducerListener2 producerListener2 = this.f605b;
        if (producerListener2 != null) {
            producerListener2.e(producerContext, str);
        }
    }

    @Override // b.f.j.k.RequestListener2
    public void f(ProducerContext producerContext) {
        RequestListener requestListener = this.c;
        if (requestListener != null) {
            requestListener.c(producerContext.e(), producerContext.getId(), producerContext.k());
        }
        RequestListener2 requestListener2 = this.d;
        if (requestListener2 != null) {
            requestListener2.f(producerContext);
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public boolean g(ProducerContext producerContext, String str) {
        ProducerListener2 producerListener2;
        ProducerListener producerListener = this.a;
        boolean zF = producerListener != null ? producerListener.f(producerContext.getId()) : false;
        return (zF || (producerListener2 = this.f605b) == null) ? zF : producerListener2.g(producerContext, str);
    }

    @Override // b.f.j.k.RequestListener2
    public void h(ProducerContext producerContext, Throwable th) {
        RequestListener requestListener = this.c;
        if (requestListener != null) {
            requestListener.g(producerContext.e(), producerContext.getId(), th, producerContext.k());
        }
        RequestListener2 requestListener2 = this.d;
        if (requestListener2 != null) {
            requestListener2.h(producerContext, th);
        }
    }

    @Override // b.f.j.k.RequestListener2
    public void i(ProducerContext producerContext) {
        RequestListener requestListener = this.c;
        if (requestListener != null) {
            requestListener.k(producerContext.getId());
        }
        RequestListener2 requestListener2 = this.d;
        if (requestListener2 != null) {
            requestListener2.i(producerContext);
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public void j(ProducerContext producerContext, String str, Map map) {
        ProducerListener producerListener = this.a;
        if (producerListener != null) {
            producerListener.i(producerContext.getId(), str, map);
        }
        ProducerListener2 producerListener2 = this.f605b;
        if (producerListener2 != null) {
            producerListener2.j(producerContext, str, map);
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public void k(ProducerContext producerContext, String str, Throwable th, Map map) {
        ProducerListener producerListener = this.a;
        if (producerListener != null) {
            producerListener.j(producerContext.getId(), str, th, map);
        }
        ProducerListener2 producerListener2 = this.f605b;
        if (producerListener2 != null) {
            producerListener2.k(producerContext, str, th, map);
        }
    }
}
