package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.invite.InviteUtils;
import com.discord.stores.StoreStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList$onViewBound$6$$special$$inlined$let$lambda$1 extends AbstractC12240o implements Function1<ModelInvite, Unit> {
    public final /* synthetic */ View $it$inlined;
    public final /* synthetic */ long $selectedGuildId;
    public final /* synthetic */ WidgetChannelsList.C74386 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList$onViewBound$6$$special$$inlined$let$lambda$1(long j, WidgetChannelsList.C74386 c74386, View view) {
        super(1);
        this.$selectedGuildId = j;
        this.this$0 = c74386;
        this.$it$inlined = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        String vanityUrlCode;
        if (modelInvite != null) {
            String link = modelInvite.toLink(WidgetChannelsList.this.getResources(), BuildConfig.HOST_INVITE);
            Context context = this.$it$inlined.getContext();
            C12238m.checkNotNullExpressionValue(context, "it.context");
            C12238m.checkNotNullExpressionValue(link, "inviteLink");
            C0876m.m163a(context, link, C5419R.string.invite_link_copied);
            return;
        }
        Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(this.$selectedGuildId);
        if (guild == null || (vanityUrlCode = guild.getVanityUrlCode()) == null) {
            return;
        }
        String strCreateLinkFromCode = InviteUtils.INSTANCE.createLinkFromCode(vanityUrlCode, null);
        Context context2 = this.$it$inlined.getContext();
        C12238m.checkNotNullExpressionValue(context2, "it.context");
        C0876m.m163a(context2, strCreateLinkFromCode, C5419R.string.invite_link_copied);
    }
}
