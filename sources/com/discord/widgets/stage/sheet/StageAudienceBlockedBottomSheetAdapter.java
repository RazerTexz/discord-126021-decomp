package com.discord.widgets.stage.sheet;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    public static final StageAudienceBlockedBottomSheetAdapter$Companion Companion = new StageAudienceBlockedBottomSheetAdapter$Companion(null);
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_PARTICIPANT = 1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageAudienceBlockedBottomSheetAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        return position != 0 ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new StageAudienceBlockedBottomSheetAdapter$HeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new StageAudienceBlockedBottomSheetAdapter$ParticipantViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
