package com.discord.widgets.channels.list;

import android.content.Context;
import android.view.View;
import b.a.d.AppToast;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.invite.InviteUtils;
import com.discord.stores.StoreStream;
import com.discord.widgets.channels.list.WidgetChannelsList;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsList$onViewBound$6$$special$$inlined$let$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsList3 extends Lambda implements Function1<ModelInvite, Unit> {
    public final /* synthetic */ View $it$inlined;
    public final /* synthetic */ long $selectedGuildId;
    public final /* synthetic */ WidgetChannelsList.AnonymousClass6 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelsList3(long j, WidgetChannelsList.AnonymousClass6 anonymousClass6, View view) {
        super(1);
        this.$selectedGuildId = j;
        this.this$0 = anonymousClass6;
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
            String link = modelInvite.toLink(WidgetChannelsList.this.getResources(), BuildConfig.HOST_INVITE);
            Context context = this.$it$inlined.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            Intrinsics3.checkNotNullExpressionValue(link, "inviteLink");
            AppToast.a(context, link, R.string.invite_link_copied);
            return;
        }
        Guild guild = StoreStream.INSTANCE.getGuilds().getGuild(this.$selectedGuildId);
        if (guild == null || (vanityUrlCode = guild.getVanityUrlCode()) == null) {
            return;
        }
        String strCreateLinkFromCode = InviteUtils.INSTANCE.createLinkFromCode(vanityUrlCode, null);
        Context context2 = this.$it$inlined.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "it.context");
        AppToast.a(context2, strCreateLinkFromCode, R.string.invite_link_copied);
    }
}
