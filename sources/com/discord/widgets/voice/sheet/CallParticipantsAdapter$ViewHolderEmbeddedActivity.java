package com.discord.widgets.voice.sheet;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import b.a.y.a0;
import com.discord.R$drawable;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.VoiceUserListItemEmbeddedActivityBinding;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.UserGuildMember;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$DistinctChangeDetector;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.PileView;
import com.discord.views.PileView$c;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderEmbeddedActivity extends MGRecyclerViewHolder<CallParticipantsAdapter, MGRecyclerDataPayload> {
    private final VoiceUserListItemEmbeddedActivityBinding binding;
    private final MGImages$DistinctChangeDetector distinctChangeDetector;
    private final boolean isCallPreview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallParticipantsAdapter$ViewHolderEmbeddedActivity(CallParticipantsAdapter callParticipantsAdapter, boolean z2) {
        super(R$layout.voice_user_list_item_embedded_activity, callParticipantsAdapter);
        m.checkNotNullParameter(callParticipantsAdapter, "adapter");
        this.isCallPreview = z2;
        View view = this.itemView;
        int i = R$id.app_icon;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.app_icon);
        if (simpleDraweeView != null) {
            i = R$id.app_name;
            TextView textView = (TextView) view.findViewById(R$id.app_name);
            if (textView != null) {
                i = R$id.clickable_container;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.clickable_container);
                if (constraintLayout != null) {
                    i = R$id.participant_avatars;
                    PileView pileView = (PileView) view.findViewById(R$id.participant_avatars);
                    if (pileView != null) {
                        VoiceUserListItemEmbeddedActivityBinding voiceUserListItemEmbeddedActivityBinding = new VoiceUserListItemEmbeddedActivityBinding((FrameLayout) view, simpleDraweeView, textView, constraintLayout, pileView);
                        m.checkNotNullExpressionValue(voiceUserListItemEmbeddedActivityBinding, "VoiceUserListItemEmbedde…ityBinding.bind(itemView)");
                        this.binding = voiceUserListItemEmbeddedActivityBinding;
                        this.distinctChangeDetector = new MGImages$DistinctChangeDetector();
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ CallParticipantsAdapter access$getAdapter$p(CallParticipantsAdapter$ViewHolderEmbeddedActivity callParticipantsAdapter$ViewHolderEmbeddedActivity) {
        return (CallParticipantsAdapter) callParticipantsAdapter$ViewHolderEmbeddedActivity.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        Drawable drawable;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        CallParticipantsAdapter$ListItem$EmbeddedActivityItem callParticipantsAdapter$ListItem$EmbeddedActivityItem = (CallParticipantsAdapter$ListItem$EmbeddedActivityItem) data;
        Application application = callParticipantsAdapter$ListItem$EmbeddedActivityItem.getApplication();
        if (!this.isCallPreview) {
            FrameLayout frameLayout = this.binding.a;
            m.checkNotNullExpressionValue(frameLayout, "binding.root");
            this.binding.a.setBackgroundColor(ColorCompat.getThemedColor(frameLayout.getContext(), 2130968911));
        }
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.appName");
        textView.setText(application.getName());
        boolean z2 = application.getIcon() != null;
        SimpleDraweeView simpleDraweeView = this.binding.f2219b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.appIcon");
        if (z2) {
            drawable = null;
        } else {
            SimpleDraweeView simpleDraweeView2 = this.binding.f2219b;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.appIcon");
            drawable = ContextCompat.getDrawable(simpleDraweeView2.getContext(), R$drawable.ic_activity_24dp);
        }
        simpleDraweeView.setBackground(drawable);
        String applicationIcon = IconUtils.INSTANCE.getApplicationIcon(application, DimenUtils.dpToPixels(32));
        SimpleDraweeView simpleDraweeView3 = this.binding.f2219b;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.appIcon");
        MGImages.setImage$default(simpleDraweeView3, z2 ? applicationIcon : null, DimenUtils.dpToPixels(32), DimenUtils.dpToPixels(32), false, null, this.distinctChangeDetector, 48, null);
        List<UserGuildMember> participants = callParticipantsAdapter$ListItem$EmbeddedActivityItem.getParticipants();
        int iDpToPixels = DimenUtils.dpToPixels(16);
        m.checkNotNullParameter(participants, "userGuildMembers");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(participants, 10));
        for (UserGuildMember userGuildMember : participants) {
            arrayList.add(IconUtils.INSTANCE.getForGuildMemberOrUser(userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(iDpToPixels), false));
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new PileView$c(new a0((String) it.next()), null));
        }
        this.binding.e.setItems(arrayList2);
        this.binding.d.setOnClickListener(new CallParticipantsAdapter$ViewHolderEmbeddedActivity$onConfigure$1(this));
    }
}
