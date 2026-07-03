package com.discord.widgets.share;

import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$configureUi$$inlined$apply$lambda$1 extends AbstractC12240o implements Function2<List<? extends WidgetGlobalSearchModel.ItemDataPayload>, List<? extends WidgetGlobalSearchModel.ItemDataPayload>, Unit> {
    public final /* synthetic */ WidgetIncomingShare.Model $this_configureUi$inlined;
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$configureUi$$inlined$apply$lambda$1(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare.Model model) {
        super(2);
        this.this$0 = widgetIncomingShare;
        this.$this_configureUi$inlined = model;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        invoke2(list, list2);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        C12238m.checkNotNullParameter(list, "<anonymous parameter 0>");
        C12238m.checkNotNullParameter(list2, "<anonymous parameter 1>");
        if (!C12238m.areEqual(this.this$0.queryString, this.$this_configureUi$inlined.getSearchModel().getFilter())) {
            this.this$0.getBinding().f17199h.scrollToPosition(0);
            this.this$0.queryString = this.$this_configureUi$inlined.getSearchModel().getFilter();
        }
    }
}
