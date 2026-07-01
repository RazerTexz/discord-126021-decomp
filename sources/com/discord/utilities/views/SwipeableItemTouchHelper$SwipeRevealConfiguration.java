package com.discord.utilities.views;

import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SwipeableItemTouchHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SwipeableItemTouchHelper$SwipeRevealConfiguration {
    private final int backgroundColor;
    private final Drawable icon;
    private final int padding;

    public SwipeableItemTouchHelper$SwipeRevealConfiguration() {
        this(0, null, 0, 7, null);
    }

    public SwipeableItemTouchHelper$SwipeRevealConfiguration(@ColorInt int i, Drawable drawable, int i2) {
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

    public /* synthetic */ SwipeableItemTouchHelper$SwipeRevealConfiguration(int i, Drawable drawable, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? null : drawable, (i3 & 4) != 0 ? 0 : i2);
    }
}
