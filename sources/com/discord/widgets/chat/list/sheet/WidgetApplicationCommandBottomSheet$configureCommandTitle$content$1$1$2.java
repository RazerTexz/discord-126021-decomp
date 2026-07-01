package com.discord.widgets.chat.list.sheet;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.models.user.User;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1$2(WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1 widgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1) {
        super(1);
        this.this$0 = widgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        User user = this.this$0.this$0.$viewState.getUser();
        if (user != null) {
            WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
            long id2 = user.getId();
            Long channelId = this.this$0.this$0.$viewState.getChannelId();
            FragmentManager childFragmentManager = this.this$0.this$0.this$0.getChildFragmentManager();
            m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, id2, channelId, childFragmentManager, this.this$0.this$0.$viewState.getGuildId(), null, null, null, 112, null);
        }
    }
}
