package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class IntentSenderRequest$Builder {
    private Intent mFillInIntent;
    private int mFlagsMask;
    private int mFlagsValues;
    private IntentSender mIntentSender;

    public IntentSenderRequest$Builder(@NonNull IntentSender intentSender) {
        this.mIntentSender = intentSender;
    }

    @NonNull
    public IntentSenderRequest build() {
        return new IntentSenderRequest(this.mIntentSender, this.mFillInIntent, this.mFlagsMask, this.mFlagsValues);
    }

    @NonNull
    public IntentSenderRequest$Builder setFillInIntent(@Nullable Intent intent) {
        this.mFillInIntent = intent;
        return this;
    }

    @NonNull
    public IntentSenderRequest$Builder setFlags(int i, int i2) {
        this.mFlagsValues = i;
        this.mFlagsMask = i2;
        return this;
    }

    public IntentSenderRequest$Builder(@NonNull PendingIntent pendingIntent) {
        this(pendingIntent.getIntentSender());
    }
}
