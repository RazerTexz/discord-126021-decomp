package com.discord.stores;

import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.rtcconnection.audio.DiscordAudioManager$DeviceTypes;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreAudioManagerV2.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAudioManagerV2$toggleSpeakerOutput$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreAudioManagerV2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAudioManagerV2$toggleSpeakerOutput$1(StoreAudioManagerV2 storeAudioManagerV2) {
        super(0);
        this.this$0 = storeAudioManagerV2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypesPrevious;
        if (this.this$0.getState().getActiveAudioDevice().ordinal() != 2) {
            this.this$0.selectOutputDevice(DiscordAudioManager$DeviceTypes.SPEAKERPHONE);
            return;
        }
        DiscordAudioManager discordAudioManager = DiscordAudioManager.d;
        List<DiscordAudioManager$DeviceTypes> list = DiscordAudioManager.c;
        ListIterator<DiscordAudioManager$DeviceTypes> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            discordAudioManager$DeviceTypesPrevious = listIterator.previous();
            DiscordAudioManager$DeviceTypes discordAudioManager$DeviceTypes = discordAudioManager$DeviceTypesPrevious;
            if (discordAudioManager$DeviceTypes != DiscordAudioManager$DeviceTypes.SPEAKERPHONE && this.this$0.getState().getAudioDevices().get(discordAudioManager$DeviceTypes.getValue()).isAvailable) {
                m.checkNotNull(discordAudioManager$DeviceTypesPrevious);
                this.this$0.selectOutputDevice(discordAudioManager$DeviceTypesPrevious);
            }
        }
        discordAudioManager$DeviceTypesPrevious = null;
        m.checkNotNull(discordAudioManager$DeviceTypesPrevious);
        this.this$0.selectOutputDevice(discordAudioManager$DeviceTypesPrevious);
    }
}
