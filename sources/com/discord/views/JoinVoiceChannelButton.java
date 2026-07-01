package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.StringRes;
import b.a.d.AppToast;
import com.discord.R;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: JoinVoiceChannelButton.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JoinVoiceChannelButton extends MaterialButton {

    /* JADX INFO: compiled from: JoinVoiceChannelButton.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ MaterialButton j;
        public final /* synthetic */ int k;

        public a(MaterialButton materialButton, int i) {
            this.j = materialButton;
            this.k = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppToast.g(this.j.getContext(), this.k, 0, null, 12);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinVoiceChannelButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        setText(R.string.connect_to_voice);
    }

    public final void a(MaterialButton materialButton, @StringRes int i) {
        materialButton.setAlpha(0.3f);
        materialButton.setOnClickListener(new a(materialButton, i));
    }
}
