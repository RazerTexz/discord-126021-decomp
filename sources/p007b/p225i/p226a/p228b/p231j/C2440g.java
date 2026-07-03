package p007b.p225i.p226a.p228b.p231j;

import java.util.concurrent.Executors;
import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.g */
/* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2440g implements InterfaceC5318a {

    /* JADX INFO: renamed from: b.i.a.b.j.g$a */
    /* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final C2440g f5278a = new C2440g();
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public Object get() {
        return new ExecutorC2441h(Executors.newSingleThreadExecutor());
    }
}
