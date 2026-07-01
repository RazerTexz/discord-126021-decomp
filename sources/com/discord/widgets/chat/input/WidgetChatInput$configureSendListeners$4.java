package com.discord.widgets.chat.input;

import android.content.Context;
import androidx.annotation.StringRes;
import b.a.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatInput.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInput$configureSendListeners$4 extends o implements Function1<Integer, Boolean> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInput$configureSendListeners$4(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
        return Boolean.valueOf(invoke(num.intValue()));
    }

    public final boolean invoke(@StringRes int i) {
        m.g(this.$context, i, 0, null, 12);
        return false;
    }
}
