package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.calls.StageCallSpeakerView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageChannelSpeakerBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final StageCallSpeakerView f2654b;

    public WidgetStageChannelSpeakerBinding(@NonNull ConstraintLayout constraintLayout, @NonNull StageCallSpeakerView stageCallSpeakerView) {
        this.a = constraintLayout;
        this.f2654b = stageCallSpeakerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
