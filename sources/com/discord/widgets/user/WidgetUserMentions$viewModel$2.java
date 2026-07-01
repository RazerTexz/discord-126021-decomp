package com.discord.widgets.user;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$viewModel$2 extends Lambda implements Function0<WidgetUserMentionsViewModel> {
    public static final WidgetUserMentions$viewModel$2 INSTANCE = new WidgetUserMentions$viewModel$2();

    public WidgetUserMentions$viewModel$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetUserMentionsViewModel invoke() {
        return new WidgetUserMentionsViewModel();
    }
}
