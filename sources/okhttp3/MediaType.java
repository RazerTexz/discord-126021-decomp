package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.d0.f;
import d0.g0.t;
import d0.t.k;
import d0.z.d.m;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;

/* JADX INFO: compiled from: MediaType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaType {
    public static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f3808b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    public static final MediaType$a c = null;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String mediaType;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final String type;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final String subtype;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final String[] parameterNamesAndValues;

    public MediaType(String str, String str2, String str3, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    public static final MediaType b(String str) {
        return MediaType$a.a(str);
    }

    public final Charset a(Charset defaultValue) {
        String str;
        m.checkParameterIsNotNull("charset", ModelAuditLogEntry.CHANGE_KEY_NAME);
        IntProgression intProgressionStep = f.step(k.getIndices(this.parameterNamesAndValues), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if (step < 0 ? first >= last : first <= last) {
            while (true) {
                if (!t.equals(this.parameterNamesAndValues[first], "charset", true)) {
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
        return (other instanceof MediaType) && m.areEqual(((MediaType) other).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getMediaType() {
        return this.mediaType;
    }
}
