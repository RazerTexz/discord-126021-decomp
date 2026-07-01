package com.discord.utilities.views;

import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SwipeableItemTouchHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class SwipeableItemTouchHelper extends ItemTouchHelper.SimpleCallback {
    private final ColorDrawable background;
    private final SwipeRevealConfiguration endConfiguration;
    private final SwipeRevealConfiguration startConfiguration;

    /* JADX INFO: compiled from: SwipeableItemTouchHelper.kt */
    public static final class SwipeRevealConfiguration {
        private final int backgroundColor;
        private final Drawable icon;
        private final int padding;

        public SwipeRevealConfiguration() {
            this(0, null, 0, 7, null);
        }

        public SwipeRevealConfiguration(@ColorInt int i, Drawable drawable, int i2) {
            this.backgroundColor = i;
            this.icon = drawable;
            this.padding = i2;
        }

        public final int getBackgroundColor() {
            return this.backgroundColor;
        }

        public final Drawable getIcon() {
            return this.icon;
        }

        public final int getPadding() {
            return this.padding;
        }

        public /* synthetic */ SwipeRevealConfiguration(int i, Drawable drawable, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? null : drawable, (i3 & 4) != 0 ? 0 : i2);
        }
    }

    public SwipeableItemTouchHelper() {
        this(0, 0, null, null, 15, null);
    }

    public /* synthetic */ SwipeableItemTouchHelper(int i, int i2, SwipeRevealConfiguration swipeRevealConfiguration, SwipeRevealConfiguration swipeRevealConfiguration2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 12 : i2, (i3 & 4) != 0 ? null : swipeRevealConfiguration, (i3 & 8) != 0 ? null : swipeRevealConfiguration2);
    }

    public final SwipeRevealConfiguration getEndConfiguration() {
        return this.endConfiguration;
    }

    public final SwipeRevealConfiguration getStartConfiguration() {
        return this.startConfiguration;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        Intrinsics3.checkNotNullParameter(c, "c");
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
        View view = viewHolder.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "viewHolder.itemView");
        float f = 0;
        if (dX > f && this.startConfiguration != null) {
            int left = view.getLeft();
            int left2 = view.getLeft() + ((int) dX);
            this.background.setColor(this.startConfiguration.getBackgroundColor());
            this.background.setBounds(left, view.getTop(), left2, view.getBottom());
            this.background.draw(c);
            Drawable icon = this.startConfiguration.getIcon();
            if (icon != null) {
                int iMin = Math.min(this.startConfiguration.getPadding() + icon.getIntrinsicWidth() + left, left2);
                int intrinsicWidth = iMin - icon.getIntrinsicWidth();
                int height = ((view.getHeight() - icon.getIntrinsicHeight()) / 2) + view.getTop();
                icon.setBounds(intrinsicWidth, height, iMin, icon.getIntrinsicHeight() + height);
                icon.draw(c);
            }
        } else if (dX < f && this.endConfiguration != null) {
            int right = view.getRight() + ((int) dX);
            int right2 = view.getRight();
            this.background.setColor(this.endConfiguration.getBackgroundColor());
            this.background.setBounds(right, view.getTop(), right2, view.getBottom());
            this.background.draw(c);
            Drawable icon2 = this.endConfiguration.getIcon();
            if (icon2 != null) {
                int iMin2 = right2 - Math.min((int) Math.abs(dX), this.endConfiguration.getPadding() + icon2.getIntrinsicWidth());
                int intrinsicWidth2 = icon2.getIntrinsicWidth() + iMin2;
                int height2 = ((view.getHeight() - icon2.getIntrinsicHeight()) / 2) + view.getTop();
                icon2.setBounds(iMin2, height2, intrinsicWidth2, icon2.getIntrinsicHeight() + height2);
                icon2.draw(c);
            }
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics3.checkNotNullParameter(target, "target");
        return false;
    }

    public SwipeableItemTouchHelper(int i, int i2, SwipeRevealConfiguration swipeRevealConfiguration, SwipeRevealConfiguration swipeRevealConfiguration2) {
        super(i, i2);
        this.startConfiguration = swipeRevealConfiguration;
        this.endConfiguration = swipeRevealConfiguration2;
        this.background = new ColorDrawable();
    }
}
