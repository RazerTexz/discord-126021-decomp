package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewVoiceCallActiveEventBinding;
import com.discord.R;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: VoiceCallActiveEventView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceCallActiveEventView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ViewVoiceCallActiveEventBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceCallActiveEventView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_voice_call_active_event, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.channel_name;
        TextView textView = (TextView) viewInflate.findViewById(R.id.channel_name);
        if (textView != null) {
            i = R.id.event_icon;
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.event_icon);
            if (imageView != null) {
                i = R.id.event_name;
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.event_name);
                if (textView2 != null) {
                    ViewVoiceCallActiveEventBinding viewVoiceCallActiveEventBinding = new ViewVoiceCallActiveEventBinding((ConstraintLayout) viewInflate, textView, imageView, textView2);
                    Intrinsics3.checkNotNullExpressionValue(viewVoiceCallActiveEventBinding, "ViewVoiceCallActiveEvent…rom(context), this, true)");
                    this.binding = viewVoiceCallActiveEventBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
