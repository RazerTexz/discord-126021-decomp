package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.models.user.User;
import com.discord.utilities.integrations.SpotifyHelper;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;

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
        Intrinsics3.checkNotNullParameter(view, "root");
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        Intrinsics3.checkNotNullParameter(simpleDraweeView2, "richPresenceImageSmall");
        Intrinsics3.checkNotNullParameter(textView, "richPresenceHeader");
        Intrinsics3.checkNotNullParameter(textView2, "richPresenceTitle");
        Intrinsics3.checkNotNullParameter(textView3, "richPresenceDetails");
        Intrinsics3.checkNotNullParameter(textView4, "richPresenceTime");
        Intrinsics3.checkNotNullParameter(view2, "richPresenceTextContainer");
        Intrinsics3.checkNotNullParameter(button, "richPresencePrimaryButton");
        Intrinsics3.checkNotNullParameter(seekBar, "richPresenceSeekbar");
        Intrinsics3.checkNotNullParameter(textView5, "richPresenceMusicDuration");
        Intrinsics3.checkNotNullParameter(textView6, "richPresenceMusicElapsed");
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
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, final boolean isMe, final User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(applicationContext, "applicationContext");
        disposeTimer();
        Context context = getRoot().getContext();
        final Activity primaryActivity = richPresence != null ? richPresence.getPrimaryActivity() : null;
        if (primaryActivity == null || !ActivityUtils.isRichPresence(primaryActivity)) {
            getRoot().setVisibility(8);
            return;
        }
        getRoot().setVisibility(0);
        boolean zEquals = StringsJVM.equals(primaryActivity.getName(), ActivityPlatform.SPOTIFY.name(), true);
        String state = primaryActivity.getState();
        String strReplace$default = state != null ? StringsJVM.replace$default(state, ';', ',', false, 4, (Object) null) : null;
        TextView richPresenceHeader = getRichPresenceHeader();
        Context context2 = getRichPresenceHeader().getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "richPresenceHeader.context");
        richPresenceHeader.setText(PresenceUtils.getActivityHeader(context2, primaryActivity));
        getRichPresenceTitle().setText(primaryActivity.getDetails());
        TextView richPresenceDetails = getRichPresenceDetails();
        if (richPresenceDetails != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            ViewExtensions.setTextAndVisibilityBy(richPresenceDetails, FormatUtils.b(context, R.string.user_activity_listening_artists, new Object[]{strReplace$default}, (4 & 4) != 0 ? FormatUtils.b.j : null));
        }
        TextView richPresenceTime = getRichPresenceTime();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        Object[] objArr = new Object[1];
        ActivityAssets assets = primaryActivity.getAssets();
        objArr[0] = assets != null ? assets.getLargeText() : null;
        ViewExtensions.setTextAndVisibilityBy(richPresenceTime, FormatUtils.b(context, R.string.user_activity_listening_album, objArr, (4 & 4) != 0 ? FormatUtils.b.j : null));
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
                FormatUtils.m(richPresencePrimaryButton2, R.string.user_activity_cannot_play_self, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
            }
            Button richPresencePrimaryButton3 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton3 != null) {
                richPresencePrimaryButton3.setEnabled(false);
            }
        } else {
            Button richPresencePrimaryButton4 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton4 != null) {
                FormatUtils.m(richPresencePrimaryButton4, R.string.user_activity_play_on_platform, new Object[]{primaryActivity.getName()}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            }
            Button richPresencePrimaryButton5 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton5 != null) {
                richPresencePrimaryButton5.setEnabled(true);
            }
        }
        if (!SpotifyHelper.INSTANCE.isSpotifyInstalled(context)) {
            Button richPresencePrimaryButton6 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton6 != null) {
                richPresencePrimaryButton6.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.presence.ViewHolderMusicRichPresence.configureUi.4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SpotifyHelper spotifyHelper = SpotifyHelper.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(view, "it");
                        Context context3 = view.getContext();
                        Intrinsics3.checkNotNullExpressionValue(context3, "it.context");
                        spotifyHelper.openPlayStoreForSpotify(context3);
                    }
                });
                return;
            }
            return;
        }
        getRichPresenceTitle().setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.presence.ViewHolderMusicRichPresence.configureUi.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyHelper.INSTANCE.launchTrack(outline.x(view, "it", "it.context"), primaryActivity);
            }
        });
        Button richPresencePrimaryButton7 = getRichPresencePrimaryButton();
        if (richPresencePrimaryButton7 != null) {
            richPresencePrimaryButton7.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.presence.ViewHolderMusicRichPresence.configureUi.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SpotifyHelper.INSTANCE.launchTrack(outline.x(view, "it", "it.context"), primaryActivity);
                }
            });
        }
        getRichPresenceImageLarge().setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.presence.ViewHolderMusicRichPresence.configureUi.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpotifyHelper spotifyHelper = SpotifyHelper.INSTANCE;
                Context contextX = outline.x(view, "it", "it.context");
                Activity activity = primaryActivity;
                User user2 = user;
                spotifyHelper.launchAlbum(contextX, activity, user2 != null ? user2.getId() : 0L, isMe);
            }
        });
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
