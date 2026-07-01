package com.discord.views.stages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.views.stages.SpeakersRecyclerView, reason: use source file name */
/* JADX INFO: compiled from: SpeakersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpeakersAdapter2 extends RecyclerView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakersAdapter2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent e) {
        return false;
    }
}
