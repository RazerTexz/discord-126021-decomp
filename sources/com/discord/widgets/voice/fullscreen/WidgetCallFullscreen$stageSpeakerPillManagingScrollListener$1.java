package com.discord.widgets.voice.fullscreen;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1 extends RecyclerView$OnScrollListener {
    private List<StoreVoiceParticipants$VoiceUser> activeSpeakers = n.emptyList();
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$stageSpeakerPillManagingScrollListener$1(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    public final List<StoreVoiceParticipants$VoiceUser> getActiveSpeakers() {
        return this.activeSpeakers;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        List<StoreVoiceParticipants$VoiceUser> list = this.activeSpeakers;
        boolean z2 = true;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
            } while (!(!WidgetCallFullscreen.access$isStageUserVisible(this.this$0, ((StoreVoiceParticipants$VoiceUser) it.next()).getUser().getId())));
        } else {
            z2 = false;
            break;
        }
        ConstraintLayout constraintLayout = WidgetCallFullscreen.access$getBinding$p(this.this$0).t;
        m.checkNotNullExpressionValue(constraintLayout, "binding.stageCallSpeakingChip");
        constraintLayout.setVisibility(z2 ? 0 : 8);
    }

    public final void setActiveSpeakers(List<StoreVoiceParticipants$VoiceUser> list) {
        m.checkNotNullParameter(list, "<set-?>");
        this.activeSpeakers = list;
    }
}
