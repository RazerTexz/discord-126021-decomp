package com.discord.widgets.stage.start;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ModeratorStartStageAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModeratorStartStageAdapter extends MGRecyclerAdapterSimple<ModeratorStartStageItem> {
    private final Function1<ModeratorStartStageItem, Unit> onItemClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ModeratorStartStageAdapter(RecyclerView recyclerView, Function1<? super ModeratorStartStageItem, Unit> function1) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(function1, "onItemClicked");
        this.onItemClicked = function1;
    }

    public final Function1<ModeratorStartStageItem, Unit> getOnItemClicked() {
        return this.onItemClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, ModeratorStartStageItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new ModeratorStartStageAdapter$HeaderViewHolder(this, null, 1, null);
        }
        if (viewType == 1) {
            return new ModeratorStartStageAdapter$ListItemViewHolder(this, null, 1, null);
        }
        if (viewType == 2) {
            return new ModeratorStartStageAdapter$ContinueViewHolder(this, null, 1, null);
        }
        if (viewType == 3) {
            return new ModeratorStartStageAdapter$WaitingViewHolder(this, null, 1, null);
        }
        throw invalidViewTypeException(viewType);
    }
}
