package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p018d.C0876m;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: JoinVoiceChannelButton.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JoinVoiceChannelButton extends MaterialButton {

    /* JADX INFO: renamed from: com.discord.views.JoinVoiceChannelButton$a */
    /* JADX INFO: compiled from: JoinVoiceChannelButton.kt */
    public static final class ViewOnClickListenerC7078a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ MaterialButton f19076j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ int f19077k;

        public ViewOnClickListenerC7078a(MaterialButton materialButton, int i) {
            this.f19076j = materialButton;
            this.f19077k = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C0876m.m169g(this.f19076j.getContext(), this.f19077k, 0, null, 12);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinVoiceChannelButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        setText(C5419R.string.connect_to_voice);
    }

    /* JADX INFO: renamed from: a */
    public final void m8547a(MaterialButton materialButton, @StringRes int i) {
        materialButton.setAlpha(0.3f);
        materialButton.setOnClickListener(new ViewOnClickListenerC7078a(materialButton, i));
    }
}
