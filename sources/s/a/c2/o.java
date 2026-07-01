package s.a.c2;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface o<E> {
    void b(CancellationException cancellationException);

    g<E> iterator();

    Object m(Continuation<? super v<? extends E>> continuation);
}
