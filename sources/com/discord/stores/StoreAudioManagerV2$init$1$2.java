package com.discord.stores;

import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAudioManagerV2$init$1$2 extends o implements Function1<DiscordAudioManager$DeviceTypes, Unit> {
    public final /* synthetic */ StoreAudioManagerV2$init$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAudioManagerV2$init$1$2(StoreAudioManagerV2$init$1 storeAudioManagerV2$init$1) {
        super(1);
        this.this$0 = storeAudioManagerV2$init$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes) {
        invoke2(discordAudioManager$DeviceTypes);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes) {
        m.checkNotNullParameter(discordAudioManager$DeviceTypes, "it");
        StoreAudioManagerV2.access$getDispatcher$p(this.this$0.this$0).schedule(new StoreAudioManagerV2$init$1$2$1(this, discordAudioManager$DeviceTypes));
    }
}
