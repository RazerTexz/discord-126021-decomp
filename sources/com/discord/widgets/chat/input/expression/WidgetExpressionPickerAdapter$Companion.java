package com.discord.widgets.chat.input.expression;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionPickerAdapter$Companion {
    private WidgetExpressionPickerAdapter$Companion() {
    }

    public final int calculateNumOfColumns(int margin, float itemSize, int defaultNumColumns, Resources resources) {
        m.checkNotNullParameter(resources, "resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        int i = (int) ((displayMetrics.widthPixels - margin) / itemSize);
        if (i != 0) {
            return i;
        }
        AppLog appLog = AppLog.g;
        StringBuilder sbU = a.U("\n          invalid dimensions while calculating numColumns\n          displayMetrics.widthPixels: ");
        sbU.append(displayMetrics.widthPixels);
        sbU.append("\n          total margin marginStart: ");
        sbU.append(margin);
        sbU.append("\n          itemSize: ");
        sbU.append(itemSize);
        sbU.append("\n        ");
        Logger.e$default(appLog, d0.g0.m.trimIndent(sbU.toString()), null, null, 6, null);
        return defaultNumColumns;
    }

    public /* synthetic */ WidgetExpressionPickerAdapter$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int calculateNumOfColumns(RecyclerView recyclerView, float itemSize, int defaultNumColumns) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        ViewGroup$LayoutParams layoutParams = recyclerView.getLayoutParams();
        int marginStart = layoutParams instanceof ViewGroup$MarginLayoutParams ? MarginLayoutParamsCompat.getMarginStart((ViewGroup$MarginLayoutParams) layoutParams) : 0;
        ViewGroup$LayoutParams layoutParams2 = recyclerView.getLayoutParams();
        int marginEnd = layoutParams2 instanceof ViewGroup$MarginLayoutParams ? MarginLayoutParamsCompat.getMarginEnd((ViewGroup$MarginLayoutParams) layoutParams2) : 0;
        Resources resources = recyclerView.getResources();
        m.checkNotNullExpressionValue(resources, "recyclerView.resources");
        return calculateNumOfColumns(marginStart + marginEnd, itemSize, defaultNumColumns, resources);
    }
}
