package com.discord.widgets.friends;

import b.d.b.a.a;
import com.discord.utilities.error.Error;
import d0.z.d.m;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class FriendsListViewModel$Event$CaptchaError extends FriendsListViewModel$Event {
    private final int discriminator;
    private final Error error;
    private final String username;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$Event$CaptchaError(Error error, String str, int i) {
        super(null);
        m.checkNotNullParameter(error, "error");
        m.checkNotNullParameter(str, "username");
        this.error = error;
        this.username = str;
        this.discriminator = i;
    }

    public static /* synthetic */ FriendsListViewModel$Event$CaptchaError copy$default(FriendsListViewModel$Event$CaptchaError friendsListViewModel$Event$CaptchaError, Error error, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            error = friendsListViewModel$Event$CaptchaError.error;
        }
        if ((i2 & 2) != 0) {
            str = friendsListViewModel$Event$CaptchaError.username;
        }
        if ((i2 & 4) != 0) {
            i = friendsListViewModel$Event$CaptchaError.discriminator;
        }
        return friendsListViewModel$Event$CaptchaError.copy(error, str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Error getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDiscriminator() {
        return this.discriminator;
    }

    public final FriendsListViewModel$Event$CaptchaError copy(Error error, String username, int discriminator) {
        m.checkNotNullParameter(error, "error");
        m.checkNotNullParameter(username, "username");
        return new FriendsListViewModel$Event$CaptchaError(error, username, discriminator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsListViewModel$Event$CaptchaError)) {
            return false;
        }
        FriendsListViewModel$Event$CaptchaError friendsListViewModel$Event$CaptchaError = (FriendsListViewModel$Event$CaptchaError) other;
        return m.areEqual(this.error, friendsListViewModel$Event$CaptchaError.error) && m.areEqual(this.username, friendsListViewModel$Event$CaptchaError.username) && this.discriminator == friendsListViewModel$Event$CaptchaError.discriminator;
    }

    public final int getDiscriminator() {
        return this.discriminator;
    }

    public final Error getError() {
        return this.error;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        Error error = this.error;
        int iHashCode = (error != null ? error.hashCode() : 0) * 31;
        String str = this.username;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.discriminator;
    }

    public String toString() {
        StringBuilder sbU = a.U("CaptchaError(error=");
        sbU.append(this.error);
        sbU.append(", username=");
        sbU.append(this.username);
        sbU.append(", discriminator=");
        return a.B(sbU, this.discriminator, ")");
    }
}
