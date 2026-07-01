package com.discord.widgets.voice.fullscreen.grid;

import android.content.res.Resources;
import android.view.View;
import androidx.core.view.DisplayCutoutCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.views.calls.VideoCallParticipantView$StreamFps;
import com.discord.views.calls.VideoCallParticipantView$StreamResolution;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.fullscreen.CallParticipant$UserOrStreamParticipant;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VideoCallGridViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoCallGridViewHolder$UserOrStream extends VideoCallGridViewHolder {
    private final VideoCallParticipantView videoCallParticipantView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoCallGridViewHolder$UserOrStream(VideoCallParticipantView videoCallParticipantView) {
        super(videoCallParticipantView, null);
        m.checkNotNullParameter(videoCallParticipantView, "videoCallParticipantView");
        this.videoCallParticipantView = videoCallParticipantView;
    }

    public final void configure(CallParticipant$UserOrStreamParticipant callParticipant, Function1<? super CallParticipant, Unit> onTapped, Function1<? super CallParticipant, Unit> onLongClicked, Function1<? super String, Unit> onWatchStreamClicked, DisplayCutoutCompat displayCutout, int spanCount, Function2<? super VideoCallParticipantView$StreamResolution, ? super VideoCallParticipantView$StreamFps, Unit> onStreamQualityIndicatorShown, Function2<? super VideoCallParticipantView$StreamResolution, ? super VideoCallParticipantView$StreamFps, Unit> onStreamQualityIndicatorClicked, VideoCallGridAdapter$CallUiInsets callUiInsets, boolean controlsVisible) {
        m.checkNotNullParameter(callParticipant, "callParticipant");
        m.checkNotNullParameter(onTapped, "onTapped");
        m.checkNotNullParameter(onLongClicked, "onLongClicked");
        m.checkNotNullParameter(onWatchStreamClicked, "onWatchStreamClicked");
        m.checkNotNullParameter(onStreamQualityIndicatorShown, "onStreamQualityIndicatorShown");
        m.checkNotNullParameter(onStreamQualityIndicatorClicked, "onStreamQualityIndicatorClicked");
        m.checkNotNullParameter(callUiInsets, "callUiInsets");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        m.checkNotNullExpressionValue(resources, "itemView.resources");
        this.videoCallParticipantView.c(callParticipant.getParticipantData(), displayCutout, resources.getConfiguration().orientation != 2 ? getAdapterPosition() < spanCount : getAdapterPosition() % spanCount == 0, callUiInsets, controlsVisible);
        this.videoCallParticipantView.setOnWatchStreamClicked(onWatchStreamClicked);
        this.videoCallParticipantView.setOnClickListener(new VideoCallGridViewHolder$UserOrStream$configure$1(onTapped, callParticipant));
        ViewExtensions.setOnLongClickListenerConsumeClick(this.videoCallParticipantView, new VideoCallGridViewHolder$UserOrStream$configure$2(onLongClicked, callParticipant));
        VideoCallParticipantView videoCallParticipantView = this.videoCallParticipantView;
        Objects.requireNonNull(videoCallParticipantView);
        m.checkNotNullParameter(onStreamQualityIndicatorShown, "onShown");
        m.checkNotNullParameter(onStreamQualityIndicatorClicked, "onClicked");
        videoCallParticipantView.onStreamQualityIndicatorShown = onStreamQualityIndicatorShown;
        videoCallParticipantView.onStreamQualityIndicatorClicked = onStreamQualityIndicatorClicked;
    }
}
