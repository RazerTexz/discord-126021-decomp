package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.models.user.User;
import com.discord.utilities.integrations.SpotifyHelper;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.z.d.m;

/* JADX INFO: compiled from: ViewHolderMusicRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderMusicRichPresence extends ViewHolderUserRichPresence {
    private final Clock clock;
    private final TextView richPresenceMusicDuration;
    private final TextView richPresenceMusicElapsed;
    private final SeekBar richPresenceSeekbar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderMusicRichPresence(View view, SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2, Button button, SeekBar seekBar, TextView textView5, TextView textView6) {
        super(view, simpleDraweeView, simpleDraweeView2, textView, textView2, textView3, textView4, null, view2, button, null, 2);
        m.checkNotNullParameter(view, "root");
        m.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        m.checkNotNullParameter(simpleDraweeView2, "richPresenceImageSmall");
        m.checkNotNullParameter(textView, "richPresenceHeader");
        m.checkNotNullParameter(textView2, "richPresenceTitle");
        m.checkNotNullParameter(textView3, "richPresenceDetails");
        m.checkNotNullParameter(textView4, "richPresenceTime");
        m.checkNotNullParameter(view2, "richPresenceTextContainer");
        m.checkNotNullParameter(button, "richPresencePrimaryButton");
        m.checkNotNullParameter(seekBar, "richPresenceSeekbar");
        m.checkNotNullParameter(textView5, "richPresenceMusicDuration");
        m.checkNotNullParameter(textView6, "richPresenceMusicElapsed");
        this.richPresenceSeekbar = seekBar;
        this.richPresenceMusicDuration = textView5;
        this.richPresenceMusicElapsed = textView6;
        this.clock = ClockFactory.get();
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    public void configureAssetUi(Activity model, StreamContext streamContext) {
        super.configureAssetUi(model, streamContext);
        SimpleDraweeView richPresenceImageSmall = getRichPresenceImageSmall();
        if (richPresenceImageSmall != null) {
            ViewKt.setVisible(richPresenceImageSmall, true);
        }
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    @MainThread
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(applicationContext, "applicationContext");
        disposeTimer();
        Context context = getRoot().getContext();
        Activity primaryActivity = richPresence != null ? richPresence.getPrimaryActivity() : null;
        if (primaryActivity == null || !ActivityUtilsKt.isRichPresence(primaryActivity)) {
            getRoot().setVisibility(8);
            return;
        }
        getRoot().setVisibility(0);
        boolean zEquals = t.equals(primaryActivity.getName(), ActivityPlatform.SPOTIFY.name(), true);
        String state = primaryActivity.getState();
        String strReplace$default = state != null ? t.replace$default(state, ';', ',', false, 4, (Object) null) : null;
        TextView richPresenceHeader = getRichPresenceHeader();
        Context context2 = getRichPresenceHeader().getContext();
        m.checkNotNullExpressionValue(context2, "richPresenceHeader.context");
        richPresenceHeader.setText(PresenceUtils.getActivityHeader(context2, primaryActivity));
        getRichPresenceTitle().setText(primaryActivity.getDetails());
        TextView richPresenceDetails = getRichPresenceDetails();
        if (richPresenceDetails != null) {
            m.checkNotNullExpressionValue(context, "context");
            ViewExtensions.setTextAndVisibilityBy(richPresenceDetails, b.h(context, 2131896737, new Object[]{strReplace$default}, null, 4));
        }
        TextView richPresenceTime = getRichPresenceTime();
        m.checkNotNullExpressionValue(context, "context");
        Object[] objArr = new Object[1];
        ActivityAssets assets = primaryActivity.getAssets();
        objArr[0] = assets != null ? assets.getLargeText() : null;
        ViewExtensions.setTextAndVisibilityBy(richPresenceTime, b.h(context, 2131896736, objArr, null, 4));
        getRichPresenceTextContainer().setSelected(true);
        configureAssetUi(primaryActivity, streamContext);
        Button richPresencePrimaryButton = getRichPresencePrimaryButton();
        if (richPresencePrimaryButton != null) {
            ViewKt.setVisible(richPresencePrimaryButton, zEquals);
        }
        this.richPresenceSeekbar.setVisibility(zEquals ? 0 : 8);
        this.richPresenceMusicDuration.setVisibility(zEquals ? 0 : 8);
        this.richPresenceMusicElapsed.setVisibility(zEquals ? 0 : 8);
        if (isMe) {
            Button richPresencePrimaryButton2 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton2 != null) {
                b.n(richPresencePrimaryButton2, 2131896720, new Object[0], null, 4);
            }
            Button richPresencePrimaryButton3 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton3 != null) {
                richPresencePrimaryButton3.setEnabled(false);
            }
        } else {
            Button richPresencePrimaryButton4 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton4 != null) {
                b.n(richPresencePrimaryButton4, 2131896739, new Object[]{primaryActivity.getName()}, null, 4);
            }
            Button richPresencePrimaryButton5 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton5 != null) {
                richPresencePrimaryButton5.setEnabled(true);
            }
        }
        if (!SpotifyHelper.INSTANCE.isSpotifyInstalled(context)) {
            Button richPresencePrimaryButton6 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton6 != null) {
                richPresencePrimaryButton6.setOnClickListener(ViewHolderMusicRichPresence$configureUi$4.INSTANCE);
                return;
            }
            return;
        }
        getRichPresenceTitle().setOnClickListener(new ViewHolderMusicRichPresence$configureUi$1(primaryActivity));
        Button richPresencePrimaryButton7 = getRichPresencePrimaryButton();
        if (richPresencePrimaryButton7 != null) {
            richPresencePrimaryButton7.setOnClickListener(new ViewHolderMusicRichPresence$configureUi$2(primaryActivity));
        }
        getRichPresenceImageLarge().setOnClickListener(new ViewHolderMusicRichPresence$configureUi$3(primaryActivity, user, isMe));
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    public void setTimeTextViews(ActivityTimestamps timestamps) {
        if (timestamps != null) {
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            long jB = timestamps.b() - timestamps.c();
            long jC = jCurrentTimeMillis >= timestamps.b() ? jB : jCurrentTimeMillis - timestamps.c();
            this.richPresenceSeekbar.setProgress((int) ((jC / jB) * ((double) 100.0f)));
            TextView textView = this.richPresenceMusicElapsed;
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            textView.setText(TimeUtils.toFriendlyStringSimple$default(timeUtils, jC, null, null, 4, null));
            this.richPresenceMusicDuration.setText(TimeUtils.toFriendlyStringSimple$default(timeUtils, jB, null, null, 4, null));
        }
    }
}
