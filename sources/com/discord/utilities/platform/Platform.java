package com.discord.utilities.platform;

import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import b.d.b.a.a;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.z.d.m;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum Platform {
    BATTLENET("Battle.net", 2131099687, 2130969440, 2131231466, false, false, false, 112, null),
    FACEBOOK("Facebook", 2131099876, 2130969441, 2131231472, false, false, true, 48, null),
    GITHUB("GitHub", 2131099910, 2130969442, 2131231474, false, false, true, 48, null),
    LEAGUEOFLEGENDS("League of Legends", 2131099945, 2130969443, 2131231476, false, false, false, 112, null),
    PLAYSTATION("PlayStation Network", 2131100120, 2130969444, 2131231479, false, true, true, 16, null),
    REDDIT("Reddit", 2131100268, 2130969445, 2131231481, false, false, true, 48, null),
    SAMSUNG("Samsung Galaxy", null, 2130969446, 2131231483, false, true, false, 82, null),
    SKYPE("Skype", 2131100280, 2130969447, 2131231485, false, false, false, 112, null),
    SPOTIFY("Spotify", 2131100282, 2130969448, 2131231487, false, true, true, 16, null),
    STEAM("Steam", 2131100424, 2130969449, 2131231489, false, false, true, 48, null),
    TWITCH("Twitch", 2131100439, 2130969450, 2131231491, false, false, true, 48, null),
    TWITTER("Twitter", 2131100441, 2130969451, 2131231493, false, false, true, 48, null),
    XBOX("Xbox", 2131100528, 2130969452, 2131231495, false, true, true, 16, null),
    YOUTUBE("YouTube", 2131100530, 2130969453, 2131231497, false, false, true, 48, null),
    NONE(null, null, null, null, false, false, false, Opcodes.LAND, null);

    public static final Platform$Companion Companion = new Platform$Companion(null);
    private final boolean canShowActivity;
    private final boolean canSyncFriends;
    private final Integer colorResId;
    private final boolean enabled;
    private final String platformId;
    private final String properName;
    private final Integer themedPlatformImage;
    private final Integer whitePlatformImage;

    Platform(@AttrRes String str, @DrawableRes Integer num, Integer num2, Integer num3, boolean z2, boolean z3, boolean z4) {
        this.properName = str;
        this.colorResId = num;
        this.themedPlatformImage = num2;
        this.whitePlatformImage = num3;
        this.canSyncFriends = z2;
        this.canShowActivity = z3;
        this.enabled = z4;
        String strName = name();
        Locale locale = Locale.ENGLISH;
        m.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
        Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strName.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        this.platformId = lowerCase;
    }

    public static final Platform from(ActivityPlatform activityPlatform) {
        return Companion.from(activityPlatform);
    }

    public static final Platform from(ConnectedAccount connectedAccount) {
        return Companion.from(connectedAccount);
    }

    public static final Platform from(String str) {
        return Companion.from(str);
    }

    public final boolean getCanShowActivity() {
        return this.canShowActivity;
    }

    public final boolean getCanSyncFriends() {
        return this.canSyncFriends;
    }

    public final Integer getColorResId() {
        return this.colorResId;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getPlatformId() {
        return this.platformId;
    }

    public final String getProfileUrl(ConnectedAccount connectedAccount) {
        m.checkNotNullParameter(connectedAccount, "connectedAccount");
        int iOrdinal = ordinal();
        if (iOrdinal == 2) {
            StringBuilder sbU = a.U("https://github.com/");
            sbU.append(connectedAccount.getName());
            return sbU.toString();
        }
        if (iOrdinal == 5) {
            StringBuilder sbU2 = a.U("https://reddit.com/u/");
            sbU2.append(connectedAccount.getName());
            return sbU2.toString();
        }
        if (iOrdinal == 13) {
            StringBuilder sbU3 = a.U("https://youtube.com/channel/");
            sbU3.append(connectedAccount.getId());
            return sbU3.toString();
        }
        switch (iOrdinal) {
            case 8:
                StringBuilder sbU4 = a.U("https://open.spotify.com/user/");
                sbU4.append(connectedAccount.getId());
                return sbU4.toString();
            case 9:
                StringBuilder sbU5 = a.U("https://steamcommunity.com/profiles/");
                sbU5.append(connectedAccount.getId());
                return sbU5.toString();
            case 10:
                StringBuilder sbU6 = a.U("https://twitch.tv/");
                sbU6.append(connectedAccount.getName());
                return sbU6.toString();
            case 11:
                StringBuilder sbU7 = a.U("https://www.twitter.com/");
                sbU7.append(connectedAccount.getName());
                return sbU7.toString();
            default:
                return null;
        }
    }

    public final String getProperName() {
        return this.properName;
    }

    public final Integer getThemedPlatformImage() {
        return this.themedPlatformImage;
    }

    public final Integer getWhitePlatformImage() {
        return this.whitePlatformImage;
    }

    /* synthetic */ Platform(String str, Integer num, Integer num2, Integer num3, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4);
    }
}
