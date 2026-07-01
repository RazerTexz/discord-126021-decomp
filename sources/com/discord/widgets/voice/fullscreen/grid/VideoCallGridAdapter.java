package com.discord.widgets.voice.fullscreen.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.DisplayCutoutCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil$Callback;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.a.i.w1;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.VideoCallGridItemEmbeddedActivityBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.PileView;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.views.calls.VideoCallParticipantView$ParticipantData;
import com.discord.views.calls.VideoCallParticipantView$StreamFps;
import com.discord.views.calls.VideoCallParticipantView$StreamResolution;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.fullscreen.CallParticipant$EmbeddedActivityParticipant;
import com.discord.widgets.voice.fullscreen.CallParticipant$UserOrStreamParticipant;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VideoCallGridAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoCallGridAdapter extends RecyclerView$Adapter<VideoCallGridViewHolder> {
    public static final VideoCallGridAdapter$Companion Companion = new VideoCallGridAdapter$Companion(null);
    private static final int EMBEDDED_ACTIVITY_VIEW_TYPE = 1;
    private static final int USER_OR_STREAM_VIEW_TYPE = 0;
    private VideoCallGridAdapter$CallUiInsets callUiInsets;
    private boolean controlsVisible;
    private List<? extends CallParticipant> data;
    private DisplayCutoutCompat displayCutout;
    private int embeddedActivityParticipantsCount;
    private final Function1<CallParticipant, Unit> onParticipantLongClicked;
    private final Function1<CallParticipant, Unit> onParticipantTapped;
    private final Function2<VideoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps, Unit> onStreamQualityIndicatorClick;
    private final Function2<VideoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps, Unit> onStreamQualityIndicatorShown;
    private final Function1<String, Unit> onWatchStreamClicked;
    private final int spanCount;
    private final GridLayoutManager$SpanSizeLookup spanSizeLookup;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoCallGridAdapter(Function1<? super CallParticipant, Unit> function1, Function1<? super CallParticipant, Unit> function2, Function1<? super String, Unit> function3, Function2<? super VideoCallParticipantView$StreamResolution, ? super VideoCallParticipantView$StreamFps, Unit> function4, Function2<? super VideoCallParticipantView$StreamResolution, ? super VideoCallParticipantView$StreamFps, Unit> function5, int i) {
        m.checkNotNullParameter(function1, "onParticipantTapped");
        m.checkNotNullParameter(function2, "onParticipantLongClicked");
        m.checkNotNullParameter(function3, "onWatchStreamClicked");
        m.checkNotNullParameter(function4, "onStreamQualityIndicatorShown");
        m.checkNotNullParameter(function5, "onStreamQualityIndicatorClick");
        this.onParticipantTapped = function1;
        this.onParticipantLongClicked = function2;
        this.onWatchStreamClicked = function3;
        this.onStreamQualityIndicatorShown = function4;
        this.onStreamQualityIndicatorClick = function5;
        this.spanCount = i;
        this.data = n.emptyList();
        this.callUiInsets = new VideoCallGridAdapter$CallUiInsets(0, 0, 0, 0);
        this.spanSizeLookup = new VideoCallGridAdapter$spanSizeLookup$1(this);
    }

    public static final /* synthetic */ List access$getData$p(VideoCallGridAdapter videoCallGridAdapter) {
        return videoCallGridAdapter.data;
    }

    public static final /* synthetic */ void access$setData$p(VideoCallGridAdapter videoCallGridAdapter, List list) {
        videoCallGridAdapter.data = list;
    }

    private final DiffUtil$Callback getDiffUtilCallback(List<? extends CallParticipant> oldData, List<? extends CallParticipant> newData) {
        return new VideoCallGridAdapter$getDiffUtilCallback$1(oldData, newData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public long getItemId(int position) {
        CallParticipant callParticipant = this.data.get(position);
        if (!(callParticipant instanceof CallParticipant$UserOrStreamParticipant)) {
            if (callParticipant instanceof CallParticipant$EmbeddedActivityParticipant) {
                return ((CallParticipant$EmbeddedActivityParticipant) callParticipant).getApplication().getId();
            }
            throw new NoWhenBranchMatchedException();
        }
        VideoCallParticipantView$ParticipantData participantData = ((CallParticipant$UserOrStreamParticipant) callParticipant).getParticipantData();
        int iOrdinal = participantData.type.ordinal();
        if (iOrdinal == 0) {
            return participantData.voiceParticipant.getUser().getId();
        }
        if (iOrdinal == 1) {
            return participantData.voiceParticipant.getUser().getId() + 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        CallParticipant callParticipant = this.data.get(position);
        if (callParticipant instanceof CallParticipant$UserOrStreamParticipant) {
            return 0;
        }
        if (callParticipant instanceof CallParticipant$EmbeddedActivityParticipant) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final GridLayoutManager$SpanSizeLookup getSpanSizeLookup() {
        return this.spanSizeLookup;
    }

    public final void notifyCallControlsVisibilityChanged(boolean controlsVisible) {
        this.controlsVisible = controlsVisible;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((VideoCallGridViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<? extends CallParticipant> data) {
        m.checkNotNullParameter(data, "data");
        DiffUtil$DiffResult diffUtil$DiffResultCalculateDiff = DiffUtil.calculateDiff(getDiffUtilCallback(this.data, data), true);
        m.checkNotNullExpressionValue(diffUtil$DiffResultCalculateDiff, "DiffUtil.calculateDiff(g…a, newData = data), true)");
        this.data = data;
        diffUtil$DiffResultCalculateDiff.dispatchUpdatesTo(this);
        int i = 0;
        if (!(data instanceof Collection) || !data.isEmpty()) {
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                if ((((CallParticipant) it.next()) instanceof CallParticipant$EmbeddedActivityParticipant) && (i = i + 1) < 0) {
                    n.throwCountOverflow();
                }
            }
        }
        this.embeddedActivityParticipantsCount = i;
    }

    public final void setDisplayCutout(DisplayCutoutCompat displayCutout, boolean isLandscape) {
        this.displayCutout = displayCutout;
        if (isLandscape) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeChanged(0, this.spanCount);
        }
    }

    public final void setInsetsForAvoidingCallUiOverlap(int top, int bottom, int left, int right) {
        this.callUiInsets = new VideoCallGridAdapter$CallUiInsets(top, bottom, left, right);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(VideoCallGridViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        if (!(holder instanceof VideoCallGridViewHolder$UserOrStream)) {
            if (holder instanceof VideoCallGridViewHolder$EmbeddedActivity) {
                CallParticipant callParticipant = this.data.get(position);
                Objects.requireNonNull(callParticipant, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.EmbeddedActivityParticipant");
                ((VideoCallGridViewHolder$EmbeddedActivity) holder).configure((CallParticipant$EmbeddedActivityParticipant) callParticipant, this.onParticipantTapped);
                return;
            }
            return;
        }
        VideoCallGridViewHolder$UserOrStream videoCallGridViewHolder$UserOrStream = (VideoCallGridViewHolder$UserOrStream) holder;
        CallParticipant callParticipant2 = this.data.get(position);
        Objects.requireNonNull(callParticipant2, "null cannot be cast to non-null type com.discord.widgets.voice.fullscreen.CallParticipant.UserOrStreamParticipant");
        videoCallGridViewHolder$UserOrStream.configure((CallParticipant$UserOrStreamParticipant) callParticipant2, this.onParticipantTapped, this.onParticipantLongClicked, this.onWatchStreamClicked, this.displayCutout, this.spanCount, this.onStreamQualityIndicatorShown, this.onStreamQualityIndicatorClick, this.callUiInsets, this.controlsVisible);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public VideoCallGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        if (viewType == 0) {
            View viewInflate = layoutInflaterFrom.inflate(R$layout.video_call_grid_item, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            VideoCallParticipantView videoCallParticipantView = (VideoCallParticipantView) viewInflate;
            m.checkNotNullExpressionValue(new w1(videoCallParticipantView), "VideoCallGridItemBinding…rent, false\n            )");
            m.checkNotNullExpressionValue(videoCallParticipantView, "VideoCallGridItemBinding… false\n            ).root");
            return new VideoCallGridViewHolder$UserOrStream(videoCallParticipantView);
        }
        if (viewType != 1) {
            throw new IllegalStateException(a.q("invalid view type: ", viewType));
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R$layout.video_call_grid_item_embedded_activity, parent, false);
        int i = R$id.activity_participant_avatars;
        PileView pileView = (PileView) viewInflate2.findViewById(R$id.activity_participant_avatars);
        if (pileView != null) {
            i = R$id.activity_preview_subtitle;
            TextView textView = (TextView) viewInflate2.findViewById(R$id.activity_preview_subtitle);
            if (textView != null) {
                i = R$id.activity_preview_title;
                TextView textView2 = (TextView) viewInflate2.findViewById(R$id.activity_preview_title);
                if (textView2 != null) {
                    i = R$id.app_background_image;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate2.findViewById(R$id.app_background_image);
                    if (simpleDraweeView != null) {
                        i = R$id.app_background_overlay;
                        View viewFindViewById = viewInflate2.findViewById(R$id.app_background_overlay);
                        if (viewFindViewById != null) {
                            VideoCallGridItemEmbeddedActivityBinding videoCallGridItemEmbeddedActivityBinding = new VideoCallGridItemEmbeddedActivityBinding((FrameLayout) viewInflate2, pileView, textView, textView2, simpleDraweeView, viewFindViewById);
                            m.checkNotNullExpressionValue(videoCallGridItemEmbeddedActivityBinding, "VideoCallGridItemEmbedde…tInflater, parent, false)");
                            return new VideoCallGridViewHolder$EmbeddedActivity(videoCallGridItemEmbeddedActivityBinding);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
    }
}
