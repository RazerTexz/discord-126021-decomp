package com.discord.utilities.embed;

import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.StoreInstantInvites$InviteState;
import com.discord.stores.StoreRequestedStageChannels$StageInstanceState;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func4;

/* JADX INFO: compiled from: InviteEmbedModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteEmbedModel$Companion {
    private InviteEmbedModel$Companion() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Observable observe$default(InviteEmbedModel$Companion inviteEmbedModel$Companion, Observable observable, Observable observable2, Observable observable3, Observable observable4, int i, Object obj) {
        if ((i & 1) != 0) {
            observable = StoreStream.Companion.getChannels().observeGuildAndPrivateChannels();
        }
        if ((i & 2) != 0) {
            observable2 = StoreStream.Companion.getInstantInvites().observeKnownInvites();
        }
        if ((i & 4) != 0) {
            observable3 = StoreStream.Companion.getStageInstances().observeStageInstances();
        }
        if ((i & 8) != 0) {
            observable4 = StoreStream.Companion.getRequestedStageChannels().observeRequestedStageChannels();
        }
        return inviteEmbedModel$Companion.observe(observable, observable2, observable3, observable4);
    }

    public final Observable<InviteEmbedModel> observe(Observable<Map<Long, Channel>> channelsObservable, Observable<Map<String, StoreInstantInvites$InviteState>> knownInvitesObservable, Observable<Map<Long, StageInstance>> stageInstancesObservable, Observable<Map<Long, StoreRequestedStageChannels$StageInstanceState>> requestedStageInstances) {
        m.checkNotNullParameter(channelsObservable, "channelsObservable");
        m.checkNotNullParameter(knownInvitesObservable, "knownInvitesObservable");
        m.checkNotNullParameter(stageInstancesObservable, "stageInstancesObservable");
        m.checkNotNullParameter(requestedStageInstances, "requestedStageInstances");
        InviteEmbedModel$Companion$observe$1 inviteEmbedModel$Companion$observe$1 = InviteEmbedModel$Companion$observe$1.INSTANCE;
        Object inviteEmbedModel$sam$rx_functions_Func4$0 = inviteEmbedModel$Companion$observe$1;
        if (inviteEmbedModel$Companion$observe$1 != null) {
            inviteEmbedModel$sam$rx_functions_Func4$0 = new InviteEmbedModel$sam$rx_functions_Func4$0(inviteEmbedModel$Companion$observe$1);
        }
        Observable<InviteEmbedModel> observableH = Observable.h(channelsObservable, knownInvitesObservable, stageInstancesObservable, requestedStageInstances, (Func4) inviteEmbedModel$sam$rx_functions_Func4$0);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest… ::InviteEmbedModel\n    )");
        return observableH;
    }

    public /* synthetic */ InviteEmbedModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
