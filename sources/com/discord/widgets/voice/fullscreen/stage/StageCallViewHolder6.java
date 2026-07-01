package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import androidx.cardview.widget.CardView;
import com.discord.R;
import com.discord.databinding.WidgetStageChannelSpeakerMediaBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.stage.MediaViewHolder, reason: use source file name */
/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageCallViewHolder6 extends StageCallViewHolder {
    private final WidgetStageChannelSpeakerMediaBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.stage.MediaViewHolder$onConfigure$2, reason: invalid class name */
    /* JADX INFO: compiled from: StageCallViewHolder.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ StageCallItem.MediaItem $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StageCallItem.MediaItem mediaItem) {
            super(1);
            this.$item = mediaItem;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            StageCallViewHolder6.access$getAdapter$p(StageCallViewHolder6.this).getOnMediaParticipantLongClicked().invoke(this.$item.getUserOrStreamParticipant());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallViewHolder6(StageCallAdapter stageCallAdapter) {
        super(R.layout.widget_stage_channel_speaker_media, stageCallAdapter, null);
        Intrinsics3.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        VideoCallParticipantView videoCallParticipantView = (VideoCallParticipantView) view.findViewById(R.id.stage_channel_media_speaker_container);
        if (videoCallParticipantView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.stage_channel_media_speaker_container)));
        }
        WidgetStageChannelSpeakerMediaBinding widgetStageChannelSpeakerMediaBinding = new WidgetStageChannelSpeakerMediaBinding((CardView) view, videoCallParticipantView);
        Intrinsics3.checkNotNullExpressionValue(widgetStageChannelSpeakerMediaBinding, "WidgetStageChannelSpeake…diaBinding.bind(itemView)");
        this.binding = widgetStageChannelSpeakerMediaBinding;
    }

    public static final /* synthetic */ StageCallAdapter access$getAdapter$p(StageCallViewHolder6 stageCallViewHolder6) {
        return (StageCallAdapter) stageCallViewHolder6.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, StageCallItem data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        final StageCallItem.MediaItem mediaItem = (StageCallItem.MediaItem) data;
        VideoCallParticipantView videoCallParticipantView = this.binding.f2655b;
        Intrinsics3.checkNotNullExpressionValue(videoCallParticipantView, "binding.stageChannelMediaSpeakerContainer");
        videoCallParticipantView.c(mediaItem.getParticipantData(), null, false, new VideoCallGridAdapter.CallUiInsets(0, 0, 0, 0), true);
        videoCallParticipantView.setOnWatchStreamClicked(((StageCallAdapter) this.adapter).getOnWatchStreamClicked());
        videoCallParticipantView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.stage.MediaViewHolder.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StageCallViewHolder6.access$getAdapter$p(StageCallViewHolder6.this).getOnMediaParticipantTapped().invoke(mediaItem.getUserOrStreamParticipant());
            }
        });
        ViewExtensions.setOnLongClickListenerConsumeClick(videoCallParticipantView, new AnonymousClass2(mediaItem));
        Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown = ((StageCallAdapter) this.adapter).getOnStreamQualityIndicatorShown();
        Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClick = ((StageCallAdapter) this.adapter).getOnStreamQualityIndicatorClick();
        Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorShown, "onShown");
        Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorClick, "onClicked");
        videoCallParticipantView.onStreamQualityIndicatorShown = onStreamQualityIndicatorShown;
        videoCallParticipantView.onStreamQualityIndicatorClicked = onStreamQualityIndicatorClick;
    }
}
