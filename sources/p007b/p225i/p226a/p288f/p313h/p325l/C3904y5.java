package p007b.p225i.p226a.p288f.p313h.p325l;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.f.h.l.y5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3904y5 implements InterfaceC3865v5 {
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3865v5
    /* JADX INFO: renamed from: b */
    public final Map<?, ?> mo5333b(Object obj) {
        return (C3878w5) obj;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3865v5
    /* JADX INFO: renamed from: c */
    public final Object mo5334c(Object obj) {
        ((C3878w5) obj).m5348f();
        return obj;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3865v5
    /* JADX INFO: renamed from: d */
    public final boolean mo5335d(Object obj) {
        return !((C3878w5) obj).m5349g();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3865v5
    /* JADX INFO: renamed from: e */
    public final Map<?, ?> mo5336e(Object obj) {
        return (C3878w5) obj;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3865v5
    /* JADX INFO: renamed from: f */
    public final Object mo5337f(Object obj, Object obj2) {
        C3878w5 c3878w5 = (C3878w5) obj;
        C3878w5 c3878w6 = (C3878w5) obj2;
        if (!c3878w6.isEmpty()) {
            if (!c3878w5.m5349g()) {
                c3878w5 = c3878w5.isEmpty() ? new C3878w5() : new C3878w5(c3878w5);
            }
            c3878w5.m5350h();
            if (!c3878w6.isEmpty()) {
                c3878w5.putAll(c3878w6);
            }
        }
        return c3878w5;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3865v5
    /* JADX INFO: renamed from: g */
    public final C3839t5<?, ?> mo5338g(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3865v5
    /* JADX INFO: renamed from: h */
    public final Object mo5339h(Object obj) {
        C3878w5 c3878w5 = C3878w5.f10381j;
        return c3878w5.isEmpty() ? new C3878w5() : new C3878w5(c3878w5);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3865v5
    /* JADX INFO: renamed from: i */
    public final int mo5340i(int i, Object obj, Object obj2) {
        C3878w5 c3878w5 = (C3878w5) obj;
        if (c3878w5.isEmpty()) {
            return 0;
        }
        Iterator it = c3878w5.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
