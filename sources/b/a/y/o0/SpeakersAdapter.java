package b.a.y.o0;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.y.o0.c, reason: use source file name */
/* JADX INFO: compiled from: SpeakersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpeakersAdapter extends MGRecyclerAdapterSimple<SpeakersItem> {
    public final GridLayoutManager.SpanSizeLookup a;

    /* JADX INFO: renamed from: b.a.y.o0.c$a */
    /* JADX INFO: compiled from: SpeakersAdapter.kt */
    public static final class a extends GridLayoutManager.SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakersAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        this.a = new a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            return new SpeakersViewHolder(this);
        }
        if (i == 1) {
            return new SpeakersViewHolder2(this);
        }
        throw new IllegalStateException(outline.q("Invalid view type: ", i));
    }
}
