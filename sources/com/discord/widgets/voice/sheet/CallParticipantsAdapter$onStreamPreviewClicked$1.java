package com.discord.widgets.voice.sheet;

import com.discord.utilities.streams.StreamContext;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$onStreamPreviewClicked$1 extends Lambda implements Function1<StreamContext, Unit> {
    public static final CallParticipantsAdapter$onStreamPreviewClicked$1 INSTANCE = new CallParticipantsAdapter$onStreamPreviewClicked$1();

    public CallParticipantsAdapter$onStreamPreviewClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
        invoke2(streamContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StreamContext streamContext) {
        Intrinsics3.checkNotNullParameter(streamContext, "it");
    }
}
