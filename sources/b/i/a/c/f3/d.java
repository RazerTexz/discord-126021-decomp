package b.i.a.c.f3;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements ThreadFactory {
    public final /* synthetic */ String j;

    public /* synthetic */ d(String str) {
        this.j = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.j);
    }
}
