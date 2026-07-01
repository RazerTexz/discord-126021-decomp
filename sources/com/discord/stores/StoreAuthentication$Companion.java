package com.discord.stores;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Patterns;
import androidx.core.content.ContextCompat;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$Companion {
    private StoreAuthentication$Companion() {
    }

    public static final /* synthetic */ String access$getDeviceEmail(StoreAuthentication$Companion storeAuthentication$Companion, Context context) {
        return storeAuthentication$Companion.getDeviceEmail(context);
    }

    public static final /* synthetic */ String access$getRnaAuthToken(StoreAuthentication$Companion storeAuthentication$Companion, Context context) {
        return storeAuthentication$Companion.getRnaAuthToken(context);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0037  */
    /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
    @SuppressLint({"MissingPermission"})
    private final String getDeviceEmail(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.GET_ACCOUNTS") != 0) {
            return null;
        }
        AccountManager accountManager = AccountManager.get(context);
        m.checkNotNullExpressionValue(accountManager, "AccountManager.get(context)");
        Account[] accounts = accountManager.getAccounts();
        m.checkNotNullExpressionValue(accounts, "AccountManager.get(context).accounts");
        for (Account account : accounts) {
            if (Patterns.EMAIL_ADDRESS.matcher(account.type).matches()) {
                if (account != null) {
                    return account.name;
                }
                return null;
            }
        }
        account = null;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    private final String getRnaAuthToken(Context context) {
        String string = context.getSharedPreferences("CacheStore", 0).getString("token", null);
        if (string != null) {
            return t.replace$default(string, "\"", "", false, 4, (Object) null);
        }
        return null;
    }

    public /* synthetic */ StoreAuthentication$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
