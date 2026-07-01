package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import s.a.MainCoroutineDispatcher;
import s.a.b2.HandlerDispatcher2;
import s.a.b2.HandlerDispatcher4;

/* JADX INFO: renamed from: kotlinx.coroutines.android.AndroidDispatcherFactory, reason: use source file name */
/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HandlerDispatcher implements MainDispatcherFactory {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public /* bridge */ /* synthetic */ MainCoroutineDispatcher createDispatcher(List list) {
        return createDispatcher((List<? extends MainDispatcherFactory>) list);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public HandlerDispatcher2 createDispatcher(List<? extends MainDispatcherFactory> allFactories) {
        return new HandlerDispatcher2(HandlerDispatcher4.a(Looper.getMainLooper(), true), null, false);
    }
}
