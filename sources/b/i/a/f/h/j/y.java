package b.i.a.f.h.j;

import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import b.i.a.f.h.j.i0;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class y<T extends i0> extends d {
    public h0<T> k;

    public y(g gVar, h0<T> h0Var) {
        super(gVar);
        this.k = h0Var;
    }

    public final T I(XmlResourceParser xmlResourceParser) {
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
                            Objects.requireNonNull(this.k);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        String strTrim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && strTrim2 != null) {
                            this.k.c(attributeValue2, strTrim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        String strTrim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(strTrim3)) {
                            try {
                                this.k.a(attributeValue3, Boolean.parseBoolean(strTrim3));
                            } catch (NumberFormatException e) {
                                f("Error parsing bool configuration value", strTrim3, e);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        String strTrim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(strTrim4)) {
                            try {
                                this.k.b(attributeValue4, Integer.parseInt(strTrim4));
                            } catch (NumberFormatException e2) {
                                f("Error parsing int configuration value", strTrim4, e2);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException | XmlPullParserException e3) {
            A("Error parsing tracker configuration file", e3);
        }
        return (T) this.k.f1418b;
    }
}
