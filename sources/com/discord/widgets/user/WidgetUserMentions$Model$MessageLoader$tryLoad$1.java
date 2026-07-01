package com.discord.widgets.user;

import com.discord.widgets.user.WidgetUserMentions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$tryLoad$1 extends Lambda implements Function1<WidgetUserMentions.Model.MessageLoader.LoadingState, WidgetUserMentions.Model.MessageLoader.LoadingState> {
    public static final WidgetUserMentions$Model$MessageLoader$tryLoad$1 INSTANCE = new WidgetUserMentions$Model$MessageLoader$tryLoad$1();

    public WidgetUserMentions$Model$MessageLoader$tryLoad$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetUserMentions.Model.MessageLoader.LoadingState invoke(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
        Intrinsics3.checkNotNullParameter(loadingState, "it");
        return loadingState;
    }
}
