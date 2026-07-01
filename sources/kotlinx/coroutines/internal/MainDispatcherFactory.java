package kotlinx.coroutines.internal;

import java.util.List;
import s.a.l1;

/* JADX INFO: compiled from: MainDispatcherFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface MainDispatcherFactory {
    l1 createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
