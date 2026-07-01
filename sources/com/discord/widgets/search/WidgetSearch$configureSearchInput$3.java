package com.discord.widgets.search;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.textprocessing.AstRenderer;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
import j0.k.b;
import java.util.List;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch$configureSearchInput$3<T, R> implements b<List<? extends QueryNode>, DraweeSpanStringBuilder> {
    public final /* synthetic */ WidgetSearch this$0;

    public WidgetSearch$configureSearchInput$3(WidgetSearch widgetSearch) {
        this.this$0 = widgetSearch;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ DraweeSpanStringBuilder call(List<? extends QueryNode> list) {
        return call2(list);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final DraweeSpanStringBuilder call2(List<? extends QueryNode> list) {
        m.checkNotNullExpressionValue(list, "queryNodes");
        return AstRenderer.render(list, this.this$0.requireContext());
    }
}
