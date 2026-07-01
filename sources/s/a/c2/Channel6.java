package s.a.c2;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: s.a.c2.o, reason: use source file name */
/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Channel6<E> {
    void b(CancellationException cancellationException);

    Channel5<E> iterator();

    Object m(Continuation<? super Channel8<? extends E>> continuation);
}
