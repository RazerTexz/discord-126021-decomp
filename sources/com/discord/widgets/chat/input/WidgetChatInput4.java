package com.discord.widgets.chat.input;

import androidx.fragment.app.Fragment;
import com.discord.R;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInput$flexInputFragment$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput4 extends Lambda implements Function0<FlexInputFragment> {
    public final /* synthetic */ WidgetChatInput this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput4(WidgetChatInput widgetChatInput) {
        super(0);
        this.this$0 = widgetChatInput;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FlexInputFragment invoke() {
        Fragment fragmentFindFragmentById = this.this$0.getChildFragmentManager().findFragmentById(R.id.chat_input_widget);
        Objects.requireNonNull(fragmentFindFragmentById, "null cannot be cast to non-null type com.lytefast.flexinput.fragment.FlexInputFragment");
        return (FlexInputFragment) fragmentFindFragmentById;
    }
}
