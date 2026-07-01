package androidx.fragment.app;

import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public class ListFragment$1 implements Runnable {
    public final /* synthetic */ ListFragment this$0;

    public ListFragment$1(ListFragment listFragment) {
        this.this$0 = listFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        ListView listView = this.this$0.mList;
        listView.focusableViewAvailable(listView);
    }
}
