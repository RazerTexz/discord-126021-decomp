package com.discord.stores.authentication;

import android.content.SharedPreferences;
import b.i.a.f.e.o.f;
import com.discord.models.authentication.AuthState;
import com.google.gson.Gson;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: AuthStateCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuthStateCache {
    private final Gson gson;
    private final SharedPreferences prefs;

    /* JADX INFO: compiled from: AuthStateCache.kt */
    public static final class Keys {
        public static final String AUTH_STATE = "STORE_AUTH_STATE";
        public static final Keys INSTANCE = new Keys();
        public static final String TOKEN = "STORE_AUTHED_TOKEN";

        private Keys() {
        }
    }

    public AuthStateCache(SharedPreferences sharedPreferences) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "prefs");
        this.prefs = sharedPreferences;
        this.gson = new Gson();
    }

    public final void cacheAuthState(AuthState authState) {
        if (authState == null) {
            SharedPreferences.Editor editorEdit = this.prefs.edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.remove(Keys.AUTH_STATE);
            editorEdit.remove(Keys.TOKEN);
            editorEdit.apply();
            return;
        }
        String strM = this.gson.m(authState);
        SharedPreferences.Editor editorEdit2 = this.prefs.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit2, "editor");
        editorEdit2.putString(Keys.AUTH_STATE, strM);
        editorEdit2.putString(Keys.TOKEN, authState.getToken());
        editorEdit2.apply();
    }

    public final AuthState getCachedAuthState() {
        String string = this.prefs.getString(Keys.AUTH_STATE, null);
        if (string != null) {
            try {
                return (AuthState) f.E1(AuthState.class).cast(this.gson.g(string, AuthState.class));
            } catch (Exception unused) {
            }
        }
        String string2 = this.prefs.getString(Keys.TOKEN, null);
        if (string2 != null) {
            return AuthState.INSTANCE.from(string2, Sets5.emptySet());
        }
        return null;
    }
}
