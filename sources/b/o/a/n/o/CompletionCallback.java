package b.o.a.n.o;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.o.a.n.o.f, reason: use source file name */
/* JADX INFO: compiled from: CompletionCallback.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class CompletionCallback implements ActionCallback {
    @Override // b.o.a.n.o.ActionCallback
    public final void a(@NonNull Action2 action2, int i) {
        if (i == Integer.MAX_VALUE) {
            b(action2);
        }
    }

    public abstract void b(@NonNull Action2 action2);
}
