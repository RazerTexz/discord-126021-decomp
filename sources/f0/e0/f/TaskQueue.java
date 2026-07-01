package f0.e0.f;

import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: f0.e0.f.b, reason: use source file name */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskQueue extends Task2 {
    public final /* synthetic */ Function0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue(Function0 function0, String str, boolean z2, String str2, boolean z3) {
        super(str2, z3);
        this.e = function0;
    }

    @Override // f0.e0.f.Task2
    public long a() {
        this.e.invoke();
        return -1L;
    }
}
