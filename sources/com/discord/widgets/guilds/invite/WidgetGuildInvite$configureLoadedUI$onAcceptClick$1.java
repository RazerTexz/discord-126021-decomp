package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.error.Error;
import com.discord.widgets.home.HomeConfig;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p018d.C0870j;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.C12185b;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInvite$configureLoadedUI$onAcceptClick$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInvite this$0;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1 */
    /* JADX INFO: compiled from: WidgetGuildInvite.kt */
    @InterfaceC12188e(m10084c = "com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1", m10085f = "WidgetGuildInvite.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C86461 extends AbstractC12194k implements Function2<Error, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public C86461(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            C86461 c86461 = WidgetGuildInvite$configureLoadedUI$onAcceptClick$1.this.new C86461(continuation);
            c86461.L$0 = obj;
            return c86461;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Error error, Continuation<? super Unit> continuation) {
            return ((C86461) create(error, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            C12183c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
            WidgetGuildInvite$configureLoadedUI$onAcceptClick$1.this.this$0.configureUIFailure((Error) this.L$0);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2 */
    /* JADX INFO: compiled from: WidgetGuildInvite.kt */
    @InterfaceC12188e(m10084c = "com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2", m10085f = "WidgetGuildInvite.kt", m10086l = {}, m10087m = "invokeSuspend")
    public static final class C86472 extends AbstractC12194k implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public C86472(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            C86472 c86472 = WidgetGuildInvite$configureLoadedUI$onAcceptClick$1.this.new C86472(continuation);
            c86472.L$0 = obj;
            return c86472;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((C86472) create(modelInvite, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            C12183c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C12113l.throwOnFailure(obj);
            ModelInvite modelInvite = (ModelInvite) this.L$0;
            Intent intentAddFlags = new Intent().addFlags(268468224);
            Guild guild = modelInvite.guild;
            Long lBoxLong = C12185b.boxBoolean(modelInvite.isNewMember()).booleanValue() ? guild != null ? C12185b.boxLong(guild.getId()) : null : null;
            GuildScheduledEvent guildScheduledEvent = modelInvite.getGuildScheduledEvent();
            intentAddFlags.putExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG", new HomeConfig(lBoxLong, guildScheduledEvent != null ? C12185b.boxLong(guildScheduledEvent.getId()) : null, false, 4, null));
            C12238m.checkNotNullExpressionValue(intentAddFlags, "Intent()\n               …      )\n                }");
            Context context = WidgetGuildInvite$configureLoadedUI$onAcceptClick$1.this.this$0.getContext();
            if (context != null) {
                C12238m.checkNotNullExpressionValue(context, "context");
                C0870j.m155c(context, false, intentAddFlags, 2);
                AppActivity appActivity = WidgetGuildInvite$configureLoadedUI$onAcceptClick$1.this.this$0.getAppActivity();
                if (appActivity != null) {
                    appActivity.finish();
                }
            }
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInvite$configureLoadedUI$onAcceptClick$1(WidgetGuildInvite widgetGuildInvite, ModelInvite modelInvite) {
        super(0);
        this.this$0 = widgetGuildInvite;
        this.$invite = modelInvite;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        InviteJoinHelper.INSTANCE.joinViaInvite(this.$invite, this.this$0.getClass(), this.this$0, "Accept Invite Page", (Opcodes.D2F & 16) != 0 ? new InviteJoinHelper.C86321(null) : new C86461(null), (Opcodes.D2F & 32) != 0 ? new InviteJoinHelper.C86332(null) : null, (Opcodes.D2F & 64) != 0 ? new InviteJoinHelper.C86343(null) : new C86472(null), (Opcodes.D2F & 128) != 0 ? null : null);
    }
}
