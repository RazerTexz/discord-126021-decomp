package com.discord.widgets.voice.call;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.widgets.voice.model.CallModel;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallIncoming$Model$Companion$get$1$1<T, R> implements b<CallModel, WidgetVoiceCallIncoming$Model> {
    public final /* synthetic */ Set $incomingCalls;

    public WidgetVoiceCallIncoming$Model$Companion$get$1$1(Set set) {
        this.$incomingCalls = set;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetVoiceCallIncoming$Model call(CallModel callModel) {
        return call2(callModel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetVoiceCallIncoming$Model call2(CallModel callModel) {
        if (callModel == null) {
            return null;
        }
        WidgetVoiceCallIncoming$Model$Companion$get$1$1$1 widgetVoiceCallIncoming$Model$Companion$get$1$1$1 = new WidgetVoiceCallIncoming$Model$Companion$get$1$1$1(callModel);
        Collection<StoreVoiceParticipants$VoiceUser> collectionValues = callModel.getParticipants().values();
        ArrayList arrayList = new ArrayList();
        for (T t : collectionValues) {
            if (widgetVoiceCallIncoming$Model$Companion$get$1$1$1.invoke2((StoreVoiceParticipants$VoiceUser) t)) {
                arrayList.add(t);
            }
        }
        return new WidgetVoiceCallIncoming$Model(callModel, arrayList, this.$incomingCalls.size());
    }
}
