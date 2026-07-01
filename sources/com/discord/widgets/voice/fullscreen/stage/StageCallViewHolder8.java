package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.y.j0.StageCallSpeakerView2;
import b.a.y.j0.StageCallSpeakerView3;
import b.a.y.j0.StageCallSpeakerView4;
import com.discord.R;
import com.discord.databinding.WidgetStageChannelSpeakerBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.colors.RepresentativeColors2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.calls.StageCallSpeakerView;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: renamed from: com.discord.widgets.voice.fullscreen.stage.SpeakerViewHolder, reason: use source file name */
/* JADX INFO: compiled from: StageCallViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageCallViewHolder8 extends StageCallViewHolder {
    private final WidgetStageChannelSpeakerBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallViewHolder8(StageCallAdapter stageCallAdapter) {
        super(R.layout.widget_stage_channel_speaker, stageCallAdapter, null);
        Intrinsics3.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        StageCallSpeakerView stageCallSpeakerView = (StageCallSpeakerView) view.findViewById(R.id.stage_channel_speaker_container);
        if (stageCallSpeakerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.stage_channel_speaker_container)));
        }
        WidgetStageChannelSpeakerBinding widgetStageChannelSpeakerBinding = new WidgetStageChannelSpeakerBinding((ConstraintLayout) view, stageCallSpeakerView);
        Intrinsics3.checkNotNullExpressionValue(widgetStageChannelSpeakerBinding, "WidgetStageChannelSpeakerBinding.bind(itemView)");
        this.binding = widgetStageChannelSpeakerBinding;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, StageCallItem data) {
        int dimensionPixelSize;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StageCallItem.SpeakerItem speakerItem = (StageCallItem.SpeakerItem) data;
        StageCallSpeakerView stageCallSpeakerView = this.binding.f2654b;
        Intrinsics3.checkNotNullExpressionValue(stageCallSpeakerView, "binding.stageChannelSpeakerContainer");
        ViewGroup.LayoutParams layoutParams = stageCallSpeakerView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int speakersPerRow = speakerItem.getSpeakersPerRow();
        if (speakersPerRow == 1) {
            dimensionPixelSize = 0;
        } else if (speakersPerRow != 2) {
            ConstraintLayout constraintLayout = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            dimensionPixelSize = constraintLayout.getResources().getDimensionPixelSize(R.dimen.speaker_height_three_up);
        } else {
            ConstraintLayout constraintLayout2 = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.root");
            dimensionPixelSize = constraintLayout2.getResources().getDimensionPixelSize(R.dimen.speaker_height_two_up);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = dimensionPixelSize;
        layoutParams2.dimensionRatio = speakerItem.getSpeakersPerRow() != 1 ? null : "H,16:9";
        stageCallSpeakerView.setLayoutParams(layoutParams2);
        StageCallSpeakerView stageCallSpeakerView2 = this.binding.f2654b;
        StoreVoiceParticipants.VoiceUser voiceUser = speakerItem.getVoiceUser();
        boolean zIsModerator = speakerItem.isModerator();
        boolean zIsBlocked = speakerItem.isBlocked();
        Objects.requireNonNull(stageCallSpeakerView2);
        Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
        String colorId = RepresentativeColors2.getColorId(voiceUser.getUser());
        stageCallSpeakerView2.binding.f223b.setOnBitmapLoadedListener(new StageCallSpeakerView2(colorId));
        stageCallSpeakerView2.binding.h.setPulsing(voiceUser.getIsSpeaking());
        stageCallSpeakerView2.binding.f223b.a(voiceUser, R.dimen.avatar_size_hero);
        stageCallSpeakerView2.binding.f223b.setRingMargin(DimenUtils.dpToPixels(2));
        ImageView imageView = stageCallSpeakerView2.binding.f;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stageChannelSpeakerMuteIndicator");
        imageView.setVisibility(voiceUser.getIsMuted() && !voiceUser.getIsDeafened() ? 0 : 8);
        ImageView imageView2 = stageCallSpeakerView2.binding.d;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.stageChannelSpeakerDeafenIndicator");
        imageView2.setVisibility(voiceUser.getIsDeafened() ? 0 : 8);
        ImageView imageView3 = stageCallSpeakerView2.binding.e;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.stageChannelSpeakerModIndicator");
        imageView3.setVisibility(zIsModerator ? 0 : 8);
        TextView textView = stageCallSpeakerView2.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stageChannelSpeakerName");
        textView.setText(voiceUser.getDisplayName());
        ImageView imageView4 = stageCallSpeakerView2.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.stageChannelSpeakerBlocked");
        imageView4.setVisibility(zIsBlocked ? 0 : 8);
        Subscription subscription = stageCallSpeakerView2.com.discord.utilities.analytics.Traits.Payment.Type.SUBSCRIPTION java.lang.String;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<R> observableG = RepresentativeColors2.getUserRepresentativeColors().observeRepresentativeColor(colorId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableZ = observableG.Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "UserRepresentativeColors…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) StageCallSpeakerView.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new StageCallSpeakerView3(stageCallSpeakerView2)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new StageCallSpeakerView4(stageCallSpeakerView2));
    }
}
