package b.i.c.u.p;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.c.u.p.InstallationResponse;

/* JADX INFO: renamed from: b.i.c.u.p.a, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_InstallationResponse.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_InstallationResponse extends InstallationResponse {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1788b;
    public final String c;
    public final TokenResult d;
    public final InstallationResponse.a e;

    public AutoValue_InstallationResponse(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.a aVar, a aVar2) {
        this.a = str;
        this.f1788b = str2;
        this.c = str3;
        this.d = tokenResult;
        this.e = aVar;
    }

    @Override // b.i.c.u.p.InstallationResponse
    @Nullable
    public TokenResult a() {
        return this.d;
    }

    @Override // b.i.c.u.p.InstallationResponse
    @Nullable
    public String b() {
        return this.f1788b;
    }

    @Override // b.i.c.u.p.InstallationResponse
    @Nullable
    public String c() {
        return this.c;
    }

    @Override // b.i.c.u.p.InstallationResponse
    @Nullable
    public InstallationResponse.a d() {
        return this.e;
    }

    @Override // b.i.c.u.p.InstallationResponse
    @Nullable
    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.a;
        if (str != null ? str.equals(installationResponse.e()) : installationResponse.e() == null) {
            String str2 = this.f1788b;
            if (str2 != null ? str2.equals(installationResponse.b()) : installationResponse.b() == null) {
                String str3 = this.c;
                if (str3 != null ? str3.equals(installationResponse.c()) : installationResponse.c() == null) {
                    TokenResult tokenResult = this.d;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.a()) : installationResponse.a() == null) {
                        InstallationResponse.a aVar = this.e;
                        if (aVar == null) {
                            if (installationResponse.d() == null) {
                                return true;
                            }
                        } else if (aVar.equals(installationResponse.d())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f1788b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.d;
        int iHashCode4 = (iHashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        InstallationResponse.a aVar = this.e;
        return iHashCode4 ^ (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InstallationResponse{uri=");
        sbU.append(this.a);
        sbU.append(", fid=");
        sbU.append(this.f1788b);
        sbU.append(", refreshToken=");
        sbU.append(this.c);
        sbU.append(", authToken=");
        sbU.append(this.d);
        sbU.append(", responseCode=");
        sbU.append(this.e);
        sbU.append("}");
        return sbU.toString();
    }
}
