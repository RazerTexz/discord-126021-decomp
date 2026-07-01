package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import com.discord.BuildConfig;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.invite.InviteUtils;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$6$$special$$inlined$let$lambda$1 extends o implements Function1<ModelInvite, Unit> {
    public final /* synthetic */ View $it$inlined;
    public final /* synthetic */ long $selectedGuildId;
    public final /* synthetic */ WidgetChannelsList$onViewBound$6 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$6$$special$$inlined$let$lambda$1(long j, WidgetChannelsList$onViewBound$6 widgetChannelsList$onViewBound$6, View view) {
        super(1);
        this.$selectedGuildId = j;
        this.this$0 = widgetChannelsList$onViewBound$6;
        this.$it$inlined = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        String vanityUrlCode;
        if (modelInvite != null) {
            String link = modelInvite.toLink(this.this$0.this$0.getResources(), BuildConfig.HOST_INVITE);
            Context context = this.$it$inlined.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            m.checkNotNullExpressionValue(link, "inviteLink");
            b.a.d.m.a(context, link, 2131892298);
            return;
        }
        Guild guild = StoreStream.Companion.getGuilds().getGuild(this.$selectedGuildId);
        if (guild == null || (vanityUrlCode = guild.getVanityUrlCode()) == null) {
            return;
        }
        String strCreateLinkFromCode = InviteUtils.INSTANCE.createLinkFromCode(vanityUrlCode, null);
        Context context2 = this.$it$inlined.getContext();
        m.checkNotNullExpressionValue(context2, "it.context");
        b.a.d.m.a(context2, strCreateLinkFromCode, 2131892298);
    }
}
