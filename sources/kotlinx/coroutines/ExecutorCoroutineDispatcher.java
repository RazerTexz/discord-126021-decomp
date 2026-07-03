package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p584w.AbstractC12175b;
import p659s.p660a.C13154u0;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    /* JADX INFO: renamed from: kotlinx.coroutines.ExecutorCoroutineDispatcher$a */
    /* JADX INFO: compiled from: Executors.kt */
    public static final class C12805a extends AbstractC12175b<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        public C12805a(DefaultConstructorMarker defaultConstructorMarker) {
            super(CoroutineDispatcher.INSTANCE, C13154u0.f27905j);
        }
    }

    static {
        new C12805a(null);
    }

    /* JADX INFO: renamed from: H */
    public abstract Executor mo10908H();
}
