package b.i.a.b.i.e;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AutoValue_AndroidClientInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    public final Integer a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f747b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    public c(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, c$a c_a) {
        this.a = num;
        this.f747b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = str7;
        this.i = str8;
        this.j = str9;
        this.k = str10;
        this.l = str11;
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public String a() {
        return this.l;
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public String b() {
        return this.j;
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public String c() {
        return this.d;
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public String d() {
        return this.h;
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        Integer num = this.a;
        if (num != null ? num.equals(aVar.l()) : aVar.l() == null) {
            String str = this.f747b;
            if (str != null ? str.equals(aVar.i()) : aVar.i() == null) {
                String str2 = this.c;
                if (str2 != null ? str2.equals(aVar.e()) : aVar.e() == null) {
                    String str3 = this.d;
                    if (str3 != null ? str3.equals(aVar.c()) : aVar.c() == null) {
                        String str4 = this.e;
                        if (str4 != null ? str4.equals(aVar.k()) : aVar.k() == null) {
                            String str5 = this.f;
                            if (str5 != null ? str5.equals(aVar.j()) : aVar.j() == null) {
                                String str6 = this.g;
                                if (str6 != null ? str6.equals(aVar.g()) : aVar.g() == null) {
                                    String str7 = this.h;
                                    if (str7 != null ? str7.equals(aVar.d()) : aVar.d() == null) {
                                        String str8 = this.i;
                                        if (str8 != null ? str8.equals(aVar.f()) : aVar.f() == null) {
                                            String str9 = this.j;
                                            if (str9 != null ? str9.equals(aVar.b()) : aVar.b() == null) {
                                                String str10 = this.k;
                                                if (str10 != null ? str10.equals(aVar.h()) : aVar.h() == null) {
                                                    String str11 = this.l;
                                                    if (str11 == null) {
                                                        if (aVar.a() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(aVar.a())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public String f() {
        return this.i;
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public String g() {
        return this.g;
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public String h() {
        return this.k;
    }

    public int hashCode() {
        Integer num = this.a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f747b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.l;
        return iHashCode11 ^ (str11 != null ? str11.hashCode() : 0);
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public String i() {
        return this.f747b;
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public String j() {
        return this.f;
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public String k() {
        return this.e;
    }

    @Override // b.i.a.b.i.e.a
    @Nullable
    public Integer l() {
        return this.a;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("AndroidClientInfo{sdkVersion=");
        sbU.append(this.a);
        sbU.append(", model=");
        sbU.append(this.f747b);
        sbU.append(", hardware=");
        sbU.append(this.c);
        sbU.append(", device=");
        sbU.append(this.d);
        sbU.append(", product=");
        sbU.append(this.e);
        sbU.append(", osBuild=");
        sbU.append(this.f);
        sbU.append(", manufacturer=");
        sbU.append(this.g);
        sbU.append(", fingerprint=");
        sbU.append(this.h);
        sbU.append(", locale=");
        sbU.append(this.i);
        sbU.append(", country=");
        sbU.append(this.j);
        sbU.append(", mccMnc=");
        sbU.append(this.k);
        sbU.append(", applicationBuild=");
        return b.d.b.a.a.J(sbU, this.l, "}");
    }
}
