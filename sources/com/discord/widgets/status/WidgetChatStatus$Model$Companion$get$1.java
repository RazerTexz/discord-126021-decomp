package com.discord.widgets.status;

import com.discord.models.application.Unread;
import java.util.Set;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatStatus$Model$Companion$get$1 extends C12236k implements Function3<Boolean, Set<? extends Long>, Unread, WidgetChatStatus.Model> {
    public WidgetChatStatus$Model$Companion$get$1(WidgetChatStatus.Model.Companion companion) {
        super(3, companion, WidgetChatStatus.Model.Companion.class, "createModel", "createModel(ZLjava/util/Set;Lcom/discord/models/application/Unread;)Lcom/discord/widgets/status/WidgetChatStatus$Model;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ WidgetChatStatus.Model invoke(Boolean bool, Set<? extends Long> set, Unread unread) {
        return invoke(bool.booleanValue(), (Set<Long>) set, unread);
    }

    public final WidgetChatStatus.Model invoke(boolean z2, Set<Long> set, Unread unread) {
        C12238m.checkNotNullParameter(set, "p2");
        C12238m.checkNotNullParameter(unread, "p3");
        return ((WidgetChatStatus.Model.Companion) this.receiver).createModel(z2, set, unread);
    }
}
