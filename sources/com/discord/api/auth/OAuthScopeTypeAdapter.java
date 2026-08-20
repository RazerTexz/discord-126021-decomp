package com.discord.api.auth;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: OAuthScopeTypeAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OAuthScopeTypeAdapter extends TypeAdapter<OAuthScope> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, OAuthScope> nameToScopeMap;

    /* JADX INFO: compiled from: OAuthScopeTypeAdapter.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        HashMap<String, OAuthScope> map = new HashMap<>();
        for (InterfaceC11230c interfaceC11230c : C12216a0.getOrCreateKotlinClass(OAuthScope.class).getSealedSubclasses()) {
            if (interfaceC11230c.getObjectInstance() != null) {
                Object objectInstance = interfaceC11230c.getObjectInstance();
                Objects.requireNonNull(objectInstance, "null cannot be cast to non-null type com.discord.api.auth.OAuthScope");
                OAuthScope oAuthScope = (OAuthScope) objectInstance;
                map.put(oAuthScope.getScopeName(), oAuthScope);
            }
        }
        nameToScopeMap = map;
    }

    @Override // com.google.gson.TypeAdapter
    public OAuthScope read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.mo6878N() == JsonToken.NULL) {
            jsonReader.mo6876H();
            return null;
        }
        String strMo6877J = jsonReader.mo6877J();
        OAuthScope invalid = nameToScopeMap.get(strMo6877J);
        if (invalid == null) {
            C12238m.checkNotNullExpressionValue(strMo6877J, "scopeName");
            invalid = new OAuthScope.Invalid(strMo6877J);
        }
        return invalid;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, OAuthScope oAuthScope) throws IOException {
        OAuthScope oAuthScope2 = oAuthScope;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (oAuthScope2 != null) {
            jsonWriter.mo6895H(oAuthScope2.getScopeName());
        } else {
            jsonWriter.mo6905s();
        }
    }
}
