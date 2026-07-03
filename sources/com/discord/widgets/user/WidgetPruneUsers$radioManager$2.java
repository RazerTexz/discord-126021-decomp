package com.discord.widgets.user;

import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetPruneUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetPruneUsers$radioManager$2 extends AbstractC12240o implements Function0<RadioManager> {
    public final /* synthetic */ WidgetPruneUsers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPruneUsers$radioManager$2(WidgetPruneUsers widgetPruneUsers) {
        super(0);
        this.this$0 = widgetPruneUsers;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RadioManager invoke() {
        return new RadioManager(C12147n.listOf((Object[]) new CheckedSetting[]{this.this$0.getBinding().f17392f, this.this$0.getBinding().f17393g}));
    }
}
