package b.a.y.o0;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.f5;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtilsKt;
import d0.z.d.m;

/* JADX INFO: compiled from: SpeakersViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends MGRecyclerViewHolder<c, d> {
    public final f5 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super(R$layout.widget_discovery_other_speakers_count, cVar);
        m.checkNotNullParameter(cVar, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R$id.other_speakers_count_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.other_speakers_count_text)));
        }
        f5 f5Var = new f5((LinearLayout) view, textView);
        m.checkNotNullExpressionValue(f5Var, "WidgetDiscoveryOtherSpea…untBinding.bind(itemView)");
        this.a = f5Var;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int i, d dVar) {
        d dVar2 = dVar;
        m.checkNotNullParameter(dVar2, "data");
        super.onConfigure(i, dVar2);
        int i2 = ((d$b) dVar2).l;
        TextView textView = this.a.f114b;
        m.checkNotNullExpressionValue(textView, "binding.otherSpeakersCountText");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        textView.setText(b.a.k.b.j(view, 2131888556, new Object[]{StringResourceUtilsKt.getI18nPluralString(b.d.b.a.a.x(this.itemView, "itemView", "itemView.context"), R$plurals.discovery_speaker_count_speakersCount, i2, Integer.valueOf(i2))}, null, 4));
    }
}
