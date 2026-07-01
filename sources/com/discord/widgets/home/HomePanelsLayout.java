package com.discord.widgets.home;

import android.content.Context;
import android.util.AttributeSet;
import com.discord.panels.OverlappingPanelsLayout;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HomePanelsLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HomePanelsLayout extends OverlappingPanelsLayout implements PanelLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePanelsLayout(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePanelsLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HomePanelsLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePanelsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HomePanelsLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
