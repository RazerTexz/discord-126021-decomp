package s.a.c2;

import kotlin.coroutines.Continuation;

/* JADX INFO: renamed from: s.a.c2.g, reason: use source file name */
/* JADX INFO: compiled from: Channel.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Channel5<E> {
    Object a(Continuation<? super Boolean> continuation);

    E next();
}
