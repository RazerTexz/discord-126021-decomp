package b.i.a.b.i.e;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.b.i.e.ClientInfo2;

/* JADX INFO: renamed from: b.i.a.b.i.e.e, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_ClientInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_ClientInfo extends ClientInfo2 {
    public final ClientInfo2.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AndroidClientInfo f748b;

    public AutoValue_ClientInfo(ClientInfo2.a aVar, AndroidClientInfo androidClientInfo, a aVar2) {
        this.a = aVar;
        this.f748b = androidClientInfo;
    }

    @Override // b.i.a.b.i.e.ClientInfo2
    @Nullable
    public AndroidClientInfo a() {
        return this.f748b;
    }

    @Override // b.i.a.b.i.e.ClientInfo2
    @Nullable
    public ClientInfo2.a b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo2)) {
            return false;
        }
        ClientInfo2 clientInfo2 = (ClientInfo2) obj;
        ClientInfo2.a aVar = this.a;
        if (aVar != null ? aVar.equals(clientInfo2.b()) : clientInfo2.b() == null) {
            AndroidClientInfo androidClientInfo = this.f748b;
            if (androidClientInfo == null) {
                if (clientInfo2.a() == null) {
                    return true;
                }
            } else if (androidClientInfo.equals(clientInfo2.a())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo2.a aVar = this.a;
        int iHashCode = ((aVar == null ? 0 : aVar.hashCode()) ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.f748b;
        return iHashCode ^ (androidClientInfo != null ? androidClientInfo.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ClientInfo{clientType=");
        sbU.append(this.a);
        sbU.append(", androidClientInfo=");
        sbU.append(this.f748b);
        sbU.append("}");
        return sbU.toString();
    }
}
