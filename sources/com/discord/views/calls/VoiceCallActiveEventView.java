package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.i4;
import com.discord.R$id;
import com.discord.R$layout;
import d0.z.d.m;

/* JADX INFO: compiled from: VoiceCallActiveEventView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceCallActiveEventView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final i4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceCallActiveEventView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_voice_call_active_event, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.channel_name;
        TextView textView = (TextView) viewInflate.findViewById(R$id.channel_name);
        if (textView != null) {
            i = R$id.event_icon;
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.event_icon);
            if (imageView != null) {
                i = R$id.event_name;
                TextView textView2 = (TextView) viewInflate.findViewById(R$id.event_name);
                if (textView2 != null) {
                    i4 i4Var = new i4((ConstraintLayout) viewInflate, textView, imageView, textView2);
                    m.checkNotNullExpressionValue(i4Var, "ViewVoiceCallActiveEvent…rom(context), this, true)");
                    this.binding = i4Var;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
