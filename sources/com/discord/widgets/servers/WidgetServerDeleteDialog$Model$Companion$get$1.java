package com.discord.widgets.servers;

import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.widgets.servers.WidgetServerDeleteDialog;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerDeleteDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerDeleteDialog$Model$Companion$get$1 extends C12236k implements Function2<MeUser, Guild, WidgetServerDeleteDialog.Model> {
    public static final WidgetServerDeleteDialog$Model$Companion$get$1 INSTANCE = new WidgetServerDeleteDialog$Model$Companion$get$1();

    public WidgetServerDeleteDialog$Model$Companion$get$1() {
        super(2, WidgetServerDeleteDialog.Model.class, "<init>", "<init>(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final WidgetServerDeleteDialog.Model invoke(MeUser meUser, Guild guild) {
        C12238m.checkNotNullParameter(meUser, "p1");
        return new WidgetServerDeleteDialog.Model(meUser, guild);
    }
}
