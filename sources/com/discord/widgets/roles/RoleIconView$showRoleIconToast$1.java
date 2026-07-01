package com.discord.widgets.roles;

import android.content.Context;
import com.discord.api.role.GuildRole;
import com.discord.utilities.icon.IconUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: RoleIconView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleIconView$showRoleIconToast$1 extends o implements Function3<Boolean, Integer, Context, String> {
    public final /* synthetic */ GuildRole $role;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleIconView$showRoleIconToast$1(GuildRole guildRole) {
        super(3);
        this.$role = guildRole;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ String invoke(Boolean bool, Integer num, Context context) {
        return invoke(bool.booleanValue(), num.intValue(), context);
    }

    public final String invoke(boolean z2, int i, Context context) {
        m.checkNotNullParameter(context, "<anonymous parameter 2>");
        IconUtils iconUtils = IconUtils.INSTANCE;
        long id2 = this.$role.getId();
        String icon = this.$role.getIcon();
        m.checkNotNull(icon);
        return IconUtils.getRoleIconUrl$default(iconUtils, id2, icon, null, 4, null);
    }
}
