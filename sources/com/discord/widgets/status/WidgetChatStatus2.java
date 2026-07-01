package com.discord.widgets.status;

import com.discord.models.application.Unread;
import com.discord.widgets.status.WidgetChatStatus;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Set;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetChatStatus$Model$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatStatus2 extends FunctionReferenceImpl implements Function3<Boolean, Set<? extends Long>, Unread, WidgetChatStatus.Model> {
    public WidgetChatStatus2(WidgetChatStatus.Model.Companion companion) {
        super(3, companion, WidgetChatStatus.Model.Companion.class, "createModel", "createModel(ZLjava/util/Set;Lcom/discord/models/application/Unread;)Lcom/discord/widgets/status/WidgetChatStatus$Model;", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ WidgetChatStatus.Model invoke(Boolean bool, Set<? extends Long> set, Unread unread) {
        return invoke(bool.booleanValue(), (Set<Long>) set, unread);
    }

    public final WidgetChatStatus.Model invoke(boolean z2, Set<Long> set, Unread unread) {
        Intrinsics3.checkNotNullParameter(set, "p2");
        Intrinsics3.checkNotNullParameter(unread, "p3");
        return ((WidgetChatStatus.Model.Companion) this.receiver).createModel(z2, set, unread);
    }
}
