package com.discord.widgets.guilds.invite;

import com.discord.models.domain.ModelInvite;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInvite$configureLoadedUI$onAcceptClick$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInvite this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInvite$configureLoadedUI$onAcceptClick$1(WidgetGuildInvite widgetGuildInvite, ModelInvite modelInvite) {
        super(0);
        this.this$0 = widgetGuildInvite;
        this.$invite = modelInvite;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        InviteJoinHelper.joinViaInvite$default(InviteJoinHelper.INSTANCE, this.$invite, this.this$0.getClass(), this.this$0, "Accept Invite Page", new WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1(this, null), null, new WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2(this, null), null, Opcodes.IF_ICMPNE, null);
    }
}
