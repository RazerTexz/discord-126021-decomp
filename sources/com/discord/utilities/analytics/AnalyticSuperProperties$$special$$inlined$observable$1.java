package com.discord.utilities.analytics;

import android.util.Base64;
import com.google.gson.Gson;
import d0.b0.a;
import d0.g0.c;
import d0.z.d.m;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Objects;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: Delegates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnalyticSuperProperties$$special$$inlined$observable$1 extends a<Map<String, ? extends Object>> {
    public final /* synthetic */ Object $initialValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalyticSuperProperties$$special$$inlined$observable$1(Object obj, Object obj2) {
        super(obj2);
        this.$initialValue = obj;
    }

    @Override // d0.b0.a
    public void afterChange(KProperty<?> property, Map<String, ? extends Object> oldValue, Map<String, ? extends Object> newValue) {
        m.checkNotNullParameter(property, "property");
        AnalyticSuperProperties analyticSuperProperties = AnalyticSuperProperties.INSTANCE;
        String strM = new Gson().m(newValue);
        if (strM == null) {
            strM = "{}";
        }
        AnalyticSuperProperties.access$setSuperPropertiesString$p(analyticSuperProperties, strM);
        String superPropertiesString = analyticSuperProperties.getSuperPropertiesString();
        Charset charset = c.a;
        Objects.requireNonNull(superPropertiesString, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = superPropertiesString.getBytes(charset);
        m.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        String strEncodeToString = Base64.encodeToString(bytes, 2);
        m.checkNotNullExpressionValue(strEncodeToString, "Base64.encodeToString(su…eArray(), Base64.NO_WRAP)");
        AnalyticSuperProperties.access$setSuperPropertiesStringBase64$p(analyticSuperProperties, strEncodeToString);
    }
}
