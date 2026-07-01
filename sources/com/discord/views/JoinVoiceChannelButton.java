package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.StringRes;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: JoinVoiceChannelButton.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JoinVoiceChannelButton extends MaterialButton {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinVoiceChannelButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        setText(2131887835);
    }

    public final void a(MaterialButton materialButton, @StringRes int i) {
        materialButton.setAlpha(0.3f);
        materialButton.setOnClickListener(new JoinVoiceChannelButton$a(materialButton, i));
    }
}
