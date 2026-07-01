package com.discord.widgets.voice.fullscreen;

import androidx.recyclerview.widget.RecyclerView$State;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridLayoutManager;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$setUpGridRecycler$layoutManager$2 extends o implements Function2<VideoCallGridLayoutManager, RecyclerView$State, Unit> {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$setUpGridRecycler$layoutManager$2(WidgetCallFullscreen widgetCallFullscreen) {
        super(2);
        this.this$0 = widgetCallFullscreen;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(VideoCallGridLayoutManager videoCallGridLayoutManager, RecyclerView$State recyclerView$State) {
        invoke2(videoCallGridLayoutManager, recyclerView$State);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VideoCallGridLayoutManager videoCallGridLayoutManager, RecyclerView$State recyclerView$State) {
        m.checkNotNullParameter(videoCallGridLayoutManager, "layoutManager");
        if (WidgetCallFullscreen.access$getHasVideoCallGridChildrenChanged$p(this.this$0)) {
            WidgetCallFullscreen.access$setHasVideoCallGridChildrenChanged$p(this.this$0, false);
            WidgetCallFullscreen.access$getViewModel$p(this.this$0).updateOffScreenParticipantsFromScroll(WidgetCallFullscreen.access$getVisibleParticipants(this.this$0, videoCallGridLayoutManager));
        }
    }
}
