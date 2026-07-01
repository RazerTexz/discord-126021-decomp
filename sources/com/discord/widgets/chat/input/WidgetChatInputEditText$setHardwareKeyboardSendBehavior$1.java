package com.discord.widgets.chat.input;

import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnKeyListener;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatInputEditText.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputEditText$setHardwareKeyboardSendBehavior$1 implements View$OnKeyListener {
    public final /* synthetic */ WidgetChatInputEditText this$0;

    public WidgetChatInputEditText$setHardwareKeyboardSendBehavior$1(WidgetChatInputEditText widgetChatInputEditText) {
        this.this$0 = widgetChatInputEditText;
    }

    @Override // android.view.View$OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        Function0<Unit> onSendListener;
        m.checkNotNullParameter(keyEvent, "event");
        boolean z2 = (keyEvent.getFlags() & 2) == 2;
        if ((i == 66) && !z2) {
            boolean zHasModifiers = keyEvent.hasModifiers(1);
            boolean isShiftEnterToSendEnabled = StoreStream.Companion.getUserSettings().getIsShiftEnterToSendEnabled();
            if ((isShiftEnterToSendEnabled && zHasModifiers) || (!isShiftEnterToSendEnabled && !zHasModifiers)) {
                if (this.this$0.getOnSendListener() != null && keyEvent.getAction() == 1 && (onSendListener = this.this$0.getOnSendListener()) != null) {
                    onSendListener.invoke();
                }
                return true;
            }
        }
        return false;
    }
}
