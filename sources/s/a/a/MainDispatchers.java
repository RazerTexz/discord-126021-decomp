package s.a.a;

import d0.f0._Sequences2;
import defpackage.ServiceLoader;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import s.a.MainCoroutineDispatcher;

/* JADX INFO: renamed from: s.a.a.n, reason: use source file name */
/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MainDispatchers {
    public static final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MainCoroutineDispatcher f3830b;

    static {
        MainDispatchers mainDispatchers = new MainDispatchers();
        String strK1 = b.i.a.f.e.o.f.k1("kotlinx.coroutines.fast.service.loader");
        a = strK1 != null ? Boolean.parseBoolean(strK1) : true;
        f3830b = mainDispatchers.a();
    }

    public final MainCoroutineDispatcher a() {
        Object obj;
        List<? extends MainDispatcherFactory> list = _Sequences2.toList(d0.f0.n.asSequence(ServiceLoader.b()));
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
                MainCoroutineDispatcher mainCoroutineDispatcherCreateDispatcher = mainDispatcherFactory.createDispatcher(list);
                if (mainCoroutineDispatcherCreateDispatcher != null) {
                    return mainCoroutineDispatcherCreateDispatcher;
                }
            } catch (Throwable th) {
                mainDispatcherFactory.hintOnError();
                throw th;
            }
        }
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }
}
