package com.adjust.sdk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class InstallReferrerHuawei {
    private static final String REFERRER_PROVIDER_AUTHORITY = "com.huawei.appmarket.commondata";
    private static final String REFERRER_PROVIDER_URI = "content://com.huawei.appmarket.commondata/item/5";
    private Context context;
    private final InstallReferrerReadListener referrerCallback;
    private ILogger logger = AdjustFactory.getLogger();
    private final AtomicBoolean shouldTryToRead = new AtomicBoolean(true);

    public InstallReferrerHuawei(Context context, InstallReferrerReadListener installReferrerReadListener) {
        this.context = context;
        this.referrerCallback = installReferrerReadListener;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00a1 A[PHI: r3
      0x00a1: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v3 android.database.Cursor) binds: [B:22:0x009f, B:16:0x008a] A[DONT_GENERATE, DONT_INLINE]] */
    public void readReferrer() {
        if (!this.shouldTryToRead.get()) {
            this.logger.debug("Should not try to read Install referrer Huawei", new Object[0]);
            return;
        }
        if (Util.resolveContentProvider(this.context, REFERRER_PROVIDER_AUTHORITY)) {
            Cursor cursorQuery = null;
            Uri uri = Uri.parse(REFERRER_PROVIDER_URI);
            try {
                try {
                    cursorQuery = this.context.getContentResolver().query(uri, null, null, new String[]{this.context.getPackageName()}, null);
                    if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                        this.logger.debug("InstallReferrerHuawei fail to read referrer for package [%s] and content uri [%s]", this.context.getPackageName(), uri.toString());
                    } else {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        String string3 = cursorQuery.getString(2);
                        this.logger.debug("InstallReferrerHuawei reads referrer[%s] clickTime[%s] installTime[%s]", string, string2, string3);
                        this.referrerCallback.onInstallReferrerRead(string, Long.parseLong(string2), Long.parseLong(string3));
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Exception e) {
                    this.logger.debug("InstallReferrerHuawei error [%s]", e.getMessage());
                    if (0 != 0) {
                        cursorQuery.close();
                    }
                }
                this.shouldTryToRead.set(false);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursorQuery.close();
                }
                throw th;
            }
        }
    }
}
