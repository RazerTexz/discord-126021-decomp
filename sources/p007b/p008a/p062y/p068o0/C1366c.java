package p007b.p008a.p062y.p068o0;

import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.o0.c */
/* JADX INFO: compiled from: SpeakersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1366c extends MGRecyclerAdapterSimple<AbstractC1367d> {

    /* JADX INFO: renamed from: a */
    public final GridLayoutManager.SpanSizeLookup f2054a;

    /* JADX INFO: renamed from: b.a.y.o0.c$a */
    /* JADX INFO: compiled from: SpeakersAdapter.kt */
    public static final class a extends GridLayoutManager.SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1366c(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        this.f2054a = new a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        C12238m.checkNotNullParameter(viewGroup, "parent");
        if (i == 0) {
            return new C1364a(this);
        }
        if (i == 1) {
            return new C1365b(this);
        }
        throw new IllegalStateException(C1643a.m871q("Invalid view type: ", i));
    }
}
