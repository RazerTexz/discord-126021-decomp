package com.discord.widgets.chat.list.actions;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType$Chat;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$onViewCreated$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetChatListActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActions$onViewCreated$2(WidgetChatListActions widgetChatListActions) {
        super(0);
        this.this$0 = widgetChatListActions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        EmojiPickerNavigator.launchBottomSheet(parentFragmentManager, new WidgetChatListActions$onViewCreated$2$1(this), EmojiPickerContextType$Chat.INSTANCE, new WidgetChatListActions$onViewCreated$2$2(this));
    }
}
