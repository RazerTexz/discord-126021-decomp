package com.discord.widgets.chat.input;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatInputApplicationCommandsBinding;
import com.discord.widgets.chat.input.autocomplete.InputAutocomplete;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$onViewBound$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$onViewBound$1(WidgetChatInput widgetChatInput) {
        super(0);
        this.this$0 = widgetChatInput;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FlexEditText flexEditTextL = WidgetChatInput.access$getFlexInputFragment$p(this.this$0).l();
        WidgetChatInput widgetChatInput = this.this$0;
        FlexInputFragment flexInputFragmentAccess$getFlexInputFragment$p = WidgetChatInput.access$getFlexInputFragment$p(widgetChatInput);
        AppFlexInputViewModel appFlexInputViewModelAccess$getFlexInputViewModel$p = WidgetChatInput.access$getFlexInputViewModel$p(this.this$0);
        TextView textView = WidgetChatInput.access$getBinding$p(this.this$0).k;
        m.checkNotNullExpressionValue(textView, "binding.chatInputEmojiMatchingHeader");
        RecyclerView recyclerView = WidgetChatInput.access$getBinding$p(this.this$0).l;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatInputMentionsRecycler");
        RecyclerView recyclerView2 = WidgetChatInput.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(recyclerView2, "binding.chatInputCategoriesRecycler");
        LinearLayout linearLayout = WidgetChatInput.access$getBinding$p(this.this$0).m;
        m.checkNotNullExpressionValue(linearLayout, "binding.chatInputStickersContainer");
        RecyclerView recyclerView3 = WidgetChatInput.access$getBinding$p(this.this$0).o;
        m.checkNotNullExpressionValue(recyclerView3, "binding.chatInputStickersRecycler");
        TextView textView2 = WidgetChatInput.access$getBinding$p(this.this$0).n;
        m.checkNotNullExpressionValue(textView2, "binding.chatInputStickersMatchingHeader");
        WidgetChatInputApplicationCommandsBinding widgetChatInputApplicationCommandsBinding = WidgetChatInput.access$getBinding$p(this.this$0).f2303b;
        m.checkNotNullExpressionValue(widgetChatInputApplicationCommandsBinding, "binding.applicationCommandsRoot");
        InputAutocomplete inputAutocomplete = new InputAutocomplete(widgetChatInput, flexInputFragmentAccess$getFlexInputFragment$p, appFlexInputViewModelAccess$getFlexInputViewModel$p, flexEditTextL, null, textView, recyclerView, recyclerView2, linearLayout, recyclerView3, textView2, widgetChatInputApplicationCommandsBinding);
        WidgetChatInput.access$setAutocomplete$p(this.this$0, inputAutocomplete);
        inputAutocomplete.onViewBoundOrOnResume();
        WidgetChatInput.access$setChatInputEditTextHolder$p(this.this$0, new WidgetChatInputEditText(flexEditTextL, null, 2, null));
        WidgetChatInput.access$setChatInputTruncatedHint$p(this.this$0, new WidgetChatInputTruncatedHint(flexEditTextL));
        WidgetChatInputTruncatedHint widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p = WidgetChatInput.access$getChatInputTruncatedHint$p(this.this$0);
        if (widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p != null) {
            widgetChatInputTruncatedHintAccess$getChatInputTruncatedHint$p.addBindedTextWatcher(this.this$0);
        }
    }
}
