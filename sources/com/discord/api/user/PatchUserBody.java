package com.discord.api.user;

import b.d.b.a.a;
import com.discord.nullserializable.NullSerializable;
import d0.z.d.m;

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
        return m.areEqual(this.avatar, patchUserBody.avatar) && m.areEqual(this.banner, patchUserBody.banner) && m.areEqual(this.bannerColor, patchUserBody.bannerColor) && m.areEqual(this.bio, patchUserBody.bio);
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
        StringBuilder sbU = a.U("PatchUserBody(avatar=");
        sbU.append(this.avatar);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", bannerColor=");
        sbU.append(this.bannerColor);
        sbU.append(", bio=");
        sbU.append(this.bio);
        sbU.append(")");
        return sbU.toString();
    }

    public PatchUserBody(NullSerializable<String> nullSerializable, NullSerializable<String> nullSerializable2, NullSerializable<String> nullSerializable3, NullSerializable<String> nullSerializable4) {
        this.avatar = nullSerializable;
        this.banner = nullSerializable2;
        this.bannerColor = nullSerializable3;
        this.bio = nullSerializable4;
    }
}
