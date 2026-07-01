package com.discord.gateway;

import b.d.b.a.a;
import com.discord.api.presence.ClientStatus;
import com.discord.gateway.io.Outgoing;
import com.discord.gateway.io.OutgoingPayload$PresenceUpdate;
import com.discord.gateway.opcodes.Opcode;
import com.discord.utilities.logging.Logger;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$presenceUpdate$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $activities;
    public final /* synthetic */ Boolean $afk;
    public final /* synthetic */ Long $since;
    public final /* synthetic */ ClientStatus $status;
    public final /* synthetic */ GatewaySocket this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewaySocket$presenceUpdate$1(GatewaySocket gatewaySocket, ClientStatus clientStatus, List list, Long l, Boolean bool) {
        super(0);
        this.this$0 = gatewaySocket;
        this.$status = clientStatus;
        this.$activities = list;
        this.$since = l;
        this.$afk = bool;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String strName;
        GatewaySocket$Companion gatewaySocket$Companion = GatewaySocket.Companion;
        Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(this.this$0);
        StringBuilder sbU = a.U("Sending self presence update: ");
        sbU.append(this.$status);
        sbU.append(' ');
        List list = this.$activities;
        String lowerCase = null;
        sbU.append(list != null ? u.joinToString$default(list, null, null, null, 0, null, GatewaySocket$presenceUpdate$1$1.INSTANCE, 31, null) : null);
        GatewaySocket$Companion.log$default(gatewaySocket$Companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
        GatewaySocket gatewaySocket = this.this$0;
        Opcode opcode = Opcode.PRESENCE_UPDATE;
        ClientStatus clientStatus = this.$status;
        if (clientStatus != null && (strName = clientStatus.name()) != null) {
            Locale locale = Locale.ROOT;
            m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            lowerCase = strName.toLowerCase(locale);
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        }
        Long l = this.$since;
        List listEmptyList = this.$activities;
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        GatewaySocket.send$default(gatewaySocket, new Outgoing(opcode, new OutgoingPayload$PresenceUpdate(lowerCase, l, listEmptyList, this.$afk)), false, null, 6, null);
    }
}
