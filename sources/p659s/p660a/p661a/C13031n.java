package p659s.p660a.p661a;

import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import p000.C0000a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p578f0.C12075n;
import p507d0.p578f0.C12078q;
import p659s.p660a.AbstractC13128l1;

/* JADX INFO: renamed from: s.a.a.n */
/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13031n {

    /* JADX INFO: renamed from: a */
    public static final boolean f27699a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC13128l1 f27700b;

    static {
        C13031n c13031n = new C13031n();
        String strM4309k1 = C3404f.m4309k1("kotlinx.coroutines.fast.service.loader");
        f27699a = strM4309k1 != null ? Boolean.parseBoolean(strM4309k1) : true;
        f27700b = c13031n.m11170a();
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC13128l1 m11170a() {
        Object obj;
        List<? extends MainDispatcherFactory> list = C12078q.toList(C12075n.asSequence(C0000a.m1b()));
        Iterator it = list.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                do {
                    Object next2 = it.next();
                    int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                    if (loadPriority < loadPriority2) {
                        next = next2;
                        loadPriority = loadPriority2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
        if (mainDispatcherFactory != null) {
            try {
                AbstractC13128l1 abstractC13128l1CreateDispatcher = mainDispatcherFactory.createDispatcher(list);
                if (abstractC13128l1CreateDispatcher != null) {
                    return abstractC13128l1CreateDispatcher;
                }
            } catch (Throwable th) {
                mainDispatcherFactory.hintOnError();
                throw th;
            }
        }
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}
