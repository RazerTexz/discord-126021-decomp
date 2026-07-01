package androidx.work.impl.constraints.trackers;

import androidx.work.impl.constraints.ConstraintListener;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintTracker$1 implements Runnable {
    public final /* synthetic */ ConstraintTracker this$0;
    public final /* synthetic */ List val$listenersList;

    public ConstraintTracker$1(ConstraintTracker constraintTracker, List list) {
        this.this$0 = constraintTracker;
        this.val$listenersList = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.val$listenersList.iterator();
        while (it.hasNext()) {
            ((ConstraintListener) it.next()).onConstraintChanged(this.this$0.mCurrentState);
        }
    }
}
