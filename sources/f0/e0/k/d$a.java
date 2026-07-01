package f0.e0.k;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.Conscrypt;
import org.conscrypt.Conscrypt$Version;

/* JADX INFO: compiled from: ConscryptPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a {
    public d$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final boolean a(int i, int i2, int i3) {
        Conscrypt$Version conscrypt$VersionVersion = Conscrypt.version();
        if (conscrypt$VersionVersion.major() != i) {
            return conscrypt$VersionVersion.major() > i;
        }
        if (conscrypt$VersionVersion.minor() != i2) {
            return conscrypt$VersionVersion.minor() > i2;
        }
        return conscrypt$VersionVersion.patch() >= i3;
    }
}
