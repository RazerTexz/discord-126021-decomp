package com.discord.stores;

import com.discord.api.voice.state.VoiceState;
import d0.t.h0;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreVoiceStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreVoiceStates$observe$1 extends o implements Function0<Map<Long, ? extends VoiceState>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreVoiceStates this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreVoiceStates$observe$1(StoreVoiceStates storeVoiceStates, long j) {
        super(0);
        this.this$0 = storeVoiceStates;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends VoiceState> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends VoiceState> invoke2() {
        Map<Long, ? extends VoiceState> map = (Map) StoreVoiceStates.access$getVoiceStatesSnapshot$p(this.this$0).get(Long.valueOf(this.$guildId));
        return map != null ? map : h0.emptyMap();
    }
}
