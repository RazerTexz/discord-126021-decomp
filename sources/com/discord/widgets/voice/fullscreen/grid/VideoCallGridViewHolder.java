package com.discord.widgets.voice.fullscreen.grid;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.DisplayCutoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.application.ApplicationAsset;
import com.discord.databinding.VideoCallGridItemEmbeddedActivityBinding;
import com.discord.models.guild.UserGuildMember;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.PileView;
import com.discord.views.calls.VideoCallParticipantView;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.C1320a0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: VideoCallGridViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class VideoCallGridViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: VideoCallGridViewHolder.kt */
    public static final class EmbeddedActivity extends VideoCallGridViewHolder {
        private final VideoCallGridItemEmbeddedActivityBinding binding;
        private final MGImages.DistinctChangeDetector distinctChangeDetector;

        /* JADX WARN: Illegal instructions before constructor call */
        public EmbeddedActivity(VideoCallGridItemEmbeddedActivityBinding videoCallGridItemEmbeddedActivityBinding) {
            C12238m.checkNotNullParameter(videoCallGridItemEmbeddedActivityBinding, "binding");
            FrameLayout frameLayout = videoCallGridItemEmbeddedActivityBinding.f15360a;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = videoCallGridItemEmbeddedActivityBinding;
            this.distinctChangeDetector = new MGImages.DistinctChangeDetector();
        }

        public final void configure(final CallParticipant.EmbeddedActivityParticipant callParticipant, final Function1<? super CallParticipant, Unit> onTapped) {
            C12238m.checkNotNullParameter(callParticipant, "callParticipant");
            C12238m.checkNotNullParameter(onTapped, "onTapped");
            ApplicationAsset backgroundAsset = callParticipant.getBackgroundAsset();
            String assetImage = backgroundAsset != null ? IconUtils.INSTANCE.getAssetImage(Long.valueOf(callParticipant.getApplication().getId()), String.valueOf(backgroundAsset.getId()), 1024) : null;
            SimpleDraweeView simpleDraweeView = this.binding.f15363d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.appBackgroundImage");
            simpleDraweeView.setVisibility(assetImage != null ? 0 : 8);
            View view = this.binding.f15364e;
            C12238m.checkNotNullExpressionValue(view, "binding.appBackgroundOverlay");
            view.setVisibility(assetImage != null ? 0 : 8);
            if (assetImage != null) {
                MGImages mGImages = MGImages.INSTANCE;
                SimpleDraweeView simpleDraweeView2 = this.binding.f15363d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.appBackgroundImage");
                Uri uri = Uri.parse(assetImage);
                C12238m.checkNotNullExpressionValue(uri, "Uri.parse(backgroundAssetUrl)");
                mGImages.setImage(simpleDraweeView2, uri, this.distinctChangeDetector);
            }
            this.binding.f15360a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.grid.VideoCallGridViewHolder$EmbeddedActivity$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    onTapped.invoke(callParticipant);
                }
            });
            FrameLayout frameLayout = this.binding.f15360a;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.root");
            Resources resources = frameLayout.getResources();
            TextView textView = this.binding.f15362c;
            C12238m.checkNotNullExpressionValue(textView, "binding.activityPreviewTitle");
            CharSequence name = callParticipant.getEmbeddedActivity().getName();
            if (name == null) {
                C12238m.checkNotNullExpressionValue(resources, "resources");
                name = C1107b.m211c(resources, C5419R.string.embedded_activities_unknown_activity_name, new Object[0], (4 & 4) != 0 ? C1107b.d.f1493j : null);
            }
            textView.setText(name);
            List<UserGuildMember> participantsInActivity = callParticipant.getParticipantsInActivity();
            int iDpToPixels = DimenUtils.dpToPixels(16);
            C12238m.checkNotNullParameter(participantsInActivity, "userGuildMembers");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(participantsInActivity, 10));
            for (UserGuildMember userGuildMember : participantsInActivity) {
                arrayList.add(IconUtils.INSTANCE.getForGuildMemberOrUser(userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(iDpToPixels), false));
            }
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new PileView.C7089c(new C1320a0((String) it.next()), null));
            }
            this.binding.f15361b.setItems(arrayList2);
        }

        public final VideoCallGridItemEmbeddedActivityBinding getBinding() {
            return this.binding;
        }
    }

    /* JADX INFO: compiled from: VideoCallGridViewHolder.kt */
    public static final class UserOrStream extends VideoCallGridViewHolder {
        private final VideoCallParticipantView videoCallParticipantView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserOrStream(VideoCallParticipantView videoCallParticipantView) {
            super(videoCallParticipantView, null);
            C12238m.checkNotNullParameter(videoCallParticipantView, "videoCallParticipantView");
            this.videoCallParticipantView = videoCallParticipantView;
        }

        public final void configure(final CallParticipant.UserOrStreamParticipant callParticipant, final Function1<? super CallParticipant, Unit> onTapped, Function1<? super CallParticipant, Unit> onLongClicked, Function1<? super String, Unit> onWatchStreamClicked, DisplayCutoutCompat displayCutout, int spanCount, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClicked, VideoCallGridAdapter.CallUiInsets callUiInsets, boolean controlsVisible) {
            C12238m.checkNotNullParameter(callParticipant, "callParticipant");
            C12238m.checkNotNullParameter(onTapped, "onTapped");
            C12238m.checkNotNullParameter(onLongClicked, "onLongClicked");
            C12238m.checkNotNullParameter(onWatchStreamClicked, "onWatchStreamClicked");
            C12238m.checkNotNullParameter(onStreamQualityIndicatorShown, "onStreamQualityIndicatorShown");
            C12238m.checkNotNullParameter(onStreamQualityIndicatorClicked, "onStreamQualityIndicatorClicked");
            C12238m.checkNotNullParameter(callUiInsets, "callUiInsets");
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            Resources resources = view.getResources();
            C12238m.checkNotNullExpressionValue(resources, "itemView.resources");
            this.videoCallParticipantView.m8583c(callParticipant.getParticipantData(), displayCutout, resources.getConfiguration().orientation != 2 ? getAdapterPosition() < spanCount : getAdapterPosition() % spanCount == 0, callUiInsets, controlsVisible);
            this.videoCallParticipantView.setOnWatchStreamClicked(onWatchStreamClicked);
            this.videoCallParticipantView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.grid.VideoCallGridViewHolder$UserOrStream$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    onTapped.invoke(callParticipant);
                }
            });
            ViewExtensions.setOnLongClickListenerConsumeClick(this.videoCallParticipantView, new VideoCallGridViewHolder$UserOrStream$configure$2(onLongClicked, callParticipant));
            VideoCallParticipantView videoCallParticipantView = this.videoCallParticipantView;
            Objects.requireNonNull(videoCallParticipantView);
            C12238m.checkNotNullParameter(onStreamQualityIndicatorShown, "onShown");
            C12238m.checkNotNullParameter(onStreamQualityIndicatorClicked, "onClicked");
            videoCallParticipantView.onStreamQualityIndicatorShown = onStreamQualityIndicatorShown;
            videoCallParticipantView.onStreamQualityIndicatorClicked = onStreamQualityIndicatorClicked;
        }
    }

    private VideoCallGridViewHolder(View view) {
        super(view);
    }

    public /* synthetic */ VideoCallGridViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }
}
