package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.calls.StageCallSpeakerView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetStageChannelSpeakerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f18158a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final StageCallSpeakerView f18159b;

    public WidgetStageChannelSpeakerBinding(@NonNull ConstraintLayout constraintLayout, @NonNull StageCallSpeakerView stageCallSpeakerView) {
        this.f18158a = constraintLayout;
        this.f18159b = stageCallSpeakerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18158a;
    }
}
