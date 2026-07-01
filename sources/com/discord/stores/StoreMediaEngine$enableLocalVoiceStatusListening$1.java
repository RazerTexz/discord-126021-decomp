package com.discord.stores;

import com.discord.rtcconnection.mediaengine.MediaEngine$LocalVoiceStatus;
import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMediaEngine$enableLocalVoiceStatusListening$1 extends k implements Function1<MediaEngine$LocalVoiceStatus, Unit> {
    public StoreMediaEngine$enableLocalVoiceStatusListening$1(SerializedSubject serializedSubject) {
        super(1, serializedSubject, SerializedSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MediaEngine$LocalVoiceStatus mediaEngine$LocalVoiceStatus) {
        invoke2(mediaEngine$LocalVoiceStatus);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MediaEngine$LocalVoiceStatus mediaEngine$LocalVoiceStatus) {
        ((SerializedSubject) this.receiver).k.onNext((T) mediaEngine$LocalVoiceStatus);
    }
}
