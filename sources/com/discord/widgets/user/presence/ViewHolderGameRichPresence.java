package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.application.Application;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.w;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: ViewHolderGameRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderGameRichPresence extends ViewHolderUserRichPresence {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderGameRichPresence(View view, SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, Button button, Button button2) {
        super(view, simpleDraweeView, simpleDraweeView2, textView, textView2, textView3, textView4, textView5, view2, button, button2, 1);
        m.checkNotNullParameter(view, "root");
        m.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        m.checkNotNullParameter(simpleDraweeView2, "richPresenceImageSmall");
        m.checkNotNullParameter(textView, "richPresenceHeader");
        m.checkNotNullParameter(textView2, "richPresenceTitle");
        m.checkNotNullParameter(textView3, "richPresenceDetails");
        m.checkNotNullParameter(textView4, "richPresenceTime");
        m.checkNotNullParameter(textView5, "richPresenceState");
        m.checkNotNullParameter(view2, "richPresenceTextContainer");
        m.checkNotNullParameter(button, "richPresencePrimaryButton");
        m.checkNotNullParameter(button2, "richPresenceSecondaryButton");
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004b  */
    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    public void configureTextUi(Activity model, StreamContext streamContext) {
        String string;
        CharSequence charSequenceH;
        Context context;
        if (model == null) {
            throw new IllegalArgumentException("model must not be null");
        }
        String state = model.getState();
        if (state != null) {
            ActivityParty party = model.getParty();
            if (party != null) {
                PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
                charSequenceH = (presenceUtils.getMaxSize(party) == 0 || (context = getRoot().getContext()) == null) ? null : b.h(context, 2131896743, new Object[]{String.valueOf(presenceUtils.getCurrentSize(party)), String.valueOf(presenceUtils.getMaxSize(party))}, null, 4);
                if (charSequenceH == null) {
                    charSequenceH = "";
                }
            } else {
                charSequenceH = "";
            }
            String str = state + ' ' + charSequenceH;
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            string = w.trim(str).toString();
        } else {
            string = null;
        }
        TextView richPresenceHeader = getRichPresenceHeader();
        Context context2 = getRichPresenceHeader().getContext();
        m.checkNotNullExpressionValue(context2, "richPresenceHeader.context");
        richPresenceHeader.setText(PresenceUtils.getActivityHeader(context2, model));
        getRichPresenceTitle().setText(model.getName());
        TextView richPresenceDetails = getRichPresenceDetails();
        if (richPresenceDetails != null) {
            ViewExtensions.setTextAndVisibilityBy(richPresenceDetails, model.getDetails());
        }
        TextView richPresenceState = getRichPresenceState();
        if (richPresenceState != null) {
            ViewExtensions.setTextAndVisibilityBy(richPresenceState, string);
        }
        TextView richPresenceTime = getRichPresenceTime();
        ActivityTimestamps timestamps = model.getTimestamps();
        ViewExtensions.setTextAndVisibilityBy(richPresenceTime, timestamps != null ? friendlyTime(timestamps) : null);
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    @MainThread
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        String applicationIcon$default;
        Application primaryApplication;
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(applicationContext, "applicationContext");
        super.configureUi(fragmentManager, streamContext, isMe, user, applicationContext, richPresence, userInSameVoiceChannel);
        if (getRichPresenceImageLarge().getVisibility() != 0) {
            if (richPresence == null || (primaryApplication = richPresence.getPrimaryApplication()) == null) {
                applicationIcon$default = null;
            } else {
                long id2 = primaryApplication.getId();
                String icon = primaryApplication.getIcon();
                if (icon == null) {
                    icon = "";
                }
                applicationIcon$default = IconUtils.getApplicationIcon$default(id2, icon, 0, 4, (Object) null);
            }
            getRichPresenceImageLarge().setVisibility(0);
            MGImages.setImage$default(getRichPresenceImageLarge(), applicationIcon$default, 0, 0, false, null, null, 124, null);
        }
    }
}
