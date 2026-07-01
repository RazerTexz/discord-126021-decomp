package com.discord.utilities.embed;

import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreRequestedStageChannels;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Map;
import kotlin.jvm.functions.Function4;

/* JADX INFO: renamed from: com.discord.utilities.embed.InviteEmbedModel$Companion$observe$1, reason: use source file name */
/* JADX INFO: compiled from: InviteEmbedModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class InviteEmbedModel2 extends FunctionReferenceImpl implements Function4<Map<Long, ? extends Channel>, Map<String, ? extends StoreInstantInvites.InviteState>, Map<Long, ? extends StageInstance>, Map<Long, ? extends StoreRequestedStageChannels.StageInstanceState>, InviteEmbedModel> {
    public static final InviteEmbedModel2 INSTANCE = new InviteEmbedModel2();

    public InviteEmbedModel2() {
        super(4, InviteEmbedModel.class, "<init>", "<init>(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ InviteEmbedModel invoke(Map<Long, ? extends Channel> map, Map<String, ? extends StoreInstantInvites.InviteState> map2, Map<Long, ? extends StageInstance> map3, Map<Long, ? extends StoreRequestedStageChannels.StageInstanceState> map4) {
        return invoke2((Map<Long, Channel>) map, map2, (Map<Long, StageInstance>) map3, (Map<Long, StoreRequestedStageChannels.StageInstanceState>) map4);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final InviteEmbedModel invoke2(Map<Long, Channel> map, Map<String, ? extends StoreInstantInvites.InviteState> map2, Map<Long, StageInstance> map3, Map<Long, StoreRequestedStageChannels.StageInstanceState> map4) {
        Intrinsics3.checkNotNullParameter(map, "p1");
        Intrinsics3.checkNotNullParameter(map2, "p2");
        Intrinsics3.checkNotNullParameter(map3, "p3");
        Intrinsics3.checkNotNullParameter(map4, "p4");
        return new InviteEmbedModel(map, map2, map3, map4);
    }
}
