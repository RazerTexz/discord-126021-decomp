package com.discord.gateway;

import com.discord.gateway.io.Outgoing;
import com.discord.gateway.io.OutgoingPayload$GuildMembersRequest;
import com.discord.gateway.opcodes.Opcode;
import com.google.gson.Gson;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$requestGuildMembers$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $guildIds;
    public final /* synthetic */ Integer $limit;
    public final /* synthetic */ String $query;
    public final /* synthetic */ List $userIds;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$requestGuildMembers$1(GatewaySocket gatewaySocket, List list, String str, List list2, Integer num) {
        super(0);
        this.this$0 = gatewaySocket;
        this.$guildIds = list;
        this.$query = str;
        this.$userIds = list2;
        this.$limit = num;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        OutgoingPayload$GuildMembersRequest outgoingPayload$GuildMembersRequest = new OutgoingPayload$GuildMembersRequest(this.$guildIds, this.$query, this.$userIds, this.$limit, false, 16, null);
        GatewaySocket$Companion.log$default(GatewaySocket.Companion, GatewaySocket.access$getLogger$p(this.this$0), "Sending guild member request: " + outgoingPayload$GuildMembersRequest, false, 2, null);
        GatewaySocket gatewaySocket = this.this$0;
        Outgoing outgoing = new Outgoing(Opcode.REQUEST_GUILD_MEMBERS, outgoingPayload$GuildMembersRequest);
        Gson gsonAccess$getGsonOmitNulls$cp = GatewaySocket.access$getGsonOmitNulls$cp();
        m.checkNotNullExpressionValue(gsonAccess$getGsonOmitNulls$cp, "gsonOmitNulls");
        GatewaySocket.send$default(gatewaySocket, outgoing, false, gsonAccess$getGsonOmitNulls$cp, 2, null);
    }
}
