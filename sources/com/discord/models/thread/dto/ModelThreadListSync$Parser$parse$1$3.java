package com.discord.models.thread.dto;

import androidx.core.app.NotificationCompat;
import com.discord.api.thread.ThreadMember;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import d0.z.d.m;
import java.util.List;
import rx.functions.Action1;

/* JADX INFO: compiled from: ModelThreadListSync.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelThreadListSync$Parser$parse$1$3<T> implements Action1<String> {
    public final /* synthetic */ ModelThreadListSync$Parser$parse$1 this$0;

    public ModelThreadListSync$Parser$parse$1$3(ModelThreadListSync$Parser$parse$1 modelThreadListSync$Parser$parse$1) {
        this.this$0 = modelThreadListSync$Parser$parse$1;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        ThreadMember threadMember = (ThreadMember) InboundGatewayGsonParser.fromJson(this.this$0.$reader, ThreadMember.class);
        m.checkNotNullExpressionValue(str, "threadId");
        ((List) this.this$0.$members.element).add(new ThreadMember(Long.parseLong(str), threadMember.getUserId(), threadMember.getFlags(), threadMember.getJoinTimestamp(), threadMember.getMuted(), threadMember.getMuteConfig()));
    }
}
