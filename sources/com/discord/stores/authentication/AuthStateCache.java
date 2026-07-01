package com.discord.stores.authentication;

import android.content.SharedPreferences;
import android.content.SharedPreferences$Editor;
import b.i.a.f.e.o.f;
import com.discord.models.authentication.AuthState;
import com.google.gson.Gson;
import d0.t.n0;
import d0.z.d.m;

/* JADX INFO: compiled from: AuthStateCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuthStateCache {
    private final Gson gson;
    private final SharedPreferences prefs;

    public AuthStateCache(SharedPreferences sharedPreferences) {
        m.checkNotNullParameter(sharedPreferences, "prefs");
        this.prefs = sharedPreferences;
        this.gson = new Gson();
    }

    public final void cacheAuthState(AuthState authState) {
        if (authState == null) {
            SharedPreferences$Editor sharedPreferences$EditorEdit = this.prefs.edit();
            m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
            sharedPreferences$EditorEdit.remove(AuthStateCache$Keys.AUTH_STATE);
            sharedPreferences$EditorEdit.remove(AuthStateCache$Keys.TOKEN);
            sharedPreferences$EditorEdit.apply();
            return;
        }
        String strM = this.gson.m(authState);
        SharedPreferences$Editor sharedPreferences$EditorEdit2 = this.prefs.edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit2, "editor");
        sharedPreferences$EditorEdit2.putString(AuthStateCache$Keys.AUTH_STATE, strM);
        sharedPreferences$EditorEdit2.putString(AuthStateCache$Keys.TOKEN, authState.getToken());
        sharedPreferences$EditorEdit2.apply();
    }

    public final AuthState getCachedAuthState() {
        String string = this.prefs.getString(AuthStateCache$Keys.AUTH_STATE, null);
        if (string != null) {
            try {
                return (AuthState) f.E1(AuthState.class).cast(this.gson.g(string, AuthState.class));
            } catch (Exception unused) {
            }
        }
        String string2 = this.prefs.getString(AuthStateCache$Keys.TOKEN, null);
        if (string2 != null) {
            return AuthState.Companion.from(string2, n0.emptySet());
        }
        return null;
    }
}
