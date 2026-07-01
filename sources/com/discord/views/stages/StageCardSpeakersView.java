package com.discord.views.stages;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.ViewStageCardSpeakersBinding;
import b.a.y.o0.SpeakersAdapter;
import com.discord.R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: StageCardSpeakersView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCardSpeakersView extends LinearLayout {
    public static final RecyclerView.ItemDecoration j = new a();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final ViewStageCardSpeakersBinding binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final SpeakersAdapter speakersAdapter;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final GridLayoutManager speakersLayoutManager;

    /* JADX INFO: compiled from: StageCardSpeakersView.kt */
    public static final class a extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            Intrinsics3.checkNotNullParameter(rect, "outRect");
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(recyclerView, "parent");
            Intrinsics3.checkNotNullParameter(state, "state");
            super.getItemOffsets(rect, view, recyclerView, state);
            boolean z2 = recyclerView.getChildAdapterPosition(view) >= state.getItemCount() + (-2);
            rect.left = DimenUtils.dpToPixels(4);
            rect.right = DimenUtils.dpToPixels(4);
            rect.bottom = z2 ? 0 : DimenUtils.dpToPixels(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCardSpeakersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_stage_card_speakers, this);
        SpeakersAdapter2 speakersAdapter2 = (SpeakersAdapter2) findViewById(R.id.discovery_speakers_recycler);
        if (speakersAdapter2 == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.discovery_speakers_recycler)));
        }
        ViewStageCardSpeakersBinding viewStageCardSpeakersBinding = new ViewStageCardSpeakersBinding(this, speakersAdapter2);
        Intrinsics3.checkNotNullExpressionValue(viewStageCardSpeakersBinding, "ViewStageCardSpeakersBin…ater.from(context), this)");
        this.binding = viewStageCardSpeakersBinding;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(speakersAdapter2, "binding.discoverySpeakersRecycler");
        SpeakersAdapter speakersAdapter = (SpeakersAdapter) companion.configure(new SpeakersAdapter(speakersAdapter2));
        this.speakersAdapter = speakersAdapter;
        Intrinsics3.checkNotNullExpressionValue(speakersAdapter2, "binding.discoverySpeakersRecycler");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(speakersAdapter2.getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(speakersAdapter.a);
        this.speakersLayoutManager = gridLayoutManager;
        RecyclerView recycler = speakersAdapter.getRecycler();
        recycler.setLayoutManager(gridLayoutManager);
        recycler.addItemDecoration(j);
        recycler.setHasFixedSize(false);
    }
}
