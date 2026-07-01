package com.discord.widgets.servers.guildboost;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnItemTouchListener;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildBoostPerkView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostPerkView$initialize$1 implements RecyclerView$OnItemTouchListener {
    @Override // androidx.recyclerview.widget.RecyclerView$OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        m.checkNotNullParameter(rv, "rv");
        m.checkNotNullParameter(e, "e");
        return e.getAction() == 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnItemTouchListener
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        m.checkNotNullParameter(rv, "rv");
        m.checkNotNullParameter(e, "e");
    }
}
