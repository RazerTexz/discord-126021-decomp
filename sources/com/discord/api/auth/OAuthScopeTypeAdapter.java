package com.discord.api.auth;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import d0.e0.c;
import d0.z.d.a0;
import d0.z.d.m;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: OAuthScopeTypeAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OAuthScopeTypeAdapter extends TypeAdapter<OAuthScope> {
    public static final OAuthScopeTypeAdapter$Companion Companion = new OAuthScopeTypeAdapter$Companion(null);
    private static final HashMap<String, OAuthScope> nameToScopeMap;

    static {
        HashMap<String, OAuthScope> map = new HashMap<>();
        for (c cVar : a0.getOrCreateKotlinClass(OAuthScope.class).getSealedSubclasses()) {
            if (cVar.getObjectInstance() != null) {
                Object objectInstance = cVar.getObjectInstance();
                Objects.requireNonNull(objectInstance, "null cannot be cast to non-null type com.discord.api.auth.OAuthScope");
                OAuthScope oAuthScope = (OAuthScope) objectInstance;
                map.put(oAuthScope.getScopeName(), oAuthScope);
            }
        }
        nameToScopeMap = map;
    }

    public static final /* synthetic */ HashMap a() {
        return nameToScopeMap;
    }

    @Override // com.google.gson.TypeAdapter
    public OAuthScope read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        String strJ = jsonReader.J();
        OAuthScope oAuthScope$Invalid = nameToScopeMap.get(strJ);
        if (oAuthScope$Invalid == null) {
            m.checkNotNullExpressionValue(strJ, "scopeName");
            oAuthScope$Invalid = new OAuthScope$Invalid(strJ);
        }
        return oAuthScope$Invalid;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, OAuthScope oAuthScope) throws IOException {
        OAuthScope oAuthScope2 = oAuthScope;
        m.checkNotNullParameter(jsonWriter, "out");
        if (oAuthScope2 != null) {
            jsonWriter.H(oAuthScope2.getScopeName());
        } else {
            jsonWriter.s();
        }
    }
}
