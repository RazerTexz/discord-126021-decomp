package com.discord.widgets.channels.list;

import com.discord.widgets.stage.model.StageChannel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListModel$Companion$getChannelEventNoticeData$1 extends AbstractC12240o implements Function1<StageChannel, Boolean> {
    public static final WidgetChannelListModel$Companion$getChannelEventNoticeData$1 INSTANCE = new WidgetChannelListModel$Companion$getChannelEventNoticeData$1();

    public WidgetChannelListModel$Companion$getChannelEventNoticeData$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(StageChannel stageChannel) {
        return Boolean.valueOf(invoke2(stageChannel));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(StageChannel stageChannel) {
        C12238m.checkNotNullParameter(stageChannel, "it");
        return stageChannel.getCanAccess() && stageChannel.getHasActiveStageInstance() && !stageChannel.getContainsMe();
    }
}
