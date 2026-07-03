package p007b.p008a.p062y.p068o0;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtilsKt;
import p007b.p008a.p025i.C0957f5;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.p068o0.AbstractC1367d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.o0.b */
/* JADX INFO: compiled from: SpeakersViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1365b extends MGRecyclerViewHolder<C1366c, AbstractC1367d> {

    /* JADX INFO: renamed from: a */
    public final C0957f5 f2053a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1365b(C1366c c1366c) {
        super(C5419R.layout.widget_discovery_other_speakers_count, c1366c);
        C12238m.checkNotNullParameter(c1366c, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C5419R.id.other_speakers_count_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.other_speakers_count_text)));
        }
        C0957f5 c0957f5 = new C0957f5((LinearLayout) view, textView);
        C12238m.checkNotNullExpressionValue(c0957f5, "WidgetDiscoveryOtherSpea…untBinding.bind(itemView)");
        this.f2053a = c0957f5;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int i, AbstractC1367d abstractC1367d) {
        AbstractC1367d abstractC1367d2 = abstractC1367d;
        C12238m.checkNotNullParameter(abstractC1367d2, "data");
        super.onConfigure(i, abstractC1367d2);
        int i2 = ((AbstractC1367d.b) abstractC1367d2).f2061l;
        TextView textView = this.f2053a.f848b;
        C12238m.checkNotNullExpressionValue(textView, "binding.otherSpeakersCountText");
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        textView.setText(C1107b.m212d(view, C5419R.string.discovery_speaker_count, new Object[]{StringResourceUtilsKt.getI18nPluralString(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.plurals.discovery_speaker_count_speakersCount, i2, Integer.valueOf(i2))}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
    }
}
