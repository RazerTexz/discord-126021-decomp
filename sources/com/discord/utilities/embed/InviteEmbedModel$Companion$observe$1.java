package com.discord.utilities.embed;

import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreRequestedStageChannels;
import java.util.Map;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InviteEmbedModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class InviteEmbedModel$Companion$observe$1 extends C12236k implements Function4<Map<Long, ? extends Channel>, Map<String, ? extends StoreInstantInvites.InviteState>, Map<Long, ? extends StageInstance>, Map<Long, ? extends StoreRequestedStageChannels.StageInstanceState>, InviteEmbedModel> {
    public static final InviteEmbedModel$Companion$observe$1 INSTANCE = new InviteEmbedModel$Companion$observe$1();

    public InviteEmbedModel$Companion$observe$1() {
        super(4, InviteEmbedModel.class, "<init>", "<init>(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ InviteEmbedModel invoke(Map<Long, ? extends Channel> map, Map<String, ? extends StoreInstantInvites.InviteState> map2, Map<Long, ? extends StageInstance> map3, Map<Long, ? extends StoreRequestedStageChannels.StageInstanceState> map4) {
        return invoke2((Map<Long, Channel>) map, map2, (Map<Long, StageInstance>) map3, (Map<Long, StoreRequestedStageChannels.StageInstanceState>) map4);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final InviteEmbedModel invoke2(Map<Long, Channel> map, Map<String, ? extends StoreInstantInvites.InviteState> map2, Map<Long, StageInstance> map3, Map<Long, StoreRequestedStageChannels.StageInstanceState> map4) {
        C12238m.checkNotNullParameter(map, "p1");
        C12238m.checkNotNullParameter(map2, "p2");
        C12238m.checkNotNullParameter(map3, "p3");
        C12238m.checkNotNullParameter(map4, "p4");
        return new InviteEmbedModel(map, map2, map3, map4);
    }
}
