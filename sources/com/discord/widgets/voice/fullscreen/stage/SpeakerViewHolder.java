package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageChannelSpeakerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.colors.RepresentativeColorsKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.views.calls.StageCallSpeakerView;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p062y.p063j0.C1344g;
import p007b.p008a.p062y.p063j0.C1345h;
import p007b.p008a.p062y.p063j0.C1346i;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpeakerViewHolder extends StageCallViewHolder {
    private final WidgetStageChannelSpeakerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakerViewHolder(StageCallAdapter stageCallAdapter) {
        super(C5419R.layout.widget_stage_channel_speaker, stageCallAdapter, null);
        C12238m.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        StageCallSpeakerView stageCallSpeakerView = (StageCallSpeakerView) view.findViewById(C5419R.id.stage_channel_speaker_container);
        if (stageCallSpeakerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.stage_channel_speaker_container)));
        }
        WidgetStageChannelSpeakerBinding widgetStageChannelSpeakerBinding = new WidgetStageChannelSpeakerBinding((ConstraintLayout) view, stageCallSpeakerView);
        C12238m.checkNotNullExpressionValue(widgetStageChannelSpeakerBinding, "WidgetStageChannelSpeakerBinding.bind(itemView)");
        this.binding = widgetStageChannelSpeakerBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, StageCallItem data) {
        int dimensionPixelSize;
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem.SpeakerItem speakerItem = (StageCallItem.SpeakerItem) data;
        StageCallSpeakerView stageCallSpeakerView = this.binding.f18159b;
        C12238m.checkNotNullExpressionValue(stageCallSpeakerView, "binding.stageChannelSpeakerContainer");
        ViewGroup.LayoutParams layoutParams = stageCallSpeakerView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int speakersPerRow = speakerItem.getSpeakersPerRow();
        if (speakersPerRow == 1) {
            dimensionPixelSize = 0;
        } else if (speakersPerRow != 2) {
            ConstraintLayout constraintLayout = this.binding.f18158a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            dimensionPixelSize = constraintLayout.getResources().getDimensionPixelSize(C5419R.dimen.speaker_height_three_up);
        } else {
            ConstraintLayout constraintLayout2 = this.binding.f18158a;
            C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            dimensionPixelSize = constraintLayout2.getResources().getDimensionPixelSize(C5419R.dimen.speaker_height_two_up);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = dimensionPixelSize;
        layoutParams2.dimensionRatio = speakerItem.getSpeakersPerRow() != 1 ? null : "H,16:9";
        stageCallSpeakerView.setLayoutParams(layoutParams2);
        StageCallSpeakerView stageCallSpeakerView2 = this.binding.f18159b;
        StoreVoiceParticipants.VoiceUser voiceUser = speakerItem.getVoiceUser();
        boolean zIsModerator = speakerItem.isModerator();
        boolean zIsBlocked = speakerItem.isBlocked();
        Objects.requireNonNull(stageCallSpeakerView2);
        C12238m.checkNotNullParameter(voiceUser, "voiceUser");
        String colorId = RepresentativeColorsKt.getColorId(voiceUser.getUser());
        stageCallSpeakerView2.binding.f1349b.setOnBitmapLoadedListener(new C1344g(colorId));
        stageCallSpeakerView2.binding.f1355h.setPulsing(voiceUser.getIsSpeaking());
        stageCallSpeakerView2.binding.f1349b.m8570a(voiceUser, C5419R.dimen.avatar_size_hero);
        stageCallSpeakerView2.binding.f1349b.setRingMargin(DimenUtils.dpToPixels(2));
        ImageView imageView = stageCallSpeakerView2.binding.f1353f;
        C12238m.checkNotNullExpressionValue(imageView, "binding.stageChannelSpeakerMuteIndicator");
        imageView.setVisibility(voiceUser.getIsMuted() && !voiceUser.getIsDeafened() ? 0 : 8);
        ImageView imageView2 = stageCallSpeakerView2.binding.f1351d;
        C12238m.checkNotNullExpressionValue(imageView2, "binding.stageChannelSpeakerDeafenIndicator");
        imageView2.setVisibility(voiceUser.getIsDeafened() ? 0 : 8);
        ImageView imageView3 = stageCallSpeakerView2.binding.f1352e;
        C12238m.checkNotNullExpressionValue(imageView3, "binding.stageChannelSpeakerModIndicator");
        imageView3.setVisibility(zIsModerator ? 0 : 8);
        TextView textView = stageCallSpeakerView2.binding.f1354g;
        C12238m.checkNotNullExpressionValue(textView, "binding.stageChannelSpeakerName");
        textView.setText(voiceUser.getDisplayName());
        ImageView imageView4 = stageCallSpeakerView2.binding.f1350c;
        C12238m.checkNotNullExpressionValue(imageView4, "binding.stageChannelSpeakerBlocked");
        imageView4.setVisibility(zIsBlocked ? 0 : 8);
        Subscription subscription = stageCallSpeakerView2.com.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<R> observableM11083G = RepresentativeColorsKt.getUserRepresentativeColors().observeRepresentativeColor(colorId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11100Z = observableM11083G.m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "UserRepresentativeColors…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableM11100Z, (Class<?>) StageCallSpeakerView.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C1345h(stageCallSpeakerView2)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C1346i(stageCallSpeakerView2));
    }
}
