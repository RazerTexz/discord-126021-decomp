package com.discord.widgets.guilds.list;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList7 extends Lambda implements Function0<WidgetGuildsListViewModel> {
    public static final WidgetGuildsList7 INSTANCE = new WidgetGuildsList7();

    public WidgetGuildsList7() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildsListViewModel invoke() {
        return new WidgetGuildsListViewModel(null, null, 3, null);
    }
}
