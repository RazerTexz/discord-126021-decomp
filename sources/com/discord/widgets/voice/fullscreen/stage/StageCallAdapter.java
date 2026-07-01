package com.discord.widgets.voice.fullscreen.stage;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.calls.VideoCallParticipantView$StreamFps;
import com.discord.views.calls.VideoCallParticipantView$StreamResolution;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import com.discord.widgets.voice.fullscreen.CallParticipant$UserOrStreamParticipant;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: StageCallAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageCallAdapter extends MGRecyclerAdapterSimple<StageCallItem> {
    public static final int AUDIENCE_SPAN_COUNT = 3;
    public static final StageCallAdapter$Companion Companion = new StageCallAdapter$Companion(null);
    public static final int SPAN_COUNT = 12;
    public static final int SPEAKER_FULL_SPAN_COUNT = 12;
    public static final int SPEAKER_HALF_SPAN_COUNT = 6;
    public static final int SPEAKER_THIRD_SPAN_COUNT = 4;
    private final FragmentManager fragmentManager;
    private final RecyclerView$ItemDecoration itemDecoration;
    private int numSpeakers;
    private final Function1<CallParticipant$UserOrStreamParticipant, Unit> onMediaParticipantLongClicked;
    private final Function1<CallParticipant$UserOrStreamParticipant, Unit> onMediaParticipantTapped;
    private final Function2<VideoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps, Unit> onStreamQualityIndicatorClick;
    private final Function2<VideoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps, Unit> onStreamQualityIndicatorShown;
    private final Function1<String, Unit> onWatchStreamClicked;
    private final GridLayoutManager$SpanSizeLookup spanSizeLookup;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public StageCallAdapter(RecyclerView recyclerView, FragmentManager fragmentManager, Function1<? super CallParticipant$UserOrStreamParticipant, Unit> function1, Function1<? super CallParticipant$UserOrStreamParticipant, Unit> function2, Function1<? super String, Unit> function3, Function2<? super VideoCallParticipantView$StreamResolution, ? super VideoCallParticipantView$StreamFps, Unit> function4, Function2<? super VideoCallParticipantView$StreamResolution, ? super VideoCallParticipantView$StreamFps, Unit> function5) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(function1, "onMediaParticipantTapped");
        m.checkNotNullParameter(function2, "onMediaParticipantLongClicked");
        m.checkNotNullParameter(function3, "onWatchStreamClicked");
        m.checkNotNullParameter(function4, "onStreamQualityIndicatorShown");
        m.checkNotNullParameter(function5, "onStreamQualityIndicatorClick");
        this.fragmentManager = fragmentManager;
        this.onMediaParticipantTapped = function1;
        this.onMediaParticipantLongClicked = function2;
        this.onWatchStreamClicked = function3;
        this.onStreamQualityIndicatorShown = function4;
        this.onStreamQualityIndicatorClick = function5;
        this.spanSizeLookup = new StageCallAdapter$spanSizeLookup$1(this);
        this.itemDecoration = new StageCallAdapter$itemDecoration$1(this);
    }

    public static final /* synthetic */ List access$getInternalData$p(StageCallAdapter stageCallAdapter) {
        return stageCallAdapter.getInternalData();
    }

    public static final /* synthetic */ int access$getNumSpeakers$p(StageCallAdapter stageCallAdapter) {
        return stageCallAdapter.numSpeakers;
    }

    public static final /* synthetic */ void access$setNumSpeakers$p(StageCallAdapter stageCallAdapter, int i) {
        stageCallAdapter.numSpeakers = i;
    }

    private final void openWidgetUserSheet(long userId, Channel channel) {
        WidgetUserSheet$Companion.show$default(WidgetUserSheet.Companion, userId, Long.valueOf(channel.getId()), this.fragmentManager, Long.valueOf(channel.getGuildId()), Boolean.TRUE, null, null, 96, null);
    }

    public final RecyclerView$ItemDecoration getItemDecoration() {
        return this.itemDecoration;
    }

    public final Function1<CallParticipant$UserOrStreamParticipant, Unit> getOnMediaParticipantLongClicked() {
        return this.onMediaParticipantLongClicked;
    }

    public final Function1<CallParticipant$UserOrStreamParticipant, Unit> getOnMediaParticipantTapped() {
        return this.onMediaParticipantTapped;
    }

    public final Function2<VideoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps, Unit> getOnStreamQualityIndicatorClick() {
        return this.onStreamQualityIndicatorClick;
    }

    public final Function2<VideoCallParticipantView$StreamResolution, VideoCallParticipantView$StreamFps, Unit> getOnStreamQualityIndicatorShown() {
        return this.onStreamQualityIndicatorShown;
    }

    public final Function1<String, Unit> getOnWatchStreamClicked() {
        return this.onWatchStreamClicked;
    }

    public final GridLayoutManager$SpanSizeLookup getSpanSizeLookup() {
        return this.spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onItemClick$app_productionGoogleRelease(StageCallItem item) {
        m.checkNotNullParameter(item, "item");
        if (item instanceof StageCallParticipantItem) {
            StageCallParticipantItem stageCallParticipantItem = (StageCallParticipantItem) item;
            openWidgetUserSheet(stageCallParticipantItem.getVoiceUser().getUser().getId(), stageCallParticipantItem.getChannel());
        }
    }

    public final void setData(List<? extends StageCallItem> data, int numSpeakers) {
        m.checkNotNullParameter(data, "data");
        this.numSpeakers = numSpeakers;
        super.setData(data);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<StageCallAdapter, StageCallItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new DetailsViewHolder(this);
            case 1:
                return new SpeakerViewHolder(this);
            case 2:
                return new AudienceHeaderViewHolder(this);
            case 3:
                return new AudienceViewHolder(this);
            case 4:
                return new DividerViewHolder(this);
            case 5:
                return new PrestartDetailsViewHolder(this);
            case 6:
                return new MediaViewHolder(this);
            default:
                throw new IllegalStateException(a.q("Invalid view type: ", viewType));
        }
    }
}
