package b.i.a.b.i.e;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.b.i.e.NetworkConnectionInfo;

/* JADX INFO: renamed from: b.i.a.b.i.e.i, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_NetworkConnectionInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {
    public final NetworkConnectionInfo.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NetworkConnectionInfo.a f752b;

    public AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.b bVar, NetworkConnectionInfo.a aVar, a aVar2) {
        this.a = bVar;
        this.f752b = aVar;
    }

    @Override // b.i.a.b.i.e.NetworkConnectionInfo
    @Nullable
    public NetworkConnectionInfo.a a() {
        return this.f752b;
    }

    @Override // b.i.a.b.i.e.NetworkConnectionInfo
    @Nullable
    public NetworkConnectionInfo.b b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.b bVar = this.a;
        if (bVar != null ? bVar.equals(networkConnectionInfo.b()) : networkConnectionInfo.b() == null) {
            NetworkConnectionInfo.a aVar = this.f752b;
            if (aVar == null) {
                if (networkConnectionInfo.a() == null) {
                    return true;
                }
            } else if (aVar.equals(networkConnectionInfo.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        NetworkConnectionInfo.b bVar = this.a;
        int iHashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        NetworkConnectionInfo.a aVar = this.f752b;
        return iHashCode ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("NetworkConnectionInfo{networkType=");
        sbU.append(this.a);
        sbU.append(", mobileSubtype=");
        sbU.append(this.f752b);
        sbU.append("}");
        return sbU.toString();
    }
}
