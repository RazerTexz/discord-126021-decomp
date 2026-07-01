package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import b.a.d.AppScreen2;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.error.Error;
import com.discord.widgets.guilds.invite.InviteJoinHelper;
import com.discord.widgets.home.HomeConfig;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.boxing;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInvite3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ WidgetGuildInvite this$0;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInvite.kt */
    @DebugMetadata(c = "com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$1", f = "WidgetGuildInvite.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<Error, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 anonymousClass1 = WidgetGuildInvite3.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Error error, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(error, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            WidgetGuildInvite3.this.this$0.configureUIFailure((Error) this.L$0);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInvite.kt */
    @DebugMetadata(c = "com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2", f = "WidgetGuildInvite.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            AnonymousClass2 anonymousClass2 = WidgetGuildInvite3.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(modelInvite, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            ModelInvite modelInvite = (ModelInvite) this.L$0;
            Intent intentAddFlags = new Intent().addFlags(268468224);
            Guild guild = modelInvite.guild;
            Long lBoxLong = boxing.boxBoolean(modelInvite.isNewMember()).booleanValue() ? guild != null ? boxing.boxLong(guild.getId()) : null : null;
            GuildScheduledEvent guildScheduledEvent = modelInvite.getGuildScheduledEvent();
            intentAddFlags.putExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG", new HomeConfig(lBoxLong, guildScheduledEvent != null ? boxing.boxLong(guildScheduledEvent.getId()) : null, false, 4, null));
            Intrinsics3.checkNotNullExpressionValue(intentAddFlags, "Intent()\n               …      )\n                }");
            Context context = WidgetGuildInvite3.this.this$0.getContext();
            if (context != null) {
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                AppScreen2.c(context, false, intentAddFlags, 2);
                AppActivity appActivity = WidgetGuildInvite3.this.this$0.getAppActivity();
                if (appActivity != null) {
                    appActivity.finish();
                }
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInvite3(WidgetGuildInvite widgetGuildInvite, ModelInvite modelInvite) {
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
        InviteJoinHelper.INSTANCE.joinViaInvite(this.$invite, this.this$0.getClass(), this.this$0, "Accept Invite Page", (Opcodes.D2F & 16) != 0 ? new InviteJoinHelper.AnonymousClass1(null) : new AnonymousClass1(null), (Opcodes.D2F & 32) != 0 ? new InviteJoinHelper.AnonymousClass2(null) : null, (Opcodes.D2F & 64) != 0 ? new InviteJoinHelper.AnonymousClass3(null) : new AnonymousClass2(null), (Opcodes.D2F & 128) != 0 ? null : null);
    }
}
