package b.f.j.f;

import b.c.a.a0.AnimatableValueParser;
import b.f.j.p.BaseConsumer;
import b.f.j.p.SettableProducerContext;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.f.j.f.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractProducerToDataSourceAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class AbstractProducerToDataSourceAdapter<T> extends BaseConsumer<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractProducerToDataSourceAdapter2 f587b;

    public AbstractProducerToDataSourceAdapter(AbstractProducerToDataSourceAdapter2 abstractProducerToDataSourceAdapter2) {
        this.f587b = abstractProducerToDataSourceAdapter2;
    }

    @Override // b.f.j.p.BaseConsumer
    public void g() {
        AbstractProducerToDataSourceAdapter2 abstractProducerToDataSourceAdapter2 = this.f587b;
        synchronized (abstractProducerToDataSourceAdapter2) {
            AnimatableValueParser.B(abstractProducerToDataSourceAdapter2.i());
        }
    }

    @Override // b.f.j.p.BaseConsumer
    public void h(Throwable th) {
        AbstractProducerToDataSourceAdapter2 abstractProducerToDataSourceAdapter2 = this.f587b;
        if (abstractProducerToDataSourceAdapter2.k(th, abstractProducerToDataSourceAdapter2.h.a())) {
            abstractProducerToDataSourceAdapter2.i.h(abstractProducerToDataSourceAdapter2.h, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.f.j.p.BaseConsumer
    public void i(T t, int i) {
        AbstractProducerToDataSourceAdapter2 abstractProducerToDataSourceAdapter2 = this.f587b;
        SettableProducerContext settableProducerContext = abstractProducerToDataSourceAdapter2.h;
        CloseableProducerToDataSourceAdapter closeableProducerToDataSourceAdapter = (CloseableProducerToDataSourceAdapter) abstractProducerToDataSourceAdapter2;
        Objects.requireNonNull(closeableProducerToDataSourceAdapter);
        CloseableReference closeableReferenceN = CloseableReference.n((CloseableReference) t);
        boolean zE = BaseConsumer.e(i);
        if (closeableProducerToDataSourceAdapter.m(closeableReferenceN, zE, settableProducerContext.a()) && zE) {
            closeableProducerToDataSourceAdapter.i.f(closeableProducerToDataSourceAdapter.h);
        }
    }

    @Override // b.f.j.p.BaseConsumer
    public void j(float f) {
        this.f587b.l(f);
    }
}
