package com.discord.widgets.servers;

import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsChannelListAdapter$computeChangedPositions$3 extends o implements Function1<CategoricalDragAndDropAdapter$Payload, Boolean> {
    public static final SettingsChannelListAdapter$computeChangedPositions$3 INSTANCE = new SettingsChannelListAdapter$computeChangedPositions$3();

    public SettingsChannelListAdapter$computeChangedPositions$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CategoricalDragAndDropAdapter$Payload categoricalDragAndDropAdapter$Payload) {
        return Boolean.valueOf(invoke2(categoricalDragAndDropAdapter$Payload));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(CategoricalDragAndDropAdapter$Payload categoricalDragAndDropAdapter$Payload) {
        m.checkNotNullParameter(categoricalDragAndDropAdapter$Payload, "item");
        int type = categoricalDragAndDropAdapter$Payload.getType();
        if (type == 0) {
            return ((SettingsChannelListAdapter$ChannelItem) categoricalDragAndDropAdapter$Payload).getCanManageCategoryOfChannel();
        }
        if (type != 1) {
            return false;
        }
        return ((SettingsChannelListAdapter$CategoryItem) categoricalDragAndDropAdapter$Payload).getCanManageCategory();
    }
}
