package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreamPreviews$StreamPreview;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContext$Joinability;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.StreamPreviewView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.w;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ViewHolderStreamRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderStreamRichPresence extends ViewHolderUserRichPresence {
    private final StreamPreviewView streamPreview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderStreamRichPresence(View view, SimpleDraweeView simpleDraweeView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, StreamPreviewView streamPreviewView) {
        super(view, simpleDraweeView, null, textView, textView2, textView3, textView4, textView5, view2, null, null, 4);
        m.checkNotNullParameter(view, "root");
        m.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        m.checkNotNullParameter(textView, "richPresenceHeader");
        m.checkNotNullParameter(textView2, "richPresenceTitle");
        m.checkNotNullParameter(textView3, "richPresenceDetails");
        m.checkNotNullParameter(textView4, "richPresenceTime");
        m.checkNotNullParameter(textView5, "richPresenceState");
        m.checkNotNullParameter(view2, "richPresenceTextContainer");
        m.checkNotNullParameter(streamPreviewView, "streamPreview");
        this.streamPreview = streamPreviewView;
    }

    private final void configureStreamPreview(StreamContext streamContext) {
        StoreApplicationStreamPreviews$StreamPreview preview = streamContext != null ? streamContext.getPreview() : null;
        if (preview == null) {
            this.streamPreview.setVisibility(8);
        } else {
            this.streamPreview.a(preview, streamContext.getJoinability(), streamContext.isCurrentUserParticipating());
            this.streamPreview.setVisibility(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003b  */
    private final String getRichPresenceStateText(String state, ActivityParty party) {
        CharSequence charSequenceJ;
        if (state == null) {
            return null;
        }
        if (party != null) {
            PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
            charSequenceJ = presenceUtils.getMaxSize(party) != 0 ? b.j(getRoot(), 2131896743, new Object[]{String.valueOf(presenceUtils.getCurrentSize(party)), String.valueOf(presenceUtils.getMaxSize(party))}, null, 4) : null;
            if (charSequenceJ == null) {
                charSequenceJ = "";
            }
        } else {
            charSequenceJ = "";
        }
        String str = state + ' ' + charSequenceJ;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        return w.trim(str).toString();
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    public void configureAssetUi(Activity model, StreamContext streamContext) {
        super.configureAssetUi(model, streamContext);
        getRichPresenceImageLarge().setVisibility(8);
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    public void configureTextUi(Activity model, StreamContext streamContext) {
        if (streamContext == null) {
            throw new IllegalArgumentException("streamContext must not be null");
        }
        Guild guild = streamContext.getGuild();
        String name = guild != null ? guild.getName() : null;
        getRichPresenceHeader().setText(name != null ? b.j(getRichPresenceHeader(), 2131896730, new Object[]{name}, null, 4) : b.j(getRichPresenceHeader(), 2131896729, new Object[0], null, 4));
        if (model == null || !ActivityUtilsKt.isGameActivity(model)) {
            getRichPresenceTextContainer().setVisibility(8);
            return;
        }
        String richPresenceStateText = getRichPresenceStateText(model.getState(), model.getParty());
        getRichPresenceTextContainer().setVisibility(0);
        getRichPresenceTitle().setText(model.getName());
        TextView richPresenceDetails = getRichPresenceDetails();
        if (richPresenceDetails != null) {
            ViewExtensions.setTextAndVisibilityBy(richPresenceDetails, model.getDetails());
        }
        TextView richPresenceState = getRichPresenceState();
        if (richPresenceState != null) {
            ViewExtensions.setTextAndVisibilityBy(richPresenceState, richPresenceStateText);
        }
        TextView richPresenceTime = getRichPresenceTime();
        ActivityTimestamps timestamps = model.getTimestamps();
        ViewExtensions.setTextAndVisibilityBy(richPresenceTime, timestamps != null ? friendlyTime(timestamps) : null);
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        Presence presence;
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(applicationContext, "applicationContext");
        disposeTimer();
        Activity playingActivity = (richPresence == null || (presence = richPresence.getPresence()) == null) ? null : PresenceUtils.INSTANCE.getPlayingActivity(presence);
        boolean z2 = (streamContext != null ? streamContext.getJoinability() : null) == StreamContext$Joinability.MISSING_PERMISSIONS;
        if ((streamContext == null && playingActivity == null) || z2) {
            getRoot().setVisibility(8);
            return;
        }
        getRoot().setVisibility(0);
        configureTextUi(playingActivity, streamContext);
        configureAssetUi(playingActivity, streamContext);
        configureStreamPreview(streamContext);
    }

    public final void setOnStreamPreviewClicked(Function0<Unit> onStreamPreviewClicked) {
        m.checkNotNullParameter(onStreamPreviewClicked, "onStreamPreviewClicked");
        this.streamPreview.setOnClickListener(new ViewHolderStreamRichPresence$setOnStreamPreviewClicked$1(onStreamPreviewClicked));
    }
}
