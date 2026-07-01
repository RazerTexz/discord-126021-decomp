package b.i.a.b.j;

import c0.a.Provider3;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: b.i.a.b.j.g, reason: use source file name */
/* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ExecutionModule_ExecutorFactory implements Provider3 {

    /* JADX INFO: renamed from: b.i.a.b.j.g$a */
    /* JADX INFO: compiled from: ExecutionModule_ExecutorFactory.java */
    public static final class a {
        public static final ExecutionModule_ExecutorFactory a = new ExecutionModule_ExecutorFactory();
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new SafeLoggingExecutor(Executors.newSingleThreadExecutor());
    }
}
