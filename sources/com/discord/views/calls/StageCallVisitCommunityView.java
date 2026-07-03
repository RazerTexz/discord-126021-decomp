package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.C1083x3;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageCallVisitCommunityView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageCallVisitCommunityView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C1083x3 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallVisitCommunityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_stage_channel_visit_community, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.visit_community_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.visit_community_icon);
        if (simpleDraweeView != null) {
            i = C5419R.id.visit_community_icon_text;
            TextView textView = (TextView) viewInflate.findViewById(C5419R.id.visit_community_icon_text);
            if (textView != null) {
                i = C5419R.id.visit_community_text;
                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.visit_community_text);
                if (textView2 != null) {
                    C1083x3 c1083x3 = new C1083x3((ConstraintLayout) viewInflate, simpleDraweeView, textView, textView2);
                    C12238m.checkNotNullExpressionValue(c1083x3, "ViewStageChannelVisitCom…rom(context), this, true)");
                    this.binding = c1083x3;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
