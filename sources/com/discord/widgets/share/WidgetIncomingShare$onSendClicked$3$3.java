package com.discord.widgets.share;

import androidx.fragment.app.FragmentManager;
import b.a.a.c;
import b.a.a.c$b;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemChannel;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload;
import com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemGuild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onSendClicked$3$3 extends o implements Function0<Unit> {
    public final /* synthetic */ MeUser $me;
    public final /* synthetic */ WidgetIncomingShare$onSendClicked$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$onSendClicked$3$3(WidgetIncomingShare$onSendClicked$3 widgetIncomingShare$onSendClicked$3, MeUser meUser) {
        super(0);
        this.this$0 = widgetIncomingShare$onSendClicked$3;
        this.$me = meUser;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Guild guild;
        WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload = this.this$0.$receiver;
        int maxFileSizeMB = 0;
        if (widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemGuild) {
            maxFileSizeMB = GuildUtilsKt.getMaxFileSizeMB(((WidgetGlobalSearchModel$ItemGuild) widgetGlobalSearchModel$ItemDataPayload).getGuild());
        } else if ((widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemChannel) && (guild = ((WidgetGlobalSearchModel$ItemChannel) widgetGlobalSearchModel$ItemDataPayload).getGuild()) != null) {
            maxFileSizeMB = GuildUtilsKt.getMaxFileSizeMB(guild);
        }
        int iMax = Math.max(maxFileSizeMB, PremiumUtils.INSTANCE.getMaxFileSizeMB(this.$me));
        c$b c_b = c.k;
        FragmentManager parentFragmentManager = this.this$0.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        UserUtils userUtils = UserUtils.INSTANCE;
        MeUser meUser = this.$me;
        m.checkNotNullExpressionValue(meUser, "me");
        boolean zIsPremium = userUtils.isPremium(meUser);
        int size = this.this$0.$data.size();
        WidgetIncomingShare$onSendClicked$3 widgetIncomingShare$onSendClicked$3 = this.this$0;
        c_b.a(parentFragmentManager, zIsPremium, iMax, Float.MAX_VALUE, Float.MAX_VALUE, null, size, widgetIncomingShare$onSendClicked$3.$hasImage, widgetIncomingShare$onSendClicked$3.$hasVideo, widgetIncomingShare$onSendClicked$3.$hasGif);
    }
}
