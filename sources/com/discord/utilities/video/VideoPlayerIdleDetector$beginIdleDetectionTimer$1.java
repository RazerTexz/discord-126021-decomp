package com.discord.utilities.video;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VideoPlayerIdleDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoPlayerIdleDetector$beginIdleDetectionTimer$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ VideoPlayerIdleDetector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPlayerIdleDetector$beginIdleDetectionTimer$1(VideoPlayerIdleDetector videoPlayerIdleDetector) {
        super(1);
        this.this$0 = videoPlayerIdleDetector;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Long l) {
        VideoPlayerIdleDetector.access$setIdle(this.this$0, true);
    }
}
