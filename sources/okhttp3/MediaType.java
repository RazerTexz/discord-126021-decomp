package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MediaType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaType {

    /* JADX INFO: renamed from: a */
    public static final Pattern f27514a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: b */
    public static final Pattern f27515b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = null;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String mediaType;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final String type;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final String subtype;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final String[] parameterNamesAndValues;

    /* JADX INFO: renamed from: okhttp3.MediaType$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MediaType.kt */
    public static final class Companion {
        /* JADX INFO: renamed from: a */
        public static final MediaType m10967a(String str) {
            C12238m.checkParameterIsNotNull(str, "$this$toMediaType");
            Matcher matcher = MediaType.f27514a.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
            }
            String strGroup = matcher.group(1);
            C12238m.checkExpressionValueIsNotNull(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            C12238m.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strGroup == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strGroup.toLowerCase(locale);
            C12238m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            C12238m.checkExpressionValueIsNotNull(strGroup2, "typeSubtype.group(2)");
            C12238m.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strGroup2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = strGroup2.toLowerCase(locale);
            C12238m.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = MediaType.f27515b.matcher(str);
            int iEnd = matcher.end();
            while (iEnd < str.length()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sbM833U = C1643a.m833U("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(iEnd);
                    C12238m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    sbM833U.append(strSubstring);
                    sbM833U.append("\" for: \"");
                    sbM833U.append(str);
                    sbM833U.append('\"');
                    throw new IllegalArgumentException(sbM833U.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (C12103t.startsWith$default(strGroup4, "'", false, 2, null) && C12103t.endsWith$default(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        C12238m.checkExpressionValueIsNotNull(strGroup4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return new MediaType(str, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* JADX INFO: renamed from: b */
        public static final MediaType m10968b(String str) {
            C12238m.checkParameterIsNotNull(str, "$this$toMediaTypeOrNull");
            try {
                return m10967a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public MediaType(String str, String str2, String str3, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    /* JADX INFO: renamed from: b */
    public static final MediaType m10965b(String str) {
        return Companion.m10967a(str);
    }

    /* JADX INFO: renamed from: a */
    public final Charset m10966a(Charset defaultValue) {
        String str;
        C12238m.checkParameterIsNotNull("charset", ModelAuditLogEntry.CHANGE_KEY_NAME);
        IntProgression intProgressionStep = C11226f.step(C12141k.getIndices(this.parameterNamesAndValues), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if (step < 0 ? first >= last : first <= last) {
            while (true) {
                if (!C12103t.equals(this.parameterNamesAndValues[first], "charset", true)) {
                    if (first == last) {
                        str = null;
                        break;
                    }
                    first += step;
                } else {
                    str = this.parameterNamesAndValues[first + 1];
                    break;
                }
            }
        } else {
            str = null;
            break;
        }
        if (str == null) {
            return defaultValue;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return defaultValue;
        }
    }

    public boolean equals(Object other) {
        return (other instanceof MediaType) && C12238m.areEqual(((MediaType) other).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getMediaType() {
        return this.mediaType;
    }
}
