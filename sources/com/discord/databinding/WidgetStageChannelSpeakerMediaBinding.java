package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.calls.VideoCallParticipantView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageChannelSpeakerMediaBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CardView f18160a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final VideoCallParticipantView f18161b;

    public WidgetStageChannelSpeakerMediaBinding(@NonNull CardView cardView, @NonNull VideoCallParticipantView videoCallParticipantView) {
        this.f18160a = cardView;
        this.f18161b = videoCallParticipantView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18160a;
    }
}
