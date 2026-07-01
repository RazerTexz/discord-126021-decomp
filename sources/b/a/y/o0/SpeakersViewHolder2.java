package b.a.y.o0;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.WidgetDiscoveryOtherSpeakersCountBinding;
import b.a.k.FormatUtils;
import b.a.y.o0.SpeakersItem;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.y.o0.b, reason: use source file name */
/* JADX INFO: compiled from: SpeakersViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpeakersViewHolder2 extends MGRecyclerViewHolder<SpeakersAdapter, SpeakersItem> {
    public final WidgetDiscoveryOtherSpeakersCountBinding a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakersViewHolder2(SpeakersAdapter speakersAdapter) {
        super(R.layout.widget_discovery_other_speakers_count, speakersAdapter);
        Intrinsics3.checkNotNullParameter(speakersAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(R.id.other_speakers_count_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.other_speakers_count_text)));
        }
        WidgetDiscoveryOtherSpeakersCountBinding widgetDiscoveryOtherSpeakersCountBinding = new WidgetDiscoveryOtherSpeakersCountBinding((LinearLayout) view, textView);
        Intrinsics3.checkNotNullExpressionValue(widgetDiscoveryOtherSpeakersCountBinding, "WidgetDiscoveryOtherSpea…untBinding.bind(itemView)");
        this.a = widgetDiscoveryOtherSpeakersCountBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int i, SpeakersItem speakersItem) {
        SpeakersItem speakersItem2 = speakersItem;
        Intrinsics3.checkNotNullParameter(speakersItem2, "data");
        super.onConfigure(i, speakersItem2);
        int i2 = ((SpeakersItem.b) speakersItem2).l;
        TextView textView = this.a.f114b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.otherSpeakersCountText");
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        textView.setText(FormatUtils.d(view, R.string.discovery_speaker_count, new Object[]{StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.discovery_speaker_count_speakersCount, i2, Integer.valueOf(i2))}, (4 & 4) != 0 ? FormatUtils.c.j : null));
    }
}
