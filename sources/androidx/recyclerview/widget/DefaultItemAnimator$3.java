package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class DefaultItemAnimator$3 implements Runnable {
    public final /* synthetic */ DefaultItemAnimator this$0;
    public final /* synthetic */ ArrayList val$additions;

    public DefaultItemAnimator$3(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.this$0 = defaultItemAnimator;
        this.val$additions = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.val$additions.iterator();
        while (it.hasNext()) {
            this.this$0.animateAddImpl((RecyclerView$ViewHolder) it.next());
        }
        this.val$additions.clear();
        this.this$0.mAdditionsList.remove(this.val$additions);
    }
}
