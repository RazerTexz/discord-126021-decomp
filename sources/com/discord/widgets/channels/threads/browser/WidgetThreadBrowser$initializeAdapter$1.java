package com.discord.widgets.channels.threads.browser;

import androidx.fragment.app.Fragment;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetThreadBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowser$initializeAdapter$1 extends o implements Function0<Fragment> {
    public final /* synthetic */ WidgetThreadBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowser$initializeAdapter$1(WidgetThreadBrowser widgetThreadBrowser) {
        super(0);
        this.this$0 = widgetThreadBrowser;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Fragment invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Fragment invoke() {
        return WidgetThreadBrowserActive.Companion.create(WidgetThreadBrowser.access$getViewModel$p(this.this$0).getGuildId(), WidgetThreadBrowser.access$getViewModel$p(this.this$0).getChannelId());
    }
}
