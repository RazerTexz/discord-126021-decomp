package com.discord.utilities.stage;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.widgets.stage.StageChannelJoinHelper;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StageChannelUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelUtils$connectToStageChannel$2 extends o implements Function0<Unit> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ FragmentManager $fragmentManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelUtils$connectToStageChannel$2(Context context, FragmentManager fragmentManager, Channel channel) {
        super(0);
        this.$context = context;
        this.$fragmentManager = fragmentManager;
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StageChannelJoinHelper.connectToStage$default(StageChannelJoinHelper.INSTANCE, this.$context, this.$fragmentManager, this.$channel.getId(), false, false, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
    }
}
