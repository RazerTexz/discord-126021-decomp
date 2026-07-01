package b.i.a.g.d;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$State;

/* JADX INFO: compiled from: SmoothCalendarLayoutManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends LinearLayoutManager {
    public j(Context context, int i, boolean z2) {
        super(context, i, z2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView$State recyclerView$State, int i) {
        j$a j_a = new j$a(this, recyclerView.getContext());
        j_a.setTargetPosition(i);
        startSmoothScroll(j_a);
    }
}
