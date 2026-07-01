package com.discord.gateway;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import androidx.preference.PreferenceManager;
import d0.z.d.m;

/* JADX INFO: compiled from: GatewayDiscovery.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewayDiscovery$Cache {
    private static final String GATEWAY_URL_CACHE_KEY = "GATEWAY_URL_CACHE_KEY";
    public static final GatewayDiscovery$Cache INSTANCE = new GatewayDiscovery$Cache();
    private static SharedPreferences sharedPreferences;

    private GatewayDiscovery$Cache() {
    }

    public final String getGatewayUrl() {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 == null) {
            m.throwUninitializedPropertyAccessException("sharedPreferences");
        }
        return sharedPreferences2.getString(GATEWAY_URL_CACHE_KEY, null);
    }

    public final void init(Context context) {
        m.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        m.checkNotNullExpressionValue(defaultSharedPreferences, "PreferenceManager.getDef…haredPreferences(context)");
        sharedPreferences = defaultSharedPreferences;
    }

    public final void setGatewayUrl(String gatewayUrl) {
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (sharedPreferences2 == null) {
            m.throwUninitializedPropertyAccessException("sharedPreferences");
        }
        SharedPreferences$Editor sharedPreferences$EditorEdit = sharedPreferences2.edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putString(GATEWAY_URL_CACHE_KEY, gatewayUrl);
        sharedPreferences$EditorEdit.apply();
    }
}
