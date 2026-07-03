package com.discord.utilities.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: InstallReferrer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InstallReferrer {
    private static final String CACHE_KEY_HAS_EXECUTED = "CACHE_KEY_HAS_EXECUTED";
    private static final String CACHE_KEY_HAS_EXECUTED_ATTEMPTS = "CACHE_KEY_HAS_EXECUTED_ATTEMPTS";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = C12083g.lazy(InstallReferrer$Companion$INSTANCE$2.INSTANCE);
    private static final int MAX_ATTEMPTS = 10;
    private final Context context;
    private final Logger logger;
    private InstallReferrerClient referrerClient;

    /* JADX INFO: renamed from: sharedPreferences$delegate, reason: from kotlin metadata */
    private final Lazy sharedPreferences;

    /* JADX INFO: compiled from: InstallReferrer.kt */
    public static final class Companion {
        private Companion() {
        }

        private final InstallReferrer getINSTANCE() {
            Lazy lazy = InstallReferrer.INSTANCE$delegate;
            Companion companion = InstallReferrer.INSTANCE;
            return (InstallReferrer) lazy.getValue();
        }

        public final void init(Function1<? super String, Unit> onReceivedInstallReferrer) {
            C12238m.checkNotNullParameter(onReceivedInstallReferrer, "onReceivedInstallReferrer");
            getINSTANCE().init(onReceivedInstallReferrer);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private InstallReferrer(Logger logger, Context context) {
        this.logger = logger;
        this.context = context;
        this.sharedPreferences = C12083g.lazy(InstallReferrer$sharedPreferences$2.INSTANCE);
    }

    public static final /* synthetic */ InstallReferrerClient access$getReferrerClient$p(InstallReferrer installReferrer) {
        InstallReferrerClient installReferrerClient = installReferrer.referrerClient;
        if (installReferrerClient == null) {
            C12238m.throwUninitializedPropertyAccessException("referrerClient");
        }
        return installReferrerClient;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.discord.utilities.analytics.InstallReferrer$createReferrerStateListener$1] */
    private final C66841 createReferrerStateListener(final Function1<? super String, Unit> onReceivedInstallReferrer) {
        return new InstallReferrerStateListener() { // from class: com.discord.utilities.analytics.InstallReferrer.createReferrerStateListener.1
            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerServiceDisconnected() {
                Logger.d$default(InstallReferrer.this.logger, "Install referrer service disconnected.", null, 2, null);
            }

            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerSetupFinished(int responseCode) {
                if (responseCode != 0) {
                    InstallReferrer.this.setFetchInstallReferrerFailed(null);
                } else {
                    try {
                        Function1 function1 = onReceivedInstallReferrer;
                        ReferrerDetails installReferrer = InstallReferrer.access$getReferrerClient$p(InstallReferrer.this).getInstallReferrer();
                        C12238m.checkNotNullExpressionValue(installReferrer, "referrerClient.installReferrer");
                        String installReferrer2 = installReferrer.getInstallReferrer();
                        C12238m.checkNotNullExpressionValue(installReferrer2, "referrerClient.installReferrer.installReferrer");
                        function1.invoke(installReferrer2);
                        InstallReferrer.this.setFetchInstallReferrerSuccessful();
                    } catch (Exception e) {
                        InstallReferrer.this.setFetchInstallReferrerFailed(e);
                    }
                }
                try {
                    InstallReferrer.access$getReferrerClient$p(InstallReferrer.this).endConnection();
                } catch (Exception e2) {
                    InstallReferrer.this.logger.mo8367i("Unable to end connection, likely already dead.", e2);
                }
            }
        };
    }

    private final SharedPreferences getSharedPreferences() {
        return (SharedPreferences) this.sharedPreferences.getValue();
    }

    private final void setFetchInstallReferrerFailed(Exception e) {
        int i = SharedPreferencesProvider.INSTANCE.get().getInt(CACHE_KEY_HAS_EXECUTED_ATTEMPTS, 0);
        this.logger.mo8367i("Unable to resolve referrer details, " + i + " attempt.", e);
        SharedPreferences.Editor editorEdit = getSharedPreferences().edit();
        C12238m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putInt(CACHE_KEY_HAS_EXECUTED_ATTEMPTS, i + 1);
        editorEdit.apply();
    }

    private final void setFetchInstallReferrerSuccessful() throws RemoteException {
        InstallReferrerClient installReferrerClient = this.referrerClient;
        if (installReferrerClient == null) {
            C12238m.throwUninitializedPropertyAccessException("referrerClient");
        }
        ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
        C12238m.checkNotNullExpressionValue(installReferrer, "referrerClient.installReferrer");
        Logger.i$default(this.logger, C1643a.m883w("Retrieved install referrer, ", installReferrer.getInstallReferrer()), null, 2, null);
        SharedPreferences.Editor editorEdit = getSharedPreferences().edit();
        C12238m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putBoolean(CACHE_KEY_HAS_EXECUTED, true);
        editorEdit.apply();
    }

    private final boolean shouldFetchInstallReferrer() {
        return !getSharedPreferences().getBoolean(CACHE_KEY_HAS_EXECUTED, false) && getSharedPreferences().getInt(CACHE_KEY_HAS_EXECUTED_ATTEMPTS, 0) < 10;
    }

    public final void init(Function1<? super String, Unit> onReceivedInstallReferrer) {
        C12238m.checkNotNullParameter(onReceivedInstallReferrer, "onReceivedInstallReferrer");
        if (shouldFetchInstallReferrer()) {
            try {
                InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(this.context).build();
                C12238m.checkNotNullExpressionValue(installReferrerClientBuild, "InstallReferrerClient.newBuilder(context).build()");
                this.referrerClient = installReferrerClientBuild;
                if (installReferrerClientBuild == null) {
                    try {
                        C12238m.throwUninitializedPropertyAccessException("referrerClient");
                    } catch (Exception e) {
                        this.logger.mo8367i("Unable to start connection to referrer client.", e);
                        return;
                    }
                }
                installReferrerClientBuild.startConnection(createReferrerStateListener(onReceivedInstallReferrer));
            } catch (Exception e2) {
                this.logger.mo8367i("Unable to initialize referrer client.", e2);
            }
        }
    }

    public /* synthetic */ InstallReferrer(Logger logger, Context context, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? LoggingProvider.INSTANCE.get() : logger, (i & 2) != 0 ? ApplicationProvider.INSTANCE.get() : context);
    }
}
