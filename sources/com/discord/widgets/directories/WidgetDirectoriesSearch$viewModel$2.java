package com.discord.widgets.directories;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetDirectoriesSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesSearch$viewModel$2 extends AbstractC12240o implements Function0<WidgetDirectoriesSearchViewModel> {
    public final /* synthetic */ WidgetDirectoriesSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesSearch$viewModel$2(WidgetDirectoriesSearch widgetDirectoriesSearch) {
        super(0);
        this.this$0 = widgetDirectoriesSearch;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetDirectoriesSearchViewModel invoke() {
        return new WidgetDirectoriesSearchViewModel(this.this$0.getArgs().getChannelId(), null, null, null, 14, null);
    }
}
