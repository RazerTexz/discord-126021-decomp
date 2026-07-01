package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsChannelListAdapter$computeChangedPositions$1 extends o implements Function1<CategoricalDragAndDropAdapter$Payload, Long> {
    public static final SettingsChannelListAdapter$computeChangedPositions$1 INSTANCE = new SettingsChannelListAdapter$computeChangedPositions$1();

    public SettingsChannelListAdapter$computeChangedPositions$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(CategoricalDragAndDropAdapter$Payload categoricalDragAndDropAdapter$Payload) {
        return invoke2(categoricalDragAndDropAdapter$Payload);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Long invoke2(CategoricalDragAndDropAdapter$Payload categoricalDragAndDropAdapter$Payload) {
        m.checkNotNullParameter(categoricalDragAndDropAdapter$Payload, "item");
        int type = categoricalDragAndDropAdapter$Payload.getType();
        if (type == 0) {
            return Long.valueOf(((SettingsChannelListAdapter$ChannelItem) categoricalDragAndDropAdapter$Payload).getChannel().getId());
        }
        if (type == 1) {
            return Long.valueOf(((SettingsChannelListAdapter$CategoryItem) categoricalDragAndDropAdapter$Payload).getId());
        }
        AppLog appLog = AppLog.g;
        StringBuilder sbU = a.U("Invalid type: ");
        sbU.append(categoricalDragAndDropAdapter$Payload.getType());
        Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
        return null;
    }
}
