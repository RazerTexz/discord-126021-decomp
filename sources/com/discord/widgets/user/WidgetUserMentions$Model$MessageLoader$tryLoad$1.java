package com.discord.widgets.user;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$tryLoad$1 extends AbstractC12240o implements Function1<WidgetUserMentions.Model.MessageLoader.LoadingState, WidgetUserMentions.Model.MessageLoader.LoadingState> {
    public static final WidgetUserMentions$Model$MessageLoader$tryLoad$1 INSTANCE = new WidgetUserMentions$Model$MessageLoader$tryLoad$1();

    public WidgetUserMentions$Model$MessageLoader$tryLoad$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserMentions.Model.MessageLoader.LoadingState invoke(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
        C12238m.checkNotNullParameter(loadingState, "it");
        return loadingState;
    }
}
