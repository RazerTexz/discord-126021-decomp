package com.discord.utilities.platform;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BATTLENET' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Platform {
    private static final /* synthetic */ Platform[] $VALUES;
    public static final Platform BATTLENET;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final Platform FACEBOOK;
    public static final Platform GITHUB;
    public static final Platform LEAGUEOFLEGENDS;
    public static final Platform NONE;
    public static final Platform PLAYSTATION;
    public static final Platform REDDIT;
    public static final Platform SAMSUNG;
    public static final Platform SKYPE;
    public static final Platform SPOTIFY;
    public static final Platform STEAM;
    public static final Platform TWITCH;
    public static final Platform TWITTER;
    public static final Platform XBOX;
    public static final Platform YOUTUBE;
    private final boolean canShowActivity;
    private final boolean canSyncFriends;
    private final Integer colorResId;
    private final boolean enabled;
    private final String platformId;
    private final String properName;
    private final Integer themedPlatformImage;
    private final Integer whitePlatformImage;

    /* JADX INFO: compiled from: Platform.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                ActivityPlatform.values();
                int[] iArr = new int[9];
                $EnumSwitchMapping$0 = iArr;
                iArr[ActivityPlatform.SAMSUNG.ordinal()] = 1;
                iArr[ActivityPlatform.SPOTIFY.ordinal()] = 2;
                iArr[ActivityPlatform.XBOX.ordinal()] = 3;
                iArr[ActivityPlatform.PS4.ordinal()] = 4;
                iArr[ActivityPlatform.PS5.ordinal()] = 5;
            }
        }

        private Companion() {
        }

        public final Platform from(ActivityPlatform activityPlatform) {
            if (activityPlatform != null) {
                int iOrdinal = activityPlatform.ordinal();
                if (iOrdinal == 1) {
                    return Platform.XBOX;
                }
                if (iOrdinal == 4) {
                    return Platform.SAMSUNG;
                }
                if (iOrdinal == 5) {
                    return Platform.SPOTIFY;
                }
                if (iOrdinal == 6) {
                    return Platform.PLAYSTATION;
                }
                if (iOrdinal == 7) {
                    return Platform.PLAYSTATION;
                }
            }
            return Platform.NONE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Platform from(String platformName) {
            Intrinsics3.checkNotNullParameter(platformName, "platformName");
            try {
                String string = Strings4.trim(platformName).toString();
                Locale locale = Locale.ENGLISH;
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String upperCase = string.toUpperCase(locale);
                Intrinsics3.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                return Platform.valueOf(upperCase);
            } catch (Exception unused) {
                return Platform.NONE;
            }
        }

        public final Platform from(ConnectedAccount connectedAccount) {
            Intrinsics3.checkNotNullParameter(connectedAccount, "connectedAccount");
            return from(connectedAccount.getType());
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Platform.values();
            int[] iArr = new int[15];
            $EnumSwitchMapping$0 = iArr;
            iArr[Platform.GITHUB.ordinal()] = 1;
            iArr[Platform.REDDIT.ordinal()] = 2;
            iArr[Platform.SPOTIFY.ordinal()] = 3;
            iArr[Platform.STEAM.ordinal()] = 4;
            iArr[Platform.TWITCH.ordinal()] = 5;
            iArr[Platform.TWITTER.ordinal()] = 6;
            iArr[Platform.YOUTUBE.ordinal()] = 7;
        }
    }

    static {
        boolean z2 = false;
        Platform platform = new Platform("BATTLENET", 0, "Battle.net", Integer.valueOf(R.color.battlenet), Integer.valueOf(R.attr.ic_account_battlenet), Integer.valueOf(R.drawable.ic_account_battlenet_white_24dp), false, false, z2, 112, null);
        BATTLENET = platform;
        Platform platform2 = new Platform("FACEBOOK", 1, "Facebook", Integer.valueOf(R.color.facebook), Integer.valueOf(R.attr.ic_account_facebook), Integer.valueOf(R.drawable.ic_account_facebook_white_24dp), false, false, true, 48, null);
        FACEBOOK = platform2;
        boolean z3 = false;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Platform platform3 = new Platform("GITHUB", 2, "GitHub", Integer.valueOf(R.color.github), Integer.valueOf(R.attr.ic_account_github), Integer.valueOf(R.drawable.ic_account_github_white_24dp), z2, z3, true, 48, defaultConstructorMarker);
        GITHUB = platform3;
        Platform platform4 = new Platform("LEAGUEOFLEGENDS", 3, "League of Legends", Integer.valueOf(R.color.league_of_legends), Integer.valueOf(R.attr.ic_account_league_of_legends), Integer.valueOf(R.drawable.ic_account_league_of_legends_white_24dp), z2, z3, false, 112, defaultConstructorMarker);
        LEAGUEOFLEGENDS = platform4;
        boolean z4 = true;
        Platform platform5 = new Platform("PLAYSTATION", 4, "PlayStation Network", Integer.valueOf(R.color.playstation), Integer.valueOf(R.attr.ic_account_playstation), Integer.valueOf(R.drawable.ic_account_playstation_white_24dp), z2, true, z4, 16, defaultConstructorMarker);
        PLAYSTATION = platform5;
        Platform platform6 = new Platform("REDDIT", 5, "Reddit", Integer.valueOf(R.color.reddit), Integer.valueOf(R.attr.ic_account_reddit), Integer.valueOf(R.drawable.ic_account_reddit_white_24dp), z2, false, z4, 48, defaultConstructorMarker);
        REDDIT = platform6;
        boolean z5 = false;
        Platform platform7 = new Platform("SAMSUNG", 6, "Samsung Galaxy", null, Integer.valueOf(R.attr.ic_account_samsung), Integer.valueOf(R.drawable.ic_account_samsung_white_24dp), z2, true, z5, 82, defaultConstructorMarker);
        SAMSUNG = platform7;
        Platform platform8 = new Platform("SKYPE", 7, "Skype", Integer.valueOf(R.color.skype), Integer.valueOf(R.attr.ic_account_skype), Integer.valueOf(R.drawable.ic_account_skype_white_24dp), z2, false, z5, 112, defaultConstructorMarker);
        SKYPE = platform8;
        boolean z6 = true;
        Platform platform9 = new Platform("SPOTIFY", 8, "Spotify", Integer.valueOf(R.color.spotify), Integer.valueOf(R.attr.ic_account_spotify), Integer.valueOf(R.drawable.ic_account_spotify_white_24dp), z2, true, z6, 16, defaultConstructorMarker);
        SPOTIFY = platform9;
        boolean z7 = false;
        int i = 48;
        Platform platform10 = new Platform("STEAM", 9, "Steam", Integer.valueOf(R.color.steam), Integer.valueOf(R.attr.ic_account_steam), Integer.valueOf(R.drawable.ic_account_steam_white_24dp), z2, z7, z6, i, defaultConstructorMarker);
        STEAM = platform10;
        Platform platform11 = new Platform("TWITCH", 10, "Twitch", Integer.valueOf(R.color.twitch), Integer.valueOf(R.attr.ic_account_twitch), Integer.valueOf(R.drawable.ic_account_twitch_white_24dp), z2, z7, z6, i, defaultConstructorMarker);
        TWITCH = platform11;
        Platform platform12 = new Platform("TWITTER", 11, "Twitter", Integer.valueOf(R.color.twitter), Integer.valueOf(R.attr.ic_account_twitter), Integer.valueOf(R.drawable.ic_account_twitter_white_24dp), z2, z7, z6, i, defaultConstructorMarker);
        TWITTER = platform12;
        Platform platform13 = new Platform("XBOX", 12, "Xbox", Integer.valueOf(R.color.xbox), Integer.valueOf(R.attr.ic_account_xbox), Integer.valueOf(R.drawable.ic_account_xbox_white_24dp), z2, true, z6, 16, defaultConstructorMarker);
        XBOX = platform13;
        boolean z8 = false;
        Platform platform14 = new Platform("YOUTUBE", 13, "YouTube", Integer.valueOf(R.color.youtube), Integer.valueOf(R.attr.ic_account_youtube), Integer.valueOf(R.drawable.ic_account_youtube_white_24dp), z2, z8, z6, 48, defaultConstructorMarker);
        YOUTUBE = platform14;
        Platform platform15 = new Platform("NONE", 14, null, null, null, null, z2, z8, false, Opcodes.LAND, defaultConstructorMarker);
        NONE = platform15;
        $VALUES = new Platform[]{platform, platform2, platform3, platform4, platform5, platform6, platform7, platform8, platform9, platform10, platform11, platform12, platform13, platform14, platform15};
        INSTANCE = new Companion(null);
    }

    private Platform(String str, @ColorRes int i, @AttrRes String str2, @DrawableRes Integer num, Integer num2, Integer num3, boolean z2, boolean z3, boolean z4) {
        super(str, i);
        this.properName = str2;
        this.colorResId = num;
        this.themedPlatformImage = num2;
        this.whitePlatformImage = num3;
        this.canSyncFriends = z2;
        this.canShowActivity = z3;
        this.enabled = z4;
        String strName = name();
        Locale locale = Locale.ENGLISH;
        Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
        Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strName.toLowerCase(locale);
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        this.platformId = lowerCase;
    }

    public static final Platform from(ActivityPlatform activityPlatform) {
        return INSTANCE.from(activityPlatform);
    }

    public static final Platform from(ConnectedAccount connectedAccount) {
        return INSTANCE.from(connectedAccount);
    }

    public static final Platform from(String str) {
        return INSTANCE.from(str);
    }

    public static Platform valueOf(String str) {
        return (Platform) Enum.valueOf(Platform.class, str);
    }

    public static Platform[] values() {
        return (Platform[]) $VALUES.clone();
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
        Intrinsics3.checkNotNullParameter(connectedAccount, "connectedAccount");
        int iOrdinal = ordinal();
        if (iOrdinal == 2) {
            StringBuilder sbU = outline.U("https://github.com/");
            sbU.append(connectedAccount.getName());
            return sbU.toString();
        }
        if (iOrdinal == 5) {
            StringBuilder sbU2 = outline.U("https://reddit.com/u/");
            sbU2.append(connectedAccount.getName());
            return sbU2.toString();
        }
        if (iOrdinal == 13) {
            StringBuilder sbU3 = outline.U("https://youtube.com/channel/");
            sbU3.append(connectedAccount.getId());
            return sbU3.toString();
        }
        switch (iOrdinal) {
            case 8:
                StringBuilder sbU4 = outline.U("https://open.spotify.com/user/");
                sbU4.append(connectedAccount.getId());
                return sbU4.toString();
            case 9:
                StringBuilder sbU5 = outline.U("https://steamcommunity.com/profiles/");
                sbU5.append(connectedAccount.getId());
                return sbU5.toString();
            case 10:
                StringBuilder sbU6 = outline.U("https://twitch.tv/");
                sbU6.append(connectedAccount.getName());
                return sbU6.toString();
            case 11:
                StringBuilder sbU7 = outline.U("https://www.twitter.com/");
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

    public /* synthetic */ Platform(String str, int i, String str2, Integer num, Integer num2, Integer num3, boolean z2, boolean z3, boolean z4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 1) != 0 ? "" : str2, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : num3, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? false : z3, (i2 & 64) != 0 ? false : z4);
    }
}
