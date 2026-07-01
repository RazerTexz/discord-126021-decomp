package com.discord.stores;

import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAudioManagerV2$init$1$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ DiscordAudioManager$DeviceTypes $it;
    public final /* synthetic */ StoreAudioManagerV2$init$1$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAudioManagerV2$init$1$2$1(StoreAudioManagerV2$init$1$2 storeAudioManagerV2$init$1$2, DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes) {
        super(0);
        this.this$0 = storeAudioManagerV2$init$1$2;
        this.$it = discordAudioManager$DeviceTypes;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreAudioManagerV2.access$updateActiveAudioDevice(this.this$0.this$0.this$0, this.$it);
    }
}
