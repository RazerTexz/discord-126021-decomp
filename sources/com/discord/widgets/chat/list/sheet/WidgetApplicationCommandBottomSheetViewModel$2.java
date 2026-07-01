package com.discord.widgets.chat.list.sheet;

import androidx.core.app.NotificationCompat;
import j0.k.b;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetViewModel$2<T, R> implements b<WidgetApplicationCommandBottomSheetViewModel$StoreState, WidgetApplicationCommandBottomSheetViewModel$UserData> {
    public static final WidgetApplicationCommandBottomSheetViewModel$2 INSTANCE = new WidgetApplicationCommandBottomSheetViewModel$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetApplicationCommandBottomSheetViewModel$UserData call(WidgetApplicationCommandBottomSheetViewModel$StoreState widgetApplicationCommandBottomSheetViewModel$StoreState) {
        return call2(widgetApplicationCommandBottomSheetViewModel$StoreState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetApplicationCommandBottomSheetViewModel$UserData call2(WidgetApplicationCommandBottomSheetViewModel$StoreState widgetApplicationCommandBottomSheetViewModel$StoreState) {
        return new WidgetApplicationCommandBottomSheetViewModel$UserData(widgetApplicationCommandBottomSheetViewModel$StoreState.getMentionedUsers(), widgetApplicationCommandBottomSheetViewModel$StoreState.getUsers());
    }
}
