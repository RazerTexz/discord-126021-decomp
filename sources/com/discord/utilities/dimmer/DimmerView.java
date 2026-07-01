package com.discord.utilities.dimmer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.discord.utilities.view.extensions.ViewExtensions;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DimmerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DimmerView extends RelativeLayout {
    private final ProgressBar dimmerProgressBar;

    public DimmerView(Context context) {
        this(context, null, 0, 6, null);
    }

    public DimmerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DimmerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ void setDimmed$default(DimmerView dimmerView, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z3 = true;
        }
        dimmerView.setDimmed(z2, z3);
    }

    public final void setDimmed(boolean z2) {
        setDimmed$default(this, z2, false, 2, null);
    }

    public final void setDimmed(boolean dimmed, boolean showProgressBar) {
        DimmerView dimmerView;
        if (dimmed) {
            dimmerView = this;
            ViewExtensions.fadeIn$default(dimmerView, 0L, null, null, null, 15, null);
        } else {
            ViewExtensions.fadeOut$default(this, 0L, null, null, 7, null);
            dimmerView = this;
        }
        dimmerView.dimmerProgressBar.setVisibility((dimmed && showProgressBar) ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DimmerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        ProgressBar progressBar = new ProgressBar(context);
        this.dimmerProgressBar = progressBar;
        progressBar.setVisibility(8);
        addView(progressBar);
    }
}
