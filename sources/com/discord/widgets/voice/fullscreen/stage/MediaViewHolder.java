package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import androidx.cardview.widget.CardView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetStageChannelSpeakerMediaBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.views.calls.VideoCallParticipantView$StreamFps;
import com.discord.views.calls.VideoCallParticipantView$StreamResolution;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter$CallUiInsets;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaViewHolder extends StageCallViewHolder {
    private final WidgetStageChannelSpeakerMediaBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaViewHolder(StageCallAdapter stageCallAdapter) {
        super(R$layout.widget_stage_channel_speaker_media, stageCallAdapter, null);
        m.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        VideoCallParticipantView videoCallParticipantView = (VideoCallParticipantView) view.findViewById(R$id.stage_channel_media_speaker_container);
        if (videoCallParticipantView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.stage_channel_media_speaker_container)));
        }
        WidgetStageChannelSpeakerMediaBinding widgetStageChannelSpeakerMediaBinding = new WidgetStageChannelSpeakerMediaBinding((CardView) view, videoCallParticipantView);
        m.checkNotNullExpressionValue(widgetStageChannelSpeakerMediaBinding, "WidgetStageChannelSpeake…diaBinding.bind(itemView)");
        this.binding = widgetStageChannelSpeakerMediaBinding;
    }

    public static final /* synthetic */ StageCallAdapter access$getAdapter$p(MediaViewHolder mediaViewHolder) {
        return (StageCallAdapter) mediaViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) {
        onConfigure2(i, stageCallItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem$MediaItem stageCallItem$MediaItem = (StageCallItem$MediaItem) data;
        VideoCallParticipantView videoCallParticipantView = this.binding.f2655b;
        m.checkNotNullExpressionValue(videoCallParticipantView, "binding.stageChannelMediaSpeakerContainer");
        videoCallParticipantView.c(stageCallItem$MediaItem.getParticipantData(), null, false, new VideoCallGridAdapter$CallUiInsets(0, 0, 0, 0), true);
        videoCallParticipantView.setOnWatchStreamClicked(((StageCallAdapter) this.adapter).getOnWatchStreamClicked());
        videoCallParticipantView.setOnClickListener(new MediaViewHolder$onConfigure$1(this, stageCallItem$MediaItem));
        ViewExtensions.setOnLongClickListenerConsumeClick(videoCallParticipantView, new MediaViewHolder$onConfigure$2(this, stageCallItem$MediaItem));
        Function2<VideoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps, Unit> onStreamQualityIndicatorShown = ((StageCallAdapter) this.adapter).getOnStreamQualityIndicatorShown();
        Function2<VideoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps, Unit> onStreamQualityIndicatorClick = ((StageCallAdapter) this.adapter).getOnStreamQualityIndicatorClick();
        m.checkNotNullParameter(onStreamQualityIndicatorShown, "onShown");
        m.checkNotNullParameter(onStreamQualityIndicatorClick, "onClicked");
        videoCallParticipantView.onStreamQualityIndicatorShown = onStreamQualityIndicatorShown;
        videoCallParticipantView.onStreamQualityIndicatorClicked = onStreamQualityIndicatorClick;
    }
}
