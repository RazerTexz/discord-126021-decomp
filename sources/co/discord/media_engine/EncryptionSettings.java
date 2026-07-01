package co.discord.media_engine;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Arrays;

/* JADX INFO: compiled from: EncryptionSettings.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EncryptionSettings {
    private final String mode;
    private final int[] secretKey;

    public EncryptionSettings(String str, int[] iArr) {
        Intrinsics3.checkNotNullParameter(str, "mode");
        Intrinsics3.checkNotNullParameter(iArr, "secretKey");
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
        Intrinsics3.checkNotNullParameter(mode, "mode");
        Intrinsics3.checkNotNullParameter(secretKey, "secretKey");
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
        return Intrinsics3.areEqual(this.mode, encryptionSettings.mode) && Intrinsics3.areEqual(this.secretKey, encryptionSettings.secretKey);
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
        StringBuilder sbU = outline.U("EncryptionSettings(mode=");
        sbU.append(this.mode);
        sbU.append(", secretKey=");
        sbU.append(Arrays.toString(this.secretKey));
        sbU.append(")");
        return sbU.toString();
    }
}
