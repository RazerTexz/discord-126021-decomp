package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppActivity;
import com.discord.models.domain.ModelInvite;
import com.discord.widgets.home.HomeConfig;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.b;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGuildInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
@e(c = "com.discord.widgets.guilds.invite.WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2", f = "WidgetGuildInvite.kt", l = {}, m = "invokeSuspend")
public final class WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2 extends k implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ WidgetGuildInvite$configureLoadedUI$onAcceptClick$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2(WidgetGuildInvite$configureLoadedUI$onAcceptClick$1 widgetGuildInvite$configureLoadedUI$onAcceptClick$1, Continuation continuation) {
        super(2, continuation);
        this.this$0 = widgetGuildInvite$configureLoadedUI$onAcceptClick$1;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2 widgetGuildInvite$configureLoadedUI$onAcceptClick$1$2 = new WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2(this.this$0, continuation);
        widgetGuildInvite$configureLoadedUI$onAcceptClick$1$2.L$0 = obj;
        return widgetGuildInvite$configureLoadedUI$onAcceptClick$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
        return ((WidgetGuildInvite$configureLoadedUI$onAcceptClick$1$2) create(modelInvite, continuation)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) {
        c.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        l.throwOnFailure(obj);
        ModelInvite modelInvite = (ModelInvite) this.L$0;
        Intent intentAddFlags = new Intent().addFlags(268468224);
        Guild guild = modelInvite.guild;
        Long lBoxLong = b.boxBoolean(modelInvite.isNewMember()).booleanValue() ? guild != null ? b.boxLong(guild.getId()) : null : null;
        GuildScheduledEvent guildScheduledEvent = modelInvite.getGuildScheduledEvent();
        intentAddFlags.putExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG", new HomeConfig(lBoxLong, guildScheduledEvent != null ? b.boxLong(guildScheduledEvent.getId()) : null, false, 4, null));
        m.checkNotNullExpressionValue(intentAddFlags, "Intent()\n               …      )\n                }");
        Context context = this.this$0.this$0.getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context");
            j.c(context, false, intentAddFlags, 2);
            AppActivity appActivity = this.this$0.this$0.getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
        return Unit.a;
    }
}
