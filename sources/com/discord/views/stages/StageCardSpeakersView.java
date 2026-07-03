package com.discord.views.stages;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import p007b.p008a.p025i.C1069v3;
import p007b.p008a.p062y.p068o0.C1366c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageCardSpeakersView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCardSpeakersView extends LinearLayout {

    /* JADX INFO: renamed from: j */
    public static final RecyclerView.ItemDecoration f19290j = new C7121a();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final C1069v3 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final C1366c speakersAdapter;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final GridLayoutManager speakersLayoutManager;

    /* JADX INFO: renamed from: com.discord.views.stages.StageCardSpeakersView$a */
    /* JADX INFO: compiled from: StageCardSpeakersView.kt */
    public static final class C7121a extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            C12238m.checkNotNullParameter(rect, "outRect");
            C12238m.checkNotNullParameter(view, "view");
            C12238m.checkNotNullParameter(recyclerView, "parent");
            C12238m.checkNotNullParameter(state, "state");
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
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.view_stage_card_speakers, this);
        SpeakersRecyclerView speakersRecyclerView = (SpeakersRecyclerView) findViewById(C5419R.id.discovery_speakers_recycler);
        if (speakersRecyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(C5419R.id.discovery_speakers_recycler)));
        }
        C1069v3 c1069v3 = new C1069v3(this, speakersRecyclerView);
        C12238m.checkNotNullExpressionValue(c1069v3, "ViewStageCardSpeakersBin…ater.from(context), this)");
        this.binding = c1069v3;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        C12238m.checkNotNullExpressionValue(speakersRecyclerView, "binding.discoverySpeakersRecycler");
        C1366c c1366c = (C1366c) companion.configure(new C1366c(speakersRecyclerView));
        this.speakersAdapter = c1366c;
        C12238m.checkNotNullExpressionValue(speakersRecyclerView, "binding.discoverySpeakersRecycler");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(speakersRecyclerView.getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(c1366c.f2054a);
        this.speakersLayoutManager = gridLayoutManager;
        RecyclerView recycler = c1366c.getRecycler();
        recycler.setLayoutManager(gridLayoutManager);
        recycler.addItemDecoration(f19290j);
        recycler.setHasFixedSize(false);
    }
}
