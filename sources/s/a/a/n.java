package s.a.a;

import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import s.a.l1;

/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l1 f3830b;

    static {
        n nVar = new n();
        String strK1 = b.i.a.f.e.o.f.k1("kotlinx.coroutines.fast.service.loader");
        a = strK1 != null ? Boolean.parseBoolean(strK1) : true;
        f3830b = nVar.a();
    }

    public final l1 a() {
        Object obj;
        List<? extends MainDispatcherFactory> list = d0.f0.q.toList(d0.f0.n.asSequence(defpackage.a.b()));
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
                l1 l1VarCreateDispatcher = mainDispatcherFactory.createDispatcher(list);
                if (l1VarCreateDispatcher != null) {
                    return l1VarCreateDispatcher;
                }
            } catch (Throwable th) {
                mainDispatcherFactory.hintOnError();
                throw th;
            }
        }
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}
