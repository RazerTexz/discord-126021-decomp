package b.i.a.b.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.b.Encoding2;
import b.i.a.b.j.EncodedDestination;
import com.adjust.sdk.Constants;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.b.i.a, reason: use source file name */
/* JADX INFO: compiled from: CCTDestination.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CCTDestination implements EncodedDestination {
    public static final String a = AnimatableValueParser.k1("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f743b;
    public static final String c;
    public static final Set<Encoding2> d;
    public static final CCTDestination e;

    @NonNull
    public final String f;

    @Nullable
    public final String g;

    static {
        String strK1 = AnimatableValueParser.k1("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f743b = strK1;
        String strK2 = AnimatableValueParser.k1("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        c = strK2;
        d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Encoding2("proto"), new Encoding2("json"))));
        e = new CCTDestination(strK1, strK2);
    }

    public CCTDestination(@NonNull String str, @Nullable String str2) {
        this.f = str;
        this.g = str2;
    }

    @NonNull
    public static CCTDestination a(@NonNull byte[] bArr) {
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
        return new CCTDestination(str2, str3);
    }

    @Nullable
    public byte[] b() {
        String str = this.g;
        if (str == null && this.f == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName(Constants.ENCODING));
    }
}
