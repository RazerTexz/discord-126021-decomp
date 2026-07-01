package s.a;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import s.a.a.LockFreeLinkedList3;

/* JADX INFO: renamed from: s.a.y, reason: use source file name */
/* JADX INFO: compiled from: CompletionHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CompletionHandler2 extends LockFreeLinkedList3 implements Function1<Throwable, Unit> {
    public abstract void q(Throwable th);
}
