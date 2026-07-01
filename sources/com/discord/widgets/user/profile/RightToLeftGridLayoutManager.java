package com.discord.widgets.user.profile;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: RightToLeftGridLayoutManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RightToLeftGridLayoutManager extends GridLayoutManager {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RightToLeftGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public boolean isLayoutRTL() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RightToLeftGridLayoutManager(Context context, int i) {
        super(context, i);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RightToLeftGridLayoutManager(Context context, int i, int i2, boolean z2) {
        super(context, i, i2, z2);
        Intrinsics3.checkNotNullParameter(context, "context");
    }
}
