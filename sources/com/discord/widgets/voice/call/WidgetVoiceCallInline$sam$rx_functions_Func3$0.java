package com.discord.widgets.voice.call;

import kotlin.jvm.functions.Function3;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline$sam$rx_functions_Func3$0 implements Func3 {
    private final /* synthetic */ Function3 function;

    public WidgetVoiceCallInline$sam$rx_functions_Func3$0(Function3 function3) {
        this.function = function3;
    }

    @Override // rx.functions.Func3
    public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
        return this.function.invoke(obj, obj2, obj3);
    }
}
