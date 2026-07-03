package p007b.p225i.p226a.p288f.p313h.p323j;

import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;
import p007b.p225i.p226a.p288f.p313h.p323j.C3521i0;

/* JADX INFO: renamed from: b.i.a.f.h.j.y */
/* JADX INFO: loaded from: classes3.dex */
public class C3552y<T extends C3521i0> extends C3506d {

    /* JADX INFO: renamed from: k */
    public C3519h0<T> f9823k;

    public C3552y(C3515g c3515g, C3519h0<T> c3519h0) {
        super(c3515g);
        this.f9823k = c3519h0;
    }

    /* JADX INFO: renamed from: I */
    public final T m4505I(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue(null, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        String strTrim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(strTrim)) {
                            Objects.requireNonNull(this.f9823k);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        String strTrim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && strTrim2 != null) {
                            this.f9823k.m4456c(attributeValue2, strTrim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        String strTrim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(strTrim3)) {
                            try {
                                this.f9823k.m4454a(attributeValue3, Boolean.parseBoolean(strTrim3));
                            } catch (NumberFormatException e) {
                                m4433f("Error parsing bool configuration value", strTrim3, e);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        String strTrim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(strTrim4)) {
                            try {
                                this.f9823k.m4455b(attributeValue4, Integer.parseInt(strTrim4));
                            } catch (NumberFormatException e2) {
                                m4433f("Error parsing int configuration value", strTrim4, e2);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException | XmlPullParserException e3) {
            m4426A("Error parsing tracker configuration file", e3);
        }
        return (T) this.f9823k.f9734b;
    }
}
