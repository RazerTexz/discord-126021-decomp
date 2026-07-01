package b.a.y.o0;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.i.WidgetDiscoveryStageCardSpeakerBinding;
import b.a.y.o0.SpeakersItem;
import com.discord.R;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.a.y.o0.a, reason: use source file name */
/* JADX INFO: compiled from: SpeakersViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpeakersViewHolder extends MGRecyclerViewHolder<SpeakersAdapter, SpeakersItem> {
    public final WidgetDiscoveryStageCardSpeakerBinding a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakersViewHolder(SpeakersAdapter speakersAdapter) {
        super(R.layout.widget_discovery_stage_card_speaker, speakersAdapter);
        Intrinsics3.checkNotNullParameter(speakersAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.discovery_stage_card_speaker_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.discovery_stage_card_speaker_avatar);
        if (simpleDraweeView != null) {
            i = R.id.discovery_stage_card_speaker_name;
            TextView textView = (TextView) view.findViewById(R.id.discovery_stage_card_speaker_name);
            if (textView != null) {
                WidgetDiscoveryStageCardSpeakerBinding widgetDiscoveryStageCardSpeakerBinding = new WidgetDiscoveryStageCardSpeakerBinding((LinearLayout) view, simpleDraweeView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetDiscoveryStageCardSpeakerBinding, "WidgetDiscoveryStageCard…kerBinding.bind(itemView)");
                this.a = widgetDiscoveryStageCardSpeakerBinding;
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int i, SpeakersItem speakersItem) {
        SpeakersItem speakersItem2 = speakersItem;
        Intrinsics3.checkNotNullParameter(speakersItem2, "data");
        super.onConfigure(i, speakersItem2);
        SpeakersItem.a aVar = (SpeakersItem.a) speakersItem2;
        SimpleDraweeView simpleDraweeView = this.a.f121b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.discoveryStageCardSpeakerAvatar");
        SimpleDraweeViewExtensions.setAvatar$default(simpleDraweeView, aVar.l, false, R.dimen.avatar_size_medium, aVar.m, 2, null);
        TextView textView = this.a.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discoveryStageCardSpeakerName");
        textView.setText(aVar.n);
    }
}
