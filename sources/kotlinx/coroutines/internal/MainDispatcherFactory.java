package kotlinx.coroutines.internal;

import java.util.List;
import p659s.p660a.AbstractC13128l1;

/* JADX INFO: compiled from: MainDispatcherFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface MainDispatcherFactory {
    AbstractC13128l1 createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
