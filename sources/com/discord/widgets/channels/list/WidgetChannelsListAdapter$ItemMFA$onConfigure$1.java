package com.discord.widgets.channels.list;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemMFA$onConfigure$1 extends o implements Function1<RenderContext, Unit> {
    public static final WidgetChannelsListAdapter$ItemMFA$onConfigure$1 INSTANCE = new WidgetChannelsListAdapter$ItemMFA$onConfigure$1();

    public WidgetChannelsListAdapter$ItemMFA$onConfigure$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("onClick", WidgetChannelsListAdapter$ItemMFA$onConfigure$1$1.INSTANCE);
    }
}
