package s.a.c2;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g<E> {
    Object a(Continuation<? super Boolean> continuation);

    E next();
}
