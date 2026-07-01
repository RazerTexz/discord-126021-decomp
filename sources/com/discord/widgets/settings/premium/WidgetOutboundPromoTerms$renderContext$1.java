package com.discord.widgets.settings.premium;

import android.content.Context;
import com.discord.utilities.textprocessing.node.UrlNode$RenderContext;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetOutboundPromoTerms.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOutboundPromoTerms$renderContext$1 implements UrlNode$RenderContext {
    private final Context context;
    private final int linkColorAttrResId;
    private final Function3<Context, String, String, Unit> onClickUrl = WidgetOutboundPromoTerms$renderContext$1$onClickUrl$1.INSTANCE;
    private final Function1<String, Unit> onLongPressUrl;
    public final /* synthetic */ WidgetOutboundPromoTerms this$0;

    public WidgetOutboundPromoTerms$renderContext$1(WidgetOutboundPromoTerms widgetOutboundPromoTerms) {
        this.this$0 = widgetOutboundPromoTerms;
        Context contextRequireContext = widgetOutboundPromoTerms.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        this.context = contextRequireContext;
        this.linkColorAttrResId = 2130969054;
        this.onLongPressUrl = WidgetOutboundPromoTerms$renderContext$1$onLongPressUrl$1.INSTANCE;
    }

    @Override // com.discord.utilities.textprocessing.node.BasicRenderContext, com.discord.utilities.textprocessing.node.UserMentionNode$RenderContext, com.discord.utilities.textprocessing.node.EmojiNode$RenderContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode$RenderContext
    public int getLinkColorAttrResId() {
        return this.linkColorAttrResId;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode$RenderContext
    public Function3<Context, String, String, Unit> getOnClickUrl() {
        return this.onClickUrl;
    }

    @Override // com.discord.utilities.textprocessing.node.UrlNode$RenderContext
    public Function1<String, Unit> getOnLongPressUrl() {
        return this.onLongPressUrl;
    }
}
