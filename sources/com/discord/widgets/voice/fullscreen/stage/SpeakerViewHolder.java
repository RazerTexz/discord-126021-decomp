package com.discord.widgets.voice.fullscreen.stage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import b.a.y.j0.g;
import b.a.y.j0.h;
import b.a.y.j0.i;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetStageChannelSpeakerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.colors.RepresentativeColorsKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.views.calls.StageCallSpeakerView;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SpeakerViewHolder extends StageCallViewHolder {
    private final WidgetStageChannelSpeakerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakerViewHolder(StageCallAdapter stageCallAdapter) {
        super(R$layout.widget_stage_channel_speaker, stageCallAdapter, null);
        m.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        StageCallSpeakerView stageCallSpeakerView = (StageCallSpeakerView) view.findViewById(R$id.stage_channel_speaker_container);
        if (stageCallSpeakerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.stage_channel_speaker_container)));
        }
        WidgetStageChannelSpeakerBinding widgetStageChannelSpeakerBinding = new WidgetStageChannelSpeakerBinding((ConstraintLayout) view, stageCallSpeakerView);
        m.checkNotNullExpressionValue(widgetStageChannelSpeakerBinding, "WidgetStageChannelSpeakerBinding.bind(itemView)");
        this.binding = widgetStageChannelSpeakerBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) {
        onConfigure2(i, stageCallItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) {
        int dimensionPixelSize;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem$SpeakerItem stageCallItem$SpeakerItem = (StageCallItem$SpeakerItem) data;
        StageCallSpeakerView stageCallSpeakerView = this.binding.f2654b;
        m.checkNotNullExpressionValue(stageCallSpeakerView, "binding.stageChannelSpeakerContainer");
        ViewGroup$LayoutParams layoutParams = stageCallSpeakerView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) layoutParams;
        int speakersPerRow = stageCallItem$SpeakerItem.getSpeakersPerRow();
        if (speakersPerRow == 1) {
            dimensionPixelSize = 0;
        } else if (speakersPerRow != 2) {
            ConstraintLayout constraintLayout = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            dimensionPixelSize = constraintLayout.getResources().getDimensionPixelSize(2131165738);
        } else {
            ConstraintLayout constraintLayout2 = this.binding.a;
            m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            dimensionPixelSize = constraintLayout2.getResources().getDimensionPixelSize(2131165739);
        }
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).height = dimensionPixelSize;
        constraintLayout$LayoutParams.dimensionRatio = stageCallItem$SpeakerItem.getSpeakersPerRow() != 1 ? null : "H,16:9";
        stageCallSpeakerView.setLayoutParams(constraintLayout$LayoutParams);
        StageCallSpeakerView stageCallSpeakerView2 = this.binding.f2654b;
        StoreVoiceParticipants$VoiceUser voiceUser = stageCallItem$SpeakerItem.getVoiceUser();
        boolean zIsModerator = stageCallItem$SpeakerItem.isModerator();
        boolean zIsBlocked = stageCallItem$SpeakerItem.isBlocked();
        Objects.requireNonNull(stageCallSpeakerView2);
        m.checkNotNullParameter(voiceUser, "voiceUser");
        String colorId = RepresentativeColorsKt.getColorId(voiceUser.getUser());
        stageCallSpeakerView2.binding.f223b.setOnBitmapLoadedListener(new g(colorId));
        stageCallSpeakerView2.binding.h.setPulsing(voiceUser.getIsSpeaking());
        stageCallSpeakerView2.binding.f223b.a(voiceUser, 2131165291);
        stageCallSpeakerView2.binding.f223b.setRingMargin(DimenUtils.dpToPixels(2));
        ImageView imageView = stageCallSpeakerView2.binding.f;
        m.checkNotNullExpressionValue(imageView, "binding.stageChannelSpeakerMuteIndicator");
        imageView.setVisibility(voiceUser.getIsMuted() && !voiceUser.getIsDeafened() ? 0 : 8);
        ImageView imageView2 = stageCallSpeakerView2.binding.d;
        m.checkNotNullExpressionValue(imageView2, "binding.stageChannelSpeakerDeafenIndicator");
        imageView2.setVisibility(voiceUser.getIsDeafened() ? 0 : 8);
        ImageView imageView3 = stageCallSpeakerView2.binding.e;
        m.checkNotNullExpressionValue(imageView3, "binding.stageChannelSpeakerModIndicator");
        imageView3.setVisibility(zIsModerator ? 0 : 8);
        TextView textView = stageCallSpeakerView2.binding.g;
        m.checkNotNullExpressionValue(textView, "binding.stageChannelSpeakerName");
        textView.setText(voiceUser.getDisplayName());
        ImageView imageView4 = stageCallSpeakerView2.binding.c;
        m.checkNotNullExpressionValue(imageView4, "binding.stageChannelSpeakerBlocked");
        imageView4.setVisibility(zIsBlocked ? 0 : 8);
        Subscription subscription = stageCallSpeakerView2.com.discord.utilities.analytics.Traits$Payment$Type.SUBSCRIPTION java.lang.String;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<R> observableG = RepresentativeColorsKt.getUserRepresentativeColors().observeRepresentativeColor(colorId).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableZ = observableG.Z(1);
        m.checkNotNullExpressionValue(observableZ, "UserRepresentativeColors…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, StageCallSpeakerView.class, (Context) null, new h(stageCallSpeakerView2), (Function1) null, (Function0) null, (Function0) null, new i(stageCallSpeakerView2), 58, (Object) null);
    }
}
