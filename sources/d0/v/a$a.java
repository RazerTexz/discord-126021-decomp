package d0.v;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Thread.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a extends Thread {
    public final /* synthetic */ Function0 j;

    public a$a(Function0 function0) {
        this.j = function0;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.j.invoke();
    }
}
