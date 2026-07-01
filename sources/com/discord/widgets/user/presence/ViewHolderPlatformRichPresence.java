package com.discord.widgets.user.presence;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.application.Application;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserConnections$State;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.playstation.PlaystationExperimentUtilsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: ViewHolderPlatformRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderPlatformRichPresence extends ViewHolderUserRichPresence {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderPlatformRichPresence(View view, SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2, TextView textView, TextView textView2, TextView textView3, View view2, Button button) {
        super(view, simpleDraweeView, simpleDraweeView2, textView, textView2, null, textView3, null, view2, button, null, 3);
        m.checkNotNullParameter(view, "root");
        m.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        m.checkNotNullParameter(simpleDraweeView2, "richPresenceImageSmall");
        m.checkNotNullParameter(textView, "richPresenceHeader");
        m.checkNotNullParameter(textView2, "richPresenceTitle");
        m.checkNotNullParameter(textView3, "richPresenceTime");
        m.checkNotNullParameter(view2, "richPresenceTextContainer");
        m.checkNotNullParameter(button, "richPresencePrimaryButton");
    }

    private final void configureImages(Platform platform, ModelRichPresence richPresence) {
        Application primaryApplication;
        String applicationIcon$default = null;
        super.configureAssetUi(richPresence != null ? richPresence.getPrimaryActivity() : null, null);
        if (platform == Platform.PLAYSTATION) {
            return;
        }
        if (platform == Platform.XBOX && platform.getThemedPlatformImage() != null) {
            MGImages.setImage$default(MGImages.INSTANCE, getRichPresenceImageLarge(), DrawableCompat.getThemedDrawableRes$default(getRichPresenceImageLarge(), platform.getThemedPlatformImage().intValue(), 0, 2, (Object) null), (MGImages$ChangeDetector) null, 4, (Object) null);
            getRichPresenceImageLarge().setVisibility(0);
            return;
        }
        Integer whitePlatformImage = platform.getWhitePlatformImage();
        SimpleDraweeView richPresenceImageSmall = getRichPresenceImageSmall();
        if (richPresenceImageSmall != null) {
            ViewKt.setVisible(richPresenceImageSmall, (whitePlatformImage == null || platform == Platform.NONE) ? false : true);
        }
        if (platform != Platform.NONE) {
            SimpleDraweeView richPresenceImageSmall2 = getRichPresenceImageSmall();
            Resources resources = richPresenceImageSmall2 != null ? richPresenceImageSmall2.getResources() : null;
            Drawable drawable = (whitePlatformImage == null || resources == null) ? null : ResourcesCompat.getDrawable(resources, whitePlatformImage.intValue(), null);
            SimpleDraweeView richPresenceImageSmall3 = getRichPresenceImageSmall();
            if (richPresenceImageSmall3 != null) {
                richPresenceImageSmall3.setImageDrawable(drawable);
            }
        }
        if (getRichPresenceImageLarge().getVisibility() != 0) {
            if (richPresence != null && (primaryApplication = richPresence.getPrimaryApplication()) != null) {
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

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    @MainThread
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        boolean z2;
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(applicationContext, "applicationContext");
        disposeSubscriptions();
        Activity primaryActivity = richPresence != null ? richPresence.getPrimaryActivity() : null;
        if (primaryActivity == null || !ActivityUtilsKt.isGamePlatform(primaryActivity)) {
            getRoot().setVisibility(8);
            return;
        }
        getRoot().setVisibility(0);
        Platform platformFrom = ActivityUtilsKt.isXboxActivity(primaryActivity) ? Platform.XBOX : Platform.Companion.from(primaryActivity.getPlatform());
        TextView richPresenceHeader = getRichPresenceHeader();
        Context context = getRichPresenceHeader().getContext();
        m.checkNotNullExpressionValue(context, "richPresenceHeader.context");
        richPresenceHeader.setText(PresenceUtils.getActivityHeader(context, primaryActivity));
        getRichPresenceTitle().setText(primaryActivity.getName());
        TextView richPresenceTime = getRichPresenceTime();
        ActivityTimestamps timestamps = primaryActivity.getTimestamps();
        ViewExtensions.setTextAndVisibilityBy(richPresenceTime, timestamps != null ? friendlyTime(timestamps) : null);
        getRichPresenceTextContainer().setSelected(true);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        boolean zCanSeePlaystationAccountIntegration = PlaystationExperimentUtilsKt.canSeePlaystationAccountIntegration(storeStream$Companion.getExperiments());
        if (!platformFrom.getEnabled() || (platformFrom == Platform.PLAYSTATION && !zCanSeePlaystationAccountIntegration)) {
            Button richPresencePrimaryButton = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton != null) {
                ViewKt.setVisible(richPresencePrimaryButton, false);
            }
            Button richPresencePrimaryButton2 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton2 != null) {
                richPresencePrimaryButton2.setOnClickListener(null);
            }
        } else {
            StoreUserConnections userConnections = storeStream$Companion.getUserConnections();
            StoreUserConnections$State stateSnapshot = userConnections.getStateSnapshot();
            if (!(stateSnapshot instanceof Collection) || !stateSnapshot.isEmpty()) {
                Iterator<ConnectedAccount> it = stateSnapshot.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    String type = it.next().getType();
                    String strName = platformFrom.name();
                    Locale locale = Locale.ENGLISH;
                    m.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
                    Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
                    String lowerCase = strName.toLowerCase(locale);
                    m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    if (m.areEqual(type, lowerCase)) {
                        z2 = true;
                        break;
                    }
                }
            } else {
                z2 = false;
                break;
            }
            Button richPresencePrimaryButton3 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton3 != null) {
                ViewKt.setVisible(richPresencePrimaryButton3, !z2);
            }
            Button richPresencePrimaryButton4 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton4 != null) {
                Context context2 = getRoot().getContext();
                m.checkNotNullExpressionValue(context2, "root.context");
                richPresencePrimaryButton4.setText(b.h(context2, 2131896723, new Object[]{platformFrom.getProperName()}, null, 4));
            }
            Button richPresencePrimaryButton5 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton5 != null) {
                richPresencePrimaryButton5.setOnClickListener(new ViewHolderPlatformRichPresence$configureUi$1(userConnections, platformFrom));
            }
        }
        configureImages(platformFrom, richPresence);
    }
}
