package com.discord.widgets.guild_role_subscriptions.tier.create;

import com.discord.utilities.color.ColorCompat;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildRoleSubscriptionMemberPreview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionMemberPreview$defaultColor$2 extends o implements Function0<Integer> {
    public final /* synthetic */ GuildRoleSubscriptionMemberPreview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionMemberPreview$defaultColor$2(GuildRoleSubscriptionMemberPreview guildRoleSubscriptionMemberPreview) {
        super(0);
        this.this$0 = guildRoleSubscriptionMemberPreview;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return ColorCompat.getColor(this.this$0, 2131100171);
    }
}
