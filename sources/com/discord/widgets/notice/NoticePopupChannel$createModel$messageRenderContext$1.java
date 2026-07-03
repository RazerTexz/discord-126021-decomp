package com.discord.widgets.notice;

import com.discord.widgets.chat.WidgetUrlActions;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: NoticePopupChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopupChannel$createModel$messageRenderContext$1 extends AbstractC12240o implements Function1<String, Unit> {
    public static final NoticePopupChannel$createModel$messageRenderContext$1 INSTANCE = new NoticePopupChannel$createModel$messageRenderContext$1();

    public NoticePopupChannel$createModel$messageRenderContext$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        C12238m.checkNotNullParameter(str, "url");
        WidgetUrlActions.INSTANCE.requestNotice(str);
    }
}
