package com.discord.widgets.voice.fullscreen.grid;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.DisplayCutoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.a.y.PileView2;
import com.discord.R;
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
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: VideoCallGridViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class VideoCallGridViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: compiled from: VideoCallGridViewHolder.kt */
    public static final class EmbeddedActivity extends VideoCallGridViewHolder {
        private final VideoCallGridItemEmbeddedActivityBinding binding;
        private final MGImages.DistinctChangeDetector distinctChangeDetector;

        /* JADX WARN: Illegal instructions before constructor call */
        public EmbeddedActivity(VideoCallGridItemEmbeddedActivityBinding videoCallGridItemEmbeddedActivityBinding) {
            Intrinsics3.checkNotNullParameter(videoCallGridItemEmbeddedActivityBinding, "binding");
            FrameLayout frameLayout = videoCallGridItemEmbeddedActivityBinding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            super(frameLayout, null);
            this.binding = videoCallGridItemEmbeddedActivityBinding;
            this.distinctChangeDetector = new MGImages.DistinctChangeDetector();
        }

        public final void configure(final CallParticipant.EmbeddedActivityParticipant callParticipant, final Function1<? super CallParticipant, Unit> onTapped) {
            Intrinsics3.checkNotNullParameter(callParticipant, "callParticipant");
            Intrinsics3.checkNotNullParameter(onTapped, "onTapped");
            ApplicationAsset backgroundAsset = callParticipant.getBackgroundAsset();
            String assetImage = backgroundAsset != null ? IconUtils.INSTANCE.getAssetImage(Long.valueOf(callParticipant.getApplication().getId()), String.valueOf(backgroundAsset.getId()), 1024) : null;
            SimpleDraweeView simpleDraweeView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.appBackgroundImage");
            simpleDraweeView.setVisibility(assetImage != null ? 0 : 8);
            View view = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.appBackgroundOverlay");
            view.setVisibility(assetImage != null ? 0 : 8);
            if (assetImage != null) {
                MGImages mGImages = MGImages.INSTANCE;
                SimpleDraweeView simpleDraweeView2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.appBackgroundImage");
                Uri uri = Uri.parse(assetImage);
                Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(backgroundAssetUrl)");
                mGImages.setImage(simpleDraweeView2, uri, this.distinctChangeDetector);
            }
            this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.grid.VideoCallGridViewHolder$EmbeddedActivity$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    onTapped.invoke(callParticipant);
                }
            });
            FrameLayout frameLayout = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
            Resources resources = frameLayout.getResources();
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.activityPreviewTitle");
            CharSequence name = callParticipant.getEmbeddedActivity().getName();
            if (name == null) {
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                name = FormatUtils.c(resources, R.string.embedded_activities_unknown_activity_name, new Object[0], (4 & 4) != 0 ? FormatUtils.d.j : null);
            }
            textView.setText(name);
            List<UserGuildMember> participantsInActivity = callParticipant.getParticipantsInActivity();
            int iDpToPixels = DimenUtils.dpToPixels(16);
            Intrinsics3.checkNotNullParameter(participantsInActivity, "userGuildMembers");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(participantsInActivity, 10));
            for (UserGuildMember userGuildMember : participantsInActivity) {
                arrayList.add(IconUtils.INSTANCE.getForGuildMemberOrUser(userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(iDpToPixels), false));
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new PileView.c(new PileView2((String) it.next()), null));
            }
            this.binding.f2169b.setItems(arrayList2);
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
            Intrinsics3.checkNotNullParameter(videoCallParticipantView, "videoCallParticipantView");
            this.videoCallParticipantView = videoCallParticipantView;
        }

        public final void configure(final CallParticipant.UserOrStreamParticipant callParticipant, final Function1<? super CallParticipant, Unit> onTapped, Function1<? super CallParticipant, Unit> onLongClicked, Function1<? super String, Unit> onWatchStreamClicked, DisplayCutoutCompat displayCutout, int spanCount, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorShown, Function2<? super VideoCallParticipantView.StreamResolution, ? super VideoCallParticipantView.StreamFps, Unit> onStreamQualityIndicatorClicked, VideoCallGridAdapter.CallUiInsets callUiInsets, boolean controlsVisible) {
            Intrinsics3.checkNotNullParameter(callParticipant, "callParticipant");
            Intrinsics3.checkNotNullParameter(onTapped, "onTapped");
            Intrinsics3.checkNotNullParameter(onLongClicked, "onLongClicked");
            Intrinsics3.checkNotNullParameter(onWatchStreamClicked, "onWatchStreamClicked");
            Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorShown, "onStreamQualityIndicatorShown");
            Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorClicked, "onStreamQualityIndicatorClicked");
            Intrinsics3.checkNotNullParameter(callUiInsets, "callUiInsets");
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            Resources resources = view.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
            this.videoCallParticipantView.c(callParticipant.getParticipantData(), displayCutout, resources.getConfiguration().orientation != 2 ? getAdapterPosition() < spanCount : getAdapterPosition() % spanCount == 0, callUiInsets, controlsVisible);
            this.videoCallParticipantView.setOnWatchStreamClicked(onWatchStreamClicked);
            this.videoCallParticipantView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.fullscreen.grid.VideoCallGridViewHolder$UserOrStream$configure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    onTapped.invoke(callParticipant);
                }
            });
            ViewExtensions.setOnLongClickListenerConsumeClick(this.videoCallParticipantView, new VideoCallGridViewHolder4(onLongClicked, callParticipant));
            VideoCallParticipantView videoCallParticipantView = this.videoCallParticipantView;
            Objects.requireNonNull(videoCallParticipantView);
            Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorShown, "onShown");
            Intrinsics3.checkNotNullParameter(onStreamQualityIndicatorClicked, "onClicked");
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
