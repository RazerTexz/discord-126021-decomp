package com.discord.widgets.stage.sheet;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter extends MGRecyclerAdapterSimple<WidgetStageRaisedHandsBottomSheetAdapter$ListItem> {
    public static final WidgetStageRaisedHandsBottomSheetAdapter$Companion Companion = new WidgetStageRaisedHandsBottomSheetAdapter$Companion(null);
    private static final int MILLIS_PER_DAY = 86400000;
    private static final int NEW_USER_DAYS_THRESOLD = 7;
    private static final int VIEW_TYPE_PARTICIPANT = 0;
    private Function1<? super StoreVoiceParticipants$VoiceUser, Unit> onDismissRequest;
    private Function1<? super StoreVoiceParticipants$VoiceUser, Unit> onInviteToSpeak;
    private Function1<? super StoreVoiceParticipants$VoiceUser, Unit> onViewProfile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onViewProfile = WidgetStageRaisedHandsBottomSheetAdapter$onViewProfile$1.INSTANCE;
        this.onInviteToSpeak = WidgetStageRaisedHandsBottomSheetAdapter$onInviteToSpeak$1.INSTANCE;
        this.onDismissRequest = WidgetStageRaisedHandsBottomSheetAdapter$onDismissRequest$1.INSTANCE;
    }

    public final Function1<StoreVoiceParticipants$VoiceUser, Unit> getOnDismissRequest() {
        return this.onDismissRequest;
    }

    public final Function1<StoreVoiceParticipants$VoiceUser, Unit> getOnInviteToSpeak() {
        return this.onInviteToSpeak;
    }

    public final Function1<StoreVoiceParticipants$VoiceUser, Unit> getOnViewProfile() {
        return this.onViewProfile;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnDismissRequest(Function1<? super StoreVoiceParticipants$VoiceUser, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onDismissRequest = function1;
    }

    public final void setOnInviteToSpeak(Function1<? super StoreVoiceParticipants$VoiceUser, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onInviteToSpeak = function1;
    }

    public final void setOnViewProfile(Function1<? super StoreVoiceParticipants$VoiceUser, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onViewProfile = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, WidgetStageRaisedHandsBottomSheetAdapter$ListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
