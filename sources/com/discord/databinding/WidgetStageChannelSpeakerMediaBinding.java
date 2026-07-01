package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.calls.VideoCallParticipantView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageChannelSpeakerMediaBinding implements ViewBinding {

    @NonNull
    public final CardView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final VideoCallParticipantView f2655b;

    public WidgetStageChannelSpeakerMediaBinding(@NonNull CardView cardView, @NonNull VideoCallParticipantView videoCallParticipantView) {
        this.a = cardView;
        this.f2655b = videoCallParticipantView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
