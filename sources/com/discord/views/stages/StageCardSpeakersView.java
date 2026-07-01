package com.discord.views.stages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import b.a.i.v3;
import b.a.y.o0.c;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import d0.z.d.m;

/* JADX INFO: compiled from: StageCardSpeakersView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCardSpeakersView extends LinearLayout {
    public static final RecyclerView$ItemDecoration j = new StageCardSpeakersView$a();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final v3 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final c speakersAdapter;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final GridLayoutManager speakersLayoutManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCardSpeakersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_stage_card_speakers, this);
        SpeakersRecyclerView speakersRecyclerView = (SpeakersRecyclerView) findViewById(R$id.discovery_speakers_recycler);
        if (speakersRecyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R$id.discovery_speakers_recycler)));
        }
        v3 v3Var = new v3(this, speakersRecyclerView);
        m.checkNotNullExpressionValue(v3Var, "ViewStageCardSpeakersBin…ater.from(context), this)");
        this.binding = v3Var;
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        m.checkNotNullExpressionValue(speakersRecyclerView, "binding.discoverySpeakersRecycler");
        c cVar = (c) mGRecyclerAdapter$Companion.configure(new c(speakersRecyclerView));
        this.speakersAdapter = cVar;
        m.checkNotNullExpressionValue(speakersRecyclerView, "binding.discoverySpeakersRecycler");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(speakersRecyclerView.getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(cVar.a);
        this.speakersLayoutManager = gridLayoutManager;
        RecyclerView recycler = cVar.getRecycler();
        recycler.setLayoutManager(gridLayoutManager);
        recycler.addItemDecoration(j);
        recycler.setHasFixedSize(false);
    }
}
