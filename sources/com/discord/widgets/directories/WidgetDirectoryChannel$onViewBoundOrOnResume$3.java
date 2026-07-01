package com.discord.widgets.directories;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel$onViewBoundOrOnResume$3<T, R> implements b<WidgetDirectoriesViewModel$ViewState, Boolean> {
    public static final WidgetDirectoryChannel$onViewBoundOrOnResume$3 INSTANCE = new WidgetDirectoryChannel$onViewBoundOrOnResume$3();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Boolean call(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        return call2(widgetDirectoriesViewModel$ViewState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        return Boolean.valueOf(widgetDirectoriesViewModel$ViewState != null);
    }
}
