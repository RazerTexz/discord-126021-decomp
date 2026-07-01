package com.discord.utilities.mg_recycler;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MGRecyclerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGRecyclerAdapter$Companion {
    private MGRecyclerAdapter$Companion() {
    }

    public final <D, T extends MGRecyclerAdapter<D>> T configure(T adapter) {
        m.checkNotNullParameter(adapter, "adapter");
        try {
            RecyclerView recycler = adapter.getRecycler();
            RecyclerView$LayoutManager layoutManager = adapter.getRecycler().getLayoutManager();
            RecyclerView$ItemAnimator recyclerView$ItemAnimator = null;
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            SelfHealingLinearLayoutManager selfHealingLinearLayoutManager = new SelfHealingLinearLayoutManager(adapter.getRecycler(), adapter, linearLayoutManager != null ? linearLayoutManager.getOrientation() : 1, false);
            selfHealingLinearLayoutManager.setSmoothScrollbarEnabled(true);
            recycler.setLayoutManager(selfHealingLinearLayoutManager);
            recycler.setAdapter(adapter);
            recycler.setHasFixedSize(true);
            RecyclerView$ItemAnimator itemAnimator = recycler.getItemAnimator();
            if (itemAnimator instanceof SimpleItemAnimator) {
                recyclerView$ItemAnimator = itemAnimator;
            }
            SimpleItemAnimator simpleItemAnimator = (SimpleItemAnimator) recyclerView$ItemAnimator;
            if (simpleItemAnimator != null) {
                simpleItemAnimator.setSupportsChangeAnimations(false);
            }
            return adapter;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public /* synthetic */ MGRecyclerAdapter$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
