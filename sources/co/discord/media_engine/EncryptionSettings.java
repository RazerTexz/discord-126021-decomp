package co.discord.media_engine;

import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EncryptionSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EncryptionSettings {
    private final String mode;
    private final int[] secretKey;

    public EncryptionSettings(String str, int[] iArr) {
        C12238m.checkNotNullParameter(str, "mode");
        C12238m.checkNotNullParameter(iArr, "secretKey");
        this.mode = str;
        this.secretKey = iArr;
    }

    public static /* synthetic */ EncryptionSettings copy$default(EncryptionSettings encryptionSettings, String str, int[] iArr, int i, Object obj) {
        if ((i & 1) != 0) {
            str = encryptionSettings.mode;
        }
        if ((i & 2) != 0) {
            iArr = encryptionSettings.secretKey;
        }
        return encryptionSettings.copy(str, iArr);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int[] getSecretKey() {
        return this.secretKey;
    }

    public final EncryptionSettings copy(String mode, int[] secretKey) {
        C12238m.checkNotNullParameter(mode, "mode");
        C12238m.checkNotNullParameter(secretKey, "secretKey");
        return new EncryptionSettings(mode, secretKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EncryptionSettings)) {
            return false;
        }
        EncryptionSettings encryptionSettings = (EncryptionSettings) other;
        return C12238m.areEqual(this.mode, encryptionSettings.mode) && C12238m.areEqual(this.secretKey, encryptionSettings.secretKey);
    }

    public final String getMode() {
        return this.mode;
    }

    public final int[] getSecretKey() {
        return this.secretKey;
    }

    public int hashCode() {
        String str = this.mode;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        int[] iArr = this.secretKey;
        return iHashCode + (iArr != null ? Arrays.hashCode(iArr) : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("EncryptionSettings(mode=");
        sbM833U.append(this.mode);
        sbM833U.append(", secretKey=");
        sbM833U.append(Arrays.toString(this.secretKey));
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
