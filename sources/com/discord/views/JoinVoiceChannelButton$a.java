package com.discord.views;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: JoinVoiceChannelButton.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JoinVoiceChannelButton$a implements View$OnClickListener {
    public final /* synthetic */ MaterialButton j;
    public final /* synthetic */ int k;

    public JoinVoiceChannelButton$a(MaterialButton materialButton, int i) {
        this.j = materialButton;
        this.k = i;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.g(this.j.getContext(), this.k, 0, null, 12);
    }
}
