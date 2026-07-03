package p007b.p225i.p226a.p228b.p229i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p228b.C2407b;
import p007b.p225i.p226a.p228b.p231j.InterfaceC2437d;

/* JADX INFO: renamed from: b.i.a.b.i.a */
/* JADX INFO: compiled from: CCTDestination.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2414a implements InterfaceC2437d {

    /* JADX INFO: renamed from: a */
    public static final String f5123a = C1460d.m537k1("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");

    /* JADX INFO: renamed from: b */
    public static final String f5124b;

    /* JADX INFO: renamed from: c */
    public static final String f5125c;

    /* JADX INFO: renamed from: d */
    public static final Set<C2407b> f5126d;

    /* JADX INFO: renamed from: e */
    public static final C2414a f5127e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final String f5128f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public final String f5129g;

    static {
        String strM537k1 = C1460d.m537k1("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f5124b = strM537k1;
        String strM537k2 = C1460d.m537k1("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f5125c = strM537k2;
        f5126d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new C2407b("proto"), new C2407b("json"))));
        f5127e = new C2414a(strM537k1, strM537k2);
    }

    public C2414a(@NonNull String str, @Nullable String str2) {
        this.f5128f = str;
        this.f5129g = str2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static C2414a m2293a(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName(Constants.ENCODING));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new C2414a(str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public byte[] m2294b() {
        String str = this.f5129g;
        if (str == null && this.f5128f == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f5128f;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName(Constants.ENCODING));
    }
}
