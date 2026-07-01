package com.discord.widgets.forums;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ForumBrowserScrollListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumBrowserScrollListener extends RecyclerView$OnScrollListener {
    private Function0<Unit> onScrollCallback;
    private Function0<Unit> onScrollEndCallback;
    private Function1<? super Integer, Unit> onScrollStateChangedCallback;

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, newState);
        Function1<? super Integer, Unit> function1 = this.onScrollStateChangedCallback;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(newState));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        Function0<Unit> function0;
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, dx, dy);
        RecyclerView$LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            Function0<Unit> function1 = this.onScrollCallback;
            if (function1 != null) {
                function1.invoke();
            }
            if (linearLayoutManager.findLastVisibleItemPosition() < linearLayoutManager.getItemCount() - 5 || (function0 = this.onScrollEndCallback) == null) {
                return;
            }
            function0.invoke();
        }
    }

    public final void setOnScrollCallback(Function0<Unit> onScroll) {
        m.checkNotNullParameter(onScroll, "onScroll");
        this.onScrollCallback = onScroll;
    }

    public final void setOnScrollEndCallback(Function0<Unit> onScrollEnd) {
        m.checkNotNullParameter(onScrollEnd, "onScrollEnd");
        this.onScrollEndCallback = onScrollEnd;
    }

    public final void setOnScrollStateChangedCallback(Function1<? super Integer, Unit> onScrollStateChanged) {
        m.checkNotNullParameter(onScrollStateChanged, "onScrollStateChanged");
        this.onScrollStateChangedCallback = onScrollStateChanged;
    }
}
