package com.discord.widgets.voice.fullscreen.grid;

import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import b.a.k.b;
import b.a.y.a0;
import com.discord.api.application.ApplicationAsset;
import com.discord.databinding.VideoCallGridItemEmbeddedActivityBinding;
import com.discord.models.guild.UserGuildMember;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$DistinctChangeDetector;
import com.discord.views.PileView$c;
import com.discord.widgets.voice.fullscreen.CallParticipant;
import com.discord.widgets.voice.fullscreen.CallParticipant$EmbeddedActivityParticipant;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VideoCallGridViewHolder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoCallGridViewHolder$EmbeddedActivity extends VideoCallGridViewHolder {
    private final VideoCallGridItemEmbeddedActivityBinding binding;
    private final MGImages$DistinctChangeDetector distinctChangeDetector;

    /* JADX WARN: Illegal instructions before constructor call */
    public VideoCallGridViewHolder$EmbeddedActivity(VideoCallGridItemEmbeddedActivityBinding videoCallGridItemEmbeddedActivityBinding) {
        m.checkNotNullParameter(videoCallGridItemEmbeddedActivityBinding, "binding");
        FrameLayout frameLayout = videoCallGridItemEmbeddedActivityBinding.a;
        m.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout, null);
        this.binding = videoCallGridItemEmbeddedActivityBinding;
        this.distinctChangeDetector = new MGImages$DistinctChangeDetector();
    }

    public final void configure(CallParticipant$EmbeddedActivityParticipant callParticipant, Function1<? super CallParticipant, Unit> onTapped) {
        m.checkNotNullParameter(callParticipant, "callParticipant");
        m.checkNotNullParameter(onTapped, "onTapped");
        ApplicationAsset backgroundAsset = callParticipant.getBackgroundAsset();
        String assetImage = backgroundAsset != null ? IconUtils.INSTANCE.getAssetImage(Long.valueOf(callParticipant.getApplication().getId()), String.valueOf(backgroundAsset.getId()), 1024) : null;
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.appBackgroundImage");
        simpleDraweeView.setVisibility(assetImage != null ? 0 : 8);
        View view = this.binding.e;
        m.checkNotNullExpressionValue(view, "binding.appBackgroundOverlay");
        view.setVisibility(assetImage != null ? 0 : 8);
        if (assetImage != null) {
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView2 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.appBackgroundImage");
            Uri uri = Uri.parse(assetImage);
            m.checkNotNullExpressionValue(uri, "Uri.parse(backgroundAssetUrl)");
            mGImages.setImage(simpleDraweeView2, uri, this.distinctChangeDetector);
        }
        this.binding.a.setOnClickListener(new VideoCallGridViewHolder$EmbeddedActivity$configure$1(onTapped, callParticipant));
        FrameLayout frameLayout = this.binding.a;
        m.checkNotNullExpressionValue(frameLayout, "binding.root");
        Resources resources = frameLayout.getResources();
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.activityPreviewTitle");
        CharSequence name = callParticipant.getEmbeddedActivity().getName();
        if (name == null) {
            m.checkNotNullExpressionValue(resources, "resources");
            name = b.i(resources, 2131888731, new Object[0], null, 4);
        }
        textView.setText(name);
        List<UserGuildMember> participantsInActivity = callParticipant.getParticipantsInActivity();
        int iDpToPixels = DimenUtils.dpToPixels(16);
        m.checkNotNullParameter(participantsInActivity, "userGuildMembers");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(participantsInActivity, 10));
        for (UserGuildMember userGuildMember : participantsInActivity) {
            arrayList.add(IconUtils.INSTANCE.getForGuildMemberOrUser(userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(iDpToPixels), false));
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new PileView$c(new a0((String) it.next()), null));
        }
        this.binding.f2169b.setItems(arrayList2);
    }

    public final VideoCallGridItemEmbeddedActivityBinding getBinding() {
        return this.binding;
    }
}
