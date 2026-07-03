package com.discord.api.user;

import com.discord.nullserializable.NullSerializable;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: PatchUserBody.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class PatchUserBody {
    private final NullSerializable<String> avatar;
    private final NullSerializable<String> banner;
    private final NullSerializable<String> bannerColor;
    private final NullSerializable<String> bio;

    public PatchUserBody() {
        this.avatar = null;
        this.banner = null;
        this.bannerColor = null;
        this.bio = null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PatchUserBody)) {
            return false;
        }
        PatchUserBody patchUserBody = (PatchUserBody) other;
        return C12238m.areEqual(this.avatar, patchUserBody.avatar) && C12238m.areEqual(this.banner, patchUserBody.banner) && C12238m.areEqual(this.bannerColor, patchUserBody.bannerColor) && C12238m.areEqual(this.bio, patchUserBody.bio);
    }

    public int hashCode() {
        NullSerializable<String> nullSerializable = this.avatar;
        int iHashCode = (nullSerializable != null ? nullSerializable.hashCode() : 0) * 31;
        NullSerializable<String> nullSerializable2 = this.banner;
        int iHashCode2 = (iHashCode + (nullSerializable2 != null ? nullSerializable2.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable3 = this.bannerColor;
        int iHashCode3 = (iHashCode2 + (nullSerializable3 != null ? nullSerializable3.hashCode() : 0)) * 31;
        NullSerializable<String> nullSerializable4 = this.bio;
        return iHashCode3 + (nullSerializable4 != null ? nullSerializable4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("PatchUserBody(avatar=");
        sbM833U.append(this.avatar);
        sbM833U.append(", banner=");
        sbM833U.append(this.banner);
        sbM833U.append(", bannerColor=");
        sbM833U.append(this.bannerColor);
        sbM833U.append(", bio=");
        sbM833U.append(this.bio);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public PatchUserBody(NullSerializable<String> nullSerializable, NullSerializable<String> nullSerializable2, NullSerializable<String> nullSerializable3, NullSerializable<String> nullSerializable4) {
        this.avatar = nullSerializable;
        this.banner = nullSerializable2;
        this.bannerColor = nullSerializable3;
        this.bio = nullSerializable4;
    }
}
