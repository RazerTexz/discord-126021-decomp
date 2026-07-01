package com.discord.utilities.recycler;

import android.R;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SpaceBetweenItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpaceBetweenItemDecoration extends DividerItemDecoration {
    private final RecyclerView.Adapter<?> adapter;
    private final int color;
    private final int sizePx;

    public /* synthetic */ SpaceBetweenItemDecoration(Context context, int i, RecyclerView.Adapter adapter, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i, adapter, (i4 & 8) != 0 ? DimenUtils.dpToPixels(16) : i2, (i4 & 16) != 0 ? R.color.transparent : i3);
    }

    @Override // androidx.recyclerview.widget.DividerItemDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(outRect, "outRect");
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        if (parent.getChildAdapterPosition(view) != this.adapter.getItemCount() - 1) {
            super.getItemOffsets(outRect, view, parent, state);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpaceBetweenItemDecoration(Context context, int i, RecyclerView.Adapter<?> adapter, int i2, @ColorRes int i3) {
        super(context, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
        this.sizePx = i2;
        this.color = i3;
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setIntrinsicWidth(i2);
        shapeDrawable.setIntrinsicHeight(i2);
        Paint paint = shapeDrawable.getPaint();
        Intrinsics3.checkNotNullExpressionValue(paint, "paint");
        paint.setColor(ContextCompat.getColor(context, i3));
        setDrawable(shapeDrawable);
    }
}
