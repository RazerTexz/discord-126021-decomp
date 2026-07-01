package com.discord.screenshot_detection;

import android.net.Uri;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ScreenshotDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenshotDetector$a extends o implements Function2<Uri, String, Unit> {
    public final /* synthetic */ ScreenshotDetector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotDetector$a(ScreenshotDetector screenshotDetector) {
        super(2);
        this.this$0 = screenshotDetector;
    }

    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Uri uri, String str) {
        Uri uri2 = uri;
        String str2 = str;
        m.checkNotNullParameter(uri2, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(str2, "filename");
        ScreenshotDetector screenshotDetector = this.this$0;
        if (screenshotDetector.enabled) {
            PublishSubject<ScreenshotDetector$Screenshot> publishSubject = screenshotDetector.publishSubject;
            publishSubject.k.onNext(new ScreenshotDetector$Screenshot(uri2, str2));
        }
        return Unit.a;
    }
}
