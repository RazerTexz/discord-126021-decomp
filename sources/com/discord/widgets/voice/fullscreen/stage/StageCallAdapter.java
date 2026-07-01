package com.discord.widgets.voice.fullscreen.stage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StageCallAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageCallAdapter extends MGRecyclerAdapterSimple<StageCallItem> {
    public static final int AUDIENCE_SPAN_COUNT = 3;
    public static final int SPAN_COUNT = 12;
    public static final int SPEAKER_FULL_SPAN_COUNT = 12;
    public static final int SPEAKER_HALF_SPAN_COUNT = 6;
    public static final int SPEAKER_THIRD_SPAN_COUNT = 4;
    private final FragmentManager fragmentManager;
    private final RecyclerView.ItemDecoration itemDecoration;
    private int numSpeakers;
    private final Function1<CallParticipant.UserOrStreamParticipant, Unit> onMediaParticipantLongClicked;
    private final Function1<CallParticipant.UserOrStreamParticipant, Unit> onMediaParticipantTapped;
    private final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClick;
    private final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown;
    private final Function1<String, Unit> onWatchStreamClicked;
    private final GridLayoutManager.SpanSizeLookup spanSizeLookup;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StageCallAdapter(RecyclerView recyclerView, FragmentManager fragmentManager, Function1<? super CallParticipant.UserOrStreamParticipant, Unit> function1, Function1<? super CallParticipant.UserOrStreamParticipant, Unit> function2, Function1<? super String, Unit> function3, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> function4, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> function5) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(function1, "onMediaParticipantTapped");
        Intrinsics3.checkNotNullParameter(function2, "onMediaParticipantLongClicked");
        Intrinsics3.checkNotNullParameter(function3, "onWatchStreamClicked");
        Intrinsics3.checkNotNullParameter(function4, "onStreamQualityIndicatorShown");
        Intrinsics3.checkNotNullParameter(function5, "onStreamQualityIndicatorClick");
        this.fragmentManager = fragmentManager;
        this.onMediaParticipantTapped = function1;
        this.onMediaParticipantLongClicked = function2;
        this.onWatchStreamClicked = function3;
        this.onStreamQualityIndicatorShown = function4;
        this.onStreamQualityIndicatorClick = function5;
        this.spanSizeLookup = new GridLayoutManager.SpanSizeLookup() { // from class: com.discord.widgets.voice.fullscreen.stage.StageCallAdapter$spanSizeLookup$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                int type = ((StageCallItem) this.this$0.getInternalData().get(position)).getType();
                if (type == 1) {
                    int i = this.this$0.numSpeakers;
                    if (i != 1) {
                        return i != 2 ? 4 : 6;
                    }
                } else if (type == 3) {
                    return 3;
                }
                return 12;
            }
        };
        this.itemDecoration = new RecyclerView.ItemDecoration() { // from class: com.discord.widgets.voice.fullscreen.stage.StageCallAdapter$itemDecoration$1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                Intrinsics3.checkNotNullParameter(outRect, "outRect");
                Intrinsics3.checkNotNullParameter(view, "view");
                Intrinsics3.checkNotNullParameter(parent, "parent");
                Intrinsics3.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition != -1 && ((StageCallItem) this.this$0.getInternalData().get(childAdapterPosition)).getType() == 1) {
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
                    int spanIndex = ((GridLayoutManager.LayoutParams) layoutParams).getSpanIndex();
                    if (this.this$0.numSpeakers == 2 && spanIndex == 0) {
                        outRect.right = DimenUtils.dpToPixels(4);
                        return;
                    }
                    if (spanIndex == 6) {
                        outRect.left = DimenUtils.dpToPixels(4);
                        return;
                    }
                    if (this.this$0.numSpeakers > 2 && spanIndex == 0) {
                        outRect.right = DimenUtils.dpToPixels(5.33f);
                    } else if (spanIndex == 8) {
                        outRect.left = DimenUtils.dpToPixels(5.33f);
                    } else if (spanIndex == 4) {
                        outRect.set(DimenUtils.dpToPixels(2.67f), 0, DimenUtils.dpToPixels(2.67f), 0);
                    }
                }
            }
        };
    }

    private final void openWidgetUserSheet(long userId, Channel channel) {
        WidgetUserSheet.Companion.show$default(WidgetUserSheet.INSTANCE, userId, Long.valueOf(channel.getId()), this.fragmentManager, Long.valueOf(channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
    }

    public final RecyclerView.ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    public final Function1<CallParticipant.UserOrStreamParticipant, Unit> getOnMediaParticipantLongClicked() {
        return this.onMediaParticipantLongClicked;
    }

    public final Function1<CallParticipant.UserOrStreamParticipant, Unit> getOnMediaParticipantTapped() {
        return this.onMediaParticipantTapped;
    }

    public final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> getOnStreamQualityIndicatorClick() {
        return this.onStreamQualityIndicatorClick;
    }

    public final Function2<VideoCallParticipantView.StreamResolution, VideoCallParticipantView.StreamFps, Unit> getOnStreamQualityIndicatorShown() {
        return this.onStreamQualityIndicatorShown;
    }

    public final Function1<String, Unit> getOnWatchStreamClicked() {
        return this.onWatchStreamClicked;
    }

    public final GridLayoutManager.SpanSizeLookup getSpanSizeLookup() {
        return this.spanSizeLookup;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onItemClick$app_productionGoogleRelease(StageCallItem item) {
        Intrinsics3.checkNotNullParameter(item, "item");
        if (item instanceof StageCallItem2) {
            StageCallItem2 stageCallItem2 = (StageCallItem2) item;
            openWidgetUserSheet(stageCallItem2.getVoiceUser().getUser().getId(), stageCallItem2.getChannel());
        }
    }

    public final void setData(List<? extends StageCallItem> data, int numSpeakers) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.numSpeakers = numSpeakers;
        super.setData(data);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<StageCallAdapter, StageCallItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new StageCallViewHolder4(this);
            case 1:
                return new StageCallViewHolder8(this);
            case 2:
                return new StageCallViewHolder2(this);
            case 3:
                return new StageCallViewHolder3(this);
            case 4:
                return new StageCallViewHolder5(this);
            case 5:
                return new StageCallViewHolder7(this);
            case 6:
                return new StageCallViewHolder6(this);
            default:
                throw new IllegalStateException(outline.q("Invalid view type: ", viewType));
        }
    }
}
