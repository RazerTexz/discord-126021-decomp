package b.i.a.b.j;

import b.i.a.b.Encoding2;
import b.i.a.b.Event2;
import b.i.a.b.Priority3;
import b.i.a.b.Transformer;
import b.i.a.b.Transport2;
import b.i.a.b.TransportScheduleCallback;
import b.i.a.b.j.AutoValue_EventInternal;
import b.i.a.b.j.AutoValue_TransportContext;
import b.i.a.b.j.TransportContext;
import b.i.a.b.j.t.Scheduler2;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.j.l, reason: use source file name */
/* JADX INFO: compiled from: TransportImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TransportImpl2<T> implements Transport2<T> {
    public final TransportContext a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f768b;
    public final Encoding2 c;
    public final Transformer<T, byte[]> d;
    public final TransportInternal e;

    public TransportImpl2(TransportContext transportContext, String str, Encoding2 encoding2, Transformer<T, byte[]> transformer, TransportInternal transportInternal) {
        this.a = transportContext;
        this.f768b = str;
        this.c = encoding2;
        this.d = transformer;
        this.e = transportInternal;
    }

    @Override // b.i.a.b.Transport2
    public void a(Event2<T> event2) {
        b(event2, new TransportScheduleCallback() { // from class: b.i.a.b.j.k
            @Override // b.i.a.b.TransportScheduleCallback
            public void a(Exception exc) {
            }
        });
    }

    @Override // b.i.a.b.Transport2
    public void b(Event2<T> event2, TransportScheduleCallback transportScheduleCallback) {
        TransportInternal transportInternal = this.e;
        TransportContext transportContext = this.a;
        Objects.requireNonNull(transportContext, "Null transportContext");
        Objects.requireNonNull(event2, "Null event");
        String str = this.f768b;
        Objects.requireNonNull(str, "Null transportName");
        Transformer<T, byte[]> transformer = this.d;
        Objects.requireNonNull(transformer, "Null transformer");
        Encoding2 encoding2 = this.c;
        Objects.requireNonNull(encoding2, "Null encoding");
        TransportRuntime transportRuntime = (TransportRuntime) transportInternal;
        Scheduler2 scheduler2 = transportRuntime.d;
        Priority3 priority3C = event2.c();
        TransportContext.a aVarA = TransportContext.a();
        aVarA.b(transportContext.b());
        aVarA.c(priority3C);
        AutoValue_TransportContext.b bVar = (AutoValue_TransportContext.b) aVarA;
        bVar.f764b = transportContext.c();
        TransportContext transportContextA = bVar.a();
        AutoValue_EventInternal.b bVar2 = new AutoValue_EventInternal.b();
        bVar2.f = new HashMap();
        bVar2.e(transportRuntime.f769b.a());
        bVar2.g(transportRuntime.c.a());
        bVar2.f(str);
        bVar2.d(new EncodedPayload(encoding2, transformer.apply(event2.b())));
        bVar2.f762b = event2.a();
        scheduler2.a(transportContextA, bVar2.b(), transportScheduleCallback);
    }
}
