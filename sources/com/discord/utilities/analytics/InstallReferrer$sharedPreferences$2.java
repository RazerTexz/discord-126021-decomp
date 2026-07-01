package com.discord.utilities.analytics;

import android.content.SharedPreferences;
import com.discord.utilities.cache.SharedPreferencesProvider;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: InstallReferrer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InstallReferrer$sharedPreferences$2 extends o implements Function0<SharedPreferences> {
    public static final InstallReferrer$sharedPreferences$2 INSTANCE = new InstallReferrer$sharedPreferences$2();

    public InstallReferrer$sharedPreferences$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SharedPreferences invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SharedPreferences invoke() {
        return SharedPreferencesProvider.INSTANCE.get();
    }
}
