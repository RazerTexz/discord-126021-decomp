package com.discord.utilities.recycler;

import android.R$color;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$State;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SpaceBetweenItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpaceBetweenItemDecoration extends DividerItemDecoration {
    private final RecyclerView$Adapter<?> adapter;
    private final int color;
    private final int sizePx;

    public /* synthetic */ SpaceBetweenItemDecoration(Context context, int i, RecyclerView$Adapter recyclerView$Adapter, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, recyclerView$Adapter, (i4 & 8) != 0 ? DimenUtils.dpToPixels(16) : i2, (i4 & 16) != 0 ? R$color.transparent : i3);
    }

    @Override // androidx.recyclerview.widget.DividerItemDecoration, androidx.recyclerview.widget.RecyclerView$ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView$State state) {
        m.checkNotNullParameter(outRect, "outRect");
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(parent, "parent");
        m.checkNotNullParameter(state, "state");
        if (parent.getChildAdapterPosition(view) != this.adapter.getPageSize() - 1) {
            super.getItemOffsets(outRect, view, parent, state);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpaceBetweenItemDecoration(Context context, int i, RecyclerView$Adapter<?> recyclerView$Adapter, int i2, @ColorRes int i3) {
        super(context, i);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(recyclerView$Adapter, "adapter");
        this.adapter = recyclerView$Adapter;
        this.sizePx = i2;
        this.color = i3;
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i2);
        Paint paint = shapeDrawable.getPaint();
        m.checkNotNullExpressionValue(paint, "paint");
        paint.setColor(ContextCompat.getColor(context, i3));
        setDrawable(shapeDrawable);
    }
}
