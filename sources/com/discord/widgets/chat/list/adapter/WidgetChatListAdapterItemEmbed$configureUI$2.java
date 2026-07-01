package com.discord.widgets.chat.list.adapter;

import android.view.ViewPropertyAnimator;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$configureUI$2 extends o implements Function1<ViewPropertyAnimator, Unit> {
    public static final WidgetChatListAdapterItemEmbed$configureUI$2 INSTANCE = new WidgetChatListAdapterItemEmbed$configureUI$2();

    public WidgetChatListAdapterItemEmbed$configureUI$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
        invoke2(viewPropertyAnimator);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
        m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
        viewPropertyAnimator.scaleX(0.9f);
        viewPropertyAnimator.scaleY(0.9f);
    }
}
