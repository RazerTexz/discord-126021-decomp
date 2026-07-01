package com.discord.widgets.chat.input.gifpicker;

import android.content.res.Resources;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: GifAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifAdapter$Companion {
    private GifAdapter$Companion() {
    }

    public final int calculateColumnCount(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        Resources resources = recyclerView.getResources();
        m.checkNotNullExpressionValue(resources, "recyclerView.resources");
        return Math.max(2, Math.max(resources.getDisplayMetrics().widthPixels, 1) / DimenUtils.dpToPixels(Opcodes.IF_ICMPLE));
    }

    public final int calculateColumnWidth(RecyclerView recyclerView, int numColumns, int columnSpacePx) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        Resources resources = recyclerView.getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getDisplayMetrics().widthPixels;
        ViewGroup$LayoutParams layoutParams = recyclerView.getLayoutParams();
        int marginStart = i - (layoutParams instanceof ViewGroup$MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart((ViewGroup$MarginLayoutParams) layoutParams) : 0);
        ViewGroup$LayoutParams layoutParams2 = recyclerView.getLayoutParams();
        return (int) (((((marginStart - (layoutParams2 instanceof ViewGroup$MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup$MarginLayoutParams) layoutParams2) : 0)) - recyclerView.getPaddingStart()) - recyclerView.getPaddingEnd()) - ((numColumns - 1) * columnSpacePx)) / numColumns);
    }

    public /* synthetic */ GifAdapter$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
