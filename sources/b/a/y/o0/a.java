package b.a.y.o0;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.g5;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;

/* JADX INFO: compiled from: SpeakersViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends MGRecyclerViewHolder<c, d> {
    public final g5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar) {
        super(R$layout.widget_discovery_stage_card_speaker, cVar);
        m.checkNotNullParameter(cVar, "adapter");
        View view = this.itemView;
        int i = R$id.discovery_stage_card_speaker_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.discovery_stage_card_speaker_avatar);
        if (simpleDraweeView != null) {
            i = R$id.discovery_stage_card_speaker_name;
            TextView textView = (TextView) view.findViewById(R$id.discovery_stage_card_speaker_name);
            if (textView != null) {
                g5 g5Var = new g5((LinearLayout) view, simpleDraweeView, textView);
                m.checkNotNullExpressionValue(g5Var, "WidgetDiscoveryStageCard…kerBinding.bind(itemView)");
                this.a = g5Var;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int i, d dVar) {
        d dVar2 = dVar;
        m.checkNotNullParameter(dVar2, "data");
        super.onConfigure(i, dVar2);
        d$a d_a = (d$a) dVar2;
        SimpleDraweeView simpleDraweeView = this.a.f121b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.discoveryStageCardSpeakerAvatar");
        SimpleDraweeViewExtensionsKt.setAvatar$default(simpleDraweeView, d_a.l, false, 2131165294, d_a.m, 2, null);
        TextView textView = this.a.c;
        m.checkNotNullExpressionValue(textView, "binding.discoveryStageCardSpeakerName");
        textView.setText(d_a.n);
    }
}
