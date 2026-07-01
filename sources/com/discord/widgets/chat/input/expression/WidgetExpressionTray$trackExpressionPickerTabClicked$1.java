package com.discord.widgets.chat.input.expression;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.icon.IconUtils;
import d0.z.d.o;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionTray$trackExpressionPickerTabClicked$1 extends o implements Function1<ExpressionTrayViewModel$ViewState, Unit> {
    public final /* synthetic */ ExpressionTrayTab $clickedTab;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionTray$trackExpressionPickerTabClicked$1(ExpressionTrayTab expressionTrayTab) {
        super(1);
        this.$clickedTab = expressionTrayTab;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ExpressionTrayViewModel$ViewState expressionTrayViewModel$ViewState) {
        invoke2(expressionTrayViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ExpressionTrayViewModel$ViewState expressionTrayViewModel$ViewState) {
        String str;
        int iOrdinal = this.$clickedTab.ordinal();
        if (iOrdinal == 0) {
            str = "emoji";
        } else if (iOrdinal == 1) {
            str = IconUtils.ANIMATED_IMAGE_EXTENSION;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = "sticker";
        }
        AnalyticsTracker.INSTANCE.expressionPickerTabClicked(str, false);
    }
}
