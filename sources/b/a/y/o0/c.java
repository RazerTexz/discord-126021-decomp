package b.a.y.o0;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;

/* JADX INFO: compiled from: SpeakersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends MGRecyclerAdapterSimple<d> {
    public final GridLayoutManager$SpanSizeLookup a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        this.a = new c$a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        m.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            return new a(this);
        }
        if (i == 1) {
            return new b(this);
        }
        throw new IllegalStateException(b.d.b.a.a.q("Invalid view type: ", i));
    }
}
