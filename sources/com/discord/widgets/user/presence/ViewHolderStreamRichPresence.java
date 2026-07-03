package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.StreamPreviewView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p027k.C1107b;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewHolderStreamRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderStreamRichPresence extends ViewHolderUserRichPresence {
    private final StreamPreviewView streamPreview;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderStreamRichPresence(View view, SimpleDraweeView simpleDraweeView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, StreamPreviewView streamPreviewView) {
        super(view, simpleDraweeView, null, textView, textView2, textView3, textView4, textView5, view2, null, null, 4);
        C12238m.checkNotNullParameter(view, "root");
        C12238m.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        C12238m.checkNotNullParameter(textView, "richPresenceHeader");
        C12238m.checkNotNullParameter(textView2, "richPresenceTitle");
        C12238m.checkNotNullParameter(textView3, "richPresenceDetails");
        C12238m.checkNotNullParameter(textView4, "richPresenceTime");
        C12238m.checkNotNullParameter(textView5, "richPresenceState");
        C12238m.checkNotNullParameter(view2, "richPresenceTextContainer");
        C12238m.checkNotNullParameter(streamPreviewView, "streamPreview");
        this.streamPreview = streamPreviewView;
    }

    private final void configureStreamPreview(StreamContext streamContext) {
        StoreApplicationStreamPreviews.StreamPreview preview = streamContext != null ? streamContext.getPreview() : null;
        if (preview == null) {
            this.streamPreview.setVisibility(8);
        } else {
            this.streamPreview.m8557a(preview, streamContext.getJoinability(), streamContext.isCurrentUserParticipating());
            this.streamPreview.setVisibility(0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003b  */
    private final String getRichPresenceStateText(String state, ActivityParty party) {
        CharSequence charSequenceM212d;
        if (state == null) {
            return null;
        }
        if (party != null) {
            PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
            charSequenceM212d = presenceUtils.getMaxSize(party) != 0 ? C1107b.m212d(getRoot(), C5419R.string.user_activity_state_size, new Object[]{String.valueOf(presenceUtils.getCurrentSize(party)), String.valueOf(presenceUtils.getMaxSize(party))}, (4 & 4) != 0 ? C1107b.c.f1492j : null) : null;
            if (charSequenceM212d == null) {
                charSequenceM212d = "";
            }
        } else {
            charSequenceM212d = "";
        }
        String str = state + ' ' + charSequenceM212d;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        return C12106w.trim(str).toString();
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
        getRichPresenceHeader().setText(name != null ? C1107b.m212d(getRichPresenceHeader(), C5419R.string.user_activity_header_streaming_to_guild, new Object[]{name}, (4 & 4) != 0 ? C1107b.c.f1492j : null) : C1107b.m212d(getRichPresenceHeader(), C5419R.string.user_activity_header_streaming_to_dm, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
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
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(applicationContext, "applicationContext");
        disposeTimer();
        Activity playingActivity = (richPresence == null || (presence = richPresence.getPresence()) == null) ? null : PresenceUtils.INSTANCE.getPlayingActivity(presence);
        boolean z2 = (streamContext != null ? streamContext.getJoinability() : null) == StreamContext.Joinability.MISSING_PERMISSIONS;
        if ((streamContext == null && playingActivity == null) || z2) {
            getRoot().setVisibility(8);
            return;
        }
        getRoot().setVisibility(0);
        configureTextUi(playingActivity, streamContext);
        configureAssetUi(playingActivity, streamContext);
        configureStreamPreview(streamContext);
    }

    public final void setOnStreamPreviewClicked(final Function0<Unit> onStreamPreviewClicked) {
        C12238m.checkNotNullParameter(onStreamPreviewClicked, "onStreamPreviewClicked");
        this.streamPreview.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.presence.ViewHolderStreamRichPresence.setOnStreamPreviewClicked.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onStreamPreviewClicked.invoke();
            }
        });
    }
}
