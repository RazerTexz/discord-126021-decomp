package com.discord.widgets.search;

import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch$configureSearchInput$4<T, R> implements b<DraweeSpanStringBuilder, String> {
    public static final WidgetSearch$configureSearchInput$4 INSTANCE = new WidgetSearch$configureSearchInput$4();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ String call(DraweeSpanStringBuilder draweeSpanStringBuilder) {
        return call2(draweeSpanStringBuilder);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final String call2(DraweeSpanStringBuilder draweeSpanStringBuilder) {
        m.checkNotNullParameter(draweeSpanStringBuilder, IconCompat.EXTRA_OBJ);
        return draweeSpanStringBuilder.toString();
    }
}
