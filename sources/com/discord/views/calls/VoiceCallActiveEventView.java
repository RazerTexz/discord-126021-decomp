package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import p007b.p008a.p025i.C0979i4;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: VoiceCallActiveEventView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceCallActiveEventView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C0979i4 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceCallActiveEventView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_voice_call_active_event, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.channel_name;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.channel_name);
        if (textView != null) {
            i = C5419R.id.event_icon;
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.event_icon);
            if (imageView != null) {
                i = C5419R.id.event_name;
                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.event_name);
                if (textView2 != null) {
                    C0979i4 c0979i4 = new C0979i4((ConstraintLayout) viewInflate, textView, imageView, textView2);
                    C12238m.checkNotNullExpressionValue(c0979i4, "ViewVoiceCallActiveEvent…rom(context), this, true)");
                    this.binding = c0979i4;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
