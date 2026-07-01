package com.discord.views;

import androidx.annotation.DrawableRes;

/* JADX INFO: compiled from: ActiveSubscriptionView.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum ActiveSubscriptionView$ActiveSubscriptionType {
    PREMIUM_BASIC(2130969613, 2131232421, 2131232438, 2131232436, 2131231018, 2131231026, 2131231025),
    PREMIUM_CLASSIC(2130969614, 2131232423, 2131232426, 2131232424, 2131231020, 2131231026, 2131231025),
    PREMIUM(2130969616, 2131232435, 2131232438, 2131232436, 2131231024, 2131231026, 2131231025),
    PREMIUM_GUILD(2130969615, 2131232427, 2131232430, 2131232428, 2131231021, 2131231023, 2131231022),
    PREMIUM_AND_PREMIUM_GUILD(2130969603, 2131232420, 2131232420, 2131232420, 2131231019, 2131231026, 2131231025);

    private final int headerBackground;
    private final int headerBackgroundError;
    private final int headerBackgroundResub;
    private final int headerImage;
    private final int headerImageError;
    private final int headerImageResub;
    private final int headerLogo;

    ActiveSubscriptionView$ActiveSubscriptionType(@DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4, @DrawableRes int i5, int i6, int i7) {
        this.headerLogo = i;
        this.headerImage = i2;
        this.headerImageResub = i3;
        this.headerImageError = i4;
        this.headerBackground = i5;
        this.headerBackgroundResub = i6;
        this.headerBackgroundError = i7;
    }

    public final int getHeaderBackground() {
        return this.headerBackground;
    }

    public final int getHeaderBackgroundError() {
        return this.headerBackgroundError;
    }

    public final int getHeaderBackgroundResub() {
        return this.headerBackgroundResub;
    }

    public final int getHeaderImage() {
        return this.headerImage;
    }

    public final int getHeaderImageError() {
        return this.headerImageError;
    }

    public final int getHeaderImageResub() {
        return this.headerImageResub;
    }

    public final int getHeaderLogo() {
        return this.headerLogo;
    }
}
