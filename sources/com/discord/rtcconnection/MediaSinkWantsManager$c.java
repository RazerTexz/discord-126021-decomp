package com.discord.rtcconnection;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MediaSinkWantsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsManager$c extends o implements Function0<Unit> {
    public final /* synthetic */ Long $ssrc;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ MediaSinkWantsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaSinkWantsManager$c(MediaSinkWantsManager mediaSinkWantsManager, Long l, long j) {
        super(0);
        this.this$0 = mediaSinkWantsManager;
        this.$ssrc = l;
        this.$userId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        if (this.$ssrc != null) {
            this.this$0.a.put(Long.valueOf(this.$userId), this.$ssrc);
        } else {
            this.this$0.a.remove(Long.valueOf(this.$userId));
        }
        MediaSinkWantsManager.e(this.this$0, null, 1);
        return Unit.a;
    }
}
