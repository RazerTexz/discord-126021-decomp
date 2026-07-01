package com.discord.widgets.stage;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreVoiceChannelSelected;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStage$1", f = "StageChannelJoinHelper.kt", l = {123}, m = "invokeSuspend")
public final class StageChannelJoinHelper$lurkAndJoinStage$1 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ FragmentManager $fragmentManager;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ boolean $launchFullscreen;
    public final /* synthetic */ StoreLurking $lurkingStore;
    public final /* synthetic */ StoreVoiceChannelSelected $selectedVoiceChannelStore;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageChannelJoinHelper$lurkAndJoinStage$1(Context context, FragmentManager fragmentManager, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$fragmentManager = fragmentManager;
        this.$guildId = j;
        this.$channelId = j2;
        this.$launchFullscreen = z2;
        this.$guildsStore = storeGuilds;
        this.$lurkingStore = storeLurking;
        this.$selectedVoiceChannelStore = storeVoiceChannelSelected;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new StageChannelJoinHelper$lurkAndJoinStage$1(this.$context, this.$fragmentManager, this.$guildId, this.$channelId, this.$launchFullscreen, this.$guildsStore, this.$lurkingStore, this.$selectedVoiceChannelStore, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StageChannelJoinHelper$lurkAndJoinStage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
            Context context = this.$context;
            FragmentManager fragmentManager = this.$fragmentManager;
            long j = this.$guildId;
            long j2 = this.$channelId;
            boolean z2 = this.$launchFullscreen;
            StoreGuilds storeGuilds = this.$guildsStore;
            StoreLurking storeLurking = this.$lurkingStore;
            StoreVoiceChannelSelected storeVoiceChannelSelected = this.$selectedVoiceChannelStore;
            this.label = 1;
            if (stageChannelJoinHelper.lurkAndJoinStageAsync(context, fragmentManager, j, j2, z2, storeGuilds, storeLurking, storeVoiceChannelSelected, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
        }
        return Unit.a;
    }
}
