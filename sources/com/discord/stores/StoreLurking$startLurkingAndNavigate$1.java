package com.discord.stores;

import android.content.Context;
import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$startLurkingAndNavigate$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreLurking this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLurking$startLurkingAndNavigate$1(StoreLurking storeLurking, long j, Long l, Context context) {
        super(0);
        this.this$0 = storeLurking;
        this.$guildId = j;
        this.$channelId = l;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (StoreLurking.access$getSessionId$p(this.this$0) != null) {
            StoreLurking.startLurkingInternal$default(this.this$0, this.$guildId, this.$channelId, false, new StoreLurking$startLurkingAndNavigate$1$1(this), null, this.$context, 20, null);
            return;
        }
        StringBuilder sbU = a.U("Queue lurk request: ");
        sbU.append(this.$guildId);
        sbU.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sbU.append(this.$channelId);
        AppLog.i(sbU.toString());
        StoreLurking.access$setLurkRequest$p(this.this$0, new StoreLurking$LurkRequest(this.$guildId, this.$channelId));
    }
}
