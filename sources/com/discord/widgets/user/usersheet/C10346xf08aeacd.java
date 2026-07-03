package com.discord.widgets.user.usersheet;

import android.content.Context;
import com.discord.models.user.User;
import com.discord.widgets.user.WidgetUserMutualGuilds;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureConnectionsSection$onMutualGuildsItemClick$1 */
/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10346xf08aeacd extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ User $user;
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10346xf08aeacd(WidgetUserSheet widgetUserSheet, User user) {
        super(0);
        this.this$0 = widgetUserSheet;
        this.$user = user;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetUserMutualGuilds.Companion companion = WidgetUserMutualGuilds.INSTANCE;
        Context contextRequireContext = this.this$0.requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        companion.show(contextRequireContext, this.$user.getId());
    }
}
