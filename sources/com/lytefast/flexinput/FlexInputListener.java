package com.lytefast.flexinput;

import com.lytefast.flexinput.model.Attachment;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FlexInputListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface FlexInputListener {
    void onSend(String data, List<? extends Attachment<?>> attachments, Function1<? super Boolean, Unit> onSendResult);
}
