package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import p659s.p660a.AbstractC13128l1;
import p659s.p660a.p662b2.C13048a;
import p659s.p660a.p662b2.C13050c;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public /* bridge */ /* synthetic */ AbstractC13128l1 createDispatcher(List list) {
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
    public C13048a createDispatcher(List<? extends MainDispatcherFactory> allFactories) {
        return new C13048a(C13050c.m11197a(Looper.getMainLooper(), true), null, false);
    }
}
