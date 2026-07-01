package com.discord.widgets.servers;

import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerDeleteDialog$Model$Companion$get$1 extends k implements Function2<MeUser, Guild, WidgetServerDeleteDialog$Model> {
    public static final WidgetServerDeleteDialog$Model$Companion$get$1 INSTANCE = new WidgetServerDeleteDialog$Model$Companion$get$1();

    public WidgetServerDeleteDialog$Model$Companion$get$1() {
        super(2, WidgetServerDeleteDialog$Model.class, "<init>", "<init>(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetServerDeleteDialog$Model invoke(MeUser meUser, Guild guild) {
        return invoke2(meUser, guild);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerDeleteDialog$Model invoke2(MeUser meUser, Guild guild) {
        m.checkNotNullParameter(meUser, "p1");
        return new WidgetServerDeleteDialog$Model(meUser, guild);
    }
}
