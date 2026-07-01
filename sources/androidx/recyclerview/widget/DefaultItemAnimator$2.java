package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DefaultItemAnimator$2 implements Runnable {
    public final /* synthetic */ DefaultItemAnimator this$0;
    public final /* synthetic */ ArrayList val$changes;

    public DefaultItemAnimator$2(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.this$0 = defaultItemAnimator;
        this.val$changes = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.val$changes.iterator();
        while (it.hasNext()) {
            this.this$0.animateChangeImpl((DefaultItemAnimator$ChangeInfo) it.next());
        }
        this.val$changes.clear();
        this.this$0.mChangesList.remove(this.val$changes);
    }
}
