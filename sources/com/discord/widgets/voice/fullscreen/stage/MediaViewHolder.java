package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import androidx.cardview.widget.CardView;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageChannelSpeakerMediaBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaViewHolder extends StageCallViewHolder {
    private final WidgetStageChannelSpeakerMediaBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.stage.MediaViewHolder$onConfigure$2 */
    /* JADX INFO: compiled from: StageCallViewHolder.kt */
    public static final class C105572 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ StageCallItem.MediaItem $item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C105572(StageCallItem.MediaItem mediaItem) {
            super(1);
            this.$item = mediaItem;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            MediaViewHolder.access$getAdapter$p(MediaViewHolder.this).getOnMediaParticipantLongClicked().invoke(this.$item.getUserOrStreamParticipant());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaViewHolder(StageCallAdapter stageCallAdapter) {
        super(C5419R.layout.widget_stage_channel_speaker_media, stageCallAdapter, null);
        C12238m.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        VideoCallParticipantView videoCallParticipantView = (VideoCallParticipantView) view.findViewById(C5419R.id.stage_channel_media_speaker_container);
        if (videoCallParticipantView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.stage_channel_media_speaker_container)));
        }
        WidgetStageChannelSpeakerMediaBinding widgetStageChannelSpeakerMediaBinding = new WidgetStageChannelSpeakerMediaBinding((CardView) view, videoCallParticipantView);
        C12238m.checkNotNullExpressionValue(widgetStageChannelSpeakerMediaBinding, "WidgetStageChannelSpeake…diaBinding.bind(itemView)");
        this.binding = widgetStageChannelSpeakerMediaBinding;
    }

    public static final /* synthetic */ StageCallAdapter access$getAdapter$p(MediaViewHolder mediaViewHolder) {
        return (StageCallAdapter) mediaViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, StageCallItem data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        final StageCallItem.MediaItem mediaItem = (StageCallItem.MediaItem) data;
        VideoCallParticipantView videoCallParticipantView = this.binding.f18161b;
        C12238m.checkNotNullExpressionValue(videoCallParticipantView, "binding.stageChannelMediaSpeakerContainer");
        videoCallParticipantView.m8583c(mediaItem.getParticipantData(), null, false, new VideoCallGridAdapter.CallUiInsets(0, 0, 0, 0), true);
        videoCallParticipantView.setOnWatchStreamClicked(((StageCallAdapter) this.adapter).getOnWatchStreamClicked());
        videoCallParticipantView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.stage.MediaViewHolder.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MediaViewHolder.access$getAdapter$p(MediaViewHolder.this).getOnMediaParticipantTapped().invoke(mediaItem.getUserOrStreamParticipant());
            }
        });
        ViewExtensions.setOnLongClickListenerConsumeClick(videoCallParticipantView, new C105572(mediaItem));
        Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown = ((StageCallAdapter) this.adapter).getOnStreamQualityIndicatorShown();
        Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClick = ((StageCallAdapter) this.adapter).getOnStreamQualityIndicatorClick();
        C12238m.checkNotNullParameter(onStreamQualityIndicatorShown, "onShown");
        C12238m.checkNotNullParameter(onStreamQualityIndicatorClick, "onClicked");
        videoCallParticipantView.onStreamQualityIndicatorShown = onStreamQualityIndicatorShown;
        videoCallParticipantView.onStreamQualityIndicatorClicked = onStreamQualityIndicatorClick;
    }
}
