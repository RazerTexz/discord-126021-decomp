package p007b.p008a.p062y.p068o0;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.C0965g5;
import p007b.p008a.p062y.p068o0.AbstractC1367d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.o0.a */
/* JADX INFO: compiled from: SpeakersViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1364a extends MGRecyclerViewHolder<C1366c, AbstractC1367d> {

    /* JADX INFO: renamed from: a */
    public final C0965g5 f2052a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1364a(C1366c c1366c) {
        super(C5419R.layout.widget_discovery_stage_card_speaker, c1366c);
        C12238m.checkNotNullParameter(c1366c, "adapter");
        View view = this.itemView;
        int i = C5419R.id.discovery_stage_card_speaker_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.discovery_stage_card_speaker_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.discovery_stage_card_speaker_name;
            TextView textView = (TextView) view.findViewById(C5419R.id.discovery_stage_card_speaker_name);
            if (textView != null) {
                C0965g5 c0965g5 = new C0965g5((LinearLayout) view, simpleDraweeView, textView);
                C12238m.checkNotNullExpressionValue(c0965g5, "WidgetDiscoveryStageCard…kerBinding.bind(itemView)");
                this.f2052a = c0965g5;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int i, AbstractC1367d abstractC1367d) {
        AbstractC1367d abstractC1367d2 = abstractC1367d;
        C12238m.checkNotNullParameter(abstractC1367d2, "data");
        super.onConfigure(i, abstractC1367d2);
        AbstractC1367d.a aVar = (AbstractC1367d.a) abstractC1367d2;
        SimpleDraweeView simpleDraweeView = this.f2052a.f878b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.discoveryStageCardSpeakerAvatar");
        SimpleDraweeViewExtensionsKt.setAvatar$default(simpleDraweeView, aVar.f2057l, false, C5419R.dimen.avatar_size_medium, aVar.f2058m, 2, null);
        TextView textView = this.f2052a.f879c;
        C12238m.checkNotNullExpressionValue(textView, "binding.discoveryStageCardSpeakerName");
        textView.setText(aVar.f2059n);
    }
}
